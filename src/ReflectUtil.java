package jp.co.airlink.ganges.fare.search.util;

import jp.co.airlink.ganges.core.vo.ProductVO;
import jp.co.airlink.ganges.core.vo.SeatMapVO;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.List;

public class ReflectUtil {
    public static void printStructureClass(Class<?> clazz, int nTab) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(String.format(tab(nTab) + "%-15s: %s", f.getName(), f.getType().toString()));
            if (f.getType() == List.class) {
                ParameterizedType parameterizedType = (ParameterizedType) f.getGenericType();
                Class<?> genericType = (Class<?>) parameterizedType.getActualTypeArguments()[0];
                printStructureClass(genericType, nTab + 1);
            }
            if (f.getType() != Integer.class && f.getType() != String.class && f.getType() != List.class && f.getType() != BigDecimal.class
                    && !f.getType().isInterface() && !f.getType().isAnnotation() && f.getType().isEnum() && f.getType().isEnum() && f.getType().isPrimitive()) {
                printStructureClass(f.getType(), nTab + 1);
            }
        }
    }

    public static String tab(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s += "\t";
        }
        return s;
    }

    public static void main(String[] args) {
        printStructureClass(ProductVO.class, 0);
    }
}
