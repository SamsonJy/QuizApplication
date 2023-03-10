package com.bfs.filestructureguide.controller;


import com.bfs.filestructureguide.dao.UserDAO;
import com.bfs.filestructureguide.domain.User;
import com.bfs.filestructureguide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
public class EditDeleteUser {

    @Autowired
    UserService userService;

    @Autowired
    UserDAO userDAO;

    @RequestMapping(value = "admin/userList")
    public String adminQUserList(Model m) {
        ArrayList<User> users = (ArrayList<User>) userService.getUserList();
        m.addAttribute("userList", users);
        return "userListAdmin"; // JSP view
    }

    @PostMapping(value = "admin/userDel")
    public @ResponseBody void deleteUser(@RequestParam Integer id) {
        try {
            System.out.println(id);
            userService.deleteUser(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @PostMapping(value = "admin/editUser")
    @ResponseBody
    public void handleEditUser(@RequestBody User user) {
        try {
            userDAO.update(user);
        } catch (DuplicateKeyException ex) {
            ex.printStackTrace();
        }
    }
}
