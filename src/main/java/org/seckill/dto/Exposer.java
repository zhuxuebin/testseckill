package org.seckill.dto;

/**
 * ��¶��ɱ��ַDTO
 * Created by xuery on 2016/6/27.
 */
public class Exposer {
    //�Ƿ�����ɱ
    private boolean exposed;

     //һ�ּ��ܻ���
    private String md5;

    //��ɱid
    private long seckillId;

    //ϵͳʱ��(ms)
    private long now;

    //����ʱ��
    private long start;

    //����ʱ��
    private long end;

    public Exposer(boolean exposed, String md5, long seckillId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.seckillId = seckillId;
    }

    public Exposer(boolean exposed, long seckillId,long now, long start, long end) {
        this.exposed = exposed;
        this.seckillId = seckillId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean exposed, long seckillId) {
        this.exposed = exposed;
        this.seckillId = seckillId;
    }

    //��д��toString����


    @Override
    public String toString() {
        return "Exposer{" +
                "exposed=" + exposed +
                ", md5='" + md5 + '\'' +
                ", seckillId=" + seckillId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }
}

