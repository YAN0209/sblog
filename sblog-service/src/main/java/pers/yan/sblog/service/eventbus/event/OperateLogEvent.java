package pers.yan.sblog.service.eventbus.event;

import lombok.Data;
import pers.yan.sblog.common.entity.User;
import pers.yan.sblog.common.enums.OperateType;

/**
 * 日志事件
 *
 * @author likaiyan
 * @date 2021/8/7 2:24 下午
 */
@Data
public class OperateLogEvent implements SblogEvent {

    /**
     * 操作类型
     */
    private OperateType operateType;

    /**
     * 新实体
     */
    private Object newEntity;

    /**
     * 旧实体
     */
    private Object oldEntity;

    /**
     * 操作人
     */
    private User operator;
}
