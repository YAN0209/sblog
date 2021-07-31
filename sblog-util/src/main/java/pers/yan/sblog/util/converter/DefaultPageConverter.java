package pers.yan.sblog.util.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import pers.yan.sblog.common.vo.BasePage;

/**
 * @author likaiyan
 * @date 2021/7/23 5:54 下午
 */
public class DefaultPageConverter<T> implements PageConverter<T> {

    @Override
    public BasePage<T> convert(Page<T> page) {
        BasePage<T> basePage = new BasePage<>();
        basePage.setPage(page.getCurrent());
        basePage.setSize(page.getSize());
        basePage.setTotalPage(page.getPages());
        basePage.setTotalElement(page.getTotal());
        basePage.setData(page.getRecords());
        return basePage;
    }
}
