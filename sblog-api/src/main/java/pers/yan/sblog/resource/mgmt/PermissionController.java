package pers.yan.sblog.resource.mgmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pers.yan.sblog.common.dto.PermissionDTO;
import pers.yan.sblog.common.dto.PermissionQuery;
import pers.yan.sblog.common.exception.SBlogException;
import pers.yan.sblog.common.vo.ApiResult;
import pers.yan.sblog.common.vo.BasePage;
import pers.yan.sblog.common.vo.PermissionVO;
import pers.yan.sblog.service.service.PermissionService;

/**
 * 权限controller
 *
 * @author likaiyan
 * @date 2021/7/31 11:32 下午
 */
@RestController
@RequestMapping("/mgmt/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("")
    @PreAuthorize("hasRole('permissionAdmin') || hasAuthority('permission::view')")
    public ApiResult<BasePage<PermissionVO>> findPermissionVoByPage(PermissionQuery permissionQuery,
                                                                    @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                                                    @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        return ApiResult.ok(permissionService.findPermissionVoByPage(permissionQuery, page, size));
    }

    @GetMapping("/{permissionId}")
    @PreAuthorize("hasRole('permissionAdmin') || hasAuthority('permission::view')")
    public ApiResult<PermissionVO> findPermissionVoByPermissionId(@PathVariable("permissionId") Integer permissionId) {
        return ApiResult.ok(permissionService.findPermissionVoByPermissionId(permissionId));
    }

    @PostMapping("")
    @PreAuthorize("hasRole('permissionAdmin') || hasAuthority('permission::add')")
    public ApiResult<PermissionVO> addPermission(@RequestBody PermissionDTO permissionDTO) {
        return ApiResult.ok(permissionService.addPermission(permissionDTO));
    }

    @PutMapping("/{permissionId}")
    @PreAuthorize("hasRole('permissionAdmin') || hasAuthority('permission::update')")
    public ApiResult<PermissionVO> updatePermission(@PathVariable("permissionId") Integer permissionId,
                                                    @RequestBody PermissionDTO permissionDTO) throws SBlogException {
        return ApiResult.ok(permissionService.updatePermission(permissionId, permissionDTO));
    }

    @DeleteMapping("/{permissionId}")
    @PreAuthorize("hasRole('permissionAdmin') || hasAuthority('permission::delete')")
    public ApiResult<Boolean> deletePermission(@PathVariable("permissionId") Integer permissionId) throws SBlogException {
        return ApiResult.ok(permissionService.deletePermission(permissionId));
    }

}
