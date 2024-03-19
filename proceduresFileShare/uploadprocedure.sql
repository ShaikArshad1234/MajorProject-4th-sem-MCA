create or replace procedure uploadprocedure
(
 logid userdetails.loginid%type,
 fname fileupload.filename%type,
 fsize fileupload.filesize%type,
 fpermission fileupload.filepermission%type,
 programname filetype.filetypepraogramname%type,
 exetension filetype.filetypeextension%type,
 icon filetype.filetypeiconimage%type
)
is
ftypeid filetype.filetypeid%type;
uid userdetails.userid%type;
begin
 select userid into uid from userdetails where loginid=logid;
 insert into filetype values((select nvl(max(filetypeid),10000)+1 from filetype),programname, exetension,icon);
 select filetypeid into ftypeid from filetype  where filetypepraogramname=programname;
 insert into fileupload values('001','001',uid,'10001', fname,ftypeid,fsize,sysdate,sysdate,'active','private');
end;
/
