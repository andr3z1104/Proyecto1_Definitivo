package proyecto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import clases.*;
/**
 *
 * @author andre
 */
public class Main {

    public static void main(String[] args) {
       Txt t = new Txt();
       System.setProperty("org.graphstream.ui", "swing");
       GrafoDefinitivo g = new GrafoDefinitivo(t.ListaUsuarios());
       GraficarGrafo a = new GraficarGrafo(g.getListaUsuarios());
       g.completarGrafo();
       g.print();
       g.printMA();
       a.mostrar();
       g.deleteVerticeGrafo("mazinger");
       g.print();
       a.mostrar();
 
    }
    
}
