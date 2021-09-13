package com.enghelper.enghelperserver.dto.response;

import com.enghelper.enghelperserver.model.Word;
import lombok.Data;

@Data
public class WordDto {

    private String content;

    private String translate;

    private String transcription;

    private String example;

    private String definition;

    public WordDto() {}

    public WordDto(Word word) {
        this.content = word.getContent();
        this.translate = word.getTranslate();
        this.transcription = word.getTranscription();
        this.example = word.getExample();
        this.definition = word.getDefinition();
    }

    public static WordDto wordToWordDto(Word word) {
        WordDto wordDto = new WordDto();
        wordDto.setContent(word.getContent());
        wordDto.setTranslate(word.getTranslate());
        wordDto.setTranscription(word.getTranscription());
        wordDto.setExample(word.getExample());
        wordDto.setDefinition(word.getDefinition());
        return wordDto;
    }
}
