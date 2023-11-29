package com.springboot.models.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.springboot.models.entitys.Rutina;
@Repository
public class RutinaDaoImpl {
	@Autowired
	private JdbcTemplate jt;
	
	public List<Rutina> listar(){
		String sql = "select * from rutina";
		List<Rutina> lista = jt.query(sql, BeanPropertyRowMapper.newInstance(Rutina.class));
		return lista;
	}
	
	public Rutina obtenerRutinaPorId(Long id) {
        String sql = "SELECT * FROM rutina WHERE id_rutina = ?";
        return jt.queryForObject(sql, BeanPropertyRowMapper.newInstance(Rutina.class), id);
    }
	
	public List<Rutina> listarF(){
		String sql = "select * from rutina";
		List<Rutina> lista = jt.query(sql, BeanPropertyRowMapper.newInstance(Rutina.class));
		return lista;
	}
	
	public Rutina obtenerRutinaPorIdF(Long id) {
        String sql = "SELECT * FROM rutina WHERE id_rutina = ?";
        return jt.queryForObject(sql, BeanPropertyRowMapper.newInstance(Rutina.class), id);
    }
}

