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
 * 商品表
 */
@ApiModel(value = "CirculateGoodEntity")
@TableName(value = "lt_goods")
@Data
public class CirculateGoodEntity implements Serializable {

    @ApiModelProperty(value = "主键 id", hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "条形码/二维码", required = true)
    @NotBlank(message = "条形码/二维码不能为空")
    @TableField(value = "bar_code")
    private String barCode;

    @ApiModelProperty(value = "商品名称", required = true)
    @NotBlank(message = "商品名称不能为空")
    @TableField(value = "goods_name")
    private String goodsName;

    @ApiModelProperty(value = "商品类型", required = true)
    @NotBlank(message = "商品类型不能为空")
    @TableField(value = "goods_type")
    private String goodsType;

    @ApiModelProperty(value = "生产企业名称", required = true)
    @NotBlank(message = "生产企业名称不能为空")
    @TableField(value = "seller_name")
    private String sellerName;

    @ApiModelProperty(value = "生产企业统一社会信用代码")
    @NotNull(message = "生产企业统一社会信用代码字段必须存在")
    @TableField(value = "social_credit_unicode")
    private String socialCreditUnicode;

    @ApiModelProperty(value = "保质期数值")
    @NotNull(message = "保质期数值字段必须存在")
    @TableField(value = "expiry_date_num")
    private String expiryDateNum;

    @ApiModelProperty(value = "保质期单位")
    @NotNull(message = "保质期单位字段必须存在")
    @TableField(value = "expiry_date_unit")
    private String expiryDateUnit;

    @ApiModelProperty(value = "规格", required = true)
    @NotBlank(message = "规格不能为空")
    @TableField(value = "specification")
    private String specification;

    @ApiModelProperty(value = "最小销售单元")
    @NotNull(message = "最小销售单元字段必须存在")
    @TableField(value = "min_sales_unit")
    private String minSalesUnit;

    @ApiModelProperty(value = "商品类别", required = true)
    @NotBlank(message = "商品类别不能为空")
    @TableField(value = "product_category_name")
    private String productCategoryName;

    @ApiModelProperty(value = "商标")
    @NotNull(message = "商标字段必须存在")
    @TableField(value = "trademark")
    private String trademark;

    @ApiModelProperty(value = "商品所属公司统一社会信用代码", required = true)
    @NotBlank(message = "商品所属公司统一社会信用代码不能为空")
    @TableField(value = "from_company_code")
    private String fromCompanyCode;

    @ApiModelProperty(value = "所属平台", required = true)
    @NotBlank(message = "所属平台不能为空")
    @TableField(value = "from_platform")
    private String fromPlatform;

    @ApiModelProperty(value = "创建时间", hidden = true)
    @TableField(value = "created_at")
    private String createdAt;

    @ApiModelProperty(value = "最近一次修改时间", hidden = true)
    @TableField(value = "updated_at")
    private String updatedAt;


}
