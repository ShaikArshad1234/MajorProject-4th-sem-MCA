create or replace procedure changeprofile
(
    fname userdetails.FIRSTNAME%type,
    lname userdetails.LASTNAME%type,
    logid userdetails.LOGINID%type,
    photo userdetails.photograph%type,
    email userdetails.EMAILID%type,
    fax userdetails.FAXNO%type,
    addresshome addresses.ADDRESSTYPE%type,
    housenohome addresses.HOUSENO%type,
    streethome addresses.STREET%type,
    cityhome addresses.CITY%type,
    statehome addresses.STATE%type,
    countryhome addresses.COUNTRY%type,
    pincodehome addresses.PINCODE%type,
    addressoffice addresses.ADDRESSTYPE%type,
    housenooffice addresses.HOUSENO%type,
    streetoffice addresses.STREET%type,
    cityoffice addresses.CITY%type,
    stateoffice addresses.STATE%type,
    countryoffice addresses.COUNTRY%type,
    pincodeoffice addresses.PINCODE%type,
    addresspersonal addresses.ADDRESSTYPE%type,
    housenopersonal addresses.HOUSENO%type,
    streetpersonal addresses.STREET%type,
    citypersonal  addresses.CITY%type,
    statepersonal addresses.STATE%type,
    countrypersonal addresses.COUNTRY%type,
    pincodepersonal addresses.PINCODE%type,
    phonehome phones.PHONETYPE%type,
    phonenohome phones.PHONENO%type,
    phoneoffice phones.PHONETYPE%type,
    phonenooffice phones.PHONENO%type,
    phonepersonal phones.PHONETYPE%type,
    phonenopersonal phones.PHONENO%type,
    flag out number
)
as
uid userdetails.userid%type;
begin
 
 update userdetails set firstname=fname,lastname=lname,photograph=photo,emailid=email,faxno=fax where loginid=logid;
		

select userid into uid from userdetails where loginid=logid;

update addresses set addresstype=addresshome,houseno=housenohome,street=streethome,city=cityhome,state=statehome,
	   country=countryhome,pincode=pincodehome where userid=uid and addresstype=addresshome;
	   
update addresses set addresstype=addressoffice,houseno=housenooffice,street=streetoffice,city=cityoffice,
	   state=stateoffice,country=countryoffice,pincode=pincodeoffice where userid=uid and addresstype=addressoffice;
	   
update addresses set addresstype=addresspersonal,houseno=housenopersonal,street=streetpersonal,city=citypersonal,
	   state=statepersonal,country=countrypersonal,pincode=pincodepersonal where userid=uid and
	   addresstype=addresspersonal;
	   
update phones set phonetype=phonehome,phoneno=phonenohome where userid=uid and phonetype=phonehome;
update phones set phonetype=phoneoffice,phoneno=phoneoffice where userid=uid and phonetype=phoneoffice;
update phones set phonetype=phonepersonal,phoneno=phonenopersonal where userid=uid and phonetype=phonepersonal;
flag:=1;
end changeprofile;
/
