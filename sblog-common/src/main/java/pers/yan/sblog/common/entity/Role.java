package pers.yan.sblog.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色
 *
 * @author likaiyan
 * @date 2021/7/23 1:40 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("role")
public class Role extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Integer roleId;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色编码
     */
    private String roleCode;

}
