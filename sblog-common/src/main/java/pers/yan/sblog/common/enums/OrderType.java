package pers.yan.sblog.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 排序类型
 *
 * @author likaiyan
 * @date 2021/7/12 9:53 上午
 */
@Getter
@AllArgsConstructor
public enum OrderType {
    /**
     * 正常
     */
    NORMAL(0),
    /**
     * 置顶
     */
    TOP(1);

    @EnumValue
    @JsonValue
    private final int value;
}
