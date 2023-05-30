package test_ulp.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import test_ulp.Entidades.Materia;

public class MateriaData {
    private Connection conexion = null;

    public MateriaData() {
        conexion = Conexion.getConexion();
    }
    
    public void guardarMateria(Materia materia) {
        //aca creamos materias nuevas
        try {
            //nuestro string AGREGA (insert into) a la tabla materias, una materia
            //pidiendo nombre, a que año pertenece (ej. primer año/segundo año), y el estado
            //de la materia, es decir, si la materia esta activa o no
            String sql = "INSERT INTO materias(nombre_materia,anio,estado) VALUES (?,?,?);";
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre_materia());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setId_materia(rs.getInt(1));
            }
            System.out.println("Materia agregada!");
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error: "+e.getMessage());
        }
    }

    public Materia buscarMateria(int id) {
        //aca buscamos una materia en especifico por id
        //generamos un objeto Materia y lo asignamos nulo
        Materia materia = null;
        try {
            //nuestro string PIDE TODO (Select * from) de la tabla materias, donde el id_materia es desconocido
            //pero el estado de la materia es 1. es decir, la materia esta activa
            String sql = "SELECT * FROM materias WHERE id_materia = ?"; // AND estado = 1 (para seleccionar todas las activas)
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                materia = new Materia(id, rs.getString("nombre_materia"), rs.getInt("anio"), rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        return materia;
    }

    public void modificarMateria(Materia materia) {
        //aca modificamos los datos de una materia
        try {
            //nuestro string ACTUALIZA (update) la tabla materias, para cambiar el nombre de la materia
            //el año de cursada, donde el id_materia sea especificado, y su estado este activo
            String sql = "UPDATE materias SET nombre_materia = ?, anio = ? WHERE id_materia = ?;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, materia.getNombre_materia());
            ps.setInt(2, materia.getAnio());
            ps.setInt(3, materia.getId_materia());
            ps.executeUpdate();
            System.out.println("Materia actualizada!");
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }

    public void eliminarMateria(int id) {
        //aca eliminamos/damos de baja una materia
        try {
            //nuestro string ACTUALIZA (update) la tabla materias y le dice que
            //CAMBIE (set) el estado de la materia a 0, segun el id_materia que le pasamos
            String sql = "UPDATE materias SET estado = 0 WHERE id_materia = ?;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Materia eliminada!");
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }

    public List<Materia> listarMaterias() {
        //esta List nos permite listar todas las materias activas
        List<Materia> listaMaterias = new ArrayList();
        try {
            //el string PIDE TODA la informacion(select * from) en la tabla materias
            //de aqueyas materias cuales esten activas
            String sql = "SELECT * FROM materias WHERE estado = 1;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                listaMaterias.add(new Materia(rs.getInt("id_materia"), rs.getString("nombre_materia"), rs.getInt("anio"), rs.getBoolean("estado")));
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        return listaMaterias;
    }
    
    /*
    public void activarMateria(int id) {
        try {
            String sql = "UPDATE materias SET estado = 1 WHERE id_materia = ?;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Materia activada!");
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    */
    
}
