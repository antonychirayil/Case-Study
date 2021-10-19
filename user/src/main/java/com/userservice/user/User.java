package com.userservice.user;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Document(collection="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
	@Id
	private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String gender;
    private String age;
    private String userName;
    private String password;
	//private Set<Coupon> coupons = new HashSet<Coupon>();
	
}

