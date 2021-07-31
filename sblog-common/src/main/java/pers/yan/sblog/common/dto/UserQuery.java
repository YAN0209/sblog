package pers.yan.sblog.common.dto;

import lombok.Data;
import pers.yan.sblog.common.enums.UserStatus;

/**
 * 用户查询参数
 *
 * @author likaiyan
 * @date 2021/7/23 2:28 下午
 */
@Data
public class UserQuery {

    private Integer userId;

    private String username;

    private UserStatus userStatus;
}
