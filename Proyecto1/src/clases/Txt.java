
package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author UsuarioDeWindows
 */
public class Txt {
    
    public String Seleccionar(){
        String path;
        JFileChooser buscador = new JFileChooser();
        buscador.showOpenDialog(buscador);
        path = buscador.getSelectedFile().getAbsolutePath();
        return path;
    }
    
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
    
    public Lista ListaUsuarios(String path){
        String data = leer_txt(path);
        Lista ListaUsers = new Lista();
        
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
    }
    
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
    


}
