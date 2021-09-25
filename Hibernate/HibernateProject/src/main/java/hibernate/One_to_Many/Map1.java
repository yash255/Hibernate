package hibernate.One_to_Many;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;
import org.hibernate.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Map1 {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//creating question
		Question1 question = new Question1();
		question.setQuestion("Where is Pune ?");
		question.setQuestionID(1);
		
/*		
		//creating answer
		Answer1 answer = new Answer1();
		answer.setAnswerID(101);
		answer.setAnswer("In Maharashtra");
		answer.setQuestion(question);
		
		Answer1 answer1 = new Answer1();
		answer1.setAnswerID(102);
		answer1.setAnswer("In India");
		answer1.setQuestion(question);
		
		Answer1 answer2 = new Answer1();
		answer2.setAnswerID(103);
		answer2.setAnswer("In Asia");
		answer2.setQuestion(question);
		
		List<Answer1> list = new ArrayList<Answer1>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);
		
		question.setAnswers(list);*/
		
		
		
		
		Session s = factory.openSession();
		org.hibernate.Transaction tx = s.beginTransaction();
		
		//save
//		s.save(question);
//		s.save(answer);
//		s.save(answer1);
//		s.save(answer2);

		Question1 que = s.get(Question1.class, 1);
		System.out.println(que.getQuestionID());
		System.out.println(que.getQuestion());
		System.out.println(que.getAnswers().size());
		
		
		
		
		
		tx.commit();
		
		
		
		
		s.close();
		
		
		
		
		factory.close();
	}

}
