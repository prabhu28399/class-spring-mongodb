package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DataController {

    @Autowired
    private DataRepository dataRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<Data> dataList = dataRepository.findAll();
        model.addAttribute("dataList", dataList);
        return "index";
    }

    @PostMapping("/submit")
    public String submit(@RequestParam String data, Model model) {
        Data newData = new Data(data);
        dataRepository.save(newData);
        List<Data> dataList = dataRepository.findAll();
        model.addAttribute("dataList", dataList);
        return "index";
    }
}
