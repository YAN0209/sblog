package pers.yan.sblog.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 权限
 *
 * @author likaiyan
 * @date 2021/7/23 1:40 下午
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("permission")
public class Permission extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Integer permissionId;

    /**
     * 权限名
     */
    private String permissionName;

    /**
     * 权限编码
     */
    private String permissionCode;

}
