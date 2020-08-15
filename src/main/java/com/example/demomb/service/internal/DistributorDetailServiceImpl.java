package com.example.demomb.service.internal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomb.entity.dao.DistributorDetailEntity;
import com.example.demomb.mapper.DistributorDetailMapper;
import com.example.demomb.service.DistributorDetailService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistributorDetailServiceImpl extends ServiceImpl<DistributorDetailMapper, DistributorDetailEntity> implements DistributorDetailService {

    @Autowired
    private DistributorDetailMapper distributorDetailMapper;

    @Transactional
    @Override
    public void create(JSONObject jsonObject) {
        //json数组 info不需要判断是否为空，可能同步的内容就是空
        JSONArray jsonArray = jsonObject.getJSONArray("info");
        String info = jsonObject.getString("info");
        System.out.println(info);
//        List<CompanyEntity> companyEntities = JSON.parseArray(info, CompanyEntity.class);
//        System.out.println(companyEntities);
        List<DistributorDetailEntity> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            Validate.notBlank(object.getString("distributorId"), "第" + i + "--外键--不能为空");
            Validate.notBlank(object.getString("productName"), "第" + i + "--产品名称--不能为空");
            Validate.notBlank(object.getString("barCode"), "第" + i + "--条码/二维码--不能为空");
            Validate.notBlank(object.getString("batch"), "第" + i + "--批号--不能为空");
            Validate.notBlank(object.getString("salesNum"), "第" + i + "--销售数量--不能为空");
            Validate.notBlank(object.getString("producedDate"), "第" + i + "--生产日期--不能为空");
            Validate.notBlank(object.getString("unit"), "第" + i + "--单位--不能为空");
            DistributorDetailEntity distributorDetailEntity = JSON.toJavaObject(object, DistributorDetailEntity.class);
            list.add(distributorDetailEntity);
        }
        saveBatch(list);
    }
}
