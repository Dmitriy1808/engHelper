package com.enghelper.enghelperserver.controller;

import com.enghelper.enghelperserver.dto.response.TestSuccessResponse;
import com.enghelper.enghelperserver.dto.response.WordDto;
import com.enghelper.enghelperserver.model.Word;
import com.enghelper.enghelperserver.repository.WordRepository;
import com.enghelper.enghelperserver.service.WordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(path = "/word")
@RestController
public class WordController {

//    @Autowired
//    private WordServiceImpl wordService;
//
//    @Autowired
//    private WordRepository wordRepository;

    private final WordServiceImpl wordService;

    private final WordRepository wordRepository;

    @Autowired
    WordController(WordServiceImpl wordService,
                   WordRepository wordRepository) {
        this.wordService = wordService;
        this.wordRepository = wordRepository;
    }

    @PostMapping(path = "/create")
    @ResponseBody
    public ResponseEntity<Object> createWord(@RequestBody Word word) {
        wordRepository.save(word);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteWord(@PathVariable Long id) {
        wordService.deleteWordById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public ResponseEntity<?> updateWord(@RequestBody Word word) {
        wordService.updateWord(word);
        return ResponseEntity.ok().build();
//        return wordRepository.save(word);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<?> getWordById(@PathVariable Long id) {
        Word word = wordService.getWordById(id)
                .orElse(null);
        return ResponseEntity.ok(WordDto.wordToWordDto(word));
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public ResponseEntity<?> getAllWords() {
        List<Word> words = wordService.getAllWords();
        List<WordDto> wordDtoList = words.stream().map(word -> WordDto.wordToWordDto(word)).collect(Collectors.toList());
        return ResponseEntity.ok(wordDtoList);
    }

    @GetMapping(value = "/test")
    @ResponseBody
    public ResponseEntity<Object> hi(@RequestParam String string) {
//        return "Test, " + string;
        return ResponseEntity.ok(new TestSuccessResponse(string));
    }

}
