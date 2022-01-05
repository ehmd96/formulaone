package com.nid.test.formulaone.repository;

import com.nid.test.formulaone.domain.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BaseRepository<T extends Base> extends JpaRepository<T, Integer> {

    List<T> findAll();

    Optional<T> findById(Integer id);

    List<T> findByNameContainsIgnoreCase(String name);
    List<T> findByDetailsContainsIgnoreCase(String keyword);
}
