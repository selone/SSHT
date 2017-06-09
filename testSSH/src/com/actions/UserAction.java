package com.actions;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.pojo.Student;
import com.service.IUserService;

@ParentPackage("struts-default")
@Namespace("/student")
@Action(value="user",results={
		@Result(name="uptsuccess",location="/student/liststudent.jsp"),
		@Result(name="queryone",location="/student/detail.jsp"),
		@Result(name="queryall",location="/student/liststudent.jsp"),
		@Result(name="error",location="/error.jsp")
		})
public class UserAction {
    private Student student;
    @Resource(name="userService")
    private IUserService userService;
    
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String add() {
		try {
			userService.add(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "uptsuccess";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
