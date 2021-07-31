package pers.yan.sblog.common.vo;

import lombok.Data;
import pers.yan.sblog.common.enums.OrderType;

/**
 * @author likaiyan
 * @date 2021/7/12 10:37 上午
 */
@Data
public class ArticleVO extends BaseVO {

    private Integer articleId;

    private String title;

    private String cover;

    private String introduce;

    private String content;

    private OrderType orderType;

    private Integer orderId;

    private Integer viewCount;

    private Integer commentCount;

    private Integer likeCount;
}
