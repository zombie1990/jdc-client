/**
 * 
 */
package com.jsu.struts2.action;

import java.util.ArrayList;
import java.util.List;

import com.jsu.io.StreamHandler;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class ShowTestCase extends ActionSupport {

	private static final long serialVersionUID = -29181731L;
	
	private Integer problemId;
	private List<String> inputFilesName;
	private List<String> outputFilesName;
	public Integer getProblemId() {
		return problemId;
	}
	public List<String> getInputFilesName() {
		return inputFilesName;
	}
	public List<String> getOutputFilesName() {
		return outputFilesName;
	}
	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}
	public void setInputFilesName(List<String> inputFilesName) {
		this.inputFilesName = inputFilesName;
	}
	public void setOutputFilesName(List<String> outputFilesName) {
		this.outputFilesName = outputFilesName;
	}
	public String execute() {
		
		try {
			String[] inN = StreamHandler.getInputFilesName(problemId);
			String[] outN = StreamHandler.getOutputFilesName(problemId);
			inputFilesName = new ArrayList<String>();
			outputFilesName = new ArrayList<String>();
			if(inN != null)
				for(int i = 0; i < inN.length; i++) {
					inputFilesName.add(inN[i]);
				}
			if(outN != null)
				for(int i = 0; i < outN.length; i++) {
					outputFilesName.add(outN[i]);
				}
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
	
}
