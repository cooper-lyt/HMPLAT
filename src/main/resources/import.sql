-- If you are using Hibernate as the JPA provider, you can use this file to load seed data into the database using SQL statements
-- The portable approach is to use a startup component (such as the @PostConstruct method of a @Startup @Singleton) or observe a lifecycle event fired by Seam Servlet

USE DB_PLAT_SYSTEM;

-- 系统参数
-- INSERT INTO SYSTEM_PARAM(ID,TYPE,VALUE,MEMO) VALUES('system.business.forwordToTask','BOOLEAN','true','业务建立后是否自动跳转到业务处理页面,是:true');


INSERT INTO SYSTEM_PARAM(ID,TYPE,VALUE,MEMO) VALUES('erp.finance.bankAccount','STRING','1002','银行总帐科目代码');
INSERT INTO SYSTEM_PARAM(ID,TYPE,VALUE,MEMO) VALUES('erp.finance.cashAccount','STRING','1001','现金总帐科目代码');


INSERT INTO SYSTEM_PARAM(ID,TYPE,VALUE,MEMO) VALUES('house.id.gentype','STRING','JDJT246_3','房屋编码生成方法： JDJT246_3 竣工时间法 JDJT246_4 坐标法 JDJT246_5 分宗法 JDJT246_6 分幅法');
INSERT INTO SYSTEM_PARAM(ID,TYPE,VALUE,MEMO) VALUES('house.id.useBlock','STRING','MAP_BLOCK','房屋编码使 MAP_BLOCK 丘号 LAND_BLOCK 宗地号');



-- 业务类别
INSERT INTO BUSINESS_CATEGORY(ID, NAME, PRIORITY) VALUES('house.owner.initReg','初始登记',1);



-- 业务


-- 测试业务
-- INSERT INTO BUSINESS_DEFINE(ID, NAME, WF_NAME, START_PAGE, START_DATA_VALIDATOR, TASK_SERVICE, CATEGORY, MEMO, VERSION) VALUES('system.business.test','测试流程','processTest','','','','erp.sale','测试流程',0);


-- 功能种类
INSERT INTO FUNC_CATEGORY (ID, NAME, ICON, PRIORITY, MEMO) VALUES ('system.config', '系统设置', '', '1', '超级管理员,一般由实施方有此权限');
INSERT INTO FUNC_CATEGORY (ID, NAME, ICON, PRIORITY, MEMO) VALUES ('system.manager', '系统管理', '', '2', '管理员');

INSERT INTO FUNC_CATEGORY (ID, NAME, ICON, PRIORITY, MEMO) VALUES ('house.datas', '房屋信息管理', '', '3', '一般为测绘');

INSERT INTO FUNC_CATEGORY (ID, NAME, ICON, PRIORITY, MEMO) VALUES ('house.data.attachCorp', '从业机构管理', '', '4', '');


-- 功能
INSERT INTO FUNCTION (ID, NAME, CATEGORY, ICON, LOCATION, BANNER, PRIORITY, MEMO) VALUES ('system.param', '系统参数管理', 'system.config', '', '/func/system/config/SystemParams.seam', '', '2', '系统运行方式设置');
INSERT INTO FUNCTION (ID, NAME, CATEGORY, ICON, LOCATION, BANNER, PRIORITY, MEMO) VALUES ('system.person', '人员维护', 'system.manager', '', '/func/system/manager/PersonMgr.seam', '', '3', '管理自然人');
INSERT INTO FUNCTION (ID, NAME, CATEGORY, ICON, LOCATION, BANNER, PRIORITY, MEMO) VALUES ('system.businessConfig','业务管理','system.config','','/func/system/config/BusinessMgr.seam','','3','业务处理配置');
INSERT INTO FUNCTION (ID, NAME, CATEGORY, ICON, LOCATION, BANNER, PRIORITY, MEMO) VALUES ('system.employee','员工管理','system.manager', '', '/func/system/manager/EmployeeMgr.seam','','4','员工和组织机构管理');
INSERT INTO FUNCTION (ID, NAME, CATEGORY, ICON, LOCATION, BANNER, PRIORITY, MEMO) VALUES ('system.role','角色管理','system.config','','/func/system/config/RoleMgr.seam','','4','角色管理和角色分配启动业务');
INSERT INTO FUNCTION (ID, NAME, CATEGORY, ICON, LOCATION, BANNER, PRIORITY, MEMO) VALUES ('system.word','字典管理','system.manager','','/func/system/manager/WordMgr.seam','','5','字典管理');
INSERT INTO FUNCTION (ID, NAME, CATEGORY, ICON, LOCATION, BANNER, PRIORITY, MEMO) VALUES ('system.jbpmProcessDeployment','流程部署','system.config','','/func/system/jbpm/ProcessDefinition.seam','',7,'部署JBPM PAR 流程');

INSERT INTO FUNCTION (ID, NAME, CATEGORY, ICON, LOCATION, BANNER, PRIORITY, MEMO) VALUES ('system.processInstanceMgr', '流程管理', 'system.manager', '', '/func/system/jbpm/ProcessInstanceMgr.seam', '', '6', '');

INSERT INTO FUNCTION (ID, NAME, CATEGORY, ICON, LOCATION, BANNER, PRIORITY, MEMO) VALUES ('house.districtMgr', '行政区管理', 'house.datas', '', '/func/house/datas/DistrictMgr.seam', '', '1', '');
INSERT INTO FUNCTION (ID, NAME, CATEGORY, ICON, LOCATION, BANNER, PRIORITY, MEMO) VALUES ('house.sectionMgr', '小区管理', 'house.datas', '', '/func/house/datas/SectionMgr.seam', '', '2', '');
INSERT INTO FUNCTION (ID, NAME, CATEGORY, ICON, LOCATION, BANNER, PRIORITY, MEMO) VALUES ('house.projectMgr', '项目管理', 'house.datas', '', '/func/house/datas/ProjectMgr.seam', '', '3', '');

INSERT INTO FUNCTION (ID, NAME, CATEGORY, ICON, LOCATION, BANNER, PRIORITY, MEMO) VALUES ('house.Developer', '开发商管理', 'house.data.attachCorp', '', '/func/house/datas/DeveloperMgr.seam', '', '1', '');
INSERT INTO FUNCTION (ID, NAME, CATEGORY, ICON, LOCATION, BANNER, PRIORITY, MEMO) VALUES ('house.MappingCorporation', '测绘机构管理', 'house.data.attachCorp', '', '/func/house/datas/MappingCorporationMgr.seam', '', '2', '');
INSERT INTO FUNCTION (ID, NAME, CATEGORY, ICON, LOCATION, BANNER, PRIORITY, MEMO) VALUES ('house.EvaluateCorporation', '评估机构管理', 'house.data.attachCorp', '', '/func/house/datas/EvaluateCorporationMgr.seam', '', '3', '');
INSERT INTO FUNCTION (ID, NAME, CATEGORY, ICON, LOCATION, BANNER, PRIORITY, MEMO) VALUES ('house.FinancialCorporation', '金融机构管理', 'house.data.attachCorp', '', '/func/house/datas/FinancialCorporationMgr.seam', '', '4', '');


-- 角色


INSERT INTO ROLE (ID, NAME, DESCRIPTION,PRIORITY) VALUES ('system.config', '系统设置', '调整系统运行方式', 1);
INSERT INTO ROLE (ID, NAME, DESCRIPTION,PRIORITY) VALUES ('system.manager', '系统管理', '系统管理', 2);

INSERT INTO ROLE (ID, NAME, DESCRIPTION,PRIORITY) VALUES ('house.data.manager', '房屋信息数据维护', '空间库房屋相关数据管理', 3);
INSERT INTO ROLE (ID, NAME, DESCRIPTION,PRIORITY) VALUES ('house.data.attachCorp', '从业机构维护', '从业机构维护', 4);

-- ROLE_FUNCTION 角色种类
INSERT INTO ROLE_FUNCTION (ROL_ID, FUN_ID) VALUES ('system.config', 'system.param');
INSERT INTO ROLE_FUNCTION (ROL_ID, FUN_ID) VALUES ('system.config', 'system.businessConfig');
INSERT INTO ROLE_FUNCTION (ROL_ID, FUN_ID) VALUES ('system.config', 'system.employee');
INSERT INTO ROLE_FUNCTION (ROL_ID, FUN_ID) VALUES ('system.config', 'system.person');
INSERT INTO ROLE_FUNCTION (ROL_ID, FUN_ID) VALUES ('system.config', 'system.role');
INSERT INTO ROLE_FUNCTION (ROL_ID, FUN_ID) VALUES ('system.config','system.jbpmProcessDeployment');
INSERT INTO ROLE_FUNCTION (ROL_ID, FUN_ID) VALUES ('system.config', 'system.word');

INSERT INTO ROLE_FUNCTION (ROL_ID, FUN_ID) VALUES ('system.manager', 'system.role');
INSERT INTO ROLE_FUNCTION (ROL_ID, FUN_ID) VALUES ('system.manager', 'system.employee');
INSERT INTO ROLE_FUNCTION (ROL_ID, FUN_ID) VALUES ('system.manager', 'system.person');
INSERT INTO ROLE_FUNCTION (ROL_ID, FUN_ID) VALUES ('system.manager', 'system.word');
INSERT INTO ROLE_FUNCTION (ROL_ID, FUN_ID) VALUES ('system.manager', 'system.processInstanceMgr');

INSERT INTO ROLE_FUNCTION (ROL_ID, FUN_ID) VALUES ('house.data.manager', 'house.districtMgr');
INSERT INTO ROLE_FUNCTION (ROL_ID, FUN_ID) VALUES ('house.data.manager', 'house.sectionMgr');
INSERT INTO ROLE_FUNCTION (ROL_ID, FUN_ID) VALUES ('house.data.manager', 'house.projectMgr');

INSERT INTO ROLE_FUNCTION (ROL_ID, FUN_ID) VALUES ('house.data.attachCorp', 'house.Developer');
INSERT INTO ROLE_FUNCTION (ROL_ID, FUN_ID) VALUES ('house.data.attachCorp', 'house.MappingCorporation');
INSERT INTO ROLE_FUNCTION (ROL_ID, FUN_ID) VALUES ('house.data.attachCorp', 'house.EvaluateCorporation');
INSERT INTO ROLE_FUNCTION (ROL_ID, FUN_ID) VALUES ('house.data.attachCorp', 'house.FinancialCorporation');



-- ADMIN INSERY
-- INSERT INTO PERSON (ID,NAME,CREDENTIALS_TYPE,_FOREIGN,CREDENTIALS_NUMBER,DATE_OF_BIRTH) VALUES ('admin','admin','OTHER',1,'1','2013-07-15 10:27:08');
-- INSERT INTO EMPLOYEE(ID,ENABLE,PERSON_ID,PASSWORD,ORGANIZATION) VALUES ('admin',b'1','admin','admin','0');
-- INSERT INTO ROLE_CATE_EMP (EMP_ID, ROLE_ID) VALUES ('admin','admin');
-- INSERT INTO ROLE_ROLE_CATEGROY(ROLE_ID, CAT_ID) VALUES ('system.manager','admin');



-- WORD

INSERT INTO WORD_CATEGORY(ID, NAME, MEMO, SYSTEM) VALUES ('house.project.buildSize','建筑规模','',b'1');

INSERT INTO WORD(ID, _KEY, _VALUE, CATEGORY, DESCRIPTION, PRIORITY, ENABLE) VALUES ('buildSize.small','small','小','house.project.buildSize','','1',b'1');
INSERT INTO WORD(ID, _KEY, _VALUE, CATEGORY, DESCRIPTION, PRIORITY, ENABLE) VALUES ('buildSize.big','big','大','house.project.buildSize','','2',b'1');


INSERT INTO WORD_CATEGORY(ID, NAME, MEMO, SYSTEM) VALUES ('system.empJob','职位','',b'1');

INSERT INTO WORD(ID, _KEY, _VALUE, CATEGORY, DESCRIPTION, PRIORITY, ENABLE) VALUES ('system.empJob.manager','manager','科长','system.empJob','','3',b'1');
INSERT INTO WORD(ID, _KEY, _VALUE, CATEGORY, DESCRIPTION, PRIORITY, ENABLE) VALUES ('system.empJob.boss','boss','科员','system.empJob','','5',b'1');


INSERT INTO WORD_CATEGORY(ID, NAME, MEMO, SYSTEM) VALUES ('erp.bank','银行','',b'1');
INSERT INTO WORD(ID, _KEY, _VALUE, CATEGORY, DESCRIPTION, PRIORITY, ENABLE) VALUES ('erp.bank.ccb','CCB','建设银行','erp.bank','',2,b'1');
INSERT INTO WORD(ID, _KEY, _VALUE, CATEGORY, DESCRIPTION, PRIORITY, ENABLE) VALUES ('erp.bank.boc','BOC','中国银行','erp.bank','',1,b'1');
INSERT INTO WORD(ID, _KEY, _VALUE, CATEGORY, DESCRIPTION, PRIORITY, ENABLE) VALUES ('erp.bank.abc','ABC','农业银行','erp.bank','',3,b'1');
INSERT INTO WORD(ID, _KEY, _VALUE, CATEGORY, DESCRIPTION, PRIORITY, ENABLE) VALUES ('erp.bank.icbc','ICBC','工商银行','erp.bank','',4,b'1');
INSERT INTO WORD(ID, _KEY, _VALUE, CATEGORY, DESCRIPTION, PRIORITY, ENABLE) VALUES ('erp.bank.cmbc','CMBC','民生银行','erp.bank','',12,b'1');
INSERT INTO WORD(ID, _KEY, _VALUE, CATEGORY, DESCRIPTION, PRIORITY, ENABLE) VALUES ('erp.bank.cmb','CMB','招商银行','erp.bank','',5,b'1');
INSERT INTO WORD(ID, _KEY, _VALUE, CATEGORY, DESCRIPTION, PRIORITY, ENABLE) VALUES ('erp.bank.cib','CIB','兴业银行','erp.bank','',13,b'1');
INSERT INTO WORD(ID, _KEY, _VALUE, CATEGORY, DESCRIPTION, PRIORITY, ENABLE) VALUES ('erp.bank.bob','BOB','北京银行','erp.bank','',14,b'1');
INSERT INTO WORD(ID, _KEY, _VALUE, CATEGORY, DESCRIPTION, PRIORITY, ENABLE) VALUES ('erp.bank.bcm','BCM','交通银行','erp.bank','',6,b'1');
INSERT INTO WORD(ID, _KEY, _VALUE, CATEGORY, DESCRIPTION, PRIORITY, ENABLE) VALUES ('erp.bank.ceb','CEB','光大银行','erp.bank','',7,b'1');
INSERT INTO WORD(ID, _KEY, _VALUE, CATEGORY, DESCRIPTION, PRIORITY, ENABLE) VALUES ('erp.bank.citic','CITIC','中信银行','erp.bank','',8,b'1');
INSERT INTO WORD(ID, _KEY, _VALUE, CATEGORY, DESCRIPTION, PRIORITY, ENABLE) VALUES ('erp.bank.gdb','GDB','广东发展银行','erp.bank','',9,b'1');
INSERT INTO WORD(ID, _KEY, _VALUE, CATEGORY, DESCRIPTION, PRIORITY, ENABLE) VALUES ('erp.bank.spdb','SPDB','上海浦东发展银行','erp.bank','',10,b'1');
INSERT INTO WORD(ID, _KEY, _VALUE, CATEGORY, DESCRIPTION, PRIORITY, ENABLE) VALUES ('erp.bank.sdb','SDB','深圳发展银行','erp.bank','',11,b'1');

insert word_category (id,name,SYSTEM, memo) values(1,'套型',b'0','');
insert word_category (id,name,SYSTEM, memo) values(3,'收据类型',b'0','');
insert word_category (id,name,SYSTEM, memo) values(4,'文件类型',b'0','');
insert word_category (id,name,SYSTEM, memo) values(70,'所属行业',b'0','');
insert word_category (id,name,SYSTEM, memo) values(71,'单位性质',b'0','');
insert word_category (id,name,SYSTEM, memo) values(25,'设计用途',b'0','');
insert word_category (id,name,SYSTEM, memo) values(26,'产别',b'0','');
insert word_category (id,name,SYSTEM, memo) values(27,'结构',b'0','');
insert word_category (id,name,SYSTEM, memo) values(28,'产权来源',b'0','');
insert word_category (id,name,SYSTEM, memo) values(32,'土地性质',b'0','');
insert word_category (id,name,SYSTEM, memo) values(33,'四墙类型',b'0','');
insert word_category (id,name,SYSTEM, memo) values(42,'权利种类',b'1','');
insert word_category (id,name,SYSTEM, memo) values(52,'评估方法',b'0','');
insert word_category (id,name,SYSTEM, memo) values(60,'申请配租类别',b'0','');
insert word_category (id,name,SYSTEM, memo) values(62,'楼幢类型',b'0','');
insert word_category (id,name,SYSTEM, memo) values(64,'房屋类型',b'0','');;
insert word_category (id,name,SYSTEM, memo) values(66,'供役地房屋利用方式',b'0','');
insert word_category (id,name,SYSTEM, memo) values(67,'与产权人关系',b'0','');
insert word_category (id,name,SYSTEM, memo) values(68,'共有情况',b'0','');
insert word_category (id,name,SYSTEM, memo) values(54,'付款方式',b'0','');
insert word_category (id,name,SYSTEM, memo) values(55,'土地取得方式',b'0','');
insert word_category (id,name,SYSTEM, memo) values(75,'学历',b'0','');
insert word_category (id,name,SYSTEM, memo) values(79,'国籍',b'0','');
insert word_category (id,name,SYSTEM, memo) values(80,'户籍所在地',b'0','');
insert word_category (id,name,SYSTEM, memo) values(1357,'变更原因',b'0','');
insert word_category (id,name,SYSTEM, memo) values(76,'证书级别',b'0','');

INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(11,'北京市',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(12,'天津市',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(13,'河北省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(14,'山西省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(15,'内蒙古自治区',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(21,'辽宁省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(22,'吉林省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(23,'黑龙江省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(31,'上海市',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(32,'江苏省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(33,'浙江省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(34,'安徽省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(35,'福建省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(36,'江西省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(37,'山东省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(41,'河南省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(42,'湖北省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(43,'湖南省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(44,'广东省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(45,'广西壮族自治区',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(46,'海南省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(50,'重庆市',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(51,'四川省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(52,'贵州省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(53,'云南省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(54,'西藏自治区',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(61,'陕西省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(62,'甘肃省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(63,'青海省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(64,'宁夏回族自治区',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(65,'新疆维吾尔自治区',0);


INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(71,'台湾省',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(81,'香港特别行政区',0);
INSERT INTO PROVINCE(PID,NAME,SORT)VALUES(82,'澳门特别行政区',0);

INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1101,11,'市辖区',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1201,12,'市辖区',0);;
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1301,13,'石家庄市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1302,13,'唐山市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1303,13,'秦皇岛市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1304,13,'邯郸市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1305,13,'邢台市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1306,13,'保定市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1307,13,'张家口市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1308,13,'承德市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1309,13,'沧州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1310,13,'廊坊市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1311,13,'衡水市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1401,14,'太原市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1402,14,'大同市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1403,14,'阳泉市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1404,14,'长治市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1405,14,'晋城市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1406,14,'朔州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1407,14,'晋中市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1408,14,'运城市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1409,14,'忻州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1410,14,'临汾市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1411,14,'吕梁市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1501,15,'呼和浩特市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1502,15,'包头市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1503,15,'乌海市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1504,15,'赤峰市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1505,15,'通辽市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1506,15,'鄂尔多斯市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1507,15,'呼伦贝尔市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1508,15,'巴彦淖尔市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1509,15,'乌兰察布市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1522,15,'兴安盟',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1525,15,'锡林郭勒盟',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(1529,15,'阿拉善盟',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2101,21,'沈阳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2102,21,'大连市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2103,21,'鞍山市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2104,21,'抚顺市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2105,21,'本溪市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2106,21,'丹东市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2107,21,'锦州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2108,21,'营口市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2109,21,'阜新市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2110,21,'辽阳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2111,21,'盘锦市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2112,21,'铁岭市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2113,21,'朝阳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2114,21,'葫芦岛市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2201,22,'长春市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2202,22,'吉林市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2203,22,'四平市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2204,22,'辽源市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2205,22,'通化市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2206,22,'白山市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2207,22,'松原市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2208,22,'白城市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2224,22,'延边朝鲜族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2301,23,'哈尔滨市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2302,23,'齐齐哈尔市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2303,23,'鸡西市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2304,23,'鹤岗市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2305,23,'双鸭山市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2306,23,'大庆市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2307,23,'伊春市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2308,23,'佳木斯市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2309,23,'七台河市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2310,23,'牡丹江市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2311,23,'黑河市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2312,23,'绥化市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(2327,23,'大兴安岭地区',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3101,31,'市辖区',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3201,32,'南京市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3202,32,'无锡市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3203,32,'徐州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3204,32,'常州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3205,32,'苏州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3206,32,'南通市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3207,32,'连云港市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3208,32,'淮安市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3209,32,'盐城市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3210,32,'扬州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3211,32,'镇江市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3212,32,'泰州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3213,32,'宿迁市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3301,33,'杭州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3302,33,'宁波市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3303,33,'温州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3304,33,'嘉兴市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3305,33,'湖州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3306,33,'绍兴市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3307,33,'金华市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3308,33,'衢州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3309,33,'舟山市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3310,33,'台州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3311,33,'丽水市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3401,34,'合肥市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3402,34,'芜湖市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3403,34,'蚌埠市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3404,34,'淮南市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3405,34,'马鞍山市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3406,34,'淮北市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3407,34,'铜陵市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3408,34,'安庆市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3410,34,'黄山市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3411,34,'滁州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3412,34,'阜阳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3413,34,'宿州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3415,34,'六安市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3416,34,'亳州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3417,34,'池州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3418,34,'宣城市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3501,35,'福州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3502,35,'厦门市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3503,35,'莆田市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3504,35,'三明市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3505,35,'泉州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3506,35,'漳州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3507,35,'南平市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3508,35,'龙岩市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3509,35,'宁德市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3601,36,'南昌市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3602,36,'景德镇市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3603,36,'萍乡市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3604,36,'九江市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3605,36,'新余市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3606,36,'鹰潭市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3607,36,'赣州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3608,36,'吉安市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3609,36,'宜春市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3610,36,'抚州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3611,36,'上饶市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3701,37,'济南市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3702,37,'青岛市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3703,37,'淄博市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3704,37,'枣庄市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3705,37,'东营市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3706,37,'烟台市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3707,37,'潍坊市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3708,37,'济宁市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3709,37,'泰安市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3710,37,'威海市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3711,37,'日照市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3712,37,'莱芜市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3713,37,'临沂市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3714,37,'德州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3715,37,'聊城市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3716,37,'滨州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(3717,37,'菏泽市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4101,41,'郑州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4102,41,'开封市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4103,41,'洛阳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4104,41,'平顶山市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4105,41,'安阳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4106,41,'鹤壁市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4107,41,'新乡市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4108,41,'焦作市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4109,41,'濮阳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4110,41,'许昌市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4111,41,'漯河市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4112,41,'三门峡市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4113,41,'南阳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4114,41,'商丘市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4115,41,'信阳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4116,41,'周口市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4117,41,'驻马店市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4190,41,'省直辖县级行政区划',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4201,42,'武汉市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4202,42,'黄石市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4203,42,'十堰市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4205,42,'宜昌市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4206,42,'襄阳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4207,42,'鄂州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4208,42,'荆门市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4209,42,'孝感市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4210,42,'荆州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4211,42,'黄冈市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4212,42,'咸宁市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4213,42,'随州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4228,42,'恩施土家族苗族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4290,42,'省直辖县级行政区划',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4301,43,'长沙市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4302,43,'株洲市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4303,43,'湘潭市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4304,43,'衡阳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4305,43,'邵阳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4306,43,'岳阳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4307,43,'常德市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4308,43,'张家界市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4309,43,'益阳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4310,43,'郴州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4311,43,'永州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4312,43,'怀化市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4313,43,'娄底市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4331,43,'湘西土家族苗族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4401,44,'广州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4402,44,'韶关市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4403,44,'深圳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4404,44,'珠海市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4405,44,'汕头市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4406,44,'佛山市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4407,44,'江门市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4408,44,'湛江市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4409,44,'茂名市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4412,44,'肇庆市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4413,44,'惠州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4414,44,'梅州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4415,44,'汕尾市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4416,44,'河源市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4417,44,'阳江市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4418,44,'清远市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4419,44,'东莞市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4420,44,'中山市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4451,44,'潮州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4452,44,'揭阳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4453,44,'云浮市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4501,45,'南宁市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4502,45,'柳州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4503,45,'桂林市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4504,45,'梧州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4505,45,'北海市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4506,45,'防城港市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4507,45,'钦州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4508,45,'贵港市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4509,45,'玉林市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4510,45,'百色市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4511,45,'贺州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4512,45,'河池市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4513,45,'来宾市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4514,45,'崇左市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4601,46,'海口市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4602,46,'三亚市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4603,46,'三沙市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(4690,46,'省直辖县级行政区划',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5001,50,'市辖区',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5101,51,'成都市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5103,51,'自贡市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5104,51,'攀枝花市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5105,51,'泸州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5106,51,'德阳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5107,51,'绵阳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5108,51,'广元市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5109,51,'遂宁市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5110,51,'内江市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5111,51,'乐山市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5113,51,'南充市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5114,51,'眉山市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5115,51,'宜宾市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5116,51,'广安市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5117,51,'达州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5118,51,'雅安市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5119,51,'巴中市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5120,51,'资阳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5132,51,'阿坝藏族羌族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5133,51,'甘孜藏族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5134,51,'凉山彝族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5201,52,'贵阳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5202,52,'六盘水市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5203,52,'遵义市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5204,52,'安顺市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5205,52,'毕节市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5206,52,'铜仁市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5223,52,'黔西南布依族苗族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5226,52,'黔东南苗族侗族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5227,52,'黔南布依族苗族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5301,53,'昆明市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5303,53,'曲靖市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5304,53,'玉溪市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5305,53,'保山市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5306,53,'昭通市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5307,53,'丽江市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5308,53,'普洱市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5309,53,'临沧市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5323,53,'楚雄彝族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5325,53,'红河哈尼族彝族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5326,53,'文山壮族苗族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5328,53,'西双版纳傣族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5329,53,'大理白族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5331,53,'德宏傣族景颇族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5333,53,'怒江傈僳族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5334,53,'迪庆藏族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5401,54,'拉萨市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5421,54,'昌都地区',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5422,54,'山南地区',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5423,54,'日喀则地区',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5424,54,'那曲地区',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5425,54,'阿里地区',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(5426,54,'林芝地区',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6101,61,'西安市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6102,61,'铜川市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6103,61,'宝鸡市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6104,61,'咸阳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6105,61,'渭南市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6106,61,'延安市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6107,61,'汉中市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6108,61,'榆林市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6109,61,'安康市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6110,61,'商洛市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6201,62,'兰州市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6202,62,'嘉峪关市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6203,62,'金昌市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6204,62,'白银市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6205,62,'天水市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6206,62,'武威市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6207,62,'张掖市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6208,62,'平凉市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6209,62,'酒泉市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6210,62,'庆阳市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6211,62,'定西市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6212,62,'陇南市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6229,62,'临夏回族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6230,62,'甘南藏族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6301,63,'西宁市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6321,63,'海东地区',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6322,63,'海北藏族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6323,63,'黄南藏族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6325,63,'海南藏族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6326,63,'果洛藏族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6327,63,'玉树藏族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6328,63,'海西蒙古族藏族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6401,64,'银川市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6402,64,'石嘴山市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6403,64,'吴忠市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6404,64,'固原市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6405,64,'中卫市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6501,65,'乌鲁木齐市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6502,65,'克拉玛依市',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6521,65,'吐鲁番地区',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6522,65,'哈密地区',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6523,65,'昌吉回族自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6527,65,'博尔塔拉蒙古自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6528,65,'巴音郭楞蒙古自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6529,65,'阿克苏地区',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6530,65,'克孜勒苏柯尔克孜自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6531,65,'喀什地区',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6532,65,'和田地区',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6540,65,'伊犁哈萨克自治州',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6542,65,'塔城地区',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6543,65,'阿勒泰地区',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(6590,65,'自治区直辖县级行政区划',0);


INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(7101,71,'台湾',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(8101,81,'香港',0);
INSERT INTO CITY(PID,FID,NAME,SORT)VALUES(8201,82,'澳门',0);

