package pers.yan.sblog.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.yan.sblog.common.dto.PermissionDTO;
import pers.yan.sblog.common.dto.PermissionQuery;
import pers.yan.sblog.common.entity.Permission;
import pers.yan.sblog.common.exception.SBlogException;
import pers.yan.sblog.common.vo.BasePage;
import pers.yan.sblog.common.vo.PermissionVO;

/**
 * 权限service
 *
 * @author likaiyan
 * @date 2021/7/31 11:34 下午
 */
public interface PermissionService extends IService<Permission> {

    /**
     * 查询权限
     *
     * @param permissionQuery 参数
     * @param page            页码
     * @param size            容量
     * @return 权限vo
     */
    BasePage<PermissionVO> findPermissionVoByPage(PermissionQuery permissionQuery, int page, int size);

    /**
     * 查询权限详情
     *
     * @param permissionId 权限id
     * @return 权限vo
     */
    PermissionVO findPermissionVoByPermissionId(int permissionId);

    /**
     * 添加权限
     *
     * @param permissionDTO 权限传输类
     * @return 权限vo
     */
    PermissionVO addPermission(PermissionDTO permissionDTO);

    /**
     * 更新权限
     *
     * @param permissionId  权限id
     * @param permissionDTO 权限传输类
     * @return 权限vo
     * @throws SBlogException 权限不存在
     */
    PermissionVO updatePermission(Integer permissionId, PermissionDTO permissionDTO) throws SBlogException;

    /**
     * 删除权限
     *
     * @param permissionId 权限id
     * @return boolean
     * @throws SBlogException 权限不存在
     */
    boolean deletePermission(Integer permissionId) throws SBlogException;
}