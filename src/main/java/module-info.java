module org.example.project01 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.project01 to javafx.fxml;
    exports org.example.project01;
    exports org.example.project01.tm;
    opens org.example.project01.tm to javafx.fxml;
    exports org.example.project01.controller;
    opens org.example.project01.controller to javafx.fxml;
}