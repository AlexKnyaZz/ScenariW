
	 
/*
 *	This content is generated from the API File Info.
 *	(Alt+Shift+Ctrl+I).
 *
 *	@desc
 *	@file 		authorisation
 *	@date 		Monday 25th of March 2024 09:59:09 AM
 *	@title 		Page 1
 *	@author
 *	@keywords
 *	@generator 	Export Kit v1.3.figma
 *
 */


package alex.knyazz.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class registration extends Activity implements View.OnClickListener{


    private TextView __________________;
    private EditText loginEditText, passwordEditText;
    private EditText editTextTextEmailAddress, editTextDate;
    private Button btnSignUp;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);


        //есть аккаунт
        __________________ = (TextView) findViewById(R.id.__________________);
        __________________.setOnClickListener(this);

        loginEditText = (EditText) findViewById(R.id.login);
        passwordEditText = (EditText) findViewById(R.id.password);
        editTextTextEmailAddress = (EditText) findViewById(R.id.editTextTextEmailAddress);
        editTextDate = (EditText) findViewById(R.id.editTextDate);

        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(this);


        //custom code goes here


    }

    public void loginUser() {
        String login = loginEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String email = editTextTextEmailAddress.getText().toString();
        String birthday = editTextDate.getText().toString();

        // Отправка данных на сервер
        new SendDataToServerTask().execute(login, password, email, birthday);
    }



    private class SendDataToServerTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... params) {
            String login = params[0];
            String password = params[1];
            String email = params[2];
            String birthday = params[3];
            try {
                // Создаем URL сервера и подключаемся к нему
                URL url = new URL("http://scenariw.ru.swtest.ru/register.php");
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                // Устанавливаем метод запроса и параметры запроса
                urlConnection.setRequestMethod("POST");
                urlConnection.setDoOutput(true);

                // Формируем данные для отправки
                String postData = "login=" + URLEncoder.encode(login, "UTF-8") +
                        "&password=" + URLEncoder.encode(password, "UTF-8") +
                        "&email=" + URLEncoder.encode(email, "UTF-8") +
                        "&birthday=" + URLEncoder.encode(birthday, "UTF-8");

                // Отправляем данные на сервер
                OutputStream os = urlConnection.getOutputStream();
                os.write(postData.getBytes());
                os.flush();
                os.close();

                // Проверяем код ответа сервера
                int responseCode = urlConnection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    return true; // Успешно отправлено
                } else {
                    return false; // Ошибка при отправке
                }
            } catch (IOException e) {
                Log.e("Error", "Error sending data to server: " + e.getMessage());
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                // Данные успешно отправлены
                Toast.makeText(registration.this, "Данные успешно отправлены на сервер", Toast.LENGTH_SHORT).show();
            } else {
                // Ошибка при отправке данных
                Toast.makeText(registration.this, "Ошибка при отправке данных на сервер", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void haveAcc(){
        Intent intent = new Intent(registration.this, authorisation_activity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnSignUp){
            loginUser();
        } else if(id == R.id.__________________){
            haveAcc();
        }
    }
}

