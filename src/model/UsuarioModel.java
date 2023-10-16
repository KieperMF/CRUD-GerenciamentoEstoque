package model;

public class UsuarioModel {
    private int usuario_id;
    private String usuario_nome;
    private String usuario_senha;

    public UsuarioModel() {
    }

    public UsuarioModel(String usuario_nome, String usuario_senha) {
        this.usuario_nome = usuario_nome;
        this.usuario_senha = usuario_senha;
    }
    
    

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsuario_nome() {
        return usuario_nome;
    }

    public void setUsuario_nome(String usuario_nome) {
        this.usuario_nome = usuario_nome;
    }

    public String getUsuario_senha() {
        return usuario_senha;
    }

    public void setUsuario_senha(String usuario_senha) {
        this.usuario_senha = usuario_senha;
    }
    
    
}
