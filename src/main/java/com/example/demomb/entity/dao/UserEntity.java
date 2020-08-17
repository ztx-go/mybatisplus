package com.example.demomb.entity.dao;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel(value = "UserEntity")
@TableName(value = "user")
@Data
public class UserEntity implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(hidden = true)
    private Long id;

    //    @TableField(value = "name", insertStrategy = FieldStrategy.NOT_NULL)
//    @NotEmpty(message = "姓名不能为空")
    @ApiModelProperty(value = "name")
    @NotBlank(message = "姓名不能为空")
    @TableField(value = "name")
    private String name;

    @ApiModelProperty(value = "age")
    @NotNull(message = "年龄字段必须存在")
    @TableField(value = "age")
    private String age;


}
