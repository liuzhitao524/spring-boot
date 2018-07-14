package com.hqins.demo.dao.master;

import com.hqins.demo.domain.master.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User findUserById(@Param("id") Integer id);
}
