package cn.itrip.service.impl;

import cn.itrip.beans.pojo.User;
import cn.itrip.common.Page;
import cn.itrip.dao.UserMapper;
import cn.itrip.service.UserService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public Page<User> getPagedUsers(int pageIndex, String userName) {
        Map<String,Object> params = new HashMap<>();
        params.put("userName",userName);
        int pageSize=5;
        params.put("from",(pageIndex-1)*pageSize);
        params.put("limit",pageSize);
        //查询满足条件的用户集合个数
        List<User> users = userMapper.getUsersByParams(params);
        int totalCount=  userMapper.getUsersCountByParams(params);

        //分页查询结果
        Page<User> pagedUsers = new Page<>(pageIndex,pageSize,totalCount,users);
        return pagedUsers;
    }
}
