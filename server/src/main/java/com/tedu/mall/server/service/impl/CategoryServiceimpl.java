package com.tedu.mall.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tedu.mall.server.mapper.CategoryMapper;
import com.tedu.mall.server.pojo.po.CategoryPO;
import com.tedu.mall.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceimpl implements CategoryService {
    //调用数据访问层
    @Autowired//自动注入，1，写了CategoryMapper接口，
        // 2,在ServerApplication中加了mapperScan(com.tedu.mall.server.mapper),生成了接口的实现类，
        // 生成了实现类的对象，对象放在spring容器中
        //3,从spring容器中找CategoryMapper的对象
        CategoryMapper categoryMapper;
    @Override
    public List<CategoryPO> selectAll() {
        //querywrapper生成查询条件 select where
        //null 没有查询条件，查询所有数据
        QueryWrapper queryWrapper =null;
        List list = categoryMapper.selectList(queryWrapper);
        return list;
    }
}
