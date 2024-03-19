create or replace procedure insertprocedure
(
    photo BLOB,
    fname userdetails.FIRSTNAME%type,
    lname userdetails.LASTNAME%type,
    db userdetails.DOB%type,
    logid userdetails.LOGINID%type,
    pass userdetails.PASSWORD%Type,
    secretquestion userdetails.FORGOTPWQUESTION%type,
    secretanswer userdetails.FORGOTPWANSWER%type,
   
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
    phonenumberhome phones.PHONENO%type,
    phoneoffice phones.PHONETYPE%type,
    phonenumberoffice phones.PHONENO%type,
    phonepersonal phones.PHONETYPE%type,
    phonenumberpersonal phones.PHONENO%type
    
)
as
begin
 
 insert into userdetails values((select nvl(max(userid),10000)+1 from userdetails),fname,lname,db,sysdate,logid,
             pass,'user',secretquestion,secretanswer,photo,email,fax);
 insert into addresses values((select max(userid) from userdetails) ,(select nvl(max(addressid),10000)+1 from addresses),
               addresshome,housenohome,streethome,cityhome,statehome,countryhome,pincodehome);
 if addressoffice is not null then
   insert into addresses values((select max(userid) from userdetails),(select max(addressid)+1 from addresses),
           addressoffice,housenooffice,streetoffice,cityoffice,stateoffice,countryoffice,pincodeoffice);
 end if;
 if addresspersonal is not null then
   insert into addresses values((select max(userid) from userdetails),(select max(addressid)+1 from addresses),
      addresspersonal,housenopersonal,streetpersonal,citypersonal,statepersonal,countrypersonal,pincodepersonal);
 end if;
 insert into phones values((select max(userid) from userdetails),phonenumberhome,phonehome);
 if phoneoffice is not null then
   insert into phones values((select max(userid) from userdetails),phonenumberoffice,phoneoffice);
 end if;
 if phonepersonal is not null then
   insert into phones values((select max(userid) from userdetails),phonenumberpersonal,phonepersonal);
 end if;

insert into personalfolder values
(
   (select nvl(max(folderid),0)+1 from personalfolder),
   (select max(userid) from userdetails),
   'Data',
   null,
   '1',
   '0',
   sysdate,
   'active'
   );
   insert into personalfolder values
(
   (select nvl(max(folderid),0)+1 from personalfolder),
   (select max(userid) from userdetails),
   'Video',
   null,
   '1',
   '0',
   sysdate,
   'active'
   );
   insert into personalfolder values
(
   (select nvl(max(folderid),0)+1 from personalfolder),
   (select max(userid) from userdetails),
   'Audio',
   null,
   '1',
   '0',
   sysdate,
   'active'
   );


end insertprocedure;
/
