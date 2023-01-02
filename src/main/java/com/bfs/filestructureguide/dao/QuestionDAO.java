/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bfs.filestructureguide.dao;


import com.bfs.filestructureguide.domain.Answer;
import com.bfs.filestructureguide.domain.Question;

import java.util.ArrayList;


public interface QuestionDAO extends EntityDAO<Question>{
    
    public ArrayList<Answer> loadPossibleAnswer(Question q);
    
    public ArrayList<Question> findQuestionByQuizId (Integer id);
    
}
