create or replace procedure changepassword
(
 lid userdetails.LOGINID%type,
 currentpw userdetails.PASSWORD%type,
 newpw userdetails.PASSWORD%type,
 flag out number
 )
is 
begin
	 update userdetails set password=newpw where loginid=lid and password=currentpw;
	 flag:=1;
end;
/
