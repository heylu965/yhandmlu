package com.yh.yhandmlu.annotation.demo1;

import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * http://www.importnew.com/10294.html
 * https://www.cnblogs.com/jpfss/p/8126049.html
 * http://www.deanwangpro.com/2017/01/31/ali-interview/s
 */
public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> clazz){
        Field[] fields = clazz.getDeclaredFields();

        String name = "名称：";
        String color = "颜色：";
        String provider = "供货商：";



        for (Field field : fields){
//            System.out.println(field.getAnnotatedType());
//            System.out.println(field.getAnnotations());
//            System.out.println(field.getDeclaringClass());
//            System.out.println(field.getModifiers());
//            System.out.println(field.isAnnotationPresent());

            System.out.println(field.getName());
            System.out.println(field.getName().substring(0,1).toUpperCase()+field.getName().substring(1));
            String methodName = "get"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
            System.out.println(methodName);

            System.out.println("=================");
            if (field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName = field.getAnnotation(FruitName.class);
                name = name + fruitName.value();
                System.out.println(name);
            }else if (field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                color = color + fruitColor.color();
                System.out.println(color);
            }else if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                provider = provider +"编号："+ fruitProvider.id() + "，名称："+fruitProvider.name() + "，地址：" +fruitProvider.address();
                System.out.println(provider);
            }

        }
    }

    public static void main(String[] arg){
//        getFruitInfo(Apple.class);

        Apple apple = new Apple();
        apple.setAppleColor("red");
        apple.setAppleName("apple");
        apple.setAppleProvider("provider");
        t(apple);
    }

    public static void t(Apple apple){
        try {
            Class clazz = apple.getClass();

            PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(clazz);
            for (PropertyDescriptor pd : propertyDescriptors){

                System.out.println("getDisplayName():"+pd.getDisplayName());
                System.out.println("pd.getShortDescription():"+pd.getShortDescription());
                System.out.println("getName():"+pd.getName());
                System.out.println("getReadMethod():"+pd.getReadMethod());
                System.out.println("getWriteMethod():"+pd.getWriteMethod());

                System.out.println("---------"+pd.getReadMethod().getDeclaringClass());
                System.out.println("+++++++++"+pd.getReadMethod().getDeclaringClass().getModifiers());

                if (!Modifier.isPrivate(pd.getReadMethod().getDeclaringClass().getModifiers())){
                    pd.getReadMethod().setAccessible(true);
                }
                Object value = pd.getReadMethod().invoke(apple);

                System.out.println("value:"+value);


            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        /**
         appleColor
         appleName
         appleProvider
         class
         */
    }

}
