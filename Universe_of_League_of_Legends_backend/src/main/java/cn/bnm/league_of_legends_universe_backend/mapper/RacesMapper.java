package cn.bnm.league_of_legends_universe_backend.mapper;

import cn.bnm.league_of_legends_universe_backend.entity.Races;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RacesMapper {

    @Select("SELECT * FROM races_information")
    List<Races> findAll();

    @Select("SELECT * FROM races_information WHERE formerly = #{formerly}")
    Races findByFormerly(String formerly);

    @Update("UPDATE races_information SET translation = #{translation}, synopsis = #{synopsis} WHERE formerly = #{formerly}")
    void update(Races races);

    @Insert("INSERT INTO races_information(formerly, translation, synopsis) VALUES(#{formerly}, #{translation}, #{synopsis})")
    void add(Races races);

    @Delete("DELETE FROM races_information WHERE formerly = #{formerly}")
    void deleteByFormerly(String formerly);
}