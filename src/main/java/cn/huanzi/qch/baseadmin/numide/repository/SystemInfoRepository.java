package cn.huanzi.qch.baseadmin.numide.repository;

import cn.huanzi.qch.baseadmin.numide.controller.pojo.SystemInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemInfoRepository extends JpaRepository<SystemInfo, Integer> {
}
