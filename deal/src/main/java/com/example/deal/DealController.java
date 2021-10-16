package com.example.deal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deals")
public class DealController {
	
	@Autowired
	private DealRepository dealRepository;
	
	@GetMapping(value = "/list")
	public List<Deal> getAllDeal(){
		return dealRepository.findAll();
	}
		
	@PostMapping (value = "/add")
	public Deal addDeals(@RequestBody Deal deal){
		return dealRepository.save(deal);
	 }

	@DeleteMapping (value="/delete/{dealId}")
	public void deleteDeal(@PathVariable String dealId) {
			System.out.println("Delete Method Called");
		      dealRepository.deleteById(dealId);
		    }
		    
		
	}
	
	
