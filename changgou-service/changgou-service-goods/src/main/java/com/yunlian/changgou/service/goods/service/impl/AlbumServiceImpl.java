package com.yunlian.changgou.service.goods.service.impl;

import com.yunlian.changgou.core.CoreService;
import com.yunlian.changgou.goods.model.Album;
import com.yunlian.changgou.service.goods.mapper.AlbumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public class AlbumServiceImpl extends CoreService<Album> {

    private AlbumMapper albumMapper;

    @Autowired
    public AlbumServiceImpl(AlbumMapper albumMapper) {
        super((Mapper<Album>) albumMapper, Album.class);
    }
}
