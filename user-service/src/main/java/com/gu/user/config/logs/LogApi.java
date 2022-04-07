package com.gu.user.config.logs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface  LogApi {
    /** 是否打印方法入参 默认关闭 接口层推荐开启 **/
    boolean logParameters() default false;
}
