package pers.yan.sblog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pers.yan.sblog.common.dto.ArticleTagQuery;
import pers.yan.sblog.common.entity.ArticleTag;
import pers.yan.sblog.common.vo.ArticleTagVO;

/**
 * @author likaiyan
 * @date 2021/7/14 6:29 下午
 */
@Mapper
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {

    Page<ArticleTagVO> findArticleTagVoByPage(Page<ArticleTagVO> page, @Param("param") ArticleTagQuery query);

}