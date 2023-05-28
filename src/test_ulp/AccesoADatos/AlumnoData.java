package test_ulp.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import test_ulp.Entidades.Alumno;

public class AlumnoData {

    private Connection con = null;
    

  public AlumnoData() {
            con = Conexion.getConexion();
    }

    public void guardarAlumno(Alumno alumno) { // Creacion de nuevo alumno
           
        //Aca generamos un String SQL en el cual le asignamos que debe insertar
        //un alumno cuyos datos son desconocidos, y cuales pediremos a traves de
        //un PreparedStatement
        
        String sql = "INSERT INTO alumnos (dni_alumno, nombre_alumno, apellido_alumno, fechaNacimiento, estado_alumno) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni_alumno()); // asignamos dni de alumno
            ps.setString(2, alumno.getApellido_alumno()); //asignamos apellido
            ps.setString(3, alumno.getNombre_alumno()); // asignamos nombre
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento())); //asignamos fecha de nacimiento usando una conversion LocalDate a Date
            ps.setBoolean(5, alumno.isEstado_alumno()); // aca el alumno se activa
            ps.executeUpdate(); // le decimos al PreparedStatement que introduzca los datos a la BD
            ResultSet rs = ps.getGeneratedKeys(); // pedimos las keys generadas para poder utilizarlas
            if (rs.next()) { // verificamos se pueda agregar un alumno en el siguiente lugar disponible
                alumno.setId_alumno(rs.getInt(1)); //id incremental generado automaticamente por DB
                JOptionPane.showMessageDialog(null, "Alumno añadido con exito.");
            } else { // el alumno no se pudo añadir
                JOptionPane.showMessageDialog(null, "El alumno no fue añadido.");
            }

            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno "+ex.getLocalizedMessage());
            //aca nos indica si hubo un error
        }

    }

    public Alumno buscarAlumno(int id) { //buscar alumno activo (estado_alumno = 1)
        Alumno alumno = new Alumno(); // generamos un objeto de tipo Alumno para poder hacer verificacion
        // tenemos un SQL para seleccionar la tabla alumnos y pedir que nos devuelva aquel alumno
        // cuyo estado sea 1, es decir, alumno activo, segun id_alumno
        String sql = "SELECT dni_alumno, apellido_alumno, nombre_alumno, fechaNacimiento FROM alumnos WHERE id_alumno=? AND estado_alumno = 1";
        PreparedStatement ps = null;
        //nuestro PreparedStatement es nulo, para poder asignarle lo que sea necesario mas adelante
        try {
            ps = con.prepareStatement(sql); // intentamos conectar y pasar el string por parametro para realizar la consulta
            ps.setInt(1, id); 
            ResultSet rs = ps.executeQuery(); // ejecutamos la consulta

            if (rs.next()) { //si hay siguiente alumno, copiamos la informacion para mostrarla
                alumno.setId_alumno(id);
                alumno.setDni_alumno(rs.getInt("dni_alumno"));
                alumno.setApellido_alumno(rs.getString("apellido_alumno"));
                alumno.setNombre_alumno(rs.getString("nombre_alumno"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
               

            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getLocalizedMessage());
            //si hay error, pedimos informacion
        }

        return alumno;
    }
    
    public Alumno buscarAlumnoPorDni(int dni) {
        Alumno alumno = null;
        String sql = "SELECT id_alumno, dni_alumno, apellido_alumno, nombre_alumno, fechaNacimiento FROM alumnos WHERE dni_alumno = ? AND estado_alumno = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,dni );
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alumno=new Alumno();
                alumno.setId_alumno(rs.getInt("id_alumno"));
                alumno.setDni_alumno(rs.getInt("dni_alumno"));
                alumno.setApellido_alumno(rs.getString("apellido_alumno"));
                alumno.setNombre_alumno(rs.getString("nombre_alumno"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado_alumno(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno. Codigo: "+ex.getMessage());
        }

       
        return alumno;
    }

    public Alumno modificarAlumno(Alumno alumno) { //modificar alumno pidiendo id para referenciar
        
        // aca generamos una ACTUALIZACION (update) en la tabla alumnos, donde podremos cambiar
        //el dni, apellido, nombre, y fecha de nacimiento cuando pasemos el id_alumno por parametro
        String sql = "UPDATE alumnos SET dni_alumno = ? , apellido_alumno = ?, nombre_alumno = ?, fechaNacimiento = ? WHERE  id_alumno = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni_alumno());
            ps.setString(2, alumno.getApellido_alumno());
            ps.setString(3, alumno.getNombre_alumno());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setInt(5, alumno.getId_alumno());
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El alumno no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getLocalizedMessage());
        }
        return alumno;
    }

    public List<Alumno> listarAlumnos() { //mostrar todos los alumnos que esten activos (estado_alumno = 1)

        List<Alumno> alumnos = new ArrayList<>(); //creamos un arrayList para poder guardar informacion
        try {
            // aca nuestro string pide TODOS los datos de la tabla alumnos
            // donde el estado_alumno sea 1 (es decir, TRUE)
            String sql = "SELECT * FROM alumnos WHERE estado_alumno = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno(); 
                //generamos un objeto alumno para poder meter en el arraylist

                alumno.setId_alumno(rs.getInt("id_alumno"));
                alumno.setDni_alumno(rs.getInt("dni_alumno"));
                alumno.setApellido_alumno(rs.getString("apellido_alumno"));
                alumno.setNombre_alumno(rs.getString("nombre_alumno"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado_alumno(rs.getBoolean("estado_alumno"));
                alumnos.add(alumno); // agregamos el objeto alumno generado dentro del arrayList
            }
            ps.close();
           

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno " + ex.getLocalizedMessage());
        }
        return alumnos;
    }

    public void eliminarAlumno(int id) { //eliminar/desactivar alumno (estado_alumno = 0) usando id_alumno por referencia

        try {
            //aca nuestro string ACTUALIZA (update) la tabla alumnos, para cambiar
            // el estado de un alumno de 1(true) a 0(false), usando el id_alumno para encontrar
            //dicho alumno
            String sql = "UPDATE alumnos SET estado_alumno = 0 WHERE id_alumno = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila=ps.executeUpdate();
            ps.close();
            if(fila==1){
                JOptionPane.showMessageDialog(null, " Se eliminó el alumno.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno " + e.getLocalizedMessage());
        }
    }

    public void activarAlumno(int id) { //activar alumno (estado_alumno = 1) usando id_alumno por referencia

        try {
            //aca nuestro string ACTUALIZA (update) en la tabla alumnos el estado
            //de un alumno, de 0(false, es decir inactivo) a 1(true, es decir activo)
            //usando el id_alumno proporcionado para poder realizar la accion
            String sql = "UPDATE alumnos SET estado_alumno = 1 WHERE id_alumno = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila=ps.executeUpdate();
            ps.close();
            if(fila==1){
                JOptionPane.showMessageDialog(null, " Se activo el alumno.");
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno " + e.getLocalizedMessage());
        }
    }

}
