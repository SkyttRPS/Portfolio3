package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);

        Model model = new Model();
        if(!model.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        List<Student> students = model.queryStudents();
        if(students == null) {
            System.out.println("No Students!");
            return;
        }

        for(Student student : students) {
            System.out.println("ID = " + student.getId() + ", Name = " + student.getName());
        }

        model.close();
    }
    @Override
    public void start(Stage primaryStage) throws Exception{

        String url = "jdbc:sqlite:database.db";

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Student Database");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
