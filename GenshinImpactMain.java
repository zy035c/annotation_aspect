package annotation_aspect;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GenshinImpactMain implements HelpMeMrSvarogInterface {
    public static void direct_activate(Class<?> clazz) {
        Method[] ms = clazz.getDeclaredMethods();
        for (Method m: ms) {
            if (m.isAnnotationPresent(DogDeclare.class)) {
                DogDeclare dogDeclare = m.getAnnotation(DogDeclare.class);
                for (int i = 0; i < dogDeclare.count(); ++i) {
                    System.out.println(dogDeclare.text());
                }
            }
        }
    }

    public int yuanShenQiDong(int res) {
        System.out.println("Genshin impact, activated!");
        return res;
    }

    public GenshinImpactMain() {}

    private HelpMeMrSvarogInterface createProxy() {
        return (HelpMeMrSvarogInterface)Proxy.newProxyInstance(
            getClass().getClassLoader(),
            new Class<?>[]{HelpMeMrSvarogInterface.class},
            new CustomAnnotationProxy(this)
        );
    }

    public static HelpMeMrSvarogInterface NewInstance() {
        return new GenshinImpactMain().createProxy();
    }

    public static void main(String[] args) {
        // var instance = new GenshinImpactMain();

        var proxy = NewInstance();
        var res = proxy.yuanShenQiDong(3);
        System.out.println("Result: "+ res);

        System.out.println("--------------------");

        direct_activate(HelpMeMrSvarogInterface.class);


        // var res = instance.yuanShenQiDong(3);
        // System.out.println(res);
    }
}
