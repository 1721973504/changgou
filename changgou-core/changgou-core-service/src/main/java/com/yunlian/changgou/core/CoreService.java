package com.yunlian.changgou.core;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.List;

public abstract class CoreService<T>{
    //通用mapepr
    protected Mapper<T> baseMapper;
    //操作的实体类
    protected Class<T> clazz;

    public CoreService(Mapper<T> baseMapper, Class<T> clazz) {
        this.baseMapper = baseMapper;
        this.clazz = clazz;
    }


    public int delete(T record) {
        return baseMapper.delete(record);
    }


    public int deleteById(Object id) {
        return baseMapper.deleteByPrimaryKey(id);
    }


    public int insert(T record) {
        return baseMapper.insertSelective(record);
    }


    public List<T> selectAll() {
        return baseMapper.selectAll();
    }


    public T selectByPrimaryKey(Object id) {
        return baseMapper.selectByPrimaryKey(id);
    }


    public List<T> select(T record) {
        return baseMapper.select(record);
    }


    public int updateByPrimaryKey(T record) {
        return baseMapper.updateByPrimaryKeySelective(record);
    }


    public PageInfo<T> findByPage(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<T> list = baseMapper.selectAll();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        return pageInfo;
    }


    public PageInfo<T> findByPage(Integer pageNo, Integer pageSize, T record) {
        Example example = new Example(clazz);
        Example.Criteria criteria = example.createCriteria();
        Field[] declaredFields = record.getClass().getDeclaredFields();

        for (Field declaredField : declaredFields) {
            try {
                //遇到 id注解 和 transient注解 不需要进行值的设置 直接跳过。
                if (declaredField.isAnnotationPresent(Transient.class) || declaredField.isAnnotationPresent(Id.class)) {
                    //遇到
                    continue;
                }
                //属性描述器  record.getClass()
                PropertyDescriptor propDesc = new PropertyDescriptor(declaredField.getName(), record.getClass());
                //获取这个值  先获取读方法的方法对象,并调用获取里面的值
                Object value = propDesc.getReadMethod().invoke(record);
                //Object value = propDesc.getValue(declaredField.getName());
                //如果是字符串
                if (value != null && value.getClass().getName().equals("java.lang.String")) {
                    Column columnAnnotation = declaredField.getAnnotation(Column.class);
                    //判断如果是长度为1 则 执行=号
                    int length = columnAnnotation.length();
                    if (length == 1) {
                        criteria.andEqualTo(declaredField.getName(), value);
                    } else {
                        criteria.andLike(declaredField.getName(), "%" + value + "%");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        PageHelper.startPage(pageNo, pageSize);
        List<T> ts = baseMapper.selectByExample(example);
        PageInfo<T> info = new PageInfo<T>(ts);
        return info;
    }


    public PageInfo<T> findByPageExample(Integer pageNo, Integer pageSize, Object example) {
        PageHelper.startPage(pageNo, pageSize);
        List<T> list = baseMapper.selectByExample(example);
        PageInfo<T> info = new PageInfo<T>(list);
        return info;
    }


}