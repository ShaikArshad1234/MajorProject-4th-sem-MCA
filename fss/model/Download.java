package com.dts.fss.model;

public class Download {
    
	String ownerID;
	String loginID;
	String sownloadDate;
	String downloadTime;
	int fileID;
	String ipAddress;
	boolean status;
	int folderID;
	int subFolderID;
	String fileName;
	double FileSize;
	public double getFileSize() {
		return FileSize;
	}
	public void setFileSize(double FileSize) {
		this.FileSize = FileSize;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getSownloadDate() {
		return sownloadDate;
	}
	public void setSownloadDate(String sownloadDate) {
		this.sownloadDate = sownloadDate;
	}
	public String getDownloadTime() {
		return downloadTime;
	}
	public void setDownloadTime(String downloadTime) {
		this.downloadTime = downloadTime;
	}
	public int getFileID() {
		return fileID;
	}
	public void setFileID(int fileID) {
		this.fileID = fileID;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getFolderID() {
		return folderID;
	}
	public void setFolderID(int folderID) {
		this.folderID = folderID;
	}
	public int getSubFolderID() {
		return subFolderID;
	}
	public void setSubFolderID(int subFolderID) {
		this.subFolderID = subFolderID;
	}
	public String getOwnerID() {
		return ownerID;
	}
	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}
	
}
