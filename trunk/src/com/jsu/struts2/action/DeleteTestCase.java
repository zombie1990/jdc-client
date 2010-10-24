/**
 * 
 */
package com.jsu.struts2.action;

import java.io.File;

import com.jsu.util.JudgeConfig;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class DeleteTestCase extends ActionSupport {

	private static final long serialVersionUID = -10730690L;
	
	private Integer problemId;
	private String inputFilesName;
	private String outputFilesName;
	public Integer getProblemId() {
		return problemId;
	}
	public String getInputFilesName() {
		return inputFilesName;
	}
	public String getOutputFilesName() {
		return outputFilesName;
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
	public String execute() {
		
		try {
			File file;
			if(outputFilesName == null)  {
				try {
					file = new File(JudgeConfig.getValue("JUDGE_BASE") + "data\\" + problemId.toString() + "\\inputs\\" + inputFilesName);
					file.delete();
				}catch(NullPointerException npe) {
					return SUCCESS;
				}
			} else {
				try {
					file = new File(JudgeConfig.getValue("JUDGE_BASE") + "data\\" + problemId.toString() + "\\outputs\\" + outputFilesName);
					file.delete();
				}catch(NullPointerException npe) {
					return SUCCESS;
				}
			}
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
}
