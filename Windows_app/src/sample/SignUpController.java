package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField login_field;

    @FXML
    private Button authSignUpButton;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField signUPLastName;

    @FXML
    private TextField signUpCountry;

    @FXML
    private CheckBox signUpCheckBoxMale;

    @FXML
    private CheckBox signUpCheckBoxFemale;

    @FXML
    private Button signUpGoBackBtn;

    @FXML
    void initialize() {

        Tooltip tolSignUpName = new Tooltip("You need to enter your real name! \uD83D\uDC13");
        Tooltip tolSignUPLastName = new Tooltip("You need to enter your family name! \uD83D\uDC10");
        Tooltip tolpassword_field = new Tooltip("Enter password!");
        Tooltip tolAuthSignUpButton = new Tooltip("Press if you have filled all fields! ");
        Tooltip tolLogin_field = new Tooltip("Enter your nickname!");
        Tooltip tolSignUpCountry = new Tooltip("Where are you from?! ");
        Tooltip tolSignUpCheckBoxMale = new Tooltip("Do you have ballz?!");
        Tooltip tolSignUpCheckBoxFemale = new Tooltip("Do you have varenik?!");
        Tooltip tolSingUpGoBack = new Tooltip("Press if you want to go back!");


        signUpName.setTooltip(tolSignUpName);
        signUPLastName.setTooltip(tolSignUPLastName);
        password_field.setTooltip(tolpassword_field);
        authSignUpButton.setTooltip(tolAuthSignUpButton);
        login_field.setTooltip(tolLogin_field);
        signUpCountry.setTooltip(tolSignUpCountry);
        signUpCheckBoxMale.setTooltip(tolSignUpCheckBoxMale);
        signUpCheckBoxFemale.setTooltip(tolSignUpCheckBoxFemale);
        signUpGoBackBtn.setTooltip(tolSingUpGoBack);


        authSignUpButton.setOnAction(event -> {

            signUpNewUser();});
            signUpGoBack();

//        authSignUpButton.setOnAction(event -> {
//
////            if(!login_field.equals("") && !password_field.equals("") && !signUpName.equals("")
////                    && !signUPLastName.equals("")   && !signUpCountry.equals("")  ){
////                System.out.println("\uD83D\uDC13Error.\uD83D\uDC13 Some filed(s) are empty!\uD83D\uDC13");
////            }
//            authSignUpButton.getScene().getWindow().hide();
//
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("/sample/app.fxml"));
//
//            try {
//                loader.load();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            Parent root = loader.getRoot();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.showAndWait();
//        });
        }
        private void signUpGoBack () {
            signUpGoBackBtn.setOnAction(event -> {

                signUpGoBackBtn.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/sample.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();

            });
        }
        private void signUpNewUser () {

            DatabaseHandler dbhandler = new DatabaseHandler();

            String firstName = signUpName.getText();
            String lastName = signUPLastName.getText();
            String userName = login_field.getText();
            String password = password_field.getText();
            String location = signUpCountry.getText();
            String gender = "";

//            if(signUpName.toString().trim().length()==0 || signUPLastName.toString().trim().length()==0 ||
//                    login_field.toString().trim().length()==0 || password_field.toString().trim().length()==0 ||
//                    signUpCountry.toString().trim().length()==0 ){
//
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//
//                alert.setTitle("Ohh, shit!");
//                alert.setHeaderText(null);
//                alert.setContentText("Please, fill all fields!");
//
//                alert.showAndWait();
//
//            }

            if (signUpCheckBoxMale.isSelected() && signUpCheckBoxFemale.isSelected()) {
                gender = "FU***NG FREAK!!";

            } else if (signUpCheckBoxMale.isSelected()) {
                gender = "Male";
            } else if (signUpCheckBoxFemale.isSelected()) {
                gender = "Female";
            } else {
                gender = "is not specify";
            }

            User user = new User(firstName, lastName, userName, password, location, gender);

            dbhandler.signUpUser(user);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Great!");
            alert.setHeaderText(null);
            alert.setContentText("Sucsess. Now go back and sign in!");

            alert.showAndWait();


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/sample.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        }
    }
