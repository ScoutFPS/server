package com.tedu.mall.server.service;

import com.tedu.mall.server.pojo.dto.InsertItemDTO;
import com.tedu.mall.server.pojo.po.ItemPO;
import com.tedu.mall.server.pojo.vo.ItemVO;

import java.util.List;

public interface ItemService {
    public List<ItemPO> selectByCategoryId(Integer categoryId);
    public ItemPO selectById(Integer id);
    public boolean Insert(InsertItemDTO insertItemDTO);
    public List<ItemVO> selectAll();
}
