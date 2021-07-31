package pers.yan.sblog.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pers.yan.sblog.common.enums.UserStatus;

/**
 * 用户
 *
 * @author likaiyan
 * @date 2021/7/23 10:41 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户状态
     */
    private UserStatus userStatus;

}
