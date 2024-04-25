
	 
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

	import androidx.core.content.ContextCompat;

	import java.io.IOException;
    import java.io.OutputStream;
    import java.net.HttpURLConnection;
    import java.net.URL;
    import java.net.URLEncoder;

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


		/*
        public void loginUser() {
            String login = loginEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // Отправка данных на сервер
            new SendDataToServerTask().execute(login, password);
        }

        private class SendDataToServerTask extends AsyncTask<String, Void, Boolean> {
            @Override
            protected Boolean doInBackground(String... params) {
                String login = params[0];
                String password = params[1];
                try {
                    // Создаем URL сервера и подключаемся к нему
                    URL url = new URL("http://scenariw.ru.swtest.ru/register.php");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                    // Устанавливаем метод запроса и параметры запроса
                    urlConnection.setRequestMethod("POST");
                    urlConnection.setDoOutput(true);

                    // Формируем данные для отправки
                    String postData = "login=" + URLEncoder.encode(login, "UTF-8") +
                            "&password=" + URLEncoder.encode(password, "UTF-8");

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
                    Toast.makeText(authorisation_activity.this, "Данные успешно отправлены на сервер", Toast.LENGTH_SHORT).show();
                } else {
                    // Ошибка при отправке данных
                    Toast.makeText(authorisation_activity.this, "Ошибка при отправке данных на сервер", Toast.LENGTH_SHORT).show();
                }
            }

        }

		 */

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
				startNewActivity();
			} else if(id == R.id.__________________){
				toRegistration();
			}
		}
	}
	
	