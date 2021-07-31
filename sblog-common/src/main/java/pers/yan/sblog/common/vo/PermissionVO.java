package pers.yan.sblog.common.vo;

import lombok.Data;

/**
 * @author likaiyan
 * @date 2021/7/23 1:51 下午
 */
@Data
public class PermissionVO extends BaseVO {

    private Integer permissionId;

    private String permissionName;

    private String permissionCode;
}
