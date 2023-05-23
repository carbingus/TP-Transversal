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
        try {
            String sql = "INSERT INTO materias(nombre_materia,anio,estado) VALUES (?,?,?);";
            PreparedStatement PS = conexion.prepareStatement(sql);
            PS.setString(1, materia.getNombre_materia());
            PS.setInt(2, materia.getAnio());
            PS.setBoolean(3, materia.isEstado());
            PS.executeUpdate();
            JOptionPane.showMessageDialog(null, "Materia agregada!");
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error: "+e.getMessage());
        }
    }

    public Materia buscarMateria(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Materia modificarMateria(int id, Materia materia) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void eliminarMateria(int id) {
    }

    public List<Materia> listarMaterias() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void activarMateria(int id) {
    }
}
