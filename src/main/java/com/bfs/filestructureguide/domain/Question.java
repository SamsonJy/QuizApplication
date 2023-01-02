/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bfs.filestructureguide.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question extends EntityImpl implements Serializable{

    private int quiz_id;
    private String title;
    private String text;
    private ArrayList<Answer> answers;
    private ArrayList<UserAnswer> userAnswer;





    @Override
    public String toString() {
        return "Question{" + "quiz_id=" + quiz_id + ", title=" + title + ", text=" + text + ", answers=" + answers + ", userAnswer=" + userAnswer + '}';
    }
    
    
}
