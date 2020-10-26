package framework;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class BenchmarkBeanPostProcessor implements BeanPostProcessor {
    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        BeanDefinition beanDefinition = factory.getBeanDefinition(beanName);
        String beanClassName = beanDefinition.getBeanClassName();
        Class<?> originalClass = null;
        try {
            originalClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Method[] methods = originalClass.getMethods();
        boolean benchmarkFound = false;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Benchmark.class)) {
                benchmarkFound = true;
                break;
            }
        }
        if(benchmarkFound){
            Class<?> finalOriginalClass = originalClass;
            Object proxy = Proxy.newProxyInstance(originalClass.getClassLoader(), originalClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Method originalMethod = finalOriginalClass.getMethod(method.getName(), method.getParameterTypes());
                if(originalMethod.isAnnotationPresent(Benchmark.class)) {
                    long before = System.nanoTime();
                    Object retVal = method.invoke(bean, args);
                    long after = System.nanoTime();
                    System.out.println(after - before);
                    return retVal;
                     } else {
                         return method.invoke(bean, args);
                    }
                }
            });
            return proxy;
        }
        return bean;
    }

/*    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        Method[] methods = clazz.getMethods();
        for(Method method:methods){
            if(method.isAnnotationPresent(Benchmark.class)) {
                Object proxy = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                     Method originalMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                        if(originalMethod.isAnnotationPresent(Benchmark.class)) {
                            long before = System.nanoTime();
                            Object retVal = method.invoke(bean, args);
                            long after = System.nanoTime();
                            System.err.println(after - before);
                            return retVal;
                        } else {
                            return method.invoke(bean, args);
                        }
                    }
                });
                return proxy;
            }
        }
        return bean;
    }*/

/*    public Object postProcessBeforeInitialization (Object o, String s){
        Method[] methods = o.getClass().getMethods();
        for(Method method:methods){
            if(method.isAnnotationPresent(RunThisMethod.class)) {
                try {
                    method.invoke(o);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return o;
    }
    */
/*    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        if(clazz.isAnnotationPresent(Benchmark.class)){
           Object proxy = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    long before = System.nanoTime();
                    Object  retVal= method.invoke(bean,args);
                    long after = System.nanoTime();
                    System.out.println(after-before);
                    return retVal;
                }
            });
            return proxy;
        } else {
            return bean;
        }
    }*/
}
