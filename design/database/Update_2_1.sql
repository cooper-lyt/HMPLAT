ALTER TABLE HOUSE_OWNER_RECORD.OWNER_BUSINESS ADD IN_ROOM BOOLEAN  NULL;


ALTER TABLE HOUSE_OWNER_RECORD.RECORD_STORE ADD CABINET BOOLEAN  NULL;
ALTER TABLE HOUSE_OWNER_RECORD.RECORD_STORE ADD FRAME BOOLEAN  NULL;
ALTER TABLE HOUSE_OWNER_RECORD.RECORD_STORE ADD BOX BOOLEAN  NULL;
ALTER TABLE HOUSE_OWNER_RECORD.RECORD_STORE ADD ROOM BOOLEAN NULL;




ALTER TABLE HOUSE_OWNER_RECORD.UPLOAD_FILE ADD PRI INT NULL;

UPDATE HOUSE_OWNER_RECORD.UPLOAD_FILE set PRI = 1;

UPDATE DB_PLAT_SYSTEM.SYSTEM_PARAM set VALUE='2.1.0' where ID='database_version';

UPDATE DB_PLAT_SYSTEM.TASK_SUBSCRIBE SET REG_NAME='GenSearchKeyForNewOwner' WHERE REG_NAME='HouseBusinessMortgageKeyGen';
