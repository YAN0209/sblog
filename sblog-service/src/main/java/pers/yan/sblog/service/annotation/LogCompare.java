package pers.yan.sblog.service.annotation;

import java.lang.annotation.*;

/**
 * 日志记录
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogCompare {
    /**
     * 字段名
     *
     * @return 字段名
     */
    String value() default "";
}
