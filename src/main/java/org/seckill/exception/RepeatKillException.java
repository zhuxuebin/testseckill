package org.seckill.exception;

/**
 * �ظ���ɱ�쳣���������쳣��
 * Created by xuery on 2016/6/27.
 */
public class RepeatKillException extends RuntimeException  {
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
