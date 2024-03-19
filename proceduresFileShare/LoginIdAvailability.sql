create or replace procedure loginidavailablity
(
 loginname userdetails.LOGINID%TYPE,
 logid out userdetails.LOGINID%TYPE
)
is
begin
	 select loginid  into logid from userdetails where loginid=loginname;
end loginidavailablity;
/
