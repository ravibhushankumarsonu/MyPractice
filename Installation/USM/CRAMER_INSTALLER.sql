create user RAVI identified by RAVI;
grant	
	CREATE SESSION,
	CREATE TYPE,
	CREATE TABLE,
	CREATE TRIGGER,
	CREATE SEQUENCE,
	CREATE INDEXTYPE,
	CREATE PROCEDURE,
	CREATE VIEW,
	AQ_ADMINISTRATOR_ROLE,
	SELECT ANY DICTIONARY
to RAVI with admin option;



GRANT JAVA_ADMIN TO RAVI;
GRANT CREATE USER TO RAVI;

CREATE SYNONYM RAVI V_$SESSION FOR V_$SESSION;
CREATE SYNONYM RAVI V_$PARAMETER FOR V_$PARAMETER;
CREATE SYNONYM RAVI V_$INSTANCE FOR V_$INSTANCE;

GRANT analyze any to RAVI;
GRANT EXECUTE ON DBMS_LOCK TO RAVI;
GRANT EXECUTE ON DBMS_PIPE TO RAVI;
GRANT EXECUTE ON DBMS_RLS TO RAVI;
GRANT EXECUTE ON dbms_job TO RAVI WITH GRANT OPTION;

GRANT EXECUTE ON UTL_FILE TO RAVI;

grant create public synonym to  RAVI;

grant create role to  RAVI;
grant drop ANY role to  RAVI;
GRANT ALTER DATABASE to RAVI;
grant create any directory to  RAVI;

grant execute on xmldom 	to  RAVI;
grant execute on xmlparser 	to  RAVI;
grant create any context to  RAVI;
grant execute any type to  RAVI with admin option;
GRANT EXECUTE ON DBMS_AQADM TO  RAVI WITH GRANT OPTION;
GRANT EXECUTE ON DBMS_AQ TO  RAVI WITH GRANT OPTION;
grant execute on DBMS_CRYPTO to RAVI;
grant execute on DBMS_RESULT_CACHE to RAVI;
