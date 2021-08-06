package model;

/**
 *
 * @author User
 */
public enum Sexo {
    m("m"),
    f("f");
    
    private String descricao;
    
    private Sexo(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
}
