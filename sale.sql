CREATE TABLE users(
  `user_code` varchar(16) NOT NULL COMMENT '用户唯一编码,数据主键',
  `nick_name` varchar(32) NOT NULL COMMENT '用户昵称',
  `phone_number` varchar(32) NOT NULL COMMENT '用户手机号',
  `state` tinyint(4) NOT NULL COMMENT '用户状态 1-有效 0-注销',
  `role` varchar(16) NOT NULL COMMENT '用户角色',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_code`) USING BTREE,
  KEY `idx_state` (`state`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';


CREATE TABLE commodities(
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `commodity_name` varchar(32) NOT NULL COMMENT '商品名称',
  `commodity_price` decimal(12,4) NOT NULL COMMENT '商品价格',
  `commodity_count` bigint(20) NOT NULL COMMENT '商品库存数',
  `commodity_picture` bigint(32) NOT NULL COMMENT '商品示例图链接',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_commodity_price` (`commodity_price`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品信息表';


CREATE TABLE commodity_operate_logs(
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `commodity_id` bigint(20) NOT NULL COMMENT '商品id',
  `operate_user_code` varchar(32) NOT NULL COMMENT '操作人code',
  `operate_detail` varchar(32) NOT NULL COMMENT '操作详情',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品操作日志记录表';

-- CREATE TABLE user_operate_logs(
--   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
--   `nick_name` varchar(32) NOT NULL COMMENT '用户昵称',
--   `phone_number` varchar(32) NOT NULL COMMENT '用户手机号',
--   `state` tinyint(4) NOT NULL COMMENT '用户状态 1-有效 0-注销',
--   `role` varchar(16) NOT NULL COMMENT '用户角色',
--   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
--   `update_time` datetime DEFAULT NULL COMMENT '更新时间',
--   PRIMARY KEY (`user_code`) USING BTREE,
--   KEY `idx_state` (`state`)
-- )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户操作日志记录表';