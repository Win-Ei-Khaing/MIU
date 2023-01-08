package edu.mum.cs544;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class StudentService {
	@Resource
	private StudentDAO studentdao;

	public Student getStudent(long studentid) {
		Student student = studentdao.load(studentid);
		return student;
	}
}
