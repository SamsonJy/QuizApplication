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


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Answer extends EntityImpl implements Serializable{



    private int question_id;
    private String text;
    private int correct;



    @Override
    public String toString() {
        return "Answer{" + "question_id=" + question_id + ", text=" + text + ", correct=" + correct + '}';
    }
    
    
    
}
