CREATE TABLE HOUSE_OWNER_RECORD.LAND_END_TIME
(
	PROJECT_ID VARCHAR(32) NOT NULL,
	ID VARCHAR(32) NOT NULL,
	END_TIME DATETIME NOT NULL,
	USE_TYPE VARCHAR(20) NOT NULL,
	PRIMARY KEY (ID),
	CONSTRAINT LAND_TIME_PROJECT_USE_TYPE UNIQUE (PROJECT_ID, USE_TYPE)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


ALTER TABLE HOUSE_OWNER_RECORD.LAND_END_TIME
	ADD FOREIGN KEY (PROJECT_ID)
	REFERENCES HOUSE_OWNER_RECORD.PROJECT_SELL_INFO (ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;
