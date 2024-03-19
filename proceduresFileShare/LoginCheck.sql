create or replace procedure logincheck
(
 logid userdetails.LOGINID%type,
 pass userdetails.PASSWORD%type,
 usertype out userdetails.LOGINTYPE%type
 )
as
uid userdetails.userid%type;
begin
  select logintype into usertype from userdetails where loginid=logid and password=pass;
  select userid into uid from userdetails where loginid=logid;
  insert into  loginmaster (userid,logindate,logintime) values(uid,sysdate,sysdate);
end logincheck;
/
