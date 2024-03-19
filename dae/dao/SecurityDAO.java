/*
 * SecurityDAO.java
 *
 * 
 */

package com.dts.dae.dao;


import com.dts.dae.model.Profile;
import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Date;
/**
 *
 * @author 
 */
public class SecurityDAO extends AbstractDataAccessObject
{
     Connection con;
     private String desc;
     private boolean flag;
    /** Creates a new instance of SecurityDAO */
    public SecurityDAO() 
    {
       
               //getting Database Connection
    	
               
    }
    
   
   
    //Login Check
    public String loginCheck(Profile regbean)
    {
        String loginid=regbean.getLoginID();
        String password=regbean.getPassword();
        String role="ee";        
        try
        {   con=getConnection();
        System.out.println("con"+con);
          //  con.setAutoCommit(true);
            CallableStatement cstmt=con.prepareCall("{call logincheck(?,?,?)}");
            cstmt.setString(1,loginid);
            cstmt.setString(2,password);
            cstmt.registerOutParameter(3,Types.VARCHAR);
           boolean flag= cstmt.execute();
           System.out.println("flag->"+flag);
            role=cstmt.getString(3);
            System.out.println("logintype="+role);
            
            
        }
        catch (SQLException ex) 
        {ex.printStackTrace();
        	LoggerManager.writeLogSevere(ex);
            desc="Database Connection problem";
            flag=false;
        }
        //loginaudit(loginid,desc);
        return role;
    }
    
    
    //Method for login audit
    public void loginaudit(String loginid)
    {
        try 
        { con=getConnection();
        	
            CallableStatement cstmt=con.prepareCall("{call signoutprocedure(?)}");
            cstmt.setString(1,loginid);
            
            System.out.println("in loginaudit");
           cstmt.execute();
           
            con.close();
        }
        catch(Exception e)
        {
             
            e.printStackTrace();
            }
    }
    //Change Password
    public boolean changePassword(Profile regbean)
    {
        String loginid=regbean.getLoginID();
        String oldpassword=regbean.getPassword();
        String newpassword=regbean.getNewPassword();
        try 
        {con=getConnection();
        	con.setAutoCommit(false);
           
            CallableStatement cstmt=con.prepareCall("{call changePassword(?,?,?,?)}");
            
            
            cstmt.setString(1,loginid);
            cstmt.setString(2,oldpassword);
            cstmt.setString(3,newpassword);
            cstmt.registerOutParameter(4,Types.INTEGER);
            cstmt.execute();
            int i=cstmt.getInt(4);
            System.out.println("i="+i);
            if(i==1)
            {
                flag=true;
                con.commit();
            }
            else
            {
                flag=false;
                con.rollback();
            }
            con.close();
        } 
        catch (SQLException ex) 
        {ex.printStackTrace();
        	LoggerManager.writeLogSevere(ex);
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException sex) 
            {
            	LoggerManager.writeLogSevere(sex);
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
            catch (SQLException sex) 
            {sex.printStackTrace();
            	LoggerManager.writeLogSevere(sex);
            }
        }
        return flag;        
    }
    
    
     //Change Secret Question
    public boolean changeQuestion(Profile regbean)
    {
        String loginid=regbean.getLoginID();
        String password=regbean.getPassword();
        String secretquestid=regbean.getSecretQuestionID();
        
        String secretans=regbean.getSecretAnswer();
        
        CallableStatement cstmt;
        int i=0;
        try 
        {   
           
            	con=getConnection();
            	//con.setAutoCommit(false);
                
               
                cstmt=con.prepareCall("{call ChangeQuetion(?,?,?,?,?)}");
            
                cstmt.setString(1,loginid);
                cstmt.setString(2,password);
                cstmt.setString(3,secretquestid);
                cstmt.setString(4,secretans);
                cstmt.registerOutParameter(5,Types.INTEGER); 
                cstmt.execute();
                i=cstmt.getInt(5);
                if(i==1)
                {
                    flag=true;
                    con.commit();
                }
                else
                {
                    flag=false;
                    con.rollback();
                }
           
            con.close();
        }
        catch (SQLException ex) 
        {ex.printStackTrace();
        	LoggerManager.writeLogSevere(ex);
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException sex) 
            {
            	LoggerManager.writeLogSevere(sex);
            }
        }
        catch (Exception e) 
        {e.printStackTrace();
        	LoggerManager.writeLogSevere(e);
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException sex) 
            {
            	LoggerManager.writeLogSevere(sex);
            }
        }
        return flag;        
    }
    
     //Recover Password using Existed Question
    public String recoverPasswordByQuestion(Profile regbean)
    {
        String password;
        String loginid=regbean.getLoginID();
        String secretquestid=regbean.getSecretQuestionID();
        String secretans=regbean.getSecretAnswer();
        try 
        {con=getConnection();
        	con.setAutoCommit(true); 
            CallableStatement cstmt=con.prepareCall("{call RecoverPassword(?,?,?,?)}");
            cstmt.setString(1,loginid);
            cstmt.setString(2,secretquestid);
            cstmt.setString(3,secretans);
            cstmt.registerOutParameter(4,Types.VARCHAR);           
            cstmt.execute();
            password=cstmt.getString(4);
            con.close();
        } 
        catch (SQLException ex) 
        {ex.printStackTrace();
        	LoggerManager.writeLogSevere(ex);
            password="";
        }
        catch (Exception e) 
        {
        	LoggerManager.writeLogSevere(e);
            password="";
        }
        return password;        
    }
    public String  checkUser(String userName)
    {
 	   String user=null;
 	   System.out.println("username"+userName);
 	   try 
 	   
        {con=getConnection();
        	con.setAutoCommit(true); 
            CallableStatement cstmt=con.prepareCall("{ call loginidavailablity(?,?) }");
            cstmt.setString(1, userName);
            cstmt.registerOutParameter(2,Types.VARCHAR);           
            cstmt.execute();
            user=cstmt.getString(2);
            con.close();
        } 
        catch (SQLException ex) 
        {ex.printStackTrace();
        	LoggerManager.writeLogSevere(ex);
            user=null;
        }
        catch (Exception e) 
        {
        	LoggerManager.writeLogSevere(e);
        	user=null;
        }
        return user;        
    }
    
}
   
