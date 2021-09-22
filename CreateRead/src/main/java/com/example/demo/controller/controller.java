package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dataModel.model;

@RestController
public class controller {
private Map<String, model> Map;
	
	@PostConstruct
	public void init() { //기본 데이터
		Map=new HashMap<String, model>();
		Map.put("1", new model("제목1", "내용1"));
		Map.put("2", new model("제목2", "내용2"));
		Map.put("3", new model("제목3", "내용3"));
	}
	
	@GetMapping("/read") //전체 읽어오기
	public List<model> getDataList(){
		return new ArrayList<model>(Map.values());
	}
	
	@PutMapping("/create/{id}")
	public void putData(@PathVariable("id") String id, @RequestParam("title") String title, @RequestParam("description") String description) {
		model user=new model(title,description);	
		Map.put(id, user); 
	}
}
