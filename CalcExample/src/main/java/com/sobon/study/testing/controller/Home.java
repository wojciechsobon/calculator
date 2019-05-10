package com.sobon.study.testing.controller;
import com.sobon.study.testing.logic.Calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greeting(@RequestParam(value="Liczba1", required=false)  String number1,
                           @RequestParam(value = "Liczba2", required = false) String number2,
                           @RequestParam(value = "mathType", required = false) String mathType,
                           Model model) {
        if (number1 != null && number2 != null && mathType != null) {
            switch (mathType) {
                case "Dodaj" :
                    model.addAttribute("result", Calculator.add(number1, number2));
                    break;
                case "Odejmij" :
                    model.addAttribute("result", Calculator.subtract(number1, number2));
                    break;
                case "Podziel" :
                    model.addAttribute("result", Calculator.divide(number1, number2));
                    break;
                default:
                    throw new RuntimeException("Unsupported operation");

            }
        }
        return "index";
    }


}