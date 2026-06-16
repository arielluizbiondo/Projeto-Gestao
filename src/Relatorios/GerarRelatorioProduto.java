/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Relatorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author biond
 */
public class GerarRelatorioProduto {
    public void gerar() {
        try {

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/PorjetoGestaoTads",
                "root",
                ""
            );

            JasperReport jasperReport = JasperCompileManager.compileReport(
                "C:/xampp/htdocs/ProjetoGestaoTads/ProjetoGestaoTads/src/Relatorios/Produtos.jrxml"
            );

            JasperPrint print = JasperFillManager.fillReport(
                jasperReport,
                new HashMap<>(),
                con
            );

            JasperViewer.viewReport(print, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
