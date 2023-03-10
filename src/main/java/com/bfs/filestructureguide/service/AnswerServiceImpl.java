/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bfs.filestructureguide.service;

import com.bfs.filestructureguide.dao.AnswerDAO;
import com.bfs.filestructureguide.dao.BaseDAO;
import com.bfs.filestructureguide.domain.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AnswerServiceImpl extends BaseDAO implements AnswerService {

    @Autowired
    private AnswerDAO answerDAO;
    
    @Autowired
    QuestionService questionService;
    
    @Autowired
    QuizService quizService;

    @Override
    public int createAnswer(Answer a) {
        try {
            this.answerDAO.save(a);
        } catch (SQLException ex) {
            Logger.getLogger(AnswerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a.getId();
    }

    @Override
    public ArrayList<Answer> getAnswerList() {
        ArrayList<Answer> answers = this.answerDAO.findAll();
        return answers;
    }

    @Override
    public Answer getAnswerById(Integer id) {
        Answer answer = this.answerDAO.findById(id);
        return answer;
    }

    @Override
    public void updateAnswer(Answer a) {
        this.answerDAO.update(a);
    }

    @Override
    public ArrayList<Answer> getAnswerByQuestion(Integer id) {
        ArrayList<Answer> ans = this.answerDAO.getAnswersByQuestionId(id);
        return ans;
    }

    @Override
    public void updateAnswers(List<Answer> answers) {
        
        answers.forEach((Answer answer) -> {
            updateAnswer(answer);
        });
    }

}
