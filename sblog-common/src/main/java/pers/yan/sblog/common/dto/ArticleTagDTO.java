package pers.yan.sblog.common.dto;

import pers.yan.sblog.common.enums.OrderType;
import pers.yan.sblog.common.enums.State;

/**
 * 文章标签传输类
 *
 * @author likaiyan
 * @date 2021/8/9 4:29 下午
 */
public class ArticleTagDTO {
    
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
     * 排序id
     */
    private Integer orderId;

    /**
     * 状态
     */
    private State state;
}
