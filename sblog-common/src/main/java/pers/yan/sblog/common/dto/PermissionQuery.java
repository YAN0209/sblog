package pers.yan.sblog.common.dto;

import lombok.Data;

/**
 * 权限查询
 *
 * @author likaiyan
 * @date 2021/7/31 8:48 下午
 */
@Data
public class PermissionQuery {

    private String permissionName;

    private String permissionCode;

}
