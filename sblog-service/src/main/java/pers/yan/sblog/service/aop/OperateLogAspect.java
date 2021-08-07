package pers.yan.sblog.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.yan.sblog.common.enums.OperateType;
import pers.yan.sblog.dao.repository.LogRepository;
import pers.yan.sblog.service.eventbus.SblogEventBus;
import pers.yan.sblog.service.eventbus.event.OperateLogEvent;
import pers.yan.sblog.util.UserUtil;

/**
 * 记录操作日志
 *
 * @author likaiyan
 * @date 2021/8/7 1:40 下午
 */
@Aspect
@Component
public class OperateLogAspect {

    @Autowired
    private LogRepository logRepository;

    @Pointcut("execution(* com.baomidou.mybatisplus.core.mapper.BaseMapper.insert(..))")
    public void insert() {
    }

    @Pointcut("execution(* com.baomidou.mybatisplus.core.mapper.BaseMapper.deleteById(..))")
    public void deleteById() {
    }

    @Pointcut("execution(* com.baomidou.mybatisplus.core.mapper.BaseMapper.updateById(..))")
    public void updateById() {
    }

    @AfterReturning(pointcut = "insert()")
    public void afterReturningInsert(JoinPoint joinPoint) {
        Object arg = joinPoint.getArgs()[0];
        OperateLogEvent event = new OperateLogEvent();
        event.setOperateType(OperateType.CREATE);
        event.setNewEntity(arg);
        event.setOperator(UserUtil.getCurrentUser());
        SblogEventBus.post(event);
    }

    @AfterReturning("updateById()")
    public void beforeUpdateById(JoinPoint joinPoint) {
        Object arg = joinPoint.getArgs()[0];
        OperateLogEvent event = new OperateLogEvent();
        event.setOperateType(OperateType.UPDATE);
        event.setNewEntity(arg);
        event.setOperator(UserUtil.getCurrentUser());
        SblogEventBus.post(event);
    }

    @AfterReturning(pointcut = "deleteById()")
    public void deleteById(JoinPoint joinPoint) {
        Object arg = joinPoint.getArgs()[0];
        OperateLogEvent event = new OperateLogEvent();
        event.setOperateType(OperateType.DELETE);
        event.setOldEntity(arg);
        event.setOperator(UserUtil.getCurrentUser());
        SblogEventBus.post(event);
    }

}
