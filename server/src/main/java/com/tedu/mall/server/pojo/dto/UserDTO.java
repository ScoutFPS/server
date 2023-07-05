package com.tedu.mall.server.pojo.dto;

//封装登录时的用户名和密码
public class UserDTO {
   String name;
   String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
