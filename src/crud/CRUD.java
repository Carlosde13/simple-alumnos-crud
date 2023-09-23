/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crud;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deleo
 */
public class CRUD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<String[]> resultados = Consultas.obtenerunselect();
        
        ArrayList<Alumno> alumnos;
        alumnos = new ArrayList<>();
        
        for (String[] fila : resultados) {
            //System.out.println("ID: " + fila[0] + ", Nombre: " + fila[1] + ", Edad: " + fila[2]);
            Alumno a = new Alumno();
            a.setId(Integer.parseInt(fila[0]));
            a.setNombre(fila[1]);
            a.setEdad(Integer.parseInt(fila[2]));
            
            alumnos.add(a);
        }
        for (Alumno alumno : alumnos) {
            System.out.println("ID: " + alumno.getId() + ", Nombre: " + alumno.getNombre() + ", Edad: " + alumno.getEdad());
        }
        AdministrarAlumnos principalFrame = new AdministrarAlumnos();
        principalFrame.show();
    }
    
}
