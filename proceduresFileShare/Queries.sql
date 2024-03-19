create table userdetails
(
	 userid NUMBER CONSTRAINT userid_pk PRIMARY KEY,
	 firstname VARCHAR2(20),
	 lastname VARCHAR2(20),
   	 dob DATE,
   	 dor DATE,
   	 loginid VARCHAR2(50) UNIQUE NOT NULL,
   	 password VARCHAR2(30),
   	 logintype VARCHAR2(20),
   	 forgotpwquestion VARCHAR2(70),
   	 forgotpwanswer VARCHAR2(70),
   	 photograph BLOB NOT NULL,
   	 emailId VARCHAR2(50),
   	 faxno VARCHAR2(20)
);

create table addresses
(
 	userid NUMBER CONSTRAINT userid_fk REFERENCES userdetails(userid) ON DELETE CASCADE,
 	addressid NUMBER,
	addresstype VARCHAR2(10),
	houseno VARCHAR2(30),
 	street VARCHAR2(30),
 	city VARCHAR2(30),
 	state VARCHAR2(30),
 	country VARCHAR2(30),
 	pincode VARCHAR2(10),
 			CONSTRAINT uid_adid_adtyp_ckpk PRIMARY KEY(userid,addressid,addresstype)
);

create table phones
(
	userid NUMBER CONSTRAINT phones_userid_fk REFERENCES userdetails(userid)ON DELETE CASCADE,
	phoneno VARCHAR2(13),
	phonetype VARCHAR2(20),
			  CONSTRAINT phones_phno_phtyp PRIMARY KEY(userid,phoneno,phonetype)
);

create table loginmaster
(
	userid NUMBER CONSTRAINT loginmaster_userid_fk REFERENCES userdetails(userid) ON DELETE CASCADE,
	logindate DATE,
	logintime DATE,
	logofftime DATE,
			   CONSTRAINT lm_uid_ldate_ltime_pk PRIMARY KEY(userid,loginDATE,logintime)
);

create table loginactivity
(
  	userid NUMBER CONSTRAINT loginactivity_userid_fk REFERENCES userdetails(userid)ON DELETE CASCADE,
	loginactivity VARCHAR2(20) CONSTRAINT lactivity_loginactivity_chk CHECK(loginactivity in('upload','download')),
  	loginactivitycount NUMBER,
  	loginactivitystartedtime DATE,
 	loginactivityendtime DATE
 );

create table personalfolder
(
 	folderid NUMBER CONSTRAINT personalfolder_folderid_pk PRIMARY KEY,
 	userid NUMBER CONSTRAINT personalfolder_userid_fk REFERENCES userdetails(userid) ON DELETE CASCADE,
 	foldername VARCHAR2(30),
 	folderappliedpath VARCHAR2(50),
 	folderappliedstoragecapacity VARCHAR2(20),
 	currentstoratecapacityused VARCHAR2(20),
 	foldercreationDATE DATE,
 	folderactivestate VARCHAR2(10) CONSTRAINT personalfolder_fas_chk CHECK(folderactivestate in('active','deactive'))
);

create table subfolder
(
  	folderid NUMBER CONSTRAINT subfolder_folderid_fk REFERENCES personalfolder(folderid)ON DELETE CASCADE,
        userid NUMBER CONSTRAINT subfolder_userid_fk REFERENCES userdetails(userid)ON DELETE CASCADE,
  	subfolderid NUMBER UNIQUE NOT NULL,
	subfoldername VARCHAR2(30),
	subfoldercreatedDATE DATE,
	subfolderstatus VARCHAR2(10) CONSTRAINT subfolder_subfolderstatus_chk CHECK(subfolderstatus in('active','deactive')),
	CONSTRAINT subfolderid_fldiduidsfld_ckpk PRIMARY KEY(folderid,userid,subfolderid)
);



create table filetype
(
	filetypeid NUMBER CONSTRAINT filetype_filetypd_pk PRIMARY KEY,
	filetypepraogramname VARCHAR2(30),
	filetypeextension VARCHAR2(20),
	filetypeiconimage blob
);

create table fileupload
(
	folderid NUMBER CONSTRAINT fileupload_folderid_fk REFERENCES personalfolder(folderid)ON DELETE CASCADE,
	subfolderid NUMBER CONSTRAINT fileupload_subfolderid_fk REFERENCES subfolder(subfolderid) ON DELETE CASCADE,
	userid NUMBER CONSTRAINT fileupload_userid_fk REFERENCES userdetails(userid)ON DELETE CASCADE,
	fileid NUMBER UNIQUE NOT NULL,
	filename VARCHAR2(20),
	content Blob,
	contentclob clob ,
	filetypeid NUMBER CONSTRAINT fiileupload_tyid_fk REFERENCES filetype(filetypeid)ON DELETE CASCADE,
	filesize VARCHAR2(20),
	fileuploadDATE DATE,
	fileuploadtime DATE,
	filestatus VARCHAR2(10) CONSTRAINT fileupload_filestatus_chk CHECK(filestatus in('active','deactive')),
	filepermission VARCHAR2(15) CONSTRAINT fileupload_filepermsn_chk CHECK(filepermission in
				   						   							 			('private','public','partialpublic'))
);

create table filedownload
(
 	userid NUMBER CONSTRAINT filednload_userid_fk REFERENCES userdetails(userid)ON DELETE CASCADE,
 	downloadid NUMBER CONSTRAINT filednload_dnloadid_pk PRIMARY KEY,
 	downloaddate DATE,
 	downloadtime DATE,
 	fileidfordownload NUMBER CONSTRAINT fldnld_flfordnld_fk REFERENCES fileupload(fileid)ON DELETE CASCADE,
 	IPaddress VARCHAR2(30),
 	downloadstatusbit NUMBER CONSTRAINT fldnload_dnldstatus_chk CHECK(downloadstatusbit in('0','1')),
 	downloadedfolderid NUMBER CONSTRAINT filednload_dnldfldid_fk REFERENCES personalfolder(folderid) ON DELETE CASCADE,
 	downloadedsubfolderid NUMBER CONSTRAINT filednload_dnldsfldid_fk REFERENCES subfolder(subfolderid) ON DELETE CASCADE
);

create table partialpublicfilestatus
(
 	fileownerid NUMBER CONSTRAINT parpubflsts_flownid_fk REFERENCES userdetails(userid)ON DELETE CASCADE,
 	fileid NUMBER CONSTRAINT parpub_flid_fk REFERENCES fileupload(fileid)ON DELETE CASCADE,
 	receiveruserid NUMBER CONSTRAINT parpub_recuid_fk REFERENCES userdetails(userid)ON DELETE CASCADE,
 	downloadablestatusbit NUMBER CONSTRAINT parpub_dnlodstsbt_chk CHECK(downloadablestatusbit in('0','1')),
 	filesharedDATEtime DATE,
 	filedownloadedDATEtime DATE,
	filedownloadedstatusbit NUMBER(1) CONSTRAINT parpubflsts_fldnloddsbt_chk CHECK(filedownloadedstatusbit in('0','1')),
  	CONSTRAINT parpubflsts_compk PRIMARY KEY(fileownerid,fileid,receiveruserid)
);
