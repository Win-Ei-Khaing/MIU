package edu.mum.cs544.bank.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.cs544.bank.logging.Logger;

@Aspect
@Component
public class JMSLogAdvice {
    @Autowired
    private Logger logger;

    @After("execution(* edu.mum.cs544.bank.jms.JMSSender.sendJMSMessage(String))")
    public void logJMSMessage(JoinPoint jp){
        Object[] args=jp.getArgs();
        logger.log("Logging every JMS message : " + args[0] + ", by Group 12");
    }
}
