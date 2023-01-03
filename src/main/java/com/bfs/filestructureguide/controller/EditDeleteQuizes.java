/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bfs.filestructureguide.controller;


import com.bfs.filestructureguide.command.QuizFormCommand;
import com.bfs.filestructureguide.domain.Question;
import com.bfs.filestructureguide.domain.Quiz;
import com.bfs.filestructureguide.service.AnswerService;
import com.bfs.filestructureguide.service.QuestionService;
import com.bfs.filestructureguide.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;


@Controller
public class EditDeleteQuizes {

    @Autowired
    QuizService quizService;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    @GetMapping(value = "admin/quizList")
    public String adminQuizList(Model m, HttpSession session) {
        ArrayList<Quiz> quizes = (ArrayList<Quiz>) quizService.getQuizList();
        m.addAttribute("quizList", quizes);
        return "quizListAdmin"; // JSP view
    }

    @PostMapping(value = "admin/quizDel")
    public @ResponseBody
    void deleteQuiz(@RequestParam Integer id) {
        try {
            System.out.println(id);
            quizService.deleteQuiz(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @GetMapping(value = "admin/quizEdit")
    @ResponseBody
    public ArrayList<Question> editQuizForm(@RequestParam("quizId") Integer id) {
        ArrayList<Question> questions = (ArrayList<Question>) questionService.questionsInQuiz(id);
        return questions;
    }

    @PostMapping(value = "admin/editQuiz")
    @ResponseBody
    public void handleEditQuiz(@RequestBody QuizFormCommand cmd) {
        try {
            quizService.updateQuiz(cmd.getQuiz());
            questionService.updateQuestions(cmd.getQuestions());
            answerService.updateAnswers(cmd.getAnswers());
        } catch (DuplicateKeyException ex) {
            ex.printStackTrace();
        }
    }
}