package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private static final String URL = "jdbc:sqlite:database.db";


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();
    }



    public static void main(String[] args) {
        //launch(args); // launches window

        Model model = new Model();
        if(!model.open()) {
            System.out.println("Can't open model");
        }

        ArrayList<Student> students = model.queryStudents();
        if (students == null) {
            System.out.println("No students");
        }

        for(Student student : students) {
            System.out.println("ID = " + student.getId() + ", Name = " + student.getName());
        }


        model.close();
    }
}
