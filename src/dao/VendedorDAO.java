/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.UsuarioModel;

/**
 *
 * @author kiepe
 */
public class VendedorDAO {
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
    
    public void AtualizarVendedor(UsuarioModel user){
        String sql = "update Vendedor set nome = ?,senha = ? where usuarioId=?";
        con = Conexao.createConnection();
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1,user.getUsuario_nome());
            pstm.setString(2, user.getUsuario_senha());
            pstm.setInt(3,user.getUsuario_id());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Vendedor Atualizado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro Atualizar vendedor"+e);
        }
    }
    
    public void DeletarVendedor(int id){
        String sql = "delete from Vendedor where usuarioId=?";
        con = Conexao.createConnection();
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,id);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Vendedor deletado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro deletar Vendedor"+e);
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
