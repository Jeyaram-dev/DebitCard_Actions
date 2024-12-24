package com.card.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.card.EntityCard;
import com.card.repo.Repo;

@Service
@Component
public class CardService {
	
	@Autowired
	Repo rep;

	public List<EntityCard>  getinfo(){
		List<EntityCard> l=rep.findAll();
		return l;
	}
	public EntityCard getbyId(int accnum) {
		Optional<EntityCard> c=rep.findById(accnum);
		return c.get();
	}

	public String activate(int accnum,EntityCard e) {
	Optional<EntityCard> o=rep.findById(accnum);
	EntityCard all=o.get();
	int anum=e.getAccnum();
	String name=e.getName();
	if(anum!=all.getAccnum()) {
		return "Account number not Valid";
	}else if(!name.equals(all.getName()))
		return "Name is not Valid";
	else {
		all.setStatus("Activated");
		rep.save(all);
		return "Card Activated Sucessfully";
	}
	}
	public String deactivate(int accnum,EntityCard e) {
		Optional<EntityCard> o=rep.findById(accnum);
		EntityCard all=o.get();
		int anum=e.getAccnum();
		String name=e.getName();
		long cardnum=all.getCardnum();
		if(anum!=all.getAccnum()) {
			return "Account number not Valid";
		}else if(!name.equals(all.getName())) {
			return "Invalid Account Holder Name";
		}
		else if(cardnum!=e.getCardnum()) {
			return "Card Number is invalid";
		}else {
			all.setStatus("Deactivated");
			rep.save(all);
			return "Card Deactivate";
		}	
		}
	public int generatenum() {
		Random r=new Random();
			int cnum= r.nextInt();
			if(cnum<0 || cnum==0) {
			return cnum=cnum*-1;
			}
	else return cnum;
	}
	public int generatecvv() {
		Random r=new Random();
			int cvv= r.nextInt();
			if(cvv<0 || cvv==0) {
			return cvv=cvv*-1;
			}
	else return cvv;
	}
	
	public EntityCard issue(EntityCard n) {
		long cardnum=generatenum();
		long cvv=generatecvv();
		n.setCardnum(cardnum);
		n.setCvvnumber(cvv);
		return rep.save(n);
	
	}
	

	public void delete(int accnum) {
		Optional<EntityCard> e=rep.findById(accnum);
		if(e.isPresent()) {
			EntityCard c=e.get();
		    rep.delete(c);
		    
		}
		
	}

	
	
}
