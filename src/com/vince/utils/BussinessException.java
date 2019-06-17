package com.vince.utils;

/**
 * @author liuxingxing
 * @date 2019-06-17 21:36
 */
public class BussinessException extends RuntimeException {

    public BussinessException(){
        super();
    }

    public BussinessException(String errorMessage){
        super(errorMessage);
    }
}
