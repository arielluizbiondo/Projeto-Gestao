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
import model.bean.Clientes;
import model.bean.Usuario;

/**
 *
 * @author biond
 */
public class UsuarioDAO 
{
            public boolean loginUsuario(String login, String senha) 
        {
            Connection con = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            boolean check = false;
            
            
            try 
            {
                con = new ConnectionFactory().getConnection(); 
                String sql = "SELECT * FROM cliente where email = ? and senha = ?"; 
                stmt = con.prepareStatement(sql);
                stmt.setString(1, login);
                stmt.setString(2, senha);
                rs = stmt.executeQuery(); 

                if (rs.next()) 
                {
                    check = true;
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

            return check;
        }
}
