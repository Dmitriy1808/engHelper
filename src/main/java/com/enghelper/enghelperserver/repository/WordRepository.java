package com.enghelper.enghelperserver.repository;


import com.enghelper.enghelperserver.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    List<Word> findAll();

    Optional<Word> findById(@NonNull Long id);

    Optional<Word> findWordById(Long id);

    Optional<Word> findWordByContent(String content);

    Optional<Word> findWordByTranslate(String translate);

    void deleteById(@NonNull Long id);

}
