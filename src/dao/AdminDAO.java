
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import model.UsuarioModel;
import java.sql.ResultSet;

public class AdminDAO {
    Connection con = null;
    PreparedStatement pstm = null;
    
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
    
}
    
    
