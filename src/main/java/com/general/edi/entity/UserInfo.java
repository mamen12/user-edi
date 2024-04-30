package com.general.edi.entity;

import java.io.Serializable;
import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="tm_user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable { 
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name; 
    
    @Column(name = "nama_lengkap")
    private String namaLengkap; 
    
    private String password;
    
    @Column(name = "created_at")
    private Date createdAt;
    
    @Column(name = "created_by")
    private String createdby;
    
    @Column(name = "updated_at")
    private Date updatedAt;
    
    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "last_login")
    private Date lastLogin;
    
    private Character status;
}

