package pers.yan.sblog.resource.mgmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pers.yan.sblog.common.dto.UserDTO;
import pers.yan.sblog.common.dto.UserQuery;
import pers.yan.sblog.common.enums.UserStatus;
import pers.yan.sblog.common.exception.SBlogException;
import pers.yan.sblog.common.vo.ApiResult;
import pers.yan.sblog.common.vo.BasePage;
import pers.yan.sblog.common.vo.UserVO;
import pers.yan.sblog.service.service.UserService;

/**
 * 用户controller
 *
 * @author likaiyan
 * @date 2021/7/25 4:36 下午
 */
@RestController
@RequestMapping("/mgmt/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('userAdmin') || hasAuthority('user::view')")
    public ApiResult<UserVO> findUserVoById(@PathVariable("userId") Integer userId) {
        return ApiResult.ok(userService.findById(userId));
    }

    @GetMapping("")
    @PreAuthorize("hasRole('userAdmin') || hasAuthority('user::view')")
    public ApiResult<BasePage<UserVO>> findUserVoByPage(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                                        @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                                                        @RequestParam(value = "userId", required = false) Integer userId,
                                                        @RequestParam(value = "username", required = false) String username,
                                                        @RequestParam(value = "status", required = false) UserStatus userStatus) {
        UserQuery userQuery = new UserQuery();
        userQuery.setUserId(userId);
        userQuery.setUsername(username);
        userQuery.setUserStatus(userStatus);
        return ApiResult.ok(userService.findByPage(page, size, userQuery));
    }

    @PostMapping("")
    @PreAuthorize("hasRole('userAdmin') || hasAuthority('user::add')")
    public ApiResult<UserVO> addUser(@RequestBody @Validated UserDTO userDTO) throws SBlogException {
        return ApiResult.ok(userService.addUser(userDTO));
    }

    @PutMapping("/{userId}")
    @PreAuthorize("hasRole('userAdmin') || hasAuthority('user::udpate')")
    public ApiResult<UserVO> updateUser(@PathVariable("userId") Integer userId, @RequestBody @Validated UserDTO userDTO) throws SBlogException {
        return ApiResult.ok(userService.updateUser(userId, userDTO));
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasRole('userAdmin') || hasAuthority('user::delete')")
    public ApiResult<Boolean> deleteUser(@PathVariable("userId") Integer userId) throws SBlogException {
        return ApiResult.ok(userService.deleteUser(userId));
    }

}
