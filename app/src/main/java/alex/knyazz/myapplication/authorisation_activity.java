
	 
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

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.io.OutputStream;
    import java.net.HttpURLConnection;
    import java.net.URL;
    import java.net.URLEncoder;
    import java.nio.charset.StandardCharsets;
    import java.security.MessageDigest;
    import java.security.NoSuchAlgorithmException;

    public class authorisation_activity extends Activity implements View.OnClickListener {


        private View _bg__authorisation_ek2;
        private ImageView shape_with_text;
        private ImageView shape_with_text_ek1;
        private TextView _____;
        private TextView __________________________________________________________________;
        private ImageView shape_with_text_ek2;
        private TextView ______;
        private View _bg__frame_5_ek1;
        private ImageView ______ek1;
        private TextView __________________;
        private ImageView shape_with_text_ek3;
        private ImageView shape_with_text_ek4;
        private ImageView shape_with_text_ek5;
        private ImageView shape_with_text_ek6;
        private ImageView shape_with_text_ek7;
        private ImageView shape_with_text_ek8;
        private ImageView shape_with_text_ek9;
        private TextView ___________________;
        private EditText loginEditText;
        private EditText passwordEditText;
        private Button btnLogin;

        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.authorisation);


            _bg__authorisation_ek2 = (View) findViewById(R.id._bg__authorisation_ek2);
            shape_with_text = (ImageView) findViewById(R.id.shape_with_text);
            shape_with_text_ek1 = (ImageView) findViewById(R.id.shape_with_text_ek1);
            _____ = (TextView) findViewById(R.id._____);
            __________________________________________________________________ = (TextView) findViewById(R.id.__________________________________________________________________);
            shape_with_text_ek2 = (ImageView) findViewById(R.id.shape_with_text_ek2);
            ______ = (TextView) findViewById(R.id.______);
            //_bg__frame_5_ek1 = (View) findViewById(R.id._bg__frame_5_ek1);
            //регистрация
			__________________ = (TextView) findViewById(R.id.__________________);
			__________________.setOnClickListener(this);

			shape_with_text_ek3 = (ImageView) findViewById(R.id.shape_with_text_ek3);
            shape_with_text_ek4 = (ImageView) findViewById(R.id.shape_with_text_ek4);
            shape_with_text_ek5 = (ImageView) findViewById(R.id.shape_with_text_ek5);
            ___________________ = (TextView) findViewById(R.id.___________________);

            loginEditText = (EditText) findViewById(R.id.login);
            passwordEditText = (EditText) findViewById(R.id.password);

            btnLogin = (Button) findViewById(R.id.btnLogin);
            btnLogin.setOnClickListener(this);



            //custom code goes here


        }


        private String hashPassword(String password) {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
                StringBuilder hexString = new StringBuilder();
                for (byte b : hash) {
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

        private class SearchUserTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                String login = params[0];
                String password = params[1];
                String hashedPassword = hashPassword(password);
                try {
                    // Создаем URL сервера и подключаемся к нему
                    URL url = new URL("http://scenariw.ru.swtest.ru/searchUser.php");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                    // Устанавливаем метод запроса и параметры запроса
                    urlConnection.setRequestMethod("POST");
                    urlConnection.setDoOutput(true);

                    // Формируем данные для отправки
                    String postData = "login=" + URLEncoder.encode(login, "UTF-8") +
                            "&password=" + URLEncoder.encode(hashedPassword, "UTF-8");

                    // Отправляем данные на сервер
                    OutputStream os = urlConnection.getOutputStream();
                    os.write(postData.getBytes());
                    os.flush();
                    os.close();

                    // Получаем ответ от сервера
                    InputStream inputStream = urlConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String response = bufferedReader.readLine();
                    bufferedReader.close();
                    inputStream.close();

                    // Возвращаем ответ сервера
                    return response;
                } catch (IOException e) {
                    Log.e("Error", "Error sending data to server: " + e.getMessage());
                    return null;
                }
            }

            @Override
            protected void onPostExecute(String result) {
                //Log.d("AuthorisationActivity", "Ответ сервера: " + result);
                System.out.println("Ответ сервера: " + result);
                if (result != null) {
                    if (result.equals("User found")) {
                        // Пользователь найден, выполните действия для авторизации
                        Toast.makeText(authorisation_activity.this, "Вы вошли в систему", Toast.LENGTH_SHORT).show();
                        startNewActivity();
                    } else if (result.equals("Incorrect password")) {
                        // Неправильный пароль
                        Toast.makeText(authorisation_activity.this, "Неправильный пароль", Toast.LENGTH_SHORT).show();
                    } else if (result.equals("Incorrect login")) {
                        // Неправильный логин
                        Toast.makeText(authorisation_activity.this, "Неправильный логин", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Ошибка при обработке ответа
                    Toast.makeText(authorisation_activity.this, "Ошибка при обработке ответа", Toast.LENGTH_SHORT).show();
                }
            }
        }


        public void startNewActivity() {
            Intent intent = new Intent(authorisation_activity.this, frame_3_activity.class);
            //System.out.println("succeeeeeeeeeeeeeeeeees");
            startActivity(intent);
        }
		public void toRegistration(){
			Intent intent = new Intent(authorisation_activity.this, registration.class);
			startActivity(intent);
		}

		@Override
		public void onClick(View v) {
			int id = v.getId();
			if (id == R.id.btnLogin){
                String login = loginEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                new SearchUserTask().execute(login, password);
			} else if(id == R.id.__________________){
				toRegistration();
			}
		}
	}
	
	