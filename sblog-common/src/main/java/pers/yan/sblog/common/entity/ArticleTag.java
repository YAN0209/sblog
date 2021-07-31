package pers.yan.sblog.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yan.sblog.common.enums.OrderType;
import pers.yan.sblog.common.enums.State;

/**
 * 文章标签
 *
 * @author likaiyan
 * @date 2021/7/12 9:41 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("article_tag")
public class ArticleTag extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Integer tagId;

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
