package com.deep.questionservice.controller;

import com.deep.questionservice.dao.QuestionDao;
import com.deep.questionservice.model.Question;
import com.deep.questionservice.pojo.QuestionPojo;
import com.deep.questionservice.pojo.Response;
import com.deep.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {



    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionDao questionDao;

    @GetMapping("/getAllQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){

        List<Question> questions = questionService.getAllQuestions();
        return ResponseEntity.ok().body(questions);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){

        List<Question> questionsByCategory = questionService.getAllQuestionsByCategory(category);

        return ResponseEntity.ok().body(questionsByCategory);
    }

    @PostMapping("/add-question")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question){

        Question addQuestion = questionService.createQuestion(question);

        return new ResponseEntity(addQuestion, HttpStatus.CREATED);
    }

    @PutMapping("/update-question/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Integer id, @RequestBody Question question){

        Question questionUpdated = questionService.updateQuestion(id,question);

        return new ResponseEntity(questionUpdated, HttpStatus.OK);

    }

    @DeleteMapping("/delete-question/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id){

        String deleted = questionService.deleteQuestion(id);
        return ResponseEntity.ok().body(deleted);
    }

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String category, @RequestParam Integer numOfQuestions){

        List<Integer> totalQuestions = questionService.getQuestionForQuiz(category,numOfQuestions);

        return new ResponseEntity<>(totalQuestions, HttpStatus.OK);
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionPojo>> getQuestionsById(@RequestBody List<Integer> questionsId){

        List<QuestionPojo> questions = questionService.getQuestionById(questionsId);

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){

              Integer score = questionService.getScore(responses);

        return new ResponseEntity<>(score, HttpStatus.OK);
    }



}
