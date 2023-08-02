package cn.bnm.league_of_legends_universe_backend.mapper;

import cn.bnm.league_of_legends_universe_backend.entity.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Select("SELECT * FROM role_information")
    List<Role> findAllRoles();

    @Select("SELECT * FROM role_information WHERE title = #{title}")
    Role findRoleByTitle(String title);

    @Insert("INSERT INTO role_information(title, name, icon, briefly) VALUES(#{title}, #{name}, #{icon}, #{briefly})")
    int insertRole(Role role);

    @Update("UPDATE role_information SET name = #{name}, icon = #{icon}, briefly = #{briefly} WHERE title = #{title}")
    int updateRole(Role role);

    @Delete("DELETE FROM role_information WHERE title = #{title}")
    int deleteRoleByTitle(String title);

}