package utils;

import com.sun.deploy.util.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-23 18:19
 * @Version: 1.0
 */
public class TestUtils {
    public static void test(Map map, Object object) {
        Class<?> clazz = object.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("INFO:======" + clazz.getName() + "测试结果======");
        map.forEach((k, v) -> {
            if (methods != null && methods.length > 0) {
                try {
                    Object testVal = methods[0].invoke(object, k);
                    if (!testVal.equals(v)) {
                        String format = "ERROR: %s:%s   预期：<%s:%s>";
                        System.out.println(String.format(format, k, testVal, k, v));
                    }else {
                        printLocal(new Object[]{k}, testVal);
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void test(Map map, Class clazz) {
        Constructor constructor = clazz.getConstructors()[0];
        Object obj = null;
        try {
            obj = constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        test(map, obj);
    }

    public static Object test(Class clazz, Object... args) {
        Constructor constructor = clazz.getConstructors()[0];
        Object obj = null;
        try {
            obj = constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        Class anInterface = clazz.getInterfaces()[0];
        Method[] methods = anInterface.getDeclaredMethods();
        System.out.println("INFO:======" + clazz.getName() + "测试结果======");
        Object testVal = null;
        try {
            testVal = methods[0].invoke(obj, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        printLocal(args, testVal);
        return testVal;
    }

    private static void printLocal(Object[] args, Object testVal) {
        System.out.print(ArrayUtils.toString(args));
        System.out.print( ",结果:");
        System.out.println(ArrayUtils.toString(testVal));

    }
}
