package com.deep.quizservice.service;

import com.deep.quizservice.dao.QuizDao;
import com.deep.quizservice.exception.NotFoundException;
import com.deep.quizservice.model.Quiz;
import com.deep.quizservice.pojo.QuestionPojo;
import com.deep.quizservice.pojo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    public Quiz createQuiz(String category, int numQ, String title) {

        List<Integer> questions = questionDao.findRandomQuestionsByCategory(category,numQ);
        if (questions.isEmpty()){
            throw new NotFoundException("Questions not available in the database");
        }

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
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

    public List<QuestionPojo> setQuizQuestions(Integer id){

//        Optional<Quiz> quiz = quizDao.findById(id);
//        if (quiz.isEmpty()){
//            throw new NotFoundException("Quiz not found");
//        }
//        List<Question> questionsFromDB = quiz.get().getQuestions();
//
        List<QuestionPojo> questionsForUsers = new ArrayList<>();
//
//        for (Question q : questionsFromDB){
//            QuestionPojo qPojo = new QuestionPojo();
//            qPojo.setId(q.getId());
//            qPojo.setQuestionTitle(q.getQuestionTitle());
//            qPojo.setOption1(q.getOption1());
//            qPojo.setOption2(q.getOption2());
//            qPojo.setOption3(q.getOption3());
//            qPojo.setOption4(q.getOption4());
//
//            questionsForUsers.add(qPojo);
//        }
        return questionsForUsers;
    }

    public Integer calculateResult(int id, List<Response> responses) {
//        Optional<Quiz> quiz = quizDao.findById(id);
//        if (quiz.isEmpty()){
//            throw new NotFoundException("Quiz not found");
//        }
//        List<Question> questions = quiz.get().getQuestions();
//
        int score=0;
//        int i=0;
//        for(Response response : responses){
//
//            if (response.getAnswers().equals(questions.get(i).getCorrectAnswer()))
//                score++;
//            i++;
//        }
        return score;

    }
}
