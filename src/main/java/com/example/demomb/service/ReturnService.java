package com.example.demomb.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demomb.entity.dao.ReturnEntity;

public interface ReturnService extends IService<ReturnEntity> {

    void create(JSONObject jsonObject);
}
