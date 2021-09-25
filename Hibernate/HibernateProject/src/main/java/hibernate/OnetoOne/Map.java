package hibernate.OnetoOne;

import javax.transaction.Transaction;
import org.hibernate.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Map {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//creating question
		Question question = new Question();
		question.setQuestion("Where is Pune ?");
		question.setQuestionID(1);
		
		
		//creating answer
		Answer answer = new Answer();
		answer.setAnswerID(101);
		answer.setAnswer("In Maharashtra");
		answer.setQuestion(question);
		
		
		question.setAnswer(answer);
		
		Session s = factory.openSession();
		org.hibernate.Transaction tx = s.beginTransaction();
		
		//save
		s.save(question);
		s.save(answer);
		tx.commit();
		
		Question que = s.get(Question.class, 1);
		System.out.println(que.getQuestion());
		System.out.println(que.getAnswer());
		
		
		s.close();
		
		
		
		
		factory.close();
	}

}
