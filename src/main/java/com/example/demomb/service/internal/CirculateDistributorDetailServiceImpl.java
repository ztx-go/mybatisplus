package com.example.demomb.service.internal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomb.entity.dao.CirculateDistributorDetailEntity;
import com.example.demomb.mapper.CirculateDistributorDetailMapper;
import com.example.demomb.service.CirculateDistributorDetailService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CirculateDistributorDetailServiceImpl extends ServiceImpl<CirculateDistributorDetailMapper, CirculateDistributorDetailEntity> implements CirculateDistributorDetailService {

    @Autowired
    private CirculateDistributorDetailMapper distributorDetailMapper;

}
