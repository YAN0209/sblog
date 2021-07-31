package pers.yan.sblog.common.vo;

import lombok.Data;

import java.util.List;

/**
 * @author likaiyan
 * @date 2021/7/23 2:22 下午
 */
@Data
public class BasePage<T> {

    private long page;

    private long size;

    private long totalPage;

    private long totalElement;

    private List<T> data;

}
