/**
 * 
 */
package com.jsu.struts2.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class Download extends ActionSupport {

	private static final long serialVersionUID = -25763216L;
	private String inputPath;

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

    public InputStream getInputStream() throws Exception {
        return ServletActionContext.getServletContext().getResourceAsStream(inputPath);
    }

    public String execute() throws Exception {
        return SUCCESS;
    }
}
