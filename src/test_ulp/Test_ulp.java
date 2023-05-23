package test_ulp;

import test_ulp.AccesoADatos.MateriaData;
import test_ulp.Entidades.Materia;

public class Test_ulp {

    public static void main(String[] args) {
        MateriaData md = new MateriaData();
        Materia m =  new Materia("Programacion 1", 1, true);
        md.guardarMateria(m);
    }
    
}
