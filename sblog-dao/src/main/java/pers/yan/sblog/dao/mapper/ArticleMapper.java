package pers.yan.sblog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.yan.sblog.common.entity.Article;

/**
 * @author likaiyan
 * @date 2021/7/14 6:27 下午
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}
