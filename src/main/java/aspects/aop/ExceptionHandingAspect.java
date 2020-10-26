package aspects.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;
import java.util.WeakHashMap;

@Aspect
public class ExceptionHandingAspect {
    @Value("${dbaMails}")
    private String[] mails;
    private Map <DatabaseRuntimeException, Integer> cache = new WeakHashMap<>();

    @Pointcut("execution(* quoters.*.*(..))")
    public void anyMethodsOfQuoters(){}

    @AfterThrowing(pointcut = "anyMethodsOfQuoters()", throwing = "ex")
    public void handleDBException(DatabaseRuntimeException ex){
        if(!cache.containsKey(ex)){
            cache.put(ex,1);
            System.out.println("I'm Exceptiond handing aspect. Now I work...");
            for (String mail: mails) {
                System.out.println("We have " + ex.getMessage() + " mail send to " + mail);
            }
        }
    }
}
