prompt PL/SQL Developer import file
prompt Created on 2020年11月27日 星期五 by Administrator
set feedback off
set define off
prompt Disabling triggers for STUDENTINFO...
alter table STUDENTINFO disable all triggers;
prompt Deleting STUDENTINFO...
delete from STUDENTINFO;
commit;
prompt Loading STUDENTINFO...
insert into STUDENTINFO (stuid, stunumber, stuname, stuage, stusex, stucard, stujointime, stuaddress, sclassid)
values (8, '005', '孙悟空', 19, '男', '430106198801010001', to_date('02-03-2007', 'dd-mm-yyyy'), '花果山水帘洞', 1);
insert into STUDENTINFO (stuid, stunumber, stuname, stuage, stusex, stucard, stujointime, stuaddress, sclassid)
values (9, '006', '大黄蜂', 20, '男', '430106198701010002', to_date('08-03-2007', 'dd-mm-yyyy'), '湖南汽车大世界', 2);
insert into STUDENTINFO (stuid, stunumber, stuname, stuage, stusex, stucard, stujointime, stuaddress, sclassid)
values (11, '007', '貂蝉', 16, '女', '430120199138380438', to_date('12-03-2007', 'dd-mm-yyyy'), '马王堆博物馆', 5);
insert into STUDENTINFO (stuid, stunumber, stuname, stuage, stusex, stucard, stujointime, stuaddress, sclassid)
values (12, '008', '关羽', null, '男', '430122198011111111', to_date('14-03-2007', 'dd-mm-yyyy'), '湖南长沙', 5);
insert into STUDENTINFO (stuid, stunumber, stuname, stuage, stusex, stucard, stujointime, stuaddress, sclassid)
values (1, '001', '火云邪神', 18, '男', '430105198905022032', to_date('01-03-2007', 'dd-mm-yyyy'), '长沙市开福区', 1);
insert into STUDENTINFO (stuid, stunumber, stuname, stuage, stusex, stucard, stujointime, stuaddress, sclassid)
values (2, '002', '东方不败', 20, '男', '430104198703012011', to_date('10-03-2007', 'dd-mm-yyyy'), '湖南湘潭', 2);
insert into STUDENTINFO (stuid, stunumber, stuname, stuage, stusex, stucard, stujointime, stuaddress, sclassid)
values (4, '003', '小李飞车', 19, '男', '420106198812064044', to_date('02-03-2007', 'dd-mm-yyyy'), '广东佛山', 1);
insert into STUDENTINFO (stuid, stunumber, stuname, stuage, stusex, stucard, stujointime, stuaddress, sclassid)
values (6, '004', '樱桃肉丸子', 18, '女', '420106198908061085', to_date('06-03-2007', 'dd-mm-yyyy'), '开福区长沙市岳麓区', 2);
commit;
prompt 8 records loaded
prompt Enabling triggers for STUDENTINFO...
alter table STUDENTINFO enable all triggers;
set feedback on
set define on
prompt Done.
