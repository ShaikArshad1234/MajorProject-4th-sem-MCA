 create or replace procedure ChangeQuetion
 (
  logid userdetails.LOGINID%type,
  pass userdetails.PASSWORD%type,
  question userdetails.FORGOTPWQUESTION%type,
  answer userdetails.FORGOTPWANSWER%type,
  flag out number
 )
 as
 begin
  update  userdetails set forgotpwquestion=question,forgotpwanswer=answer where loginid=logid and password=pass;
  flag:=1;
 end;
/
