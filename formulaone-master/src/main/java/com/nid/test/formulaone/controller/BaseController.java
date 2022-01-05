package com.nid.test.formulaone.controller;

import com.nid.test.formulaone.domain.Base;
import com.nid.test.formulaone.domain.Message;
import com.nid.test.formulaone.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class BaseController<T extends Base> {

    /*
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Message> handle(Exception ex, HttpServletRequest request, HttpServletResponse httpServletResponse){
        Message msg = new Message();
        msg.setCode(666);
        msg.setContent("Sorry, something went wrong with your api call. Please check your url or contact the related support !");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msg);
    }
     */

    @Autowired
    private BaseService baseService;

    @PostMapping("/create")
    public Message add(@RequestBody T anything) {
        return this.baseService.add(anything);
    }

    @GetMapping("/list/all")
    public List<T> getAll() {
        return this.baseService.retrieveAll();
    }

    @GetMapping("/profile/{id}")
    public Optional<T> getById(@PathVariable Integer id) {
        return this.baseService.retrieveSingleById(id);
    }

    @GetMapping("/list/name/{name}")
    public List<T> getByName(@PathVariable String name) {
        return this.baseService.retrieveByName(name);
    }

    @GetMapping("/list/keyword/{keyword}")
    public List<T> getByKeyword(@PathVariable String keyword) {
        return this.baseService.retrieveByDetails(keyword);
    }

    @PutMapping("/update/{id}")
    public Message update(@RequestBody T anything, @PathVariable Integer id) {
        return this.baseService.update(anything, id);
    }

    @DeleteMapping("/delete/{id}")
    public Message delete(@PathVariable Integer id) {
        return this.baseService.delete(id);
    }

}
