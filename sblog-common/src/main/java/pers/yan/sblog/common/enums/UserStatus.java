package pers.yan.sblog.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户状态
 *
 * @author likaiyan
 * @date 2021/7/23 11:45 上午
 */
@Getter
@AllArgsConstructor
public enum UserStatus {
    /**
     * 正常
     */
    NORMAL(0),
    /**
     * 锁
     */
    LOCK(1);

    @EnumValue
    @JsonValue
    private final int value;
}
