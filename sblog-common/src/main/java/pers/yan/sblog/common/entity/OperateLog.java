package pers.yan.sblog.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pers.yan.sblog.common.enums.OperateType;

import java.util.Date;

/**
 * 操作日志
 *
 * @author likaiyan
 * @date 2021/7/14 5:14 下午
 */
@Data
@EqualsAndHashCode
@Document("operate_log")
public class OperateLog {

    @Id
    private String id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 操作类型
     */
    private OperateType operateType;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 实体类
     */
    private String entityClass;

    /**
     * 实体id
     */
    private String entityId;

    /**
     * 内容
     */
    private String content;

}
