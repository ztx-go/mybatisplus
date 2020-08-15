package com.example.demomb.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demomb.entity.dao.DistributorDetailEntity;

public interface DistributorDetailService extends IService<DistributorDetailEntity> {

    void create(JSONObject jsonObject);

}
