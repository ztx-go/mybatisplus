package com.example.demomb.entity.dao;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName(value = "user")
@Data
public class UserEntity implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

//    @TableField(value = "name", insertStrategy = FieldStrategy.NOT_NULL)
    @TableField(value = "name")
    private String name;

    @TableField(value = "age")
    private String age;


}
