package com.bfs.filestructureguide.controller;


import com.bfs.filestructureguide.command.ProcessQuiz;
import com.bfs.filestructureguide.command.QuizFormCommand;
import com.bfs.filestructureguide.domain.Game;
import com.bfs.filestructureguide.domain.User;
import com.bfs.filestructureguide.service.AnswerService;
import com.bfs.filestructureguide.service.GameService;
import com.bfs.filestructureguide.service.QuestionService;
import com.bfs.filestructureguide.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
public class QuizController {

    @Autowired
    QuizService quizService;

    @Autowired
    GameService gameService;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    @GetMapping(value = "user/quizStart")
    public ModelAndView quiz(HttpSession session, @RequestParam("id") Integer id) {
        User user = (User) session.getAttribute("user");
        QuizFormCommand cmd = new QuizFormCommand();
        Game game = gameService.startNewGame(user.getId(), id);
        cmd.setQuiz(quizService.getQuizById(id));
        cmd.setQuestions(cmd.getQuiz().getQuestions());
        ModelAndView modelAndView = new ModelAndView("quiz");
        modelAndView.addObject("cmd", cmd);
        session.setAttribute("game", game);
        return modelAndView;
    }


    @RequestMapping(value = "user/processQuiz", method = RequestMethod.POST)
    public ModelAndView processQuiz(@ModelAttribute("cmd") ProcessQuiz cmd, HttpSession session) throws Exception {
        Game game = (Game) session.getAttribute("game");  
        game.setScore(gameService.checkCorrectAnswer(cmd.getAnswers()));
        gameService.updateGame(game);
        String score = gameService.processScore(cmd.getQuestions(), cmd.getAnswers());
        session.removeAttribute("game");
        return new ModelAndView("processQuiz", "score", score);
    }
}
