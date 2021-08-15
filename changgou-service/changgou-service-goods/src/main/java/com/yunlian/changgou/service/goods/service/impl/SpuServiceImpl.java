package com.yunlian.changgou.service.goods.service.impl;

import com.yunlian.changgou.common.IdWorker;
import com.yunlian.changgou.common.Result;
import com.yunlian.changgou.common.StatusCode;
import com.yunlian.changgou.core.CoreService;
import com.yunlian.changgou.goods.model.*;
import com.yunlian.changgou.service.goods.mapper.BrandMapper;
import com.yunlian.changgou.service.goods.mapper.CategoryMapper;
import com.yunlian.changgou.service.goods.mapper.SpuMapper;
import com.yunlian.changgou.service.goods.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SpuServiceImpl extends CoreService<Spu> implements SpuService {

    private IdWorker idWorker = new IdWorker();

    @Autowired
    private SpuMapper spuMapper;

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    public SpuServiceImpl(SpuMapper spuMapper) {
        super(spuMapper, Spu.class);
    }

    @Transactional
    @Override
    public void add(Goods goods) {
        Spu spu = goods.getSpu();
        long id = idWorker.nextId();
        spu.setId(id);
        spu.setIsDelete("0");
        spu.setIsMarketable("0");
        spu.setStatus("0");
        spuMapper.insertSelective(spu);
    }

    @Transactional
    @Override
    public Result audit(String id) {
        Spu spu = spuMapper.selectByPrimaryKey(id);
        if(spu==null){
            return new Result(false,StatusCode.ERROR,"商品不存在");
        }else if(spu.getIsDelete().equals(1)){
            return new Result(false, StatusCode.ERROR,"货品以被删除");
        }else {
            spu = new Spu();
            spu.setStatus("1");
            spu.setIsMarketable("1");
            spu.setId(Long.parseLong(id));
            spuMapper.updateByPrimaryKeySelective(spu);
            return new Result(true,StatusCode.OK,"审核成功");
        }
    }

    @Override
    public Result pull(String id) {
        Spu spu = spuMapper.selectByPrimaryKey(id);
        if(spu==null){
            return new Result(false,StatusCode.ERROR,"商品不存在");
        }else if(spu.getIsDelete().equals(1)){
            return new Result(false, StatusCode.ERROR,"货品以被删除");
        }else {
            spu = new Spu();
            spu.setStatus("1");
            spu.setIsMarketable("0");
            spu.setId(Long.parseLong(id));
            spuMapper.updateByPrimaryKeySelective(spu);
            return new Result(true,StatusCode.OK,"下架成功");
        }
    }

    @Override
    public Result delete(String id) {
        Spu spu = spuMapper.selectByPrimaryKey(id);
        if(spu==null){
            return new Result(false,StatusCode.ERROR,"商品不存在");
        }else if(spu.getIsDelete().equals(1)){
            return new Result(false, StatusCode.ERROR,"货品以被删除");
        }else if(!spu.getIsMarketable().equals("0")){
            return new Result(false,StatusCode.ERROR,"商品需要先下架才可以删除");
        }else {
            spu = new Spu();
            spu.setIsDelete("1");
            spu.setStatus("0");
            spu.setId(Long.parseLong(id));
            spuMapper.updateByPrimaryKeySelective(spu);
            return new Result(true,StatusCode.OK,"删除成功");
        }
    }

    private void saveSkuList(Goods goods) {
    }
}