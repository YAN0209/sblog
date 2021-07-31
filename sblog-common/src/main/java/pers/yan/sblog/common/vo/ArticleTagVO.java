package pers.yan.sblog.common.vo;

import lombok.Data;
import pers.yan.sblog.common.enums.OrderType;

/**
 * @author likaiyan
 * @date 2021/7/14 5:58 下午
 */
@Data
public class ArticleTagVO extends BaseVO {

    private Integer tagId;

    private String tagCode;

    private String name;

    private OrderType orderType;

    private Integer orderId;

}
