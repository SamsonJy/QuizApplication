/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bfs.filestructureguide.service;


import com.bfs.filestructureguide.domain.Answer;

import java.util.ArrayList;
import java.util.List;

public interface AnswerService {

    public int createAnswer(Answer a);

    public ArrayList<Answer> getAnswerList();

    public Answer getAnswerById(Integer id);

    public ArrayList<Answer> getAnswerByQuestion(Integer id);

    public void updateAnswer(Answer a);
    
    public void updateAnswers (List<Answer> answers);       
    
}
