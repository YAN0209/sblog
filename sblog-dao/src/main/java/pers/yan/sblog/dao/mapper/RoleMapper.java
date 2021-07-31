package pers.yan.sblog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pers.yan.sblog.common.entity.Role;
import pers.yan.sblog.common.vo.RoleVO;

import java.util.List;

/**
 * @author likaiyan
 * @date 2021/7/23 2:09 下午
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    List<RoleVO> findRoleVoByUserId(@Param("userId") Integer userId);

}