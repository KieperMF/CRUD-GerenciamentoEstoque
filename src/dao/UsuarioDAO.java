
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.ProdutoModel;
import model.UsuarioModel;

public class UsuarioDAO {
    Connection con = null;
    PreparedStatement pstm = null;
    
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
