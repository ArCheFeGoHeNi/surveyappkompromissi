
package hh.swd22.project.surveyapp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity //Entity Class
public class Question {

    private String questionText;
    private String questionType;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionID;

    @ManyToOne
    //@JsonManagedReference
    @JsonBackReference //Critical for stopping endless looping //Child level
    @JoinColumn
    private Survey survey;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    @JsonIgnore
    //@JsonBackReference
    //@JsonManagedReference //Parent level
    private List<Answer> answer;

    public Question() {

    }

    public Question(String questionText, String questionType, Survey survey) {
        this.questionText = questionText;
        this.questionType = questionType;
        this.survey = survey;
    }

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String question) {
        this.questionText = question;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questiontype) {
        this.questionType = questiontype;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}
    

}