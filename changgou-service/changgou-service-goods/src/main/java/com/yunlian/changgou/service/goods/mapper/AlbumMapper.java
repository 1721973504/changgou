package com.yunlian.changgou.service.goods.mapper;

import com.yunlian.changgou.goods.model.Album;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface AlbumMapper extends tk.mybatis.mapper.common.Mapper<Album> {
}
