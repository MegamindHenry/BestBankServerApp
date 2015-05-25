package trastienda.modelo;

public class SecurityQuestion {

	private Integer CustomerID;
	private Integer QuestionNum;
	private String Answer;
	
	public SecurityQuestion(){	
		
	}
	
	public SecurityQuestion(Integer CustomerID, Integer QuestionNum, String Answer)
	{
		this.CustomerID = CustomerID;
		this.QuestionNum = QuestionNum;
		this.Answer = Answer;
		
	}

	
	public Integer getCustomerID()
	{
		return CustomerID;
	}
	
	public void setCustomerID(int CustomerID) {
		this.CustomerID = CustomerID;
	}
	
	public Integer getQuestionNum()
	{
		return QuestionNum;
	}
	
	public void setQuestionNum(int QuestionNum) {
		this.QuestionNum = QuestionNum;
	}
	
	public String getAnswer()
	{
		return Answer;
	}
	
	public void setAnswer(String Answer) {
		this.Answer = Answer;
	}
	

}
