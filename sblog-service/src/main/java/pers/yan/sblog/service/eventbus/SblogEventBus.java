package pers.yan.sblog.service.eventbus;


import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import pers.yan.sblog.service.eventbus.event.SblogEvent;

import java.util.concurrent.Executors;

/**
 * 消息总线
 *
 * @author likaiyan
 * @date 2021/8/7 2:02 下午
 */
@SuppressWarnings("UnstableApiUsage")
public class SblogEventBus {

    public static final EventBus SblogEventBus = new AsyncEventBus(Executors.newFixedThreadPool(5));

    public static void post(SblogEvent event) {
        SblogEventBus.post(event);
    }
}
