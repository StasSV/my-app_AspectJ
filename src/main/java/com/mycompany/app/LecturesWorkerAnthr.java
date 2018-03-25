package com.mycompany.app;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LecturesWorkerAnthr{

	@Autowired
	private TransactionTemplate transactionTemplate;
	@Autowired
	private LecturesDao lecturesDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public void addLecture(Lecture lecture) {
		lecturesDao.saveLecture(lecture);
		System.out.println("Lecture has been saved " + lecture);
	}

}
