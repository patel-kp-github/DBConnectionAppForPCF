package com.capgermini.DAO;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DaoClass {

	@PostConstruct
	public void init() {
		String sql = "create table IF NOT EXISTS user(id int NOT NULL AUTO_INCREMENT,name varchar(25),primary key(id))";
		jdbc.update(sql);
	}

	@Autowired
	private JdbcTemplate jdbc;

	public String store(String name) {
		String sql = "insert into user(name)values('" + name + "')";
		try {
			jdbc.update(sql);
			return "SUCCESS";
		} catch (Exception e) {
			return "FAILED";
		}
	}

	public List<Map<String, Object>> get() {
		String sql = "select * from user";
		try {
			return jdbc.queryForList(sql);
		} catch (Exception e) {
			return null;
		}
	}
}
