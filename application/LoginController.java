package application;
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

public class LoginController {

    @FXML
    private TextField tfLogin;

    @FXML
    private PasswordField tfPassword;

    @FXML
    void signInButtonClicked(ActionEvent event) {
        String login = tfLogin.getText();
        String password = tfPassword.getText();

        try {
            // Установка URL вашего сервера
            URL url = new URL("http://scenariw.ru.swtest.ru/searchUser.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // Формирование тела POST-запроса
            String postData = "login=" + login + "&password=" + password;
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
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
