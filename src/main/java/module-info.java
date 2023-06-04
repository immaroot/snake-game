module com.immaroot.snakegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.immaroot.snakegame to javafx.fxml;
    exports com.immaroot.snakegame;
}