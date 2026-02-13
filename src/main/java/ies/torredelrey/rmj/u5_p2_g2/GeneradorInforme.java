/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ies.torredelrey.rmj.u5_p2_g2;
import ies.torredelrey.rmj.u5_p2_g2.modelo.Empleados;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.view.JasperViewer;


public class GeneradorInforme {
    public static void leerInformeBD(List<Empleados> lista){
        try{
            JRDataSource datasource = new JRBeanArrayDataSource(lista.toArray());
            HashMap<String, Object> param = new HashMap<>();
            InputStream reportStream = GeneradorInforme.class.getResourceAsStream("/ireport/Proyecto_2.jasper");
            JasperPrint print = JasperFillManager.fillReport(reportStream, param, datasource);
            JasperExportManager.exportReportToPdfFile(print, "InfoEmpleado.pdf");
            JasperViewer.viewReport(print, false);

        } catch(JRException ex){
            Logger.getLogger(GeneradorInforme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
