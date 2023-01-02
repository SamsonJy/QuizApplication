package com.bfs.filestructureguide.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User extends EntityImpl implements Serializable {

    private String name;
    private String username;
    private String password;
    private Integer role;
    private ArrayList<Game> games;
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", username=" + username + ", role=" + role + '}';
    }
}
