create or replace procedure signoutprocedure(logid userdetails.loginid%type)
is
uid userdetails.userid%type;
begin
select userid into uid from userdetails where loginid=logid;
 update loginmaster set logofftime=sysdate where logofftime is null and userid=uid;
end;
/