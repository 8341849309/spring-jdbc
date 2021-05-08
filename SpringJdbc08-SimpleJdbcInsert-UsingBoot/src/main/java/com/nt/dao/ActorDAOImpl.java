package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.entity.Actor;

@Repository("actorRepo")
public class ActorDAOImpl implements IActorDAO {

	@Autowired
	private SimpleJdbcInsert sji;

	/*
	 * public int insert(Actor deatils) { sji.setTableName("ACTOR"); Map<String,
	 * Object> map = new HashMap<String, Object>(); map.put("ACTORID",
	 * deatils.getActorid()); map.put("ACTORNAME", deatils.getActorname());
	 * map.put("ADDRESS", deatils.getAddress()); map.put("REMUNERATION",
	 * deatils.getRemuneration());
	 * 
	 * return sji.execute(map); }
	 */

	public int insert(Actor deatils) {

		sji.setTableName("ACTOR");

		return sji.execute(new BeanPropertySqlParameterSource(deatils));
	}

}
