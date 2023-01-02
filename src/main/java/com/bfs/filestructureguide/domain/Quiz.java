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
import java.sql.Timestamp;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz extends EntityImpl implements Serializable{

    private String name;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private String about;
    private ArrayList<Question> questions;
    private ArrayList<Game> games;


    @Override
    public String toString() {
        return "Quiz{" + "name=" + name + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", about=" + about + ", questions=" + questions + ", games=" + games + '}';
    }
  
    
}
