package changer;

import framework.MyDeprecated;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class ChangeDeprecatedClassAspect {

    @Around("execution((@framework.MyDeprecated *) quoters.*.*(..))")
    public Object replaceDeprecated(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println("Entering: " + methodName);
        try {
        Object retVal = proceedingJoinPoint.proceed();
            MyDeprecated annotation = retVal.getClass().getAnnotation(MyDeprecated.class);
            Object newRetVal = annotation.newClass().getDeclaredConstructor().newInstance();
            return newRetVal;
        } finally {
            System.out.println("Exiting: "+ methodName);
        }
    }
}
