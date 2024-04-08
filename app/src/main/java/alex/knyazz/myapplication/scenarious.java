
	 
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
    import android.content.SharedPreferences;
    import android.os.Bundle;
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

    import java.io.File;
    import java.util.ArrayList;
    import java.util.HashSet;

    public class scenarious extends Activity implements View.OnClickListener {


        private RelativeLayout authorisation, content_container, page_authorisation_ek1, frame_5;
        private View _bg__authorisation_ek2;
        private ImageView shape_with_text, shape_with_text_ek2, shape_with_text_ek3, shape_with_scanerious, shape_with_text_ek4;
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
                setContentView(R.layout.scenarious);
            } else {
                setContentView(R.layout.scenarious1);
            }

            files(); // список всех файлов
            fillTableWithFileData(); // наполнение таблицы данными из списка всех файлов

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
            delete = (Button) findViewById(R.id.delete);
            delete.setOnClickListener(this);
            open = (Button) findViewById(R.id.open);
            open.setOnClickListener(this);
            deleteAll = (Button) findViewById(R.id.deleteAll);
            deleteAll.setOnClickListener(this);

            //custom code goes here
        }

        // считаем, сколько сценариев создано
        public int countScene() {
            sPref = getSharedPreferences("ScenariousCount", MODE_PRIVATE);
            String scenNum1 = sPref.getString("count: ", String.valueOf(scenNum));
            scenNum = Integer.parseInt(scenNum1);
            System.out.println("scenNum: " + scenNum);
            return scenNum;
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
            stk.removeAllViews();
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
                clonedNameTextView.setWidth(625);
                clonedNameTextView.setTextSize(25);
                clonedNameTextView.setPadding(80, 15, 5, 15);
                clonedNameTextView.setGravity(Gravity.LEFT);
                clonedNameTextView.setId(countId); // устанавливаем id
                clonedNameTextView.setClickable(true);
                clonedNameTextView.setOnClickListener(this);
                // копируем вторую ячейку
                TextView clonedTypeTextView = new TextView(this);
                clonedTypeTextView.setTextSize(25);
                clonedTypeTextView.setPadding(5, 15, 5, 15);
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
            Intent intent = new Intent(scenarious.this, edit_page_1.class);
            startActivity(intent);
        }

        public void deleteAllFiles() {

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
	
	