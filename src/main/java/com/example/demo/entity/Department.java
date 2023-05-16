package com.example.demo.entity;



import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data 
public class Department {
      
       
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
		private Long dId;
        @NotBlank(message="enter name bto")
        private String dn;
        private String da;
        private String dc;
        
		
        
}
