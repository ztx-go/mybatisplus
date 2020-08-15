package com.example.demomb.service.internal;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomb.entity.dao.DistributorEntity;
import com.example.demomb.entity.dao.GoodEntity;
import com.example.demomb.mapper.GoodMapper;
import com.example.demomb.service.GoodService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper, GoodEntity> implements GoodService {

    @Autowired
    private GoodMapper goodMapper;

    @Override
    public void create(JSONObject jsonObject) {
        //json数组 info不需要判断是否为空，可能同步的内容就是空
        JSONArray jsonArray = jsonObject.getJSONArray("info");
        String info = jsonObject.getString("info");
        System.out.println(info);
//        List<CompanyEntity> companyEntities = JSON.parseArray(info, CompanyEntity.class);
//        System.out.println(companyEntities);
        List<GoodEntity> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            Validate.notBlank(object.getString("barCode"), "第" + i + "行：条形码/二维码--不能为空");
            Validate.notBlank(object.getString("goodsName"), "第" + i + "行：商品名称--不能为空");
            Validate.notBlank(object.getString("goodsType"), "第" + i + "行：商品类型--不能为空");
            Validate.notBlank(object.getString("sellerName"), "第" + i + "行：生产企业名称--不能为空");
            Validate.notBlank(object.getString("specification"), "第" + i + "行：规格--不能为空");
            Validate.notBlank(object.getString("productCategoryName"), "第" + i + "行：商品类别--不能为空");
            Validate.notBlank(object.getString("fromCompanyCode"), "第" + i + "行：商品所属公司统一社会信用代码--不能为空");
            Validate.notBlank(object.getString("fromPlatform"), "第" + i + "行：所属平台--不能为空");

            GoodEntity goodEntity = JSON.toJavaObject(object, GoodEntity.class);
            list.add(goodEntity);
        }

        saveBatch(list);
    }
}
