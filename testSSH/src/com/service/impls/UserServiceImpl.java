package com.service.impls;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.IStudentDao;
import com.pojo.Student;
import com.service.IUserService;

@Service(value="userService")
@Transactional
public class UserServiceImpl implements IUserService {
	@Resource(name="studentDao")
    private IStudentDao studentDao;
    
	public IStudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	@Transactional (readOnly=false,propagation=Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
	public void add(Student stu) {
		System.out.println(stu.getName());
		studentDao.add(stu);
	}

}
