package pers.yan.sblog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pers.yan.sblog.common.dto.UserQuery;
import pers.yan.sblog.common.entity.User;
import pers.yan.sblog.common.vo.UserVO;

/**
 * @author likaiyan
 * @date 2021/7/23 2:07 下午
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 分页查询用户
     *
     * @param page      分页实体
     * @param userQuery 查询参数
     */
    Page<UserVO> findUserVoByPage(Page<UserVO> page, @Param("param") UserQuery userQuery);

    /**
     * 查询用户
     *
     * @param userId 用户id
     * @return 用户VO
     */
    UserVO findUserVoById(@Param("userId") int userId);

    /**
     * 查询用户
     *
     * @param loginName 登录名
     * @return user
     */
    User findUserByLoginName(@Param("loginName") String loginName);

    /**
     * 查询用户
     *
     * @param loginName 登录名
     * @return userVO
     */
    UserVO findUserVoByLoginName(@Param("loginName") String loginName);
}