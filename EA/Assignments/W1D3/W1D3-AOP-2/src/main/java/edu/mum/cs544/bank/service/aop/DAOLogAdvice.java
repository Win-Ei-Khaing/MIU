package edu.mum.cs544.bank.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.cs544.bank.logging.Logger;

@Aspect
@Component
public class DAOLogAdvice {
    @Autowired
    private Logger logger;
    
    @Before("execution(* edu.mum.cs544.bank.dao.*.*(..))")
    public void logDAOCall(JoinPoint jp){
        logger.log("Logging every call of bank.dao by Group 12");
    }
}
