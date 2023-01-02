package com.bfs.filestructureguide.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class Game extends EntityImpl implements Serializable {

    private int user_id;
    private int quiz_id;
    private Timestamp start_time;
    private Timestamp end_time;
    private int score;
    private List<UserAnswer> userAnswer;

    public Game(int id, int user_id, int quiz_id, Timestamp start_time, Timestamp end_time, int score) {
        super(id);
        this.user_id = user_id;
        this.quiz_id = quiz_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.score = score;
        this.userAnswer = new ArrayList<>();
    }

    public void addUserAnswer(UserAnswer ua) {
        this.userAnswer.add(ua);
    }

    public void removeUserAnswer(UserAnswer ua) {
        this.userAnswer.remove(ua);
    }

    @Override
    public String toString() {
        return "Game{" + "user_id=" + user_id + ", quiz_id=" + quiz_id + ", start_time=" + start_time + ", end_time=" + end_time + ", score=" + score + ", userAnswer=" + userAnswer + '}';
    }
}
