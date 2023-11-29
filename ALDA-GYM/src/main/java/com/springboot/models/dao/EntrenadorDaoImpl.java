package com.springboot.models.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.models.entitys.Entrenador;

@Repository

public class EntrenadorDaoImpl implements IEntrenadorDao {

	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public List<Entrenador> listar() {
		String sql = "select * from entrenador";
		List<Entrenador> lista = jt.query(sql, BeanPropertyRowMapper.newInstance(Entrenador.class));
		return lista;
	}

	@Override
	public int guardar(Entrenador entrenador) {
		// TODO Auto-generated method stub
		String sql= "insert into entrenador(idtrainer,nombretrainer,apellidotrainer,sueldotrainer,telefonotrainer)values(?,?,?,?,?)";
		return jt.update(sql, entrenador.getIdtrainer(), entrenador.getNombretrainer(), entrenador.getApellidotrainer(),
				entrenador.getSueldotrainer(), entrenador.getTelefonotrainer());
	
	}
	
	 @Override
	    public Entrenador obtenerEntrenadorPorId(Long id) {
	        String sql = "SELECT * FROM entrenador WHERE idtrainer = ?";
	        return jt.queryForObject(sql, BeanPropertyRowMapper.newInstance(Entrenador.class), id);
	    }

	    @Override
	    public int actualizar(Entrenador entrenador) {
	        String sql = "UPDATE entrenador SET nombretrainer = ?, apellidotrainer = ?, sueldotrainer = ?, telefonotrainer = ? WHERE idtrainer = ?";
	        return jt.update(sql,  entrenador.getNombretrainer(), entrenador.getApellidotrainer(),
					entrenador.getSueldotrainer(), entrenador.getTelefonotrainer(), entrenador.getIdtrainer());
	    }

	    @Override
	    public int borrar(Long id) {
	        String sql = "DELETE FROM entrenador WHERE idtrainer = ?";
	        return jt.update(sql, id);
	    }
}
