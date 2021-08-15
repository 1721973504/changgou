package com.yunlian.changgou.service.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunlian.changgou.goods.model.Brand;
import com.yunlian.changgou.service.goods.mapper.BrandMapper;
import com.yunlian.changgou.service.goods.service.BrandService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class BrandServiceImpl implements BrandService{

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public Brand findOneById(int id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Brand brand) {
        brandMapper.insert(brand);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void delete(int id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Brand> findList(Brand brand) {
        return brandMapper.selectByExample(createExample(brand));
    }

    @Override
    public PageInfo<Brand> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(brandMapper.selectAll());
    }

    @Override
    public List findListByCategoryName(String categoryName) {
        return brandMapper.findListByCategoryName(categoryName);
    }

    @Override
    public List findSpecListByCategory(String categoryName) {
        return brandMapper.findSpecListByCategory(categoryName);
    }

    public Example createExample(Brand brand){
        Example example=new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if(brand!=null){
            // 品牌名称
            if(!StringUtils.isEmpty(brand.getName())){
                criteria.andLike("name","%"+brand.getName()+"%");
            }
            // 品牌图片地址
            if(!StringUtils.isEmpty(brand.getImage())){
                criteria.andLike("image","%"+brand.getImage()+"%");
            }
            // 品牌的首字母
            if(!StringUtils.isEmpty(brand.getLetter())){
                criteria.andLike("letter","%"+brand.getLetter()+"%");
            }
            // 品牌id
            if(!StringUtils.isEmpty(brand.getLetter())){
                criteria.andEqualTo("id",brand.getId());
            }
            // 排序
            if(!StringUtils.isEmpty(brand.getSeq().toString())){
                criteria.andEqualTo("seq",brand.getSeq());
            }
        }
        return example;
    }
}
