package pers.yan.sblog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.yan.sblog.common.entity.Comment;

/**
 * @author likaiyan
 * @date 2021/7/14 6:30 下午
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}