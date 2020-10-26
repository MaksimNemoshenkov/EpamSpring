package framework;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Component
public class TransactionBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> originalClass = bean.getClass();
        if(originalClass.isAnnotationPresent(Transaction.class))
            map.put(beanName, originalClass);
        return bean;
    }


/*    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        Class<?> originalClass = map.get(beanName);
        Method[] methods = clazz.getMethods();
        boolean benchmarkFound = false;
        for (Method method : methods) {
            if (originalClass!=null) {
                benchmarkFound = true;
                break;
            }
        }
        if(benchmarkFound){
            Object proxy = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Method originalMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                    if(originalMethod.isAnnotationPresent(Transaction.class)) {
                        System.out.println("Start transaction");
                        Object retVal = method.invoke(bean, args);
                        System.out.println("Transaction closed");
                        return retVal;
                    } else {
                        return method.invoke(bean, args);
                    }
                }
            });
            return proxy;
        }
        return bean;
    }*/


    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        Class<?> originalClass = map.get(beanName);
        if(originalClass!=null){
            return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("Start transaction");
                    Object retVal = method.invoke(bean, args);
                    System.out.println("Transaction closed");
                    return retVal;
                }
            });
        }
        return bean;
    }

}
