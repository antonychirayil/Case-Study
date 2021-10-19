package com.example.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    RestTemplate restTemplate;

    private CouponRepository couponRepository;

    @RequestMapping("")
    public  String Test(){
        return "helloWorld";
    }

    //--------Admin-coupon Connection--------------------------------------------------
    @RequestMapping(value = "/listAll")
    public List<Coupon> getAllCoupons(){
        return Arrays.asList(restTemplate.getForObject("http://coupons/coupons/list",Coupon[].class));
    }

    @RequestMapping(value = "/addAll")
    public  String addCoupon(@RequestBody Coupon coupon){
        return  restTemplate.postForObject("http://coupons/coupons/add",coupon,String.class);
    }

    @RequestMapping(value = "/deleteAll/{couponID}")
    public String deleteProduct(@PathVariable String couponID) {
        restTemplate.delete("http://coupons/coupons/delete/{couponID}", couponID, String.class);
        return "Deleted Successfully";
    }

    @RequestMapping(value = "/updateAll/{couponID}")
    public String updateCoupon(@RequestBody Coupon coupon, @PathVariable String couponID){
        restTemplate.put("http://coupons/coupons/update/{couponID}",coupon,couponID,String.class);
        return "coupon Updated Succesfully";
    }

    //

}