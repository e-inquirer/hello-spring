package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ahmed on 3/16/17.
 */
@Controller
@RequestMapping("hello")
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index() {
        return "Hello World";
    }

    @RequestMapping(value = "goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye";
    }
}
