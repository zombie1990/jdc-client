/**
 * 
 */
package com.jsu.struts2.action;

import java.io.File;

import com.jsu.io.StreamHandler;
import com.jsu.util.JudgeConfig;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class ShowTestCaseContent extends ActionSupport {

	private static final long serialVersionUID = -15980198L;
	
	private Integer problemId;
	private String inputFilesName;
	private String outputFilesName;
	private String content;
	public Integer getProblemId() {
		return problemId;
	}
	public String getInputFilesName() {
		return inputFilesName;
	}
	public String getOutputFilesName() {
		return outputFilesName;
	}
	public String getContent() {
		return content;
	}
	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}
	public void setInputFilesName(String inputFilesName) {
		this.inputFilesName = inputFilesName;
	}
	public void setOutputFilesName(String outputFilesName) {
		this.outputFilesName = outputFilesName;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String execute() {
		
		try {
			File file;
			if(outputFilesName == null)  {
				try {
					file = new File(JudgeConfig.getValue("JUDGE_BASE") + "data\\" + problemId.toString() + "\\inputs\\" + inputFilesName);
				}catch(NullPointerException npe) {
					this.content = "File Not Found, Please Check First!";
					return SUCCESS;
				}
			} else {
				try {
					file = new File(JudgeConfig.getValue("JUDGE_BASE") + "data\\" + problemId.toString() + "\\outputs\\" + outputFilesName);
				}catch(NullPointerException npe) {
					this.content = "File Not Found, Please Check First!";
					return SUCCESS;
				}
			}
			try {
				this.content = StreamHandler.read(file).replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>");
			} catch (NullPointerException npe) {
				this.content = "File Not Found, Please Check First!";
				return SUCCESS;
			}
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
	
}
