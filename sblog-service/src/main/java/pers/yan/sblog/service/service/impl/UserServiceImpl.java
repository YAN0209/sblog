package pers.yan.sblog.service.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yan.sblog.common.constant.Constant;
import pers.yan.sblog.common.dto.UserDTO;
import pers.yan.sblog.common.dto.UserQuery;
import pers.yan.sblog.common.entity.Role;
import pers.yan.sblog.common.entity.User;
import pers.yan.sblog.common.entity.UserRole;
import pers.yan.sblog.common.exception.SBlogException;
import pers.yan.sblog.common.vo.BasePage;
import pers.yan.sblog.common.vo.UserVO;
import pers.yan.sblog.dao.mapper.RoleMapper;
import pers.yan.sblog.dao.mapper.UserMapper;
import pers.yan.sblog.dao.mapper.UserRoleMapper;
import pers.yan.sblog.service.service.UserService;
import pers.yan.sblog.util.PageUtil;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 用户service
 *
 * @author likaiyan
 * @date 2021/7/23 2:19 下午
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public BasePage<UserVO> findByPage(int page, int size, UserQuery userQuery) {
        Page<UserVO> userVoPage = new Page<>(page, size);
        this.baseMapper.findUserVoByPage(userVoPage, userQuery);
        return PageUtil.convert(userVoPage);
    }

    @Override
    public UserVO findById(int userId) {
        return this.baseMapper.findUserVoById(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserVO addUser(UserDTO userDTO) throws SBlogException {
        checkRoleExists(userDTO.getRoles());

        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        this.save(user);

        userDTO.getRoles().forEach(roleId -> {
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getUserId());
            userRole.setRoleId(roleId);
            userRoleMapper.insert(userRole);
        });

        return this.baseMapper.findUserVoById(user.getUserId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(cacheNames = Constant.REDIS_USER_DETAIL, key = "#result.userId")
    public UserVO updateUser(Integer userId, UserDTO userDTO) throws SBlogException {
        User user = Optional.ofNullable(this.getById(userId))
                .orElseThrow(() -> new SBlogException("用户不存在"));

        checkRoleExists(userDTO.getRoles());

        BeanUtils.copyProperties(userDTO, user, "password");
        if (StringUtils.isNotBlank(userDTO.getPassword())) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        this.updateById(user);

        List<UserRole> userRoles = Optional.ofNullable(userRoleMapper.findByUserId(user.getUserId()))
                .orElse(Collections.emptyList());
        Set<Integer> userRoleRoleIds = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toSet());

        //删除用户角色
        if (CollectionUtils.isNotEmpty(userRoles)) {
            List<Integer> deleteUserRoleIds = userRoles.stream()
                    .filter(userRole -> !userDTO.getRoles().contains(userRole.getRoleId()))
                    .map(UserRole::getUserRoleId).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(deleteUserRoleIds)) {
                userRoleMapper.deleteBatchIds(deleteUserRoleIds);
            }
        }

        //添加新用户角色
        List<Integer> needToAddRoleIds = userDTO.getRoles().stream()
                .filter(roleId -> !userRoleRoleIds.contains(roleId)).collect(Collectors.toList());
        needToAddRoleIds.forEach(roleId -> {
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getUserId());
            userRole.setRoleId(roleId);
            userRoleMapper.insert(userRole);
        });

        return this.baseMapper.findUserVoById(user.getUserId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(cacheNames = Constant.REDIS_USER_DETAIL, key = "#userId")
    public Boolean deleteUser(Integer userId) throws SBlogException {
        boolean removeSuccess = this.removeById(userId);
        if (!removeSuccess) {
            throw new SBlogException("用户不存在");
        }

        userRoleMapper.deleteByUserId(userId);

        return true;
    }

    private void checkRoleExists(List<Integer> roleIds) throws SBlogException {
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<Role> roles = Optional.ofNullable(roleMapper.selectBatchIds(roleIds)).orElse(Collections.emptyList());
            if (roles.size() != roleIds.size()) {
                Set<Integer> existRoleIds = roles.stream().map(Role::getRoleId).collect(Collectors.toSet());
                throw new SBlogException(String.format("角色id【%s】不存在",
                        roleIds.stream().filter(roleId -> !existRoleIds.contains(roleId))
                                .map(String::valueOf).collect(Collectors.joining(","))));
            }
        }
    }

}
