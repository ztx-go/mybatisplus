package com.example.demomb.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demomb.entity.dao.CirculateDistributorDetailEntity;

public interface CirculateDistributorDetailService extends IService<CirculateDistributorDetailEntity> {

    void create(JSONObject jsonObject);

}
