/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bfs.filestructureguide.command;



import com.bfs.filestructureguide.domain.Answer;
import com.bfs.filestructureguide.domain.Question;
import com.bfs.filestructureguide.domain.Quiz;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Setter
@Getter
public class QuizCommand {
                        
     private Quiz quiz;
    
     private Question question;
    
    private ArrayList<Answer> answers;



    @Override
    public String toString() {
        return "QuizCommand{" + "quiz=" + quiz + ", question=" + question + ", answers=" + answers + '}';
    }
    
}
