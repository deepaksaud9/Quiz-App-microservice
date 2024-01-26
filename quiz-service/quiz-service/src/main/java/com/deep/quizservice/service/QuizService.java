package com.deep.quizservice.service;

import com.deep.quizservice.dao.QuizDao;
import com.deep.quizservice.exception.NotFoundException;
import com.deep.quizservice.feign.QuizFeignInterface;
import com.deep.quizservice.model.Quiz;
import com.deep.quizservice.pojo.QuestionPojo;
import com.deep.quizservice.pojo.Response;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    QuizFeignInterface quizInterface;

    public Quiz createQuiz( String title, String category, int numQ) {
//        System.out.println("create Quiz called");
        List<Integer> questions = quizInterface.getQuestionForQuiz(category,numQ).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsIds(questions);

        Quiz savedQuiz = quizDao.save(quiz);


        return savedQuiz;
    }

    public Quiz getQuizById(int id) {

        Quiz quiz = quizDao.findById(id).get();
        if (quiz == null) {

            throw new NotFoundException("Quiz of this " + id + "not found");
        }

        return quiz;
    }

    public List<QuestionPojo> getQuizQuestions(Integer id){

        Quiz quiz = quizDao.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionsIds();

        List<QuestionPojo> questions = quizInterface.getQuestionsById(questionIds).getBody();
        return questions;
    }

    public Integer calculateResult(int id, List<Response> responses) {
        Integer score = quizInterface.getScore(responses).getBody();
        return score;

    }
}
