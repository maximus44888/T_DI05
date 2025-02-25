package pujalte.martinez.juan.chinook;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Utils {

    public static final Supplier<Connection> connection;

    static {
        connection = () -> {
            try {
                return DriverManager.getConnection("jdbc:sqlite:chinook.db");
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static void viewReport(
            final InputStream jrxml,
            final Connection connection,
            final Map<String, Object> parameters,
            final boolean isExitOnClose
    ) throws JRException {
        final var jasperPrint = JasperFillManager.fillReport(
                JasperCompileManager.compileReport(jrxml),
                parameters != null ? new HashMap<>(parameters) : null,
                connection
        );
        JasperViewer.viewReport(jasperPrint, isExitOnClose);
    }
}
