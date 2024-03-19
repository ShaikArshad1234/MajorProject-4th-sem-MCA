CREATE OR REPLACE PACKAGE REF_CURSOR_TEST IS

	TYPE T_ACCOUNTS_CURSOR IS REF CURSOR;
	PROCEDURE GET_ACCOUNTS_PROCEDURE (P_ACCOUNTS OUT T_ACCOUNTS_CURSOR);

END REF_CURSOR_TEST;
/

CREATE OR REPLACE PACKAGE BODY REF_CURSOR_TEST IS

	PROCEDURE GET_ACCOUNTS_PROCEDURE (
			P_ACCOUNTS OUT T_ACCOUNTS_CURSOR
	) AS
	BEGIN
	OPEN P_ACCOUNTS FOR 
			SELECT DISTINCT(UD.LOGINID ),UD.FIRSTNAME,UD.LASTNAME,UD.DOB,UD.DOR,UD.EMAILID FROM USERDETAILS UD,LOGINMASTER LM WHERE UD.USERID=LM.USERID AND logofftime is NULL;
			
	END GET_ACCOUNTS_PROCEDURE;

END REF_CURSOR_TEST;
/