package Relatorios;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.util.JRLoader;


        
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

public class GerarRelatorioCliente {

    public void gerar() {
        try {

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/PorjetoGestaoTads",
                "root",
                ""
            );

            JasperReport jasperReport = JasperCompileManager.compileReport(
                "C:/xampp/htdocs/ProjetoGestaoTads/ProjetoGestaoTads/src/Relatorios/Cliente.jrxml"
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