package com.example.demomb.entity.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 销货商品明细表
 */
@TableName(value = "tz_distributors_details")
@Data
public class DistributorDetailEntity implements Serializable {

    /**
     * 外键: tz_distributors表ID
     * 产品名称
     * 条码/二维码
     * 批号
     * 销售数量
     * 生产日期，格式为yyyy-MM-dd
     * 生产企业统一社会信用代码
     * 单位
     * 检验检疫报告
     * 创建时间
     * 最近一次修改时间
     */

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "外键: tz_distributors表ID")
    @TableField(value = "distributor_id")
    private String distributorId;

    @ApiModelProperty(value = "产品名称")
    @TableField(value = "product_name")
    private String productName;

    @ApiModelProperty(value = "条码/二维码")
    @TableField(value = "bar_code")
    private String barCode;

    @ApiModelProperty(value = "批号")
    @TableField(value = "batch")
    private String batch;

    @ApiModelProperty(value = "销售数量")
    @TableField(value = "sales_num")
    private String salesNum;

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
