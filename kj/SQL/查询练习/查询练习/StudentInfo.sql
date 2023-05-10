prompt PL/SQL Developer import file
prompt Created on 2020��11��27�� ������ by Administrator
set feedback off
set define off
prompt Disabling triggers for STUDENTINFO...
alter table STUDENTINFO disable all triggers;
prompt Deleting STUDENTINFO...
delete from STUDENTINFO;
commit;
prompt Loading STUDENTINFO...
insert into STUDENTINFO (stuid, stunumber, stuname, stuage, stusex, stucard, stujointime, stuaddress, sclassid)
values (8, '005', '�����', 19, '��', '430106198801010001', to_date('02-03-2007', 'dd-mm-yyyy'), '����ɽˮ����', 1);
insert into STUDENTINFO (stuid, stunumber, stuname, stuage, stusex, stucard, stujointime, stuaddress, sclassid)
values (9, '006', '��Ʒ�', 20, '��', '430106198701010002', to_date('08-03-2007', 'dd-mm-yyyy'), '��������������', 2);
insert into STUDENTINFO (stuid, stunumber, stuname, stuage, stusex, stucard, stujointime, stuaddress, sclassid)
values (11, '007', '����', 16, 'Ů', '430120199138380438', to_date('12-03-2007', 'dd-mm-yyyy'), '�����Ѳ����', 5);
insert into STUDENTINFO (stuid, stunumber, stuname, stuage, stusex, stucard, stujointime, stuaddress, sclassid)
values (12, '008', '����', null, '��', '430122198011111111', to_date('14-03-2007', 'dd-mm-yyyy'), '���ϳ�ɳ', 5);
insert into STUDENTINFO (stuid, stunumber, stuname, stuage, stusex, stucard, stujointime, stuaddress, sclassid)
values (1, '001', '����а��', 18, '��', '430105198905022032', to_date('01-03-2007', 'dd-mm-yyyy'), '��ɳ�п�����', 1);
insert into STUDENTINFO (stuid, stunumber, stuname, stuage, stusex, stucard, stujointime, stuaddress, sclassid)
values (2, '002', '��������', 20, '��', '430104198703012011', to_date('10-03-2007', 'dd-mm-yyyy'), '������̶', 2);
insert into STUDENTINFO (stuid, stunumber, stuname, stuage, stusex, stucard, stujointime, stuaddress, sclassid)
values (4, '003', 'С��ɳ�', 19, '��', '420106198812064044', to_date('02-03-2007', 'dd-mm-yyyy'), '�㶫��ɽ', 1);
insert into STUDENTINFO (stuid, stunumber, stuname, stuage, stusex, stucard, stujointime, stuaddress, sclassid)
values (6, '004', 'ӣ��������', 18, 'Ů', '420106198908061085', to_date('06-03-2007', 'dd-mm-yyyy'), '��������ɳ����´��', 2);
commit;
prompt 8 records loaded
prompt Enabling triggers for STUDENTINFO...
alter table STUDENTINFO enable all triggers;
set feedback on
set define on
prompt Done.
