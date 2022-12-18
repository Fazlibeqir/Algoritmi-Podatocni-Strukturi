module com.example.filefinder {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.filefinder to javafx.fxml;
    exports com.example.filefinder;
}