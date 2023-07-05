package com.tedu.mall.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tedu.mall.server.mapper.UserMapper;
import com.tedu.mall.server.pojo.dto.UserDTO;
import com.tedu.mall.server.pojo.dto.UserPasswordDTO;
import com.tedu.mall.server.pojo.po.UserPO;
import com.tedu.mall.server.pojo.vo.UserVO;
import com.tedu.mall.server.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
        UserMapper userMapper;
    @Override
        public Integer login(UserDTO userDTO) {
        //select * from user where name='' and password=''
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",userDTO.getName());
        queryWrapper.eq("password", userDTO.getPassword());
        UserPO userPO = userMapper.selectOne(queryWrapper);
        if(userPO!=null)return userPO.getId();
        return -1;
    }

    @Override
    public UserVO getInfo(Integer userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",userId);
        UserPO userPO = userMapper.selectOne(queryWrapper);
        if(userPO==null){
            throw new RuntimeException("用户不存在");
        }
        else {
            UserVO userVO = new UserVO();
            userVO.setId(userId);
            userVO.setName(userPO.getName());
            userVO.setLevel(10);
            return userVO;
        }
    }

    @Override
    public Integer register(UserDTO userDTO) {
        //1,先判断用户名是否存在
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",userDTO.getName());
        UserPO userPO = userMapper.selectOne(queryWrapper);
        if(userPO==null){//用户名不存在
            //2,执行添加
            UserPO insertPO = new UserPO();
            BeanUtils.copyProperties(userDTO,insertPO);
            int insertrownum = userMapper.insert(insertPO);
            //3,判断添加是否成功
            if(insertrownum>=1){
                //4,添加成功，查询刚注册的用户的编号
                QueryWrapper selectregisterid = new QueryWrapper();
                selectregisterid.eq("name",insertPO.getName());
                selectregisterid.eq("password",insertPO.getPassword());
                UserPO registerUserPo = userMapper.selectOne(selectregisterid);
                if(registerUserPo==null){
                    throw new RuntimeException("注册后查询失败");
                }else {
                    return registerUserPo.getId();//返回用户编号
                }
            }else {
                  throw new RuntimeException("添加失败");
            }
        }else{
            throw new RuntimeException("用户名已存在");
        }
    }

    @Override
    public boolean changepwd(UserPasswordDTO userPasswordDTO) {
        //update user set passowrd='newPassword '
        //where id=1 and password='oldPassword '
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",userPasswordDTO.getId());
        queryWrapper.eq("password",userPasswordDTO.getOldPassword());

        UserPO userPO= new UserPO();
        userPO.setPassword(userPasswordDTO.getNewPassword());

        int updaterownum = userMapper.update(userPO,queryWrapper);
        return updaterownum>=1?true:false;
    }

    @Override
    public boolean delete(Integer userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",userId);
        int deletenum = userMapper.delete(queryWrapper);
        return deletenum>=1?true:false;
    }


}
