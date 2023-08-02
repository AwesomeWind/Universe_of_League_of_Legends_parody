package cn.bnm.league_of_legends_universe_backend.mapper;

import cn.bnm.league_of_legends_universe_backend.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user_information")
    List<User> findAll();

    @Select("SELECT * FROM user_information WHERE username = #{username}")
    User findByUsername(String username);

    @Insert("INSERT INTO user_information(username, emil, password) VALUES(#{username}, #{emil}, #{password})")
    void insert(User user);

    @Update("UPDATE user_information SET emil = #{emil}, password = #{password} WHERE username = #{username}")
    void updateByUsername(User user);

    @Delete("DELETE FROM user_information WHERE username = #{username}")
    void deleteByUsername(String username);

}