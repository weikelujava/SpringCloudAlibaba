package com.smart.demo.test;

import lombok.Getter;

/**
 * @author lukewei
 * @date 2021/5/10 17:36
 */
@Getter
public class ShopCartException extends RuntimeException {

    private static final long serialVersionUID = 7494039625448996942L;

    private final String error;
    private final String msg;



    public ShopCartException(String error, String msg){
        super(error);
        this.error = error;
        this.msg = msg;
    }

    public ShopCartException(String error, Throwable cause, String msg) {
        this.error = error;
        this.msg = msg;
    }

    public ShopCartException(String error,String msg, Throwable cause) {
        super(error, cause);
        this.error = error;
        this.msg = msg + cause.getMessage();
    }

}
