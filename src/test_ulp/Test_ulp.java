package test_ulp;

import javax.swing.JOptionPane;
import test_ulp.AccesoADatos.MateriaData;
import test_ulp.Entidades.Materia;

public class Test_ulp {

    public static void main(String[] args) {
        MateriaData md = new MateriaData(); //generamos un nuevo MateriaData
        
        
        //creamos una nueva materia y le asignamos informacion respectiva
        //Materia("nombre_materia",anio, estado_materia)
        //anio indica el año de cursada, primer año, segundo año, utilizar solo numeros
        //estado utiliza un boolean true/false, para indicar que esta activa o no
        //el estado en la base de datos aparece como "TinyInt"
        //ya que TinyInt es la forma de utilizar booleans
        //por lo tanto si estado_materia = true ó si estado_materia = 1
        //la materia es considerada como activa
        //de la misma manera, si estado_materia = false ó si estado_materia = 0
        //la materia es considerada como inactiva
        
         Materia m =  new Materia("Programacion 1", 1, true); 
         md.guardarMateria(m); // con este metodo, se guarda la materia en la base de datos
         
         //el siguiente metodo sirve para verificar si la materia existe o no, dentro de la base de datos
         //utilizando md.buscarMateria(id_materia) como parametro para realizar la busqueda
         //en este caso ejemplo, la nueva materia tendra id 9
        /*
        if (md.buscarMateria(9) == null) {
            JOptionPane.showMessageDialog(null, "Materia NO encontrada!");
        } else {
            JOptionPane.showMessageDialog(null, "Materia encontrada!");
        }
        */
        
//        md.modificarMateria(new Materia(13, "Programacion 2", 3, true)); //aca modificamos la info de la materia
        
//        md.eliminarMateria(10); //aca eliminamos la materia buscandola por id_materia (en este caso su id es 10)

        //este loop nos lista por consola, todas las materias que tengamos dentro de la base de datos
        for (Materia materia : md.listarMaterias()) {
            System.out.println(materia.toString());
            System.out.println("");
        }
        
        //faltaria luego agregar alumnos usando los metodos de AlumnoData
        //y finalmente inscribir alumnos a materias, utilizando InscripcionData
        
    }
    
}
