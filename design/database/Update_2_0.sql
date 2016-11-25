DROP TABLE IF EXISTS HOUSE_OWNER_RECORD.SALE_SHOW_CHECK;

CREATE TABLE HOUSE_OWNER_RECORD.POWER_OWNER
(
  ID VARCHAR(32) NOT NULL,
  NAME VARCHAR(50) NOT NULL,
  ID_TYPE VARCHAR(32) NOT NULL,
  ID_NO VARCHAR(100) NOT NULL,
  RELATION VARCHAR(32),
  POOL_AREA DECIMAL(19,4),
  PERC DECIMAL(19,4),
  PHONE VARCHAR(15),
  LEGAL_PERSON VARCHAR(50),
  LEGAL_TYPE VARCHAR(20),
  ROOT_ADDRESS VARCHAR(50),
  ADDRESS VARCHAR(200),
  BIRTHDAY DATE,
  SEX VARCHAR(10),
  -- OWNER:共有人/产权人
  -- CONTRACT:备案人
  -- PREPARE:预告人
  -- INIT:初始登记人
  --
  --
  TYPE VARCHAR(16) NOT NULL,
  PRI INT NOT NULL,
  CARD VARCHAR(32),
  OLD BOOLEAN NOT NULL,
  OLD_MEMO VARCHAR(32),
  PROXY_PERSON VARCHAR(32),
  PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;

CREATE TABLE HOUSE_OWNER_RECORD.HOUSE_OWNER
(
  HOUSE VARCHAR(32) NOT NULL,
  POOL VARCHAR(32) NOT NULL,
  PRIMARY KEY (HOUSE, POOL)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;

CREATE TABLE HOUSE_OWNER_RECORD.HOUSE_MORTGAEGE
(
  MORTGAEGE VARCHAR(32) NOT NULL,
  HOUSE VARCHAR(32) NOT NULL,
  PRIMARY KEY (MORTGAEGE, HOUSE)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;

CREATE TABLE HOUSE_OWNER_RECORD.CONTRACT_SUBMIT
(
  ID VARCHAR(32) NOT NULL,
  ATTACH_EMP_ID VARCHAR(32) NOT NULL,
  ATTACH_EMP_NAME VARCHAR(50) NOT NULL,
  CONTRACT LONGTEXT NOT NULL,
  CONTRACT_VERSION INT NOT NULL,
  PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;

USE HOUSE_OWNER_RECORD;

INSERT INTO HOUSE_OWNER_RECORD.POWER_OWNER(ID,NAME,ID_TYPE,ID_NO,RELATION,POOL_AREA,OLD_MEMO,PHONE,LEGAL_PERSON,LEGAL_TYPE,TYPE,PRI,CARD,OLD)
  SELECT bp.ID,bp.NAME,bp.ID_TYPE,bp.ID_NO,bp.RELATION,bp.POOL_AREA,bp.PERC,bp.PHONE,bp.LEGAL_PERSON,'LEGAL_OWNER',if(ob.DEFINE_ID='WP42' or ob.DEFINE_ID='WP43','CONTRACT','OWNER') as type ,11,bp.CARD,false FROM BUSINESS_POOL bp LEFT JOIN HOUSE_POOL hp on hp.POOL=bp.ID LEFT JOIN HOUSE h on h.ID = hp.HOUSE LEFT JOIN BUSINESS_HOUSE bh on bh.AFTER_HOUSE = h.ID LEFT JOIN OWNER_BUSINESS ob on ob.ID = bh.BUSINESS_ID;

INSERT INTO HOUSE_OWNER(HOUSE,POOL) SELECT HOUSE,POOL FROM HOUSE_POOL;


INSERT INTO HOUSE_OWNER_RECORD.POWER_OWNER(ID,NAME,ID_TYPE,ID_NO,PHONE,LEGAL_PERSON,LEGAL_TYPE,ROOT_ADDRESS,ADDRESS,TYPE,PRI,CARD,OLD)
  SELECT bo.ID,bo.NAME,bo.ID_TYPE,bo.ID_NO,bo.PHONE,bo.LEGAL_PERSON,'LEGAL_OWNER',bo.ADDRESS,bo.ROOT_ADDRESS,'OWNER',0,bo.OWNER_CARD,false FROM HOUSE_OWNER_RECORD.BUSINESS_HOUSE bh LEFT JOIN HOUSE h on h.ID = bh.AFTER_HOUSE LEFT JOIN BUSINESS_OWNER bo on bo.ID = h.MAIN_OWNER where not h.MAIN_OWNER is null;

INSERT INTO HOUSE_OWNER(HOUSE,POOL)
  SELECT h.ID,bo.ID FROM HOUSE_OWNER_RECORD.BUSINESS_HOUSE bh LEFT JOIN HOUSE h on h.ID = bh.AFTER_HOUSE LEFT JOIN BUSINESS_OWNER bo on bo.ID = h.MAIN_OWNER where not h.MAIN_OWNER is null;



INSERT INTO HOUSE_OWNER_RECORD.POWER_OWNER(ID,NAME,ID_TYPE,ID_NO,PHONE,LEGAL_PERSON,LEGAL_TYPE,ROOT_ADDRESS,ADDRESS,TYPE,PRI,CARD,OLD)
  SELECT bo.ID,bo.NAME,bo.ID_TYPE,bo.ID_NO,bo.PHONE,bo.LEGAL_PERSON,'LEGAL_OWNER',bo.ADDRESS,bo.ROOT_ADDRESS,'INIT',0,bo.OWNER_CARD,false FROM HOUSE_OWNER_RECORD.BUSINESS_HOUSE bh LEFT JOIN HOUSE h on h.ID = bh.AFTER_HOUSE LEFT JOIN BUSINESS_OWNER bo on bo.ID = h.OLD_OWNER where not h.OLD_OWNER is null;

INSERT INTO HOUSE_OWNER(HOUSE,POOL)
  SELECT h.ID,bo.ID FROM HOUSE_OWNER_RECORD.BUSINESS_HOUSE bh LEFT JOIN HOUSE h on h.ID = bh.AFTER_HOUSE LEFT JOIN BUSINESS_OWNER bo on bo.ID = h.OLD_OWNER where not h.OLD_OWNER is null;



INSERT INTO HOUSE_OWNER_RECORD.POWER_OWNER(ID,NAME,ID_TYPE,ID_NO,PHONE,LEGAL_PERSON,LEGAL_TYPE,ROOT_ADDRESS,ADDRESS,TYPE,PRI,CARD,OLD)
  SELECT bo.ID,bo.NAME,bo.ID_TYPE,bo.ID_NO,bo.PHONE,bo.LEGAL_PERSON,'LEGAL_OWNER',bo.ADDRESS,bo.ROOT_ADDRESS,'PREPARE',0,bo.OWNER_CARD,false FROM HOUSE_OWNER_RECORD.BUSINESS_HOUSE bh LEFT JOIN HOUSE h on h.ID = bh.AFTER_HOUSE LEFT JOIN BUSINESS_OWNER bo on bo.ID = h.NOITCE_OWNER where not h.NOITCE_OWNER is null;

INSERT INTO HOUSE_OWNER(HOUSE,POOL)
  SELECT h.ID,bo.ID FROM HOUSE_OWNER_RECORD.BUSINESS_HOUSE bh LEFT JOIN HOUSE h on h.ID = bh.AFTER_HOUSE LEFT JOIN BUSINESS_OWNER bo on bo.ID = h.NOITCE_OWNER where not h.NOITCE_OWNER is null;



INSERT INTO HOUSE_OWNER_RECORD.POWER_OWNER(ID,NAME,ID_TYPE,ID_NO,PHONE,LEGAL_PERSON,LEGAL_TYPE,ROOT_ADDRESS,ADDRESS,TYPE,PRI,OLD)
  SELECT co.ID,co.NAME,co.ID_TYPE,co.ID_NO,co.PHONE,co.LEGAL_PERSON,'LEGAL_OWNER',co.ROOT_ADDRESS,co.ADDRESS,'CONTRACT',0,FALSE FROM CONTRACT_OWNER co LEFT JOIN HOUSE h on h.CONTRACT_OWNER = co.ID where not h.ID is null;

INSERT INTO HOUSE_OWNER(HOUSE,POOL)
  SELECT h.ID,co.ID FROM CONTRACT_OWNER co LEFT JOIN HOUSE h on h.CONTRACT_OWNER = co.ID where not h.ID is null;


INSERT INTO HOUSE_MORTGAEGE(MORTGAEGE, HOUSE)
select mr.ID,h.ID from MORTGAEGE_REGISTE mr left join BUSINESS_OWNER bo on bo.ID = mr.OWNER left join HOUSE h on h.MAIN_OWNER = bo.ID where not (h.ID is null);

INSERT INTO HOUSE_MORTGAEGE(MORTGAEGE, HOUSE)
  select mr.ID,h.ID from MORTGAEGE_REGISTE mr left join BUSINESS_OWNER bo on bo.ID = mr.OWNER left join HOUSE h on h.NOITCE_OWNER = bo.ID where not (h.ID is null);

INSERT INTO HOUSE_MORTGAEGE(MORTGAEGE, HOUSE)
  select mr.ID,h.ID from MORTGAEGE_REGISTE mr left join BUSINESS_OWNER bo on bo.ID = mr.OWNER left join HOUSE h on h.OLD_OWNER = bo.ID where not (h.ID is null);

ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_CONTRACT ADD CONTRACT_NUMBER VARCHAR(50) NOT NULL;
ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_CONTRACT ADD CONTRACT_DATE DATETIME NOT NULL;
ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_CONTRACT ADD TYPE VARCHAR(32) NOT NULL;
ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_CONTRACT ADD PROJECT_RSHIP_NUMBER VARCHAR(50) NULL;
ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_CONTRACT ADD BUSINESS VARCHAR(32) NOT NULL;


UPDATE HOUSE_CONTRACT as hc LEFT JOIN  CONTRACT_OWNER co on co.ID = hc.ID set hc.CONTRACT_NUMBER = co.CONTRACT_NUMBER, hc.CONTRACT_DATE = co.CONTRACT_DATE, hc.TYPE = co.TYPE, hc.PROJECT_RSHIP_NUMBER = co.PROJECT_RSHIP_NUMBER,hc.BUSINESS = co.BUSINESS;
INSERT INTO HOUSE_OWNER_RECORD.CONTRACT_SUBMIT (ID,ATTACH_EMP_ID,ATTACH_EMP_NAME,CONTRACT,CONTRACT_VERSION) SELECT ID,ATTACH_EMP_ID,ATTACH_EMP_NAME,CONTRACT,CONTRACT_VERSION FROM HOUSE_OWNER_RECORD.HOUSE_CONTRACT;

ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_CONTRACT DROP ATTACH_EMP_ID;
ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_CONTRACT DROP ATTACH_EMP_NAME;
ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_CONTRACT DROP CONTRACT;
ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_CONTRACT DROP CONTRACT_VERSION;

INSERT HOUSE_CONTRACT(ID,CONTRACT_NUMBER,CONTRACT_DATE,TYPE,PROJECT_RSHIP_NUMBER,BUSINESS) select co.ID,co.CONTRACT_NUMBER,co.CONTRACT_DATE,co.TYPE,co.PROJECT_RSHIP_NUMBER,co.BUSINESS from CONTRACT_OWNER co where not (co.ID in (select ID FROM HOUSE_CONTRACT));


DROP TABLE HOUSE_OWNER_RECORD.HOUSE_POOL;
DROP TABLE HOUSE_OWNER_RECORD.BUSINESS_POOL;

ALTER TABLE HOUSE_OWNER_RECORD.HOUSE DROP FOREIGN KEY HOUSE_ibfk_4;
ALTER TABLE HOUSE_OWNER_RECORD.HOUSE DROP FOREIGN KEY HOUSE_ibfk_1;
ALTER TABLE HOUSE_OWNER_RECORD.HOUSE DROP FOREIGN KEY HOUSE_ibfk_3;
ALTER TABLE HOUSE_OWNER_RECORD.HOUSE DROP FOREIGN KEY HOUSE_ibfk_2;

DROP INDEX CONTRACT_OWNER ON HOUSE_OWNER_RECORD.HOUSE;
ALTER TABLE HOUSE_OWNER_RECORD.HOUSE DROP CONTRACT_OWNER;

DROP INDEX OLD_OWNER ON HOUSE_OWNER_RECORD.HOUSE;
ALTER TABLE HOUSE_OWNER_RECORD.HOUSE DROP OLD_OWNER;

DROP INDEX NOITCE_OWNER ON HOUSE_OWNER_RECORD.HOUSE;
ALTER TABLE HOUSE_OWNER_RECORD.HOUSE DROP NOITCE_OWNER;


DROP INDEX MAIN_OWNER ON HOUSE_OWNER_RECORD.HOUSE;

ALTER TABLE HOUSE_OWNER_RECORD.MORTGAEGE_REGISTE DROP FOREIGN KEY MORTGAEGE_REGISTE_ibfk_1;
DROP INDEX OWNER ON HOUSE_OWNER_RECORD.MORTGAEGE_REGISTE;
ALTER TABLE HOUSE_OWNER_RECORD.MORTGAEGE_REGISTE DROP OWNER;

DROP TABLE HOUSE_OWNER_RECORD.BUSINESS_OWNER;

ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_CONTRACT DROP FOREIGN KEY HOUSE_CONTRACT_ibfk_1;

DROP TABLE HOUSE_OWNER_RECORD.CONTRACT_OWNER;

ALTER TABLE HOUSE_OWNER_RECORD.CONTRACT_NUMBER DROP FOREIGN KEY CONTRACT_NUMBER_ibfk_1;

ALTER TABLE HOUSE_OWNER_RECORD.CONTRACT_NUMBER
  ADD FOREIGN KEY (CONTRACT)
REFERENCES HOUSE_OWNER_RECORD.CONTRACT_SUBMIT (ID)
  ON UPDATE RESTRICT
  ON DELETE RESTRICT
;

ALTER TABLE HOUSE_OWNER_RECORD.CONTRACT_SUBMIT
  ADD FOREIGN KEY (ID)
REFERENCES HOUSE_OWNER_RECORD.HOUSE_CONTRACT (ID)
  ON UPDATE RESTRICT
  ON DELETE RESTRICT
;

ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_OWNER
  ADD FOREIGN KEY (HOUSE)
REFERENCES HOUSE_OWNER_RECORD.HOUSE (ID)
  ON UPDATE RESTRICT
  ON DELETE RESTRICT
;

ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_OWNER
  ADD FOREIGN KEY (POOL)
REFERENCES HOUSE_OWNER_RECORD.POWER_OWNER (ID)
  ON UPDATE RESTRICT
  ON DELETE RESTRICT
;

ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_MORTGAEGE
  ADD FOREIGN KEY (HOUSE)
REFERENCES HOUSE_OWNER_RECORD.HOUSE (ID)
  ON UPDATE RESTRICT
  ON DELETE RESTRICT
;

ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_MORTGAEGE
  ADD FOREIGN KEY (MORTGAEGE)
REFERENCES HOUSE_OWNER_RECORD.MORTGAEGE_REGISTE (ID)
  ON UPDATE RESTRICT
  ON DELETE RESTRICT
;

ALTER TABLE HOUSE_OWNER_RECORD.POWER_OWNER
  ADD FOREIGN KEY (CARD)
REFERENCES HOUSE_OWNER_RECORD.MAKE_CARD (ID)
  ON UPDATE RESTRICT
  ON DELETE RESTRICT
;

ALTER TABLE HOUSE_OWNER_RECORD.HOUSE
  ADD FOREIGN KEY (MAIN_OWNER)
REFERENCES HOUSE_OWNER_RECORD.POWER_OWNER (ID)
  ON UPDATE RESTRICT
  ON DELETE RESTRICT
;

ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_CONTRACT
  ADD FOREIGN KEY (BUSINESS)
REFERENCES HOUSE_OWNER_RECORD.BUSINESS_HOUSE (ID)
  ON UPDATE RESTRICT
  ON DELETE RESTRICT
;


CREATE TABLE HOUSE_OWNER_RECORD.SALE_SHOW_CHECK
(
  PASS BOOLEAN NOT NULL,
  SELL_SHOW_ID VARCHAR(32) NOT NULL,
  MESSAGES VARCHAR(512),
  BUSINESS VARCHAR(32) NOT NULL,
  ID VARCHAR(32) NOT NULL,
  PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


ALTER TABLE HOUSE_OWNER_RECORD.SALE_SHOW_CHECK
  ADD FOREIGN KEY (BUSINESS)
REFERENCES HOUSE_OWNER_RECORD.BUSINESS_HOUSE (ID)
  ON UPDATE RESTRICT
  ON DELETE RESTRICT
;

ALTER TABLE HOUSE_OWNER_RECORD.BUSINESS_HOUSE ADD SEARCH_KEY VARCHAR(1024) NULL;
ALTER TABLE HOUSE_OWNER_RECORD.BUSINESS_HOUSE ADD DISPLAY VARCHAR(1024) NULL;


ALTER TABLE HOUSE_OWNER_RECORD.OWNER_BUSINESS ADD SEARCH_KEY VARCHAR(1024) NULL;
ALTER TABLE HOUSE_OWNER_RECORD.OWNER_BUSINESS ADD DISPLAY VARCHAR(1024) NULL;

ALTER TABLE HOUSE_OWNER_RECORD.HOUSE ADD DESIGN_USE_TYPE VARCHAR(512) NOT NULL;
ALTER TABLE HOUSE_INFO.HOUSE ADD DESIGN_USE_TYPE VARCHAR(512) NOT NULL;
ALTER TABLE HOUSE_INFO.GRID_BLOCK ADD DESIGN_USE_TYPE VARCHAR(512);
-- 处理设计用途为空
--


--
UPDATE HOUSE_OWNER_RECORD.HOUSE h left join DB_PLAT_SYSTEM.WORD w on w.ID = h.USE_TYPE set h.DESIGN_USE_TYPE = w._VALUE WHERE not w._VALUE is null;
UPDATE HOUSE_OWNER_RECORD.HOUSE h left join DB_PLAT_SYSTEM.WORD w on w.ID = h.USE_TYPE set h.USE_TYPE = w._KEY WHERE not w._KEY is null;

UPDATE HOUSE_OWNER_RECORD.LAND_END_TIME h left join DB_PLAT_SYSTEM.WORD w on w.ID = h.USE_TYPE set h.USE_TYPE = w._KEY WHERE not w._KEY is null;


UPDATE HOUSE_INFO.HOUSE h left join DB_PLAT_SYSTEM.WORD w on w.ID = h.USE_TYPE set h.DESIGN_USE_TYPE = w._VALUE WHERE not w._VALUE is null;;
UPDATE HOUSE_INFO.HOUSE h left join DB_PLAT_SYSTEM.WORD w on w.ID = h.USE_TYPE set h.USE_TYPE = w._KEY WHERE not w._KEY is null;

UPDATE HOUSE_INFO.GRID_BLOCK h left join DB_PLAT_SYSTEM.WORD w on w.ID = h.USE_TYPE set h.DESIGN_USE_TYPE = w._VALUE WHERE not w._VALUE is null;;
UPDATE HOUSE_INFO.GRID_BLOCK h left join DB_PLAT_SYSTEM.WORD w on w.ID = h.USE_TYPE set h.USE_TYPE = w._KEY WHERE not w._KEY is null;


use HOUSE_OWNER_RECORD;

UPDATE HOUSE h set USE_TYPE = 'OTHER' WHERE USE_TYPE <> '1' and USE_TYPE <> '2' and h.USE_TYPE <> '3' and h.USE_TYPE <> '4';
UPDATE HOUSE h set USE_TYPE = 'DWELLING_KEY' WHERE USE_TYPE='1';
UPDATE HOUSE h set USE_TYPE = 'SHOP_HOUSE_KEY' WHERE USE_TYPE='2';
UPDATE HOUSE h set USE_TYPE = 'STORE_HOUSE' WHERE USE_TYPE='4';
UPDATE HOUSE h set USE_TYPE = 'OFFICE' WHERE USE_TYPE='3';

UPDATE LAND_END_TIME h set USE_TYPE = 'OTHER' WHERE USE_TYPE <> '1' and USE_TYPE <> '2' and h.USE_TYPE <> '3' and h.USE_TYPE <> '4';
UPDATE LAND_END_TIME h set USE_TYPE = 'DWELLING_KEY' WHERE USE_TYPE='1';
UPDATE LAND_END_TIME h set USE_TYPE = 'SHOP_HOUSE_KEY' WHERE USE_TYPE='2';
UPDATE LAND_END_TIME h set USE_TYPE = 'STORE_HOUSE' WHERE USE_TYPE='4';
UPDATE LAND_END_TIME h set USE_TYPE = 'OFFICE' WHERE USE_TYPE='3';

use HOUSE_INFO;

UPDATE HOUSE h set USE_TYPE = 'OTHER' WHERE USE_TYPE <> '1' and USE_TYPE <> '2' and h.USE_TYPE <> '3' and h.USE_TYPE <> '4';
UPDATE HOUSE h set USE_TYPE = 'DWELLING_KEY' WHERE USE_TYPE='1';
UPDATE HOUSE h set USE_TYPE = 'SHOP_HOUSE_KEY' WHERE USE_TYPE='2';
UPDATE HOUSE h set USE_TYPE = 'STORE_HOUSE' WHERE USE_TYPE='4';
UPDATE HOUSE h set USE_TYPE = 'OFFICE' WHERE USE_TYPE='3';

UPDATE GRID_BLOCK h set USE_TYPE = 'OTHER' WHERE USE_TYPE <> '1' and USE_TYPE <> '2' and h.USE_TYPE <> '3' and h.USE_TYPE <> '4';
UPDATE GRID_BLOCK h set USE_TYPE = 'DWELLING_KEY' WHERE USE_TYPE='1';
UPDATE GRID_BLOCK h set USE_TYPE = 'SHOP_HOUSE_KEY' WHERE USE_TYPE='2';
UPDATE GRID_BLOCK h set USE_TYPE = 'STORE_HOUSE' WHERE USE_TYPE='4';
UPDATE GRID_BLOCK h set USE_TYPE = 'OFFICE' WHERE USE_TYPE='3';



CREATE TABLE HOUSE_OWNER_RECORD.PROXY_PERSON
(
  ID VARCHAR(32) NOT NULL,
  TYPE VARCHAR(16) NOT NULL,
  NAME VARCHAR(50) NOT NULL,
  ID_TYPE VARCHAR(32) NOT NULL,
  ID_NO VARCHAR(100) NOT NULL,
  PHONE VARCHAR(15) NOT NULL,
  PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


ALTER TABLE HOUSE_OWNER_RECORD.BUSINESS_PERSION ADD PROXY_PERSON VARCHAR(32) NULL;

ALTER TABLE HOUSE_OWNER_RECORD.FINANCIAL ADD PROXY_PERSON VARCHAR(32) NULL;


ALTER TABLE HOUSE_OWNER_RECORD.BUSINESS_PERSION
  ADD CONSTRAINT BUSINESS_PERSON_IBFK FOREIGN KEY (PROXY_PERSON)
REFERENCES HOUSE_OWNER_RECORD.PROXY_PERSON (ID)
  ON UPDATE RESTRICT
  ON DELETE RESTRICT
;

ALTER TABLE HOUSE_OWNER_RECORD.FINANCIAL
  ADD CONSTRAINT FINANCIAL_PROXY_IBFK FOREIGN KEY (PROXY_PERSON)
REFERENCES HOUSE_OWNER_RECORD.PROXY_PERSON (ID)
  ON UPDATE RESTRICT
  ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.POWER_OWNER
  ADD FOREIGN KEY (PROXY_PERSON)
REFERENCES HOUSE_OWNER_RECORD.PROXY_PERSON (ID)
  ON UPDATE RESTRICT
  ON DELETE RESTRICT
;


ALTER TABLE HOUSE_OWNER_RECORD.HOUSE ADD UNIT_NUMBER VARCHAR(32) NULL;

ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_RECORD ADD SEARCH_KEY VARCHAR(1024) NULL;
ALTER TABLE HOUSE_OWNER_RECORD.HOUSE_RECORD ADD DISPLAY VARCHAR(1024) NULL;


ALTER TABLE HOUSE_OWNER_RECORD.PROJECT_MORTGAGE ADD DEVELOPER_CODE VARCHAR(32) NOT NULL;
ALTER TABLE HOUSE_OWNER_RECORD.PROJECT_MORTGAGE ADD DEVELOPER_NAME VARCHAR(100) NOT NULL;

ALTER TABLE HOUSE_OWNER_RECORD.PROJECT_MORTGAGE DROP FOREIGN KEY PROJECT_MORTGAGE_ibfk_1;

UPDATE HOUSE_OWNER_RECORD.PROJECT_MORTGAGE pm left join HOUSE_OWNER_RECORD.MORTGAEGE_REGISTE mr on mr.BUSINESS_ID = pm.BUSINESS  set pm.ID= mr.ID;

DROP INDEX BUSINESS ON HOUSE_OWNER_RECORD.PROJECT_MORTGAGE;
ALTER TABLE HOUSE_OWNER_RECORD.PROJECT_MORTGAGE DROP BUSINESS;

ALTER TABLE HOUSE_OWNER_RECORD.PROJECT_MORTGAGE
  ADD FOREIGN KEY (ID)
REFERENCES HOUSE_OWNER_RECORD.MORTGAEGE_REGISTE (ID)
  ON UPDATE RESTRICT
  ON DELETE RESTRICT
;


-- 以下根据地区修改
UPDATE HOUSE_OWNER_RECORD.HOUSE set HOUSE_TYPE = 'SALE_HOUSE' where HOUSE_TYPE = '205' or HOUSE_TYPE is null;
UPDATE HOUSE_OWNER_RECORD.HOUSE set HOUSE_TYPE = 'BACK_HOUSE' where HOUSE_TYPE = '1946';
UPDATE HOUSE_OWNER_RECORD.HOUSE set HOUSE_TYPE = 'WELFARE_HOUSE' where HOUSE_TYPE = '206';
UPDATE HOUSE_OWNER_RECORD.HOUSE set HOUSE_TYPE = 'OTHER' where HOUSE_TYPE = '2773' or HOUSE_TYPE = '784';
UPDATE HOUSE_OWNER_RECORD.HOUSE set HOUSE_TYPE = 'GOV_SALE_HOUSE' where HOUSE_TYPE = '781';
UPDATE HOUSE_OWNER_RECORD.HOUSE set HOUSE_TYPE = 'GOV_RENT' where HOUSE_TYPE = '782';
UPDATE HOUSE_OWNER_RECORD.HOUSE set HOUSE_TYPE = 'GROUP_HOUSE' where HOUSE_TYPE = '783';

UPDATE HOUSE_INFO.HOUSE set HOUSE_TYPE = 'SALE_HOUSE' where HOUSE_TYPE = '205' or HOUSE_TYPE is null;
UPDATE HOUSE_INFO.HOUSE set HOUSE_TYPE = 'BACK_HOUSE' where HOUSE_TYPE = '1946';
UPDATE HOUSE_INFO.HOUSE set HOUSE_TYPE = 'WELFARE_HOUSE' where HOUSE_TYPE = '206';
UPDATE HOUSE_INFO.HOUSE set HOUSE_TYPE = 'OTHER' where HOUSE_TYPE = '2773' or HOUSE_TYPE = '784';
UPDATE HOUSE_INFO.HOUSE set HOUSE_TYPE = 'GOV_SALE_HOUSE' where HOUSE_TYPE = '781';
UPDATE HOUSE_INFO.HOUSE set HOUSE_TYPE = 'GOV_RENT' where HOUSE_TYPE = '782';
UPDATE HOUSE_INFO.HOUSE set HOUSE_TYPE = 'GROUP_HOUSE' where HOUSE_TYPE = '783';

UPDATE HOUSE_INFO.GRID_BLOCK set HOUSE_TYPE = 'SALE_HOUSE' where HOUSE_TYPE = '205' or HOUSE_TYPE is null;
UPDATE HOUSE_INFO.GRID_BLOCK set HOUSE_TYPE = 'BACK_HOUSE' where HOUSE_TYPE = '1946';
UPDATE HOUSE_INFO.GRID_BLOCK set HOUSE_TYPE = 'WELFARE_HOUSE' where HOUSE_TYPE = '206';
UPDATE HOUSE_INFO.GRID_BLOCK set HOUSE_TYPE = 'OTHER' where HOUSE_TYPE = '2773' or HOUSE_TYPE = '784';
UPDATE HOUSE_INFO.GRID_BLOCK set HOUSE_TYPE = 'GOV_SALE_HOUSE' where HOUSE_TYPE = '781';
UPDATE HOUSE_INFO.GRID_BLOCK set HOUSE_TYPE = 'GOV_RENT' where HOUSE_TYPE = '782';
UPDATE HOUSE_INFO.GRID_BLOCK set HOUSE_TYPE = 'GROUP_HOUSE' where HOUSE_TYPE = '783';

INSERT DB_PLAT_SYSTEM.SYSTEM_PARAM(ID,TYPE, VALUE, MEMO) VALUES ('OWNER_SHARE_CALC_TYPE','INTEGER','1','按份共有分配方式: 1.按份额, 2.按面积, 3.手动');


UPDATE DB_PLAT_SYSTEM.SYSTEM_PARAM set VALUE='2.0' where ID='database_version';



