package com.sz.guigu.test01;

import java.lang.reflect.Field;

public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException, HasNotIdPropertiesException {
        Class userClass = Class.forName("com.sz.guigu.test01.User");
        boolean isOk = true;
        if (userClass.isAnnotationPresent(MustHasIdPropertiesAnnotation.class)) {
            for (Field field : userClass.getDeclaredFields()) {

                if (field.getName().equals("id") && field.getType().getSimpleName().equals("int")) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                throw new HasNotIdPropertiesException("被@MustHasIdPropertyAnnotation注解标注的类中必须要有一个int类型的id属性！");
            }
        }
    }
}
