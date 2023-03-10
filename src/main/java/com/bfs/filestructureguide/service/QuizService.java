/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bfs.filestructureguide.service;


import com.bfs.filestructureguide.domain.Quiz;

import java.util.List;


public interface QuizService {
    
    public int createQuiz(Quiz q);

    public List<Quiz> getQuizList();
    
    public List<Quiz> getQuizListWithQuestions();

    public Quiz getQuizById(Integer id);

    public void updateQuiz(Quiz q);

    public void deleteQuiz(Integer id);
    
    public void loadQuestions(Quiz q);
    
    public void loadGames(Quiz q);
    

}
