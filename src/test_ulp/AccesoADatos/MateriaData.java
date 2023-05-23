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
    private Connection con = null;

    private Conexion conexion;

    public MateriaData(Conexion conexion) {
    }

    public void guardarMateria(Materia materia) {
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
