package cn.bnm.league_of_legends_universe_backend.mapper;

import org.apache.ibatis.annotations.*;
import cn.bnm.league_of_legends_universe_backend.entity.Hero;
import java.util.List;

@Mapper
public interface HeroMapper {

    //根据hero的formerly查询
    @Select("SELECT * FROM hero_information WHERE formerly=#{formerly}")
    Hero findByFormerly(String formerly);

    //模糊查询
    @Select("SELECT h.*\n" +
            "FROM hero_information h \n" +
            "LEFT JOIN region_information re ON h.relevantRegion = re.formerly \n" +
            "LEFT JOIN races_information r ON h.races = r.formerly \n" +
            "LEFT JOIN role_information ro ON h.role = ro.title \n" +
            "WHERE LOWER(h.translation) LIKE CONCAT('%', #{keyword}, '%') \n" +
            "   OR LOWER(h.title) LIKE CONCAT('%', #{keyword}, '%') \n" +
            "   OR LOWER(re.translation) LIKE CONCAT('%', #{keyword}, '%') \n" +
            "   OR LOWER(r.translation) LIKE CONCAT('%', #{keyword}, '%') \n" +
            "   OR LOWER(ro.name) LIKE CONCAT('%', #{keyword}, '%')")
    List<Hero> FuzzyQueries(String keyword);

    //查询heroes
    @Select("SELECT * FROM hero_information")
    List<Hero> findAllHeroes();

    //根据region查询heroes
    @Select("SELECT * FROM hero_information WHERE relevantRegion=#{region}")
    List<Hero> findHeroesByRegional(String region);

    @Insert("INSERT INTO hero_information(releaseDate, formerly, translation, title, races, relevantRegion, role, biography, synopsis, motto, relatedPeople, posters, width, height, x, y) " +
            "values(#{releaseDate},#{formerly},#{translation},#{title},#{races},#{relevantRegion},#{role},#{biography},#{synopsis},#{motto},#{relatedPeople},#{posters},#{width},#{height},#{x},#{y})")
    @Options(useGeneratedKeys = true, keyProperty = "formerly", keyColumn = "formerly")
    int insert(Hero hero);

    @Delete("DELETE FROM hero_information WHERE formerly=#{formerly}")
    int deleteByFormerly(String formerly);

}