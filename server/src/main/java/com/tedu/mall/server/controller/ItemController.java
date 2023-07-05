package com.tedu.mall.server.controller;

import com.tedu.mall.server.pojo.ServerResult;
import com.tedu.mall.server.pojo.dto.InsertItemDTO;
import com.tedu.mall.server.pojo.po.ItemPO;
import com.tedu.mall.server.pojo.vo.ItemVO;
import com.tedu.mall.server.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    @RequestMapping("/item/selectByCategoryId")
    //访问：http://localhost:9002/doc.html
    public ServerResult selectByCategoryId(Integer categoryId){
        List<ItemPO> list = itemService.selectByCategoryId(categoryId);
        ServerResult serverResult = new ServerResult(0,"成功",list);
        return serverResult;
    }

    @RequestMapping("/item/selectById")
    public ServerResult selectById(Integer id){
        ItemPO itemPO = itemService.selectById(id);
        ServerResult serverResult = new ServerResult(0,"成功",itemPO);
        return serverResult;
    }

    @RequestMapping("/item/insert")
    public ServerResult insert(InsertItemDTO insertItemDTO){
        boolean insert = itemService.Insert(insertItemDTO);
        if(insert)return new ServerResult(0,"insert success!",insert);
        else return new ServerResult(666,"insert failed!",insert);
    }

    @RequestMapping("/selectAll")
    public ServerResult selectAll(){
        List<ItemVO> list = itemService.selectAll();
        return new ServerResult(0,"Success!",list);
    }
}
