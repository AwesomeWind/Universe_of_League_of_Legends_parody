package cn.bnm.league_of_legends_universe_backend.mapper;

import cn.bnm.league_of_legends_universe_backend.entity.Region;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RegionMapper {

    @Select("SELECT * FROM region_information")
    List<Region> findAllRegions();

    @Select("SELECT * FROM region_information WHERE formerly=#{formerly}")
    Region findRegionByFormerly(String formerly);

    @Delete("DELETE FROM region_information WHERE formerly=#{formerly}")
    void deleteRegionByFormerly(String formerly);

    @Update("UPDATE region_information SET translation=#{translation},icon_name=#{iconName},emblem_name=#{emblemName},description=#{description},posters=#{posters},width=#{width},height=#{height},x=#{x},y=#{y} WHERE formerly=#{formerly}")
    void updateRegion(Region region);

}