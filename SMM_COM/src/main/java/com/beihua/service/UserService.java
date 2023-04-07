package com.beihua.service;

import com.beihua.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
  List<User> selectUserPage(String userName,String userSex,int startRow);

  int updateUserById(User user);

  int deleteUserById(String userId);

  int getRowCount(String userName,String userSex);

  public int createUser(User user);
}
