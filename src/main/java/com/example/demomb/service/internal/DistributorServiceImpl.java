package com.example.demomb.service.internal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomb.entity.dao.DistributorDetailEntity;
import com.example.demomb.entity.dao.DistributorEntity;
import com.example.demomb.mapper.DistributorMapper;
import com.example.demomb.service.DistributorService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistributorServiceImpl extends ServiceImpl<DistributorMapper, DistributorEntity> implements DistributorService {

    @Autowired
    private DistributorMapper distributorMapper;

    @Override
    public void create(JSONObject jsonObject) {
        //json数组 info不需要判断是否为空，可能同步的内容就是空
        JSONArray jsonArray = jsonObject.getJSONArray("info");
        String info = jsonObject.getString("info");
        System.out.println(info);
//        List<CompanyEntity> companyEntities = JSON.parseArray(info, CompanyEntity.class);
//        System.out.println(companyEntities);
        List<DistributorEntity> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            Validate.notBlank(object.getString("distributorName"), "第" + i + "--分销商名称--不能为空");
            Validate.notBlank(object.getString("salesDate"), "第" + i + "--销货日期--不能为空");
            Validate.notBlank(object.getString("fromCompanyCode"), "第" + i + "--台账所属公司统一社会信用代码--不能为空");
            Validate.notBlank(object.getString("fromPlatform"), "第" + i + "--所属平台--不能为空");
            DistributorEntity distributorEntity = JSON.toJavaObject(object, DistributorEntity.class);
            list.add(distributorEntity);

        }

        saveBatch(list);
    }
}