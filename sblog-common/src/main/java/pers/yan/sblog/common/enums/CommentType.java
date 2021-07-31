package pers.yan.sblog.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 评论类型
 *
 * @author likaiyan
 * @date 2021/7/14 4:16 下午
 */
@Getter
@AllArgsConstructor
public enum CommentType {
    /**
     * 新建
     */
    NEW(0),
    /**
     * 回复
     */
    REPLY(1);

    @EnumValue
    @JsonValue
    private final Integer value;
}
