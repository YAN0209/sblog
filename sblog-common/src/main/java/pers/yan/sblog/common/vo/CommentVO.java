package pers.yan.sblog.common.vo;

import lombok.Data;
import pers.yan.sblog.common.enums.CommentType;

/**
 * @author likaiyan
 * @date 2021/7/14 6:15 下午
 */
@Data
public class CommentVO extends BaseVO {

    private Integer commentId;

    private Integer articleId;

    private String content;

    private CommentType commentType;

    private String replyCommentNickName;

    private String nickName;


}
