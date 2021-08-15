package com.yunlian.changgou.service.goods.mapper;

import com.yunlian.changgou.goods.model.Spu;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Component
public interface SpuMapper extends Mapper<Spu> {
}
