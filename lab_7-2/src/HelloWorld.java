
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import static javafx.scene.text.Font.font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class HelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        //Nodes (components)
        Text myText = new Text ("Kalam Mlwn FX!");
        myText.setId("text");
       // myText.setFont(Font.font("Serif",FontWeight.BOLD, 24));
        //myText.setFill(Color.RED);
        Rectangle myRect = new Rectangle (400,300);
        StackPane pane = new StackPane ();
        pane.getChildren().add(myRect);
        pane.getChildren().add(myText);
        
        //Reflection
        Reflection myReflection = new Reflection(10,2,0.5,2); //
        myText.setEffect(myReflection);
  
        
        //LinearGradient
        LinearGradient g
      = LinearGradient.valueOf("linear-gradient(from 0px 0px to 0px 300px, black 0%, white 50%, black 100% )");
        myRect.setFill(g);

        
        //Scene
        Scene myScene = new Scene (pane,400,300);
        myScene.getStylesheets().add(getClass().getResource("style.css").toString());
        myText.getStyleClass().add("MyStyleClass");
        
        //stage
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setTitle("JavaFX");
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
    
    
    public static void main (String[] args){
        
        Application.launch();
    }
    
}
