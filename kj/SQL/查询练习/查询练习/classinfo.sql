prompt PL/SQL Developer import file
prompt Created on 2020年11月27日 星期五 by Administrator
set feedback off
set define off
prompt Disabling triggers for CLASSINFO...
alter table CLASSINFO disable all triggers;
prompt Deleting CLASSINFO...
delete from CLASSINFO;
commit;
prompt Loading CLASSINFO...
insert into CLASSINFO (classid, classnumber, cteacherid, classgrade)
values (5, '070315', 4, 'S2');
insert into CLASSINFO (classid, classnumber, cteacherid, classgrade)
values (1, '07034', 1, 'S1');
insert into CLASSINFO (classid, classnumber, cteacherid, classgrade)
values (2, '07038', 2, 'S1');
commit;
prompt 3 records loaded
prompt Enabling triggers for CLASSINFO...
alter table CLASSINFO enable all triggers;
set feedback on
set define on
prompt Done.
