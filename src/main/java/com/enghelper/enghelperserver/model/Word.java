package com.enghelper.enghelperserver.model;

import javax.persistence.*;

@Entity
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String content;

    @Column
    private String translate;

    @Column
    private String transcription;

    @Column
    private String example;

    @Column
    private String definition;

    public Word() {
    }

    public Word(Long id,
                String content,
                String translate,
                String transcription,
                String example,
                String definition) {
        this.id = id;
        this.content = content;
        this.translate = translate;
        this.transcription = transcription;
        this.example = example;
        this.definition = definition;
    }

    public Word(String content,
                String translate,
                String transcription,
                String example,
                String definition) {
        this.content = content;
        this.translate = translate;
        this.transcription = transcription;
        this.example = example;
        this.definition = definition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", translate='" + translate + '\'' +
                ", transcription='" + transcription + '\'' +
                ", example='" + example + '\'' +
                ", definition='" + definition + '\'' +
                '}';
    }
}
