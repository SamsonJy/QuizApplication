package com.bfs.filestructureguide.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScoresCommand {

    private int id;

    private int quizId;

    private Timestamp endTime;

    private String username;

    private int score;



    @Override
    public String toString() {
        return "ScoresCommand{" + "id=" + id + ", quizId=" + quizId + ", endTime=" + endTime + ", username=" + username + ", score=" + score + '}';
    }
    
}
