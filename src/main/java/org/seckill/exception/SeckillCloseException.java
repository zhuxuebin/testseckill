package org.seckill.exception;

/**
 * ��ɱ�رպ� ��Ȼ������ɱ�쳣
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
