prompt PL/SQL Developer import file
prompt Created on 2020��11��27�� ������ by Administrator
set feedback off
set define off
prompt Disabling triggers for TEACHERINFO...
alter table TEACHERINFO disable all triggers;
prompt Deleting TEACHERINFO...
delete from TEACHERINFO;
commit;
prompt Loading TEACHERINFO...
insert into TEACHERINFO (teacherid, teachername, teachertel, teacheremail)
values (4, '����', '13507458168', 'lb@sina.com');
insert into TEACHERINFO (teacherid, teachername, teachertel, teacheremail)
values (1, '������', '13907311119', 'tsz@yahoo.com');
insert into TEACHERINFO (teacherid, teachername, teachertel, teacheremail)
values (2, '������', '13907315200', 'qtz@yahoo.com');
commit;
prompt 3 records loaded
prompt Enabling triggers for TEACHERINFO...
alter table TEACHERINFO enable all triggers;
set feedback on
set define on
prompt Done.
