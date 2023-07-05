package com.tedu.mall.server.controller;

import com.tedu.mall.server.pojo.ServerResult;
import com.tedu.mall.server.pojo.dto.UserDTO;
import com.tedu.mall.server.pojo.dto.UserPasswordDTO;
import com.tedu.mall.server.pojo.vo.UserVO;
import com.tedu.mall.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/login")
    public ServerResult login(UserDTO userDTO){
        Integer userId = userService.login(userDTO);
        if (userId>=1)return new ServerResult(0,"success",userId);
        else return new ServerResult(666,"fail",null);
    }
    @RequestMapping("/getInfo")
    public ServerResult getInfo(Integer userId){
        UserVO userVO = userService.getInfo(userId);
        ServerResult serverResult= new ServerResult(0,"success",userVO);
        return  serverResult;
    }
    @RequestMapping("/register")
    public ServerResult register(UserDTO userDTO){
        Integer userId = userService.register(userDTO);
        return new ServerResult(0,"register succsess!",userId);
    }

    @RequestMapping("/changepwd")
    public ServerResult changepwd(UserPasswordDTO userPasswordDTO){
        boolean changepwd = userService.changepwd(userPasswordDTO);
        if(changepwd)return new ServerResult(0,"change success!",changepwd);
        else return new ServerResult(666,"change Failed!",changepwd);
    }

    @RequestMapping("/delete")
    public ServerResult delete(Integer userId){
        boolean delete = userService.delete(userId);
        if(delete)return  new ServerResult(0,"delete success!",delete);
        else  return  new ServerResult(666,"delete Failed!",delete);
    }
}
