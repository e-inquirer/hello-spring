package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ahmed on 3/16/17.
 */
@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request) {

        String name = request.getParameter("name");

        //Null check
        if (name == null) {
            name = "World";
        }
        return "Hello " + name;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select name='language'>" +
                   "<option value='English'>English</option>" +
                   "<option value='French'>French</option>" +
                   "<option value='German'>German</option>" +
                   "<option value='Latin'>Latin</option>" +
                   "<option value='Spanish'>Spanish</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!' />" +
        "</form>";

        return html;
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {
        String name = request.getParameter("name");
        String language = request.getParameter("language");
        String greeting = "Hello";

        switch (language) {
            case "English":
                greeting = "Hello ";
                break;
            case "French":
                greeting = "Bonjour ";
                break;
            case "German":
                greeting = "Halo ";
                break;
            case "Latin":
                greeting = "Salve ";
                break;
            case "Spanish":
                greeting = "Hola ";
                break;
        }

        String message = greeting + name;

        return message;
    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name) {
        return "Hello " + name;

    }

    @RequestMapping(value = "goodbye")
    public String goodbye() {
        return "redirect:/";
    }
}
