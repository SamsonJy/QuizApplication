/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bfs.filestructureguide.service;


import com.bfs.filestructureguide.command.ScoresWrapper;
import com.bfs.filestructureguide.dao.BaseDAO;
import com.bfs.filestructureguide.dao.GameDAO;
import com.bfs.filestructureguide.domain.Answer;
import com.bfs.filestructureguide.domain.Game;
import com.bfs.filestructureguide.domain.Question;
import com.bfs.filestructureguide.domain.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class GameServiceImpl extends BaseDAO implements GameService {

    @Autowired
    private GameDAO gameDAO;
    
    @Autowired
    private QuizService quizService;

    @Override
    public void updateGame(Game g) {
        this.gameDAO.update(g);
    }

    @Override
    public Game startNewGame(int userId, int quizId) {
        Game g = this.gameDAO.createNewGame(quizId, userId);
        return g;
    }

    @Override
    public int checkCorrectAnswer(ArrayList<Answer> answers) {
        int numCorrectAnswers = 0;
        numCorrectAnswers = answers.stream().map((answer) -> this.gameDAO.checkCorrectAnswer(answer.getId())).map((i) -> i).reduce(numCorrectAnswers, Integer::sum);
        return numCorrectAnswers;
    }

    @Override
    public int createUserAnswer(int gameId, int questionId, int answerId) {
        int i = this.gameDAO.createUserAnswer(gameId, questionId, answerId);
        return i;
    }

    @Override
    public String processScore(ArrayList<Question> quest, ArrayList<Answer> ans) {
        String completedQuiz;
        int total = quest.size();
        int numCorrectAnswers;       
        numCorrectAnswers = checkCorrectAnswer(ans);
        return completedQuiz = "Congratulations your score is " + numCorrectAnswers + " / " + total;
    }

    @Override
    public ArrayList<ScoresWrapper> highScores() {
        ArrayList<ScoresWrapper> sws = new ArrayList<>();
        ScoresWrapper sw;
        ArrayList<Quiz> quizes = (ArrayList<Quiz>) quizService.getQuizList();
        for(Quiz quiz: quizes){
            sw = gameDAO.loadBestScores(quiz.getId());
            sw.setQuiz(quiz);
            sws.add(sw);
        }
        return sws;
    }
    
    
    @Override
    public ArrayList<ScoresWrapper> userHighScores(int userId) {
        ArrayList<ScoresWrapper> sws = new ArrayList<>();
        ScoresWrapper sw;
        ArrayList<Quiz> quizes = (ArrayList<Quiz>) quizService.getQuizList();
        for(Quiz quiz: quizes){
            sw = gameDAO.userBestScores(quiz.getId(), userId);
            sw.setQuiz(quiz);
            sws.add(sw);
        }
        return sws;
    }

}
