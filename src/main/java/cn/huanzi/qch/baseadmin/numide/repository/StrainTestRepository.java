package cn.huanzi.qch.baseadmin.numide.repository;

import cn.huanzi.qch.baseadmin.numide.controller.pojo.StrainTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrainTestRepository extends JpaRepository<StrainTest, Integer> {
}
