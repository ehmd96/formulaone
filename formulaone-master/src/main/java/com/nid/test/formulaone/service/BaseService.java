package com.nid.test.formulaone.service;

import com.nid.test.formulaone.domain.Base;
import com.nid.test.formulaone.domain.Message;
import com.nid.test.formulaone.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaseService<T extends Base> {
    @Autowired
    private BaseRepository baseRepository;

    public Message add(T anything) {
        this.baseRepository.saveAndFlush(anything);
        String msg = anything.getClass().getSimpleName() + " of ID: " + anything.getId() + " successfully created !";
        return new Message(200, msg);
    }

    public List<T> retrieveAll() {
        return this.baseRepository.findAll();
    }

    public Optional<T> retrieveSingleById(Integer id) {
        return this.baseRepository.findById(id);
    }

    public List<T> retrieveByName(String name) {
        return this.baseRepository.findByNameContainsIgnoreCase(name);
    }

    public List<T> retrieveByDetails(String keyword) {
        return this.baseRepository.findByDetailsContainsIgnoreCase(keyword);
    }

    public Message update(T anything, Integer id) {
        Optional<T> optionalPrevious = this.baseRepository.findById(id);
        T previous = optionalPrevious.get();

        previous.setName(anything.getName());
        previous.setDetails(anything.getDetails());

        this.baseRepository.saveAndFlush(previous);

        String msg = anything.getClass().getSimpleName() + " of ID: " + anything.getId() + " successfully updated !";
        return new Message(200, msg);
    }

    public Message delete(Integer id) {
        Optional<T> anything = this.baseRepository.findById(id);
        this.baseRepository.deleteById(id);

        String msg = anything.get().getClass().getSimpleName() + " of ID: " + id + " successfully deleted !";
        return new Message(200, msg);
    }
}
