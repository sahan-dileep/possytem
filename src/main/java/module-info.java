module org.example.project01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.project01 to javafx.fxml;
    exports org.example.project01;
}