Create table `payment`(
  id BIGINT(20) not NULL AUTO_INCREMENT COMMENT 'ID',
  serial VARCHAR(200) DEFAULT '',
  PRIMARY KEY(id)
) engine=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;