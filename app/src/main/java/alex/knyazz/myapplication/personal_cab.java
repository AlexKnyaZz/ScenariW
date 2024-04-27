
	 
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

    import android.annotation.SuppressLint;
    import android.app.Activity;
    import android.content.Context;
    import android.content.Intent;
    import android.content.SharedPreferences;
    import android.os.AsyncTask;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;

    import org.json.JSONException;
    import org.json.JSONObject;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.net.HttpURLConnection;
    import java.net.URL;

    public class personal_cab extends Activity implements View.OnClickListener {


        private TextView userName, btnLogOut, userAge;
        private Button btnBack;


        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.personal_cab);


            userName = (TextView) findViewById(R.id.userName);
            userAge = (TextView) findViewById(R.id.age);


            btnBack = (Button) findViewById(R.id.btnBack);
            btnBack.setOnClickListener(this);

            btnLogOut = (TextView) findViewById(R.id.btnLogOut);
            btnLogOut.setOnClickListener(this);

            // Получаем информацию о текущем пользователе
            getUserInfo();


            //custom code goes here


        }


        @SuppressLint("StaticFieldLeak")
        private void getUserInfo() {
            new AsyncTask<Void, Void, String>() {
                @Override
                protected String doInBackground(Void... voids) {
                    try {
                        // Создаем URL сервера и подключаемся к нему
                        URL url = new URL("http://scenariw.ru.swtest.ru/getUserInfo.php");
                        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                        // Получаем куки из SharedPreferences
                        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        String cookie = sharedPreferences.getString("Cookie", "");

                        // Устанавливаем куки в заголовок запроса
                        if (!cookie.isEmpty()) {
                            urlConnection.setRequestProperty("Cookie", cookie);
                        } else {
                            toAuthorisation();
                        }

                        // Читаем ответ от сервера
                        InputStream inputStream = urlConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        StringBuilder response = new StringBuilder();
                        String inputLine;
                        while ((inputLine = bufferedReader.readLine()) != null) {
                            response.append(inputLine);
                        }
                        bufferedReader.close();
                        inputStream.close();

                        // Возвращаем ответ сервера
                        return response.toString();
                    } catch (IOException e) {
                        Log.e("Error", "Error fetching user info: " + e.getMessage());
                        return null;
                    }
                }

                @Override
                protected void onPostExecute(String result) {
                    Log.d("Response", "Response: " + result); // Добавляем вывод для отладки
                    if (result != null && !result.isEmpty()) {
                        if (result.equals("User not logged in")) {
                            Log.d("Info", "User not logged in"); // Добавляем вывод для отладки
                        } else {
                            try {
                                // Разбираем ответ сервера в формате JSON
                                JSONObject jsonObject = new JSONObject(result);
                                String userId = jsonObject.getString("user_id");
                                String username = jsonObject.getString("username");
                                int age = jsonObject.getInt("age");

                                // Обновляем UI, отображая имя пользователя
                                userName.setText(username);
                                userAge.setText(String.valueOf(age));
                            } catch (JSONException e) {
                                Log.e("Error", "Error parsing user info JSON: " + e.getMessage());
                            }
                        }
                    } else {
                        Log.e("Error", "Empty or null response");
                    }
                }
            }.execute();
        }

        @SuppressLint("StaticFieldLeak")
        private void logOut() {
            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... voids) {
                    try {
                        // Создаем URL сервера и подключаемся к нему
                        URL url = new URL("http://scenariw.ru.swtest.ru/logout.php");
                        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                        // Читаем ответ от сервера (в этом случае не требуется)
                        InputStream inputStream = urlConnection.getInputStream();
                        inputStream.close();

                        // Возвращаем null, так как doInBackground возвращает Void
                        return null;
                    } catch (IOException e) {
                        Log.e("Error", "Error logging out: " + e.getMessage());
                        return null;
                    }
                }

                @Override
                protected void onPostExecute(Void result) {
                    // очищаем куки
                    SharedPreferences sPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor ed2 = sPref.edit();
                    ed2.clear();
                    ed2.commit();

                    // Переходим на экран авторизации
                    Intent intent = new Intent(personal_cab.this, authorisation_activity.class);
                    startActivity(intent);
                    finish(); // Закрываем текущую активность
                }
            }.execute();
        }


        public void startNewActivity() {
            Intent intent = new Intent(personal_cab.this, frame_3_activity.class);
            //System.out.println("succeeeeeeeeeeeeeeeeees");
            startActivity(intent);
        }

        public void toAuthorisation() {
            Intent intent = new Intent(personal_cab.this, authorisation_activity.class);
            startActivity(intent);
        }

        public void toUpdatePass() {
            Intent intent = new Intent(personal_cab.this, ResetPasswordActivity.class);
            startActivity(intent);
        }

        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.btnLogin) {
                //String login = loginEditText.getText().toString();
                //String password = passwordEditText.getText().toString();
                //new SearchUserTask().execute(login, password);
            } else if (id == R.id.btnBack) {
                startNewActivity();
            } else if (id == R.id.btnLogOut) {
                logOut();
            }
        }
    }
	
	