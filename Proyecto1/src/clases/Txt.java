
package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class Txt {
    
    /**
     *Indica al usuario para que seleccione un archivo de texto (.TXT) usando el FileChooser
     * 
     * @return path, la ubicacion del archivo selecto
     */
    public String Seleccionar(){
        String path;
        JFileChooser buscador = new JFileChooser();
        buscador.showOpenDialog(buscador);
        path = buscador.getSelectedFile().getAbsolutePath();
        return path;
    }
    
    /**
     *Lee los contenidos del archivo de texto (.TXT)
     * 
     * @param path la ubicacion del archivo selecto a leer
     * @return usuarios_txt, los contenidos del archivo en forma de String
     */
    public String leer_txt(String path){
        String line;
        String usuarios_txt = "";
//        String path = Seleccionar();
        File file = new File(path);
        try{
            if (!file.exists()){
                file.createNewFile();
            }else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine())!= null ){
                    if (!line.isEmpty()){
                        usuarios_txt += line+ "\n";
                    }
                }
            }
        }catch(Exception err){
            JOptionPane.showMessageDialog(null, err);
        }
        
        return usuarios_txt;
        
    }
    
    /**
     *Analiza el contenido y crea una lista enlazada de usuarios con sus relaciones
     * la cual tambien se almacena en una lista enlazada
     * 
     * @param path la ubicacion del archivo de texto para analizar
     * @return ListaUsers, lista de usarios con sus relaciones
     */
    public Lista ListaUsuarios(String path){
        String data = leer_txt(path);
        Lista ListaUsers = new Lista();
        if (data!=""){
        String[] data_split = data.split("relaciones");
        String[] data_users = data_split[0].split("\n");
        String[] data_relations = data_split[1].split("\n");
        
        for (int i=1; i<data_users.length;i++){
            Usuario user = new Usuario(data_users[i].replace(" ","").replace("@",""));
            Lista relaciones = new Lista();
            
            for (int j=0;j<data_relations.length;j++){
                String[] relacion = data_relations[j].split(",");
                if (("@"+user.getName()).equals(relacion[0])){
                    String relacionado = relacion[1].replace(" ","").replace("@","");
                    relaciones.insertFinale(relacionado);
                }
            }
            
            user.setRelaciones(relaciones);
            ListaUsers.insertFinale(user);
  
        }
        return ListaUsers;
        }else{
        ListaUsers.insertFinale("TxtVacio");
        return ListaUsers;
        }
        
    }
    
    /**
     *Modifca el archivo de texto con datos nuevos
     * 
     * @param path la ubicacion del archivo de texto a modificar
     * @param data los nuevos datos que seran escritos en el archivo de texto
     */
    public void modificarTxt(String path, String data){
        try { 

            FileWriter output = new FileWriter(path);
            output.write(data); 
            output.close(); 
        } 
  
        catch (Exception e) { 
            e.getStackTrace(); 
        } 
    }
    
    /**
     *Modifica un String mediante la eliminacion de las ocurriencias de un
     * nombre especifico
     * 
     * @param s el String a modificar
     * @param name el nombre para remover del String
     * @return new_string, el String modificado
     */
    public String modificarStringd(String s, String name){
        String[] splits = s.split("\n");
        String new_string = "";
        for (int i=0;i<splits.length;i++){
            if (!splits[i].contains(name)){
                new_string+=splits[i]+"\n";
            }
        }
        
        return new_string;
    }
    
    /**
     *Modifca un String mediante la adicion de un nombre nuevo con sus relaciones nuevas
     * 
     * @param s el String a modificar
     * @param name el nombre al cual se le agrega sus relaciones
     * @param relaciones la lista de relaciones para agregar
     * @return new_string, el String modificado
     */
    public String modifiarStringAdd(String s, String name,Lista relaciones){
        String[] splits = s.split("\n");
        String new_string = "";
        for (int i=0;i<splits.length;i++){
            if (splits[i].equalsIgnoreCase("relaciones")){
                new_string+="@"+name+"\n"+splits[i]+"\n";
            }else{
                new_string+=splits[i]+"\n";
            }  
        }
        Nodo pAux = relaciones.getHead();
        while (pAux!=null){
            if (!((String) pAux.getElement()).equalsIgnoreCase("")){
            new_string+="@"+name+","+" "+"@"+((String) pAux.getElement())+"\n";
            }
            pAux=pAux.getNext();
        }
        return new_string;
    }
    


}
