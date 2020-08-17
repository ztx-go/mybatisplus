package com.example.demomb.entity.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 销货商品明细表
 */
@ApiModel(value = "CirculateDistributorDetailEntity")
@TableName(value = "tz_distributors_details")
@Data
public class CirculateDistributorDetailEntity implements Serializable {

    @ApiModelProperty(value = "主键 id", hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "外键: tz_distributors表ID", hidden = true)
    @TableField(value = "distributor_id")
    private String distributorId;

    @ApiModelProperty(value = "产品名称")
    @NotBlank(message = "产品名称不能为空")
    @TableField(value = "product_name")
    private String productName;

    @ApiModelProperty(value = "条码/二维码")
    @NotBlank(message = "条码/二维码不能为空")
    @TableField(value = "bar_code")
    private String barCode;

    @ApiModelProperty(value = "批号")
    @NotBlank(message = "批号不能为空")
    @TableField(value = "batch")
    private String batch;

    @ApiModelProperty(value = "销售数量")
    @NotBlank(message = "销售数量不能为空")
    @TableField(value = "sales_num")
    private String salesNum;

    @ApiModelProperty(value = "生产日期")
    @NotBlank(message = "生产日期不能为空")
    @TableField(value = "produced_date")
    private String producedDate;

    @ApiModelProperty(value = "生产企业统一社会信用代码", hidden = true)
    @TableField(value = "social_credit_unicode")
    private String socialCreditUnicode;

    @ApiModelProperty(value = "单位")
    @NotBlank(message = "单位不能为空")
    @TableField(value = "unit")
    private String unit;

    @ApiModelProperty(value = "检验检疫报告")
    @NotBlank(message = "检验检疫报告不能为空")
    @TableField(value = "detection_records")
    private String detectionRecords;

    @ApiModelProperty(value = "创建时间", hidden = true)
    @TableField(value = "created_at")
    private String createdAt;

    @ApiModelProperty(value = "最近一次修改时间", hidden = true)
    @TableField(value = "updated_at")
    private String updatedAt;

}
