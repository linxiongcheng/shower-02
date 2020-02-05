-- auto Generated on 2020-01-31
DROP TABLE IF EXISTS device_order_info;
CREATE TABLE device_order_info(
	id BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
	create_time DATETIME COMMENT 'createTime',
	update_time TIMESTAMP COMMENT 'updateTime',
	create_user VARCHAR (50) COMMENT 'createUser',
	update_user VARCHAR (50) COMMENT 'updateUser',
	device_id BIGINT (15) COMMENT '设备ID',
	device_code VARCHAR (50) COMMENT '设备编号',
	order_id BIGINT (15) COMMENT '订单ID',
	order_no VARCHAR (50) COMMENT '订单号',
	`status` INT (11) COMMENT '设备订单状态',
	content VARCHAR (50) COMMENT '详情',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'device_order_info';
