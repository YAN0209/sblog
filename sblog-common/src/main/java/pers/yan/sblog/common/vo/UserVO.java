package pers.yan.sblog.common.vo;

import lombok.Data;
import pers.yan.sblog.common.enums.UserStatus;

import java.util.List;

/**
 * @author likaiyan
 * @date 2021/7/23 10:59 上午
 */
@Data
public class UserVO extends BaseVO {

    private Integer userId;

    private String username;

    private String loginName;

    private UserStatus userStatus;

    private List<RoleVO> roles;

}
