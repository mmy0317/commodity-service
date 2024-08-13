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

