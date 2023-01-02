/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bfs.filestructureguide.command;


import com.bfs.filestructureguide.domain.Answer;
import com.bfs.filestructureguide.domain.Question;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ProcessQuiz {
       
    private ArrayList<Question> questions;
    
    private ArrayList<Answer> answers;


    @Override
    public String toString() {
        return "ProcessQuiz{" + "questions=" + questions + ", answers=" + answers + '}';
    }
    
}
