package edu.mum.cs544;

import javax.persistence.EntityManager;

public class StudentDAO {
	public Student load(long studentid) {
		EntityManager em = EntityManagerHelper.getCurrent();
        return em.find(Student.class, studentid);
	}
}
