package com.example.demomb.service.internal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomb.entity.dao.CirculateHandleEntity;
import com.example.demomb.mapper.CirculateHandleMapper;
import com.example.demomb.service.CirculateHandleService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CirculateHandleServiceImpl extends ServiceImpl<CirculateHandleMapper, CirculateHandleEntity> implements CirculateHandleService {

    @Autowired
    private CirculateHandleMapper handleMapper;

}
