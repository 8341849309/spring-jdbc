package com.nt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
	@NonNull
	private Integer actorid;
	@NonNull
	private String actorname;
	@NonNull
	private String address;
	@NonNull
	private Float remuneration;
}
