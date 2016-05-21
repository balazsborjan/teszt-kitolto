package xyz.codingmentor.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Olivér
 */
@Entity
public class Question implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String text;
    @Enumerated
    private QuestionType type;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TEST_ID")
    private Test test;
    private Integer lengthOfAnswer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Integer getLengthOfAnswer() {
        return lengthOfAnswer;
    }

    public void setLengthOfAnswer(Integer lengthOfAnswer) {
        this.lengthOfAnswer = lengthOfAnswer;
    }
}
