package com.springboot.models.dao;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.springboot.models.entitys.Cliente;
import com.springboot.models.entitys.Rutina;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceDaoImpl {
	 @Autowired
	    private JavaMailSender javaMailSender;
	 @Autowired
		private JdbcTemplate jt;
	

	    // ... otros métodos existentes ...

	 public void sendEmail(String toAddress, String subject, String body) {
	        MimeMessage message = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
	        try {
	            helper.setTo(toAddress);
	            helper.setSubject(subject);
	            helper.setText(body, true);  // El segundo parámetro indica que es contenido HTML
	        } catch (MessagingException e) {
	            throw new RuntimeException("Error al configurar el mensaje HTML", e);
	        }

	        javaMailSender.send(message);
	    }

	    public void enviarDatosPorEmail(Cliente cliente) {
	        String subject = "Información del Cliente";
	        String body = "Nombre: " + cliente.getNombrecliente() + "\nCorreo: " + cliente.getCorreocliente() + construirTablaHTML(cliente);

	        sendEmail(cliente.getCorreocliente(), subject, body);
	    }
	    
	    public Rutina obtenerRutinaPorId(int id) {
	        String sql = "SELECT * FROM rutina WHERE id_rutina = ?";
	        return jt.queryForObject(sql, BeanPropertyRowMapper.newInstance(Rutina.class), id);
	    }
	    
	    
	    private String construirTablaHTML(Cliente cliente) {
	        // Obtener datos de la rutina asociada al cliente
	        Rutina rutina = obtenerRutinaPorId(cliente.getId_rutina());

	        if (rutina != null) {
	            StringBuilder htmlTable = new StringBuilder();
	            htmlTable.append("<style>")
	            .append("table {font-family: 'Arial', sans-serif; border-collapse: collapse; width: 100%;}")
	            .append("th, td {border=1; padding: 12px; text-align: left;}")
	            .append("th {background-color: #3498db; color: black;}")  // Fondo azul y texto blanco para el encabezado
	            .append("tr:nth-child(even) {background-color: #f2f2f2;}")  // Alternar colores de fondo en filas pares
	            .append("</style>");
        htmlTable.append("<table  ><tr>");


       
	            
	            // Agregar encabezados de la tabla con los nombres de los campos
	            htmlTable.append("<th>ID</th>");
	            htmlTable.append("<th>Dia 1</th>");  // Reemplazar con el nombre real del campo
	            htmlTable.append("<th>Dia 2</th>");  // Reemplazar con el nombre real del campo
	            htmlTable.append("<th>Dia 3</th>");  // Reemplazar con el nombre real del campo
	            htmlTable.append("<th>Dia 4</th>");  // Reemplazar con el nombre real del campo
	            htmlTable.append("<th>Dia 5</th>");  // Reemplazar con el nombre real del campo
	     
	            // Agregar más encabezados según sea necesario

	            htmlTable.append("</tr><tr>");
	            
	            // Agregar valores de la rutina a la tabla
	            htmlTable.append("<td>").append(rutina.getId_rutina()).append("</td>");
	            htmlTable.append("<td>").append(rutina.getDay_1()).append("</td>");  // Reemplazar con el nombre real del campo
	            htmlTable.append("<td>").append(rutina.getDay_2()).append("</td>");  // Reemplazar con el nombre real del campo
	            htmlTable.append("<td>").append(rutina.getDay_3()).append("</td>");  // Reemplazar con el nombre real del campo
	            htmlTable.append("<td>").append(rutina.getDay_4()).append("</td>");  // Reemplazar con el nombre real del campo
	            htmlTable.append("<td>").append(rutina.getDay_5()).append("</td>");  // Reemplazar con el nombre real del campo
	            // Agregar más valores según sea necesario

	            htmlTable.append("</tr></table>");
	            return htmlTable.toString();
	        } else {
	            return "Rutina no encontrada para el cliente con ID: " + cliente.getIdcliente();
	        }
	    }
	    
	   
}
