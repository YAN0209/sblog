package pers.yan.sblog.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yan.sblog.common.enums.OrderType;
import pers.yan.sblog.common.enums.State;

/**
 * 文章
 *
 * @author likaiyan
 * @date 2021/7/11 5:53 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("article")
public class Article extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Integer articleId;

    /**
     * 标题
     */
    private String title;

    /**
     * 简介
     */
    private String introduce;

    /**
     * 封面
     */
    private String cover;

    /**
     * 内容
     */
    private String content;

    /**
     * 状态
     */
    private State state;

    /**
     * 排序类型
     */
    private OrderType orderType;

    /**
     * 排序id
     */
    private Integer orderId;

    /**
     * 观看数
     */
    private Integer viewCount;

    /**
     * 评论数
     */
    private Integer commentCount;

    /**
     * 点赞数
     */
    private Integer likeCount;

}

