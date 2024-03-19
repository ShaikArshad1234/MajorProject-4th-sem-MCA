create or replace procedure showprofile
(
 logid userdetails.loginid%type,
 pass out userdetails.PASSWORD%type,
 fname OUT userdetails.FIRSTNAME%type,
 lname OUT  userdetails.LASTNAME%type,
 db OUT varchar2,
  email OUT  userdetails.EMAILID%type,
 fax OUT userdetails.FAXNO%type,
 addresshome OUT addresses.ADDRESSTYPE%type,
 housenohome OUT addresses.HOUSENO%type,
 streethome OUT addresses.STREET%type,
 cityhome OUT addresses.CITY%type,
 statehome OUT addresses.STATE%type,
 countryhome OUT addresses.COUNTRY%type,
 pincodehome OUT addresses.PINCODE%type,
 addressoffice OUT addresses.ADDRESSTYPE%type,
 housenooffice OUT addresses.HOUSENO%type,
 streetoffice OUT addresses.STREET%type,
 cityoffice OUT  addresses.CITY%type,
 stateoffice OUT addresses.STATE%type,
 countryoffice OUT addresses.COUNTRY%type,
 pincodeoffice OUT addresses.PINCODE%type,
 addresspersonal OUT addresses.ADDRESSTYPE%type,
 housenopersonal OUT addresses.HOUSENO%type,
 streetpersonal OUT addresses.STREET%type,
 citypersonal OUT addresses.CITY%type,
 statepersonal OUT addresses.STATE%type,
 countrypersonal OUT addresses.COUNTRY%type,
 pincodepersonal OUT addresses.PINCODE%type,
 phonehome OUT phones.PHONETYPE%type,
 phonenohome OUT phones.PHONENO%type,
 phoneoffice OUT  phones.PHONETYPE%type,
 phonenooffice OUT phones.PHONENO%type,
 phonepersonal OUT phones.PHONETYPE%type,
 phonenopersonal OUT phones.PHONENO%type,
photo OUT  userdetails.PHOTOGRAPH%type
)
AS
 CURSOR addresses_cursor(uid number) is select * from addresses where userid=uid;
 CURSOR phones_cursor(uid number) is select * from phones where userid=uid;
 addresses addresses_cursor%rowtype;
 phones phones_cursor%rowtype;
 customerid userdetails.USERID%TYPE;
 addressid addresses.addressid%type;
BEGIN
 select userid,firstname,lastname,to_char(dob),password, photograph,emailid,faxno into customerid,fname,lname,db,pass,
																photo,email,fax	from userdetails where loginid=logid;
open addresses_cursor(customerid);
FETCH addresses_cursor  into customerid,addressid,addresshome,housenohome,streethome,cityhome,statehome,countryhome,pincodehome;
FETCH addresses_cursor  into customerid,addressid,addressoffice,housenooffice,streetoffice,cityoffice,stateoffice,
		 	  																		countryoffice,pincodeoffice;
 FETCH addresses_cursor into customerid,addressid,addresspersonal,housenopersonal,streetpersonal,citypersonal,statepersonal,
 	   			 	  																	countrypersonal,pincodepersonal;
close addresses_cursor;
open phones_cursor(customerid);
FETCH phones_cursor  into customerid,phonenohome,phonehome;
FETCH phones_cursor into customerid,phonenooffice,phoneoffice;
FETCH phones_cursor into customerid,phonenopersonal,phonepersonal;
close phones_cursor;
end showprofile;
/
