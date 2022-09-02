package com.niit.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	private static Logger logger = LogManager.getLogger();

	@AfterThrowing(pointcut = "execution(* com.niit.service.*Impl.*(..))", throwing = "exception")
	public void logServiceException(Exception exception) {
		logger.error(exception.getMessage(), exception);
	}

}
