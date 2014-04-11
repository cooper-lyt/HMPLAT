SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE HOUSE_INFO.POOL_BUILD;
DROP TABLE HOUSE_INFO.PROJECT_BUILD_PROCESS;
DROP TABLE HOUSE_INFO.GRID_BLOCK;
DROP TABLE HOUSE_INFO.GRID_ROW;
DROP TABLE HOUSE_INFO.HOUSE_GRID_TITLE;
DROP TABLE HOUSE_INFO.BUILD_GRID_MAP;
DROP TABLE HOUSE_INFO.RECORD_ATTACH_WONER;
DROP TABLE HOUSE_INFO.OLDHOUSECONTRACT;
DROP TABLE HOUSE_INFO.CONTRACT_ATTACH_OWNER;
DROP TABLE HOUSE_INFO.NEW_HOUSE_CONTRACT;
DROP TABLE HOUSE_INFO.HOUSE_CONTRACT;
DROP TABLE HOUSE_INFO.HOUSE_CARD;
DROP TABLE HOUSE_INFO.HOUSE_STATE;
DROP TABLE HOUSE_INFO.POOL_OWNER;
DROP TABLE HOUSE_INFO.HOUSE;
DROP TABLE HOUSE_INFO.BUILD;
DROP TABLE HOUSE_INFO.PROJECT;
DROP TABLE HOUSE_INFO.SMSUBCOMPANY;
DROP TABLE HOUSE_INFO.OWNER_GROUP;
DROP TABLE HOUSE_INFO.SECTION;
DROP TABLE HOUSE_INFO.DISTRICT;
DROP TABLE HOUSE_INFO.PROVINCE_CITY;
DROP TABLE HOUSE_INFO.PROJECT_SELL_CARD;
DROP TABLE HOUSE_INFO.CARD;
DROP TABLE HOUSE_INFO.HOUSE_OWNER;
DROP TABLE HOUSE_INFO.DEMPLOYEE;
DROP TABLE HOUSE_INFO.SELL_EMPLOYEE;
DROP TABLE HOUSE_INFO.EMPLOYEE_ATTACH_ACTION;
DROP TABLE HOUSE_INFO.ATTACH_EMPLOYEE;
DROP TABLE HOUSE_INFO.DEVELOPER;
DROP TABLE HOUSE_INFO.ORG_ATTACH_ACTION;
DROP TABLE HOUSE_INFO.LAND_INFO;
DROP TABLE HOUSE_INFO.EVALUATE_CORPORATION;
DROP TABLE HOUSE_INFO.MCOMPANY;
DROP TABLE HOUSE_INFO.FINANCIAL_CORPORATION;
DROP TABLE HOUSE_INFO.MAPPING_CORPORATION;
DROP TABLE HOUSE_INFO.HOUSE_SELL_COMPANY;
DROP TABLE HOUSE_INFO.ATTACH_CORPORATION;




/* Create Tables */

CREATE TABLE HOUSE_INFO.PROVINCE_CITY
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	NAME VARCHAR(100) COMMENT '名称',
	MEMO VARCHAR(200) COMMENT '备注',
	CONSTRAINT PK_PROVINCECITY PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '省市' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.SECTION
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	DISTRICTID VARCHAR(32) COMMENT '行政区ID',
	NAME VARCHAR(50) NOT NULL COMMENT '项目名称',
	ADDRESS VARCHAR(200) COMMENT '地址',
	VERSION INT COMMENT 'VERSION',
	MEMO VARCHAR(200) COMMENT '备注',
	CONSTRAINT PK_SECTION PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '小区表' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.HOUSE_CARD
(
	CARD_ID VARCHAR(32) NOT NULL COMMENT 'CARD_ID',
	HOUSE_ID VARCHAR(32) NOT NULL COMMENT 'HOUSE_ID',
	PRIMARY KEY (CARD_ID, HOUSE_ID)
) ENGINE = InnoDB COMMENT = 'HOUSE_CARD' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.HOUSE_CONTRACT
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	HOUSE_ID VARCHAR(32) NOT NULL COMMENT 'HOUSE_ID',
	PASSWORD VARCHAR(50) COMMENT 'PASSWORD',
	RECORD_TIME TIMESTAMP COMMENT '生效时间',
	PRICE DECIMAL(18,3) COMMENT '交易价格',
	STATE INT NOT NULL COMMENT '状态',
	PART_COUNT INT NOT NULL COMMENT '合同份数',
	PAY_TYPE VARCHAR(32) COMMENT '购买方式',
	MEMO VARCHAR(200) COMMENT 'MEMO',
	OWNER_ID VARCHAR(32) NOT NULL COMMENT 'OWNER_ID',
	PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '房屋销售合同' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.NEW_HOUSE_CONTRACT
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	DEMPLOYEE VARCHAR(32) NOT NULL COMMENT 'DEmployee',
	CONTRACT_ID VARCHAR(32) NOT NULL COMMENT 'CONTRACT_ID',
	VERSION INT NOT NULL COMMENT 'VERSION',
	CONSTRAINT PK_NEWHOUSECONTRACT PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '商品房合同' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.OLDHOUSECONTRACT
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	IEMPLOYEE VARCHAR(32) NOT NULL COMMENT 'IEmployee',
	CONTRACT_ID VARCHAR(32) NOT NULL COMMENT 'CONTRACT_ID',
	VERSION INT NOT NULL COMMENT 'VERSION',
	CONSTRAINT PK_OLDHOUSECONTRACT PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '二手房合同' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.CONTRACT_ATTACH_OWNER
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	OWNER_ID VARCHAR(32) NOT NULL COMMENT 'OWNER_ID',
	CONTRACT_ID VARCHAR(32) NOT NULL COMMENT 'CONTRACT_ID',
	OWNE_SCALE DECIMAL(19,4) COMMENT '所占份额',
	RELATION VARCHAR(32) COMMENT '与所有人关系',
	PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '合同共有权人' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.CARD
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	NUMBER VARCHAR(50) COMMENT '权证号',
	CARD_CODE VARCHAR(50) COMMENT '证编号',
	TYPE INT NOT NULL COMMENT '类型',
	BUSINESS_CODE VARCHAR(32) COMMENT '业务编号',
	PRINT_TIME TIMESTAMP COMMENT '填发时间',
	MEMO VARCHAR(200) COMMENT '备注',
	CONSTRAINT PK_PROJECTCARD PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = 'CARD' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.HOUSE_OWNER
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	CREDENTIALS_NUMBER VARCHAR(100) COMMENT '证件编号',
	CREDENTIALS_TYPE INT COMMENT '证件类型',
	NAME VARCHAR(50) COMMENT '姓名',
	PERSON_ID VARCHAR(32) COMMENT 'PERSON_ID',
	PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = 'HOUSE_OWNER' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.RECORD_ATTACH_WONER
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	OWNER_ID VARCHAR(32) NOT NULL COMMENT 'OWNER_ID',
	HOUSE_ID VARCHAR(32) NOT NULL COMMENT 'HOUSE_ID',
	RELATION VARCHAR(32) COMMENT '与所有人关系',
	OWNE_SCALE DECIMAL(19,4) COMMENT '所占份额',
	PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '备案共有人' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.POOL_OWNER
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	RELATION VARCHAR(32) COMMENT '与所有人关系',
	OWNE_SCALE DECIMAL(19,4) COMMENT '所占份额',
	HOUSE_ID VARCHAR(32) NOT NULL COMMENT 'HOUSE_ID',
	CARD_ID VARCHAR(32) NOT NULL COMMENT 'CARD_ID',
	OWNER_ID VARCHAR(32) NOT NULL COMMENT 'OWNER_ID',
	PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '共有权人' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.DEMPLOYEE
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	DEVELOPER VARCHAR(32) NOT NULL COMMENT 'Developer',
	ATTACH_EMPLOYEE_ID VARCHAR(32) NOT NULL COMMENT '从业人员',
	MEMO VARCHAR(200) COMMENT '备注',
	CONSTRAINT PK_DEMPLOYEE PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '开发商从业人员' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.SELL_EMPLOYEE
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	INTERMEDIARY VARCHAR(32) NOT NULL COMMENT 'Intermediary',
	ATTACH_EMLOPEE_ID VARCHAR(32) NOT NULL COMMENT '从业人员',
	MEMO VARCHAR(200) COMMENT '备注',
	CONSTRAINT PK_IEMPLOYEE PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '房屋中介从业人员' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.ATTACH_EMPLOYEE
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	PASSWORD VARCHAR(100) NOT NULL COMMENT 'PASSWORD',
	LICENSE_LEVE VARCHAR(32) COMMENT '证书等级',
	LICENSE_NUMBER VARCHAR(50) COMMENT '证书编号',
	LICENSE_TIME_TO TIMESTAMP COMMENT '证书期限',
	PHONE VARCHAR(20) COMMENT 'PHONE',
	DEUCATION VARCHAR(32) COMMENT '学历',
	NAME VARCHAR(50) NOT NULL COMMENT '姓名',
	CREDENTIALS_TYPE INT COMMENT '证件类型',
	CREDENTIALS_NUMBER VARCHAR(100) COMMENT '证件编号',
	PERSION_ID VARCHAR(32) COMMENT 'PERSION_ID',
	ENABLE BIT(1) COMMENT 'ENABLE',
	CREATE_TIME TIMESTAMP COMMENT '建立时间',
	PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '从业人员' DEFAULT CHARACTER SET utf8;


-- 一个物业公司可能管理多个小区
CREATE TABLE HOUSE_INFO.SMSUBCOMPANY
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	MCOMPANY VARCHAR(32) COMMENT 'MCompany',
	SECTION VARCHAR(32) NOT NULL COMMENT 'Section',
	NAME VARCHAR(50) COMMENT '名称',
	ADDRESS VARCHAR(100) COMMENT '地址',
	MANAGER VARCHAR(50) COMMENT '负责人',
	PHONE VARCHAR(50) COMMENT '电话',
	REGISTER_TIME TIMESTAMP COMMENT '注册时间',
	ENABLE BIT(1) COMMENT 'ENABLE',
	MEMO VARCHAR(200) COMMENT '备注',
	CONSTRAINT PK_SMSUBCOMPANY PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '小区物业管理处 : 一个物业公司可能管理多个小区' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.DEVELOPER
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	NAME VARCHAR(100) NOT NULL COMMENT 'NAME',
	VERSION INT NOT NULL COMMENT 'VERSION',
	MEMO VARCHAR(200) COMMENT '备注',
	ATTACH_ID VARCHAR(32) NOT NULL COMMENT 'ATTACH_ID',
	CONSTRAINT PK_DEVELOPER PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '开发商' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.OWNER_GROUP
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	SECTION VARCHAR(32) NOT NULL COMMENT 'Section',
	NUMBER VARCHAR(50) NOT NULL UNIQUE COMMENT '权证号',
	NAME VARCHAR(50) NOT NULL COMMENT '项目名称',
	PHONE VARCHAR(50) COMMENT '电话',
	ADDRESS VARCHAR(200) COMMENT '地址',
	REGISTER_TIME TIMESTAMP COMMENT '注册日期',
	MANAGER VARCHAR(50) COMMENT '负责人',
	TOTALCOUNT INT COMMENT 'TotalCount',
	MEMO VARCHAR(200) COMMENT '备注',
	CONSTRAINT PK_OWNERGROUP PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '业主委员会' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.PROJECT
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	NAME VARCHAR(50) NOT NULL COMMENT '项目名称',
	SECTIONID VARCHAR(32) COMMENT '小区ID',
	DEVELOPERID VARCHAR(32) COMMENT '开发商ID',
	ADDRESS VARCHAR(200) COMMENT '地址',
	OPEN_TIME TIMESTAMP COMMENT '开盘时间',
	BUILD_SIZE VARCHAR(32) COMMENT '建筑规模',
	BUILD_COUNT INT COMMENT '项目栋数',
	FINISH_DATE TIMESTAMP COMMENT '峻工日期',
	AREA DECIMAL(18,3) COMMENT '面积',
	SUM_AREA DECIMAL(18,3) COMMENT '总面积',
	COME_DATE TIMESTAMP COMMENT '入住日期',
	STATE INT NOT NULL COMMENT 'STATE',
	MEMO VARCHAR(200) COMMENT '备注',
	MAP_TIME TIMESTAMP COMMENT '测绘时间',
	MAP_MEMO VARCHAR(200) COMMENT 'MAP_MEMO',
	CAN_SELL BIT(1) COMMENT '是否可售',
	VERSION INT COMMENT 'VERSION',
	CONSTRAINT PK_PROJECT PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '项目' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.HOUSE_STATE
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	HOUSEID VARCHAR(32) NOT NULL COMMENT '房屋ID',
	STATE INT NOT NULL COMMENT 'STATE',
	BUSINESS_ID VARCHAR(32) COMMENT '业务ID',
	VERSION INT COMMENT 'VERSION',
	CONSTRAINT PK_HOUSESTATE PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '房屋状态关联表' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.EMPLOYEE_ATTACH_ACTION
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	TYPE INT NOT NULL COMMENT 'TYPE',
	CONTEXT VARCHAR(200) COMMENT 'CONTEXT',
	CREATE_TIME TIMESTAMP COMMENT '时间',
	COMMIT_PERSION VARCHAR(50) COMMENT 'COMMIT_PERSION',
	ATTACH_EMPLOYEE_ID VARCHAR(32) NOT NULL COMMENT '从业人员',
	PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = 'EMPLOYEE_ATTACH_ACTION' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.ORG_ATTACH_ACTION
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	TYPE INT NOT NULL COMMENT 'TYPE',
	CONTEXT VARCHAR(200) COMMENT 'CONTEXT',
	CREATE_TIME TIMESTAMP COMMENT '时间',
	COMMIT_PERSION VARCHAR(50) COMMENT 'COMMIT_PERSION',
	CORPORATION_ID VARCHAR(32) NOT NULL COMMENT 'CORPORATION_ID',
	PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = 'ORG_ATTACH_ACTION' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.GRID_ROW
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	TITLE VARCHAR(50) NOT NULL COMMENT 'TITLE',
	_ORDER INT NOT NULL COMMENT '_ORDER',
	GRID_ID VARCHAR(32) NOT NULL COMMENT 'GRID_ID',
	FLOOR_INDEX INT NOT NULL COMMENT 'FLOOR_INDEX',
	PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = 'GRID_ROW' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.GRID_BLOCK
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	ROW_ID VARCHAR(32) NOT NULL COMMENT 'ROW_ID',
	_ORDER INT NOT NULL COMMENT '_ORDER',
	COLSPAN INT NOT NULL COMMENT 'COLSPAN',
	ROWSPAN INT NOT NULL COMMENT 'ROWSPAN',
	AREA DECIMAL(18,3) COMMENT '建筑面积',
	USE_AREA DECIMAL(18,3) COMMENT '使用面积',
	COMM_AREA DECIMAL(18,3) COMMENT '公摊面积',
	SHINE_AREA DECIMAL(18,3) COMMENT '阳台面积',
	LOFT_AREA DECIMAL(18,3) COMMENT '阁楼面积',
	COMM_PARAM DECIMAL(18,3) COMMENT '分摊系数',
	USE_TYPE VARCHAR(32) COMMENT '设计用途',
	STRUCTURE VARCHAR(32) COMMENT '结构',
	HOUSE_TYPE VARCHAR(32) COMMENT '房屋类型',
	UNIT_INDEX INT NOT NULL COMMENT '单元',
	UNIT_NAME VARCHAR(32) NOT NULL COMMENT '单元名',
	HOUSE_ID VARCHAR(32) NOT NULL COMMENT '房屋',
	PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = 'GRID_BLOCK' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.HOUSE_GRID_TITLE
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	_ORDER INT NOT NULL COMMENT '_ORDER',
	TITLE VARCHAR(32) NOT NULL COMMENT 'TITLE',
	COLSPAN INT NOT NULL COMMENT 'COLSPAN',
	GRILD_ID VARCHAR(32) NOT NULL COMMENT 'GRILD_ID',
	PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = 'HOUSE_GRID_TITLE' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.LAND_INFO
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	LAND_CARD_NO VARCHAR(50) COMMENT '土地证号',
	NUMBER VARCHAR(50) COMMENT '地号',
	LAND_PROPERTY VARCHAR(32) COMMENT '土地性质',
	BEGIN_USE_TIME TIMESTAMP COMMENT '土地使用年限始',
	END_USE_TIME TIMESTAMP COMMENT '土地使用年限止',
	AREA DECIMAL(18,3) COMMENT '面积',
	LAND_GET_MODE VARCHAR(32) COMMENT '取得方式',
	MEMO VARCHAR(200) COMMENT '备注',
	CONSTRAINT PK_LANDINFO PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = 'LAND_INFO' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.PROJECT_SELL_CARD
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	CARD_ID VARCHAR(32) NOT NULL COMMENT 'CARD_ID',
	HOUSE_COUNT INT COMMENT '套数',
	BUILD_COUNT INT COMMENT '栋数',
	AREA DECIMAL(18,3) COMMENT '面积',
	PREPARE_SELL BIT(1) COMMENT '是否预售',
	USE_TYPE VARCHAR(32) COMMENT '规划用途',
	SELL_OBJECT VARCHAR(50) COMMENT '销售对象',
	YEAR_NUMBER VARCHAR(20) COMMENT '年号',
	ORDER_NUMBER VARCHAR(20) COMMENT '第号',
	PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = 'PROJECT_SELL_CARD' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.BUILD_GRID_MAP
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	BUILD_ID VARCHAR(32) NOT NULL COMMENT 'BUILD_ID',
	NAME VARCHAR(50) NOT NULL COMMENT 'NAME',
	_ORDER INT NOT NULL COMMENT '_ORDER',
	PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = 'BUILD_GRID_MAP' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.DISTRICT
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	NAME VARCHAR(100) NOT NULL COMMENT 'NAME',
	SHORT_NAME VARCHAR(50) COMMENT '房权证简称',
	VERSION INT COMMENT 'VERSION',
	PROVINCECITYID VARCHAR(32) NOT NULL COMMENT '省市ID',
	MEMO VARCHAR(200) COMMENT 'MEMO',
	CONSTRAINT PK_DISTRICT PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '城区' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.EVALUATE_CORPORATION
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	NAME VARCHAR(100) NOT NULL COMMENT 'NAME',
	VERSION INT NOT NULL COMMENT 'VERSION',
	ATTACH_ID VARCHAR(32) NOT NULL COMMENT 'ATTACH_ID',
	DESTROYED BIT(1) NOT NULL COMMENT '注销',
	CONSTRAINT PK_EVALUATECORPORATION PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '评估机构' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.MCOMPANY
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	NAME VARCHAR(50) NOT NULL COMMENT '项目名称',
	VERSION INT NOT NULL COMMENT 'VERSION',
	ATTACH_ID VARCHAR(32) NOT NULL COMMENT 'ATTACH_ID',
	DESTROYED BIT(1) NOT NULL COMMENT '注销',
	CONSTRAINT PK_MCOMPANY PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '物业公司' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.FINANCIAL_CORPORATION
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	NAME VARCHAR(50) NOT NULL COMMENT '名称',
	VERSION INT NOT NULL COMMENT 'VERSION',
	ATTACH_ID VARCHAR(32) NOT NULL COMMENT 'ATTACH_ID',
	DESTROYED BIT(1) NOT NULL COMMENT '注销',
	CONSTRAINT PK_FINANCIALINFO PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '金融机构' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.MAPPING_CORPORATION
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	NAME VARCHAR(100) NOT NULL COMMENT 'NAME',
	VERSION INT NOT NULL COMMENT 'VERSION',
	ATTACH_ID VARCHAR(32) NOT NULL COMMENT 'ATTACH_ID',
	DESTROYED BIT(1) NOT NULL COMMENT '注销',
	CONSTRAINT PK_MAPPINGCORPORATION PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '测绘机构' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.HOUSE_SELL_COMPANY
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	NAME VARCHAR(100) NOT NULL COMMENT 'NAME',
	VERSION INT NOT NULL COMMENT 'VERSION',
	ATTACH_ID VARCHAR(32) NOT NULL COMMENT 'ATTACH_ID',
	DESTROYED BIT(1) NOT NULL COMMENT '注销',
	CONSTRAINT PK_INTERMEDIARY PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '房屋中介公司' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.ATTACH_CORPORATION
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	RECORD_DATE TIMESTAMP COMMENT '备案日期',
	ADDRESS VARCHAR(100) COMMENT '地址',
	PHONE VARCHAR(200) COMMENT 'PHONE',
	OWNER_NAME VARCHAR(20) COMMENT '法人名称',
	OWNER_CARD VARCHAR(50) COMMENT '法人身份证',
	FAX VARCHAR(50) COMMENT '传真',
	EMAIL VARCHAR(50) COMMENT 'EMail',
	ICON VARCHAR(100) COMMENT 'Icon',
	MEMO VARCHAR(200) COMMENT '备注',
	PASSWORD VARCHAR(50) COMMENT 'Password',
	POST_CODE VARCHAR(50) COMMENT '邮编',
	ENABLE BIT(1) NOT NULL COMMENT 'ENABLE',
	LICENSE_NUMBER VARCHAR(100) COMMENT '营业执照',
	TAX_LICENSE VARCHAR(100) COMMENT '税务代码证',
	COMPANY_CODE VARCHAR(100) COMMENT '企业代码',
	COMPANY_TYPE VARCHAR(32) COMMENT '公司类型',
	REGISTER_MONEY DECIMAL(18,3) COMMENT '注册资金',
	LEVE VARCHAR(32) COMMENT '资志等级',
	WEB_URL VARCHAR(100) COMMENT '网站',
	DATE_TO TIMESTAMP COMMENT '到期时间',
	MANAGER VARCHAR(20) COMMENT '经理',
	CONSTRAINT PK_INTERMEDIARY PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '从业机构' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.BUILD
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	MAP_NUMBER VARCHAR(50) NOT NULL COMMENT '图号',
	BLOCK_NO VARCHAR(50) NOT NULL COMMENT '丘号',
	BUILD_NO VARCHAR(50) NOT NULL COMMENT '幢号',
	NAME VARCHAR(100) NOT NULL COMMENT '楼幢名称',
	PROJECT_ID VARCHAR(32) NOT NULL COMMENT '项目ID',
	DOOR_NO VARCHAR(10) COMMENT '门牌号',
	UNINT_COUNT INT COMMENT '单元数',
	FLOOR_COUNT INT COMMENT '层数',
	ADDRESS VARCHAR(50) COMMENT '楼幢地址',
	HOUSE_COUNT INT COMMENT '套数',
	AREA DECIMAL(18,3) COMMENT '面积',
	LNG DECIMAL(18,14) COMMENT 'LNG',
	LAT DECIMAL(18,14) COMMENT 'LAT',
	ZOOM INT COMMENT 'ZOOM',
	BUILD_TYPE VARCHAR(32) COMMENT 'BUILD_TYPE',
	STRUCTURE VARCHAR(32) COMMENT '结构',
	VERSION INT COMMENT 'VERSION',
	MEMO VARCHAR(200) COMMENT '备注',
	INBIZ BIT(1) NOT NULL COMMENT 'INBIZ',
	BUSINESS_KEY VARCHAR(32) COMMENT '所在业务编号',
	LAND_ID VARCHAR(32) COMMENT '土地',
	HOME_COUNT INT COMMENT '住宅套数',
	HOME_AREA DECIMAL(18,3) COMMENT '住宅面积',
	UNHOME_COUNT INT COMMENT '非住宅套数',
	UNHOME_AREA DECIMAL(18,3) COMMENT '非住宅面积',
	SHOP_COUNT INT COMMENT '网点套数',
	SHOP_AREA DECIMAL(18,3) COMMENT '网点面积',
	CARD_ID VARCHAR(32) COMMENT 'CARD_ID',
	BUILD_COST DECIMAL(18,3) COMMENT '建安成本',
	CONSTRAINT PK_BUILD PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '楼幢表' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.HOUSE
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	BUILDID VARCHAR(32) NOT NULL COMMENT '楼幢ID',
	HOUSE_NUMBER VARCHAR(50) COMMENT '房屋编号',
	HOUSE_ORDER VARCHAR(20) NOT NULL COMMENT '房号',
	HOUSE_UNIT_NAME VARCHAR(20) COMMENT '单元名',
	IN_FLOOR_NAME VARCHAR(50) COMMENT '所在层名称',
	HOUSE_AREA DECIMAL(18,3) NOT NULL COMMENT '建筑面积',
	PREPARE_AREA DECIMAL(18,3) COMMENT '预测面积',
	TEMP_AREA DECIMAL(18,3) COMMENT '备案面积',
	USE_AREA DECIMAL(18,3) COMMENT '使用面积',
	COMM_AREA DECIMAL(18,3) COMMENT '分摊面积',
	SHINE_AREA DECIMAL(18,10) COMMENT '阳台面积',
	LOFT_AREA DECIMAL(18,3) COMMENT '阁楼面积',
	COMM_PARAM DECIMAL(18,3) COMMENT '分摊系数',
	PRIVATE_AREA DECIMAL(18,3) COMMENT '私有面积',
	HOUSE_STATE INT NOT NULL COMMENT '房屋状态',
	DOOR_NO VARCHAR(20) COMMENT '门牌号',
	HOUSE_TYPE VARCHAR(32) COMMENT '房屋类型',
	USE_TYPE VARCHAR(32) COMMENT '设计用途',
	HOUSE_PORPERTY VARCHAR(32) COMMENT '产别',
	STRUCTURE VARCHAR(32) COMMENT '结构',
	KNOT_SIZE VARCHAR(32) COMMENT '套型',
	HOUSE_FROM VARCHAR(32) COMMENT '房屋来源',
	ADDRESS VARCHAR(200) COMMENT '房屋坐落',
	LAND_INFO VARCHAR(32) COMMENT '土地',
	INBIZ BIT(1) NOT NULL COMMENT 'INBIZ',
	IN_BUSINESS_CODE VARCHAR(32) COMMENT 'IN_BUSINESS_CODE',
	DATA_SOURCE VARCHAR(32) COMMENT '数据来源',
	SOUTH_NEXT VARCHAR(50) COMMENT '南临',
	WEST_NEXT VARCHAR(50) COMMENT '西临',
	NORTH_NEXT VARCHAR(50) COMMENT '北临',
	EAST_NEXT VARCHAR(50) COMMENT '东临',
	EAST_WALL VARCHAR(32) COMMENT '东墙',
	WEST_WALL VARCHAR(32) COMMENT '西墙',
	SOUTH_WALL VARCHAR(32) COMMENT '南墙',
	NORTH_WALL VARCHAR(32) COMMENT '北墙',
	MAP_TIME TIMESTAMP COMMENT '测绘时间',
	DIRECTION VARCHAR(32) COMMENT '朝向',
	INIT_REGISTER BIT(1) NOT NULL COMMENT '初始登记',
	INIT_REGISTER_BUSINESS_CODE VARCHAR(32) COMMENT '初始登记业务编号',
	FIRMLY_POWER BIT(1) NOT NULL COMMENT '是否确权',
	FIRMLY_POWER_BUSINESS_CODE VARCHAR(32) COMMENT '确权业务编码',
	OUT_PLAN BIT(1) NOT NULL COMMENT '超规划',
	VERSION INT COMMENT 'VERSION',
	SUM_PRICE DECIMAL(18,3) COMMENT '购房款',
	PAY_TYPE VARCHAR(32) COMMENT '购买方式',
	OWNER_ID VARCHAR(32) NOT NULL COMMENT '产权人',
	MEMO VARCHAR(200) COMMENT '备注',
	RECORD_ID VARCHAR(32) NOT NULL COMMENT '备案人',
	BUILD_COST DECIMAL(18,3) COMMENT '建安成本',
	CONSTRAINT PK_HOUSE PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '房屋表' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.PROJECT_BUILD_PROCESS
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	PROJECT_ID VARCHAR(32) COMMENT 'PROJECT_ID',
	PROCESS_TIME TIMESTAMP COMMENT '进度时间',
	MONEY DECIMAL(18,3) COMMENT '投资额',
	MEMO VARCHAR(200) COMMENT 'MEMO',
	CONSTRAINT PK_PROJECTCREATEPROCESS PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '项目工程进度' DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.POOL_BUILD
(
	ID VARCHAR(32) NOT NULL COMMENT 'ID',
	MAP_NUMBER VARCHAR(50) COMMENT '图号',
	BLOCK_NO VARCHAR(50) COMMENT '丘号',
	BUILD_NO VARCHAR(50) COMMENT '幢号',
	HOUSE_NUMBER VARCHAR(50) COMMENT '房屋编号',
	BUILD_NAME VARCHAR(50) COMMENT '楼幢名称',
	STRUCTURE VARCHAR(32) COMMENT '结构',
	ADDRESS VARCHAR(200) COMMENT '地址',
	AREA DECIMAL(18,3) COMMENT '面积',
	MEMO VARCHAR(200) COMMENT '备注',
	SECTION_ID VARCHAR(32) NOT NULL COMMENT 'SECTION_ID',
	REG_TIME TIMESTAMP COMMENT '登记时间',
	FLOOR_COUNT INT COMMENT '总层数',
	CONSTRAINT PK_POOLBUILD PRIMARY KEY (ID)
) ENGINE = InnoDB COMMENT = '共有建筑' DEFAULT CHARACTER SET utf8;



/* Create Foreign Keys */

ALTER TABLE HOUSE_INFO.DISTRICT
	ADD FOREIGN KEY (PROVINCECITYID)
	REFERENCES HOUSE_INFO.PROVINCE_CITY (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.POOL_BUILD
	ADD FOREIGN KEY (SECTION_ID)
	REFERENCES HOUSE_INFO.SECTION (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.PROJECT
	ADD CONSTRAINT FK_PROJECT_REFERENCE_SECTION FOREIGN KEY (SECTIONID)
	REFERENCES HOUSE_INFO.SECTION (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.SMSUBCOMPANY
	ADD CONSTRAINT FK_SMSUBCOM_REFERENCE_SECTION FOREIGN KEY (SECTION)
	REFERENCES HOUSE_INFO.SECTION (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.OWNER_GROUP
	ADD CONSTRAINT FK_OWNERGRO_REFERENCE_SECTION FOREIGN KEY (SECTION)
	REFERENCES HOUSE_INFO.SECTION (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.OLDHOUSECONTRACT
	ADD FOREIGN KEY (CONTRACT_ID)
	REFERENCES HOUSE_INFO.HOUSE_CONTRACT (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.CONTRACT_ATTACH_OWNER
	ADD FOREIGN KEY (CONTRACT_ID)
	REFERENCES HOUSE_INFO.HOUSE_CONTRACT (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.NEW_HOUSE_CONTRACT
	ADD FOREIGN KEY (CONTRACT_ID)
	REFERENCES HOUSE_INFO.HOUSE_CONTRACT (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.PROJECT_SELL_CARD
	ADD FOREIGN KEY (CARD_ID)
	REFERENCES HOUSE_INFO.CARD (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.POOL_OWNER
	ADD FOREIGN KEY (CARD_ID)
	REFERENCES HOUSE_INFO.CARD (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.HOUSE_CARD
	ADD FOREIGN KEY (CARD_ID)
	REFERENCES HOUSE_INFO.CARD (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.HOUSE
	ADD FOREIGN KEY (OWNER_ID)
	REFERENCES HOUSE_INFO.HOUSE_OWNER (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.HOUSE_CONTRACT
	ADD FOREIGN KEY (OWNER_ID)
	REFERENCES HOUSE_INFO.HOUSE_OWNER (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.POOL_OWNER
	ADD FOREIGN KEY (OWNER_ID)
	REFERENCES HOUSE_INFO.HOUSE_OWNER (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.CONTRACT_ATTACH_OWNER
	ADD FOREIGN KEY (OWNER_ID)
	REFERENCES HOUSE_INFO.HOUSE_OWNER (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.RECORD_ATTACH_WONER
	ADD FOREIGN KEY (OWNER_ID)
	REFERENCES HOUSE_INFO.HOUSE_OWNER (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.HOUSE
	ADD FOREIGN KEY (RECORD_ID)
	REFERENCES HOUSE_INFO.HOUSE_OWNER (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.NEW_HOUSE_CONTRACT
	ADD CONSTRAINT FK_NEWHOUSE_REFERENCE_DEMPLOYE FOREIGN KEY (DEMPLOYEE)
	REFERENCES HOUSE_INFO.DEMPLOYEE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.OLDHOUSECONTRACT
	ADD CONSTRAINT FK_OLDHOUSE_REFERENCE_IEMPLOYE2 FOREIGN KEY (IEMPLOYEE)
	REFERENCES HOUSE_INFO.SELL_EMPLOYEE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.EMPLOYEE_ATTACH_ACTION
	ADD FOREIGN KEY (ATTACH_EMPLOYEE_ID)
	REFERENCES HOUSE_INFO.ATTACH_EMPLOYEE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.SELL_EMPLOYEE
	ADD FOREIGN KEY (ATTACH_EMLOPEE_ID)
	REFERENCES HOUSE_INFO.ATTACH_EMPLOYEE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.DEMPLOYEE
	ADD FOREIGN KEY (ATTACH_EMPLOYEE_ID)
	REFERENCES HOUSE_INFO.ATTACH_EMPLOYEE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.DEMPLOYEE
	ADD CONSTRAINT FK_DEMPLOYE_REFERENCE_DEVELOPE FOREIGN KEY (DEVELOPER)
	REFERENCES HOUSE_INFO.DEVELOPER (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.PROJECT
	ADD CONSTRAINT FK_PROJECT_REFERENCE_DEVELOPE FOREIGN KEY (DEVELOPERID)
	REFERENCES HOUSE_INFO.DEVELOPER (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.PROJECT_BUILD_PROCESS
	ADD CONSTRAINT FK_PROJECTC_REFERENCE_PROJECT FOREIGN KEY (PROJECT_ID)
	REFERENCES HOUSE_INFO.PROJECT (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.BUILD
	ADD CONSTRAINT FK_BUILD_REFERENCE_PROJECT FOREIGN KEY (PROJECT_ID)
	REFERENCES HOUSE_INFO.PROJECT (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.GRID_BLOCK
	ADD FOREIGN KEY (ROW_ID)
	REFERENCES HOUSE_INFO.GRID_ROW (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.HOUSE
	ADD CONSTRAINT FK_HOUSE_REFERENCE_LANDINFO FOREIGN KEY (LAND_INFO)
	REFERENCES HOUSE_INFO.LAND_INFO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.BUILD
	ADD FOREIGN KEY (LAND_ID)
	REFERENCES HOUSE_INFO.LAND_INFO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.BUILD
	ADD FOREIGN KEY (CARD_ID)
	REFERENCES HOUSE_INFO.PROJECT_SELL_CARD (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.GRID_ROW
	ADD FOREIGN KEY (GRID_ID)
	REFERENCES HOUSE_INFO.BUILD_GRID_MAP (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.HOUSE_GRID_TITLE
	ADD FOREIGN KEY (GRILD_ID)
	REFERENCES HOUSE_INFO.BUILD_GRID_MAP (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.SECTION
	ADD CONSTRAINT FK_SECTION_REFERENCE_DISTRICT FOREIGN KEY (DISTRICTID)
	REFERENCES HOUSE_INFO.DISTRICT (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.SMSUBCOMPANY
	ADD CONSTRAINT FK_SMSUBCOM_REFERENCE_MCOMPANY FOREIGN KEY (MCOMPANY)
	REFERENCES HOUSE_INFO.MCOMPANY (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.SELL_EMPLOYEE
	ADD CONSTRAINT FK_IEMPLOYE_REFERENCE_INTERMED FOREIGN KEY (INTERMEDIARY)
	REFERENCES HOUSE_INFO.HOUSE_SELL_COMPANY (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.EVALUATE_CORPORATION
	ADD FOREIGN KEY (ATTACH_ID)
	REFERENCES HOUSE_INFO.ATTACH_CORPORATION (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.FINANCIAL_CORPORATION
	ADD FOREIGN KEY (ATTACH_ID)
	REFERENCES HOUSE_INFO.ATTACH_CORPORATION (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.HOUSE_SELL_COMPANY
	ADD FOREIGN KEY (ATTACH_ID)
	REFERENCES HOUSE_INFO.ATTACH_CORPORATION (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.ORG_ATTACH_ACTION
	ADD FOREIGN KEY (CORPORATION_ID)
	REFERENCES HOUSE_INFO.ATTACH_CORPORATION (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.MAPPING_CORPORATION
	ADD FOREIGN KEY (ATTACH_ID)
	REFERENCES HOUSE_INFO.ATTACH_CORPORATION (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.MCOMPANY
	ADD FOREIGN KEY (ATTACH_ID)
	REFERENCES HOUSE_INFO.ATTACH_CORPORATION (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.DEVELOPER
	ADD FOREIGN KEY (ATTACH_ID)
	REFERENCES HOUSE_INFO.ATTACH_CORPORATION (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.BUILD_GRID_MAP
	ADD FOREIGN KEY (BUILD_ID)
	REFERENCES HOUSE_INFO.BUILD (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.HOUSE
	ADD CONSTRAINT FK_HOUSE_HOUSEANDB_BUILD FOREIGN KEY (BUILDID)
	REFERENCES HOUSE_INFO.BUILD (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.RECORD_ATTACH_WONER
	ADD FOREIGN KEY (HOUSE_ID)
	REFERENCES HOUSE_INFO.HOUSE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.HOUSE_CONTRACT
	ADD FOREIGN KEY (HOUSE_ID)
	REFERENCES HOUSE_INFO.HOUSE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.GRID_BLOCK
	ADD FOREIGN KEY (HOUSE_ID)
	REFERENCES HOUSE_INFO.HOUSE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.HOUSE_CARD
	ADD FOREIGN KEY (HOUSE_ID)
	REFERENCES HOUSE_INFO.HOUSE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.HOUSE_STATE
	ADD CONSTRAINT FK_HOUSESTA_REFERENCE_HOUSE FOREIGN KEY (HOUSEID)
	REFERENCES HOUSE_INFO.HOUSE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE HOUSE_INFO.POOL_OWNER
	ADD FOREIGN KEY (HOUSE_ID)
	REFERENCES HOUSE_INFO.HOUSE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



