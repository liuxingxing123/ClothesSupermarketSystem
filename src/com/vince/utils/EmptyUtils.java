package com.vince.utils;

/**
 * @author liuxingxing
 * @date 2019-06-17 22:10
 */
public class EmptyUtils {
    public static boolean isEmpty(String s){
        if(null == s|| "".equals(s)){
            return true;
        }else{
            return false;
        }
    }
}
