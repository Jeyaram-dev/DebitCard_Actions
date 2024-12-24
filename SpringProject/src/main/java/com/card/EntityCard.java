package com.card;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="card")
public class EntityCard {

	@Id
	@Column(name="account_number")
	private int accnum;
	@Column(name="card_holder_name")
	private String name;
	@Column(name="cardnumber")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long cardnum;
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="cvv_number")
	private Long cvvnumber;
	@Column(name="card_status")
	private String status;
	
	

}
