
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

    public GRAFO(int n) {
        matrixAdy = new int [n][n];
    }

    public int[][] getMatrixAdy() {
        return matrixAdy;
    }

    public void setMatrixAdy(int[][] matrixAdy) {
        this.matrixAdy = matrixAdy;
    }
    
    public boolean[] getVisitado(){
        return visitado;
    }

    
    public boolean isEmpty(){
        return getMatrixAdy().length == 0;
    }
    
    public boolean existArista(int i, int j){
        return matrixAdy[i][j] != 0;
    } 
    
    public void insertArista(int i, int j){
        matrixAdy[i][j] = 1;
    }
    
    public void deleteArista(int i, int j){
        if(isEmpty()){
            System.out.println("Grafo vacio");
        }else if(i >= getMatrixAdy().length ||  j >= getMatrixAdy().length || !existArista(i, j)){
            System.out.println("No existen los vertices");
        }else{
            matrixAdy[i][j] = 0;
        }
    }
    
    
     public void insertVertice(int n){
        int[][] newMatriz = new int [n + getMatrixAdy().length] [n + getMatrixAdy().length];
            for (int x = 0; x < getMatrixAdy().length; x++) {
                for (int y = 0; y < getMatrixAdy().length; y++)
                        newMatriz [x] [y] = matrixAdy [x] [y];
                }
           setMatrixAdy(newMatriz);
     }
    
    
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
    
   
    
    
    public void kosaraju(){
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

        while (!pila.isEmpty()) {
              int v = pila.pop().getElement();

            if (!visitados[v]) {
                System.out.print("Componente fuertemente conexa: ");
                grafoTranspuesto.dfs(v, visitados);
                System.out.println();
            }
        }
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

    private void dfs(int v, boolean[] visitados) {
        visitados[v] = true;
        System.out.print(v + " ");

        for (int i = 0; i < getMatrixAdy().length; i++) {
            if (getMatrixAdy()[v][i] != 0 && !visitados[i]) {
                dfs(i, visitados);
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
    
