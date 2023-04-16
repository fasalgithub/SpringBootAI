package com.example.springbootcuredemo.service;

import com.example.springbootcuredemo.dao.LeanerList;
import com.example.springbootcuredemo.dao.Learner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LearnerService {
    private static List<Learner> learnerList = new ArrayList<>();

    static
    {
        learnerList.add(new Learner(101, "Sathya", "Java"));
        learnerList.add(new Learner(102, "Fasal", "Java Script"));
        learnerList.add(new Learner(103, "Abi", "Python"));

    }

    public List<Learner> getAllMyLeaner() {
        return learnerList;
    }

    public Learner getMyLeaner(int id) {
        return learnerList
                .stream()
                .filter(learner1 -> (id == learner1.getLearnerId()))
                .findFirst()
                .orElse(new Learner());
    }

    public Learner addMyLeaner(Learner learner) {
        Optional<Learner> newLeaner = learnerList
                .stream()
                .filter(learner1 -> (learner.getLearnerId() == learner1.getLearnerId()))
                .findFirst();


        Learner insertedLeaner = new Learner();
        if (newLeaner.isPresent())
        {
            insertedLeaner = newLeaner.get();
            insertedLeaner.setLearnerId(learner.getLearnerId());
            insertedLeaner.setLearnerName(learner.getLearnerName());
            insertedLeaner.setLearnerTechnology(learner.getLearnerTechnology());

        }
        else
        {
            insertedLeaner.setLearnerId(learner.getLearnerId());
            insertedLeaner.setLearnerName(learner.getLearnerName());
            insertedLeaner.setLearnerTechnology(learner.getLearnerTechnology());
            learnerList.add(insertedLeaner);
        }
        return insertedLeaner;
    }

    public String removeMyLeaner(int id) {
        for (Learner learner : learnerList)
        {
            if (learner.getLearnerId() == id)
            {
                learnerList.remove(learner);
                break;
            }
        }
        return "Leaner Removed";
    }

    public LeanerList addMyLeaner(LeanerList list)
    {
        learnerList.addAll(list.getLearnerList());
        return list;

    }
    public List<Learner> addMyListLeaner(List<Learner> list)
    {
        learnerList.addAll(list);
        return list;

    }


}
