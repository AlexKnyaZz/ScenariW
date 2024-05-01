package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Controller {
	
	@FXML
	private Button btnSignIn, btnSignUp;
	@FXML
	private Pane pnSignUp, pnSignIn;
	@FXML
	private ImageView btnBack;
	
	@FXML
    private TextField tfLogin;
	
	@FXML
    private Text txtIncLog;
	
	@FXML
    private Text txtIncPass;

    @FXML
    private PasswordField tfPassword;
	
	@FXML
	public void toMain(ActionEvent event) {
		btnSignIn.setOnAction(e ->{
			try {
				Scene curScene = btnSignIn.getScene();
				Pane root = (Pane) curScene.getRoot();
				Stage stage = new Stage();
				Parent main = FXMLLoader.load(getClass().getResource("main.fxml"));
				//stage.setScene(new Scene(main));
				
				root.getChildren().setAll(main);
				
		        //stage.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	@FXML
	public void signUp(ActionEvent event) {
		if (event.getSource().equals(btnSignUp)){
			pnSignUp.toFront();
		}
	}
	
	@FXML
	public void back(MouseEvent event) {
		if (event.getSource().equals(btnBack)){
			pnSignIn.toFront();
		}
	}
	
	/*
	@FXML
	public void signUp(ActionEvent event) {
		if (event.getSource().equals(btnSignUp)){
			pnSignUp.toFront();
		}
	}
	
	
	
	@FXML
	private void handleMouseEvent(MouseEvent event) {
		if(event.getSource().equals(btnBack)) {
			pnSignIn.toFront();
		}
	} */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	
	public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	@FXML
	void signInButtonClicked(ActionEvent event) {
	    String login = tfLogin.getText();
	    String password = tfPassword.getText();
	    String hashedPassword = hashPassword(password);

	    try {
	        // Установка URL вашего сервера
	        URL url = new URL("http://scenariw.ru.swtest.ru/searchUser.php");
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("POST");
	        connection.setDoOutput(true);

	        // Формирование тела POST-запроса
	        String postData = "login=" + login + "&password=" + hashedPassword;
	        byte[] postDataBytes = postData.getBytes(StandardCharsets.UTF_8);

	        // Отправка POST-запроса на сервер
	        try (OutputStream os = connection.getOutputStream()) {
	            os.write(postDataBytes);
	        }

	        // Получение ответа от сервера
	        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
	            StringBuilder response = new StringBuilder();
	            String line;
	            while ((line = in.readLine()) != null) {
	                response.append(line);
	            }

	            // Обработка ответа от сервера
	            String serverResponse = response.toString();
	            // Здесь вы можете обновить интерфейс в соответствии с ответом от сервера
	            System.out.println("Server response: " + serverResponse);
	            
	         // Получение куков из заголовков ответа
	            Map<String, List<String>> headerFields = connection.getHeaderFields();
	            List<String> cookiesHeader = headerFields.get("Set-Cookie");
	            if (cookiesHeader != null) {
	                for (String cookieHeader : cookiesHeader) {
	                    System.out.println("Cookie: " + cookieHeader);
	                    // Проверяем каждый куки и извлекаем идентификатор сессии, если он присутствует
	                    if (cookieHeader.startsWith("PHPSESSID=")) {
	                        String sessionId = cookieHeader.split(";")[0].substring("PHPSESSID=".length());
	                        System.out.println("Session ID: " + sessionId);
	                        // Здесь вы можете использовать полученный идентификатор сессии
	                        saveSessionId(sessionId);
	                    }
	                }
	            }
	            
	            if(serverResponse.equals("Incorrect login")) {
	                txtIncLog.setVisible(true);
	                txtIncPass.setVisible(false);
	            } else if(serverResponse.equals("Incorrect password")) {
	                txtIncPass.setVisible(true);
	                txtIncLog.setVisible(false);
	            } else if(serverResponse.equals("User found")) {
	                txtIncLog.setVisible(false);
	                txtIncPass.setVisible(false);
	                
	                try {
	                    Scene curScene = btnSignIn.getScene();
	                    Pane root = (Pane) curScene.getRoot();
	                    Stage stage = new Stage();
	                    Parent main = FXMLLoader.load(getClass().getResource("main.fxml"));
	                    //stage.setScene(new Scene(main));
	                    
	                    root.getChildren().setAll(main);
	                    
	                    //stage.show();
	                } catch (IOException e1) {
	                    // TODO Auto-generated catch block
	                    e1.printStackTrace();
	                }
	            }
	            
	        }

	        connection.disconnect();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	// Класс для представления пары ключ-значение
	public class SessionData {
	    public String key;
	    public String value;

	    public SessionData(String key, String value) {
	        this.key = key;
	        this.value = value;
	    }
	}

	// Метод для сохранения идентификатора сессии в SharedPreferences
	private void saveSessionId(String sessionId) {
		// Создаем объект для пары ключ-значение
	    SessionData sessionData = new SessionData("sessionId", sessionId);
	    // Создаем Gson
	    Gson gson = new Gson();
	    // Конвертируем объект в JSON строку
	    String json = gson.toJson(sessionData);

	    try {
	        // Указываем путь к файлу, куда будем сохранять данные
	        String directoryPath = "D:\\ScenariW\\data";
	        String fileName = "sessionData.json";

	        // Создаем директорию, если она не существует
	        Path directory = Paths.get(directoryPath);
	        if (!Files.exists(directory)) {
	            Files.createDirectories(directory);
	        }

	        // Создаем путь к файлу
	        Path filePath = Paths.get(directoryPath, fileName);

	        // Записываем JSON строку в файл
	        try (FileWriter writer = new FileWriter(filePath.toString())) {
	            writer.write(json);
	            System.out.println("Session ID saved: " + sessionId);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}
