package com.example.coupon;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
class CouponApplicationTests {
	
	@MockBean
	CouponRepository couponRepository;
	
	@Autowired
	CouponController couponController;
	
	
	@Test
	public void getAllCouponsTest()  {
		 when(couponRepository.findAll()).thenReturn(
	                Stream.of(
	                        new Coupon("","Realme","Rea20","Mobile","20% offer"))
	                        .collect(Collectors.toList()));
	        assertEquals(1  , couponController.getAllCoupons().size());
		
	}
	
	@Test
	public void addCouponTest() {
		Coupon coupon = new Coupon("","Fila","Fil30","Sport","40% offer");
		when(couponRepository.save(coupon)).thenReturn(coupon);
		 assertEquals(coupon,couponController.addCoupon(coupon));
	}
	
	@Test
	public void deleteCouponTest() {
	
		String couponId = "001";
		
		Coupon coupon = new Coupon("001","Amazon","Ama15","Beauty","15% offer");
		couponRepository.deleteById(couponId);
		verify(couponRepository).deleteById(couponId);
		
		
	}

}