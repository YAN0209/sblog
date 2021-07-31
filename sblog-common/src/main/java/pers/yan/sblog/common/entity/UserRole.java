package pers.yan.sblog.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户角色
 *
 * @author likaiyan
 * @date 2021/7/23 3:21 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_role")
public class UserRole extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Integer userRoleId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 角色id
     */
    private Integer roleId;

}
