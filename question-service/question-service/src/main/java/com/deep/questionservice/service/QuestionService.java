package com.deep.questionservice.service;

import com.deep.questionservice.dao.QuestionDao;
import com.deep.questionservice.exception.NotFoundException;
import com.deep.questionservice.model.Question;
import com.deep.questionservice.pojo.QuestionPojo;
import com.deep.questionservice.pojo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {


    @Autowired
    private QuestionDao questionDao;
    public List<Question> getAllQuestions() {

        List<Question> questionsList = questionDao.findAll();
        if (questionsList==null){
            throw new NotFoundException("data not found or data not available in database");
        }
        return questionsList;
    }

    public List<Question> getAllQuestionsByCategory(String category) {

        List<Question> questionByCategoryList = questionDao.getQuestionsByCategory(category).get();
        if (questionByCategoryList==null){
            throw new NotFoundException("No any list or data available");
        }

        return questionByCategoryList;

    }

    public Question createQuestion(Question question) {

        Question question1 = new Question();

        question1.setQuestionTitle(question.getQuestionTitle());
        question1.setOption1(question.getOption1());
        question1.setOption2(question.getOption2());
        question1.setOption3(question.getOption3());
        question1.setOption4(question.getOption4());
        question1.setCorrectAnswer(question.getCorrectAnswer());
        question1.setDifficultyLevel(question.getDifficultyLevel());
        question1.setCategory(question.getCategory());


        Question savedQuestion = questionDao.save(question1);

        return savedQuestion;
    }

    public Question updateQuestion( Integer id,Question question) {

        Question questionUpdate = questionDao.findById(id).get();
        if (questionUpdate==null){
            throw new NotFoundException("id not found");
        }

        questionUpdate.setQuestionTitle(question.getQuestionTitle());
        questionUpdate.setOption1(question.getOption1());
        questionUpdate.setOption2(question.getOption2());
        questionUpdate.setOption3(question.getOption3());
        questionUpdate.setOption4(question.getOption4());
        questionUpdate.setCorrectAnswer(question.getCorrectAnswer());
        questionUpdate.setDifficultyLevel(question.getDifficultyLevel());
        questionUpdate.setCategory(question.getCategory());

        Question updatedQuestion = questionDao.save(questionUpdate);

        return updatedQuestion;

    }

    public String deleteQuestion(int id){
        Optional<Question> question = questionDao.findById(id);

        if (!question.isPresent()){
            throw new NotFoundException("Id not present");
        }
        questionDao.delete(question.get());

        return "question deleted";
    }


    public List<Integer> getQuestionForQuiz(String category, Integer numOfQuestions) {

        List<Integer> questions = questionDao.findRandomQuestionsByCategory(category,numOfQuestions);

        return questions;
    }

    public List<QuestionPojo> getQuestionById(List<Integer> questionsId) {

//        List<Question> questions = questionDao.findAllById(questionsId);
        List<QuestionPojo> questionPojos = new ArrayList<>();
        List<Question> questions = new ArrayList<>();

        for (Integer id : questionsId){
            questions.add(questionDao.findById(id).get());
        }

        for ( Question question : questions){
            QuestionPojo questionPojo = new QuestionPojo();
            questionPojo.setId(question.getId());
            questionPojo.setQuestionTitle(question.getQuestionTitle());
            questionPojo.setOption1(question.getOption1());
            questionPojo.setOption2(question.getOption2());
            questionPojo.setOption3(question.getOption3());
            questionPojo.setOption4(question.getOption4());

            questionPojos.add(questionPojo);
        }
        return questionPojos;
    }


    public Integer getScore(List<Response> responses) {

        int score=0;

        for(Response response : responses){
               Question question = questionDao.findById(response.getId()).get();
            if (response.getAnswers().equals(question.getCorrectAnswer()))
                score++;

        }
        return score;
    }
}

