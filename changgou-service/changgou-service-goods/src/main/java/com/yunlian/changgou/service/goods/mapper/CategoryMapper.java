package com.yunlian.changgou.service.goods.mapper;

import com.yunlian.changgou.goods.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Component
public interface CategoryMapper extends Mapper<Category> {
}
