
package clases;

/**
 *
 * @author andre
 */
public class Usuario {
    
    private String name;
    private Lista relaciones;
    private int cantRelaciones;

    /**
     *Constructor del Usuario con un nombre
     * 
     * @param name, el nombre del Usuario
     */
    public Usuario(String name) {
        this.name = name;
    }

    /**
     *Constructor del Usuario con un nombre y su numero de relaciones
     * 
     * @param name, el nombre del Usuario
     * @param cantRelaciones, el numero de relaciones del usuario
     */
    public Usuario(String name, int cantRelaciones) {
        this.name = name;
        this.cantRelaciones = cantRelaciones;
    }

    /**
     *Retorna el nombre del Usuario
     * 
     * @return el nombre del Usuario
     */
    public String getName() {
        return name;
    }

    /**
     *Setea el nombre del Usuario
     * 
     * @param name el nombre a setear para el Usuario
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *Retorna la lista de relaciones del Usuario
     * 
     * @return la lista de relaciones del Usuario
     */
    public Lista getRelaciones() {
        return relaciones;
    }

    /**
     *Setea la lista de releaciones del usuario
     * 
     * @param relaciones la lista de relaciones a setear para el Usuario
     */
    public void setRelaciones(Lista relaciones) {
        this.relaciones = relaciones;
    }

    /**
     *Retorna el numero de relaciones del Usuario
     * 
     * @return el numero de relaciones del Usuario
     */
    public int getCantRelaciones() {
        return cantRelaciones;
    }

    /**
     *Setea la cantidad de relaciones para el Usuario
     * 
     * @param cantRelaciones el numero de relaciones para setear al Usuario
     */
    public void setCantRelaciones(int cantRelaciones) {
        this.cantRelaciones = cantRelaciones;
    }
}
