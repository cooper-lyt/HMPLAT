SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Indexes */

DROP INDEX RELATIONSHIP_11_FK ON DB_PLAT_SYSTEM.WORD;
DROP INDEX RELATIONSHIP_6_FK ON DB_PLAT_SYSTEM.EMPLOYEE;



/* Drop Tables */

DROP TABLE DB_PLAT_SYSTEM.ROLE_FUNCTION;
DROP TABLE DB_PLAT_SYSTEM.FUNCTION;
DROP TABLE DB_PLAT_SYSTEM.SYSTEM_LOG;
DROP TABLE DB_PLAT_SYSTEM.ROLE_EMP;
DROP TABLE DB_PLAT_SYSTEM.EMPLOYEE;
DROP TABLE DB_PLAT_SYSTEM.ORGANIZATION;
DROP TABLE DB_PLAT_SYSTEM.ROLE_BIZ;
DROP TABLE DB_PLAT_SYSTEM.CITY;
DROP TABLE DB_PLAT_SYSTEM.ROLE;
DROP TABLE DB_PLAT_SYSTEM.PROVINCE;
DROP TABLE DB_PLAT_SYSTEM.WORD;
DROP TABLE DB_PLAT_SYSTEM.WORD_CATEGORY;
DROP TABLE DB_PLAT_SYSTEM.SYSTEM_PARAM;
DROP TABLE DB_PLAT_SYSTEM.NUMBER_POOL;
DROP TABLE DB_PLAT_SYSTEM.PERSON;
DROP TABLE DB_PLAT_SYSTEM.BUSINESS_NEED_FILE;
DROP TABLE DB_PLAT_SYSTEM.TASK_SUBSCRIBE;
DROP TABLE DB_PLAT_SYSTEM.BUSINESS_DEFINE;
DROP TABLE DB_PLAT_SYSTEM.BUSINESS_CATEGORY;
DROP TABLE DB_PLAT_SYSTEM.FILE_SUBSCRIBE;




/* Create Tables */

CREATE TABLE DB_PLAT_SYSTEM.FUNCTION
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	NAME VARCHAR(20) NOT NULL COMMENT 'NAME',
	ICON VARCHAR(100) NOT NULL COMMENT 'ICON',
	LOCATION VARCHAR(100) NOT NULL COMMENT '请求位置',
	-- 功能页head上的图片
	BANNER VARCHAR(100) COMMENT 'BANNER',
	PRIORITY INT NOT NULL COMMENT '优先级',
	MEMO VARCHAR(100) COMMENT 'MEMO',
	CATEGORY VARCHAR(20) NOT NULL COMMENT 'CATEGORY',
	NEED_CONVERSATION BOOLEAN NOT NULL COMMENT 'NEED_CONVERSATION',
	CONSTRAINT PK_DGFUNCTION PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '功能' DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.ORGANIZATION
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	PARENT VARCHAR(32) COMMENT '上层组织',
	ROOT BIT(1) NOT NULL COMMENT '根',
	NAME VARCHAR(50) NOT NULL COMMENT 'NAME',
	PHONE_NUMBER VARCHAR(20) COMMENT '电话',
	MEMO VARCHAR(100) COMMENT 'MEMO',
	CONSTRAINT PK_DGORGANISE PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '组织机构' DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.SYSTEM_LOG
(
	ID INT NOT NULL AUTO_INCREMENT COMMENT 'ID',
	DATE TIMESTAMP COMMENT 'DATE',
	THREAD VARCHAR(50) COMMENT 'THREAD',
	LEVEL VARCHAR(10) COMMENT 'LEVEL',
	EMPLOYEE VARCHAR(32) COMMENT 'EMPLOYEE',
	CLASS VARCHAR(100) COMMENT 'CLASS',
	MESSAGES VARCHAR(100) COMMENT 'MESSAGES',
	CONSTRAINT PK_DGSYSTEMLOG PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '日志' DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.ROLE_BIZ
(
	ROLE_ID VARCHAR(32) NOT NULL COMMENT 'ROLE_ID',
	BIZ_ID VARCHAR(32) NOT NULL COMMENT 'BIZ_ID',
	CONSTRAINT PK_DGROLEBIZ PRIMARY KEY (ROLE_ID, BIZ_ID)
) ENGINE = InnoDB COMMENT = 'ROLE_BIZ' DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.ROLE_EMP
(
	EMP_ID VARCHAR(32) NOT NULL COMMENT 'EMP_ID',
	ROL_ID VARCHAR(32) NOT NULL COMMENT 'ROL_ID',
	PRIMARY KEY (EMP_ID, ROL_ID)
) ENGINE = InnoDB COMMENT = 'ROLE_EMP' DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.CITY
(
	PID INT NOT NULL COMMENT 'PID',
	NAME VARCHAR(50) COMMENT 'NAME',
	SORT INT COMMENT 'SORT',
	FID INT NOT NULL COMMENT 'FID',
	PRIMARY KEY (PID)
) ENGINE = InnoDB COMMENT = '市/自治区/自治州' DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.ROLE_FUNCTION
(
	FUN_ID VARCHAR(32) NOT NULL COMMENT 'FUN_ID',
	ROL_ID VARCHAR(32) NOT NULL COMMENT 'ROL_ID',
	CONSTRAINT PK_DGROLEFUNCTION PRIMARY KEY (FUN_ID, ROL_ID)
) ENGINE = InnoDB COMMENT = 'ROLE_FUNCTION' DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.ROLE
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	NAME VARCHAR(20) NOT NULL COMMENT 'NAME',
	DESCRIPTION VARCHAR(200) COMMENT 'DESCRIPTION',
	PRIORITY INT NOT NULL COMMENT '优先级',
	CONSTRAINT PK_DGROLE PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '角色' DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.PROVINCE
(
	PID INT NOT NULL COMMENT 'PID',
	NAME VARCHAR(50) NOT NULL COMMENT 'NAME',
	SORT INT NOT NULL COMMENT 'SORT',
	PRIMARY KEY (PID)
) ENGINE = InnoDB COMMENT = '省/行政区' DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.WORD_CATEGORY
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	NAME VARCHAR(50) NOT NULL COMMENT 'NAME',
	MEMO VARCHAR(100) COMMENT 'MEMO',
	SYSTEM BIT(1) NOT NULL COMMENT 'SYSTEM',
	CONSTRAINT PK_DGWORDBOOKTYPE PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '字典种类' DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.WORD
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	_KEY VARCHAR(50) NOT NULL COMMENT 'KEY',
	_VALUE VARCHAR(100) NOT NULL COMMENT 'VALUE',
	CATEGORY VARCHAR(32) NOT NULL COMMENT 'CATEGORY',
	DESCRIPTION VARCHAR(200) COMMENT 'DESCRIPTION',
	PRIORITY INT NOT NULL COMMENT '优先级',
	ENABLE BIT(1) NOT NULL COMMENT '可用',
	CONSTRAINT PK_DGWORDBOOK PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '字典' DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.SYSTEM_PARAM
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	TYPE VARCHAR(32) NOT NULL COMMENT 'TYPE',
	VALUE VARCHAR(100) NOT NULL COMMENT 'VALUE',
	MEMO VARCHAR(100) COMMENT 'MEMO',
	CONSTRAINT PK_DGSYSTEMPARAM PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '系统参数' DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.NUMBER_POOL
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	NUMBER BIGINT UNSIGNED NOT NULL COMMENT 'NUMBER',
	POOL_SIZE INT NOT NULL COMMENT 'POOL_SIZE',
	PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '号池' DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.PERSON
(
	NAME VARCHAR(50) NOT NULL COMMENT 'NAME',
	CREDENTIALS_TYPE VARCHAR(32) NOT NULL COMMENT '证件类型',
	CREDENTIALS_NUMBER VARCHAR(100) NOT NULL COMMENT '证件号',
	CREDENTIALS_ORGAN VARCHAR(100) NOT NULL COMMENT '发证机关',
	SEX VARCHAR(32) COMMENT '性别',
	ETHNIC VARCHAR(20) COMMENT '民族',
	DATE_OF_BIRTH DATETIME COMMENT '出生日期',
	-- 一般为身份证地址
	ADDRESS VARCHAR(200) COMMENT '地址',
	READ_TIME TIMESTAMP COMMENT 'READ_TIME',
	PRIMARY KEY (CREDENTIALS_TYPE, CREDENTIALS_NUMBER)
) ENGINE = InnoDB COMMENT = '证件' DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.EMPLOYEE
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	ORGANIZATION VARCHAR(32) COMMENT '组织机构',
	JOIN_DATE DATETIME COMMENT '入职时间',
	E_MAIL VARCHAR(20) COMMENT 'E_Mail',
	PASSWORD VARCHAR(100) COMMENT 'PASSWORD',
	ENABLE BIT(1) NOT NULL COMMENT '启用',
	JOB VARCHAR(32) COMMENT '岗位',
	MEMO VARCHAR(100) COMMENT 'MEMO',
	PHONE VARCHAR(20) COMMENT 'PHONE',
	CREDENTIALS_TYPE VARCHAR(32) NOT NULL COMMENT '证件类型',
	CREDENTIALS_NUMBER VARCHAR(100) NOT NULL COMMENT '证件号',
	NAME VARCHAR(50) NOT NULL COMMENT 'NAME',
	CONSTRAINT PK_DGEMPLOYEE PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '员工' DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.BUSINESS_DEFINE
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	NAME VARCHAR(50) NOT NULL COMMENT 'NAME',
	WF_NAME VARCHAR(32) NOT NULL COMMENT '工作流名称',
	START_PAGE VARCHAR(200) COMMENT '启动处理页面',
	CATEGORY VARCHAR(32) NOT NULL COMMENT 'CATEGORY',
	MEMO VARCHAR(200) COMMENT 'MEMO',
	-- 乐观锁
	VERSION INT COMMENT 'VERSION',
	START_PROPAGATION VARCHAR(10) COMMENT '启动页propagation',
	ROLE_PREFIX VARCHAR(20) COMMENT 'ROLE_PREFIX',
	CONSTRAINT PK_DGBIZ PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '业务种类' DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.TASK_SUBSCRIBE
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	DEFINE_ID VARCHAR(32) NOT NULL COMMENT 'DEFINE_ID',
	TASK_NAME VARCHAR(200) COMMENT 'TASK_NAME',
	TYPE VARCHAR(10) NOT NULL COMMENT 'TYPE',
	REG_NAME VARCHAR(200) NOT NULL COMMENT 'REG_NAME',
	PRIORITY INT NOT NULL COMMENT '优先级',
	PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = 'TASK_SUBSCRIBE' DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.BUSINESS_NEED_FILE
(
	NEED_FILE VARCHAR(32) NOT NULL COMMENT 'NEED_FILE',
	BUSINESS VARCHAR(32) NOT NULL COMMENT 'BUSINESS',
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	PRIORITY INT NOT NULL COMMENT '优先级',
	TASK_NAME VARCHAR(200) COMMENT 'TASK_NAME',
	PRIMARY KEY (ID),
	CONSTRAINT UNIQUE_BUSINESS_FILE UNIQUE (NEED_FILE, BUSINESS)
) ENGINE = InnoDB COMMENT = 'BUSINESS_NEED_FILE' DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.BUSINESS_CATEGORY
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	NAME VARCHAR(50) NOT NULL COMMENT 'NAME',
	PRIORITY INT NOT NULL COMMENT '优先级',
	PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '业务种类' DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.FILE_SUBSCRIBE
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	NAME VARCHAR(100) NOT NULL UNIQUE COMMENT 'NAME',
	PARENT_ID VARCHAR(32) COMMENT 'PARENT_ID',
	DESCRIPTION VARCHAR(500) COMMENT 'DESCRIPTION',
	CONSTRAINT PK_DGBIZDOC PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '启动要件' DEFAULT CHARACTER SET utf8;



/* Create Foreign Keys */

ALTER TABLE DB_PLAT_SYSTEM.ROLE_FUNCTION
	ADD CONSTRAINT FK_DGROLEFU_RELATIONS_DGFUNCTI FOREIGN KEY (FUN_ID)
	REFERENCES DB_PLAT_SYSTEM.FUNCTION (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.EMPLOYEE
	ADD CONSTRAINT FK_DGEMPLOY_RELATIONS_DGORGANI FOREIGN KEY (ORGANIZATION)
	REFERENCES DB_PLAT_SYSTEM.ORGANIZATION (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.ORGANIZATION
	ADD CONSTRAINT FK_DGORGANI_REFERENCE_DGORGANI FOREIGN KEY (PARENT)
	REFERENCES DB_PLAT_SYSTEM.ORGANIZATION (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.ROLE_FUNCTION
	ADD FOREIGN KEY (ROL_ID)
	REFERENCES DB_PLAT_SYSTEM.ROLE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.ROLE_BIZ
	ADD CONSTRAINT FK_DGROLEBI_REFERENCE_DGROLE FOREIGN KEY (ROLE_ID)
	REFERENCES DB_PLAT_SYSTEM.ROLE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.ROLE_EMP
	ADD FOREIGN KEY (ROL_ID)
	REFERENCES DB_PLAT_SYSTEM.ROLE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.CITY
	ADD FOREIGN KEY (FID)
	REFERENCES DB_PLAT_SYSTEM.PROVINCE (PID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.WORD
	ADD CONSTRAINT FK_DGWORDBO_RELATIONS_DGWORDBO FOREIGN KEY (CATEGORY)
	REFERENCES DB_PLAT_SYSTEM.WORD_CATEGORY (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.SYSTEM_LOG
	ADD CONSTRAINT FK_DGSYSTEM_REFERENCE_DGEMPLOY FOREIGN KEY (EMPLOYEE)
	REFERENCES DB_PLAT_SYSTEM.EMPLOYEE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.ROLE_EMP
	ADD FOREIGN KEY (EMP_ID)
	REFERENCES DB_PLAT_SYSTEM.EMPLOYEE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.BUSINESS_NEED_FILE
	ADD FOREIGN KEY (BUSINESS)
	REFERENCES DB_PLAT_SYSTEM.BUSINESS_DEFINE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.ROLE_BIZ
	ADD CONSTRAINT FK_DGROLEBI_REFERENCE_DGBIZ FOREIGN KEY (BIZ_ID)
	REFERENCES DB_PLAT_SYSTEM.BUSINESS_DEFINE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.TASK_SUBSCRIBE
	ADD FOREIGN KEY (DEFINE_ID)
	REFERENCES DB_PLAT_SYSTEM.BUSINESS_DEFINE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.BUSINESS_DEFINE
	ADD FOREIGN KEY (CATEGORY)
	REFERENCES DB_PLAT_SYSTEM.BUSINESS_CATEGORY (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.FILE_SUBSCRIBE
	ADD FOREIGN KEY (PARENT_ID)
	REFERENCES DB_PLAT_SYSTEM.FILE_SUBSCRIBE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.BUSINESS_NEED_FILE
	ADD FOREIGN KEY (NEED_FILE)
	REFERENCES DB_PLAT_SYSTEM.FILE_SUBSCRIBE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



/* Create Indexes */

CREATE INDEX RELATIONSHIP_11_FK USING BTREE ON DB_PLAT_SYSTEM.WORD (CATEGORY ASC);
CREATE INDEX RELATIONSHIP_6_FK USING BTREE ON DB_PLAT_SYSTEM.EMPLOYEE (ORGANIZATION ASC);



