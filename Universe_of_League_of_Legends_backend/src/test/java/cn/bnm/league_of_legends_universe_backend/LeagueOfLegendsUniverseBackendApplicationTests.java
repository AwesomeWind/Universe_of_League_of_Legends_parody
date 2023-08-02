package cn.bnm.league_of_legends_universe_backend;

import cn.bnm.league_of_legends_universe_backend.entity.Region;
import cn.bnm.league_of_legends_universe_backend.mapper.RegionMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LeagueOfLegendsUniverseBackendApplicationTests {

    @Autowired
    private RegionMapper regionMapper;

    @Test
    public void testFindAllRegions() {
        // 查询所有区域信息
        List<Region> regions = regionMapper.findAllRegions();
        // 打印结果
        for(Region region : regions){
            System.out.println(region);
        }
        // 验证结果
        Assertions.assertNotEquals(0, regions.size()); // 验证数据数量不为0
    }

}
