
	 
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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class ResetPasswordActivity extends Activity implements View.OnClickListener {


    private EditText loginEditText, passwordEditText;
    private Button btnSignUp;
    private TextView __________________;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_password_activity);


        loginEditText = (EditText) findViewById(R.id.login);
        passwordEditText = (EditText) findViewById(R.id.password);

        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(this);

        __________________ = (TextView) findViewById(R.id.__________________);
        __________________.setOnClickListener(this);


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


    private void resetPassword(String emailOrLogin, String newPassword) {
        new ResetPasswordTask().execute(emailOrLogin, newPassword);
    }

    private class ResetPasswordTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String emailOrLogin = params[0];
            String newPassword = params[1];
            try {
                URL url = new URL("http://scenariw.ru.swtest.ru/resetPass.php");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);

                String postData = "emailOrLogin=" + URLEncoder.encode(emailOrLogin, "UTF-8") +
                        "&password=" + URLEncoder.encode(newPassword, "UTF-8");

                OutputStream os = conn.getOutputStream();
                os.write(postData.getBytes());
                os.flush();
                os.close();

                InputStream inputStream = conn.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String response = bufferedReader.readLine();
                bufferedReader.close();
                inputStream.close();

                return response;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null) {
                if (result.equals("Password updated successfully")) {
                    Toast.makeText(ResetPasswordActivity.this, "Пароль успешно обновлен", Toast.LENGTH_SHORT).show();
                    finish(); // Закрываем активность после успешного обновления пароля
                } else if (result.equals("User not found")) {
                    Toast.makeText(ResetPasswordActivity.this, "Пользователь не найден", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ResetPasswordActivity.this, "Произошла ошибка", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(ResetPasswordActivity.this, "Произошла ошибка", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void haveAcc() {
        Intent intent = new Intent(ResetPasswordActivity.this, authorisation_activity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnSignUp) {
            String emailOrLogin = loginEditText.getText().toString();
            String newPassword = passwordEditText.getText().toString();
            String hashedPassword = hashPassword(newPassword);
            resetPassword(emailOrLogin, hashedPassword);
            //haveAcc();
        } else if (id == R.id.__________________) {
            haveAcc();
        }
    }
}

