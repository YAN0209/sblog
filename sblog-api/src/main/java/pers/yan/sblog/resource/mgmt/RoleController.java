package pers.yan.sblog.resource.mgmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.yan.sblog.common.dto.RoleDTO;
import pers.yan.sblog.common.dto.RoleQuery;
import pers.yan.sblog.common.exception.SBlogException;
import pers.yan.sblog.common.vo.ApiResult;
import pers.yan.sblog.common.vo.BasePage;
import pers.yan.sblog.common.vo.RoleVO;
import pers.yan.sblog.service.RoleService;

import java.util.Optional;

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
    public ApiResult<BasePage<RoleVO>> findRoleVoByPage(RoleQuery roleQuery,
                                                  @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                                  @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        return ApiResult.ok(roleService.findRoleVoByPage(roleQuery, page, size));
    }

    @GetMapping("/{roleId}")
    public ApiResult<RoleVO> findRoleVoByRoleId(@PathVariable("roleId") Integer roleId) {
        return ApiResult.ok(roleService.findRoleVoByRoleId(roleId));
    }

    @PostMapping("")
    public ApiResult<RoleVO> addRole(@RequestBody RoleDTO roleDTO) throws SBlogException {
        return ApiResult.ok(roleService.addRole(roleDTO));
    }

    @PutMapping("")
    public ApiResult<RoleVO> updateRole(@RequestBody RoleDTO roleDTO) throws SBlogException {
        Optional.ofNullable(roleDTO.getRoleId()).orElseThrow(() -> new SBlogException("roleId不能为空"));
        return ApiResult.ok(roleService.updateRole(roleDTO));
    }

    @DeleteMapping("")
    public ApiResult<Boolean> deleteRole(@RequestBody RoleDTO roleDTO) throws SBlogException {
        Optional.ofNullable(roleDTO.getRoleId()).orElseThrow(() -> new SBlogException("角色id不能为空"));
        return ApiResult.ok(roleService.deleteRole(roleDTO));
    }

}
