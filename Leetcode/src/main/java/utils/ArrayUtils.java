package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-21 14:37
 * @Version: 1.0
 */
public class ArrayUtils {

    public static String toString(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return "{}";
        }
        StringBuffer sb = new StringBuffer("{");
        for (Object o : collection) {
            sb.append(o + ", ");
        }
        return sb.substring(0, sb.length() - 2) + "}";
    }


    public static String toString(Object obj) {
        if (obj == null) {
            return "null";
        }
        Class<?> aClass = obj.getClass();
        if (aClass.isArray()) {
            String simpleName = aClass.getSimpleName();
            List list = null;
            if ("int[]".equals(simpleName)) {
                int[] arr = (int[]) obj;
                list = Arrays.stream(arr).boxed().collect(Collectors.toList());
            } else if ("double[]".equals(simpleName)) {
                double[] arr = (double[]) obj;
                list = Arrays.stream(arr).boxed().collect(Collectors.toList());
            }
            return toString(list);
        }
        return obj.toString();
    }

    public static String toString(Object[] arr) {
        StringBuffer sb = new StringBuffer("{");
        for (Object obj : arr) {
            if (obj instanceof int[]) {
                sb.append(toString(obj) + ", ");
            }else {
                sb.append(obj + ", ");
            }
        }
        return sb.substring(0, sb.length() - 2) + "}";
    }

    public static List<List<Integer>> toList(int[][] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] innerArray : nums) {
            List<Integer> innerList = new ArrayList<>();
            for (int i : innerArray) {
                innerList.add(i);
            }
            list.add(innerList);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(toString(new double[]{1.0, 4.0}));
    }
}
