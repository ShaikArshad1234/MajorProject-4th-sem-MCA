CREATE OR REPLACE procedure getphoto(photo out varchar)
 as
 begin
 select utl_raw.cast_to_varchar2(photograph) into photo from userdetails where loginid='uu';
 end;
/