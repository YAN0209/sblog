package pers.yan.sblog.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 通用状态
 *
 * @author likaiyan
 * @date 2021/7/11 6:04 下午
 */
@Getter
@AllArgsConstructor
public enum State {
    /**
     * 未发布
     */
    UNPUBLISHED(0),
    /**
     * 已发布
     */
    RELEASED(1);

    @EnumValue
    @JsonValue
    private final int value;
}
