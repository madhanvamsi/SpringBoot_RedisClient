package org.Tayana.Sprinb_Boot_RedisClient.controller;


import java.util.List;

import org.Tayana.Sprinb_Boot_RedisClient.dto.Merchant;
import org.Tayana.Sprinb_Boot_RedisClient.dto.ResponseStructure;
import org.Tayana.Sprinb_Boot_RedisClient.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerchantController {
  
	@Autowired
	private MerchantService service;
	
	
	@PostMapping("/merchant")
	public ResponseEntity<ResponseStructure<Merchant>> save(@RequestBody Merchant merchant)
	{
		return service.save(merchant);
	}
	
	@GetMapping("/merchant")
	public ResponseEntity<ResponseStructure<List<Object>>>  findAll()
	{
		return service.findAll();
	}
	
	@GetMapping("/merchant/{id}")
	public ResponseEntity<ResponseStructure<Boolean>> findById(@PathVariable int id)
	{
		return service.findById(id);
	}

}

