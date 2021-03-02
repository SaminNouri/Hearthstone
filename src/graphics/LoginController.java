package graphics;

import com.jfoenix.controls.JFXButton;
import game.GamePlayer;
import game.LoggerCreator;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable  {

    private Mapper mapper;

    @FXML
    private AnchorPane MainAnchorPane;

    @FXML
    private ImageView MainImage;

    @FXML
    private TextField UsernameTextField;

    @FXML
    private TextField PasswordTextField;

    @FXML
    private Button LoginButton;

    @FXML
    private Label UsernameLabel;

    @FXML
    private Label ResultLabel;

    @FXML
    private Button SignupButton;

    @FXML
    private Label PasswordLabel;

    @FXML
    private JFXButton QuitButton;

    @FXML
    private Text NotificationText;

    @FXML
    void getPasswordAction(ActionEvent event) {



    }

    @FXML
    void getUsernameAction(ActionEvent event) {

    }



    @FXML
    void loginAction(ActionEvent event) throws Exception {
        String Password=(PasswordTextField.getText().toString());
        String Username=(UsernameTextField.getText().toString());
        mapper.setPassword(Password);
        mapper.setUsername(Username);
        mapper.addRequest(Mapper.RequestType.Login);
        if(mapper.isInformationCorrect()) {
            ResultLabel.setText("welcome");
            update();
        }
        else
            ResultLabel.setText("wrong password/username");

        //update();

    }

    @FXML
    void quitAction(ActionEvent event) {

    }

    @FXML
    void signupAction(ActionEvent event) throws Exception {

        String Password=(PasswordTextField.getText().toString());
        String Username=(UsernameTextField.getText().toString());
        mapper.setPassword(Password);
        mapper.setUsername(Username);
        mapper.addRequest(Mapper.RequestType.SignUp);
        update();


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapper=Mapper.getInstance();

    }
   void update() throws IOException, LineUnavailableException, UnsupportedAudioFileException {

        ScreenController.activate();

    }


}