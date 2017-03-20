package com.niit.collaborationbackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationbackend.dao.UserRoleDAO;
import com.niit.collaborationbackend.model.UserRole;

public class UserRoleUniTest {

	@Autowired
	UserRoleDAO userRoleDao;

	@Autowired
	UserRole userRole;

	AnnotationConfigApplicationContext context;

	@Before
	public void init(){
		try
		{
			context = new AnnotationConfigApplicationContext();
			context.scan("com.niit.collaborationbackend");
			context.refresh();

			userRole = (UserRole) context.getBean("userRole");
			userRoleDao = (UserRoleDAO) context.getBean("userRoleDao");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

	//@Test
	public void addUserRole() {
		userRole.setRolename("Role_Admin");
		assertEquals("addUserRole", userRoleDao.userRoleUpdate(userRole), true);
	}
	
	//@Test
	public void getUserRole() {
		
		userRole = userRoleDao.getUserRoleByID(1);
		System.err.println("Role ID : " + userRole.getRoleid() + " and Role name : " + userRole.getRolename());
		assertEquals("addUserRole", userRole.getRoleid(), 1);
	}

	//@Test
	public void getAllUserRole() {

		List<UserRole> lst = userRoleDao.getAllUserRoles();
		int total = lst.size();
		
		for(UserRole ur : lst){
			System.err.println("Role ID : " + ur.getRoleid() + " and Role name : " + ur.getRolename());
		}
		assertEquals("addUserRole", total, 1);
	}
}
