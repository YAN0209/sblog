package pers.yan.sblog.service.eventbus.listener;

import com.baomidou.mybatisplus.annotation.TableField;
import com.google.common.eventbus.Subscribe;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;
import pers.yan.sblog.common.entity.OperateLog;
import pers.yan.sblog.common.enums.OperateType;
import pers.yan.sblog.dao.repository.LogRepository;
import pers.yan.sblog.service.annotation.LogCompare;
import pers.yan.sblog.service.eventbus.SblogEventBus;
import pers.yan.sblog.service.eventbus.event.OperateLogEvent;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.sql.Date;
import java.time.Instant;

/**
 * 日志事件监听
 *
 * @author likaiyan
 * @date 2021/8/7 2:21 下午
 */
@SuppressWarnings("UnstableApiUsage")
@Slf4j
@Component
public class OperateLogListener {

    @Autowired
    private LogRepository logRepository;

    @PostConstruct
    public void init() {
        SblogEventBus.SblogEventBus.register(this);
    }

    @Subscribe
    public void action(OperateLogEvent operateLogEvent) {
        OperateLog operateLog = new OperateLog();
        operateLog.setCreateTime(Date.from(Instant.now()));
        operateLog.setOperateType(operateLogEvent.getOperateType());
        operateLog.setCreator(operateLogEvent.getOperator().getUsername() + "[" + operateLogEvent.getOperator().getUserId() + "]");

        if (OperateType.CREATE.equals(operateLogEvent.getOperateType()) || OperateType.UPDATE.equals(operateLogEvent.getOperateType())) {
            operateLog.setEntityClass(ResolvableType.forInstance(operateLogEvent.getNewEntity()).resolve().getName());
            operateLog.setEntityId(getEntityId(operateLogEvent.getNewEntity()));
            operateLog.setContent(new Gson().toJson(operateLogEvent.getNewEntity()));
        }

        if (OperateType.DELETE.equals(operateLog.getOperateType())) {
            operateLog.setEntityClass(ResolvableType.forInstance(operateLogEvent.getNewEntity()).resolve().getName());
            operateLog.setEntityId(operateLogEvent.getOldEntity().toString());
        }

        logRepository.insert(operateLog);
    }

    private String getEntityId(Object entity) {
        Field[] fields = entity.getClass().getDeclaredFields();
        if (fields.length > 0) {
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(TableField.class)) {
                    try {
                        return String.valueOf(field.get(entity));
                    } catch (IllegalAccessException e) {
                        log.error("记录操作日志获取主键失败", e);
                    }
                    return null;
                }
            }
        }
        return null;
    }

    private String getCompareResult(Object newEntity, Object oldEntity) {
        if (!newEntity.getClass().equals(oldEntity.getClass())) {
            return null;
        }

        Field[] fields = newEntity.getClass().getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        if (fields.length > 0) {
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(LogCompare.class)) {
                    try {
                        Object oldValue = field.get(oldEntity);
                        Object newValue = field.get(newEntity);
                        if ((oldValue != null && !oldValue.equals(newValue))
                                || (newValue != null && !newValue.equals(oldValue))) {
                            sb.append(field.getAnnotation(LogCompare.class).value())
                                    .append(":[").append(oldValue).append("]=>[").append(newValue).append("] ");
                        }
                    } catch (IllegalAccessException e) {
                        log.error("记录操作日志获取新旧值对比失败", e);
                    }

                }
            }
        }
        return sb.toString();
    }

}
