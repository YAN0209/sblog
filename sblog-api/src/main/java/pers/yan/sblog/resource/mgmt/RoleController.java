package pers.yan.sblog.resource.mgmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pers.yan.sblog.common.dto.RoleDTO;
import pers.yan.sblog.common.dto.RoleQuery;
import pers.yan.sblog.common.exception.SBlogException;
import pers.yan.sblog.common.vo.ApiResult;
import pers.yan.sblog.common.vo.BasePage;
import pers.yan.sblog.common.vo.RoleVO;
import pers.yan.sblog.service.service.RoleService;

/**
 * 角色controller
 *
 * @author likaiyan
 * @date 2021/7/31 8:42 下午
 */
@RestController
@RequestMapping("/mgmt/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("")
    @PreAuthorize("hasRole('roleAdmin') || hasAuthority('role::view')")
    public ApiResult<BasePage<RoleVO>> findRoleVoByPage(RoleQuery roleQuery,
                                                        @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                                        @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        return ApiResult.ok(roleService.findRoleVoByPage(roleQuery, page, size));
    }

    @GetMapping("/{roleId}")
    @PreAuthorize("hasRole('roleAdmin') || hasAuthority('role::view')")
    public ApiResult<RoleVO> findRoleVoByRoleId(@PathVariable("roleId") Integer roleId) {
        return ApiResult.ok(roleService.findRoleVoByRoleId(roleId));
    }

    @PostMapping("")
    @PreAuthorize("hasRole('roleAdmin') || hasAuthority('role::add')")
    public ApiResult<RoleVO> addRole(@RequestBody RoleDTO roleDTO) throws SBlogException {
        return ApiResult.ok(roleService.addRole(roleDTO));
    }

    @PutMapping("/{roleId}")
    @PreAuthorize("hasRole('roleAdmin') || hasAuthority('role::update')")
    public ApiResult<RoleVO> updateRole(@PathVariable("roleId") Integer roleId, @RequestBody RoleDTO roleDTO) throws SBlogException {
        return ApiResult.ok(roleService.updateRole(roleId, roleDTO));
    }

    @DeleteMapping("/{roleId}")
    @PreAuthorize("hasRole('roleAdmin') || hasAuthority('role::delete')")
    public ApiResult<Boolean> deleteRole(@PathVariable("roleId") Integer roleId) throws SBlogException {
        return ApiResult.ok(roleService.deleteRole(roleId));
    }

}
