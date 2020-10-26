package framework;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.lang.reflect.Method;
import java.util.Collection;

public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext context = contextRefreshedEvent.getApplicationContext();
        Collection<Object> beans = context.getBeansOfType(Object.class).values();
        for (Object bean : beans) {
            Method[] methods = bean.getClass().getMethods();
            for (Method method : methods) {
                if(method.isAnnotationPresent(PostInitialize.class)) {
                    try {
                        method.invoke(bean);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
