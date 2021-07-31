package pers.yan.sblog.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 角色传输类
 *
 * @author likaiyan
 * @date 2021/7/31 8:59 下午
 */
@Data
public class RoleDTO {

    private Integer roleId;

    @NotBlank
    private String roleName;

    @NotBlank
    private String roleCode;

    @NotEmpty
    private List<Integer> permissions;
}
