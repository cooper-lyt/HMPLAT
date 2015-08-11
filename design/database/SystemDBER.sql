SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Indexes */

DROP INDEX RELATIONSHIP_6_FK ON DB_PLAT_SYSTEM.EMPLOYEE;
DROP INDEX RELATIONSHIP_11_FK ON DB_PLAT_SYSTEM.WORD;



/* Drop Tables */

DROP TABLE IF EXISTS DB_PLAT_SYSTEM.BUSINESS_AND_FEE;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.ROLE_BIZ;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.TASK_SUBSCRIBE;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.CREATE_COMPONENT;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.BUSINESS_NEED_FILE;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.OLD_CREATE_BIZ;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.VIEW_SUBSCRIBE;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.SUBSCRIBE_GROUP;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.BUSINESS_REPROT;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.BUSINESS_DEFINE;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.BUSINESS_CATEGORY;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.CITY;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.ROLE_EMP;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.SYSTEM_LOG;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.EMPLOYEE;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.FEE_TIME_AREA;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.FEE;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.FEE_CATEGORY;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.ROLE_FUNCTION;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.FUNCTION;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.NUMBER_POOL;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.PERSON;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.PROVINCE;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.REPORT;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.ROLE;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.SYSTEM_PARAM;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.WORD;
DROP TABLE IF EXISTS DB_PLAT_SYSTEM.WORD_CATEGORY;




/* Create Tables */

CREATE TABLE DB_PLAT_SYSTEM.BUSINESS_AND_FEE
(
	BUSINESS VARCHAR(32) NOT NULL,
	FEE VARCHAR(32) NOT NULL,
	PRIMARY KEY (BUSINESS, FEE)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.BUSINESS_CATEGORY
(
	ID VARCHAR(32) NOT NULL,
	NAME VARCHAR(50) NOT NULL,
	PRIORITY INT NOT NULL,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.BUSINESS_DEFINE
(
	ID VARCHAR(32) NOT NULL,
	NAME VARCHAR(50) NOT NULL,
	WF_NAME VARCHAR(32) NOT NULL,
	START_PAGE VARCHAR(200),
	CATEGORY VARCHAR(32) NOT NULL,
	MEMO VARCHAR(200),
	-- 乐观锁
	VERSION INT COMMENT '乐观锁',
	START_PROPAGATION VARCHAR(10),
	ROLE_PREFIX VARCHAR(20),
	-- 动态
	DESCRIPTION VARCHAR(500) COMMENT '动态',
	PRIORITY INT NOT NULL,
	ENABLE BOOLEAN NOT NULL,
	PICK_BUSINESS_DEFINE_ID VARCHAR(32),
	MODIFY_PAGE VARCHAR(200),
	MODIFY_SEARCH_PAGE VARCHAR(200),
	CONSTRAINT PK_DGBIZ PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.BUSINESS_NEED_FILE
(
	BUSINESS VARCHAR(32) NOT NULL,
	ID VARCHAR(32) NOT NULL,
	PRIORITY INT NOT NULL,
	TASK_NAME VARCHAR(200),
	PARENT_ID VARCHAR(32),
	-- ALL
	-- ONE
	-- CHILD
	TYPE VARCHAR(20) NOT NULL COMMENT 'ALL
ONE
CHILD',
	NAME VARCHAR(50) NOT NULL,
	DESCRIPTION VARCHAR(200),
	_CONDITION VARCHAR(500),
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.BUSINESS_REPROT
(
	BUSINESS VARCHAR(32) NOT NULL,
	REPORT VARCHAR(32) NOT NULL,
	TASK_NAME VARCHAR(100) NOT NULL,
	ID VARCHAR(32) NOT NULL,
	PRIORITY INT NOT NULL,
	PRIMARY KEY (ID),
	CONSTRAINT BUSINESS_REPORT_UNIQUE UNIQUE (BUSINESS, REPORT, TASK_NAME)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.CITY
(
	PID INT NOT NULL,
	NAME VARCHAR(50),
	SORT INT,
	FID INT NOT NULL,
	PRIMARY KEY (PID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.CREATE_COMPONENT
(
	ID VARCHAR(32) NOT NULL,
	COMPONENT VARCHAR(50) NOT NULL,
	PRIORITY INT NOT NULL,
	BUSINESS_ID VARCHAR(32) NOT NULL,
	TYPE VARCHAR(20) NOT NULL,
	PRIMARY KEY (ID),
	CONSTRAINT BUSINESS_AND_VALIDATION_UNIQUE UNIQUE (COMPONENT, BUSINESS_ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.EMPLOYEE
(
	ID VARCHAR(32) NOT NULL,
	JOIN_DATE DATETIME NOT NULL,
	E_MAIL VARCHAR(20),
	PASSWORD VARCHAR(32) NOT NULL,
	ENABLE BIT(1) NOT NULL,
	PHONE VARCHAR(20),
	NAME VARCHAR(100) NOT NULL,
	PY_CODE VARCHAR(100),
	CONSTRAINT PK_DGEMPLOYEE PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.FEE
(
	ID VARCHAR(32) NOT NULL,
	CATEGORY VARCHAR(32) NOT NULL,
	NAME VARCHAR(50) NOT NULL,
	DESCRIPTION VARCHAR(400),
	FEE_EL VARCHAR(500),
	DETAILS_EL VARCHAR(500),
	PRIORITY INT NOT NULL,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.FEE_CATEGORY
(
	ID VARCHAR(32) NOT NULL,
	NAME VARCHAR(50) NOT NULL,
	PRIORITY INT NOT NULL,
	DESCRIPTION VARCHAR(400),
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.FEE_TIME_AREA
(
	ID VARCHAR(32) NOT NULL,
	FEE VARCHAR(32) NOT NULL,
	BEGIN_TIME DATETIME NOT NULL,
	END_TIME DATETIME NOT NULL,
	CONDITION_EL VARCHAR(500),
	FEE_EL VARCHAR(500) NOT NULL,
	DETAILS_EL VARCHAR(500) NOT NULL,
	DESCRIPTION VARCHAR(400),
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.FUNCTION
(
	ID VARCHAR(32) NOT NULL,
	NAME VARCHAR(20) NOT NULL,
	ICON VARCHAR(100) NOT NULL,
	LOCATION VARCHAR(100) NOT NULL,
	-- 功能页head上的图片
	BANNER VARCHAR(100) COMMENT '功能页head上的图片',
	PRIORITY INT NOT NULL,
	MEMO VARCHAR(100),
	CATEGORY VARCHAR(20) NOT NULL,
	NEED_CONVERSATION BOOLEAN NOT NULL,
	CONSTRAINT PK_DGFUNCTION PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.NUMBER_POOL
(
	ID VARCHAR(32) NOT NULL,
	NUMBER BIGINT UNSIGNED NOT NULL,
	POOL_SIZE INT NOT NULL,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.OLD_CREATE_BIZ
(
	ROL VARCHAR(32) NOT NULL,
	BIZ VARCHAR(32) NOT NULL,
	PRIMARY KEY (ROL, BIZ)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.PERSON
(
	NAME VARCHAR(50) NOT NULL,
	CREDENTIALS_TYPE VARCHAR(32) NOT NULL,
	CREDENTIALS_NUMBER VARCHAR(100) NOT NULL,
	CREDENTIALS_ORGAN VARCHAR(100),
	SEX VARCHAR(32),
	ETHNIC VARCHAR(20),
	DATE_OF_BIRTH DATETIME,
	-- 一般为身份证地址
	ADDRESS VARCHAR(200) COMMENT '一般为身份证地址',
	READ_TIME TIMESTAMP NOT NULL,
	PHONE VARCHAR(20),
	PRIMARY KEY (CREDENTIALS_TYPE, CREDENTIALS_NUMBER)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.PROVINCE
(
	PID INT NOT NULL,
	NAME VARCHAR(50) NOT NULL,
	SORT INT NOT NULL,
	PRIMARY KEY (PID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.REPORT
(
	ID VARCHAR(32) NOT NULL,
	NAME VARCHAR(100) NOT NULL,
	DESCRIPTION VARCHAR(200),
	PAGE VARCHAR(200) NOT NULL,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.ROLE
(
	ID VARCHAR(32) NOT NULL,
	NAME VARCHAR(20) NOT NULL,
	DESCRIPTION VARCHAR(200),
	PRIORITY INT NOT NULL,
	CONSTRAINT PK_DGROLE PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.ROLE_BIZ
(
	ROLE_ID VARCHAR(32) NOT NULL,
	BIZ_ID VARCHAR(32) NOT NULL,
	CONSTRAINT PK_DGROLEBIZ PRIMARY KEY (ROLE_ID, BIZ_ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.ROLE_EMP
(
	EMP_ID VARCHAR(32) NOT NULL,
	ROL_ID VARCHAR(32) NOT NULL,
	PRIMARY KEY (EMP_ID, ROL_ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.ROLE_FUNCTION
(
	FUN_ID VARCHAR(32) NOT NULL,
	ROL_ID VARCHAR(32) NOT NULL,
	CONSTRAINT PK_DGROLEFUNCTION PRIMARY KEY (FUN_ID, ROL_ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.SUBSCRIBE_GROUP
(
	ID VARCHAR(32) NOT NULL,
	NAME VARCHAR(30) NOT NULL,
	PRIORITY INT NOT NULL,
	TASK_NAME VARCHAR(200),
	TYPE VARCHAR(20) NOT NULL,
	DEFINE_ID VARCHAR(32) NOT NULL,
	ICON_CSS VARCHAR(100),
	GROUP_WIDTH INT,
	KEY_WIDTH INT,
	VALUE_WIDTH INT,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.SYSTEM_LOG
(
	ID INT NOT NULL AUTO_INCREMENT,
	DATE TIMESTAMP,
	THREAD VARCHAR(50),
	LEVEL VARCHAR(10),
	EMPLOYEE VARCHAR(32),
	CLASS VARCHAR(100),
	MESSAGES VARCHAR(100),
	CONSTRAINT PK_DGSYSTEMLOG PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.SYSTEM_PARAM
(
	ID VARCHAR(32) NOT NULL,
	TYPE VARCHAR(32) NOT NULL,
	VALUE VARCHAR(100) NOT NULL,
	MEMO VARCHAR(100),
	CONSTRAINT PK_DGSYSTEMPARAM PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.TASK_SUBSCRIBE
(
	ID VARCHAR(32) NOT NULL,
	DEFINE_ID VARCHAR(32) NOT NULL,
	TASK_NAME VARCHAR(200),
	TYPE VARCHAR(20) NOT NULL,
	REG_NAME VARCHAR(200) NOT NULL,
	PRIORITY INT NOT NULL,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.VIEW_SUBSCRIBE
(
	ID VARCHAR(32) NOT NULL,
	REG_NAME VARCHAR(200) NOT NULL,
	PRIORITY INT NOT NULL,
	GROUP_ID VARCHAR(32) NOT NULL,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.WORD
(
	ID VARCHAR(32) NOT NULL,
	_KEY VARCHAR(50) NOT NULL,
	_VALUE VARCHAR(100) NOT NULL,
	CATEGORY VARCHAR(32) NOT NULL,
	DESCRIPTION VARCHAR(200),
	PRIORITY INT NOT NULL,
	ENABLE BIT(1) NOT NULL,
	CONSTRAINT PK_DGWORDBOOK PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE DB_PLAT_SYSTEM.WORD_CATEGORY
(
	ID VARCHAR(32) NOT NULL,
	NAME VARCHAR(50) NOT NULL,
	MEMO VARCHAR(100),
	SYSTEM BIT(1) NOT NULL,
	CONSTRAINT PK_DGWORDBOOKTYPE PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;



/* Create Foreign Keys */

ALTER TABLE DB_PLAT_SYSTEM.BUSINESS_DEFINE
	ADD FOREIGN KEY (CATEGORY)
	REFERENCES DB_PLAT_SYSTEM.BUSINESS_CATEGORY (ID)
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


ALTER TABLE DB_PLAT_SYSTEM.CREATE_COMPONENT
	ADD FOREIGN KEY (BUSINESS_ID)
	REFERENCES DB_PLAT_SYSTEM.BUSINESS_DEFINE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.BUSINESS_NEED_FILE
	ADD FOREIGN KEY (BUSINESS)
	REFERENCES DB_PLAT_SYSTEM.BUSINESS_DEFINE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.OLD_CREATE_BIZ
	ADD FOREIGN KEY (BIZ)
	REFERENCES DB_PLAT_SYSTEM.BUSINESS_DEFINE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.SUBSCRIBE_GROUP
	ADD FOREIGN KEY (DEFINE_ID)
	REFERENCES DB_PLAT_SYSTEM.BUSINESS_DEFINE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.BUSINESS_REPROT
	ADD FOREIGN KEY (BUSINESS)
	REFERENCES DB_PLAT_SYSTEM.BUSINESS_DEFINE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.BUSINESS_AND_FEE
	ADD FOREIGN KEY (BUSINESS)
	REFERENCES DB_PLAT_SYSTEM.BUSINESS_DEFINE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.BUSINESS_NEED_FILE
	ADD FOREIGN KEY (PARENT_ID)
	REFERENCES DB_PLAT_SYSTEM.BUSINESS_NEED_FILE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.ROLE_EMP
	ADD FOREIGN KEY (EMP_ID)
	REFERENCES DB_PLAT_SYSTEM.EMPLOYEE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.SYSTEM_LOG
	ADD CONSTRAINT FK_DGSYSTEM_REFERENCE_DGEMPLOY FOREIGN KEY (EMPLOYEE)
	REFERENCES DB_PLAT_SYSTEM.EMPLOYEE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.FEE_TIME_AREA
	ADD FOREIGN KEY (FEE)
	REFERENCES DB_PLAT_SYSTEM.FEE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.BUSINESS_AND_FEE
	ADD FOREIGN KEY (FEE)
	REFERENCES DB_PLAT_SYSTEM.FEE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.FEE
	ADD FOREIGN KEY (CATEGORY)
	REFERENCES DB_PLAT_SYSTEM.FEE_CATEGORY (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.ROLE_FUNCTION
	ADD CONSTRAINT FK_DGROLEFU_RELATIONS_DGFUNCTI FOREIGN KEY (FUN_ID)
	REFERENCES DB_PLAT_SYSTEM.FUNCTION (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.CITY
	ADD FOREIGN KEY (FID)
	REFERENCES DB_PLAT_SYSTEM.PROVINCE (PID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.BUSINESS_REPROT
	ADD FOREIGN KEY (REPORT)
	REFERENCES DB_PLAT_SYSTEM.REPORT (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.OLD_CREATE_BIZ
	ADD FOREIGN KEY (ROL)
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


ALTER TABLE DB_PLAT_SYSTEM.ROLE_BIZ
	ADD CONSTRAINT FK_DGROLEBI_REFERENCE_DGROLE FOREIGN KEY (ROLE_ID)
	REFERENCES DB_PLAT_SYSTEM.ROLE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.ROLE_FUNCTION
	ADD FOREIGN KEY (ROL_ID)
	REFERENCES DB_PLAT_SYSTEM.ROLE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.VIEW_SUBSCRIBE
	ADD FOREIGN KEY (GROUP_ID)
	REFERENCES DB_PLAT_SYSTEM.SUBSCRIBE_GROUP (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE DB_PLAT_SYSTEM.WORD
	ADD CONSTRAINT FK_DGWORDBO_RELATIONS_DGWORDBO FOREIGN KEY (CATEGORY)
	REFERENCES DB_PLAT_SYSTEM.WORD_CATEGORY (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



/* Create Indexes */

CREATE INDEX RELATIONSHIP_6_FK USING BTREE ON DB_PLAT_SYSTEM.EMPLOYEE ();
CREATE INDEX RELATIONSHIP_11_FK USING BTREE ON DB_PLAT_SYSTEM.WORD (CATEGORY ASC);



