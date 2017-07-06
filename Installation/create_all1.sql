@/ossusers1/oss/users/testusm1/dba/create_installer_user.sql CRAMER_INSTALLER CRAMER_INSTALLER
@/ossusers1/oss/users/testusm1/dba/create_schema_owner.sql CRAMER CRAMER USERS TEMP;
@/ossusers1/oss/users/testusm1/dba/create_common_user.sql CRAMER_COMMAN CRAMER_COMMAN USERS TEMP CRAMER;
@/ossusers1/oss/users/testusm1/dba/create_shared_user.sql CRAMER_SHARED USERS TEMP;
@/ossusers1/oss/users/testusm1/dba/create_cramersso_user.sql CRAMERSSO CRAMERSSO USERS TEMP;
@/ossusers1/oss/users/testusm1/dba/create-ar-schema.sql REPORTS REPORTS USERS TEMP;
@/ossusers1/oss/users/testusm1/dba/create_asm_user.sql UAMS UAMS USERS TEMP;
@/ossusers1/oss/users/testusm1/dba/create_directory_user.sql CRAMERDIRECTORY CRAMERDIRECTORY USERS TEMP;
@/ossusers1/oss/users/testusm1/dba/create_sf_user.sql sfuser sfuser USERS TEMP;
@/ossusers1/oss/users/testusm1/dba/grant_MM_privileges_schema_owner.sql CRAMER;
grant drop any table to CRAMER;
@/ossusers1/oss/users/testusm1/dba/hf-8830.sql CRAMER_INSTALLER CRAMER;
alter user CRAMER quota unlimited on USM_MEF_SVCS_DATA;
alter user CRAMER quota unlimited on USM_MEF_SVCS_INDEX;
commit;
exit;
