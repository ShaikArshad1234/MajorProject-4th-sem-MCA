create or replace procedure folderprocedure(logid varchar2,fname varchar2,fpath varchar2)
is
uid varchar2(20);
begin

	select userid into uid from userdetails where loginid=logid;
	insert into personalfolder values((select nvl(max(userid),10000)+1 from personalfolder),uid,fname,fpath,512,0,sysdate,'active');
end;
/