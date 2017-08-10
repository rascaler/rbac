package com.redding.rbac.commons.aop;

import com.redding.rbac.commons.exception.SPIException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/3/24 17:34
 */
public class Log4jAspect {

    private final static Logger logger = LoggerFactory.getLogger(Log4jAspect.class);

    public Object info(ProceedingJoinPoint jp) {

        long startTime = System.currentTimeMillis();
        Thread.currentThread().setName(new StringBuffer().append(Thread.currentThread().getName())
                                                         .append(" ")
                                                         .append(UUID.randomUUID()).toString());
        logger.info(new StringBuffer("调用方法开始:【").append(jp.getTarget().getClass())
                                                            .append(".")
                                                            .append(jp.getSignature().getName())
                                                            .append("()】").toString());
        StringBuffer argsString = new StringBuffer("入参:");
        Object[] args = jp.getArgs();

        for(int i = 0; i < args.length; i++) {
            Object arg = args[i];
            argsString.append("【")
                    .append(arg)
                    .append("】");
        }

        logger.info(argsString.toString());

        Object result;
        try {
            result = jp.proceed();
        } catch (Throwable ex) {
            if(ex instanceof SPIException) {
                throw (SPIException)ex;
            }

            if(ex instanceof RuntimeException) {
                throw (RuntimeException)ex;
            }

            logger.error(new StringBuffer().append("【")
                    .append(jp.getTarget().getClass())
                    .append(".")
                    .append(jp.getSignature().getName())
                    .append("()】调用出错:").append(ex.getMessage()).toString(), ex);
            throw new RuntimeException(ex);
        } finally {
            logger.info(new StringBuffer().append("调用方法结束:【")
                    .append(jp.getTarget().getClass())
                    .append(".")
                    .append(jp.getSignature().getName())
                    .append("() 】耗时:")
                    .append(System.currentTimeMillis() - startTime)
                    .append("ms").toString());
        }

        return result;
    }
}


