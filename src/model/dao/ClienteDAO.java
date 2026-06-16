/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Clientes;
/**
 *
 * @author biond
 */
public class ClienteDAO
{
    Connection con;
 public void create(Clientes cliente) 
    {
        Connection con = (Connection) new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;

        try 
        {

            String sql = "INSERT INTO cliente (nome, senha, email, telefone, genero) VALUES (?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSenha());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getGenero());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente cadastrado do sucesso!");
        
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
 
        public ArrayList<Clientes> listarCLiente() 
        {
            ArrayList<Clientes> lista = new ArrayList<>();
            Connection con = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;

            try 
            {
                con = new ConnectionFactory().getConnection(); 
                String sql = "SELECT id,nome, email,telefone, genero FROM cliente"; 
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery(); 

                while (rs.next()) 
                {
                    Clientes cliente = new Clientes();
                    cliente.setId(rs.getInt("id"));
                    cliente.setNome(rs.getString("nome")); 
                    cliente.setEmail(rs.getString("email"));
                    cliente.setTelefone(rs.getString("telefone"));
                    cliente.setGenero(rs.getString("genero"));

                    lista.add(cliente);                      
                }

            } 
            catch (SQLException e) 
            {
                System.out.println("Erro ao listar clientes: " + e.getMessage());
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

        
        public int qtdClientes() 
        {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int quantidade = 0; // valor padrão

        try 
        {
            con = new ConnectionFactory().getConnection(); 
            String sql = "SELECT COUNT(*) AS total FROM cliente"; 
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) 
            {
                quantidade = rs.getInt("total");
                System.out.println("Quantidade de clientes no banco: " + quantidade);
            }
            else 
            {
                System.out.println("Nenhum cliente encontrado.");
            }

        } 
        catch (SQLException e) 
        {
            System.out.println("Erro ao contar clientes: " + e.getMessage());
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

    public ArrayList<Clientes> listarCLienteNome(String nome)
    {
        ArrayList<Clientes> lista = new ArrayList<>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            con = new ConnectionFactory().getConnection();

            String sql = "SELECT * FROM cliente WHERE nome LIKE ?";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            rs = stmt.executeQuery();

            while(rs.next())
            {
                Clientes c = new Clientes();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setGenero(rs.getString("genero"));
                c.setTelefone(rs.getString("telefone"));

                lista.add(c);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return lista;
    }
    
    public ArrayList<Clientes> listarCLienteEmail(String email)
    {
        ArrayList<Clientes> lista = new ArrayList<>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            con = new ConnectionFactory().getConnection();

            String sql = "SELECT * FROM cliente WHERE email LIKE ?";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            rs = stmt.executeQuery();

            while(rs.next())
            {
                Clientes c = new Clientes();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setGenero(rs.getString("genero"));
                c.setTelefone(rs.getString("telefone"));

                lista.add(c);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return lista;
    }
    public ArrayList<Clientes> listarCLienteTelefone(String telefone)
    {
        ArrayList<Clientes> lista = new ArrayList<>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            con = new ConnectionFactory().getConnection();

            String sql = "SELECT * FROM cliente WHERE telefone LIKE ?";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, telefone);

            rs = stmt.executeQuery();

            while(rs.next())
            {
                Clientes c = new Clientes();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setGenero(rs.getString("genero"));
                c.setTelefone(rs.getString("telefone"));

                lista.add(c);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return lista;
    }
    public ArrayList<Clientes> listarCLienteGenero(String genero)
    {
        ArrayList<Clientes> lista = new ArrayList<>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            con = new ConnectionFactory().getConnection();

            String sql = "SELECT * FROM cliente WHERE genero LIKE ?";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, genero);

            rs = stmt.executeQuery();

            while(rs.next())
            {
                Clientes c = new Clientes();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setGenero(rs.getString("genero"));
                c.setTelefone(rs.getString("telefone"));

                lista.add(c);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return lista;
    }
}
