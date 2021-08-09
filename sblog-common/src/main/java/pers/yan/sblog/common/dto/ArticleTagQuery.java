package pers.yan.sblog.common.dto;

import lombok.Data;
import pers.yan.sblog.common.enums.OrderType;
import pers.yan.sblog.common.enums.State;

/**
 * 文章标签查询
 *
 * @author likaiyan
 * @date 2021/8/9 4:23 下午
 */
@Data
public class ArticleTagQuery {

    /**
     * 标签编码
     */
    private String tagCode;

    /**
     * 标签名
     */
    private String name;

    /**
     * 排序类型
     */
    private OrderType orderType;

    /**
     * 状态
     */
    private State state;
}
