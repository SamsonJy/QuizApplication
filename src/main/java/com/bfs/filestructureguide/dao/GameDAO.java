package com.bfs.filestructureguide.dao;


import com.bfs.filestructureguide.command.ScoresWrapper;
import com.bfs.filestructureguide.domain.Game;

public interface GameDAO extends EntityDAO<Game> {

    public Integer checkCorrectAnswer(int answerId);

    public Game createNewGame(int quizId, int userId);

    public int createUserAnswer(int gameId, int questionId, int answerId);

    public ScoresWrapper loadBestScores(int quizId);

    public ScoresWrapper userBestScores(int quizId, int userId);

}
