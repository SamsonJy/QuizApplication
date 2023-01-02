package com.bfs.filestructureguide.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class EntityImpl implements Entity{

    protected int id;


    @Override
    public int getId() {

        return id;
    }

    @Override
    public void setId(int id) {

        this.id = id;

    }
}
