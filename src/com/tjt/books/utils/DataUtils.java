package com.tjt.books.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class DataUtils {
    /**
     * 将方法，封装到静态方法，方便使用
     * @param value 将表单发送来的数据封装到Map中
     * @param bean javabean，底层通过反射，将Map中的数据映射到javabean中
     * @param <T>  泛型，接受任意类型的javabean
     * @return  返回映射赋值后的javabean
     */
    public static <T> T copyParameterToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    //将字符串转成一个整数，否则返回一个默认值
    public static int parseInt(String val,int defaultVal){
        try {
             return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            System.out.println(val+"格式不正确");
        }
        return defaultVal;
    }
}
