package com.yunlian.changgou.service.goods.controller;

import com.yunlian.changgou.common.Result;
import com.yunlian.changgou.core.AbstractCoreController;
import com.yunlian.changgou.core.CoreService;
import com.yunlian.changgou.goods.model.Spu;
import com.yunlian.changgou.service.goods.service.SpuService;
import com.yunlian.changgou.service.goods.service.impl.SpuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spu")
public class SpuController extends AbstractCoreController<Spu> {

    @Autowired
    private SpuServiceImpl spuService;

    @Autowired
    public SpuController(SpuServiceImpl spuService) {
        super(spuService);
    }

    @PutMapping("/audit/{id}")
    public Result audit(@PathVariable String id){
        return spuService.audit(id);
    }

    @PutMapping("/pull/{id}")
    public Result pull(@PathVariable String id){
        return spuService.pull(id);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable String id){
        return spuService.delete(id);
    }

}
