module pujalte.martinez.juan.chinook {
    requires javafx.controls;
    requires javafx.fxml;
    requires jasperreports;
    requires java.sql;
    requires log4j;


    opens pujalte.martinez.juan.chinook to javafx.fxml;
    exports pujalte.martinez.juan.chinook;
}