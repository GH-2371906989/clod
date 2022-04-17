package com.gu.test.config.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
@Slf4j
public class AppRunListener implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        log.info("********************************************");
        log.info("***** 项目于 {} 启动成功 *****", LocalDate.now().toString()+" "+ LocalTime.now().toString());
        log.info("********************************************");

    }
}
