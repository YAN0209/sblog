package pers.yan.sblog.dao.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import pers.yan.sblog.util.UserUtil;

import java.sql.Date;
import java.time.Instant;

/**
 * 通用字段自动填充
 *
 * @author likaiyan
 * @date 2021/7/23 10:27 上午
 */
@Component
public class EntityFillHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("createTime", Date.from(Instant.now()), metaObject);
        setFieldValByName("createBy", UserUtil.getCurrentUserId(), metaObject);
        setFieldValByName("updateTime", Date.from(Instant.now()), metaObject);
        setFieldValByName("updateBy", UserUtil.getCurrentUserId(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateTime", Date.from(Instant.now()), metaObject);
        setFieldValByName("updateBy", UserUtil.getCurrentUserId(), metaObject);
    }
}
