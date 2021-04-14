package com.springboot.demo.aspects;

import com.springboot.demo.model.Authorization;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static java.lang.System.out;

public class MyLogger {
    private ApplicationContext applicationContext;

    public void beforeMethodInvocation(JoinPoint joinPoint) {

        Authorization authorization = applicationContext.getBean("userAuthorized", Authorization.class);
        out.println("Authorized : " + authorization.getAuthorized());
        out.println("***********************************");
        out.println("******* Log : before method " + joinPoint.getSignature().toShortString() + ". ");
        out.println("***********************************");
    }

    public void afterReturn(JoinPoint joinPoint, Object result) {
        out.println(joinPoint.getSignature().getName() + " method of " + joinPoint.getTarget().toString() + " was invoked!");
        out.println("Result of method execution : " + result);
        out.println("***********************************");
        out.println("* Log : success method invocation *");
        out.println("***********************************");
    }

    public void afterThrowing(Exception ex) {
        out.println("***********************************");
        out.println("*********** Log : error ***********");
        out.println("Exception : " + ex.getMessage());
        out.println("***********************************");
    }


    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
