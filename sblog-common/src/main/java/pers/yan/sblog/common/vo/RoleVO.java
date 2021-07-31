package pers.yan.sblog.common.vo;

import lombok.Data;

import java.util.List;

/**
 * @author likaiyan
 * @date 2021/7/23 1:50 下午
 */
@Data
public class RoleVO extends BaseVO {

    private Integer roleId;

    private String roleName;

    private String roleCode;

    private List<PermissionVO> permissions;
}
