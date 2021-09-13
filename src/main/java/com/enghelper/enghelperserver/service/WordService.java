package com.enghelper.enghelperserver.service;

import com.enghelper.enghelperserver.model.Word;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface WordService {

//    void createWord(String content, String translate, String transcription, String example, String definition);

    List<Word> getAllWords();

    Optional<Word> getWordById(@NonNull Long id);

    void createWord(Word word);

    void updateWord(Word word);

    void deleteWordById(Long id);

}
