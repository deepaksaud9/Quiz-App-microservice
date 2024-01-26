package com.deep.quizservice.feign;

import com.deep.quizservice.pojo.QuestionPojo;
import com.deep.quizservice.pojo.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizFeignInterface {

    @GetMapping("/api/v1/question/generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String category, @RequestParam Integer numOfQuestions);

    @PostMapping("/api/v1/question/getQuestions")
    public ResponseEntity<List<QuestionPojo>> getQuestionsById(@RequestBody List<Integer> questionsId);

    @PostMapping("/api/v1/question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);


}
