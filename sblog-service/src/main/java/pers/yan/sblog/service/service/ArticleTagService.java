package pers.yan.sblog.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.yan.sblog.common.dto.ArticleDTO;
import pers.yan.sblog.common.dto.ArticleTagDTO;
import pers.yan.sblog.common.dto.ArticleTagQuery;
import pers.yan.sblog.common.entity.ArticleTag;
import pers.yan.sblog.common.vo.ArticleTagVO;
import pers.yan.sblog.common.vo.BasePage;

/**
 * 文章标签service
 *
 * @author likaiyan
 * @date 2021/8/9 4:20 下午
 */
public interface ArticleTagService extends IService<ArticleTag> {

    /**
     * 查询文章标签
     *
     * @param articleTagQuery 查询参数
     * @param page            页码
     * @param size            容量
     * @return 分页
     */
    BasePage<ArticleTagVO> findArticleTagVoByPage(ArticleTagQuery articleTagQuery, int page, int size);

    /**
     * 查询文章标签
     *
     * @param articleTagId 标签id
     * @return 标签vo
     */
    ArticleTagVO findArticleTagVoById(int articleTagId);

    /**
     * 添加文章标签
     *
     * @param articleDTO 标签参数
     * @return 标签vo
     */
    ArticleTagVO addArticleTag(ArticleDTO articleDTO);

    /**
     * 更新文章标签
     *
     * @param articleTagId  标签id
     * @param articleTagDTO 参数
     * @return 标签vo
     */
    ArticleTagVO updateArticleTag(int articleTagId, ArticleTagDTO articleTagDTO);

    /**
     * 删除文章标签
     *
     * @param articleTagId 标签id
     * @return boolean
     */
    boolean deleteArticleTag(int articleTagId);

}
