package pers.yan.sblog.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yan.sblog.common.dto.RoleDTO;
import pers.yan.sblog.common.dto.RoleQuery;
import pers.yan.sblog.common.entity.Permission;
import pers.yan.sblog.common.entity.Role;
import pers.yan.sblog.common.entity.RolePermission;
import pers.yan.sblog.common.exception.SBlogException;
import pers.yan.sblog.common.vo.BasePage;
import pers.yan.sblog.common.vo.RoleVO;
import pers.yan.sblog.dao.mapper.PermissionMapper;
import pers.yan.sblog.dao.mapper.RoleMapper;
import pers.yan.sblog.dao.mapper.RolePermissionMapper;
import pers.yan.sblog.service.RoleService;
import pers.yan.sblog.util.PageUtil;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author likaiyan
 * @date 2021/7/31 8:50 下午
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public BasePage<RoleVO> findRoleVoByPage(RoleQuery roleQuery, int page, int size) {
        Page<RoleVO> rolePage = Page.of(page, size);
        this.baseMapper.findRoleVoByPage(rolePage, roleQuery);
        return PageUtil.convert(rolePage);
    }

    @Override
    public RoleVO findRoleVoByRoleId(int roleId) {
        return this.baseMapper.findRoleVoByRoleId(roleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RoleVO addRole(RoleDTO roleDTO) throws SBlogException {
        checkPermissionExists(roleDTO.getPermissions());

        Role role = new Role();
        BeanUtils.copyProperties(roleDTO, role);
        this.save(role);

        roleDTO.getPermissions().forEach(permissionId -> {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(role.getRoleId());
            rolePermission.setPermissionId(permissionId);
            rolePermissionMapper.insert(rolePermission);
        });

        return this.baseMapper.findRoleVoByRoleId(role.getRoleId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RoleVO updateRole(RoleDTO roleDTO) throws SBlogException {
        Role role = Optional.ofNullable(this.getById(roleDTO.getRoleId()))
                .orElseThrow(() -> new SBlogException("角色不存在"));

        checkPermissionExists(roleDTO.getPermissions());

        BeanUtils.copyProperties(roleDTO, role);
        this.updateById(role);

        List<Permission> permissions = permissionMapper.selectBatchIds(roleDTO.getPermissions());
        if (permissions.size() != roleDTO.getPermissions().size()) {
            Set<Integer> existPermissionIds = permissions.stream().map(Permission::getPermissionId).collect(Collectors.toSet());
            throw new SBlogException(String.format("权限id【%s】不存在",
                    roleDTO.getPermissions().stream().filter(permissionId -> !existPermissionIds.contains(permissionId))
                            .map(String::valueOf).collect(Collectors.joining(","))));
        }

        return this.baseMapper.findRoleVoByRoleId(role.getRoleId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteRole(RoleDTO roleDTO) throws SBlogException {
        boolean deleteSuccess = this.removeById(roleDTO.getRoleId());
        if (!deleteSuccess) {
            throw new SBlogException("用户不存在");
        }

        rolePermissionMapper.deleteByRoleId(roleDTO.getRoleId());

        return true;
    }

    private void checkPermissionExists(List<Integer> permissionIds) throws SBlogException {
        if (CollectionUtils.isNotEmpty(permissionIds)) {
            List<Permission> permissions = permissionMapper.selectBatchIds(permissionIds);
            if (permissions.size() != permissionIds.size()) {
                Set<Integer> existPermissionIds = permissions.stream().map(Permission::getPermissionId).collect(Collectors.toSet());
                throw new SBlogException(String.format("权限id【%s】不存在",
                        permissionIds.stream().filter(permissionId -> !existPermissionIds.contains(permissionId))
                                .map(String::valueOf).collect(Collectors.joining(","))));
            }
        }
    }

}
