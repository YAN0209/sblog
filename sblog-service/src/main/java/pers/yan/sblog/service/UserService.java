package pers.yan.sblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.yan.sblog.common.dto.UserDTO;
import pers.yan.sblog.common.dto.UserQuery;
import pers.yan.sblog.common.entity.User;
import pers.yan.sblog.common.exception.SBlogException;
import pers.yan.sblog.common.vo.BasePage;
import pers.yan.sblog.common.vo.UserVO;

/**
 * @author likaiyan
 * @date 2021/7/23 2:10 下午
 */
public interface UserService extends IService<User> {

    /**
     * 分页查询用户
     *
     * @param page      页码
     * @param size      容量
     * @param userQuery 参数
     * @return 分页用户
     */
    BasePage<UserVO> findByPage(int page, int size, UserQuery userQuery);

    /**
     * 查询用户
     *
     * @param userId 用户id
     * @return 用户
     */
    UserVO findById(int userId);

    /**
     * 添加用户
     *
     * @param userDTO 用户信息
     * @return 用户信息
     * @throws SBlogException 角色不存在
     */
    UserVO addUser(UserDTO userDTO) throws SBlogException;

    /**
     * 更新用户
     *
     * @param userDTO 用户信息
     * @return 用户信息
     * @throws SBlogException 用户不存在/角色不存在
     */
    UserVO updateUser(UserDTO userDTO) throws SBlogException;

    /**
     * 删除用户
     *
     * @param userDTO 用户信息
     * @return boolean
     * @throws SBlogException 用户不存在
     */
    Boolean deleteUser(UserDTO userDTO) throws SBlogException;

}