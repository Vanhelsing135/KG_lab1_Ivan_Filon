module org.example.kg_lab1_ivan_filon {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.kg_lab1_ivan_filon to javafx.fxml;
    exports org.example.kg_lab1_ivan_filon;
}