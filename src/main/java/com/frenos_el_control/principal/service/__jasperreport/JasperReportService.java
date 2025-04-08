package com.frenos_el_control.principal.service.__jasperreport;


import lombok.Setter;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JasperReportService {

    private JasperReport jasperReport;
    @Setter
    private Map<String, Object> parameters;

    public JasperReportService() {
        try {
            this.parameters = new HashMap<>();
            ClassLoader classLoader = getClass().getClassLoader();
            URL jasperUrl = classLoader.getResource("jasperR/facturaReporte.jasper");
            assert jasperUrl != null;
            this.jasperReport = (JasperReport) JRLoader.loadObject(jasperUrl);
        } catch (JRException e) {
            System.out.println("Error" + e.getMessage());
        }

    }

    public byte[] imprimirReporte(List<InvoiceDetail> invoiceDetail) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            // Apartado del los datos
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(invoiceDetail);
            // El jasperPrint es el que se encarga de llenar el reporte con los datos
            JasperPrint jp = JasperFillManager.fillReport(jasperReport, new HashMap<>(parameters), dataSource);
            //JasperViewer.viewReport(jp, false);
            JasperExportManager.exportReportToPdfStream(jp, outputStream);
            System.out.println("Report Created Successfully" + parameters.toString());
            System.out.println("Invoice Details: "+invoiceDetail.toString());
            return outputStream.toByteArray();
        } catch (JRException e) {
            System.out.println("Error" + e.getMessage());
        }
        return null;
    }
}
