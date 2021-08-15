package com.yunlian.changgou.service.goods.controller;

import com.yunlian.changgou.core.AbstractCoreController;
import com.yunlian.changgou.core.CoreService;
import com.yunlian.changgou.goods.model.Album;
import com.yunlian.changgou.service.goods.service.impl.AlbumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/album")
public class AlbumController extends AbstractCoreController<Album> {

    private AlbumServiceImpl albumService;

    @Autowired
    public AlbumController(AlbumServiceImpl service) {
        super(service);
        this.coreService =service;
    }

}
