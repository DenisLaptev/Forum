package com.nx.forum_project.web.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public abstract class CRUDController<E, K> {

    public static final String AVATAR_URL_MVC = "ui/avatar";
    public static final String AVATAR_NAME = "avatar";
    public static final String MESSAGE_URL_MVC = "ui/message";
    public static final String MESSAGE_NAME = "message";
    public static final String ROLE_URL_MVC = "ui/role";
    public static final String ROLE_NAME = "role";
    public static final String SECTION_URL_MVC = "ui/section";
    public static final String SECTION_NAME = "section";
    public static final String TOPIC_URL_MVC = "ui/topic";
    public static final String TOPIC_NAME = "topic";
    public static final String USER_URL_MVC = "ui/user";
    public static final String USER_NAME = "user";

    abstract String getEntityName();

    @GetMapping("/list")
    public String showList() {

        return getEntityName() + "/list";
    }

    @GetMapping("/read/{id}")
    public String showRead(@PathVariable String id, Model model) {

        model.addAttribute("id", id);

        return getEntityName() + "/read";
    }

    @GetMapping("/create")
    public String showCreate() {

        return getEntityName() + "/create";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable String id, Model model) {

        model.addAttribute("id", id);

        return getEntityName() + "/update";
    }
}
