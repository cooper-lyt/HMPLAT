
DELETE FROM SYSTEM_PARAM WHERE ID = 'IdCardImgPath';
DELETE FROM SYSTEM_PARAM WHERE ID = 'businessFilePath';
DELETE FROM SYSTEM_PARAM WHERE ID = 'businessFile.address';
DELETE FROM SYSTEM_PARAM WHERE ID = 'businessFile.port';
DELETE FROM SYSTEM_PARAM WHERE ID = 'businessFile.userName';
DELETE FROM SYSTEM_PARAM WHERE ID = 'businessFile.password';
DELETE FROM SYSTEM_PARAM WHERE ID = 'businessFile.rootDir';
DELETE FROM SYSTEM_PARAM WHERE ID = 'FTP_USER_NAME';
DELETE FROM SYSTEM_PARAM WHERE ID = 'FTP_PASSWORD';
DELETE FROM SYSTEM_PARAM WHERE ID = 'BUSINESS_FILE_CHECK_TYPE';
DELETE FROM SYSTEM_PARAM WHERE ID = 'LOCAL_FILE_UPLOAD_PATH';


INSERT INTO SYSTEM_PARAM(ID,TYPE,VALUE,MEMO) VALUES('IMG_SERVER_ADDRESS','STRING','http://localhost:8090/','图片服务器地址');
INSERT INTO SYSTEM_PARAM(ID,TYPE,VALUE,MEMO) VALUES('FILE_SERVER_ADDRESS','STRING','http://localhost:9333/','文件服务器地址');
