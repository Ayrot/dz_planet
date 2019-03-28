package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Animation");
			Group root = new Group();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			Canvas canvas = new Canvas(512,512);
			root.getChildren().add(canvas);
			
			GraphicsContext gc = canvas.getGraphicsContext2D();
			Image sun = new Image("sun.png");
			Image earth = new Image("earth.png");
			Image space = new Image("space.png");
	
			
			new AnimationTimer() 
			{
				double x = 120.0;
				double y = 120.0;
				
				@Override
				public void handle(long now) {
					gc.drawImage(space, 0, 0);
					if(x==390.0 && y<390.0)
					{
						y=y+3.0;
						gc.drawImage(earth, x, y);
						
					}
					if(y==390.0 && x>120.0)
					{
						x=x-3.0;
						gc.drawImage(earth, x, y);
					}
					if(x==120.0 && y>120.0)
					{
						y=y-3.0;
						gc.drawImage(earth, x, y);
					}
					if(x<390.0 && y==120.0)
					{
						x=x+3.0;
						gc.drawImage(earth, x, y);
					}

					gc.drawImage(sun, 196, 196);
					
				}
				
			}.start();
			
			//gc.drawImage(sun, 200, 200);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
