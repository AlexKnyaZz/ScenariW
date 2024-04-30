
	 
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
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class scenarious extends Activity implements View.OnClickListener {


    private RelativeLayout authorisation, content_container, page_authorisation_ek1, frame_5;
    private View _bg__authorisation_ek2;
    private ImageView updateMyFiles, uploadMyFiles, shape_with_text, shape_with_text_ek2, shape_with_text_ek3, shape_with_scanerious, shape_with_text_ek4;
    private Button Create, Return, delete, open, deleteAll;
    private TextView ___________________, __________________________________________________________________;
    private TableLayout table;
    private TableRow TableRowSc;
    private TextView NameOfScene, TypeOfScene;
    private ScrollView scrollTable;

    SharedPreferences sPref;

    int scenNum = 0;

    public ArrayList<String> fileNames = new ArrayList<String>();

    int clickNum = 0; // кол-во нажатий на кнопку
    String selectedFile; // выбранный файл

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        countScene(); // проверяем, есть ли сценарии
        if (scenNum == 0) {
            System.out.println("запустился слой 1");
            setContentView(R.layout.scenarious);
        } else {
            System.out.println("запустился слой 2");
            setContentView(R.layout.scenarious1);
            delete = (Button) findViewById(R.id.delete);
            delete.setOnClickListener(this);
            open = (Button) findViewById(R.id.open);
            open.setOnClickListener(this);
            deleteAll = (Button) findViewById(R.id.deleteAll);
            deleteAll.setOnClickListener(this);
            uploadMyFiles = (ImageView) findViewById(R.id.uploadMyFiles);
            uploadMyFiles.setOnClickListener(this);

            files(); // список всех файлов
            fillTableWithFileData(); // наполнение таблицы данными из списка всех файлов
        }

        authorisation = (RelativeLayout) findViewById(R.id.authorisation);
        table = (TableLayout) findViewById(R.id.table);
        TableRowSc = (TableRow) findViewById(R.id.TableRowSc);
        NameOfScene = (TextView) findViewById(R.id.NameOfScene);
        TypeOfScene = (TextView) findViewById(R.id.TypeOfScene);
        content_container = (RelativeLayout) findViewById(R.id.content_container);
        page_authorisation_ek1 = (RelativeLayout) findViewById(R.id.page_authorisation_ek1);
        _bg__authorisation_ek2 = (View) findViewById(R.id._bg__authorisation_ek2);
        shape_with_text = (ImageView) findViewById(R.id.shape_with_text);
        shape_with_text_ek2 = (ImageView) findViewById(R.id.shape_with_text_ek2);
        frame_5 = (RelativeLayout) findViewById(R.id.frame_5);
        shape_with_text_ek3 = (ImageView) findViewById(R.id.shape_with_text_ek3);
        shape_with_scanerious = (ImageView) findViewById(R.id.shape_with_scanerious);
        __________________________________________________________________ = (TextView) findViewById(R.id.__________________________________________________________________);
        shape_with_text_ek4 = (ImageView) findViewById(R.id.shape_with_text_ek4);
        ___________________ = (TextView) findViewById(R.id.___________________);
        scrollTable = (ScrollView) findViewById(R.id.scrollTable);

        Create = (Button) findViewById(R.id.Create);
        Create.setOnClickListener(this);
        Return = (Button) findViewById(R.id.Return);
        Return.setOnClickListener(this);

        updateMyFiles = (ImageView) findViewById(R.id.updateMyFiles);
        updateMyFiles.setOnClickListener(this);


        //custom code goes here
    }

    // считаем, сколько сценариев создано
    public int countScene() {
        sPref = getSharedPreferences("ScenariousCount", MODE_PRIVATE);
        String scenNum1 = sPref.getString("count: ", String.valueOf(scenNum));
        scenNum = Integer.parseInt(scenNum1);
        if (scenNum >= 0) {
            System.out.println("scenNum: " + scenNum);
            System.out.println("scenNum 1111 === " + scenNum);
            return scenNum;
        } else {
            scenNum = 0;
            System.out.println("scenNum 2222 === " + scenNum);
            return scenNum;
        }

    }

    // список имён созданных файлов
    public void files() {
        // этот метод просто берёт данные из файла
        // очищаем список от старых и неактуальных имён и записываем те, что в файле с именами
        fileNames.clear();
        sPref = getSharedPreferences("MyFiles", MODE_PRIVATE);
        ArrayList<String> savedFileNames = new ArrayList<String>(sPref.getStringSet("fileNames", new HashSet<>()));
        fileNames.addAll(savedFileNames);
        System.out.println("Файлы, которые есть сейчас: "); // имена сценариев, которые взяты из файла и продублированы в список с именами
        for (String fileName : fileNames) {
            System.out.println("fileNames: " + fileName);
        }
    }

    // наполнение таблицы данными
    public void fillTableWithFileData() {
        // Клонируем существующие элементы
        TableLayout stk = (TableLayout) findViewById(R.id.table);
        // обнуление всех созданных дубликатов //
        if (stk.getChildCount() > 0) {
            stk.removeAllViews();
        }
        // вывод списка сценариев
        int countId = 0; // счётчик для установки id
        for (String fileName : fileNames) {
            // увеличиваем счётчик
            countId += 1;
            // Получаем SharedPreferences для текущего файла
            SharedPreferences filePrefs = getSharedPreferences(fileName, MODE_PRIVATE);
            // Получаем значения по ключам
            String name = filePrefs.getString("saved_name", "");
            String type = filePrefs.getString("saved_type", "");
            // копируем строку таблицы
            TableRow clonedTableRow = new TableRow(this);
            // копируем первую ячейку
            TextView clonedNameTextView = new TextView(this);
            // устанавливаем параметры отображения
            clonedNameTextView.setWidth(600);
            clonedNameTextView.setTextSize(25);
            clonedNameTextView.setPadding(60, 15, 0, 15);
            clonedNameTextView.setGravity(Gravity.LEFT);
            clonedNameTextView.setId(countId); // устанавливаем id
            clonedNameTextView.setClickable(true);
            clonedNameTextView.setOnClickListener(this);
            // копируем вторую ячейку
            TextView clonedTypeTextView = new TextView(this);
            clonedTypeTextView.setTextSize(25);
            clonedTypeTextView.setPadding(0, 15, 5, 15);
            clonedTypeTextView.setGravity(Gravity.CENTER);
            clonedTypeTextView.setClickable(true);
            clonedTypeTextView.setOnClickListener(this);
            // устанавливаем тег
            clonedNameTextView.setTag(name);
            clonedTableRow.setTag(name);
            // Устанавливаем данные из файла SharedPreferences в клонированные элементы
            clonedNameTextView.setText(name);
            clonedTypeTextView.setText(type);
            // Добавляем ячейки с данными в строку таблицы
            clonedTableRow.addView(clonedNameTextView);
            clonedTableRow.addView(clonedTypeTextView);
            // Добавляем клонированную строку в таблицу
            stk.addView(clonedTableRow);
            System.out.println("table 4");
        }
    }


    // кнопки
    public void toCreate1(View v) {
        Intent intent = new Intent(scenarious.this, scenarious_create1.class);
        startActivity(intent);
    }

    public void toReturn(View v) {
        Intent intent = new Intent(scenarious.this, frame_3_activity.class);
        //System.out.println("succeeeeeeeeeeeeeeeeees");
        startActivity(intent);
    }

    // для тестов и реализации дальнейших функций; получение данных о файле
    public void data(String s) {
        SharedPreferences filePrefs = getSharedPreferences(s, MODE_PRIVATE);

        // Получаем значения по ключам
        String name = filePrefs.getString("saved_name", "");
        String type = filePrefs.getString("saved_type", "");

        System.out.println("name: " + name + ", type: " + type);
    }

    // выбрать текущий файл
    public void addCurrent(String s) {
        sPref = getSharedPreferences("MyFiles", MODE_PRIVATE);
        SharedPreferences.Editor ed3 = sPref.edit();
        ed3.putString("current_name", s);
        ed3.apply();
    }

    // выбранный файл
    public String selected() {
        SharedPreferences filePrefs = getSharedPreferences("MyFiles", MODE_PRIVATE);
        // Получаем значение по ключу
        String name = filePrefs.getString("current_name", "");
        System.out.println("name: " + name);
        return name;
    }

    // удаляем файл
    public void deleteFile() {
        selectedFile = selected();
        System.out.println(selectedFile);
        // удаляем из списка с названиями сценариев
        fileNames.remove(selectedFile);

        System.out.println("Удалён файл " + selectedFile);

        // Обновляем SharedPreferences с новым списком файлов
        sPref = getSharedPreferences("MyFiles", MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.clear();
        editor.putStringSet("fileNames", new HashSet<>(fileNames));
        editor.apply();

        files();
        // вычитаем из счётчика единицу
        sPref = getSharedPreferences("ScenariousCount", MODE_PRIVATE);
        String scenNum1 = sPref.getString("count: ", String.valueOf(scenNum));
        scenNum = Integer.parseInt(scenNum1);

        System.out.println("До удаления: " + scenNum);

        SharedPreferences.Editor ed1 = sPref.edit();
        scenNum -= 1;
        ed1.putString("count: ", String.valueOf(scenNum));
        ed1.commit();

        System.out.println("После удаления: " + scenNum);

        // очищаем файл перед удалением
        sPref = getSharedPreferences(selectedFile, MODE_PRIVATE);
        SharedPreferences.Editor ed2 = sPref.edit();
        ed2.clear();
        ed2.commit();

        // удаляем сам файл
        File file = new File("/data/data/alex.knyazz.myapplication/shared_prefs/" + selectedFile + ".xml");
        file.delete();

        // обновляем отображающийся на экране список сценариев
        fillTableWithFileData(); // наполнение таблицы данными из списка всех файлов
    }

    public void openFile() {
        selectedFile = selected();
        System.out.println("selected: " + selectedFile);
        System.out.println("пробуем открыть...");
        Intent intent = new Intent(scenarious.this, edit_page_1.class);
        startActivity(intent);
    }

    public void deleteAllFiles() {
        for (String fileName : fileNames) {
            // очищаем файл перед удалением
            sPref = getSharedPreferences(fileName, MODE_PRIVATE);
            SharedPreferences.Editor ed2 = sPref.edit();
            ed2.clear();
            ed2.commit();

            System.out.println("очистили сам файл");

            // удаляем сам файл
            File file = new File("/data/data/alex.knyazz.myapplication/shared_prefs/" + fileName + ".xml");
            file.delete();

            System.out.println("удалили");
        }

        sPref = getSharedPreferences("MyFiles", MODE_PRIVATE);
        SharedPreferences.Editor ed1 = sPref.edit();
        ed1.clear();
        ed1.commit();
        File file = new File("/data/data/alex.knyazz.myapplication/shared_prefs/MyFiles.xml");
        file.delete();

        sPref = getSharedPreferences("ScenariousCount", MODE_PRIVATE);
        SharedPreferences.Editor ed2 = sPref.edit();
        ed2.clear();
        ed2.commit();
        File file1 = new File("/data/data/alex.knyazz.myapplication/shared_prefs/ScenariousCount.xml");
        file1.delete();

        fillTableWithFileData();
        // перезапускаем
        Intent intent = new Intent(scenarious.this, scenarious.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        //в самую последнюю очередь
        /*sPref = getSharedPreferences("MyFiles", MODE_PRIVATE);
        SharedPreferences.Editor ed1 = sPref.edit();
        ed1.clear();
        ed1.commit();*/

    }

    @SuppressLint("StaticFieldLeak")
    private void saveMyFilesData() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    // Чтение данных из shared preferences
                    SharedPreferences sharedPreferences = getSharedPreferences("MyFiles", MODE_PRIVATE);
                    Set<String> fileNamesSet = sharedPreferences.getStringSet("fileNames", new HashSet<String>());
                    //String currentName = sharedPreferences.getString("current_name", "");

                    // Создание URL сервера и подключение к нему
                    URL url = new URL("http://scenariw.ru.swtest.ru/saveMyFilesData.php");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                    // Получаем куки из SharedPreferences
                    SharedPreferences sPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    String cookie = sPref.getString("Cookie", "");

                    // Устанавливаем куки в заголовок запроса
                    if (!cookie.isEmpty()) {
                        urlConnection.setRequestProperty("Cookie", cookie);
                    } else {
                    }

                    // Установка метода запроса
                    urlConnection.setRequestMethod("POST");
                    urlConnection.setDoOutput(true);

                    // Формирование параметров запроса
                    StringBuilder postData = new StringBuilder();
                    //postData.append(URLEncoder.encode("username", "UTF-8")).append("=").append(URLEncoder.encode("your_username", "UTF-8")).append("&");
                    //postData.append(URLEncoder.encode("current_scenario", "UTF-8")).append("=").append(URLEncoder.encode(currentName, "UTF-8")).append("&");
                    for (String fileName : fileNamesSet) {
                        SharedPreferences sPrefForData = getSharedPreferences(fileName, MODE_PRIVATE);
                        String saved_type = sPrefForData.getString("saved_type", "");
                        String saved_role = sPrefForData.getString("saved_role", "");
                        String form = sPrefForData.getString("form", "");
                        String rowsCount = sPrefForData.getString("rowsCount", "");
                        String lastId = sPrefForData.getString("lastId", "");

                        int last = Integer.parseInt(lastId);

                        postData.append(URLEncoder.encode("scenario_names[]", "UTF-8")).append("=").append(URLEncoder.encode(fileName, "UTF-8")).append("&");
                        postData.append(URLEncoder.encode("saved_types[]", "UTF-8")).append("=").append(URLEncoder.encode(saved_type, "UTF-8")).append("&");
                        postData.append(URLEncoder.encode("saved_roles[]", "UTF-8")).append("=").append(URLEncoder.encode(saved_role, "UTF-8")).append("&");
                        postData.append(URLEncoder.encode("forms[]", "UTF-8")).append("=").append(URLEncoder.encode(form, "UTF-8")).append("&");
                        postData.append(URLEncoder.encode("rowsCounts[]", "UTF-8")).append("=").append(URLEncoder.encode(rowsCount, "UTF-8")).append("&");
                        postData.append(URLEncoder.encode("lastIds[]", "UTF-8")).append("=").append(URLEncoder.encode(lastId, "UTF-8")).append("&");


                        List<String> dataList = new ArrayList<>();
                        // получаем данные
                        for (int i = 0; i <= last; i++) {
                            String a_key = "a" + i;
                            String b_key = "b" + i;


                            String aText = sPrefForData.getString("a" + i, "");
                            String bText = sPrefForData.getString("b" + i, "");

                            String data_ = a_key + "&=$" + aText + "=$=" + b_key + "&=$" + bText + "=$=";

                            dataList.add(data_);
                            //postData.append(URLEncoder.encode("datas[]", "UTF-8")).append("=").append(URLEncoder.encode(data, "UTF-8")).append("&");


                        }

                        String data = dataList.toString();
                        postData.append(URLEncoder.encode("datas[]", "UTF-8")).append("=").append(URLEncoder.encode(data, "UTF-8")).append("&");

                    }

                    System.out.println(postData.toString());

                    // Отправка данных на сервер
                    OutputStream os = urlConnection.getOutputStream();
                    os.write(postData.toString().getBytes());
                    os.flush();
                    os.close();

                    // Получение ответа от сервера
                    InputStream inputStream = urlConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder response = new StringBuilder();
                    String inputLine;
                    while ((inputLine = bufferedReader.readLine()) != null) {
                        response.append(inputLine);
                    }
                    bufferedReader.close();
                    inputStream.close();

                    // Вывод ответа сервера (можно убрать в реальном приложении)
                    Log.d("Response", "Response: " + response.toString());

                    return null;
                } catch (IOException e) {
                    Log.e("Error", "Error sending data to server: " + e.getMessage());
                    return null;
                }
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    private void getMyFilesData() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    // Создание URL сервера и подключение к нему
                    URL url = new URL("http://scenariw.ru.swtest.ru/getMyFilesData.php");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                    // Получаем куки из SharedPreferences
                    SharedPreferences sPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    String cookie = sPref.getString("Cookie", "");

                    // Устанавливаем куки в заголовок запроса
                    if (!cookie.isEmpty()) {
                        urlConnection.setRequestProperty("Cookie", cookie);
                    }

                    // Установка метода запроса
                    urlConnection.setRequestMethod("GET");

                    // Получение ответа от сервера
                    InputStream inputStream = urlConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder response = new StringBuilder();
                    String inputLine;
                    while ((inputLine = bufferedReader.readLine()) != null) {
                        response.append(inputLine);
                    }
                    bufferedReader.close();
                    inputStream.close();

                    // Вывод ответа сервера (можно убрать в реальном приложении)
                    Log.d("Response", "Response: " + response.toString());

                    // Обработка полученных данных
                    // В данном случае данные приходят в формате JSON, их нужно распарсить и обработать

                    JSONArray jsonArray = new JSONArray(response.toString());

// Обход массива JSON-объектов
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        // Получение значений из JSON-объекта
                        String scenarioName = jsonObject.getString("scenario_name");
                        //String savedType = jsonObject.getString("saved_type");

                        // Обновляем список сценариев в MyFiles
                        System.out.println(scenarioName);
                        SharedPreferences setPref = getSharedPreferences("MyFiles", MODE_PRIVATE);
                        SharedPreferences.Editor ed1 = setPref.edit();

                        fileNames.add(scenarioName);
                        Set<String> fileNamesSet = new HashSet<>(fileNames);
                        ed1.putStringSet("fileNames", fileNamesSet);
                        ed1.apply();
                        // Далее вы можете использовать полученные значения для отображения в приложении или для других целей
                    }


                    return null;
                } catch (IOException e) {
                    Log.e("Error", "Error sending data to server: " + e.getMessage());
                    return null;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    public void getFilenameData() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    // Создание URL сервера и подключение к нему
                    URL url = new URL("http://scenariw.ru.swtest.ru/getFilenameData.php");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                    // Получаем куки из SharedPreferences
                    SharedPreferences sPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    String cookie = sPref.getString("Cookie", "");

                    // Устанавливаем куки в заголовок запроса
                    if (!cookie.isEmpty()) {
                        urlConnection.setRequestProperty("Cookie", cookie);
                    }

                    // Установка метода запроса
                    urlConnection.setRequestMethod("GET");

                    // Получение ответа от сервера
                    InputStream inputStream = urlConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder response = new StringBuilder();
                    String inputLine;
                    while ((inputLine = bufferedReader.readLine()) != null) {
                        response.append(inputLine);
                    }
                    bufferedReader.close();
                    inputStream.close();

                    // Вывод ответа сервера (можно убрать в реальном приложении)
                    Log.d("Response", "Response: " + response.toString());

                    // Обработка полученных данных
                    // В данном случае данные приходят в формате JSON, их нужно распарсить и обработать

                    JSONArray jsonArray = new JSONArray(response.toString());

// Обход массива JSON-объектов
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        // Получение значений из JSON-объекта
                        String scenarioName = jsonObject.getString("scenario_name");
                        //String savedType = jsonObject.getString("saved_type");

                        // Обновляем список сценариев в MyFiles
                        /*
                        System.out.println(scenarioName);
                        SharedPreferences setPref = getSharedPreferences("MyFiles", MODE_PRIVATE);
                        SharedPreferences.Editor ed1 = setPref.edit();

                        fileNames.add(scenarioName);
                        Set<String> fileNamesSet = new HashSet<>(fileNames);
                        ed1.putStringSet("fileNames", fileNamesSet);
                        ed1.apply();

                         */
                    }


                    return null;
                } catch (IOException e) {
                    Log.e("Error", "Error sending data to server: " + e.getMessage());
                    return null;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }.execute();
    }

    // обработчик кнопок
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.Create) {
            toCreate1(v);
        } else if (id == R.id.Return) {
            toReturn(v);
        } else if (id == R.id.delete) {
            deleteFile();
            clickNum = 0;
            System.out.println("deleted");
        } else if (id == R.id.open) {
            openFile();
        } else if (id == R.id.deleteAll) {
            deleteAllFiles();
            System.out.println("deleteAll");
        } else if (id == R.id.uploadMyFiles) {
            saveMyFilesData();
        } else if (id == R.id.updateMyFiles) {
            getMyFilesData();
            getFilenameData();
        } else { // при выборе файла из списка сценариев
            clickNum += 1;
            System.out.println(clickNum);
            if (clickNum == 1) {
                // получаем тег нажатого элемента для дальнейших действий (тег = имя нового файла, что упрощает работу с данными)
                String naame = (String) v.getTag();
                v.setBackground(ContextCompat.getDrawable(this, R.color.bbb));
                // получаем данные этого элемента
                data(naame);

                addCurrent(naame);
                System.out.println(naame);
        /*sPref = getSharedPreferences("MyFiles", MODE_PRIVATE);
        SharedPreferences.Editor ed3 = sPref.edit();
        ed3.putString("current_name", naame);
        ed3.apply();
        */
            } else if (clickNum > 1) {
                // снимаем выделение с элемента
                v.setBackground(null);
                clickNum = 0;
            }
            // получаем id нажатого элемента для дальнейших действий
    /*int idd = v.getId();
    System.out.println("idd = "+ idd);*/
        }
    }

}

