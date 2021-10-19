package com.example.coupon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupons")
public class CouponController {

	@Autowired
	private CouponRepository couponRepository;
	
	@GetMapping(value = "/list")
	public List<Coupon> getAllCoupons(){
        return couponRepository.findAll();
    }
	
	@PostMapping(value = "/add")
	public Coupon addCoupon(@RequestBody Coupon coupon){
        return couponRepository.save(coupon);
    }
	
	 @PutMapping(value = "/update/{couponID}")
	   public String updateCoupon(@RequestBody Coupon coupon, @PathVariable String couponID){
	        couponRepository.save(coupon);
	        return "coupon Updated Succesfully";
	    }
	 
	@DeleteMapping(value = "/delete/{couponID}")
	 public void deleteProduct(@PathVariable String couponID) {
	        System.out.println("Delete method called");
	        couponRepository.deleteById(couponID);
}
}
