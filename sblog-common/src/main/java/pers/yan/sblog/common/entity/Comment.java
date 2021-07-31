package pers.yan.sblog.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yan.sblog.common.enums.CommentType;
import pers.yan.sblog.common.enums.State;

/**
 * 评论
 *
 * @author likaiyan
 * @date 2021/7/14 4:13 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("comment")
public class Comment extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Integer commentId;

    /**
     * 文章id
     */
    private Integer articleId;

    /**
     * 内容
     */
    private String content;

    /**
     * 评论类型
     */
    private CommentType commentType;

    /**
     * 回复评论id
     */
    private Integer replyCommentId;

    /**
     * 回复人姓名
     */
    private String nickName;

    /**
     * 邮件
     */
    private String email;

    /**
     * 状态
     */
    private State state;

}
