package com.yunlian.changgou.service.goods.service;

import com.github.pagehelper.PageInfo;
import com.yunlian.changgou.goods.model.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandService {

    List<Brand> findAll();

    Brand findOneById(int id);

    void add(Brand brand);

    void update(Brand brand);

    void delete(int id);

    List<Brand> findList(Brand brand);

    PageInfo<Brand> findPage(int page,int size);

    public List findListByCategoryName(@Param("categoryName")String categoryName);

    public List findSpecListByCategory(@Param("categoryName")String categoryName);
}
