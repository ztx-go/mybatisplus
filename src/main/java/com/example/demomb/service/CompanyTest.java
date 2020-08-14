package com.example.demomb.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomb.entity.dao.CompanyEntity;
import com.example.demomb.mapper.CompanyMapper;
import org.springframework.stereotype.Service;

@Service
public class CompanyTest  extends ServiceImpl<CompanyMapper, CompanyEntity> implements CompanyService {

}
