package com.iohim.shopbook.controller;

import com.iohim.shopbook.model.User;
import com.iohim.shopbook.service.UsersServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class UsersController {

   private final UsersServiceImp usersService;

   @Autowired
    public UsersController(UsersServiceImp usersService) {
       this.usersService = usersService;
    }


    /**
     * Метод получения всех Users(пользователей).
     */
    @GetMapping
    public String index(Model model) {
       List<User> allUsers = usersService.findAll();
       model.addAttribute( "allUsers", allUsers);
        return "/all-users";
    }


    /**
     * Метод получения User(пользователя) по его айди.
     */
    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute( "user", usersService.findById(id));
        return "/show";
    }


    /**
     * Метод возврощает нового создоного пользовотеля из БД
     */
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "/new";
    }


    /**
     * Метод кладёт создоного пользователя в БД
     */
    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/new";
        usersService.save(user);
        return "redirect:/";
    }


    /**
     * Метод возврощает обновлёного юзера
     */
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", usersService.findById(id));
        return "/edit";
    }


    /**
     * Метод обновления юзераб, делает редирект на метод edit
     */
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") Long id) {
        if (bindingResult.hasErrors())
            return "/edit";

        usersService.update(id, user);
        return "redirect:/";
    }


    /**
     * Метод удаления пользователя
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        usersService.delete(id);
        return "redirect:/";
    }
}
