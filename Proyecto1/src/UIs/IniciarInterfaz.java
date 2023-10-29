/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package UIs;

/**
 *
 * @author ACER
 */
public class IniciarInterfaz {

    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");
        InterfazGeneral ventana = new InterfazGeneral();
        ventana.setVisible(true);
        
    }
}
