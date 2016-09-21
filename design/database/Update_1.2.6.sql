CREATE TABLE HOUSE_INFO.OLD_HOUSE_SELL
(
	ID VARCHAR(32) NOT NULL,
	MASTER_COMPANY VARCHAR(32) NOT NULL,
	APPLY_TIME DATETIME NOT NULL,
	SHOW_TIME DATETIME,
	END_TIME DATETIME NOT NULL,
	CHECK_BIZ_ID VARCHAR(32) NOT NULL,
	-- 预告
	-- 预抵
	-- 交易
	SELL_BIZ_ID VARCHAR(32) COMMENT '预告
预抵
交易',
	TEL VARCHAR(16),
	POWER_CARD_NUMBER VARCHAR(50) NOT NULL,
	CREDENTIALS_TYPE VARCHAR(32) NOT NULL,
	CREDENTIALS_NUMBER VARCHAR(100) NOT NULL,
	OWNER_NAME VARCHAR(50) NOT NULL,
	PRICE DECIMAL(19,4) NOT NULL,
	HOUSE_SELL_INFO VARCHAR(32) NOT NULL,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.HOUSE_SELL_INFO
(
	ID VARCHAR(32) NOT NULL,
	HOUSE VARCHAR(32) NOT NULL,
	TITLE VARCHAR(64) NOT NULL,
	TAGS VARCHAR(512),
	DESCRIPTION VARCHAR(512),
	ENVIRONMENT VARCHAR(512),
	LAT DECIMAL(18,14),
	LNG DECIMAL(18,14),
	ZOOM INT,
	ROOM_COUNT INT NOT NULL,
	LIVING_ROOM INT NOT NULL,
	LOCAL_AREA VARCHAR(32),
	SCHOOL_AREA VARCHAR(32),
	METRO_AREA VARCHAR(32),
	DIRECTION VARCHAR(32) NOT NULL,
	DECORATE VARCHAR(512) NOT NULL,
	CREATE_YEAR INT NOT NULL,
	ELEVATOR BOOLEAN,
	IMG VARCHAR(32),
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE HOUSE_INFO.SELL_SHOW_IMG
(
	ID VARCHAR(32) NOT NULL,
	TITLE VARCHAR(64) NOT NULL,
	DESCRIPTION VARCHAR(512),
	HOUSE_SELL_INFO VARCHAR(32) NOT NULL,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;

CREATE TABLE HOUSE_INFO.COMPANY_SELL_INFO
(
	COMPANY VARCHAR(32) NOT NULL,
	SELL_INFO VARCHAR(32) NOT NULL,
	PRIMARY KEY (COMPANY, SELL_INFO)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;

ALTER TABLE HOUSE_INFO.COMPANY_SELL_INFO
	ADD FOREIGN KEY (SELL_INFO)
	REFERENCES HOUSE_INFO.OLD_HOUSE_SELL (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

ALTER TABLE HOUSE_INFO.COMPANY_SELL_INFO
	ADD FOREIGN KEY (COMPANY)
	REFERENCES HOUSE_INFO.HOUSE_SELL_COMPANY (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

ALTER TABLE HOUSE_INFO.OLD_HOUSE_SELL
	ADD FOREIGN KEY (MASTER_COMPANY)
	REFERENCES HOUSE_INFO.HOUSE_SELL_COMPANY (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

ALTER TABLE HOUSE_INFO.OLD_HOUSE_SELL
	ADD FOREIGN KEY (HOUSE_SELL_INFO)
	REFERENCES HOUSE_INFO.HOUSE_SELL_INFO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

ALTER TABLE HOUSE_INFO.HOUSE_SELL_INFO
	ADD FOREIGN KEY (HOUSE)
	REFERENCES HOUSE_INFO.HOUSE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

ALTER TABLE HOUSE_INFO.SELL_SHOW_IMG
	ADD FOREIGN KEY (HOUSE_SELL_INFO)
	REFERENCES HOUSE_INFO.HOUSE_SELL_INFO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

ALTER TABLE HOUSE_INFO.HOUSE_SELL_COMPANY ADD TEL VARCHAR(16) NOT NULL;

CREATE TABLE HOUSE_OWNER_RECORD.SALE_SHOW_CHECK
(
	ID VARCHAR(32) NOT NULL,
	PASS BOOLEAN NOT NULL,
	SELL_SHOW_ID VARCHAR(32) NOT NULL,
	MESSAGES VARCHAR(512),
	HOUSE_BUSINESS VARCHAR(32) NOT NULL,
	PRIMARY KEY (ID)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;

ALTER TABLE HOUSE_OWNER_RECORD.SALE_SHOW_CHECK
	ADD FOREIGN KEY (HOUSE_BUSINESS)
REFERENCES HOUSE_OWNER_RECORD.BUSINESS_HOUSE (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;