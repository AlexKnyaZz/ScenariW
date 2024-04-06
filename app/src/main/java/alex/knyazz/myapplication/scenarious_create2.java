
	 
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

    String[] item = {"Story", "Dialogue", "Quest"};
    String[] item1 = {"Designer", "Scenarist", "Programmer", "Sound Engineer"};
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

        countScen(); // кол-во созданных сценариев
        System.out.println(ScenNum);




        // список имён файлов
        /*fileNames = new HashSet<>();
        sPref = getSharedPreferences("MyFiles", MODE_PRIVATE);
        Set<String> savedFileNames = sPref.getStringSet("fileNames", new HashSet<>());
        fileNames.addAll(savedFileNames);
        for (String fileName : fileNames) {
            System.out.println("fileNames: " + fileName);
        }*/

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


        // Автозаполнение списка "Выберите тип"
        autoCompleteTextView = findViewById(R.id.auto_complete_txt);

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
        autoCompleteTextView1 = findViewById(R.id.auto_complete_txt1);

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

    public void onClick(View v){
        int id = v.getId();
        if(id == R.id.Create){
            name = scenName.getText().toString();
            System.out.println(name);
            saveType();
            saveRole();
            saveName();

            toChoiceFormat(v);
        } else if (id == R.id.Return) {
            toReturn(v);
        }
        ;
    }


    /*public void files(){
        System.out.println("fileNames!!!!!!!!!!!!!");
        sPref = getSharedPreferences("MyFiles", MODE_PRIVATE);
        Set<String> savedFileNames = sPref.getStringSet("fileNames", new HashSet<>());
        fileNames.addAll(savedFileNames);
        for (String fileName : fileNames) {
            System.out.println("fileNames: " + fileName);
        }
    }*/

    public void files(){
        sPref = getSharedPreferences("MyFiles", MODE_PRIVATE);
        ArrayList<String> savedFileNames = new ArrayList<String>(sPref.getStringSet("fileNames", new HashSet<>()));
        fileNames.addAll(savedFileNames);
        for (String fileName : fileNames) {
            System.out.println("fileNames: " + fileName);
        }
    }

    // сохранение данных о новом сценарии: тип, роль, название
    private void saveType(){
        sPref = getSharedPreferences(name, MODE_PRIVATE); //сохраняем в файл, название которого = названию сценария
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TYPE, type);
        ed.commit();
    }
    private void saveRole(){
        sPref = getSharedPreferences(name, MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_ROLE, role);
        ed.commit();
    }
    private void saveName(){
        sPref = getSharedPreferences(name, MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_NAME, scenName.getText().toString());
        ed.commit();
        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();

        //добавляем в счётчик сценариев
        sPref = getSharedPreferences("ScenariousCount", MODE_PRIVATE);
        SharedPreferences.Editor ed1 = sPref.edit();
        //String data = sPref.getString(SAVED_NAME, scenName.getText().toString());
        ScenNum += 1;
        ed1.putString("count: ", String.valueOf(ScenNum));
        ed1.commit();


        fileNames.add(name);
        sPref = getSharedPreferences("MyFiles", MODE_PRIVATE);
        SharedPreferences.Editor ed3 = sPref.edit();
        Set<String> fileNamesSet = new HashSet<>(fileNames);
        ed3.putStringSet("fileNames", fileNamesSet);
        ed3.apply();

        addCurrent(name);
    }

    public int countScen(){
        sPref = getSharedPreferences("ScenariousCount", MODE_PRIVATE);
        SharedPreferences.Editor ed1 = sPref.edit();
        String num = sPref.getString("count: ", String.valueOf(ScenNum));
        ScenNum = Integer.parseInt(num);
        System.out.println(ScenNum + " is now");
        return ScenNum;
    }

        public void addCurrent(String s) {
            sPref = getSharedPreferences("MyFiles", MODE_PRIVATE);
            SharedPreferences.Editor ed3 = sPref.edit();
            ed3.putString("current_name", s);
            ed3.apply();
        }

        public void toChoiceFormat(View v) {
            Intent intent = new Intent(scenarious_create2.this, edit_page.class);
        startActivity(intent);
    }

        public void toReturn(View v) {
            Intent intent = new Intent(scenarious_create2.this, frame_3_activity.class);
            startActivity(intent);
        }
}
	
	