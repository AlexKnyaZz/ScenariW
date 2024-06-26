
	 
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
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.ArrayAdapter;
    import android.widget.AutoCompleteTextView;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.ImageView;
    import android.widget.RelativeLayout;
    import android.widget.ScrollView;
    import android.widget.TextView;
    import android.widget.Toast;

    import java.util.ArrayList;
    import java.util.HashSet;
    import java.util.Set;

    public class scenarious_create2 extends Activity implements View.OnClickListener {


        private ScrollView authorisation;
        private RelativeLayout content_container;
        private RelativeLayout frame_5;
        private RelativeLayout page_authorisation_ek1;
        private View _bg__authorisation_ek2;
        private ImageView shape_with_text;
        private ImageView shape_with_text_ek2;
        private ImageView shape_with_text_ek1;
        private ImageView shape_with_text_ek3;

        private Button Return;
        private TextView __________________________________________________________________;
        private TextView ___________________;
        private EditText scenName;

        Button Create;
        String name;
        String role;
        String type;

        String Story;
        String Dialogue;
        String Quest;
        String Designer;
        String Scenarist;
        String Programmer;
        String SoundEngineer;

        //String[] item = {"Story", "Dialogue", "Quest"};
        //String[] item = {getString(R.string.Story), getString(R.string.Dialogue), getString(R.string.Quest)};

        //String[] item1 = {"Designer", "Scenarist", "Programmer", "Sound Engineer"};
        //String[] item1 = {getString(R.string.Designer), getString(R.string.Scenarist), getString(R.string.Programmer), getString(R.string.SoundEngineer)};
        AutoCompleteTextView autoCompleteTextView;
        AutoCompleteTextView autoCompleteTextView1;
        ArrayAdapter<String> adapterItems;
        ArrayAdapter<String> adapterItems1;

        SharedPreferences sPref;
        final String SAVED_TEXT = "saved_text";
        final String SAVED_TYPE = "saved_type";
        final String SAVED_ROLE = "saved_role";
        final String SAVED_NAME = "saved_name";


        public int ScenNum = 0;

        //public Set<String> fileNames;
        public ArrayList<String> fileNames = new ArrayList<String>();

        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.scenarious_create2);

            // в контексте данного слоя - для тестов
            // считаем кол-во сценариев
            countScen();
            System.out.println(ScenNum);

            // для тестов
            // смотрим существующие файлы
            files();

            authorisation = (ScrollView) findViewById(R.id.authorisation);
            content_container = (RelativeLayout) findViewById(R.id.content_container);
            page_authorisation_ek1 = (RelativeLayout) findViewById(R.id.page_authorisation_ek1);
            frame_5 = (RelativeLayout) findViewById(R.id.frame_5);
            _bg__authorisation_ek2 = (View) findViewById(R.id._bg__authorisation_ek2);
            shape_with_text = (ImageView) findViewById(R.id.shape_with_text);
            shape_with_text_ek2 = (ImageView) findViewById(R.id.shape_with_text_ek2);
            shape_with_text_ek1 = (ImageView) findViewById(R.id.shape_with_text_ek1);
            shape_with_text_ek3 = (ImageView) findViewById(R.id.shape_with_text_ek3);

            Create = (Button) findViewById(R.id.Create);
            Create.setOnClickListener(this);

            Return = (Button) findViewById(R.id.Return);
            __________________________________________________________________ = (TextView) findViewById(R.id.__________________________________________________________________);
            ___________________ = (TextView) findViewById(R.id.___________________);
            scenName = (EditText) findViewById(R.id.scenName);

            Story = (String) getString(R.string.Story);
            Dialogue = (String) getString(R.string.Dialogue);
            Quest = (String) getString(R.string.Quest);

            Designer = (String) getString(R.string.Designer);
            Scenarist = (String) getString(R.string.Scenarist);
            Programmer = (String) getString(R.string.Programmer);
            SoundEngineer = (String) getString(R.string.SoundEngineer);

            String[] item = {getString(R.string.Story), getString(R.string.Dialogue), getString(R.string.Quest)};
            //String[] item1 = {"Designer", "Scenarist", "Programmer", "Sound Engineer"};
            String[] item1 = {getString(R.string.Designer), getString(R.string.Scenarist), getString(R.string.Programmer), getString(R.string.SoundEngineer)};


            // Автозаполнение списка "Выберите тип"
            autoCompleteTextView = findViewById(R.id.type_input);

            adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, item);
            autoCompleteTextView.setAdapter(adapterItems);
            autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    type = adapterView.getItemAtPosition(i).toString();
                    //Toast.makeText(scenarious_create2.this, "item: " + type, Toast.LENGTH_SHORT).show();
                }
            });
            // Автозаполнение списка "Выберите роль"
            autoCompleteTextView1 = findViewById(R.id.role_input);

            adapterItems1 = new ArrayAdapter<String>(this, R.layout.list_item, item1);
            autoCompleteTextView1.setAdapter(adapterItems1);
            autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView1, View view1, int i1, long l1) {
                    role = adapterView1.getItemAtPosition(i1).toString();
                    //Toast.makeText(scenarious_create2.this, "item: " + role, Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.Create) {
                name = scenName.getText().toString(); // берём из поля с id scenName имя сценария для вывода в консоль (для тестов)
                System.out.println(name);
                saveType(); // сохраняем в новый файл тип, роль и название
                saveRole();
                saveName();
                // новые строчки, которые используются в коде другой активности
                setRowsCount();
                setLastId();

                toChoiceFormat(v); // переход на следующий слой
            } else if (id == R.id.Return) {
                toReturn(v);
            }
            ;
        }

        public void files() {
            sPref = getSharedPreferences("MyFiles", MODE_PRIVATE);
            ArrayList<String> savedFileNames = new ArrayList<String>(sPref.getStringSet("fileNames", new HashSet<>()));
            fileNames.addAll(savedFileNames);
            for (String fileName : fileNames) {
                System.out.println("fileNames: " + fileName);
            }
        }

        // сохранение данных о новом сценарии: тип, роль, название
        private void saveType() {
            sPref = getSharedPreferences(name, MODE_PRIVATE); //сохраняем в файл, название которого = названию сценария
            SharedPreferences.Editor ed = sPref.edit();
            ed.putString(SAVED_TYPE, type);
            ed.commit();
        }

        private void saveRole() {
            sPref = getSharedPreferences(name, MODE_PRIVATE);
            SharedPreferences.Editor ed = sPref.edit();
            ed.putString(SAVED_ROLE, role);
            ed.commit();
        }

        private void setRowsCount() {
            sPref = getSharedPreferences(name, MODE_PRIVATE);
            SharedPreferences.Editor ed1 = sPref.edit();
            int rowsCount = 0;
            ed1.putString("rowsCount", String.valueOf(rowsCount));
            ed1.commit();
        }

        private void setLastId() {
            sPref = getSharedPreferences(name, MODE_PRIVATE);
            SharedPreferences.Editor ed1 = sPref.edit();
            int lastId = 0;
            ed1.putString("lastId", String.valueOf(lastId));
            ed1.commit();
        }

        private void saveName() {
            sPref = getSharedPreferences(name, MODE_PRIVATE);
            SharedPreferences.Editor ed = sPref.edit();
            ed.putString(SAVED_NAME, scenName.getText().toString());
            ed.commit();
            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();

            //добавляем в счётчик сценариев
            sPref = getSharedPreferences("ScenariousCount", MODE_PRIVATE);
            SharedPreferences.Editor ed1 = sPref.edit();
            ScenNum += 1;
            ed1.putString("count: ", String.valueOf(ScenNum));
            ed1.commit();

            // добавляем имя сценария в файл MyFiles
            fileNames.add(name);
            sPref = getSharedPreferences("MyFiles", MODE_PRIVATE);
            SharedPreferences.Editor ed3 = sPref.edit();
            Set<String> fileNamesSet = new HashSet<>(fileNames);
            ed3.putStringSet("fileNames", fileNamesSet);
            ed3.apply();
            // добавляем имя текущего файла
            addCurrent(name);
        }

        // считаем, сколько сейчас сценариев (на этом слое - для тестов)
        public int countScen() {
            sPref = getSharedPreferences("ScenariousCount", MODE_PRIVATE);
            SharedPreferences.Editor ed1 = sPref.edit();
            String num = sPref.getString("count: ", String.valueOf(ScenNum));
            ScenNum = Integer.parseInt(num);
            System.out.println(ScenNum + " is now");
            return ScenNum;
        }

        // текущий элемент, установка
        public void addCurrent(String s) {
            sPref = getSharedPreferences("MyFiles", MODE_PRIVATE);
            SharedPreferences.Editor ed3 = sPref.edit();
            ed3.putString("current_name", s);
            ed3.apply();
        }

        // кнопка Далее
        public void toChoiceFormat(View v) {
            Intent intent = new Intent(scenarious_create2.this, edit_page.class);
            startActivity(intent);
        }

        public void toReturn(View v) {
            Intent intent = new Intent(scenarious_create2.this, frame_3_activity.class);
            startActivity(intent);
        }
    }
	
	