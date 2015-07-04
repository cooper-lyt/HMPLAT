SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.BUILD;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.BUSINESS_EMP;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.UPLOAD_FILE;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.BUSINESS_FILE;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.RECORD_STORE;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.NEW_HOUSE_CONTRACT_SALE;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.NEW_HOUSE_CONTRACT_PRESALE;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.HOUSE_COMMERCI_CONTRACT;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.CONTRACT_MORTGAGE;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.HOUSE_CONTRACT;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.BUSINESS_HOUSE;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.BUSINESS_MONEY;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.HOUSE_REG_INFO;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.HOUSE_RECORD;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.OTHER_POWER_CARD_AND_HOUSE;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.HOUSE_STATE;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.HOUSE_POOL;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.HOUSE_AND_MOR;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.HOUSE;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.BUSINESS_OWNER;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.BUSINESS_PERSION;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.BUSINESS_POOL;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.CARD;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.OTHER_POWER_CARD;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.CARD_INFO;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.CLOSE_HOUSE;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.EVALUATE;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.MORTGAEGE_REGISTE;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.FINANCIAL;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.HOUSE_CLOSE_CANCEL;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.LAND_INFO;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.LOCKED_HOUSE;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.PROJECT_RECORD_STORE;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.PROJECT_RECORD;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.PROJECT_SELL_CARD;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.MAKE_CARD;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.MAPPING_CORP;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.NUMBER_POOL;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.REASON;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.PROJECT;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.SALE_INFO;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.PROCESS_MESSAGES;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.TASK_OPER;
DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.OWNER_BUSINESS;




/* Create Tables */

CREATE TABLE HOUSE_OWNER_RECORD.BUILD
(
	ID VARCHAR(32) NOT NULL,
	MAP_NUMBER VARCHAR(4),
	BLOCK_NO VARCHAR(10) NOT NULL,
	BUILD_NO VARCHAR(4) NOT NULL,
	BUILD_CODE VARCHAR(32) NOT NULL,
	STREET_CODE VARCHAR(4),
	NAME VARCHAR(100) NOT NULL,
	DOOR_NO VARCHAR(32),
	UNINT_COUNT INT,
	FLOOR_COUNT INT NOT NULL,
	UP_FLOOR_COUNT INT NOT NULL,
	DOWN_FLOOR_COUNT INT NOT NULL,
	ADDRESS VARCHAR(50),
	HOUSE_COUNT INT,
	AREA DECIMAL(18,3),
	LNG DECIMAL(18,14),
	LAT DECIMAL(18,14),
	BUILD_TYPE VARCHAR(32),
	STRUCTURE VARCHAR(32) NOT NULL,
	HOME_COUNT INT,
	HOME_AREA DECIMAL(18,3),
	UNHOME_COUNT INT,
	UNHOME_AREA DECIMAL(18,3),
	SHOP_COUNT INT,
	SHOP_AREA DECIMAL(18,3),
	PROJECT VARCHAR(32) NOT NULL,
	COMPLETE_DATE VARCHAR(6),
	BUILD_DEVELOPER_NUMBER VARCHAR(20),
	CONSTRAINT PK_BUILD PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.BUSINESS_EMP
(
	ID VARCHAR(32) NOT NULL,
	TYPE VARCHAR(20) NOT NULL,
	EMP_CODE VARCHAR(32) NOT NULL,
	EMP_NAME VARCHAR(50) NOT NULL,
	-- 倒库导入原库的NO
	BUSINESS_ID VARCHAR(32) NOT NULL COMMENT '倒库导入原库的NO',
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.BUSINESS_FILE
(
	ID VARCHAR(32) NOT NULL,
	-- 倒库导入原库的NO
	BUSINESS_ID VARCHAR(32) NOT NULL COMMENT '倒库导入原库的NO',
	NAME VARCHAR(100) NOT NULL,
	IMPORTANT_CODE VARCHAR(32),
	NO_FILE BOOLEAN NOT NULL,
	IMPORTANT BOOLEAN NOT NULL,
	MEMO VARCHAR(200),
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.BUSINESS_HOUSE
(
	ID VARCHAR(32) NOT NULL,
	HOUSE_CODE VARCHAR(32) NOT NULL,
	-- 倒库导入原库的NO
	BUSINESS_ID VARCHAR(32) NOT NULL COMMENT '倒库导入原库的NO',
	START_HOUSE VARCHAR(32) NOT NULL,
	AFTER_HOUSE VARCHAR(32),
	CONSTRAINT PK_HOUSE PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.BUSINESS_MONEY
(
	ID VARCHAR(32) NOT NULL,
	MONEY_TYPE_ID VARCHAR(20) NOT NULL,
	SHOULD_MONEY DECIMAL(18,3),
	FACT_MONEY DECIMAL(18,3),
	CHARGE_DETAILS VARCHAR(200),
	MEMO VARCHAR(200),
	-- 倒库导入原库的NO
	BUSINESS VARCHAR(32) NOT NULL COMMENT '倒库导入原库的NO',
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.BUSINESS_OWNER
(
	ID VARCHAR(32) NOT NULL,
	NAME VARCHAR(50) NOT NULL,
	ID_TYPE VARCHAR(32) NOT NULL,
	ID_NO VARCHAR(100) NOT NULL,
	PHONE VARCHAR(15) NOT NULL,
	ROOT_ADDRESS VARCHAR(50),
	CARD VARCHAR(32),
	LEGAL_PERSON VARCHAR(50),
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.BUSINESS_PERSION
(
	ID VARCHAR(32) NOT NULL,
	ID_NO VARCHAR(100) NOT NULL,
	ID_TYPE VARCHAR(32) NOT NULL,
	NAME VARCHAR(50) NOT NULL,
	TYPE VARCHAR(20) NOT NULL,
	-- 倒库导入原库的NO
	BUSINESS_ID VARCHAR(32) NOT NULL COMMENT '倒库导入原库的NO',
	PHONE VARCHAR(15),
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.BUSINESS_POOL
(
	ID VARCHAR(32) NOT NULL,
	NAME VARCHAR(50) NOT NULL,
	ID_TYPE VARCHAR(32) NOT NULL,
	ID_NO VARCHAR(100) NOT NULL,
	RELATION VARCHAR(32),
	POOL_AREA DECIMAL(19,4),
	PERC VARCHAR(10),
	PHONE VARCHAR(15),
	CARD VARCHAR(32),
	CREATE_TIME TIMESTAMP NOT NULL,
	MEMO VARCHAR(200),
	ROOT_ADDRESS VARCHAR(50),
	LEGAL_PERSON VARCHAR(50),
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


-- 记录业务关联时，权证号，和同同，法律文件号，等相关证件的正价编号
CREATE TABLE HOUSE_OWNER_RECORD.CARD
(
	ID VARCHAR(32) NOT NULL,
	TYPE VARCHAR(20) NOT NULL,
	NUMBER VARCHAR(100) NOT NULL,
	-- 倒库导入原库的NO
	BUSINESS_ID VARCHAR(32) NOT NULL COMMENT '倒库导入原库的NO',
	PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '记录业务关联时，权证号，和同同，法律文件号，等相关证件的正价编号' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.CARD_INFO
(
	CODE VARCHAR(100),
	MEMO VARCHAR(200),
	MAKE_EMP_CODE VARCHAR(32) NOT NULL,
	MAKE_EMP_NAME VARCHAR(50) NOT NULL,
	PRINT_TIME TIMESTAMP,
	ID VARCHAR(32) NOT NULL,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.CLOSE_HOUSE
(
	ID VARCHAR(32) NOT NULL,
	CLOSE_DOWN_CLOUR VARCHAR(100) NOT NULL,
	ACTION VARCHAR(100),
	CLOSE_DATE DATETIME NOT NULL,
	TO_DATE DATETIME,
	-- 倒库导入原库的NO
	BUSINESS_ID VARCHAR(32) NOT NULL COMMENT '倒库导入原库的NO',
	-- 裁定书、判决书或其它生效的法律文书
	LEGAL_DOCUMENTS VARCHAR(50) COMMENT '裁定书、判决书或其它生效的法律文书',
	EXECUTION_NOTICE VARCHAR(50),
	SEND_PEOPLE VARCHAR(10),
	PHONE VARCHAR(15),
	EXECUTION_CARD_NO VARCHAR(30),
	WORK_CARD_NO VARCHAR(30),
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.CONTRACT_MORTGAGE
(
	ID VARCHAR(32) NOT NULL,
	COMMERCI_ID VARCHAR(32) NOT NULL,
	IS_MORTGAGE VARCHAR(32),
	MORTGAGE_TYPE VARCHAR(60),
	MORTGAGE_PEOPRE VARCHAR(60),
	MORTGAGE_OBLIGEE VARCHAR(100),
	MORTGAGE_REGISTER VARCHAR(100),
	MORTGAGE_TIME VARCHAR(100),
	CONTRACT VARCHAR(32) NOT NULL,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.EVALUATE
(
	EVALUATE_CORP_NAME VARCHAR(60),
	EVALUATE_CORP_N0 VARCHAR(32),
	ASSESSMENT_PRICE DECIMAL(19,4) NOT NULL,
	ID VARCHAR(32) NOT NULL,
	-- 倒库导入原库的NO
	BUSINESS_ID VARCHAR(32) NOT NULL COMMENT '倒库导入原库的NO',
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.FINANCIAL
(
	ID VARCHAR(32) NOT NULL,
	NAME VARCHAR(120) NOT NULL,
	CODE VARCHAR(100),
	PHONE VARCHAR(15),
	-- 个人
	-- 机构
	FINANCIAL_TYPE VARCHAR(20) NOT NULL COMMENT '个人
机构',
	ID_TYPE VARCHAR(32),
	BANK VARCHAR(32),
	CREATE_TIME TIMESTAMP NOT NULL,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.HOUSE
(
	ID VARCHAR(32) NOT NULL,
	HOUSE_ORDER VARCHAR(20) NOT NULL,
	HOUSE_UNIT_NAME VARCHAR(20),
	IN_FLOOR_NAME VARCHAR(50) NOT NULL,
	HOUSE_AREA DECIMAL(18,3) NOT NULL,
	USE_AREA DECIMAL(18,3),
	COMM_AREA DECIMAL(18,3),
	SHINE_AREA DECIMAL(18,10),
	LOFT_AREA DECIMAL(18,3),
	COMM_PARAM DECIMAL(18,3),
	HOUSE_TYPE VARCHAR(32),
	USE_TYPE VARCHAR(32) NOT NULL,
	STRUCTURE VARCHAR(32) NOT NULL,
	KNOT_SIZE VARCHAR(32),
	ADDRESS VARCHAR(200) NOT NULL,
	EAST_WALL VARCHAR(32),
	WEST_WALL VARCHAR(32),
	SOUTH_WALL VARCHAR(32),
	NORTH_WALL VARCHAR(32),
	MAP_TIME TIMESTAMP,
	DIRECTION VARCHAR(32),
	HOUSE_CODE VARCHAR(32) NOT NULL,
	HAVE_DOWN_ROOM BOOLEAN NOT NULL,
	BUILD_CODE VARCHAR(32) NOT NULL,
	MAP_NUMBER VARCHAR(4),
	BLOCK_NO VARCHAR(10) NOT NULL,
	BUILD_NO VARCHAR(4) NOT NULL,
	STREET_CODE VARCHAR(4),
	DOOR_NO VARCHAR(32),
	UP_FLOOR_COUNT INT NOT NULL,
	FLOOR_COUNT INT NOT NULL,
	DOWN_FLOOR_COUNT INT NOT NULL,
	BUILD_TYPE VARCHAR(32),
	PROJECT_CODE VARCHAR(32) NOT NULL,
	PROJECT_NAME VARCHAR(50) NOT NULL,
	BUILD_SIZE VARCHAR(32),
	COMPLETE_DATE VARCHAR(6),
	DEVELOPER_CODE VARCHAR(32),
	DEVELOPER_NAME VARCHAR(100),
	SECTION_CODE VARCHAR(32) NOT NULL,
	SECTION_NAME VARCHAR(50) NOT NULL,
	DISTRICT_CODE VARCHAR(32) NOT NULL,
	DISTRICT_NAME VARCHAR(100) NOT NULL,
	BUILD_NAME VARCHAR(100) NOT NULL,
	BUILD_DEVELOPER_NUMBER VARCHAR(20),
	HOUSE_STATUS VARCHAR(32),
	POOL_MEMO VARCHAR(32) NOT NULL,
	MAIN_OWNER VARCHAR(32),
	LAND_INFO VARCHAR(32),
	CONSTRAINT PK_HOUSE PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.HOUSE_AND_MOR
(
	HOUSE VARCHAR(32) NOT NULL,
	MOR VARCHAR(32) NOT NULL,
	PRIMARY KEY (HOUSE, MOR)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.HOUSE_CLOSE_CANCEL
(
	ID VARCHAR(32) NOT NULL,
	CANCEL_DATE DATETIME NOT NULL,
	-- 倒库导入原库的NO
	BUSINESS_ID VARCHAR(32) NOT NULL COMMENT '倒库导入原库的NO',
	CANCEL_DOWN_CLOUR VARCHAR(100) NOT NULL,
	ACTION VARCHAR(100),
	OPEN_DATE DATETIME,
	-- 裁定书、判决书或其它生效的法律文书
	LEGAL_DOCUMENTS VARCHAR(50) COMMENT '裁定书、判决书或其它生效的法律文书',
	EXECUTION_NOTICE VARCHAR(50),
	SEND_PEOPLE VARCHAR(10),
	PHONE VARCHAR(15),
	EXECUTION_CARD_NO VARCHAR(30),
	WORK_CARD_NO VARCHAR(30),
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.HOUSE_COMMERCI_CONTRACT
(
	COMMERCI_TYPE VARCHAR(32) NOT NULL,
	HTDSR_CMR VARCHAR(100) NOT NULL,
	HTDSR_CMR_DZ VARCHAR(100) NOT NULL,
	HTDSR_CMR_YB VARCHAR(15),
	HTDSR_CMR_YYZZ VARCHAR(30) NOT NULL,
	HTDSR_CMR_QYZSH VARCHAR(30) NOT NULL,
	HTDSR_CMR_FDDBR VARCHAR(10) NOT NULL,
	HTDSR_CMR_FDDBRDH VARCHAR(15) NOT NULL,
	HTDSR_CMR_WTDLR VARCHAR(10),
	HTDSR_CMR_WTDLRDH VARCHAR(15),
	XMJSYJ_TDQDFS VARCHAR(32) NOT NULL,
	XMJSYJ_TDZL VARBINARY(50) NOT NULL,
	XMJSYJ_TDSQQQLX VARCHAR(32) NOT NULL,
	XMJSYJ_TDQZH VARCHAR(30) NOT NULL,
	XMJSYJ_TDMJ DECIMAL(18,3) NOT NULL,
	XMJSYJ_TDYT VARCHAR(20) NOT NULL,
	XMJSYJ_TDSYQZZSJ TIMESTAMP NOT NULL,
	XMJSYJ_XMMC VARCHAR(100) NOT NULL,
	XMJSYJ_JSGCGHXKZH VARCHAR(50) NOT NULL,
	XMJSYJ_JZGCSGXUKZH VARCHAR(50) NOT NULL,
	SPFJBQK_FWSJYT VARCHAR(32) NOT NULL,
	SPFJBQK_FWJG VARCHAR(32) NOT NULL,
	SPFJBQK_FWJZZCS INT NOT NULL,
	SPFJBQK_FWJZDSCS INT NOT NULL,
	SPFJBQK_FWJZDXCS INT NOT NULL,
	SPFJBQK_ZH VARCHAR(20) NOT NULL,
	SPFJBQK_ZUOHAO VARCHAR(20),
	SPFJBQK_DYH VARCHAR(10) NOT NULL,
	SPFJBQK_CH VARCHAR(10) NOT NULL,
	SPFJBQK_CHJG VARCHAR(50) NOT NULL,
	SPFJBQK_JZMJ DECIMAL(18,3) NOT NULL,
	SPFJBQK_TNMJ DECIMAL(18,3) NOT NULL,
	SPFJBQK_FTMJ DECIMAL(18,3) NOT NULL,
	CGW DECIMAL(8,3) NOT NULL,
	YGYT INT NOT NULL,
	YJGFBYT INT NOT NULL,
	FBYTGS INT NOT NULL,
	FWQLZKQN4 VARCHAR(100),
	FWQLZKQN5 VARCHAR(100),
	AZ VARCHAR(10),
	FWQLZKCN_CFFS VARCHAR(32),
	DJZ INT,
	TNMJ_BZ1 VARCHAR(32),
	TNMJ_Y1 DECIMAL(18,3),
	TNMJ_ZJKBZ1 VARCHAR(32),
	TNMJ_ZJK1 DECIMAL(18,3),
	TNMJ_ZJKDX1 VARCHAR(50),
	JZMJ_BZ2 VARCHAR(32),
	JZMJ_Y2 DECIMAL(18,3),
	JZMJ_ZJKBZ2 VARCHAR(32),
	JZMJ_ZJK2 DECIMAL(18,3),
	ZJKDX2 VARCHAR(50),
	T_BZ3 VARCHAR(32),
	T_ZJK3 DECIMAL(18,3),
	T_ZJKDX3 VARCHAR(50),
	QT_AZJS VARCHAR(20),
	QT_BZ4 VARCHAR(32),
	QT_ZJK4 DECIMAL(18,3),
	QT_ZJKDX4 VARCHAR(50),
	FKFSJQX_BZ1 VARCHAR(32),
	FKFSJQX_ZJK1 VARCHAR(50),
	FKFSJQX_DJJFFS VARCHAR(32),
	FKFSJQX_DYSPFJK VARCHAR(32),
	DJZFKFS INT,
	YCXFK_YCXFKSJ TIMESTAMP,
	FQFK_FQFKSJ TIMESTAMP,
	FQFK_FJQ INT,
	FQFK_SQFJKBZ VARCHAR(32),
	FQFK_SQFJKY DECIMAL(18,3),
	FQFK_SQFJKDX VARCHAR(50),
	FQFK_YDY TIMESTAMP,
	FQFK_YDYBZ VARCHAR(100),
	DKFS_DKFS VARCHAR(32),
	DKFS_MSRSFSJ TIMESTAMP,
	DKFS_DKSFBZ VARCHAR(32),
	DKFS_DKSFY DECIMAL(18,3),
	DKFS_DKSFKDX VARCHAR(50),
	DKFS_ZQBFKBFB VARCHAR(10),
	DKFS_YKBZ VARCHAR(32),
	DKFS_YK DECIMAL(18,3),
	DKFS_YKDX VARCHAR(100),
	DKFS_DKJG VARCHAR(100),
	FKQTFS VARCHAR(200),
	YQFKZEFS INT,
	YQJR1 INT,
	YFKWFZJ1 DECIMAL(8,3),
	YQFKZR_YQCGJR INT,
	SDZRQ INT,
	YFKBFB DECIMAL(8,3),
	YFKWFZJ2 DECIMAL(8,3),
	YQFKZRBZ2 VARCHAR(200),
	FHTJ3 INT,
	FHTJ4 INT,
	FHTJMEMO3 VARCHAR(100),
	FHTJMEMO4 VARCHAR(100),
	JCSSSB1 VARCHAR(100),
	JCSSSB2 VARCHAR(100),
	JCSSSB3 VARCHAR(100),
	JCSSSB4 VARCHAR(100),
	AZXLDJZCL INT,
	ZFWYJ5 DECIMAL(18,3),
	ZFWYJ6 DECIMAL(18,3),
	ZFWYJ7 DECIMAL(18,3),
	YDJFRHDJR INT,
	JFSYTJMEMO2 VARCHAR(100),
	LDLSJ TIMESTAMP,
	LDLMEMO VARCHAR(50),
	SZDLSJ TIMESTAMP,
	SZDLSJMEMO VARCHAR(50),
	GHDCWSJ TIMESTAMP,
	GHDCWMEMO VARCHAR(50),
	WYFWYF TIMESTAMP,
	WYFWYFMEMO VARCHAR(50),
	YLWSJG TIMESTAMP,
	YLWSJGMEMO VARCHAR(50),
	YEY TIMESTAMP,
	YEYMEMO VARCHAR(50),
	XX TIMESTAMP,
	XXMEMO VARCHAR(50),
	GGFWJPT8 VARCHAR(100),
	GGFWJPT9 VARCHAR(100),
	XQLDPCSM VARCHAR(50),
	FSZDLPCSM VARCHAR(50),
	CWCKPCSM VARCHAR(50),
	WYFWYFSM VARCHAR(50),
	QTSSWDDSM VARCHAR(50),
	CMRJHSH TIMESTAMP,
	JMQ INT,
	JFSJHSX2 VARCHAR(100),
	CYCRQ INT,
	CYFWBZ5 VARCHAR(100),
	CYFWBZ6 VARCHAR(100),
	CYFWBZ7 VARCHAR(100),
	CYFWBZ8 VARCHAR(100),
	YQJFCLFS INT,
	YQZDJRZN INT,
	WFZJ1 DECIMAL(8,3),
	YQCGJR INT,
	YQCGAZBFB2 DECIMAL(8,3),
	FJKDBFB2 DECIMAL(8,3),
	FJKWFZJ2 DECIMAL(8,3),
	YQJFZR2BZ VARCHAR(100),
	SPFZLJBXZR_BFB1 DECIMAL(8,3),
	SPFZLJBXZR_MEMO1 VARCHAR(100),
	SPFZLJBXZR_MEMO2 VARCHAR(100),
	SPFZLJBXZR_BFB2 DECIMAL(18,3),
	SPFZLJBXZR_QT_MEMO3 VARCHAR(100),
	SPFZLJBXZR_ZXBZ2 INT,
	SPFZLJBXZR_ZXBZ3 INT,
	SPFZLJBXZR_MEMO3 VARCHAR(100),
	SPFZLJBXZR_MEMO4 VARCHAR(100),
	-- 国家，地方
	SPFZLJBXZR_KQZLBZ VARCHAR(32) COMMENT '国家，地方',
	SPFZLJBXZR_KQBZMC VARBINARY(100),
	SPFZLJBXZR_KQBZWH VARCHAR(50),
	-- 国家，地方
	SPFZLJBXZR_GYBZ VARCHAR(32) COMMENT '国家，地方',
	SPFZLJBXZR_AZ DECIMAL(8,3),
	SPFZLJBXZR_MEMO5 VARCHAR(100),
	SPFZLJBXZR_BXZE_MEMO6 VARBINARY(100),
	SPFZLJBXZR_BXZE_HMRR INT,
	SPFZLJBXZR_ZLDB_Y VARCHAR(50),
	HTBAYFWDJ_QQWYGL_MC VARCHAR(50),
	HTBAYFWDJ_QQWYGL_FWSJQ TIMESTAMP,
	HTBAYFWDJ_QQWYGL_FWSJZ TIMESTAMP,
	HTBAYFWDJ_QQWYGL_WYJFFS VARCHAR(32),
	HTBAYFWDJ_QQWYGL_MYWYF DECIMAL(10,3),
	QTSX_JZWQFSYQ_MEMO1 VARCHAR(100),
	QTSX_JZWQFSYQ_CKCW VARCHAR(50),
	QTSX_JZWQFSYQ_HS VARCHAR(100),
	QTSX_JZWQFSYQ_MEMO3 VARCHAR(100),
	QTSX_SXHSYQCN_MEMO6 VARCHAR(100),
	QTSX_SXHSYQCN_MEMO7 VARCHAR(100),
	QTSX_SD_FS VARCHAR(32),
	QTSX_SD_BGZR INT,
	QTSX_ZYJJFS_FSJW INT,
	QTSX_ZYJJFS_ZCWYHMC VARCHAR(50),
	QTSX_HTSX_BHTYS INT,
	QTSX_HTSX_HTFS INT,
	QTSX_HTSX_CMRFS INT,
	QTSX_HTSX_MSRFS INT,
	QTSX_HTSX_MC1 INT UNSIGNED ZEROFILL,
	QTSX_HTSX_FS1 INT,
	QTSX_HTSX_MC2 INT,
	QTSX_HTSX_FS2 INT,
	QDSJ TIMESTAMP,
	QDDD VARCHAR(50),
	ZSZXJXGSB_WQ VARCHAR(32),
	ZSZXJXGSB_WQBZ VARCHAR(100),
	ZSZXJXGSB_QJS_NQ VARCHAR(32),
	ZSZXJXGSB_QJS_DP VARCHAR(32),
	ZSZXJXGSB_QJS_DPBZ VARCHAR(100),
	ZSZXJXGSB_QJS_SNDM VARCHAR(32),
	ZSZXJXGSB_QJS_SNDMBZ VARCHAR(100),
	ZSZXJXGSB_CF_DM VARCHAR(32),
	ZSZXJXGSB_CF_DMBZ VARCHAR(100),
	ZSZXJXGSB_CF_QM VARCHAR(32),
	ZSZXJXGSB_CF_QMBZ VARCHAR(100),
	ZSZXJXGSB_CF_DP VARCHAR(32),
	ZSZXJXGSB_CF_DPBZ VARCHAR(100),
	ZSZXJXGSB_CF_CJ VARCHAR(200),
	ZSZXJXGSB_WSJ_DM VARCHAR(32),
	ZSZXJXGSB_WSJ_DMBZ VARBINARY(100),
	ZSZXJXGSB_WSJ_QM VARCHAR(32),
	ZSZXJXGSB_WSJ_QMBZ VARCHAR(100),
	ZSZXJXGSB_WSJ_DP VARCHAR(32),
	ZSZXJXGSB_WSJ_DPBZ VARCHAR(100),
	ZSZXJXGSB_WSJ_QJ VARCHAR(100),
	ZSZXJXGSB_YT VARCHAR(32),
	ZSZXJXGSB_YTBZ VARCHAR(100),
	ZSZXJXGSB_DT_PP VARCHAR(100),
	ZSZXJXGSB_DT_XH VARCHAR(100),
	ZSZXJXGSB_GD VARCHAR(100),
	ZSZXJXGSB_CH VARCHAR(100),
	ZSZXJXGSB_BZ9 VARCHAR(100),
	ZSZXJXGSB_BZ10 VARCHAR(100),
	BXFWQXZR_DJJCHZTJG_BXQX VARCHAR(20),
	BXFWQXZR_DJJCHZTJG_BXQXBZ VARCHAR(100),
	BXFWQXZR_FSGC_BXQX VARCHAR(20),
	BXFWQXZR_FSGC_BXQXBZ VARCHAR(100),
	BXFWQXZR_GLGR_BXQX VARCHAR(20),
	BXFWQXZR_GLGR_BXQXBZ VARCHAR(100),
	BXFWQXZR_DXGX_BXQX VARCHAR(20),
	BXFWQXZR_DXGX_BXQXBZ VARCHAR(100),
	BXFWQXZR_ZXGC_BXQX VARCHAR(20),
	BXFWQXZR_ZXGC_BXQXBZ VARCHAR(100),
	BXFWQXZR_MEMO6 VARCHAR(100),
	BXFWQXZR_MEMO7 VARCHAR(100),
	BXFWQXZR_MEMO8 VARCHAR(100),
	BXFWQXZR_QTYD VARCHAR(200),
	ID VARCHAR(32) NOT NULL,
	PRIMARY KEY (ID),
	UNIQUE (XMJSYJ_TDQZH)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.HOUSE_CONTRACT
(
	ID VARCHAR(32) NOT NULL,
	TYPE VARCHAR(32),
	PASSWORD VARCHAR(50),
	PRICE DECIMAL(18,3),
	RECORD_TIME TIMESTAMP,
	PART_COUNT INT NOT NULL,
	PAY_TYPE VARCHAR(32),
	MEMO VARCHAR(200),
	OWNER VARCHAR(50) NOT NULL,
	ID_TYPE VARCHAR(32) NOT NULL,
	ID_NO VARCHAR(100) NOT NULL,
	CREATE_TIME TIMESTAMP NOT NULL,
	STATUS VARCHAR(20) NOT NULL,
	SELL_CORPORATION VARCHAR(50),
	SELL_CORPORATION_ADDRESS VARCHAR(50),
	SELL_CORPORATION_POST VARCHAR(50),
	SELL_CORPORATION_CODE VARCHAR(50),
	SELL_CORPORATION_NUMBER VARCHAR(50),
	SELL_CORPORATION_LEGAL VARCHAR(50),
	SELL_CORPORATION_CALL VARCHAR(15),
	PHONE VARCHAR(15),
	BIRTHDAY TIMESTAMP,
	SEX BIT(1),
	ROOT_ADDRESS VARCHAR(50),
	ADDRESS VARCHAR(100),
	LEGAL_PERSON VARCHAR(50),
	POST_CODE VARCHAR(50),
	BUSINESS_HOUSE VARCHAR(32) NOT NULL,
	DEVELOPER_NAME VARCHAR(100) NOT NULL,
	DEVELOPER_ID VARCHAR(32) NOT NULL,
	DEVELOPER_EMPLOYEE VARCHAR(10) NOT NULL,
	DEVELOPER_PERSON_ID VARCHAR(32) NOT NULL,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.HOUSE_POOL
(
	HOUSE VARCHAR(32) NOT NULL,
	POOL VARCHAR(32) NOT NULL,
	PRIMARY KEY (HOUSE, POOL)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.HOUSE_RECORD
(
	HOUSE_CODE VARCHAR(32) NOT NULL,
	HOUSE VARCHAR(32) NOT NULL,
	PRIMARY KEY (HOUSE_CODE),
	UNIQUE (HOUSE),
	CONSTRAINT HOUSE_CODE_UNIQUE UNIQUE (HOUSE_CODE, HOUSE)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.HOUSE_REG_INFO
(
	ID VARCHAR(32) NOT NULL,
	HOUSE_PORPERTY VARCHAR(32) NOT NULL,
	HOUSE_FROM VARCHAR(32) NOT NULL,
	HOUSE VARCHAR(32) NOT NULL,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.HOUSE_STATE
(
	ID VARCHAR(32) NOT NULL,
	HOUSE VARCHAR(32) NOT NULL,
	HOUSE_STATUS VARCHAR(32) NOT NULL,
	CREATE_DATE TIMESTAMP NOT NULL,
	CONSTRAINT PK_HOUSESTATE PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.LAND_INFO
(
	ID VARCHAR(32) NOT NULL,
	LAND_CARD_NO VARCHAR(50),
	NUMBER VARCHAR(50) NOT NULL,
	LAND_PROPERTY VARCHAR(32),
	BEGIN_USE_TIME TIMESTAMP NOT NULL,
	END_USE_TIME TIMESTAMP NOT NULL,
	LAND_GET_MODE VARCHAR(32) NOT NULL,
	LAND_AREA DECIMAL(18,3),
	-- 倒库导入原库的NO
	BUSINESS VARCHAR(32) NOT NULL COMMENT '倒库导入原库的NO',
	CONSTRAINT PK_LANDINFO PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.LOCKED_HOUSE
(
	HOUSE_CODE VARCHAR(32) NOT NULL,
	-- 字典
	TYPE VARCHAR(32) NOT NULL COMMENT '字典',
	DESCRIPTION VARCHAR(500),
	EMP_CODE VARCHAR(32) NOT NULL,
	EMP_NAME VARCHAR(50) NOT NULL,
	LOCKED_TIME TIMESTAMP NOT NULL,
	BUILD_CODE VARCHAR(32) NOT NULL,
	PRIMARY KEY (HOUSE_CODE)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.MAKE_CARD
(
	ID VARCHAR(32) NOT NULL,
	NUMBER VARCHAR(100) NOT NULL,
	TYPE VARCHAR(20) NOT NULL,
	-- 倒库导入原库的NO
	BUSINESS_ID VARCHAR(32) NOT NULL COMMENT '倒库导入原库的NO',
	DISABLE BOOLEAN NOT NULL,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.MAPPING_CORP
(
	ID VARCHAR(32) NOT NULL,
	NAME VARCHAR(100) NOT NULL,
	CODE VARCHAR(100) NOT NULL,
	-- 倒库导入原库的NO
	BUSINESS_ID VARCHAR(32) NOT NULL COMMENT '倒库导入原库的NO',
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.MORTGAEGE_REGISTE
(
	HIGHEST_MOUNT_MONEY DECIMAL(19,4) NOT NULL,
	WARRANT_SCOPE VARCHAR(100) NOT NULL,
	INTEREST_TYPE VARCHAR(32) NOT NULL,
	MORTGAGE_DUE_TIME_S DATETIME NOT NULL,
	MORTGAGE_TIME VARCHAR(50) NOT NULL,
	MORTGAGE_AREA DECIMAL(19,4) NOT NULL,
	ID VARCHAR(32) NOT NULL,
	-- 倒库导入原库的NO
	BUSINESS_ID VARCHAR(32) NOT NULL COMMENT '倒库导入原库的NO',
	OLD_FIN VARCHAR(32),
	FIN VARCHAR(32),
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.NEW_HOUSE_CONTRACT_PRESALE
(
	VERSION INT NOT NULL,
	YSYJ_YSJG VARCHAR(100) NOT NULL,
	YSYJ_YSXKZH VARCHAR(50) NOT NULL,
	YSZJJGJG VARCHAR(100),
	YSJZJGZHMC VARCHAR(100),
	YSZJJGJGZH VARCHAR(100),
	MJCYCLFS INT,
	MJCY_AZBFB1 DECIMAL(8,3),
	MJCY_AZBFB2 DECIMAL(8,3),
	MJCYMEMO3 VARCHAR(100),
	MJCLCLMEMO4 VARCHAR(100),
	GHSJ_BFB1 DECIMAL(8,3),
	GHSJ_FJKBFB1 DECIMAL(8,3),
	GHSJ_MEMO1 VARCHAR(100),
	GHSJ_MEMO3 VARCHAR(100),
	GHSJ_MEMO4 VARCHAR(4),
	GHSJ_MEMO5 VARCHAR(100),
	GHSJ_BFB2 DECIMAL(8,3),
	GHSJ_FJKBFB2 DECIMAL(8,3),
	GHSJ_MEMO6 VARCHAR(100),
	HTBAYFWDJ_BASJ INT,
	HTBAYFWDJ_BASJ_QTYD VARCHAR(150),
	HTBAYFWDJ_FWDJ_FJZRQN INT,
	HTBAYFWDJ_FWDJ_CLFS INT,
	HTBAYFWDJ_FWDJ_AZBFB DECIMAL(8,3),
	HTBAYFWDJ_FWDJ_WFZJ DECIMAL(8,3),
	HTBAYFWDJ_FWDJ_MEMO1 VARCHAR(100),
	QTSX_SF_YCD VARCHAR(50),
	ID VARCHAR(32) NOT NULL,
	CONSTRAINT PK_NEWHOUSECONTRACT PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.NEW_HOUSE_CONTRACT_SALE
(
	SSYJ_ZJLX VARCHAR(32),
	SSYJ_QZH VARCHAR(30),
	SSYJ_JGMC VARCHAR(32),
	SSYJ_DJJG VARCHAR(50),
	SSYJ_SFCZ VARCHAR(32),
	SSYJ_ZLQXS TIMESTAMP,
	SSYJ_ZLQXZ TIMESTAMP,
	SSYJ_BZ VARCHAR(100),
	ZHMC VARCHAR(50),
	KHYH VARCHAR(100),
	ZK VARCHAR(50),
	ID VARCHAR(32) NOT NULL,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.NUMBER_POOL
(
	ID VARCHAR(32) NOT NULL,
	NUMBER BIGINT UNSIGNED NOT NULL,
	VERSION INT,
	TYPE VARCHAR(20) NOT NULL,
	USE_TIME TIMESTAMP NOT NULL,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.OTHER_POWER_CARD
(
	FINANCIAL_NAME VARCHAR(120) NOT NULL,
	FINANCIAL_CODE VARCHAR(100),
	FINANCIAL_PHONE VARCHAR(15),
	-- 个人
	-- 机构
	FINANCIAL_TYPE VARCHAR(20) NOT NULL COMMENT '个人
机构',
	ID_TYPE VARCHAR(32),
	ID VARCHAR(32) NOT NULL,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.OTHER_POWER_CARD_AND_HOUSE
(
	HOUSE VARCHAR(32) NOT NULL,
	CARD VARCHAR(32) NOT NULL,
	PRIMARY KEY (HOUSE, CARD)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.OWNER_BUSINESS
(
	-- 倒库导入原库的NO
	ID VARCHAR(32) NOT NULL COMMENT '倒库导入原库的NO',
	VERSION INT,
	SOURCE VARCHAR(20) NOT NULL,
	MEMO VARCHAR(200),
	STATUS VARCHAR(20) NOT NULL,
	DEFINE_NAME VARCHAR(50),
	DEFINE_ID VARCHAR(32),
	-- 倒库导入原库的NO
	SELECT_BUSINESS VARCHAR(32) COMMENT '倒库导入原库的NO',
	CREATE_TIME TIMESTAMP NOT NULL,
	APPLY_TIME DATETIME,
	CHECK_TIME DATETIME,
	REG_TIME DATETIME,
	RECORD_TIME DATETIME,
	RECORDED BOOLEAN NOT NULL,
	-- 正常业务
	-- 撤消业务
	-- 更正业务
	TYPE VARCHAR(20) NOT NULL COMMENT '正常业务
撤消业务
更正业务',
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.PROCESS_MESSAGES
(
	ID VARCHAR(32) NOT NULL,
	LEVEL VARCHAR(20) NOT NULL,
	MESSAGES VARCHAR(200) NOT NULL,
	-- 倒库导入原库的NO
	BUSINESS_ID VARCHAR(32) NOT NULL COMMENT '倒库导入原库的NO',
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.PROJECT
(
	ID VARCHAR(32) NOT NULL,
	NAME VARCHAR(50) NOT NULL,
	ADDRESS VARCHAR(200),
	BUILD_SIZE VARCHAR(32),
	BUILD_COUNT INT,
	AREA DECIMAL(18,3),
	SUM_AREA DECIMAL(18,3),
	MAP_TIME TIMESTAMP,
	COMPLETE_DATE VARCHAR(6),
	DEVELOPER_NAME VARCHAR(100),
	DEVELOPER_CODE VARCHAR(32),
	SECTION_NAME VARCHAR(50) NOT NULL,
	SECTION_CODE VARCHAR(32) NOT NULL,
	DISTRICT_CODE VARCHAR(32) NOT NULL,
	DISTRICT_NAME VARCHAR(100) NOT NULL,
	PROJECT_CODE VARCHAR(32) NOT NULL,
	-- 倒库导入原库的NO
	BUSINESS VARCHAR(32) NOT NULL COMMENT '倒库导入原库的NO',
	CONSTRAINT PK_PROJECT PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.PROJECT_RECORD
(
	ID VARCHAR(32) NOT NULL,
	SALE_CARD VARCHAR(32),
	PROJECT_CODE VARCHAR(32) NOT NULL,
	PRIMARY KEY (ID),
	UNIQUE (PROJECT_CODE)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.PROJECT_RECORD_STORE
(
	ID VARCHAR(32) NOT NULL,
	FRAME VARCHAR(10) NOT NULL,
	CABINET VARCHAR(20) NOT NULL,
	BOX VARCHAR(50) NOT NULL,
	RECORD VARCHAR(32) NOT NULL,
	BUSINESS VARCHAR(32) NOT NULL,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.PROJECT_SELL_CARD
(
	HOUSE_COUNT INT,
	BUILD_COUNT INT,
	AREA DECIMAL(18,3),
	PREPARE_SELL BIT(1),
	USE_TYPE VARCHAR(32),
	SELL_OBJECT VARCHAR(50),
	YEAR_NUMBER VARCHAR(20),
	ORDER_NUMBER VARCHAR(20),
	PRINT_TIME TIMESTAMP NOT NULL,
	MEMO VARCHAR(200),
	PROJECT VARCHAR(32) NOT NULL,
	ID VARCHAR(32) NOT NULL,
	TYPE VARCHAR(20) NOT NULL,
	LAND_CARD_NO VARCHAR(50),
	NUMBER VARCHAR(50) NOT NULL,
	LAND_PROPERTY VARCHAR(32),
	BEGIN_USE_TIME TIMESTAMP NOT NULL,
	END_USE_TIME TIMESTAMP NOT NULL,
	LAND_GET_MODE VARCHAR(32),
	LAND_AREA DECIMAL(18,3),
	CARD VARCHAR(32) NOT NULL,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


-- 记录注销原因，更正前，更正后，变更前，变更后等事由信息
CREATE TABLE HOUSE_OWNER_RECORD.REASON
(
	ID VARCHAR(32) NOT NULL,
	TYPE VARCHAR(20) NOT NULL,
	REASON VARCHAR(200),
	-- 倒库导入原库的NO
	BUISINESS_ID VARCHAR(32) NOT NULL COMMENT '倒库导入原库的NO',
	PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '记录注销原因，更正前，更正后，变更前，变更后等事由信息' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.RECORD_STORE
(
	ID VARCHAR(32) NOT NULL,
	FRAME VARCHAR(10) NOT NULL,
	CABINET VARCHAR(20) NOT NULL,
	BOX VARCHAR(50) NOT NULL,
	BUSINESS_HOUSE VARCHAR(32) NOT NULL,
	HOUSE_CODE VARCHAR(32) NOT NULL,
	RECORD_CODE VARCHAR(50) NOT NULL,
	PRIMARY KEY (ID),
	UNIQUE (HOUSE_CODE)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.SALE_INFO
(
	ID VARCHAR(32) NOT NULL,
	PAY_TYPE VARCHAR(32),
	SUM_PRICE DECIMAL(19,4) NOT NULL,
	-- 倒库导入原库的NO
	BUSINESS_ID VARCHAR(32) NOT NULL COMMENT '倒库导入原库的NO',
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.TASK_OPER
(
	ID BIGINT NOT NULL,
	-- 倒库导入原库的NO
	BUSINESS VARCHAR(32) NOT NULL COMMENT '倒库导入原库的NO',
	OPER_TIME TIMESTAMP NOT NULL,
	EMP_CODE VARCHAR(32) NOT NULL,
	EMP_NAME VARCHAR(50) NOT NULL,
	TASK_NAME VARCHAR(100) NOT NULL,
	COMMENTS VARCHAR(500),
	OPER_TYPE VARCHAR(20) NOT NULL,
	ACCEPT BOOLEAN NOT NULL,
	TASK_TYPE VARCHAR(20) NOT NULL,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_OWNER_RECORD.UPLOAD_FILE
(
	FILE_NAME VARCHAR(255) NOT NULL,
	EMP_NAME VARCHAR(50) NOT NULL,
	EMP_CODE VARCHAR(32) NOT NULL,
	MD5 VARCHAR(500) NOT NULL,
	BUSINESS_FILE_ID VARCHAR(32) NOT NULL,
	PRIMARY KEY (FILE_NAME)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;



/* Create Foreign Keys */

ALTER TABLE HOUSE_OWNER_RECORD.UPLOAD_FILE
	ADD FOREIGN KEY (BUSINESS_FILE_ID)
	REFERENCES HOUSE_OWNER_RECORD.BUSINESS_FILE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.RECORD_STORE
	ADD FOREIGN KEY (BUSINESS_HOUSE)
	REFERENCES HOUSE_OWNER_RECORD.BUSINESS_HOUSE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_CONTRACT
	ADD FOREIGN KEY (BUSINESS_HOUSE)
	REFERENCES HOUSE_OWNER_RECORD.BUSINESS_HOUSE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.HOUSE
	ADD FOREIGN KEY (MAIN_OWNER)
	REFERENCES HOUSE_OWNER_RECORD.BUSINESS_OWNER (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_POOL
	ADD FOREIGN KEY (POOL)
	REFERENCES HOUSE_OWNER_RECORD.BUSINESS_POOL (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.OTHER_POWER_CARD
	ADD FOREIGN KEY (ID)
	REFERENCES HOUSE_OWNER_RECORD.CARD_INFO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.OTHER_POWER_CARD_AND_HOUSE
	ADD FOREIGN KEY (CARD)
	REFERENCES HOUSE_OWNER_RECORD.CARD_INFO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.MORTGAEGE_REGISTE
	ADD FOREIGN KEY (OLD_FIN)
	REFERENCES HOUSE_OWNER_RECORD.FINANCIAL (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.MORTGAEGE_REGISTE
	ADD FOREIGN KEY (FIN)
	REFERENCES HOUSE_OWNER_RECORD.FINANCIAL (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.BUSINESS_HOUSE
	ADD FOREIGN KEY (AFTER_HOUSE)
	REFERENCES HOUSE_OWNER_RECORD.HOUSE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_REG_INFO
	ADD FOREIGN KEY (HOUSE)
	REFERENCES HOUSE_OWNER_RECORD.HOUSE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_RECORD
	ADD FOREIGN KEY (HOUSE)
	REFERENCES HOUSE_OWNER_RECORD.HOUSE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.OTHER_POWER_CARD_AND_HOUSE
	ADD FOREIGN KEY (HOUSE)
	REFERENCES HOUSE_OWNER_RECORD.HOUSE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.BUSINESS_HOUSE
	ADD FOREIGN KEY (START_HOUSE)
	REFERENCES HOUSE_OWNER_RECORD.HOUSE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_STATE
	ADD FOREIGN KEY (HOUSE)
	REFERENCES HOUSE_OWNER_RECORD.HOUSE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_POOL
	ADD FOREIGN KEY (HOUSE)
	REFERENCES HOUSE_OWNER_RECORD.HOUSE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_AND_MOR
	ADD FOREIGN KEY (HOUSE)
	REFERENCES HOUSE_OWNER_RECORD.HOUSE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.NEW_HOUSE_CONTRACT_SALE
	ADD FOREIGN KEY (ID)
	REFERENCES HOUSE_OWNER_RECORD.HOUSE_COMMERCI_CONTRACT (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.NEW_HOUSE_CONTRACT_PRESALE
	ADD FOREIGN KEY (ID)
	REFERENCES HOUSE_OWNER_RECORD.HOUSE_COMMERCI_CONTRACT (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_COMMERCI_CONTRACT
	ADD FOREIGN KEY (ID)
	REFERENCES HOUSE_OWNER_RECORD.HOUSE_CONTRACT (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.CONTRACT_MORTGAGE
	ADD FOREIGN KEY (CONTRACT)
	REFERENCES HOUSE_OWNER_RECORD.HOUSE_CONTRACT (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.RECORD_STORE
	ADD FOREIGN KEY (HOUSE_CODE)
	REFERENCES HOUSE_OWNER_RECORD.HOUSE_RECORD (HOUSE_CODE)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.HOUSE
	ADD FOREIGN KEY (LAND_INFO)
	REFERENCES HOUSE_OWNER_RECORD.LAND_INFO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.BUSINESS_POOL
	ADD FOREIGN KEY (CARD)
	REFERENCES HOUSE_OWNER_RECORD.MAKE_CARD (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.CARD_INFO
	ADD FOREIGN KEY (ID)
	REFERENCES HOUSE_OWNER_RECORD.MAKE_CARD (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.BUSINESS_OWNER
	ADD FOREIGN KEY (CARD)
	REFERENCES HOUSE_OWNER_RECORD.MAKE_CARD (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.PROJECT_SELL_CARD
	ADD FOREIGN KEY (CARD)
	REFERENCES HOUSE_OWNER_RECORD.MAKE_CARD (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_AND_MOR
	ADD FOREIGN KEY (MOR)
	REFERENCES HOUSE_OWNER_RECORD.MORTGAEGE_REGISTE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.OWNER_BUSINESS
	ADD FOREIGN KEY (SELECT_BUSINESS)
	REFERENCES HOUSE_OWNER_RECORD.OWNER_BUSINESS (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.BUSINESS_PERSION
	ADD FOREIGN KEY (BUSINESS_ID)
	REFERENCES HOUSE_OWNER_RECORD.OWNER_BUSINESS (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.BUSINESS_MONEY
	ADD FOREIGN KEY (BUSINESS)
	REFERENCES HOUSE_OWNER_RECORD.OWNER_BUSINESS (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.BUSINESS_EMP
	ADD FOREIGN KEY (BUSINESS_ID)
	REFERENCES HOUSE_OWNER_RECORD.OWNER_BUSINESS (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.REASON
	ADD FOREIGN KEY (BUISINESS_ID)
	REFERENCES HOUSE_OWNER_RECORD.OWNER_BUSINESS (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_CLOSE_CANCEL
	ADD FOREIGN KEY (BUSINESS_ID)
	REFERENCES HOUSE_OWNER_RECORD.OWNER_BUSINESS (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.PROJECT
	ADD FOREIGN KEY (BUSINESS)
	REFERENCES HOUSE_OWNER_RECORD.OWNER_BUSINESS (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.EVALUATE
	ADD FOREIGN KEY (BUSINESS_ID)
	REFERENCES HOUSE_OWNER_RECORD.OWNER_BUSINESS (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.CLOSE_HOUSE
	ADD FOREIGN KEY (BUSINESS_ID)
	REFERENCES HOUSE_OWNER_RECORD.OWNER_BUSINESS (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.CARD
	ADD FOREIGN KEY (BUSINESS_ID)
	REFERENCES HOUSE_OWNER_RECORD.OWNER_BUSINESS (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.BUSINESS_HOUSE
	ADD FOREIGN KEY (BUSINESS_ID)
	REFERENCES HOUSE_OWNER_RECORD.OWNER_BUSINESS (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.SALE_INFO
	ADD FOREIGN KEY (BUSINESS_ID)
	REFERENCES HOUSE_OWNER_RECORD.OWNER_BUSINESS (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.MORTGAEGE_REGISTE
	ADD FOREIGN KEY (BUSINESS_ID)
	REFERENCES HOUSE_OWNER_RECORD.OWNER_BUSINESS (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.PROCESS_MESSAGES
	ADD FOREIGN KEY (BUSINESS_ID)
	REFERENCES HOUSE_OWNER_RECORD.OWNER_BUSINESS (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.TASK_OPER
	ADD FOREIGN KEY (BUSINESS)
	REFERENCES HOUSE_OWNER_RECORD.OWNER_BUSINESS (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.BUSINESS_FILE
	ADD FOREIGN KEY (BUSINESS_ID)
	REFERENCES HOUSE_OWNER_RECORD.OWNER_BUSINESS (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.MAPPING_CORP
	ADD FOREIGN KEY (BUSINESS_ID)
	REFERENCES HOUSE_OWNER_RECORD.OWNER_BUSINESS (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.MAKE_CARD
	ADD FOREIGN KEY (BUSINESS_ID)
	REFERENCES HOUSE_OWNER_RECORD.OWNER_BUSINESS (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.LAND_INFO
	ADD FOREIGN KEY (BUSINESS)
	REFERENCES HOUSE_OWNER_RECORD.OWNER_BUSINESS (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.BUILD
	ADD FOREIGN KEY (PROJECT)
	REFERENCES HOUSE_OWNER_RECORD.PROJECT (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.PROJECT_RECORD_STORE
	ADD FOREIGN KEY (BUSINESS)
	REFERENCES HOUSE_OWNER_RECORD.PROJECT (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.PROJECT_SELL_CARD
	ADD FOREIGN KEY (PROJECT)
	REFERENCES HOUSE_OWNER_RECORD.PROJECT (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.PROJECT_RECORD_STORE
	ADD FOREIGN KEY (RECORD)
	REFERENCES HOUSE_OWNER_RECORD.PROJECT_RECORD (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.PROJECT_RECORD
	ADD FOREIGN KEY (SALE_CARD)
	REFERENCES HOUSE_OWNER_RECORD.PROJECT_SELL_CARD (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



