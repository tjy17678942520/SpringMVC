package com.beihua.mapper;

import com.beihua.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 条件分页查询
     * select * from user
     * limit （当前页码 - 1） * 每页显示条数，每页显示条数
     * @param userName
     * @param userSex
     * @param startRow
     * @return
     */
    List<User> selectUserPage(@Param("userName") String userName, @Param("userSex") String userSex, @Param("startRow") int startRow);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int createUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateUserById(User user);

    /**
     * 更新行数
     * @param userId
     * @return
     */
    int deleteUserById(@Param("userId") String userId);

    /**
     * 获取总行数
     * @param userName
     * @param userSex
     * @return
     */
    int getRowCount(@Param("userName") String userName,@Param("userSex") String userSex);
}
