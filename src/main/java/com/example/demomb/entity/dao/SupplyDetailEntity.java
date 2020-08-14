package com.example.demomb.entity.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 进货商品明细表
 */
@TableName(value = "tz_supplies_details")
@Data
public class SupplyDetailEntity implements Serializable {

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "外键:tz_supplies表ID")
    @TableField(value = "supply_id")
    private String supply_id;

    @ApiModelProperty(value = "产品名称")
    @TableField(value = "product_name")
    private String productName;

    @ApiModelProperty(value = "条码/二维码")
    @TableField(value = "bar_code")
    private String barCode;

    @ApiModelProperty(value = "批号")
    @TableField(value = "batch")
    private String batch;

    @ApiModelProperty(value = "进货数量")
    @TableField(value = "stock_num")
    private String stockNum;

    @ApiModelProperty(value = "生产日期")
    @TableField(value = "produced_date")
    private String producedDate;

    @ApiModelProperty(value = "生产企业统一社会信用代码")
    @TableField(value = "social_credit_unicode")
    private String socialCreditUnicode;

    @ApiModelProperty(value = "单位")
    @TableField(value = "unit")
    private String unit;

    @ApiModelProperty(value = "检验检疫报告")
    @TableField(value = "detection_records")
    private String detectionRecords;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "created_at")
    private String createdAt;

    @ApiModelProperty(value = "最近一次修改时间")
    @TableField(value = "updated_at")
    private String updatedAt;

}
