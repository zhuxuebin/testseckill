package org.seckill.exception;

/**
 * 秒杀关闭后 仍然继续秒杀异常
 * Created by xuery on 2016/6/27.
 */
public class SeckillCloseException extends RuntimeException {
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
