package modeloDao;

import com.mysql.jdbc.PreparedStatement;
import config.conexion;
import interfaces.crud;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.persona;

/**
 *
 * @author json
 */
public class personaDao implements crud {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    persona p = new persona();

    @Override
    public List listar() {
        ArrayList<persona> list = new ArrayList<>();
        String sql = "select * from persona";
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                persona per = new persona();
                per.setId(rs.getInt("id"));
                per.setNombre(rs.getString("lastname"));
                per.setApellido(rs.getString("firstname"));
                per.setTelefono(rs.getString("phone"));
                per.setTipoIdentificacion(rs.getString("tipoIdentificacion"));
                per.setIdentificacion(rs.getString("identificacion"));
                per.setFechaNacimiento(rs.getString("dateofbirth"));
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public persona list(int id) {
        String sql = "select * from persona where id=" + id;
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("lastname"));
                p.setApellido(rs.getString("firstname"));
                p.setTelefono(rs.getString("phone"));
                p.setTipoIdentificacion(rs.getString("tipoIdentificacion"));
                p.setIdentificacion(rs.getString("identificacion"));
                p.setFechaNacimiento(rs.getString("dateofbirth"));
            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean add(persona per) {
        String sql = "insert into persona(lastname,firstname,phone,tipoIdentificacion,identificacion,dateofbirth) values ('" 
                + per.getNombre() 
                + "','" + per.getApellido() 
                + "','" + per.getTelefono() 
                + "','" + per.getTipoIdentificacion()
                + "','" + per.getIdentificacion()
                + "','" + per.getFechaNacimiento() + "')";
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(persona per) {
        String sql = "update persona set lastname='" + per.getNombre()
                + "',firstname='" + per.getApellido()
                + "',phone='" + per.getTelefono()
                + "',tipoIdentificacion='" + per.getTipoIdentificacion()
                + "',identificacion='" + per.getIdentificacion()
                + "',dateofbirth='" + per.getFechaNacimiento()
                + "' where id=" + per.getId();
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql ="delete from persona where id=" + id;
        try {
            con =cn.getConnection();
            ps=(PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
