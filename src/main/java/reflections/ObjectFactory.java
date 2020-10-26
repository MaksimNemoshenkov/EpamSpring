package reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class ObjectFactory {
    public static <T> T createObject (Class<T> clazz) throws Exception {
        T object = clazz.getDeclaredConstructor().newInstance();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if(field.isAnnotationPresent(Inject.class)){
               Inject annotation = field.getAnnotation(Inject.class);
              int min = annotation.min();
              int max = annotation.max();
                field.setAccessible(true);
                field.set(object, min + new Random().nextInt(max-min));
            }
        }

        handleMethodsAnnotation(clazz, object);
        return object;
    }

    private static <T> void handleMethodsAnnotation(Class<T> clazz, T object) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = clazz.getMethods();
        for (Method method : methods){
            RunThisMethod annotation = method.getAnnotation(RunThisMethod.class);
            if(annotation!=null){
                for(int i = 0; i < annotation.repeat(); i++) {
                    method.invoke(object);
                }
            }
        }
    }
}