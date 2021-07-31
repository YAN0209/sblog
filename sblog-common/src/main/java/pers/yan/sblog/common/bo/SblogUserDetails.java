package pers.yan.sblog.common.bo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pers.yan.sblog.common.entity.User;
import pers.yan.sblog.common.enums.UserStatus;
import pers.yan.sblog.common.vo.UserVO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author likaiyan
 * @date 2021/7/23 1:57 下午
 */
@Data
public class SblogUserDetails implements UserDetails {

    private User user;

    private UserVO userVO;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        userVO.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleCode()));
            role.getPermissions().forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission.getPermissionCode())));
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return String.valueOf(user.getUserId());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserStatus.NORMAL.equals(user.getUserStatus());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
