package pers.yan.sblog.service.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pers.yan.sblog.common.dto.ArticleDTO;
import pers.yan.sblog.common.dto.ArticleTagDTO;
import pers.yan.sblog.common.dto.ArticleTagQuery;
import pers.yan.sblog.common.entity.ArticleTag;
import pers.yan.sblog.common.vo.ArticleTagVO;
import pers.yan.sblog.common.vo.BasePage;
import pers.yan.sblog.dao.mapper.ArticleTagMapper;
import pers.yan.sblog.service.service.ArticleTagService;
import pers.yan.sblog.util.PageUtil;

/**
 * @author likaiyan
 * @date 2021/8/9 5:24 下午
 */
@Service
@Slf4j
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements ArticleTagService {

    @Override
    public BasePage<ArticleTagVO> findArticleTagVoByPage(ArticleTagQuery articleTagQuery, int page, int size) {
        Page<ArticleTagVO> articleTagVoPage = Page.of(page, size);
        this.baseMapper.findArticleTagVoByPage(articleTagVoPage, articleTagQuery);
        return PageUtil.convert(articleTagVoPage);
    }

    @Override
    public ArticleTagVO findArticleTagVoById(int articleTagId) {
        return null;
    }

    @Override
    public ArticleTagVO addArticleTag(ArticleDTO articleDTO) {
        return null;
    }

    @Override
    public ArticleTagVO updateArticleTag(int articleTagId, ArticleTagDTO articleTagDTO) {
        return null;
    }

    @Override
    public boolean deleteArticleTag(int articleTagId) {
        return false;
    }
}
