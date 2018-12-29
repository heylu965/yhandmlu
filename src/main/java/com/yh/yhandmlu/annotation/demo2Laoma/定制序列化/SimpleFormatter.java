package com.yh.yhandmlu.annotation.demo2Laoma.定制序列化;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 格式化
 */
public class SimpleFormatter {

    /**
     getField
     获取一个类的 ==public成员变量，包括基类== 。

     getDeclaredField
     获取一个类的 ==所有成员变量，不包括基类== 。

     Field.setAccessible
     成员变量为private，必须进行此操作。

     * @param object
     * @return
     */
    public static String format(Object object){
        try {
            // 获取该对象运行时类
            Class<?> aClass = object.getClass();
            StringBuilder sb = new StringBuilder();
            // 获取对象所有声明的成员属性属性，不包括继承属性
            for (Field field : aClass.getDeclaredFields()){
                if (!field.isAccessible()){
                    field.setAccessible(true);
                }
                Label label = field.getAnnotation(Label.class);
                // 有注解，取注解value值，没有注解，取字段属性名称
                String name = label != null ? label.value() : field.getName();

                // 获取属性对应的值
                Object value = field.get(object);
                // 属性值不为null且属性值类型是java.util.Date类型
                if (value != null && field.getType() == Date.class){
                    value = formatDate(field,value);
                }
                sb = sb.append(name+": "+value+"\n");
            }
            return sb.toString();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static Object formatDate(Field field, Object value) {
        Format annotation = field.getAnnotation(Format.class);
        if (annotation != null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(annotation.pattern());
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(annotation.timezone()));
            return simpleDateFormat.format(value);
        }
        return value;
    }


}
