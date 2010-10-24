package edu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.domains.User;

/**
 * @author xiyu
 *
 */
public class DoUpload extends ActionSupport {

	private File upload;
	private String fileName;
	private String contentType;
	private int manageType;
	
	public String execute() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(null == user) {
			ActionContext.getContext().getSession().put("error", "请先登录");
			return INPUT;
		}
		if("00000000".equals(user.getPermission())) {
			ActionContext.getContext().getSession().put("error", "您没有权利管理该板块");
			return INPUT;
		}
		if(null == upload) {
			ActionContext.getContext().getSession().put("error", "请选择上传文件");
			return INPUT;
		}
		String path = "/home/zb00115/Tomcat/webapps/ROOT";
		String separator = "/";
		FileInputStream fis = new FileInputStream(upload);
		FileOutputStream fos = new FileOutputStream(path + separator + fileName);
		byte[] buffer = new byte[1024];
		int len = 0;
		while( (len = fis.read(buffer)) > 0 ) {
			fos.write(buffer, 0, len);
		}
		fos.close();
		fis.close();
		ActionContext.getContext().getSession().put("error", "上传成功");
		return SUCCESS;
	}

	public String getUploadContentType() {
		return contentType;
	}

	public void setUploadContentType(String contentType) {
		this.contentType = contentType;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return fileName;
	}

	public void setUploadFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getManageType() {
		return manageType;
	}

	public void setManageType(int manageType) {
		this.manageType = manageType;
	}

}
