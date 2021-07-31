package pers.yan.sblog.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.yan.sblog.common.dto.PermissionDTO;
import pers.yan.sblog.common.dto.PermissionQuery;
import pers.yan.sblog.common.entity.Permission;
import pers.yan.sblog.common.exception.SBlogException;
import pers.yan.sblog.common.vo.BasePage;
import pers.yan.sblog.common.vo.PermissionVO;
import pers.yan.sblog.dao.mapper.PermissionMapper;
import pers.yan.sblog.service.PermissionService;
import pers.yan.sblog.util.PageUtil;

/**
 * @author likaiyan
 * @date 2021/7/31 11:44 下午
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Override
    public BasePage<PermissionVO> findPermissionVoByPage(PermissionQuery permissionQuery, int page, int size) {
        Page<PermissionVO> permissionPage = Page.of(page, size);

        return PageUtil.convert(permissionPage);
    }

    @Override
    public PermissionVO findPermissionVoByPermissionId(int permissionId) {
        throw new UnsupportedOperationException("Method not implemented.");
    }

    @Override
    public PermissionVO addPermission(PermissionDTO permissionDTO) {
        throw new UnsupportedOperationException("Method not implemented.");
    }

    @Override
    public PermissionVO updatePermission(PermissionDTO permissionDTO) throws SBlogException {
        throw new UnsupportedOperationException("Method not implemented.");
    }

    @Override
    public boolean deletePermission(PermissionDTO permissionDTO) throws SBlogException {
        throw new UnsupportedOperationException("Method not implemented.");
    }
}
