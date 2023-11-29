package com.springboot.models.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;


import com.springboot.models.entitys.Cliente;


@Repository

public class ClienteDaoImpl implements IClienteDao{

	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public List<Cliente> listar() {
		String sql = "select * from cliente";
		List<Cliente> lista = jt.query(sql, BeanPropertyRowMapper.newInstance(Cliente.class));
		return lista;
	}
	 @Override
	    public double calcularIMC(Long id) {
	        Cliente cliente = obtenerClientePorId(id);
	        return cliente.calcularIMC();
	    }

	    @Override
	    public String clasificarIMC(Long id) {
	        Cliente cliente = obtenerClientePorId(id);
	        return cliente.clasificarIMC();
	    }


	@Override
	public int guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		cliente.calcularIMC();
		String sql= "insert into cliente(idcliente,nombrecliente,apellidocliente,correocliente,contraseñacliente,telefonocliente,pesocliente,altura,imc,clasificacionimc,id_categoria,idtrainer,id_Plan_Aliment,id_rutina)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return jt.update(sql,cliente.getIdcliente(), cliente.getNombrecliente(), cliente.getApellidocliente(), cliente.getCorreocliente(),
				cliente.getContraseñacliente(), cliente.getTelefonocliente(), cliente.getPesocliente(),cliente.getAltura(),cliente.getImc(),cliente.clasificarIMC(), cliente.getId_categoria(),cliente.getIdtrainer(),
				cliente.getId_Plan_Aliment(),cliente.clasificarRutina());
	
	}
	
	
	
	 @Override
	    public Cliente obtenerClientePorId(Long id) {
	        String sql = "SELECT * FROM cliente WHERE idcliente = ?";
	        return jt.queryForObject(sql, BeanPropertyRowMapper.newInstance(Cliente.class), id);
	    }

	    @Override
	    public int actualizarcliente(Cliente cliente) {
	    	cliente.calcularIMC();
	        String sql = "UPDATE cliente SET  nombrecliente = ?, apellidocliente = ?, correocliente = ?, contraseñacliente = ?, telefonocliente = ?, pesocliente = ?, altura = ?, imc = ?, clasificacionimc = ?, id_categoria = ?, idtrainer = ?, id_Plan_Aliment = ?, id_rutina = ? WHERE idcliente = ?";
	        return jt.update(sql, cliente.getNombrecliente(), cliente.getApellidocliente(),  cliente.getCorreocliente(),
					cliente.getContraseñacliente(), cliente.getTelefonocliente(), cliente.getPesocliente(),cliente.getAltura(),cliente.getImc(),cliente.clasificarIMC(),cliente.getId_categoria(),cliente.getIdtrainer(),
					cliente.getId_Plan_Aliment(),cliente.clasificarRutina(), cliente.getIdcliente());
	    }

	    @Override
	    public int borrarcliente(Long id) {
	        String sql = "DELETE FROM cliente WHERE idcliente = ?";
	        return jt.update(sql, id);
	    }
	    
	    /* Impl Vista Cliente*/
	    
	    public int guardarF(Cliente cliente) {
			// TODO Auto-generated method stub
			cliente.calcularIMC();
			String sql= "insert into cliente(idcliente,nombrecliente,apellidocliente,correocliente,contraseñacliente,telefonocliente,pesocliente,altura,imc,clasificacionimc,idtrainer,id_Plan_Aliment,id_rutina)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			return jt.update(sql,cliente.getIdcliente(), cliente.getNombrecliente(), cliente.getApellidocliente(), cliente.getCorreocliente(),
					cliente.getContraseñacliente(), cliente.getTelefonocliente(), cliente.getPesocliente(),cliente.getAltura(),cliente.getImc(),cliente.clasificarIMC(),cliente.getIdtrainer(),
					cliente.getId_Plan_Aliment(),cliente.clasificarRutina());
		
		}
	    public int actualizarclienteF(Cliente cliente) {
	    	cliente.calcularIMC();
	        String sql = "UPDATE cliente SET  nombrecliente = ?, apellidocliente = ?,  correocliente = ?, contraseñacliente = ?, telefonocliente = ?, pesocliente = ?, altura = ?, imc = ?, clasificacionimc = ?,  idtrainer = ?, id_Plan_Aliment = ?, id_rutina = ? WHERE idcliente = ?";
	        return jt.update(sql, cliente.getNombrecliente(), cliente.getApellidocliente(),  cliente.getCorreocliente(),
					cliente.getContraseñacliente(), cliente.getTelefonocliente(), cliente.getPesocliente(),cliente.getAltura(),cliente.getImc(),cliente.clasificarIMC(),cliente.getIdtrainer(),
					cliente.getId_Plan_Aliment(),cliente.clasificarRutina(), cliente.getIdcliente());
	    }
	    
	    
	    
	   
	   

		
}
