package com.bfs.filestructureguide.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserAnswer extends EntityImpl implements Serializable {
    private int game_id;
    private int question_id;
    private int answer_id;

}
