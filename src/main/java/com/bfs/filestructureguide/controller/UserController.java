package com.bfs.filestructureguide.controller;

import com.bfs.filestructureguide.command.LoginCommand;
import com.bfs.filestructureguide.command.ScoresWrapper;
import com.bfs.filestructureguide.command.UserCommand;
import com.bfs.filestructureguide.domain.Quiz;
import com.bfs.filestructureguide.domain.User;
import com.bfs.filestructureguide.service.GameService;
import com.bfs.filestructureguide.service.QuizService;
import com.bfs.filestructureguide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private QuizService quizService;

    @Autowired
    private GameService gameService;


    @GetMapping(value = {"/", "/index1"})
    public String index(Model m) {
        m.addAttribute("command", new LoginCommand());
        m.addAttribute("command1", new UserCommand());
        return "index1"; // JSP - /WEB-INF/view/index.jsp
    }

    @PostMapping(value = "/login")
    public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
        try {
            User loggedInUser = userService.login(cmd.getUsername(), cmd.getPassword());
            if (loggedInUser == null) {
                m.addAttribute("errorMsg", "Login failed, please try again");
                return "index1";
            } else {
                if (loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
                    addUserInSession(loggedInUser, session);
                    return "redirect:admin/dashboard";
                } else if (loggedInUser.getRole().equals(UserService.ROLE_USER)) {
                    addUserInSession(loggedInUser, session);
                    return "redirect:user/home";
                } else {
                    m.addAttribute("err", "INVALID USER ROLE");
                    return "index1";
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "index1";
        }
    }

    @PostMapping(value = "/register")
    public ModelAndView registerUser(@ModelAttribute("command1") User user) {
        try {
            user.setRole(UserService.ROLE_USER);
            userService.registration(user);
            return new ModelAndView("index1", "successMsg", "Registration complete, please login in"); //JSP
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            return new ModelAndView("index1", "errorMsg", "Registration failed, username already exist please try another username");
        }
    }

    @RequestMapping(value = {"/logout"})
    public String logout(HttpSession session) {
        session.invalidate();
        return "index1";
    }


    private void addUserInSession(User u, HttpSession session) {
        session.setAttribute("user", u);
        session.setAttribute("userId", u.getId());
        session.setAttribute("role", u.getRole());
    }

    @GetMapping(value = {"/user/home"})
    public String userHomePage(Model m) {
        Collection<Quiz> quizes = quizService.getQuizList();
        m.addAttribute("quizList", quizes);
        return "userHomePage";
    }

    @GetMapping(value = {"/admin/dashboard"})
    public String adminDashboard() {
        return "dashboard_admin";
    }

    @GetMapping(value = "/user/info")
    public ModelAndView userInfo(WebRequest request, HttpSession session, Model m) {
        User user = (User) session.getAttribute("user");
        ArrayList<ScoresWrapper> sws = gameService.userHighScores(user.getId());
        m.addAttribute("sws", sws);
        return new ModelAndView("userInfoPage", "user", user);
    }


    @GetMapping(value = "/user/about")
    public String userAbout(){
        return "aboutInfo";
    }
}
