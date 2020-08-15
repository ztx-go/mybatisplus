package com.example.demomb.entity.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 商品处理台账表
 */
@TableName(value = "tz_handles")
@Data
public class HandleEntity implements Serializable {

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商品名称")
    @TableField(value = "product_name")
    private String productName;

    @ApiModelProperty(value = "商品条码/二维码")
    @TableField(value = "bar_code")
    private String barCode;

    @ApiModelProperty(value = "批号")
    @TableField(value = "batch")
    private String batch;

    @ApiModelProperty(value = "生产日期")
    @TableField(value = "produced_date")
    private String producedDate;

    @ApiModelProperty(value = "生产企业统一社会信用代码")
    @TableField(value = "social_credit_unicode")
    private String socialCreditUnicode;

    @ApiModelProperty(value = "单位")
    @TableField(value = "unit")
    private String unit;

    @ApiModelProperty(value = "处理数量")
    @TableField(value = "return_num")
    private String returnNum;

    @ApiModelProperty(value = "处理类型")
    @TableField(value = "handle_type")
    private String handleType;

    @ApiModelProperty(value = "经度")
    @TableField(value = "longitude")
    private String longitude;

    @ApiModelProperty(value = "纬度")
    @TableField(value = "latitude")
    private String latitude;

    @ApiModelProperty(value = "台账所属公司统一社会信用代码")
    @TableField(value = "from_company_code")
    private String fromCompanyCode;

    @ApiModelProperty(value = "所属平台")
    @TableField(value = "from_platform")
    private String fromPlatform;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "created_at")
    private String createdAt;

    @ApiModelProperty(value = "最近一次修改时间")
    @TableField(value = "updated_at")
    private String updatedAt;


}
