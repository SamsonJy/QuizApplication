/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bfs.filestructureguide.RowMapper;



import com.bfs.filestructureguide.command.ScoresCommand;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ScoresRowMapper implements RowMapper<ScoresCommand> {

    @Override
    public ScoresCommand mapRow(ResultSet rs, int i) throws SQLException {
        ScoresCommand sc = new ScoresCommand();
        sc.setId(rs.getInt("id"));
        sc.setQuizId(rs.getInt("quiz_id"));
        sc.setEndTime(rs.getTimestamp("end_time"));
        sc.setUsername(rs.getString("username"));
        sc.setScore(rs.getInt("score"));
        return sc;
    }
    
}
