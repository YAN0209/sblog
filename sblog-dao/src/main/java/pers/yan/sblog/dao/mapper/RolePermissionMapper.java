package pers.yan.sblog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pers.yan.sblog.common.entity.RolePermission;

/**
 * 角色权限mapper
 *
 * @author likaiyan
 * @date 2021/7/23 3:55 下午
 */
@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

    /**
     * 删除角色权限
     *
     * @param roleId 角色id
     * @return boolean
     */
    boolean deleteByRoleId(@Param("roleId") Integer roleId);

    /**
     * 删除角色权限
     *
     * @param permissionId 权限id
     * @return boolean
     */
    boolean deleteByPermissionId(@Param("permissionId") Integer permissionId);

}