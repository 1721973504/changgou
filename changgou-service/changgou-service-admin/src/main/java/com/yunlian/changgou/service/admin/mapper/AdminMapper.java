package com.yunlian.changgou.service.admin.mapper;

import com.yunlian.changgou.goods.model.Admin;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
@Component
public interface AdminMapper extends Mapper<Admin> {
}
