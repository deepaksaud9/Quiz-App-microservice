package com.deep.quizservice.controller;

import com.deep.quizservice.dto.QuizDto;
import com.deep.quizservice.model.Quiz;
import com.deep.quizservice.pojo.QuestionPojo;
import com.deep.quizservice.pojo.Response;
import com.deep.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @Autowired
    QuizDto quizDto;

    @PostMapping("/create")
    public ResponseEntity<Quiz> createQuiz(@RequestBody QuizDto quizDto){
        System.out.println("I am creat Quiz method (debugging) ");

        Quiz quiz = quizService.createQuiz(quizDto.getCategory(),quizDto.getNumberOfQuestion(), quizDto.getTitle());

        return new ResponseEntity<Quiz>(quiz, HttpStatus.OK);
    }

    @GetMapping("/get-quiz-details/{id}")
    public ResponseEntity<Quiz> getQuizDetailsById(@PathVariable int id){

        Quiz quiz = quizService.getQuizById(id);

        return new ResponseEntity<>(quiz, HttpStatus.OK);

    }

    @GetMapping("/get-quiz/{id}")
    public ResponseEntity<List<QuestionPojo>> getQuizById(@PathVariable int id){

        List<QuestionPojo> quiz = quizService.getQuizQuestions(id);

        return new ResponseEntity<>(quiz, HttpStatus.OK);

    }

    @PostMapping("/submit-answer/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response> responses){

        Integer score = quizService.calculateResult(id,responses);

        return new ResponseEntity<>(score,HttpStatus.OK);
    }

}
