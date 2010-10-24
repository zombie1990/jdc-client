package edu.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.DAO.DAOFactory;
import edu.domains.User;

/**
 * @author xiyu
 *
 */
public class AddPermission extends ActionSupport {

	private String newPermission;
	private String newPermissionUsername;
	
	public String execute() throws Exception {
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(null == user) {
			ActionContext.getContext().getSession().put("error", "请先登录");
			return INPUT;
		}
		if(null == newPermission || "".equals(newPermission)) {
			ActionContext.getContext().getSession().put("error", "请选择权限");
			return INPUT;
		}
		if(null == newPermissionUsername || "".equals(newPermissionUsername)) {
			ActionContext.getContext().getSession().put("error", "请输入待添加权限的用户名");
			return INPUT;
		}
		User newPermissionUser = DAOFactory.getInstance().getUserDAO().findById(newPermissionUsername.trim(), false);
		if(null == newPermissionUser) {
			ActionContext.getContext().getSession().put("error", "该用户不存在");
			return INPUT;
		}
		/* 开始判断 */
		char[] temp = new char[8];
		newPermissionUser.getPermission().getChars(0, 8, temp, 0);
		if("学校概况".equals(newPermission)) {
			
			temp[0] = '1';
			newPermissionUser.setPermission(new String(temp));
			DAOFactory.getInstance().getUserDAO().makePersistent(newPermissionUser);
			ActionContext.getContext().getSession().put("error", "添加权限成功");
		}
		else if("校园新闻".equals(newPermission)) {
			temp[1] = '1';
			newPermissionUser.setPermission(new String(temp));
			DAOFactory.getInstance().getUserDAO().makePersistent(newPermissionUser);
			ActionContext.getContext().getSession().put("error", "添加权限成功");
		}
		else if("教师教学".equals(newPermission)) {
			temp[2] = '1';
			newPermissionUser.setPermission(new String(temp));
			DAOFactory.getInstance().getUserDAO().makePersistent(newPermissionUser);
			ActionContext.getContext().getSession().put("error", "添加权限成功");
		}
		else if("雏鹰起飞".equals(newPermission)) {
			temp[3] = '1';
			newPermissionUser.setPermission(new String(temp));
			DAOFactory.getInstance().getUserDAO().makePersistent(newPermissionUser);
			ActionContext.getContext().getSession().put("error", "添加权限成功");
		}
		else if("图片中心".equals(newPermission)) {
			temp[4] = '1';
			newPermissionUser.setPermission(new String(temp));
			DAOFactory.getInstance().getUserDAO().makePersistent(newPermissionUser);
			ActionContext.getContext().getSession().put("error", "添加权限成功");
		}
		else if("资源下载".equals(newPermission)) {
			temp[5] = '1';
			newPermissionUser.setPermission(new String(temp));
			DAOFactory.getInstance().getUserDAO().makePersistent(newPermissionUser);
			ActionContext.getContext().getSession().put("error", "添加权限成功");
		}
		else if("乾小博客".equals(newPermission)) {
			temp[6] = '1';
			newPermissionUser.setPermission(new String(temp));
			DAOFactory.getInstance().getUserDAO().makePersistent(newPermissionUser);
			ActionContext.getContext().getSession().put("error", "添加权限成功");
		}
		return SUCCESS;
	}

	public String getNewPermission() {
		return newPermission;
	}

	public void setNewPermission(String newPermission) {
		this.newPermission = newPermission;
	}

	public String getNewPermissionUsername() {
		return newPermissionUsername;
	}

	public void setNewPermissionUsername(String newPermissionUsername) {
		this.newPermissionUsername = newPermissionUsername;
	}
}
