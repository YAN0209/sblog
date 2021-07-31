package pers.yan.sblog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pers.yan.sblog.common.dto.RoleQuery;
import pers.yan.sblog.common.entity.Role;
import pers.yan.sblog.common.vo.RoleVO;

import java.util.List;

/**
 * @author likaiyan
 * @date 2021/7/23 2:09 下午
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 查询角色
     *
     * @param userId 用户id
     * @return 角色列表
     */
    List<RoleVO> findRoleVoByUserId(@Param("userId") Integer userId);

    /**
     * 查询角色
     *
     * @param page      分页
     * @param roleQuery 查询参数
     */
    void findRoleVoByPage(Page<RoleVO> page, @Param("roleQuery") RoleQuery roleQuery);

    /**
     * 查询角色
     *
     * @param roleId 角色id
     * @return 角色
     */
    RoleVO findRoleVoByRoleId(@Param("roleId") Integer roleId);
}