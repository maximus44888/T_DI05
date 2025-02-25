package pujalte.martinez.juan.chinook;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static void viewReport(
            final InputStream jrxml,
            final String database,
            final Map<String, Object> parameters,
            final boolean isExitOnClose
    ) throws SQLException, JRException {
        final var connection = DriverManager.getConnection(database);
        final var jasperPrint = JasperFillManager.fillReport(jrxml, parameters != null ? new HashMap<>(parameters) : null, connection);
        JasperViewer.viewReport(jasperPrint, isExitOnClose);
    }
}
