package annotation_aspect;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;


public class CustomAnnotationProxy implements InvocationHandler {
    private Object target;

    CustomAnnotationProxy(Object obj) {
        this.target = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(DogDeclare.class)) {
            System.out.println("CustomAnnotation is triggered before method: " + method.getName());
            DogDeclare dogDeclare = method.getDeclaredAnnotation(DogDeclare.class);
            for (int i = 0; i < dogDeclare.count(); ++i) {
                System.out.println(dogDeclare.text());
            }
            if (method.getReturnType() == int.class) {
                return (int)method.invoke(target, args) + dogDeclare.count();
            }
        }
        return method.invoke(target, args);
    }

}