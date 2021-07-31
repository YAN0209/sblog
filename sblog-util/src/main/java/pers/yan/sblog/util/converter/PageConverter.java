package pers.yan.sblog.util.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.core.convert.converter.Converter;
import pers.yan.sblog.common.vo.BasePage;

/**
 * 分页转换器
 *
 * @author likaiyan
 * @date 2021/7/25 3:57 下午
 */
@FunctionalInterface
public interface PageConverter<T> extends Converter<Page<T>, BasePage<T>> {

    /**
     * 转换
     *
     * @param s mpb分页实体
     * @return 通用分页
     */
    @Override
    BasePage<T> convert(Page<T> s);
}