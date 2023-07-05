package com.tedu.mall.server.controller;

import com.tedu.mall.server.mapper.CategoryMapper;
import com.tedu.mall.server.pojo.ServerResult;
import com.tedu.mall.server.pojo.po.CategoryPO;
import com.tedu.mall.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//让springweb框架为CategoryController创建一个对象
public class CategoryController {
    //控制层调业务层
    @Autowired
    CategoryService categoryService;//面向接口编程
    @RequestMapping("/testException")
    public ServerResult testException(int n){
        int result = 10/n;
        return new ServerResult(0,"成功",result);
    }
    //控制层直接调数据访问层可以
    @RequestMapping("/catehttp://localhost:9002gory/selectAll")
    //在浏览器中输入/category/selectAll
    public ServerResult selectAll(){
        List<CategoryPO> list = categoryService.selectAll();
        ServerResult serverResult = new ServerResult(0,"查询成功",list);
        return serverResult;
    }
}
