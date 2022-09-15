package com.niit.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.niit.model.ResultantObject;
import com.niit.model.State;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class weatherController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/states")
	public ResponseEntity<?> getStates() {

		String country = "India";
		String key = "0a0247ff-2fbf-405d-9ead-d7e48fedac6a";
		String url = "http://api.airvisual.com/v2/states?country=" + country + "&key=" + key;

		ResultantObject res = restTemplate.getForObject(url, ResultantObject.class);
		ArrayList<State> stateList = new ArrayList<State>();

		for (State state : res.getData()) {
			stateList.add(state);
		}
		return new ResponseEntity<>(stateList, HttpStatus.OK);

	}

}
