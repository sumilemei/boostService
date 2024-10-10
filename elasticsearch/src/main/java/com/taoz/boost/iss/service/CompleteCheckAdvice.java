package com.taoz.boost.iss.service;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class CompleteCheckAdvice {

    @Pointcut("@annotation(com.taoz.boost.iss.service.CompletePointcut)")
    private void annotationPointcut(){};

    @Around("annotationPointcut()")
    public Object appendDataCompleteCheck(ProceedingJoinPoint joinPoint) throws Throwable{
        Object[] args = joinPoint.getArgs();
        //Class<? extends ICompleteCheck> dataByType = EnforceDataEnum.getDataByType(args[0].getClass());
        ICompleteCheck iCompleteCheck = GetBeanUtil.getBean(EnforceDataEnum.getDataByType(args[0].getClass()));
        //ICompleteCheck iCompleteCheck = EnforceDataEnum.getDataByType(args[0].getClass()).newInstance();
        iCompleteCheck.dataCompleteCheck(args[0]);
        return joinPoint.proceed();
    }

}
