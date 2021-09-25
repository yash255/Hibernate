package hibernate.One_to_Many;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question1 {
	@Id
	@Column(name = "question_id")
	private int questionID;
	
	private String question;
	
	@OneToMany(mappedBy = "question",fetch = FetchType.EAGER )
	private List<Answer1> answers;
	
	//getter setter
	
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	
	public List<Answer1> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer1> answers) {
		this.answers = answers;
	}
	
	
	public Question1(int questionID, String question, List<Answer1> answers) {
		super();
		this.questionID = questionID;
		this.question = question;
		this.answers = answers;
	}
	
	
	public Question1() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
