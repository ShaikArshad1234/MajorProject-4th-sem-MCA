create or replace procedure RecoverPassword
(
 logid userdetails.LOGINID%type,
 securityquestion userdetails.FORGOTPWQUESTION%type,
 answer userdetails.FORGOTPWANSWER%type,
 pw out userdetails.PASSWORD%type
)
is
begin
	 select password into pw from userdetails where loginid=logid and forgotpwquestion=securityquestion and 
 				 	  	 	  			  					  	  							forgotpwanswer=answer;
end;
/
