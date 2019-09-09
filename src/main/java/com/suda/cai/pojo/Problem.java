package com.suda.cai.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "problem")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String author;
    private int type;
    @ManyToOne
    @JoinColumn(name="courseID")
    private Course course;
    @ManyToOne
    @JoinColumn(name="chapterID")
    private Chapter chapter;
    @ManyToOne
    @JoinColumn(name="knowledgepointID")
    private Knowledgepoint knowledgepoint;

    private String question;
    private String questionFileName;
    private String text1;
    private String text2;
    private String text3;
    private String text4;
    private String answer;
    private String answerFileName;
    private String description;
    private int difficulty;
    @Transient
    private int chosed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public Knowledgepoint getKnowledgepoint() {
        return knowledgepoint;
    }

    public void setKnowledgepoint(Knowledgepoint knowledgepoint) {
        this.knowledgepoint = knowledgepoint;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestionFileName() {
        return questionFileName;
    }

    public void setQuestionFileName(String questionFileName) {
        this.questionFileName = questionFileName;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswerFileName() {
        return answerFileName;
    }

    public void setAnswerFileName(String answerFileName) {
        this.answerFileName = answerFileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getChosed() {
        return chosed;
    }

    public void setChosed(int chosed) {
        this.chosed = chosed;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", type=" + type +
                ", course=" + course +
                ", chapter=" + chapter +
                ", knowledgepoint=" + knowledgepoint +
                ", question='" + question + '\'' +
                ", questionFileName='" + questionFileName + '\'' +
                ", text1='" + text1 + '\'' +
                ", text2='" + text2 + '\'' +
                ", text3='" + text3 + '\'' +
                ", text4='" + text4 + '\'' +
                ", answer='" + answer + '\'' +
                ", answerFileName='" + answerFileName + '\'' +
                ", description='" + description + '\'' +
                ", difficulty=" + difficulty +
                ", chosed=" + chosed +
                '}';
    }
}
