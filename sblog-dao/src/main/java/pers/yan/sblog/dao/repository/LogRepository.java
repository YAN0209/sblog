package pers.yan.sblog.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pers.yan.sblog.common.entity.OperateLog;

/**
 * @author likaiyan
 * @date 2021/7/23 10:09 上午
 */
@Repository
public interface LogRepository extends MongoRepository<OperateLog, String> {
}
