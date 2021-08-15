package com.yunlian.changgou.service.goods.service;

import com.yunlian.changgou.common.Result;
import com.yunlian.changgou.goods.model.Goods;

public interface SpuService {
    void add(Goods goods);

    Result audit(String id);

    Result pull(String id);

    Result delete(String id);
}
