package com.liupcc.spring.test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTest extends HttpServlet {
	/**
	 * ServletConfig:代表当前Servlet在web.xml中的配置信息
	 * String getServletName()  -- 获取当前Servlet在web.xml中配置的名字
	 * String getInitParameter(String name) -- 获取当前Servlet指定名称的初始化参数的值
	 * Enumeration getInitParameterNames()  -- 获取当前Servlet所有初始化参数的名字组成的枚举
	 * ServletContext getServletContext()  -- 获取代表当前web应用的ServletContext对象
	 * 
	 * 当servlet配置了初始化参数后，web容器在创建servlet实例对象时，会自动将这些初始化参数封装到ServletConfig对象中，
	 * 并在调用servlet的init方法时，将ServletConfig对象传递给servlet。
	 * 进而，程序员通过ServletConfig对象就可以得到当前servlet的初始化参数信息。
	 * 
	 * 这样做的好处是：如果将数据库信息、编码方式等配置信息放在web.xml中，如果以后数据库的用户名、密码改变了，
	 * 则直接很方便地修改web.xml就行了，避免了直接修改源代码的麻烦。
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//拿到init方法中的ServletConfig对象
		ServletConfig config = this.getServletConfig();
		String sName = config.getServletName();
		System.out.println("当前Servlet 在web.xml中配置的名称:"+sName);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
