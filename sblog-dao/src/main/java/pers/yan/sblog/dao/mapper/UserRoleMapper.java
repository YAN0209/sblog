package pers.yan.sblog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pers.yan.sblog.common.entity.UserRole;

import java.util.List;

/**
 * @author likaiyan
 * @date 2021/7/23 3:31 下午
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 查询用户角色
     *
     * @param userId 用户id
     * @param roleId 角色id
     * @return 用户角色
     */
    UserRole findByUserIdAndRoleId(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    /**
     * 查询用户角色
     *
     * @param userId 用户id
     * @return 用户角色
     */
    List<UserRole> findByUserId(@Param("userId") Integer userId);

    /**
     * 删除
     *
     * @param userId 用户id
     * @return boolean
     */
    boolean deleteByUserId(@Param("userId") Integer userId);
}