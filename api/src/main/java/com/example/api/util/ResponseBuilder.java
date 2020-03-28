package com.example.api.util;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

/**
 * @author yzx
 * @date 2020/3/28
 *
 */

public class ResponseBuilder {
    /**
     * 基础json构造器,反射枚举类的字段名和字段值
     *
     * @param theEnum 消息枚举值
     * @return 枚举类 字段名和字段值生成的Map
     */
    public static HashMap<String, Object> buildBaseJson(Enum theEnum) throws IllegalAccessException{
        HashMap<String ,Object> baseJson = new HashMap<>();
        int fieldsNum = theEnum.ordinal();
        Class enumClazz = theEnum.getDeclaringClass();
        Field[] fields = enumClazz.getDeclaredFields();
        for (Field field: fields){
            if(!Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                String key = field.getName();
                Object value = field.get(theEnum);
                baseJson.put(key, value);
            }
        }
        return baseJson;
    }

    /**
     * 请求成功，无参json消息构造方法
     *
     * @return 构造好的Map消息
     */

    public static HashMap<String, Object> success() throws IllegalAccessException {
        return buildBaseJson(RespJsonEnum.SUCCESS);
    }

    /**
     * 请求成功，有参json消息构造方法
     *
     * @param respData 参数数据
     * @param <T>      泛型
     * @return 构造好的Map消息
     */

    public static <T> HashMap<String, Object> success(T respData) throws IllegalAccessException {
        HashMap<String,Object> baseJson = buildBaseJson(RespJsonEnum.SUCCESS);
        baseJson.put("result",respData);
        return baseJson;
    }

    /**
     * 请求失败,无参json消息构造方法
     *
     * @return 构造好的Map消息
     */

    public static HashMap<String, Object> error() throws IllegalAccessException {
        return buildBaseJson(RespJsonEnum.ERROR);
    }

    /**
     * 无Token错误,无参json消息构造方法
     *
     * @return 构造好的Map消息
     */

    public static HashMap<String, Object> noTokenError() throws IllegalAccessException {
        return buildBaseJson(RespJsonEnum.NO_TOKEN_ERROR);
    }

    /**
     * Token过期错误,无参json消息构造方法
     *
     * @return 构造好的Map消息
     */

    public static HashMap<String, Object> expiredTokenError() throws IllegalAccessException {
        return buildBaseJson(RespJsonEnum.EXPIRED_TOKEN_ERROR);
    }

}
