CREATE TABLE `t_user` (
  `pkId` bigint(20) NOT NULL COMMENT '唯一标识',
  `user_id` varchar(32) NOT NULL COMMENT '登录帐号',
  `user_pwd` varchar(255) NOT NULL COMMENT '登录密码',
  `salt` char(6) NOT NULL COMMENT '密码盐值',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否禁用',
  PRIMARY KEY (`pkId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_role` (
  `pkId` bigint(20) NOT NULL COMMENT '唯一标识',
  `name` varchar(255) NOT NULL COMMENT '角色名称',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否禁用',
  PRIMARY KEY (`pkId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_permission` (
  `pkId` bigint(20) NOT NULL COMMENT '唯一标识',
  `code` varchar(255) NOT NULL COMMENT '权限代码',
  `description` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `role_id` bigint(20) NOT NULL COMMENT '角色标识',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否禁用',
  PRIMARY KEY (`pkId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_user_role` (
  `pkId` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL COMMENT '用户标识',
  `role_id` bigint(20) NOT NULL COMMENT '角色标识',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否禁用',
  PRIMARY KEY (`pkId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_role_permission` (
  `pkId` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL COMMENT '角色标识',
  `permission_id` bigint(20) NOT NULL COMMENT '权限标识',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否禁用',
  PRIMARY KEY (`pkId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;