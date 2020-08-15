package com.example.demomb.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demomb.entity.dao.SupplyEntity;

public interface SupplyService extends IService<SupplyEntity> {

    void create(JSONObject jsonObject);
}
