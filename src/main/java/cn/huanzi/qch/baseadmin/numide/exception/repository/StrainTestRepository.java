package cn.huanzi.qch.baseadmin.numide.exception.repository;

import cn.huanzi.qch.baseadmin.numide.pojo.StrainTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrainTestRepository extends JpaRepository<StrainTest, Integer> {
}
