package com.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.card.EntityCard;
import com.card.service.CardService;

@RestController
public class Control {
	@Autowired
	CardService c;
	@GetMapping(value="/get")
	public List<EntityCard> read() {
		 return c.getinfo();
	}
	@GetMapping(value="getbyid/{accnum}")
	public EntityCard getbyId(@PathVariable int accnum) {
		 return c.getbyId(accnum);
	}
	
	@PutMapping(value="activate/{accnum}")
	public String activate(@PathVariable int accnum,@RequestBody EntityCard issue) {
		return c.activate(accnum,issue);
		
	}
	@PutMapping(value="deactivate/{accnum}")
	public String deactivate(@PathVariable int accnum,@RequestBody EntityCard e) {
		return c.deactivate(accnum,e);
	}
	public boolean isOk(EntityCard n) {
		boolean flag=true;
		if(n.getAccnum()<100000&&n.getName().contains(null)) {
		flag=false;}
		return flag;
	}
	
	@PostMapping(value="/post")
	public ResponseEntity<EntityCard>issue(@RequestBody EntityCard n) {
		if(isOk(n)==true) {
			EntityCard e=c.issue(n);
			return new ResponseEntity<EntityCard>(e,HttpStatus.OK);
		}else {
			return new ResponseEntity<EntityCard>(HttpStatus.BAD_REQUEST);
		}
	
	}
	
	@DeleteMapping(value="delete/{accnum}")
	public void Delete(@PathVariable int accnum) {
		c.delete(accnum);
		}
		
	}
	
