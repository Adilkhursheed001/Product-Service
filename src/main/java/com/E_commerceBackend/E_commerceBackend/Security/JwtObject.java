package com.E_commerceBackend.E_commerceBackend.Security;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class JwtObject {
 private Long id;

 private Date created_At;

 private Date expiry_At;

 private Role role;

 private Long user_id;

}
