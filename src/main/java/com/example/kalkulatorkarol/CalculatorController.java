package com.example.kalkulatorkarol;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/calculate")
    public String calculate(
            @RequestParam double num1,
            @RequestParam double num2,
            @RequestParam String operation) {
        double result;
        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 == 0) {
                    return "Error: Division by zero!";
                }
                result = num1 / num2;
                break;
            default:
                return "Error: Unsupported operation!";
        }
        return "The result is: " + result;
    }
}
