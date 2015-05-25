package trastienda.modelo;

import java.util.ArrayList;
import java.util.Collection;

public class Question {

	private int QuestionNum;
	private String Question;
	private Collection<SecurityQuestion> securityQuestions = new ArrayList<SecurityQuestion>();

	public Question(){
	}
	
	public Question(int QuestionNum, String Question)
	{
		this.QuestionNum = QuestionNum;
		this.Question = Question;
	}

	
	public int getQuestionNum()
	{
		return QuestionNum;
	}
	
	public void setQuestionNum(int QuestionNum) {
		this.QuestionNum = QuestionNum;
	}

	public String getQuestion()
	{
		return Question;
	}
	
	public void setQuestion(String Question) {
		this.Question = Question;
	}
	
	public void setSecurityQuestion(Collection<SecurityQuestion> securityQuestions) {
		this.securityQuestions = securityQuestions;
	}

	public Collection<SecurityQuestion> getSecurityQuestion() {
		return securityQuestions;
	}
}
