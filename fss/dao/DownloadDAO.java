/**
 * 
 */
package com.dts.fss.dao;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringTokenizer;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.dae.model.Profile;
import com.dts.fss.model.Download;

/**
 * @author user
 *
 */
public class DownloadDAO extends AbstractDataAccessObject {

	Connection con;
	public String fileDownload(Download d,String path)
	{
	boolean flag=false;
	String filename=null;
	try
	{
		con =getConnection();
       String sql = "SELECT  FILENAME,CONTENT,CONTENTCLOB FROM fileupload where fileid=? and subfolderid=? and folderid=?";
	   PreparedStatement stmt = con.prepareStatement(sql);
	   stmt.setInt(1, d.getFileID());
	   stmt.setInt(2, d.getSubFolderID());
	   stmt.setInt(3, d.getFolderID());
	   ResultSet resultSet = stmt.executeQuery();
   while (resultSet.next()) {
       
	   filename=resultSet.getString(1);
	   StringTokenizer stk=new StringTokenizer(filename,".");
		
		String name=stk.nextToken();
		System.out.println("after Stringtokenizer in download");
		String extension=stk.nextToken();
         
          
          if(!(extension.equalsIgnoreCase("JPEG")||extension.equalsIgnoreCase("JPG")||extension.equalsIgnoreCase("GIF")||extension.equalsIgnoreCase("bmp")||extension.equalsIgnoreCase("wmv")))
            
          {System.out.println("in if");
        	  File data = new File(path+"/"+name+"."+extension);
        	  Reader reader = resultSet.getCharacterStream(3);
             FileWriter writer = new FileWriter(data);
             char[] buffer = new char[1];
             while (reader.read(buffer) > 0) {
                 writer.write(buffer);
                 
             }
             writer.close();
            }
            else
            {

            	Blob b =resultSet.getBlob(2);
    			byte b1[]=b.getBytes(1,(int)b.length());//new byte[(int)b.length()];
    			//InputStream in=photo.getBinaryStream();
    			OutputStream fout=new FileOutputStream(path+"/"+name+"."+extension);
    			fout.write(b1);
            }
       flag=true;
   }
   if(flag)
   {
	   flag=false;
   String ipaddr="127.0.0.1";
   String downldQuery="insert into filedownload values((select userid from userdetails where loginid='"+d.getLoginID()+"'),(select nvl(max(downloadid),100)+1 from filedownload),sysdate,sysdate,?,?,1,?,?)";
   stmt = con.prepareStatement(downldQuery);
   stmt.setInt(1, d.getFileID());
   stmt.setString(2,ipaddr);
   stmt.setInt(3, d.getFolderID());
   stmt.setInt(4, d.getSubFolderID());
   int res=stmt.executeUpdate();
   if(res>0)
	   flag=true;
   
   
   
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

	return filename;	
    
}
	//ownfiledownload
	public String ownFileDownload(Download d,String path)
	{
	boolean flag=false;
	String filename=null;
	try
	{
		con =getConnection();
		//con.setAutoCommit(false);
       String sql = "SELECT  FILENAME,CONTENT,CONTENTCLOB FROM fileupload where fileid=? and subfolderid=?";
	   PreparedStatement stmt = con.prepareStatement(sql);
	   stmt.setInt(1, d.getFileID());
	   stmt.setInt(2, d.getSubFolderID());
	   
	   ResultSet resultSet = stmt.executeQuery();
   while (resultSet.next()) {
       
	   filename=resultSet.getString(1);
	   StringTokenizer stk=new StringTokenizer(filename,".");
		
		String name=stk.nextToken();
		System.out.println("after Stringtokenizer in download");
		String extension=stk.nextToken();
         
          
          if(!(extension.equalsIgnoreCase("JPEG")||extension.equalsIgnoreCase("JPG")||extension.equalsIgnoreCase("GIF")||extension.equalsIgnoreCase("bmp")||extension.equalsIgnoreCase("wmv")))
            
          {
        	  System.out.println("in if");
        	  File data = new File(path+"/"+name+"."+extension);
        	  Reader reader = resultSet.getCharacterStream(3);
             FileWriter writer = new FileWriter(data);
             char[] buffer = new char[1];
             while (reader.read(buffer) > 0) 
             {
                 writer.write(buffer);
                 
             }
             writer.close();
            }
            else
            {
            	
            	Blob b =resultSet.getBlob(2);
    			byte b1[]=b.getBytes(1,(int)b.length());//new byte[(int)b.length()];
    			//InputStream in=photo.getBinaryStream();
    			OutputStream fout=new FileOutputStream(path+"/"+name+"."+extension);
    			fout.write(b1);
            }
          
       
       flag=true;
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

	return filename;	
    
}
	
	 public CoreHash getPublicDownloadableFile()
		{
			
			CoreHash aCoreHash = new CoreHash();
			aCoreHash.clear();
			
			int sno=1;
			Statement st;
			Statement st1;
			Download aDownload=null;
			try {
				 con = getConnection();
				   
	            	 st=con.createStatement();
	            	 st1=con.createStatement();
	            	 ResultSet rs=st.executeQuery("SELECT FILEID,SUBFOLDERID,FOLDERID,FILENAME,FILESIZE,to_char(fileuploadDATE),userid FROM FILEUPLOAD WHERE FILEPERMISSION='public' AND FILESTATUS='active' order by 6 asc");
	            	 while(rs.next())
	                 {
	              	   aDownload=new Download();
	              	  
	              	   aDownload.setFileID(rs.getInt(1));
	              	   aDownload.setSubFolderID(rs.getInt(2));  
	              	   aDownload.setFolderID(rs.getInt(3));
	              	   aDownload.setFileName(rs.getString(4));
	              	   aDownload.setFileSize(rs.getInt(5));
	                   aDownload.setSownloadDate(rs.getString(6)); 
	                   int userid=rs.getInt(7);
	                   ResultSet rs1=st1.executeQuery("select loginid from userdetails where userid="+userid);
	                   if(rs1.next())
	                   aDownload.setOwnerID(rs1.getString(1));
	              	 aCoreHash.put(new Integer(sno),aDownload);
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
	 //getAllreadydownloadedfile
	
	 public boolean getAllreadydownloadedfile(Download d,String user)
		{
			
			int sno=1;
			Statement st;
			boolean flag=false;
			try {
				 con = getConnection();
				 PreparedStatement pstmt=con.prepareStatement("select * from filedownload where userid=(select userid from userdetails where loginid='"+user+"') and fileidfordownload=? and downloadedfolderid=? and downloadedsubfolderid=?");
				 pstmt.setInt(1,d.getFileID());
				 pstmt.setInt(2,d.getFolderID());
				 pstmt.setInt(3,d.getSubFolderID());
				 ResultSet rs=pstmt.executeQuery();
				 if(rs.next())
				 {
					 flag=true;
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
			return flag;
		}
	
	
	 
	 //parialpublic view
	 public CoreHash getPartialPublicDownloadableFile(String user)
		{
			

			CoreHash aCoreHash = new CoreHash();
			aCoreHash.clear();
			
			int sno=1;
			Statement st;
			Statement st1;
			Download aDownload=null;
			try {
				 con = getConnection();
				   
	            	 st=con.createStatement();
	            	 st1=con.createStatement();
	            	 ResultSet rs=st.executeQuery("SELECT FILEID,SUBFOLDERID,FOLDERID,FILENAME,FILESIZE,to_char(fileuploadDATE),userid FROM FILEUPLOAD WHERE FILEPERMISSION='partialpublic' AND FILESTATUS='active' order by 6 asc");
	            	 while(rs.next())
	                 {
	              	   aDownload=new Download();
	              	   aDownload.setFileID(rs.getInt(1));
	              	   aDownload.setSubFolderID(rs.getInt(2));  
	              	   aDownload.setFolderID(rs.getInt(3));
	              	   aDownload.setFileName(rs.getString(4));
	              	   aDownload.setFileSize(rs.getInt(5));
	                   aDownload.setSownloadDate(rs.getString(6)); 
	                   int userid=rs.getInt(7);
	                   ResultSet rs1=st1.executeQuery("select loginid from userdetails where userid="+userid);
	                   if(rs1.next())
	                   aDownload.setOwnerID(rs1.getString(1));
	              	 aCoreHash.put(new Integer(sno),aDownload);
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
	
	 //permitedPartialpublicfiles
	 public boolean getpermitedFiles(Download d,String user)
		{
			
			int sno=1;
			Statement st;
			boolean flag=false;
			try {
				 con = getConnection();
				 PreparedStatement pstmt=con.prepareStatement("select * from partialpublicfilestatus where receiveruserid=(select userid from userdetails where loginid='"+user+"') and fileid=?");
				 pstmt.setInt(1,d.getFileID());
				 ResultSet rs=pstmt.executeQuery();
				 if(rs.next())
				 {
					 flag=true;
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
			return flag;
		}
	 
	    

	
}
