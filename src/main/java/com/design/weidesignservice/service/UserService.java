/**
 * 主要业务层，编写复杂功能，提供impl接口
 */

package com.design.weidesignservice.service;

import com.design.weidesignservice.entity.User;
import com.design.weidesignservice.mapper.UserMapper;
import com.design.weidesignservice.result.ResultDTO;
import com.design.weidesignservice.result.ResultError;
import com.design.weidesignservice.result.UserError;
import com.design.weidesignservice.util.JwtUtil;
import com.design.weidesignservice.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.design.weidesignservice.util.UUIDUtil;

import java.util.HashMap;
import java.util.Map;



@Service("UserService")
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisUtils redisUtils;

   /* @Autowired
    PasswordEncoder passwordEncoder;*/

    public User findUserById(String userId) {
        return userMapper.findUserById(userId);
    }

    public ResultDTO Insert(String username, String password, String showName) {
        Map<String, Object> respMap = new HashMap<>();
        String Id = UUIDUtil.getUUID();
        User user = null;
        try {
            User user1 = userMapper.findByUsername(username);
            if(user1 != null) {
                return ResultDTO.failure(new ResultError(UserError.EMP_IS_EXIT));
            }
            userMapper.insert(Id, username, password, showName);

            user = userMapper.findUserById(Id);
            // 如果没查到新增的用户信息
            if(user == null) {
                return ResultDTO.failure(new ResultError(UserError.EMP_INSERT_ERROR));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        respMap.put("user", user);
        return ResultDTO.success(respMap, "注册成功！");
    }

    public ResultDTO login(String name, String password) {
        Map<String, Object> tokenMap = new HashMap<>();
        //密码需要客户端加密后传递
        String token = null;
        try {
            User user = userMapper.findByUsername(name);
            if(user == null){
                 return ResultDTO.failure(new ResultError(UserError.EMP_IS_NULL_EXIT));
            }else{
                if(!user.getPassword().equals(password)){
                    return ResultDTO.failure(new ResultError(UserError.PASSWORD_OR_NAME_IS_ERROR));
                }else {
                    // 将 user id 、userName保存到 token 里面
                    token = JwtUtil.sign(user.getUsername(),user.getId(),user.getPassword());
                    redisUtils.set("userToken-" + user.getId(), token, 2L * 60);
                }
            }

            if(StringUtils.isEmpty(token)){
                return ResultDTO.failure(new ResultError(UserError.PASSWORD_OR_NAME_IS_ERROR));
            }
            tokenMap.put("token", token);
            tokenMap.put("user", user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultDTO.success(tokenMap, "登录成功");
    }

}
