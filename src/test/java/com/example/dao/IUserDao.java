package com.example.dao;

import com.example.po.User;

/**
 * @author ZhangPengFei
 * @description
 */
public interface IUserDao {

    String queryUserName(String uId);

    User queryUserInfoById(String uId);
}
