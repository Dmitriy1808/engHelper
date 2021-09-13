package com.enghelper.enghelperserver.service;

import com.enghelper.enghelperserver.model.Word;
import com.enghelper.enghelperserver.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    WordRepository wordRepository;

//    @Override
//    public void createWord(String content, String translate, String transcription, String example, String definition) {
//         wordRepository.save(new Word(content, translate, transcription, example, definition));
//    }

    @Override
    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }

    @Override
    public Optional<Word> getWordById(Long id) {
        return wordRepository.findById(id);
    }

    @Override
    public void createWord(Word word) {
        wordRepository.save(word);
    }

    @Override
    public void updateWord(Word word) {
        Word wordToSave = new Word();
        wordToSave.setId(word.getId());
        wordToSave.setContent(word.getContent());
        wordToSave.setTranslate(word.getTranslate());
        wordToSave.setTranscription(word.getTranscription());
        wordToSave.setExample(word.getExample());
        wordToSave.setDefinition(word.getDefinition());
        wordRepository.save(wordToSave);
    }

    @Override
    public void deleteWordById(Long id) {
        Word word = wordRepository.getById(id);
        wordRepository.delete(word);
    }
}
