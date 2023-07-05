package com.tedu.mall.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tedu.mall.server.mapper.ItemMapper;
import com.tedu.mall.server.pojo.ServerResult;
import com.tedu.mall.server.pojo.dto.InsertItemDTO;
import com.tedu.mall.server.pojo.po.ItemPO;
import com.tedu.mall.server.pojo.vo.ItemVO;
import com.tedu.mall.server.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ItemServiceimpl implements ItemService {

    @Autowired
        ItemMapper itemMapper;
    @Override
    public List<ItemPO> selectByCategoryId(Integer categoryId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("category_id",categoryId);
        List list = itemMapper.selectList(queryWrapper);
        return list;
    }

    @Override
    public ItemPO selectById(Integer id) {
/*        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",id);*/
        ItemPO itemPO = itemMapper.selectById(id);
        return itemPO;
    }

    @Override
    public boolean Insert(InsertItemDTO insertItemDTO) {
        ItemPO itemPO = new ItemPO();
        BeanUtils.copyProperties(insertItemDTO,itemPO);
        int insertnum = itemMapper.insert(itemPO);
        return insertnum>=1?true:false;
    }

    @Override
    public List<ItemVO> selectAll() {
        ArrayList<ItemVO> POList = new ArrayList();
        List<ItemPO> Itemlist = itemMapper.selectList(null);
        for(ItemPO itemPO:Itemlist){
            ItemVO itemVO = new ItemVO();
            BeanUtils.copyProperties(itemPO,itemVO);
            POList.add(itemVO);
        }
        return  POList;
    }
}
