prompt PL/SQL Developer import file
prompt Created on 2020年11月27日 星期五 by Administrator
set feedback off
set define off
prompt Disabling triggers for STUDENTEXAM...
alter table STUDENTEXAM disable all triggers;
prompt Deleting STUDENTEXAM...
delete from STUDENTEXAM;
commit;
prompt Loading STUDENTEXAM...
insert into STUDENTEXAM (examid, examnumber, estuid, examsubject, examresult)
values (6, 'S1_2007070801', 8, 'SQL', 70);
insert into STUDENTEXAM (examid, examnumber, estuid, examsubject, examresult)
values (7, 'S1_2007070801', 8, 'Java', 78);
insert into STUDENTEXAM (examid, examnumber, estuid, examsubject, examresult)
values (8, 'S1_2007070801', 9, 'SQL', 68);
insert into STUDENTEXAM (examid, examnumber, estuid, examsubject, examresult)
values (9, 'S1_2007070801', 9, 'Java', 85);
insert into STUDENTEXAM (examid, examnumber, estuid, examsubject, examresult)
values (1, 'S1_2007070801', 1, 'SQL', 80);
insert into STUDENTEXAM (examid, examnumber, estuid, examsubject, examresult)
values (2, 'S1_2007070801', 1, 'Java', 56);
insert into STUDENTEXAM (examid, examnumber, estuid, examsubject, examresult)
values (3, 'S1_2007070801', 4, 'SQL', 90);
insert into STUDENTEXAM (examid, examnumber, estuid, examsubject, examresult)
values (4, 'S1_2007070801', 6, 'SQL', 95);
insert into STUDENTEXAM (examid, examnumber, estuid, examsubject, examresult)
values (5, 'S1_2007070801', 6, 'Java', 80);
commit;
prompt 9 records loaded
prompt Enabling triggers for STUDENTEXAM...
alter table STUDENTEXAM enable all triggers;
set feedback on
set define on
prompt Done.
