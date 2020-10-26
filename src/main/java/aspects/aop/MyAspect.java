package aspects.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    @Pointcut("execution(* aspects.prostotak.*.*())")
    public void prostoTakMethods(){
    }

    @AfterReturning(pointcut = "prostoTakMethods()", returning = "retValue")
    public void printReturningValue(Integer retValue){
        System.out.print("I'm your aspect and I know that method returning value is: ");
        System.out.println(retValue);
    }
}
