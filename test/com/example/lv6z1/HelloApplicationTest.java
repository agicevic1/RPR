package com.example.lv6z1;
import static org.junit.jupiter.api.Assertions.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
@ExtendWith(ApplicationExtension.class)
class HelloAplicationTest {
    private Label display;
    @Start
    public void start(Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(Main.class.getResource("/fxml/digitron.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Test
    public void startWithZero (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        assertEquals("0", display.getText());
    }

    @Test
    public void numberOne (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#btn1");
        assertEquals("1", display.getText());
    }

    @Test
    public void number123 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#dugmad[0]");
        robot.clickOn("#dugmad[1]");
        robot.clickOn("#dugmad[2]");
        assertEquals("123", display.getText());
    }

    @Test
    public void number123Plus456 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#dugmad[0]");
        robot.clickOn("#dugmad[1]");
        robot.clickOn("#dugmad[2]");
        robot.clickOn("#plus");
        robot.clickOn("#dugmad[3]");
        robot.clickOn("#dugmad[4]");
        robot.clickOn("#dugmad[5]");
        assertEquals("456", display.getText());
    }

    @Test
    public void number123Plus456Equals (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#dugmad[0]");
        robot.clickOn("#dugmad[1]");
        robot.clickOn("#dugmad[2]");
        robot.clickOn("#plus");
        robot.clickOn("#dugmad[3]");
        robot.clickOn("#dugmad[4]");
        robot.clickOn("#dugmad[5]");
        robot.clickOn("#jednako");
        assertEquals("579.0", display.getText());
    }

    @Test
    public void dotBtn (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#dugmad[7]");
        robot.clickOn("#dugmad[8]");
        robot.clickOn("#tacka");
        robot.clickOn("#dugmad[]");
        robot.clickOn("#dugmad[7]");
        robot.clickOn("#plus");
        robot.clickOn("#dugmad[0]");
        robot.clickOn("#jednako");
        assertEquals("89.88", display.getText());
    }

    @Test
    public void zeroBtn (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#nula");
        robot.clickOn("#nula");
        assertEquals("0", display.getText());
    }

    @Test
    public void zeroBtn2 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#nula");
        robot.clickOn("#nula");
        robot.clickOn("#dugmad[1]");
        robot.clickOn("#nula");
        assertEquals("10", display.getText());
    }

    @Test
    public void timesBtn(FxRobot robot){
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#dugmad[1]");
        robot.clickOn("#tacka");
        robot.clickOn("#dugmad[2]");
        robot.clickOn("#puta");
        robot.clickOn("#dugmad[6]");
        robot.clickOn("#tacka");
        robot.clickOn("#dugmad[7]");
        robot.clickOn("#jednako");
        assertEquals("24.32", display.getText());
    }

    @Test
    public void divideBtn(FxRobot robot){
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#dugmad[8]");
        robot.clickOn("#tacka");
        robot.clickOn("#dugmad[6]");
        robot.clickOn("#crta");
        robot.clickOn("#dugmad[3]");
        robot.clickOn("#tacka");
        robot.clickOn("#dugmad[4]");
        robot.clickOn("#jednako");
        assertEquals("2.1555555555555554", display.getText());
    }

    @Test
    public void modBtn(FxRobot robot){
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#dugmad[8]");
        robot.clickOn("#procenat");
        robot.clickOn("#dugmad[1]");
        robot.clickOn("#jednako");
        assertEquals("1.0", display.getText());
    }

    @Test
    public void dijeljenjeNulom(FxRobot robot){
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#dugmad[5]");
        robot.clickOn("#crta");
        robot.clickOn("#nula");
        robot.clickOn("#jednako");
        assertEquals("Infinity", display.getText());
    }
    @Test
    public void mnozenjeNulom(FxRobot robot){
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#dugmad[6]");
        robot.clickOn("#tacka");
        robot.clickOn("#dugmad[3]");
        robot.clickOn("#puta");
        robot.clickOn("#nula");
        robot.clickOn("#jednako");
        assertEquals("0", display.getText());
    }
    @Test
    public void mnozenjeRandom(FxRobot robot){
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#dugmad[2]");
        robot.clickOn("#tacka");
        robot.clickOn("#dugmad[1]");
        robot.clickOn("#puta");
        robot.clickOn("#dugmad[5]");
        robot.clickOn("#jednako");
        assertEquals("19.2", display.getText());
    }
    @Test
    public void dijeljenjeRandom(FxRobot robot){
        display = robot.lookup("#display").queryAs(Label.class);
        robot.clickOn("#dugmad[8]");
        robot.clickOn("#tacka");
        robot.clickOn("#dugmad[1]");
        robot.clickOn("#crta");
        robot.clickOn("#dugmad[5]");
        robot.clickOn("#jednako");
        assertEquals("1.5333333333333332", display.getText());
    }
}