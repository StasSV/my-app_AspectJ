package com.mycompany.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;


public class LecturesWorker {
	@Autowired
	private TransactionTemplate transactionTemplate;
	@Autowired
	private LecturesDao lecturesDao;

	public Lecture addLecture(final Lecture lecture) {
		transactionTemplate.execute(new TransactionCallback<Void>() {
			public Void doInTransaction(TransactionStatus txStatus) {
				try {
					lecturesDao.addLecture(lecture);
					System.out.println("Lecture has been added " + lecture);
				} catch (RuntimeException e) {
					txStatus.setRollbackOnly();
					throw e;
				}
				return null;
			}
		});
		return lecture;
	}
}
