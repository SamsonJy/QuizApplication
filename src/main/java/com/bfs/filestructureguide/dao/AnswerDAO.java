/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bfs.filestructureguide.dao;


import com.bfs.filestructureguide.domain.Answer;

import java.util.ArrayList;

public interface AnswerDAO extends EntityDAO<Answer>{
    
    public ArrayList<Answer> getAnswersByQuestionId(Integer id);
    
    
    
}
