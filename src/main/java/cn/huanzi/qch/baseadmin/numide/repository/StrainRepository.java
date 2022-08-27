package cn.huanzi.qch.baseadmin.numide.repository;


import cn.huanzi.qch.baseadmin.numide.pojo.Strain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrainRepository extends JpaRepository<Strain, Integer> {
}
