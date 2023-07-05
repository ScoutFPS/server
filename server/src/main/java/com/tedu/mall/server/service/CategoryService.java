package com.tedu.mall.server.service;

import com.tedu.mall.server.pojo.po.CategoryPO;

import java.util.List;

public interface CategoryService {
        //查询所有商品分类
    List<CategoryPO> selectAll();
}
