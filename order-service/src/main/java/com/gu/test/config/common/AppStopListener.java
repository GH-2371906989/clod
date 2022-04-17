package com.gu.test.config.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
@Slf4j
public class AppStopListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        log.info("********************************************");
        log.info("***** 项目于 {} 关闭成功 *****", LocalDate.now().toString()+" "+ LocalTime.now().toString());
        log.info("********************************************");
    }
}
