package com.example.demomb.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demomb.entity.dao.CompanyEntity;

public interface CompanyService extends IService<CompanyEntity> {

    void create(JSONObject jsonObject);
}
