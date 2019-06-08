
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class ConsultasPersona extends Conexion{
    
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insertar(Persona persona){
        Connection conexion = getConnection();
        
        try{
            ps = conexion.prepareStatement("insert into persona (clave,nombre,domicilio,celular,correo,genero) values (?,?,?,?,?,?)");
            ps.setString(1, persona.getClave());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getDomicilio());
            ps.setString(4, persona.getCelular());
            ps.setString(5, persona.getCorreo());
            ps.setString(6, persona.getGenero());
            
            int resultado = ps.executeUpdate();
            
            if (resultado > 0) {
                return true;  
            }else {
                return false;
            }
            
            
        }catch(Exception ex){
            System.out.println("Error, " +ex);
            return false;
        }finally{
            try{
                conexion.close();
            }catch(Exception ex){
                System.out.println("Error, "+ex);
            }
        }
        
        
    }
    
    public boolean buscar(Persona persona){
        Connection conexion = getConnection();
        
        try{
            ps = conexion.prepareStatement("select * from persona where clave = ?");
            ps.setString(1, persona.getClave());
            rs = ps.executeQuery();
           
            if (rs.next()) {
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setClave(rs.getString("clave"));
                persona.setNombre(rs.getString("nombre"));
                persona.setDomicilio(rs.getString("domicilio"));
                persona.setCelular(rs.getString("celular"));
                persona.setCorreo(rs.getString("correo"));
                persona.setGenero(rs.getString("genero"));
                return true;
            }else {
                return false;
            }
            
        }catch(Exception ex){
            System.out.println("Error, " +ex);
            return false;
        }finally{
            try{
                conexion.close();
            }catch(Exception ex){
                System.out.println("Error, "+ex);
            }
        }
    }
    
    
    public boolean modificar(Persona persona){
        Connection conexion = getConnection();
        
        try{
            ps = conexion.prepareStatement("update persona set clave=?,nombre=?,domicilio=?,celular=?,correo=?,genero=? where idPersona=?");
            ps.setString(1, persona.getClave());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getDomicilio());
            ps.setString(4, persona.getCelular());
            ps.setString(5, persona.getCorreo());
            ps.setString(6, persona.getGenero());
            ps.setInt(7, persona.getIdPersona());
            
            int resultado = ps.executeUpdate();
            
            if (resultado > 0) {
                return true;  
            }else {
                return false;
            }
            
            
        }catch(Exception ex){
            System.out.println("Error, " +ex);
            return false;
        }finally{
            try{
                conexion.close();
            }catch(Exception ex){
                System.out.println("Error, "+ex);
            }
        }
        
        
    }
    
    public boolean eliminar(Persona persona){
        Connection conexion = getConnection();
        
        try{
            ps = conexion.prepareStatement("delete from persona where idPersona=?");
            ps.setInt(1, persona.getIdPersona());
            
            int resultado = ps.executeUpdate();
            
            if (resultado > 0) {
                return true;  
            }else {
                return false;
            }
            
            
        }catch(Exception ex){
            System.out.println("Error, " +ex);
            return false;
        }finally{
            try{
                conexion.close();
            }catch(Exception ex){
                System.out.println("Error, "+ex);
            }
        }
        
        
    }
    
    
}
