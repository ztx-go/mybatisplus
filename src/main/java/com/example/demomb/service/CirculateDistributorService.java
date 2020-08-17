package com.example.demomb.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demomb.entity.dao.CirculateDistributorEntity;

public interface CirculateDistributorService extends IService<CirculateDistributorEntity> {

    void create(JSONObject jsonObject);

}
