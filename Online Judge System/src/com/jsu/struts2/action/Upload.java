/**
 * 
 */
package com.jsu.struts2.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


import com.jsu.util.JudgeConfig;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class Upload extends ActionSupport {

	private static final long serialVersionUID = -25763216L;
	
	private Integer problemId;
	private File file;
	private String fileFileName;
	private String inOrOut;
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getInOrOut() {
		return inOrOut;
	}
	public void setInOrOut(String inOrOut) {
		this.inOrOut = inOrOut;
	}
	public Integer getProblemId() {
		return problemId;
	}
	public File getFile() {
		return file;
	}
	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
	public String execute() throws Exception {
		
		try {
			File dirIn = new File(JudgeConfig.getValue("JUDGE_BASE") + "data\\" + problemId.toString() + "\\inputs");
			File dirOut = new File(JudgeConfig.getValue("JUDGE_BASE") + "data\\" + problemId.toString() + "\\outputs");
			if(!dirIn.exists() && !dirOut.exists()) {
				dirIn.mkdirs();
				dirOut.mkdirs();
			}
			FileOutputStream fos = new FileOutputStream(JudgeConfig.getValue("JUDGE_BASE") + "data\\" + problemId.toString() + "\\" + this.inOrOut + "\\" + fileFileName);
			FileInputStream fis = new FileInputStream(this.file);
			byte[] buffer = new byte[1024];
			int len = 0;
			while( (len = fis.read(buffer)) > 0 ) {
				fos.write(buffer, 0, len);
			}
			fos.close();
			fis.close();
		} catch(Exception e) {
			return "error";
		}
		return SUCCESS;
	}
	
	public void validate() {
		
		if(this.file == null || this.inOrOut == null) {
			this.addFieldError("inOrOut", "direction,file can not be empty,and file size can not exceed 20M!");
		}
	}
}
