package com.tedu.mall.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tedu.mall.server.pojo.po.CategoryPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends BaseMapper <CategoryPO> {

}
