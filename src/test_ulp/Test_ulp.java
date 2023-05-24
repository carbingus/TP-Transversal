package test_ulp;

import javax.swing.JOptionPane;
import test_ulp.AccesoADatos.MateriaData;
import test_ulp.Entidades.Materia;

public class Test_ulp {

    public static void main(String[] args) {
        MateriaData md = new MateriaData();
//        Materia m =  new Materia("Programacion 1", 1, true);
//        md.guardarMateria(m);
        /*
        if (md.buscarMateria(9) == null) {
            JOptionPane.showMessageDialog(null, "Materia NO encontrada!");
        } else {
            JOptionPane.showMessageDialog(null, "Materia encontrada!");
        }
        */
        
//        md.modificarMateria(new Materia(13, "Programacion 2", 3, true));
        
//        md.eliminarMateria(10);

        for (Materia materia : md.listarMaterias()) {
            System.out.println(materia.toString());
            System.out.println("");
        }
        
    }
    
}
