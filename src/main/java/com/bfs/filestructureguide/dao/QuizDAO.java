/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bfs.filestructureguide.dao;



import com.bfs.filestructureguide.domain.Game;
import com.bfs.filestructureguide.domain.Question;
import com.bfs.filestructureguide.domain.Quiz;

import java.util.ArrayList;

public interface QuizDAO extends EntityDAO<Quiz>{
    
    public abstract ArrayList<Question> loadQuestions(Quiz q);
    
    public abstract ArrayList<Game> loadGames(Quiz q);
    
    
}
