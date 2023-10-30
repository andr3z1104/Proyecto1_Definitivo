package proyecto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import UIs.InterfazGeneral;
import clases.*;
/**
 *
 * @author andre
 */
public class Main {

    public static void main(String[] args) {
         System.setProperty("org.graphstream.ui", "swing");
        InterfazGeneral ventana = new InterfazGeneral();
        ventana.setVisible(true);
 
    }
    
}
