package com.exam.entity.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Set;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long qId;
    private String title;
    @Column(length = 5000)
    private String description;
    private long maxMarks;
    private long numberOfQuestions;
    private boolean active=false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cId")
    private Category category;

    @OneToMany(mappedBy ="quiz",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Question> questions = new HashSet<>();
    public Quiz() {
    }

    public Quiz(long qId, String title, String description, long maxMarks, long numberOfQuestions) {
        this.qId = qId;
        this.title = title;
        this.description = description;
        this.maxMarks = maxMarks;
        this.numberOfQuestions = numberOfQuestions;
    }

    public long getqId() {
        return qId;
    }

    public void setqId(long qId) {
        this.qId = qId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(long maxMarks) {
        this.maxMarks = maxMarks;
    }

    public long getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(long numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
