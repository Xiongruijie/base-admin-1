package cn.huanzi.qch.baseadmin.numide.repository;

import cn.huanzi.qch.baseadmin.numide.controller.pojo.QueryDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author:Xiongruijie
 * @create: 2023-06-28 16:52
 * @Description:
 */
@Repository
public interface QueryDetailRepository extends JpaRepository<QueryDetail,Integer> {
}
