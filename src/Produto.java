
/**
 *
 * @author 2830482321037
 */
public class Produto { 
    
    private int idcategoria;
    private String categoria;
    private String nome;
    private float peso; 
    private String codigodebarra;  
     

    /**
     *  
     * @return the idcategoria
     */ 
     
    
    public int getIdcategoria() {
        return idcategoria;
    }

    /**
     * @param idcategoria the idcategoria to set
     */
    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the peso
     */
    public float getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }

    /**
     * @return the codigodebarra
     */
    public String getCodigodebarra() {
        return codigodebarra;
    }

    /**
     * @param codigodebarra the codigodebarra to set
     */
    public void setCodigodebarra(String codigodebarra) {
        this.codigodebarra = codigodebarra;
    } 
    
    @Override
public String toString() {
    return nome + " (" + codigodebarra + ")";
}
    
    
    
}
