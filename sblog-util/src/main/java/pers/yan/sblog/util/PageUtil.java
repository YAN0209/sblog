package pers.yan.sblog.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import pers.yan.sblog.common.vo.BasePage;
import pers.yan.sblog.util.converter.DefaultPageConverter;
import pers.yan.sblog.util.converter.PageConverter;

/**
 * 分页工具类
 *
 * @author likaiyan
 * @date 2021/7/23 5:48 下午
 */
public class PageUtil {

    public static <T> BasePage<T> convert(Page<T> page) {
        return convert(page, null);
    }

    public static <T> BasePage<T> convert(Page<T> page, PageConverter<T> pageConverter) {
        if (pageConverter == null) {
            pageConverter = new DefaultPageConverter<>();
        }
        return pageConverter.convert(page);
    }

}
