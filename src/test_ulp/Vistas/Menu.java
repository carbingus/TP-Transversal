package test_ulp.Vistas;

import javax.swing.JInternalFrame;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuAdministracion = new javax.swing.JMenu();
        menuItemAlumnos = new javax.swing.JMenuItem();
        menuItemMateria = new javax.swing.JMenuItem();
        menuItemInscripcion = new javax.swing.JMenuItem();
        menuItemNotas = new javax.swing.JMenuItem();
        menuConsultas = new javax.swing.JMenu();
        menuItemListAlumMat = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenu();
        menuItemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 539, Short.MAX_VALUE)
        );

        menuAdministracion.setText("Administración");

        menuItemAlumnos.setText("Formulario de Alumno");
        menuItemAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAlumnosActionPerformed(evt);
            }
        });
        menuAdministracion.add(menuItemAlumnos);

        menuItemMateria.setText("Formulario de Materia");
        menuItemMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMateriaActionPerformed(evt);
            }
        });
        menuAdministracion.add(menuItemMateria);

        menuItemInscripcion.setText("Manejo de Inscripciones");
        menuItemInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemInscripcionActionPerformed(evt);
            }
        });
        menuAdministracion.add(menuItemInscripcion);

        menuItemNotas.setText("Carga de Notas");
        menuItemNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNotasActionPerformed(evt);
            }
        });
        menuAdministracion.add(menuItemNotas);

        menuBar.add(menuAdministracion);

        menuConsultas.setText("Consultas");

        menuItemListAlumMat.setText("Listado de Alumnos por Materia");
        menuItemListAlumMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemListAlumMatActionPerformed(evt);
            }
        });
        menuConsultas.add(menuItemListAlumMat);

        menuBar.add(menuConsultas);

        menuSalir.setText("Salir");

        menuItemSalir.setText("Salir del Sistema");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirActionPerformed(evt);
            }
        });
        menuSalir.add(menuItemSalir);

        menuBar.add(menuSalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAlumnosActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        FormularioAlumno formA = new FormularioAlumno();
        centrarVentana(formA);
    }//GEN-LAST:event_menuItemAlumnosActionPerformed

    private void menuItemMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMateriaActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        FormularioMateria formM = new FormularioMateria();
        centrarVentana(formM);
    }//GEN-LAST:event_menuItemMateriaActionPerformed

    private void menuItemInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInscripcionActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        FormularioInscripcion formI = new FormularioInscripcion();
        centrarVentana(formI);
    }//GEN-LAST:event_menuItemInscripcionActionPerformed

    private void menuItemNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNotasActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        FormularioNotas formN = new FormularioNotas();
        centrarVentana(formN);
    }//GEN-LAST:event_menuItemNotasActionPerformed

    private void menuItemListAlumMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListAlumMatActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaAlumnosPorMateria formAxM = new VistaAlumnosPorMateria();
        centrarVentana(formAxM);
    }//GEN-LAST:event_menuItemListAlumMatActionPerformed

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuItemSalirActionPerformed

    public void centrarVentana(JInternalFrame ventana) {
        int x = escritorio.getWidth()/2 - ventana.getWidth()/2;
        int y = escritorio.getHeight()/2 - ventana.getHeight()/2;
        if (ventana.isShowing()) {
            ventana.setLocation(x, y);
        } else {
            escritorio.add(ventana);
            ventana.setLocation(x, y);
            ventana.show();
        }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu menuAdministracion;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuConsultas;
    private javax.swing.JMenuItem menuItemAlumnos;
    private javax.swing.JMenuItem menuItemInscripcion;
    private javax.swing.JMenuItem menuItemListAlumMat;
    private javax.swing.JMenuItem menuItemMateria;
    private javax.swing.JMenuItem menuItemNotas;
    private javax.swing.JMenuItem menuItemSalir;
    private javax.swing.JMenu menuSalir;
    // End of variables declaration//GEN-END:variables
}
