package com.example.demomb.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demomb.entity.dao.DistributorEntity;

public interface DistributorService extends IService<DistributorEntity> {

    void create(JSONObject jsonObject);

}
