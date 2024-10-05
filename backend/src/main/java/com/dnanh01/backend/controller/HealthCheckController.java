package com.dnanh01.backend.controller;

import com.dnanh01.backend.model.response.JSONResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/health-check")
public class HealthCheckController {
	@GetMapping("/")
	public ResponseEntity<JSONResponse<String>> healthCheck() {
		JSONResponse<String> response = new JSONResponse<>();
		response.setStatusCode(200);
		response.setData("Service is up and running");
		return ResponseEntity.status(200).body(response);
	}
}
