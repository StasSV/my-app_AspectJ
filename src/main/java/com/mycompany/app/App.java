package com.mycompany.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
		LecturesWorker worker = (LecturesWorker) context.getBean("worker");
		LecturesWorkerAnthr workerant = (LecturesWorkerAnthr) context.getBean("workerant");
		

		Lecture lecture = new Lecture();
		lecture.setName("Introduction to Spring");
		lecture.setCredits(2.5);
		worker.addLecture(lecture);
		
		Lecture lecture2 = new Lecture();
		lecture2.setName("Introduction to Haskell");
		lecture2.setCredits(5.5);
		workerant.addLecture(lecture2);
		
	}

}