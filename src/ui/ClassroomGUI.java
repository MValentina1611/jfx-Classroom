package ui;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Classroom;
import model.UserAccount;

public class ClassroomGUI{

    @FXML
    private Pane loginPane;
    
    private Stage loginStage;
    
    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField passwordF;

    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnLogIn;

    @FXML
    private TableView<UserAccount> tvUserAccountList;

    @FXML
    private TableColumn<UserAccount, String> tcUsername;

    @FXML
    private TableColumn<UserAccount, String> tcGender;

    @FXML
    private TableColumn<UserAccount, String> tcCareer;

    @FXML
    private TableColumn<UserAccount, String> tcBirthday;

    @FXML
    private TableColumn<UserAccount, String> tcBrowser;

    @FXML
    private ObservableList<UserAccount> observableList;
    
    @FXML
    private Button btnLogOut;
    
    @FXML
    private ImageView imgProfilePhoto;
    
    //private Image imageProfilePhoto;
    
    @FXML
    private TextField txtCreateUsername;

    @FXML
    private PasswordField passwordFCreate;

    @FXML
    private TextField txtUrlProfilePhoto;

    @FXML
    private DatePicker dpBirthday;

    @FXML
    private Button btnSigInFfromCreate;

    @FXML
    private Button btnCreateAccount;

    @FXML
    private Button btnBrowser;

    @FXML
    private GridPane gpCreateAccount;
    
    @FXML
    private VBox vbxCreateAccount;
    
    @FXML
    private MenuButton mnbtnFBrowser;

    @FXML
    private MenuItem mniOperaB;

    @FXML
    private MenuItem mniMicroEdgeB;

    @FXML
    private MenuItem mniGoogleChromeB;
    
    @FXML
    private Pane paneForCheckbox;
    
    @FXML
    private Pane paneForGender;

    
    private Classroom classroom;
    
    @FXML
    private CheckBox chbxTE;

    @FXML
    private CheckBox chbxSE;

    @FXML
    private CheckBox chbxIE;
    
    @FXML
    private RadioButton rbtnMale;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton rbtnFemale;

    @FXML
    private RadioButton rbtnOther;

   
    
    //Builder
    public ClassroomGUI()
    {
    	loginStage = new Stage();
    	loginPane = new Pane();
    	classroom = new Classroom();
    	
	
    }

	
    //getters and setters
    
	public Pane getLoginPane() {
		return loginPane;
	}

	public void setLoginPane(Pane loginPane) {
		this.loginPane = loginPane;
	}  
    
	
	//Methods
	
    @FXML
    private void initializeTableView()
    {
    	observableList = FXCollections.observableArrayList( classroom.getUserAccountList());
    	
    	tvUserAccountList.setItems(observableList);
    	tcUsername.setCellValueFactory(new PropertyValueFactory<UserAccount, String> ("username"));
    	tcGender.setCellValueFactory(new PropertyValueFactory<UserAccount, String> ("gender"));
    	tcCareer.setCellValueFactory(new PropertyValueFactory<UserAccount, String> ("career"));
    	tcBirthday.setCellValueFactory(new PropertyValueFactory<UserAccount, String> ("birthday"));
    	tcBrowser.setCellValueFactory(new PropertyValueFactory<UserAccount, String> ("browser"));
    }
	

	public void showLogin( Pane mainPane ) throws IOException
	{

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		loginStage.setScene(scene);
		loginStage.setTitle("Classroom");
		loginStage.show(); 
	
	}
	
	
    @FXML
    public void directToCreateUserAccount(ActionEvent event) throws IOException 
    {
     	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
    	fxmlLoader.setController(this);
    	Parent register = fxmlLoader.load();
    	loginPane.getChildren().setAll( register );
    }
    
    @FXML
    public void showUserAccountList( ActionEvent event) throws IOException 
    {
    	String userNI = txtUsername.getText();
    	String passwordI = passwordF.getText();
    	int pos = 0;
    	if( classroom.verifyUser( userNI, passwordI ) )
    	{
         	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-list.fxml"));
        	fxmlLoader.setController(this);
        	Parent accountList = fxmlLoader.load();
        	loginPane.getChildren().setAll( accountList );
        	
        	pos = classroom.userPos(userNI, passwordI );
            imgProfilePhoto.setImage(classroom.getUserAccountList().get(pos).getUrlProfilePhoto());
        	
        	initializeTableView();
            	
    	}
    	
    	else
    	{
			Alert alert = new Alert(AlertType.ERROR);
	    	alert.setTitle("Classroom");
	    	alert.setHeaderText("ERROR");
	    	alert.setContentText("Username or password invalid");
	    	alert.showAndWait();
    	}
    }

    @FXML
    public void searchProfilePhoto(ActionEvent event) 
    {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Search Profile Photo");
               
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG", "*.png")
            );
             
            Stage stage = (Stage)vbxCreateAccount.getScene().getWindow();
            		
           File imgFile = fileChooser.showOpenDialog( stage );
           
           if(imgFile !=null) 
           {
        	   txtUrlProfilePhoto.setText(imgFile.getAbsolutePath());
               Classroom.profilePhoto = new Image ("file:"+imgFile.getAbsolutePath()); 
                    
           }
           
    }
    
    @FXML
    public void setTextFieldtoGoogleChrome(ActionEvent event) 
    {
    	mnbtnFBrowser.setText(mniGoogleChromeB.getText());
    }

    @FXML
    public void setTextFieldtoMicroEdge(ActionEvent event) 
    {
    	mnbtnFBrowser.setText(mniMicroEdgeB.getText());
    }

    @FXML
    public void setTextFieldtoOpera(ActionEvent event) 
    {
    	mnbtnFBrowser.setText(mniOperaB.getText());
    }
   
    public String  getBirthday()
    {
    	String birthday = null;
    	LocalDate bdate = dpBirthday.getValue();
    	if( bdate != null )
    	{
    		birthday = bdate.toString();
    	}
    		
    	return birthday;
    }
    
    public String getGender()
    {
    	String genderString = "";
    	
    	if (gender.getSelectedToggle().toString().equals("RadioButton[id=rbtnMale, styleClass=radio-button]'Male'")) 
    	{
             genderString ="Male";
        }
        else if (gender.getSelectedToggle().toString().equals("RadioButton[id=rbtnFemale, styleClass=radio-button]'Female'")) 
        {
            genderString ="Female";
        }
        else 
        {
            genderString ="Other";
        }
    	
    	return genderString;
    }
    
    public String getCareers()
    {
    	String career = "";
    		
    	if(chbxTE.isSelected())
    	{
    		career +=  chbxTE.getText() +"";
    	}
    	
    	if(chbxSE.isSelected())
    	{
    		career += chbxSE.getText() +"";
    	}
    	
    	if(chbxIE.isSelected())
    	{
    		career += chbxSE.getText() +"";
    	}
    	
    	return career;
    }
    
    public String[] getUserInfo()
    {
    	String username,
    			password,
    			urlPhoto,
    			genderString,
    			career,
    			birthday,
    			browser;
    	
    	
    	username = txtCreateUsername.getText(); 
    	password = passwordFCreate.getText();
    	urlPhoto = txtUrlProfilePhoto.getText();
    	birthday = getBirthday();
    	genderString = getGender();
    	career = getCareers();
    	browser = mnbtnFBrowser.getText();
    	
    	String[] userInfo = {username, password, genderString, career, birthday, browser, urlPhoto };
    	
    	return userInfo;
    }
     
    
    
    @FXML
    public void createAccount(ActionEvent event) 
    {
    	if(  classroom.verifyFullFields( getUserInfo() ) == false )   
    	{	
    		classroom.add(new UserAccount(getUserInfo()[0], getUserInfo()[1], getUserInfo()[2], getUserInfo()[3], 
    				getUserInfo()[4], getUserInfo()[5], Classroom.profilePhoto ));
    					
			Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Account created");
	    	alert.setHeaderText("WELCOME!");
	    	alert.setContentText("The new account has been created");
	    	alert.showAndWait();
    	}
    	
    	else
    	{
			Alert alert = new Alert(AlertType.ERROR);
	    	alert.setTitle("Validation Error");
	    	alert.setHeaderText("ERROR");
	    	alert.setContentText("You must fill each field in the form");
	    	alert.showAndWait();
    	}
    	
    	
    }

   
    
    @FXML
    public void directToHomeFromCreate(ActionEvent event) throws IOException 
    {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		loginStage.setScene(scene);
		loginStage.setTitle("Classroom");
		loginStage.show(); 
		
    }

    @FXML
    public void directToHome(ActionEvent event) throws IOException 
    {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		loginStage.setScene(scene);
		loginStage.setTitle("Classroom");
		loginStage.show(); 
    }



  
}

