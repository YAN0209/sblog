package pers.yan.sblog.common.dto;

import lombok.Data;

/**
 * 权限传输类
 *
 * @author likaiyan
 * @date 2021/7/31 11:38 下午
 */
@Data
public class PermissionDTO {
    
    private String permissionName;

    private String permissionCode;
}
