package com.example.demomb.service.internal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomb.entity.dao.CirculateSupplyDetailEntity;
import com.example.demomb.mapper.CirculateSupplyDetailMapper;
import com.example.demomb.service.CirculateSupplyDetailService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CirculateSupplyDetailServiceImpl extends ServiceImpl<CirculateSupplyDetailMapper, CirculateSupplyDetailEntity> implements CirculateSupplyDetailService {

    @Autowired
    private CirculateSupplyDetailMapper supplyDetailMapper;

}
