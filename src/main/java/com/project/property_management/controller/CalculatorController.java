package com.project.property_management.controller;

import com.project.property_management.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

    @GetMapping("/add/{z}")
    public Double add(@RequestParam("num1") Double x, @RequestParam("num2") Double y,@PathVariable("z") Double z) {
        return x + y +z;
    }

    @GetMapping("/subtract/{x}/{y}")
    public Double subtract(@PathVariable("x") Double x, @PathVariable("y") Double y) {
        Double result = null;

        if(x > y)
            result= x - y;
        else
            result= y - x;

        return result;
    }

    @PostMapping("/mul")
    public  ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calculatorDTO) {

        Double result = null;
        result = calculatorDTO.getNum1()*calculatorDTO.getNum2()*calculatorDTO.getNum3()*calculatorDTO.getNum4();

       // ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
