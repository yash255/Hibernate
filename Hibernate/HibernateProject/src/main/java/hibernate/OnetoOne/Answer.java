package hibernate.OnetoOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.sun.beans.introspect.PropertyInfo.Name;

@Entity
public class Answer {
	@Id
	@Column(name = "answer_id")
	private int  answerID;
	@OneToOne(mappedBy = "answer")
	
	private Question question;
	
	
	
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Answer(int answerID, String answer) {
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



	public Question getQuestion() {
		return question;
	}


	public void setQuestion(Question question) {
		this.question = question;
	}

}
