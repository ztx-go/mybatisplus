package com.example.demomb.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demomb.entity.dao.GoodEntity;

public interface GoodService extends IService<GoodEntity> {

    void create(JSONObject jsonObject);

}
