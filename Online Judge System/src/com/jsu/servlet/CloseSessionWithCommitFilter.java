/**
 * 
 */
package com.jsu.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsu.util.HibernateUtil;

/**
 * @author: Luo Qiang Last Modified: 2010-1-26
 */

public class CloseSessionWithCommitFilter implements Filter {
	protected FilterConfig config;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			chain.doFilter((HttpServletRequest)request, (HttpServletResponse)response);
		} finally {
			try {
				HibernateUtil.commitTransaction();
			} catch (Exception e) {
				HibernateUtil.rollbackTransaction();
			} finally {
				HibernateUtil.closeSession();
			}
		}
	}

	public void destroy() {
		this.config = null;
	}

}