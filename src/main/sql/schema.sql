##�������ݿ�
create database seckill;
##ʹ�����ݿ�
use seckill;
##�������ݿ���ɱ��
CREATE TABLE seckill(
	`seckill_id`  BIGINT NOT NULL AUTO_INCREMENT COMMENT '��Ʒ���id',
	`name`  VARCHAR(120) NOT NULL COMMENT '��Ʒ����',
  `number` int NOT NULL COMMENT '�������',
  `start_time`  TIMESTAMP  NOT NULL COMMENT '��ɱ����ʱ��',
	`end_time`  TIMESTAMP NOT NULL COMMENT '��ɱ����ʱ��',
	`create_time` TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP COMMENT '����ʱ��',
	PRIMARY KEY (`seckill_id`),
	KEY idx_start_time(`start_time`),
	KEY idx_end_time(`end_time`),
	Key idx_create_time(`create_time`)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='��ɱ����';

##��ʼ������
insert into 
	seckill (name,number,start_time,end_time)
values
	('1000Ԫ��ɱiphone6',100,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
	('500Ԫ��ɱ����plus',200,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
	('300Ԫ��ɱС��6',300,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
	('200Ԫ��ɱ����F2',400,'2015-11-01 00:00:00','2015-11-02 00:00:00');

##��ɱ�ɹ���ϸ��
##�û���¼��֤����ص���Ϣ
CREATE TABLE success_killed(
	seckill_id  BIGINT NOT NULL COMMENT '��ɱ��Ʒid',
	user_phone BIGINT NOT NULL COMMENT '�û��ֻ���',
	state      BIGINT NOT NULL DEFAULT -1 COMMENT '״̬��ʶ��-1����Ч��0���ɹ���1���Ѹ��2���ѷ���',
	create_time TIMESTAMP NOT NULL COMMENT '����ʱ��',
	PRIMARY KEY(seckill_id,user_phone),
	key idx_create_time(create_time)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='��ɱ�ɹ���ϸ��';







