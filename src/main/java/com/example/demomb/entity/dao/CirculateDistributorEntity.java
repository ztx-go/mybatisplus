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
 * 销货记录表
 */
@ApiModel(value = "CirculateDistributorEntity")
@TableName(value = "tz_distributors")
@Data
public class CirculateDistributorEntity implements Serializable {

    @ApiModelProperty(value = "主键 id", hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "分销商名称")
    @NotBlank(message = "分销商名称不能为空")
    @TableField(value = "distributor_name")
    private String distributorName;

    @ApiModelProperty(value = "分销商统一社会信用代码")
    @NotNull(message = "分销商统一社会信用代码字段必须存在")
    @TableField(value = "distributor_code")
    private String distributorCode;

    @ApiModelProperty(value = "销货日期")
    @NotBlank(message = "销货日期不能为空")
    @TableField(value = "sales_date")
    private String salesDate;

    @ApiModelProperty(value = "经度")
    @NotNull(message = "经度不能为空")
    @TableField(value = "longitude")
    private String longitude;

    @ApiModelProperty(value = "纬度")
    @NotNull(message = "纬度不能为空")
    @TableField(value = "latitude")
    private String latitude;

    @ApiModelProperty(value = "台账所属公司统一社会信用代码")
    @NotBlank(message = "台账所属公司统一社会信用代码不能为空")
    @TableField(value = "from_company_code")
    private String fromCompanyCode;

    @ApiModelProperty(value = "所属平台")
    @NotBlank(message = "所属平台不能为空")
    @TableField(value = "from_platform")
    private String fromPlatform;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "created_at")
    private String createdAt;

    @ApiModelProperty(value = "最近一次修改时间")
    @TableField(value = "updated_at")
    private String updatedAt;


}
