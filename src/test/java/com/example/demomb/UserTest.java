package com.example.demomb;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demomb.entity.dao.UserEntity;
import com.example.demomb.entity.vo.UserTestVO;
import com.example.demomb.mapper.UserMapper;
import com.example.demomb.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootTest
public class UserTest {

    @Autowired
    UserService userService;

    @Resource
    UserMapper userMapper;

    @Test
    void testForSelect1() {
        UserEntity userEntity = userMapper.selectById("21");
        System.out.println("======" + userEntity);
    }

    //分页相关
    @Test
    void testForSelect2() {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
//Page 第一个参数是第一页，第二个参数是页面的大小，先查一次总数据量，然后再limit 查询，如果不需要总数据量，第三个参数可以写成false
//        Page<UserEntity> page = new Page<>(3, 3,false);
//        ===============用法示例===============
//        Page<UserEntity> page = new Page<>(3, 3);
//        查询所有的话可以是 selectPage(page, null);
//        Page<UserEntity> userEntityPage = userMapper.selectPage(page, queryWrapper);
//        System.out.println("============" + userEntityPage.getTotal() + userEntityPage.getSize() + userEntityPage.getRecords());

//        IPage<Map<String,Object>> memberPage=new Page<>(1,5);
//        IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(memberPage, queryWrapper);
//        System.out.println("============" + mapIPage.getTotal() + mapIPage.getSize() + mapIPage.getRecords());

//        Page<UserEntity> page1 = new Page<>(1, 3);
//        IPage<UserEntity> myPageUser = userMapper.selectMyPage(page1, queryWrapper);
//        System.out.println("============" + myPageUser.getTotal() + myPageUser.getSize() + myPageUser.getRecords());
//
//        IPage<UserTestVO> myPageUser1 = userMapper.selectByHisName(page1);
//        System.out.println("+++++++" + myPageUser1.getTotal() + myPageUser1.getSize() + myPageUser1.getRecords());

    }

    @Test
    void testForSelect3() {
//        注意需要和数据库中的字段类型相匹配
        HashMap<String, Object> map = new HashMap<>(16);
        map.put("password", "123456");
        map.put("pwdSalt", "666");
//        List<UserEntity> userEntities = userMapper.selectByMap(map);
//        System.out.println(userEntities);
        int i = userMapper.deleteByMap(map);
        System.out.println("===" + i);
    }
}
