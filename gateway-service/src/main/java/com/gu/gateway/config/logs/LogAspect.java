package com.gu.gateway.config.logs;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class LogAspect {
    @Pointcut("@within(com.gu.gateway.config.logs.LogApi)")
    public void Log() {
    }
    @Around("Log()")
    public Object logInfo(ProceedingJoinPoint proceedingJoinPoint) {
//        log.info(JSON.toJSONString(proceedingJoinPoint));
        String pattern = "yyyy-MM-dd HH-mm-ss";
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Class<?> aClass = proceedingJoinPoint.getTarget().getClass();
        String className = aClass.getSimpleName();
        //得到方法签名
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        //得到方法名
        Method method = signature.getMethod();
        String methodName = method.getName();
        //获得参数
        Object[] args = proceedingJoinPoint.getArgs();
        //开始时间
        String startTime = df.format(new Date());
        long start = System.currentTimeMillis();
        try {
            log.info("***** 进入类 {},开始调用方法 {},开始时间 {} *****", className, methodName, startTime);
            LogApi annotation = aClass.getAnnotation(LogApi.class);
            if(annotation.logParameters()){
                Arrays.asList(args).forEach(object -> log.info("**** 参数为 ：{} *****",object));
            }
            Object proceed = proceedingJoinPoint.proceed();
            String endTime = df.format(new Date());
            long end = System.currentTimeMillis();
            long runTime = end - start;
            log.info("***** 结束类 {},结束调用方法 {},结束时间 {},耗时 {}  *****", className, methodName, endTime, runTime + "ms");
            return proceed;
        } catch (Throwable throwable) {
            String endTime = df.format(new Date());
            long end = System.currentTimeMillis();
            long runTime = end - start;
            log.error("***** 结束类 {},调用方法 {} 时出现错误, 结束时间 {}, 耗时 {} *****", className, methodName, endTime, runTime +"ms");
            log.error(throwable.getMessage(), throwable);
            return throwable.getMessage();
        }

    }
}
