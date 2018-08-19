package com.liupcc.spring.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LiupccDispatchServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Properties contextConfig = new Properties();

	private Map<String, Object> beanMap = new ConcurrentHashMap<>();

	private List<String> beanNames = new ArrayList<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("dopost..........");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 定位
		doLoadConfig(config.getInitParameter("contextConfigLocation"));

		// 加载
		doScanner();

		// 注册
		doRegister();

		// 自动依赖注入
		doAutowired();

		// 如果是springMVC会多设计一个HandlerMapping
		// 将@requestMapping中的配置url和一个Method关联上
		// 以便从浏览器获得用户输入的url，能通过具体执行的Method通过反射去调用
		initHandlerMapping();

	}

	private void initHandlerMapping() {
		// TODO Auto-generated method stub

	}

	private void doAutowired() {
		// TODO Auto-generated method stub

	}

	private void doRegister() {
		// TODO Auto-generated method stub

	}

	private void doScanner() {
		// TODO Auto-generated method stub

	}

	private void doLoadConfig(String location) {
		System.out.println(location.replace("classpath:", ""));
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(location.replace("classpath:", ""));
		try {
			contextConfig.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
