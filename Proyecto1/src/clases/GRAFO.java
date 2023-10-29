
package clases;


/**
 *
 * @author andre
 *
 * 
 */
public class GRAFO {
    
    private boolean[] visitado;
    private int [][] matrixAdy;

    /**
     *Construye un objeto GRAFO usando una matriz de adyacencia con el numero especificado de vertices
     * 
     * @param n el numero the vertices de la matriz
     */
    public GRAFO(int n) {
        matrixAdy = new int [n][n];
    }

    /**
     *Retorna la matriz de adyacencia del GRAFO
     * 
     * @return la matriz de adyacencia
     */
    public int[][] getMatrixAdy() {
        return matrixAdy;
    }

    /**
     * Setea la matriz de adyacencia del GRAFO
     * 
     * @param matrixAdy
     */
    public void setMatrixAdy(int[][] matrixAdy) {
        this.matrixAdy = matrixAdy;
    }
    
    /**
     * Retorna un boolean array indicando si cada vertice fue visitado
     * 
     * @return boolean array indicando si cada vertice fue visitado
     */
    public boolean[] getVisitado(){
        return visitado;
    }

    /**
     *Checkea si el GRAFO esta vacio (no tiene vertices)
     * 
     * @return true si el GRAFO esta vacio, falso de lo contrario
     */
    public boolean isEmpty(){
        return getMatrixAdy().length == 0;
    }
    
    /**
     *Checkea si hay una arista entre dos vertices
     * 
     * @param i el indice del primer vertice
     * @param j el indice del segundo vertice
     * @return true si hay una arista entre dos vertices, falso de lo contrario
     */
    public boolean existArista(int i, int j){
        return matrixAdy[i][j] != 0;
    } 
    
    /**
     *Inserta una arista entre dos vertices
     * 
     * @param i el indice del primer vertice 
     * @param j el indice del segundo vertice
     */
    public void insertArista(int i, int j){
        matrixAdy[i][j] = 1;
    }
    
    /**
     *Borra la arista entre dos vertices
     * 
     * @param i el indice del primer vertice 
     * @param j el indice del segundo vertice
     */
    public void deleteArista(int i, int j){
        if(isEmpty()){
            System.out.println("Grafo vacio");
        }else if(i >= getMatrixAdy().length ||  j >= getMatrixAdy().length || !existArista(i, j)){
            System.out.println("No existen los vertices");
        }else{
            matrixAdy[i][j] = 0;
        }
    }
    
    /**
     *Inserta uno o mas vertice al GRAFO
     * 
     * @param n el numero de vertices a insertar
     */
    public void insertVertice(int n){
        int[][] newMatriz = new int [n + getMatrixAdy().length] [n + getMatrixAdy().length];
            for (int x = 0; x < getMatrixAdy().length; x++) {
                for (int y = 0; y < getMatrixAdy().length; y++)
                        newMatriz [x] [y] = matrixAdy [x] [y];
                }
           setMatrixAdy(newMatriz);
     }
    
    /**
     *Borra un vertice del GRAFO
     * 
     * @param v el indice del vertice a borrar
     */
    public void deleteVertice(int v){
        
        if(isEmpty()){
            System.out.println("Grafo Vacio");
            
        }else if( v > getMatrixAdy().length){
            
            System.out.println("Indice de vertice fuera de rango");
            
        }else{
            
            int [] [] deleteMatriz = new int [getMatrixAdy().length-1] [getMatrixAdy().length-1];

            
            for (int i = 0; i < getMatrixAdy().length; i++) {
                for (int j = 0; j < getMatrixAdy().length; j++) {
                    if(i<v && j<v){
                        deleteMatriz[i][j] = getMatrixAdy()[i][j];
                    }
                    else if (i<v && j>v) {
                        deleteMatriz[i][j-1] = getMatrixAdy()[i][j];
                    }
                    else if(i>v && j<v){
                        deleteMatriz[i-1][j] = getMatrixAdy()[i][j];
                        
                    }else if(i>v && j>v){
                        deleteMatriz[i-1][j-1] = getMatrixAdy()[i][j];
                    }
                        
                }

            }
            setMatrixAdy(deleteMatriz);
        }
        
        
    }
    
    /**
     *Hace el algoritmo de Kosaraju para encontrar los componentes fuertementes conectados del GRAFO
     * 
     * @return una Lista de Listas, en que cada Lista contiene los componentes fuertemente conectados
     */
    public Lista kosaraju(){
        int n = getMatrixAdy().length;
        boolean[] visitados = new boolean[n];
        StackKosa pila = new StackKosa();
    


        for (int i = 0; i < n; i++) {
            if (!visitados[i]) {
                findOrder(i, visitados, pila);
            }
        }

        GRAFO grafoTranspuesto = getTranspuesto();

        visitados = new boolean[n];
        Lista verticesFuertes = new Lista();
       

        while (!pila.isEmpty()) {
              int v = pila.pop().getElement();

            if (!visitados[v]) {
                Lista fuerte = new Lista();
                grafoTranspuesto.dfs(v, visitados, fuerte);
                verticesFuertes.insertFinale(fuerte);
               
            }
        }
        
         return verticesFuertes;
    }
    
    

    private void findOrder(int v, boolean[] visitados, StackKosa pila) {
        visitados[v] = true;

        for (int i = 0; i < getMatrixAdy().length; i++) {
            if (getMatrixAdy()[v][i] != 0 && !visitados[i]) {
                findOrder(i, visitados, pila);
            }
        }

        pila.push(v);
    }

    private void dfs(int v, boolean[] visitados, Lista fuerte) {
        visitados[v] = true;
        fuerte.insertFinale(v);

        for (int i = 0; i < getMatrixAdy().length; i++) {
            if (getMatrixAdy()[v][i] != 0 && !visitados[i]) {
                dfs(i, visitados, fuerte);
            }
        }
    }

    private GRAFO getTranspuesto() {
        int n = getMatrixAdy().length;
        GRAFO grafoTranspuesto = new GRAFO(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grafoTranspuesto.getMatrixAdy()[i][j] = getMatrixAdy()[j][i];
            }
        }

        return grafoTranspuesto;
    }
    
    /**
     *Printea la matriz de adjacencia del GRAFO
     * 
     */
    public void print(){
        System.out.println("Vertices: " + getMatrixAdy().length );
        for (int i = 0; i < getMatrixAdy().length; i++) {
            for (int j = 0; j < getMatrixAdy().length; j++) {
                System.out.print(matrixAdy[i][j]+" ");
            }
            System.out.println("");
        }
    }
    

}
    
