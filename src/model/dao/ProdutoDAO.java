/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Produto;


/**
 *
 * @author biond
 */
public class ProdutoDAO 
{
    public void create(Produto produto) 
    {
        Connection con = (Connection) new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;

        try 
        {

            String sql = "INSERT INTO produtos (nome, valor, quantidade, fabricante, descricao) VALUES (?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getValor());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setString(4, produto.getFabricante());
            stmt.setString(5, produto.getDescricao());
            
            stmt.executeUpdate();
        
            JOptionPane.showMessageDialog(null, "Produto cadastrado do sucesso!");
        } 
        catch (SQLException e) 
        {
            System.out.println("Erro ao inserir: " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar recursos: " + ex.getMessage());
            }
        }
    }
    public ArrayList<Produto> listarProduto() 
        {
            ArrayList<Produto> lista = new ArrayList<>();
            Connection con = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;

            try 
            {
                con = new ConnectionFactory().getConnection(); 
                String sql = "SELECT * FROM produtos"; 
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery(); 

                while (rs.next()) 
                {
                    //Clientes cliente = new Clientes();
                    Produto Produto = new Produto();
                    Produto.setNome(rs.getString("nome")); 
                    Produto.setValor(rs.getFloat("valor"));
                    Produto.setQuantidade(rs.getInt("quantidade"));
                    Produto.setFabricante(rs.getString("fabricante"));
                    Produto.setDescricao(rs.getString("descricao"));

                    
                    lista.add(Produto);                      
                }

            } 
            catch (SQLException e) 
            {
                System.out.println("Erro ao listar Produtos: " + e.getMessage());
            } 
            finally 
            {
                try 
                {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (con != null) con.close();
                } 
                catch (SQLException ex) 
                {
                    System.out.println("Erro ao fechar recursos: " + ex.getMessage());
                }
            }

            return lista;
        }
    
    public int qtdProdutos() 
        {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int quantidade = 0; // valor padrão

        try 
        {
            con = new ConnectionFactory().getConnection(); 
            String sql = "SELECT COUNT(*) AS total FROM produtos"; 
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) 
            {
                quantidade = rs.getInt("total");
            }

        } 
        catch (SQLException e) 
        {
            System.out.println("Erro ao contar produtos: " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println("Erro ao fechar recursos: " + ex.getMessage());
            }
        }

        return quantidade;
    }
public ArrayList<Produto> listarProdutoNome(String nome)
    {
        ArrayList<Produto> lista = new ArrayList<>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            con = new ConnectionFactory().getConnection();

            String sql = "SELECT * FROM produtos WHERE nome LIKE ?";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            rs = stmt.executeQuery();

            while(rs.next())
            {
                Produto p = new Produto();

                p.setNome(rs.getString("nome"));
                p.setValor(rs.getDouble("valor"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setFabricante(rs.getString("fabricante"));
                p.setDescricao(rs.getString("descricao"));
                
                lista.add(p);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return lista;
    }

    public ArrayList<Produto> listarProdutoValor(String valor) {
        ArrayList<Produto> lista = new ArrayList<>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = new ConnectionFactory().getConnection();

            String sql = "SELECT * FROM produtos WHERE CAST(valor AS CHAR) LIKE ?";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + valor + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();

                p.setNome(rs.getString("nome"));
                p.setValor(rs.getDouble("valor"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setFabricante(rs.getString("fabricante"));
                p.setDescricao(rs.getString("descricao"));

                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return lista;
    }
    
    public ArrayList<Produto> listarProdutoQuantidade(String quantidade) {
        ArrayList<Produto> lista = new ArrayList<>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = new ConnectionFactory().getConnection();

            String sql = "SELECT * FROM produtos WHERE CAST(quantidade AS CHAR) LIKE ?";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + quantidade + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();

                p.setNome(rs.getString("nome"));
                p.setValor(rs.getDouble("valor"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setFabricante(rs.getString("fabricante"));
                p.setDescricao(rs.getString("descricao"));

                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return lista;
    }
    public ArrayList<Produto> listarProdutoFabricante(String fabricante)
    {
        ArrayList<Produto> lista = new ArrayList<>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            con = new ConnectionFactory().getConnection();

            String sql = "SELECT * FROM produtos WHERE fabricante LIKE ?";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, fabricante);

            rs = stmt.executeQuery();

            while(rs.next())
            {
                Produto p = new Produto();

                p.setNome(rs.getString("nome"));
                p.setValor(rs.getDouble("valor"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setFabricante(rs.getString("fabricante"));
                p.setDescricao(rs.getString("descricao"));
                
                lista.add(p);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return lista;
    }
    
    public ArrayList<Produto> listarProdutoDescricao(String descricao)
    {
        ArrayList<Produto> lista = new ArrayList<>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            con = new ConnectionFactory().getConnection();

            String sql = "SELECT * FROM produtos WHERE descricao LIKE ?";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, descricao);

            rs = stmt.executeQuery();

            while(rs.next())
            {
                Produto p = new Produto();

                p.setNome(rs.getString("nome"));
                p.setValor(rs.getDouble("valor"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setFabricante(rs.getString("fabricante"));
                p.setDescricao(rs.getString("descricao"));
                
                lista.add(p);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return lista;
    }
}

