package annotation_aspect;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface DogDeclare {
    int count() default 1;
    String text() default "I'm a dog of Kamisato Ayaka! 我是神里绫华小姐的狗！";
}
