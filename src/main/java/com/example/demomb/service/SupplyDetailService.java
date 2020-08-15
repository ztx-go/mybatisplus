package com.example.demomb.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demomb.entity.dao.SupplyDetailEntity;

public interface SupplyDetailService extends IService<SupplyDetailEntity> {

    void create(JSONObject jsonObject);
}
