module modulefx {
    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    exports it.unicam.cs.ids2021;
    opens it.unicam.cs.ids2021 to javafx.fxml;

    exports it.unicam.cs.ids2021.interaction;
    opens it.unicam.cs.ids2021.interaction to javafx.fxml;
}

