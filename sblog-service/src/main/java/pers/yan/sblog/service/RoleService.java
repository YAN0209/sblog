package pers.yan.sblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.yan.sblog.common.dto.RoleDTO;
import pers.yan.sblog.common.dto.RoleQuery;
import pers.yan.sblog.common.entity.Role;
import pers.yan.sblog.common.exception.SBlogException;
import pers.yan.sblog.common.vo.BasePage;
import pers.yan.sblog.common.vo.RoleVO;

/**
 * 角色service
 *
 * @author likaiyan
 * @date 2021/7/31 8:43 下午
 */
public interface RoleService extends IService<Role> {

    /**
     * 查询角色
     *
     * @param roleQuery 查询参数
     * @return 分页
     */
    BasePage<RoleVO> findRoleVoByPage(RoleQuery roleQuery, int page, int size);

    /**
     * 查询角色详情
     *
     * @param roleId 角色id
     * @return 角色
     */
    RoleVO findRoleVoByRoleId(int roleId);

    /**
     * 添加角色
     *
     * @param roleDTO 角色参数
     * @return 角色
     * @throws SBlogException 权限不存在
     */
    RoleVO addRole(RoleDTO roleDTO) throws SBlogException;

    /**
     * 更新角色
     *
     * @param roleId  角色id
     * @param roleDTO 角色参数
     * @return 角色
     * @throws SBlogException 角色不存在/权限不存在
     */
    RoleVO updateRole(Integer roleId, RoleDTO roleDTO) throws SBlogException;

    /**
     * 删除角色
     *
     * @param roleId  角色id
     * @return boolean
     * @throws SBlogException 角色不存在
     */
    boolean deleteRole(Integer roleId) throws SBlogException;

}