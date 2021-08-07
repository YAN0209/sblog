package pers.yan.sblog.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import pers.yan.sblog.common.bo.SblogUserDetails;
import pers.yan.sblog.common.entity.User;
import pers.yan.sblog.common.vo.UserVO;

/**
 * 用户相关用户类
 *
 * @author likaiyan
 * @date 2021/7/31 3:59 下午
 */
public class UserUtil {

    public static SblogUserDetails getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            return (SblogUserDetails) authentication.getPrincipal();
        }
        return null;
    }

    public static Integer getCurrentUserId() {
        SblogUserDetails sblogUserDetails = getUserDetails();
        if (sblogUserDetails != null) {
            return sblogUserDetails.getUser().getUserId();
        }
        return null;
    }

    public static String getCurrentUserName() {
        SblogUserDetails sblogUserDetails = getUserDetails();
        if (sblogUserDetails != null) {
            return sblogUserDetails.getUsername();
        }
        return null;
    }

    public static UserVO getCurrentUserVO() {
        SblogUserDetails sblogUserDetails = getUserDetails();
        if (sblogUserDetails != null) {
            return sblogUserDetails.getUserVO();
        }
        return null;
    }

    public static User getCurrentUser() {
        SblogUserDetails sblogUserDetails = getUserDetails();
        if (sblogUserDetails != null) {
            return sblogUserDetails.getUser();
        }
        return null;
    }

}
