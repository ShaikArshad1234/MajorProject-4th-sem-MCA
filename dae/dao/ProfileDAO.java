/*
 * ProfileDAO.java
 *
 * 
 * 
 */

package com.dts.dae.dao;
import oracle.jdbc.driver.*;
import com.dts.dae.model.Profile;
import com.dts.core.dao.AbstractDataAccessObject; 
import com.dts.core.util.CoreHash;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.Date;
import java.util.Properties;


/**
 *
 * @author 
 */
public class ProfileDAO extends AbstractDataAccessObject{
    
    public Connection con;

    private boolean flag;
    /** Creates a new instance of ProfileDAO */
    public ProfileDAO() 
    {
           //getting Database Connection
           
    }
    
       
    //User Registration
    public boolean registration(Profile regbean)
    {
    	
        String loginid=regbean.getLoginID();
        String password=regbean.getPassword();
        String firstname=regbean.getFirstName();
        String lastname=regbean.getLastName();
        String logintype=regbean.getLoginType();
        String regdate=regbean.getRegDate();
        String secretquest=regbean.getSecretQuestionID();
        String ownsecretquest=regbean.getOwnSecretQuestion();
        String secretans=regbean.getSecretAnswer();
        String bdate=DateWrapper.parseDate(regbean.getBirthDate());
       //home
        String hno=regbean.getHno();
        String home=regbean.getHome();
        String street=regbean.getStreet();
        String city=regbean.getCity();
        String state=regbean.getState();
        String country=regbean.getCountry();
        String pin=regbean.getPin();
        String Phonetype=regbean.getHomePhoneType();
        String phone=regbean.getPhone();
        //office
        String ohno=regbean.getOhno();
        String office=regbean.getOffice();
        String ostreet=regbean.getOstreet();
        String ocity=regbean.getOcity();
        String ostate=regbean.getOstate();
        String ocountry=regbean.getOcountry();
        String opin=regbean.getOpin();
        String oPhonetype=regbean.getOfficePhoneType();
        String ophone=regbean.getOphone();
        //personal
        String phno=regbean.getChno();
        String contact=regbean.getContact();
        String pstreet=regbean.getCstreet();
        String pcity=regbean.getCcity();
        String pstate=regbean.getCstate();
        String pcountry=regbean.getCcountry();
        String ppin=regbean.getCpin();
        String pPhonetype=regbean.getPersonalPhoneType();
        String pphone=regbean.getCphone();
       System.out.println("homephoto= "+phone+" office= "+ophone+" personal = "+pphone);
        String fax=regbean.getFax();
        String email=regbean.getEmail();
        String photo=regbean.getPhoto();
        String newdate=DateWrapper.parseDate(new Date());
        try 
        {
        	System.out.println("photo="+photo);
        	File f=new File(photo);
        	FileInputStream fis=new FileInputStream(f); 
        	System.out.println("fole="+f.length());
           
            
        	con=getConnection();
          // con.setAutoCommit(false);
           CallableStatement cstmt=con.prepareCall("{call insertprocedure(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
          /*
   1 photo BLOB,
   2 fname userdetails.FIRSTNAME%type,
   3 lname userdetails.LASTNAME%type,
   4 db userdetails.DOB%type,
   5 logid userdetails.LOGINID%type,
   6 pass userdetails.PASSWORD%Type,
   7 secretquestion userdetails.FORGOTPWQUESTION%type,
   8 secretanswer userdetails.FORGOTPWANSWER%type,
   
   9 email userdetails.EMAILID%type,
   10 fax userdetails.FAXNO%type,
  */
           cstmt.setBinaryStream(1, fis,(int)f.length());
           cstmt.setString(2,firstname);
           cstmt.setString(3,lastname);
           cstmt.setString(4,bdate);
           
           cstmt.setString(5,loginid);
           cstmt.setString(6,password);
          
           cstmt.setString(7,secretquest);
           cstmt.setString(8,secretans);
           
           cstmt.setString(9,email);
           cstmt.setString(10,fax);
         /*
           //home
           11 addresshome addresses.ADDRESSTYPE%type,
           12 housenohome addresses.HOUSENO%type,
           13 streethome addresses.STREET%type,
           14 cityhome addresses.CITY%type,
           15 statehome addresses.STATE%type,
           16 countryhome addresses.COUNTRY%type,
           17 pincodehome addresses.PINCODE%type,
           
           
           */       
           cstmt.setString(11,home);
           cstmt.setString(12,hno);
           cstmt.setString(13,street);
           cstmt.setString(14,city);
           cstmt.setString(15,state);
           cstmt.setString(16,country);
           cstmt.setString(17,pin);
          /*
            //office
   18 addressoffice addresses.ADDRESSTYPE%type,
   19 housenooffice addresses.HOUSENO%type,
   20 streetoffice addresses.STREET%type,
   21 cityoffice addresses.CITY%type,
   22 stateoffice addresses.STATE%type,
   23 countryoffice addresses.COUNTRY%type,
   24 pincodeoffice addresses.PINCODE%type,
   
            */
  cstmt.setString(18,office);
           cstmt.setString(19,ohno);
           cstmt.setString(20,ostreet);
           cstmt.setString(21,ocity);
           cstmt.setString(22,ostate);
           cstmt.setString(23,ocountry);
           cstmt.setString(24,opin);
        /* //personal
           25 addresspersonal addresses.ADDRESSTYPE%type,
           26 housenopersonal addresses.HOUSENO%type,
           27 streetpersonal addresses.STREET%type,
           28 citypersonal  addresses.CITY%type,
           29 statepersonal addresses.STATE%type,
           30 countrypersonal addresses.COUNTRY%type,
           31 pincodepersonal addresses.PINCODE%type,
          */       
           cstmt.setString(25,contact);
           cstmt.setString(26,phno);
           cstmt.setString(27,pstreet);
           cstmt.setString(28,pcity);
           cstmt.setString(29,pstate);
           cstmt.setString(30,pcountry);
           cstmt.setString(31,ppin);
          /*
           32 phonehome phones.PHONETYPE%type,
           33 phonenumberhome phones.PHONENO%type,
           34 phoneoffice phones.PHONETYPE%type,
           35 phonenumberoffice phones.PHONENO%type,
           36 phonepersonal phones.PHONETYPE%type,
           37 phonenumberpersonal phones.PHONENO%type
            */
           cstmt.setString(32,Phonetype);
           cstmt.setString(33,phone);
           cstmt.setString(34,oPhonetype);
           cstmt.setString(35,ophone);
           cstmt.setString(36,pPhonetype);
           cstmt.setString(37,pphone);     
        
             int i= cstmt.executeUpdate();
             if(i==1)
             {
              flag=true;
             }
             else
             {
            	 flag=false;
            	 
             }
             con.close();
        } 
        catch(SQLException e)
    	{
    	System.out.println(e.toString());
    	if(e.toString().equalsIgnoreCase("java.sql.SQLException: [Microsoft][ODBC driver for Oracle][Oracle]ORA-12571: TNS:packet writer failure"))
    		{
    		flag=true;
    		System.out.println("n==="+flag);
    		}
    System.out.println(e);

    	}
        catch (Exception e) 
        {
            e.printStackTrace();
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException se) 
            {
                se.printStackTrace();
            }
        }
        return flag;
    }
    
    //Getting profile
    public Profile getProfile(String loginname,String path)
    {
        Profile rb=new Profile();
        try
        {
        	con=getConnection();
        	CallableStatement cs=con.prepareCall("{call showprofile(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		    
		    /*
		1 logid userdetails.loginid%type,
		2 pass out userdetails.PASSWORD%type,
		3 fname OUT userdetails.FIRSTNAME%type,
		4 lname OUT  userdetails.LASTNAME%type,
		5 db OUT varchar2,
		 
		6 email OUT  userdetails.EMAILID%type,
		7 fax OUT userdetails.FAXNO%type,
		8 addresshome OUT addresses.ADDRESSTYPE%type,
		9 housenohome OUT addresses.HOUSENO%type,
		10 streethome OUT addresses.STREET%type,
		11 cityhome OUT addresses.CITY%type,
		12 statehome OUT addresses.STATE%type,
		13 countryhome OUT addresses.COUNTRY%type,
		14 pincodehome OUT addresses.PINCODE%type,
		15 addressoffice OUT addresses.ADDRESSTYPE%type,
		16 housenooffice OUT addresses.HOUSENO%type,
		17 streetoffice OUT addresses.STREET%type,
		18 cityoffice OUT  addresses.CITY%type,
		19 stateoffice OUT addresses.STATE%type,
		20 countryoffice OUT addresses.COUNTRY%type,
		21 pincodeoffice OUT addresses.PINCODE%type,
		22 addresspersonal OUT addresses.ADDRESSTYPE%type,
		23 housenopersonal OUT addresses.HOUSENO%type,
		24 streetpersonal OUT addresses.STREET%type,
		25 citypersonal OUT addresses.CITY%type,
		26 statepersonal OUT addresses.STATE%type,
		27 countrypersonal OUT addresses.COUNTRY%type,
		28 pincodepersonal OUT addresses.PINCODE%type,
		29 phonehome OUT phones.PHONETYPE%type,
		30 phonenohome OUT phones.PHONENO%type,
		31 phoneoffice OUT  phones.PHONETYPE%type,
		32 phonenooffice OUT phones.PHONENO%type,
		33 phonepersonal OUT phones.PHONETYPE%type,
		34 phonenopersonal OUT phones.PHONENO%type,
		35 photo OUT  userdetails.PHOTOGRAPH%type 
		     */
		    		
		    
		    cs.setString(1,loginname);
			cs.registerOutParameter(2,Types.VARCHAR);
			cs.registerOutParameter(3,Types.VARCHAR);
			cs.registerOutParameter(4,Types.VARCHAR);
			cs.registerOutParameter(5,Types.VARCHAR);
			cs.registerOutParameter(6,Types.VARCHAR);
			cs.registerOutParameter(7,Types.VARCHAR);
			cs.registerOutParameter(8,Types.VARCHAR);
			cs.registerOutParameter(9,Types.VARCHAR);
			cs.registerOutParameter(10,Types.VARCHAR);
			cs.registerOutParameter(11,Types.VARCHAR);
			cs.registerOutParameter(12,Types.VARCHAR);
			cs.registerOutParameter(13,Types.VARCHAR);
			cs.registerOutParameter(14,Types.VARCHAR);
			cs.registerOutParameter(15,Types.VARCHAR);
			cs.registerOutParameter(16,Types.VARCHAR);
			cs.registerOutParameter(17,Types.VARCHAR);
			cs.registerOutParameter(18,Types.VARCHAR);
			cs.registerOutParameter(19,Types.VARCHAR);
			cs.registerOutParameter(20,Types.VARCHAR);
			cs.registerOutParameter(21,Types.VARCHAR);
			cs.registerOutParameter(22,Types.VARCHAR);
			cs.registerOutParameter(23,Types.VARCHAR);
			cs.registerOutParameter(24,Types.VARCHAR);
			cs.registerOutParameter(25,Types.VARCHAR);
			cs.registerOutParameter(26,Types.VARCHAR);
			cs.registerOutParameter(27,Types.VARCHAR);
			cs.registerOutParameter(28,Types.VARCHAR);
			cs.registerOutParameter(29,Types.VARCHAR);
			cs.registerOutParameter(30,Types.VARCHAR);
			cs.registerOutParameter(31,Types.VARCHAR);
			cs.registerOutParameter(32,Types.VARCHAR);
			cs.registerOutParameter(33,Types.VARCHAR);
			cs.registerOutParameter(34,Types.VARCHAR);
			cs.registerOutParameter(35,Types.BLOB);
			cs.execute();
			rb.setPassword(cs.getString(2));
			rb.setFirstname(cs.getString(3));
			rb.setLastname(cs.getString(4));
			
			rb.setBdate(cs.getString(5));
			//rb.setPhoto(cs.getString());
			rb.setEmail(cs.getString(6));
			rb.setFax(cs.getString(7));
			rb.setHome(cs.getString(8));
			rb.setHno(cs.getString(9));
			rb.setStreet(cs.getString(10));
			rb.setCity(cs.getString(11));
			rb.setState(cs.getString(12));
			//rb.setPin(cs.getString(13));
			rb.setCountry(cs.getString(13));
			rb.setPin(cs.getString(14));
			rb.setOffice(cs.getString(15));
			rb.setOhno(cs.getString(16));
			rb.setOstreet(cs.getString(17));
			rb.setOcity(cs.getString(18));
			
			rb.setOstate(cs.getString(19));
		/*
		 20 countryoffice OUT addresses.COUNTRY%type,
		21 pincodeoffice OUT addresses.PINCODE%type,
		22 addresspersonal OUT addresses.ADDRESSTYPE%type,
		23 housenopersonal OUT addresses.HOUSENO%type,
		24 streetpersonal OUT addresses.STREET%type,
		25 citypersonal OUT addresses.CITY%type,
		26 statepersonal OUT addresses.STATE%type,
		27 countrypersonal OUT addresses.COUNTRY%type,
		28 pincodepersonal OUT addresses.PINCODE%type,
		
		 
		     */
			rb.setOcountry(cs.getString(20));
			rb.setOpin(cs.getString(21));
			rb.setContact(cs.getString(22));
			rb.setChno(cs.getString(23));
			rb.setCstreet(cs.getString(24));
			rb.setCcity(cs.getString(25));
			rb.setCstate(cs.getString(26));
			//rb.setCpin(cs.getString(27));
			rb.setCcountry(cs.getString(27));
			rb.setCpin(cs.getString(28));
			/*
			 	29 phonehome OUT phones.PHONETYPE%type,
				30 phonenohome OUT phones.PHONENO%type,
				31 phoneoffice OUT  phones.PHONETYPE%type,
				32 phonenooffice OUT phones.PHONENO%type,
				33 phonepersonal OUT phones.PHONETYPE%type,
				34 phonenopersonal OUT phones.PHONENO%type, 
				35 photo OUT  userdetails.PHOTOGRAPH%type
					 */
			rb.setHomePhoneType(cs.getString(29));
			rb.setPhone(cs.getString(30));
			rb.setOfficePhoneType(cs.getString(31));
			String o=cs.getString(32);
			rb.setOphone(o);
			rb.setPersonalPhoneType(cs.getString(33));
		String s=cs.getString(34);
		rb.setCphone(s);
		System.out.println("personal phone="+s+"  officeph= "+o);
		 /*FileOutputStream fs = null;
         InputStream is = null;
         fs = new FileOutputStream("photo.jpg");
        
         is = cs.getBlob(35).getBinaryStream();
         byte[] buf = new byte[16384];
         int bytes;
         while ((bytes = is.read(buf)) != -1) {
             fs.write(buf, 0, bytes);
			
         }*/
		Blob b =cs.getBlob(35);
		byte b1[]=b.getBytes(1,(int)b.length());
		OutputStream fout=new FileOutputStream(path+"/"+loginname+".gif");
		fout.write(b1);

	}
	
        catch(Exception e)
        {e.printStackTrace();
        	LoggerManager.writeLogSevere(e);
        }
        finally
        {
        	try{
        		con.close();
        	}catch(Exception e)
        	{
        		LoggerManager.writeLogSevere(e);
            }
        	
        }
        return rb;
    }     // Modify Profile
    public boolean modifyProfile(Profile regbean)
    {
    	String loginid=regbean.getLoginID();
        String firstname=regbean.getFirstName();
        String lastname=regbean.getLastName();
       // String bdate=DateWrapper.parseDate(regbean.getBirthDate());
       //home
        String hno=regbean.getHno();
        String home=regbean.getHome();
        String street=regbean.getStreet();
        String city=regbean.getCity();
        String state=regbean.getState();
        String country=regbean.getCountry();
        String pin=regbean.getPin();
        String Phonetype=regbean.getHomePhoneType();
        String phone=regbean.getPhone();
        //office
        String ohno=regbean.getOhno();
        String office=regbean.getOffice();
        String ostreet=regbean.getOstreet();
        String ocity=regbean.getOcity();
        String ostate=regbean.getOstate();
        String ocountry=regbean.getOcountry();
        String opin=regbean.getOpin();
        String oPhonetype=regbean.getOfficePhoneType();
        String ophone=regbean.getOphone();
        //personal
        String phno=regbean.getChno();
        String contact=regbean.getContact();
        String pstreet=regbean.getCstreet();
        String pcity=regbean.getCcity();
        String pstate=regbean.getCstate();
        String pcountry=regbean.getCcountry();
        String ppin=regbean.getCpin();
        String pPhonetype=regbean.getPersonalPhoneType();
        String pphone=regbean.getCphone();
       
        String fax=regbean.getFax();
        String email=regbean.getEmail();
        String photo=regbean.getPhoto();
        String newdate=DateWrapper.parseDate(new Date());
        try 
        {
        	System.out.println("photo="+photo);
        	File f=new File(photo);
        	FileInputStream fis=new FileInputStream(f); 
        	System.out.println("fole="+f.length());
           
        	con=getConnection();
          // con.setAutoCommit(false);
        	CallableStatement cs=con.prepareCall("{call changeprofile(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
    
        	/*
    
		   1 fname userdetails.FIRSTNAME%type,
		   2 lname userdetails.LASTNAME%type,
		   3 logid userdetails.LOGINID%type,
		   4 photo userdetails.photograph%type,
		   5 email userdetails.EMAILID%type,
		   6 fax userdetails.FAXNO%type,
		    
        	 */
        	cs.setString(1,firstname);
    		cs.setString(2,lastname);
    		cs.setString(3,loginid);
    		cs.setBinaryStream(4, fis,(int)f.length());
    		// cs.setBinaryStream(4, fis,999);
    		cs.setString(5,email);
    		cs.setString(6,fax);
    
    		/*
    	    7 addresshome addresses.ADDRESSTYPE%type,
		    8 housenohome addresses.HOUSENO%type,
		    9 streethome addresses.STREET%type,
		    10 cityhome addresses.CITY%type,
		    11 statehome addresses.STATE%type,
		    12 countryhome addresses.COUNTRY%type,
		    13 pincodehome addresses.PINCODE%type,
		     
    		 */
    		
    		cs.setString(7,home);
    		cs.setString(8,hno);
    		cs.setString(9,street);
    		cs.setString(10,city);
    		cs.setString(11,state);
    		cs.setString(12,country);
    		cs.setString(13,pin);
    		
    
    		/*
    		 14  addressoffice addresses.ADDRESSTYPE%type,
			 15  housenooffice addresses.HOUSENO%type,
			 16  streetoffice addresses.STREET%type,
			 17  cityoffice addresses.CITY%type,
			 18  stateoffice addresses.STATE%type,
			 19  countryoffice addresses.COUNTRY%type,
			 20 pincodeoffice addresses.PINCODE%type,
			    
    		 */
    		cs.setString(14,office);
    		
    		cs.setString(15,ohno);
    		cs.setString(16,ostreet);
    		cs.setString(17,ocity);
    		cs.setString(18,ostate);
    		cs.setString(19,ocountry);
    		cs.setString(20,opin);
    		
    		/*
    
    		21 addresspersonal addresses.ADDRESSTYPE%type,
		    22 housenopersonal addresses.HOUSENO%type,
		    23 streetpersonal addresses.STREET%type,
		    24 citypersonal  addresses.CITY%type,
		    25 statepersonal addresses.STATE%type,
		    26 countrypersonal addresses.COUNTRY%type,
		    27 pincodepersonal addresses.PINCODE%type,
		    
    		 */
    		cs.setString(21,contact);
    		cs.setString(22,phno);
    		cs.setString(23,pstreet);
    		cs.setString(24,pcity);
    		cs.setString(25,pstate);
    		cs.setString(26,pcountry);
    		cs.setString(27,ppin);
    
    		/*
    	    28 phonehome phones.PHONETYPE%type,
    	    29 phonenohome phones.PHONENO%type,
    	    30 phoneoffice phones.PHONETYPE%type,
    	    31 phonenooffice phones.PHONENO%type,
    	    32 phonepersonal phones.PHONETYPE%type,
    	    33 phonenopersonal phones.PHONENO%type,
    	    34 flag out number
    	          
    	    */ 
    	    
    		cs.setString(28,Phonetype);
    		cs.setString(29,phone);
    		cs.setString(30,oPhonetype);
    		cs.setString(31,ophone);
    		cs.setString(32,pPhonetype);
    		cs.setString(33,pphone);
    		cs.registerOutParameter(34,Types.INTEGER);
    			cs.execute();
    		int n=cs.getInt(34);
    		if(n>0)
    		{
    			flag=true;
    	}
           
            else
            {
                flag=false;
            con.rollback();
            }
            con.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException sex) 
            {
                sex.printStackTrace();
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException se) 
            {
                se.printStackTrace();
            }
        }
        return flag;
    }
   //getreport of login fromdate todate
    public CoreHash getReportFromTo(String sdate,String edate)
	{
		System.out.println("sdate"+sdate+" edate="+edate);
		Properties p=getProperties();
		String pattern="";
		if(p.getProperty("dbname").equals("access"))
			pattern="#";
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println(" aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		Profile aProfile=null;
		try {
			 con = getConnection();
			   
            	 st=con.createStatement();
            	 ResultSet rs=st.executeQuery("SELECT DISTINCT(UD.LOGINID ),UD.FIRSTNAME,UD.LASTNAME,UD.DOB,UD.DOR,UD.EMAILID FROM USERDETAILS UD,LOGINMASTER LM WHERE UD.USERID=LM.USERID AND LOGINDATE>='"+sdate+"' AND LOGINDATE<='"+edate+"'");
            	 while(rs.next())
                 {
              	   aProfile=new Profile();
              	  
              	   aProfile.setLoginID(rs.getString(1));
              	   aProfile.setFirstname(rs.getString(2));  
              	   aProfile.setLastName(rs.getString(3));
              	   String date=DateWrapper.parseDate(rs.getDate(4)).trim();
                	aProfile.setBirthDate(date);
                   aProfile.setRegDate(DateWrapper.parseDate(rs.getDate(5)).trim());
                   aProfile.setEmail(rs.getString(6));
                   /*Blob b =rs.getBlob(7);
          			byte b1[]=b.getBytes(1,(int)b.length());
          			OutputStream fout=new FileOutputStream("F:/Public/WorkSpace/projects2008-09/FileShare/WebRoot/userimages/"+rs.getString(1)+".gif");
       			fout.write(b1);
               	   */
              	 aCoreHash.put(new Integer(sno),aProfile);
 			    sno++;
 		  
                 }
		}
		catch(Exception e)
		{e.printStackTrace();
			LoggerManager.writeLogWarning(e);
		}
		finally
		{
		 try{
			 if(con!=null)
				 con.close();
			 
		 }
		 catch(Exception e){}
		}
		return aCoreHash;
	}
  //getreport of login fromdate todate
    public CoreHash getReportByRegisterDate(String sdate,String edate)
	{
		
		Properties p=getProperties();
		System.out.println("sdate="+sdate);
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println(" aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		Profile aProfile=null;
		try {
			 con = getConnection();
			   
            	 st=con.createStatement();
            	 ResultSet rs=st.executeQuery("SELECT LOGINID ,FIRSTNAME,LASTNAME,DOB,DOR,EMAILID FROM USERDETAILS WHERE DOR>='"+sdate+"' AND DOR<='"+edate+"'"  );
            	 System.out.println("after result set inregisterusers ");
            	 while(rs.next())
                 {System.out.println("after result set inregisterusers in while");
              	   aProfile=new Profile();
              	  
              	   aProfile.setLoginID(rs.getString(1));
              	   aProfile.setFirstname(rs.getString(2));  
              	   aProfile.setLastName(rs.getString(3));
              	   String date=DateWrapper.parseDate(rs.getDate(4)).trim();
                	aProfile.setBirthDate(date);
                   aProfile.setRegDate(DateWrapper.parseDate(rs.getDate(5)).trim());
                   aProfile.setEmail(rs.getString(6));
                   	 aCoreHash.put(new Integer(sno),aProfile);
 			    sno++;
 		  
                 }
		}
		catch(Exception e)
		{e.printStackTrace();
			LoggerManager.writeLogWarning(e);
		}
		finally
		{
		 try{
			 if(con!=null)
				 con.close();
			 
		 }
		 catch(Exception e){}
		}
		return aCoreHash;
	}
    //presentloginuser getting
    
    public CoreHash getReportPresent()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		CallableStatement cstmt;
		Profile aProfile=null;
		try {
			 con = getConnection();
			   
			
            	 cstmt=con.prepareCall("{call REF_CURSOR_TEST.GET_ACCOUNTS_PROCEDURE(?)}");
            	 cstmt.registerOutParameter(1,OracleTypes.CURSOR);
            	 cstmt.executeUpdate();
            	 ResultSet rs=((OracleCallableStatement)cstmt).getCursor(1);
            	  while(rs.next())
                 {
              	   aProfile=new Profile();
              	   
              	   aProfile.setLoginID(rs.getString(1));
              	   aProfile.setFirstname(rs.getString(2));  
              	   aProfile.setLastName(rs.getString(3));
              	   String date=DateWrapper.parseDate(rs.getDate(4)).trim();
                	aProfile.setBirthDate(date);
                   aProfile.setRegDate(DateWrapper.parseDate(rs.getDate(5)).trim());
                   aProfile.setEmail(rs.getString(6));
                   	
               	   
              	 aCoreHash.put(new Integer(sno),aProfile);
 			    sno++;
 		  
                 }
		}
		catch(Exception e)
		{e.printStackTrace();
			LoggerManager.writeLogWarning(e);
		}
		finally
		{
		 try{
			 if(con!=null)
				 con.close();
			 
		 }
		 catch(Exception e){}
		}
		return aCoreHash;
	}
    
    
    public boolean changeAccountStatus(String loginid,int status)
    {
        try 
        {
        	con=getConnection();
            con.setAutoCommit(false);
            
        }
        catch(Exception e){}
        return flag;
    }
}
