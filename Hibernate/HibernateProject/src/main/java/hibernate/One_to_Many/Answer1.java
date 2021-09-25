package hibernate.One_to_Many;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.sun.beans.introspect.PropertyInfo.Name;

@Entity
public class Answer1 {
	@Id
	@Column(name = "answer_id")
	private int  answerID;
	@ManyToOne
	
	private Question1 question;
	
	
	
	public Answer1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Answer1(int answerID, String answer) {
		super();
		this.answerID = answerID;
		this.answer = answer;
	}
	
	
	public int getAnswerID() {
		return answerID;
	}
	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	private String answer;



	public Question1 getQuestion() {
		return question;
	}


	public void setQuestion(Question1 question) {
		this.question = question;
	}

}
