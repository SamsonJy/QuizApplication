/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bfs.filestructureguide.command;


import com.bfs.filestructureguide.domain.Quiz;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ScoresWrapper {
    
    private ArrayList<ScoresCommand> scoresCommand;
    
    private Quiz quiz;


    @Override
    public String toString() {
        return "ScoresWrapper{" + "scoresCommand=" + scoresCommand + ", quiz=" + quiz + '}';
    }
   
}
