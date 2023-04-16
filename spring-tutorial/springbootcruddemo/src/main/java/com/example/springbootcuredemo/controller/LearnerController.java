package com.example.springbootcuredemo.controller;


import com.example.springbootcuredemo.dao.LeanerList;
import com.example.springbootcuredemo.dao.Learner;
import com.example.springbootcuredemo.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LearnerController {
    @Autowired
    private LearnerService learnerService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    @ResponseBody
    public String hiJava() {
        return "Hi Java";
    }

    @GetMapping(path = "/get-my-learners")
    public LeanerList getAllMyLearner()
    {
        LeanerList list = new LeanerList();
        list.setLearnerList(learnerService.getAllMyLeaner());
        return list;
    }

    @GetMapping(path = "/get-my-learner/{id}")
    public Learner getAllMyLearner(@PathVariable("id") int leanerId) {
        return learnerService.getMyLeaner(leanerId);
    }

    @DeleteMapping(path = "/remove-my-learner/{id}")
    public String removeMyLearner(@PathVariable("id") int leanerId) {
        return learnerService.removeMyLeaner(leanerId);
    }

    @PostMapping(path = "/add-my-learner")
    public Learner addMyLearner(@RequestBody Learner learner) {
        return learnerService.addMyLeaner(learner);
    }

    @PutMapping(path = "/update-my-learner")
    public Learner updateMyLeaner(@RequestBody Learner learner) {
        return learnerService.addMyLeaner(learner);
    }









    @PostMapping(path = "/add-my-learners")
    public LeanerList addAllMyLeaner(@RequestBody LeanerList list) {
        return learnerService.addMyLeaner(list);
    }

    @PostMapping(path = "/add-my-learners-List")
    public List<Learner> addAllMyLeaner(@RequestBody List<Learner> list) {
        return learnerService.addMyListLeaner(list);
    }


}
