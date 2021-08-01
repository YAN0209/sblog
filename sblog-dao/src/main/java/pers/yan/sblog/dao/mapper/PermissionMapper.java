package pers.yan.sblog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pers.yan.sblog.common.dto.PermissionQuery;
import pers.yan.sblog.common.entity.Permission;
import pers.yan.sblog.common.vo.PermissionVO;

import java.util.List;

/**
 * @author likaiyan
 * @date 2021/7/23 2:08 下午
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    List<PermissionVO> findPermissionVoByRoleId(@Param("roleId") Integer roleId);

    void findPermissionVoByPage(Page<PermissionVO> permissionPage, @Param("permissionQuery") PermissionQuery permissionQuery);

    PermissionVO findPermissionVoByPermissionId(@Param("permissionId") Integer permissionId);
}