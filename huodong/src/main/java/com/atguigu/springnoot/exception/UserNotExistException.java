package com.atguigu.springnoot.exception;

/**
 * @author huo
 * @create 2019-12-22-19:53
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("用户不存在");
    }
}
