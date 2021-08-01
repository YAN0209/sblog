package pers.yan.sblog.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yan.sblog.common.dto.PermissionDTO;
import pers.yan.sblog.common.dto.PermissionQuery;
import pers.yan.sblog.common.entity.Permission;
import pers.yan.sblog.common.exception.SBlogException;
import pers.yan.sblog.common.vo.BasePage;
import pers.yan.sblog.common.vo.PermissionVO;
import pers.yan.sblog.dao.mapper.PermissionMapper;
import pers.yan.sblog.dao.mapper.RolePermissionMapper;
import pers.yan.sblog.service.PermissionService;
import pers.yan.sblog.util.PageUtil;

import java.util.Optional;

/**
 * @author likaiyan
 * @date 2021/7/31 11:44 下午
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public BasePage<PermissionVO> findPermissionVoByPage(PermissionQuery permissionQuery, int page, int size) {
        Page<PermissionVO> permissionPage = Page.of(page, size);
        this.baseMapper.findPermissionVoByPage(permissionPage, permissionQuery);
        return PageUtil.convert(permissionPage);
    }

    @Override
    public PermissionVO findPermissionVoByPermissionId(int permissionId) {
        return this.baseMapper.findPermissionVoByPermissionId(permissionId);
    }

    @Override
    public PermissionVO addPermission(PermissionDTO permissionDTO) {
        Permission permission = new Permission();
        BeanUtils.copyProperties(permissionDTO, permission);
        this.save(permission);

        return this.baseMapper.findPermissionVoByPermissionId(permission.getPermissionId());
    }

    @Override
    public PermissionVO updatePermission(Integer permissionId, PermissionDTO permissionDTO) throws SBlogException {
        Permission permission = Optional.ofNullable(this.getById(permissionId))
                .orElseThrow(() -> new SBlogException("权限不存在"));

        BeanUtils.copyProperties(permissionDTO, permission);
        this.updateById(permission);

        return this.baseMapper.findPermissionVoByPermissionId(permission.getPermissionId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deletePermission(Integer permissionId) throws SBlogException {
        boolean deleteSuccess = this.removeById(permissionId);
        if (!deleteSuccess) {
            throw new SBlogException("权限不存在");
        }

        return rolePermissionMapper.deleteByPermissionId(permissionId);
    }
}
