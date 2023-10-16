package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;
import javax.swing.JOptionPane;
import model.ProdutoModel;
import java.sql.ResultSet;

public class ProdutoDAO {

    Connection con = null;
    PreparedStatement pstm = null;
    ResultSet rset = null;

    public void CadastrarProduto(ProdutoModel produto) {
        String sql = "insert into Produto (nome,descricao,precoUnitario,estoque) values(?,?,?,?)";
        try {
            con = Conexao.createConnection();
            pstm = con.prepareStatement(sql);

            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());
            pstm.setDouble(3, produto.getPreco());
            pstm.setInt(4, produto.getEstoque());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Produto Cadastrado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro Cadastrar:" + e);
        }
    }

    public void Atualizar(ProdutoModel produto) {
        String sql = "update produto set nome=?, descricao=?,precoUnitario=?,estoque=? where produtoId=?";
        try {
            con = Conexao.createConnection();
            pstm = con.prepareStatement(sql);

            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());
            pstm.setDouble(3, produto.getPreco());
            pstm.setInt(4, produto.getEstoque());
            pstm.setInt(5, produto.getId());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Produto Atualizado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro Atualizar:" + e);
        }
    }

    public void Deletar(int id) {
        String sql = "delete  from Produto where produtoId=?";
        try {
            con = Conexao.createConnection();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Produto Deletado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro Deletar:" + e);
        }
    }

    public List<ProdutoModel> Exibirprodutos() {
        String sql = "select * from Produto";
        ArrayList<ProdutoModel> produtos = new ArrayList<>();
        try {
            con = Conexao.createConnection();
            pstm = con.prepareStatement(sql);
            rset = pstm.executeQuery();
            while (rset.next()) {
                ProdutoModel produto = new ProdutoModel();

                produto.setNome(rset.getString("nome"));
                produto.setDescricao(rset.getString("descricao"));
                produto.setPreco(rset.getDouble("precoUnitario"));
                produto.setEstoque(rset.getInt("estoque"));
                produto.setId(rset.getInt("produtoId"));
                produtos.add(produto);
            }
            return produtos;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro Exibir:" + e);
            return null;
        }
    }
}
