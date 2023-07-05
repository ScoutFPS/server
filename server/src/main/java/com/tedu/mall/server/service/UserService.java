package com.tedu.mall.server.service;

import com.tedu.mall.server.pojo.dto.UserDTO;
import com.tedu.mall.server.pojo.dto.UserPasswordDTO;
import com.tedu.mall.server.pojo.vo.UserVO;

/**
 * 登录
 * @param userDTO 封装了用户名和密码
 * @return 用户编号
 */
public interface UserService {
    Integer login(UserDTO userDTO);
    UserVO getInfo(Integer userId);
    Integer register(UserDTO userDTO);
    boolean changepwd(UserPasswordDTO userPasswordDTO);
    boolean delete(Integer userId);
}
