package proyecto;


import clases.*;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.javafx.*;
import org.graphstream.ui.view.*;
import org.graphstream.ui.layout.*;

/**
 *
 * @author andre
 */
public class proyecto {

    public static void main(String[] args) {

       Txt t= new Txt();
       Lista l =new Lista();
       l.insertFinale("xoxojaime");
       l.insertFinale("pepe");
       String path = t.Seleccionar();
       
       t.modificarTxt(path, t.modifiarStringAdd(t.leer_txt(path), "luis", l));
       t.modificarTxt(path, t.modificarStringd(t.leer_txt(path), "luis"));
       System.setProperty("org.graphstream.ui", "swing");
       Graph a = new SingleGraph("hp");
       GRAFO g = new GRAFO(8);
       g.print();
//       g.insertArista(0, 1);
//       g.insertArista(2, 4);
//       g.insertArista(3, 1);
//       g.insertArista(2, 3);
//       g.insertArista(4, 3);

        //Aristas Kosaraju Prueba
        //NumVertices 5
//        g.insertArista(0, 1);
//        g.insertArista(0, 4);
//        g.insertArista(1, 3);
//        g.insertArista(2, 0);
//        g.insertArista(2, 4);

       g.insertArista(0, 2);
       g.insertArista(1, 0);
       g.insertArista(1, 3);
       g.insertArista(2, 4);
       g.insertArista(2, 3);
       g.insertArista(2, 1);
       g.insertArista(3, 5);
       g.insertArista(4, 5);
       g.insertArista(4, 6);
       g.insertArista(5, 3);
       g.insertArista(6, 4);
       g.insertArista(6, 7);
       g.insertArista(7, 5);
       g.insertArista(7, 6);
       


       g.print();
       g.kosaraju();
       
       g.print();
       
       g.insertVertice(1);
       g.print();
       
       
       
//       g.print();
//       g.deleteVertice(1);
////       g.print();
//       a.addNode("A");
//       a.addNode("B");
//       a.addNode("C");
//       a.addEdge("AB", "A", "B");
//       a.addEdge("BC", "B", "C");
//       Edge edge = a.getEdge("AB");
//       edge.setAttribute("ui.style", "fill-color: red;");
//       a.display();

       
    }
    
}
