
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.ProdutoModel;
import model.UsuarioModel;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    Connection con = null;
    PreparedStatement pstm = null;
    
    public void CadastrarVendedor(UsuarioModel usuario){
        String sql = "insert into Vendedor(nome,senha) values(?,?)";
        con = Conexao.createConnection();
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1,usuario.getUsuario_nome());
            pstm.setString(2, usuario.getUsuario_senha());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Vendedor Cadastrado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro Cadastro vendedor"+e);
        }
    }
    
    public void CadastrarAdmin(UsuarioModel usuario){
        String sql = "insert into Admin(nome,senha) values(?,?)";
        con = Conexao.createConnection();
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1,usuario.getUsuario_nome());
            pstm.setString(2, usuario.getUsuario_senha());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Admin Cadastrado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro Cadastro admin"+e);
        }
    }
    
    public List<UsuarioModel> ExibirVendedor(){
        con = Conexao.createConnection();
        String sql = "select * from Vendedor";
        ArrayList<UsuarioModel> users = new ArrayList<>();
        try {
            pstm = con.prepareStatement(sql);
            ResultSet rset = pstm.executeQuery();
            
            while(rset.next()){
                UsuarioModel user = new UsuarioModel();
                user.setUsuario_id(rset.getInt("usuarioId"));
                user.setUsuario_nome(rset.getString("nome"));
                user.setUsuario_senha(rset.getString("senha"));
                users.add(user);
            }
        } catch (Exception e) {
        }
        return users;
    }
    
    public ResultSet AutenticarLoginAdmin(UsuarioModel usuario){
        con = Conexao.createConnection();
        try {
            String sql = "select * from Admin where nome = ? and senha = ?";
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1,usuario.getUsuario_nome());
            pstm.setString(2, usuario.getUsuario_senha());
            
            ResultSet rset = pstm.executeQuery();
            return rset;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro Login:"+e);
            return null;
        }
    }
    
    public ResultSet AutenticarLoginVendedor(UsuarioModel usuario){
        con = Conexao.createConnection();
        try {
            String sql = "select * from Vendedor where nome = ? and senha = ?";
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1,usuario.getUsuario_nome());
            pstm.setString(2, usuario.getUsuario_senha());
            
            ResultSet rset = pstm.executeQuery();
            return rset;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro Login:"+e);
            return null;
        }
    }
}
