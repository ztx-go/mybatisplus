package com.example.demomb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demomb.entity.dao.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {


}
