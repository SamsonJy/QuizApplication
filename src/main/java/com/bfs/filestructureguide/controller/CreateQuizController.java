/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bfs.filestructureguide.controller;


import com.bfs.filestructureguide.command.QuizCommand;
import com.bfs.filestructureguide.domain.Answer;
import com.bfs.filestructureguide.domain.Quiz;
import com.bfs.filestructureguide.service.AnswerService;
import com.bfs.filestructureguide.service.QuestionService;
import com.bfs.filestructureguide.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CreateQuizController {

    @Autowired
    QuizService quizService;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;
    
    int quizId;

    @RequestMapping(value = "admin/createQuiz", method = RequestMethod.POST)
    @ResponseBody
    public Quiz handleCreateQuiz(@RequestBody QuizCommand cmd) {
        try {
            if(cmd.getQuiz().getId() == 0){
                quizId = quizService.createQuiz(cmd.getQuiz());
                cmd.getQuestion().setQuiz_id(quizId);
                int questionId = questionService.createQuestion(cmd.getQuestion());
                cmd.getAnswers().forEach((Answer answer) -> {
                    answer.setQuestion_id(questionId);
                    answerService.createAnswer(answer);
                });
            }else{
                cmd.getQuestion().setQuiz_id(cmd.getQuiz().getId());
                int questionId = questionService.createQuestion(cmd.getQuestion());
                cmd.getAnswers().forEach((Answer answer) -> {
                    answer.setQuestion_id(questionId);
                    answerService.createAnswer(answer);
                });
            }
        } catch (DuplicateKeyException ex) {
            ex.printStackTrace();
        }
        return cmd.getQuiz();
    }
}
