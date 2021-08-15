package com.yunlian.changgou.service.goods.mapper;

import com.yunlian.changgou.goods.model.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface BrandMapper extends Mapper<Brand> {

    @Select("select b.name,b.image from tb_brand as b where b.id in (select cb.brand_id  from tb_category_brand cb where cb.category_id in (select ct.id from tb_category as ct where name=#{categoryName}))")
    public List findListByCategoryName(@Param("categoryName")String categoryName);

    @Select("select sp.name,sp.options from tb_spec sp where sp.template_id =(select ct.template_id from tb_category as ct where name=#{categoryName})")
    public List findSpecListByCategory(@Param("categoryName")String categoryName);
}
