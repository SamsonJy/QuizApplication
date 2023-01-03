
package com.bfs.filestructureguide.controller;

import com.bfs.filestructureguide.command.ScoresWrapper;
import com.bfs.filestructureguide.service.GameService;
import com.bfs.filestructureguide.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class HighScoresController {
    
    @Autowired
    GameService gameService;
    
    @Autowired
    QuizService quizService;
    
    @GetMapping(value = {"user/highscores"})
    public ModelAndView highScores() {
        ArrayList<ScoresWrapper> sws = gameService.highScores();
        return new ModelAndView("highScorePage", "sws", sws);
    }
      
}
