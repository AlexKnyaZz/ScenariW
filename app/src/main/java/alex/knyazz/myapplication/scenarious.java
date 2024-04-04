
	 
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

    import java.util.ArrayList;
    import java.util.HashSet;

    public class scenarious extends Activity implements View.OnClickListener {


        private RelativeLayout authorisation;
    private RelativeLayout content_container;
    private RelativeLayout page_authorisation_ek1;
    private View _bg__authorisation_ek2;
    private ImageView shape_with_text;
    private ImageView shape_with_text_ek2;
    private RelativeLayout frame_5;
    private Button Create;
    private Button Return;
    private ImageView shape_with_text_ek3;
    private ImageView shape_with_scanerious;
    private TextView __________________________________________________________________;
    private ImageView  shape_with_text_ek4;
    private TextView ___________________;
    private TableLayout table;
    private TableRow TableRowSc;
    private TextView NameOfScene;
    private TextView TypeOfScene;
        private ScrollView scrollTable;


    SharedPreferences sPref;

    int scenNum = 0;

    public ArrayList<String> fileNames = new ArrayList<String>();

        int clickNum = 0; // кол-во нажатий на кнопку

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        countScene();

        if (scenNum == 0){
            setContentView(R.layout.scenarious);
        }else{
        setContentView(R.layout.scenarious1);}

        files();
        fillTableWithFileData();

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
        Create = (Button) findViewById(R.id.Create);
        Return = (Button) findViewById(R.id.Return);
        shape_with_text_ek3 = (ImageView) findViewById(R.id.shape_with_text_ek3);
        shape_with_scanerious = (ImageView) findViewById(R.id.shape_with_scanerious);
        __________________________________________________________________ = (TextView) findViewById(R.id.__________________________________________________________________);
        shape_with_text_ek4 = (ImageView) findViewById(R.id.shape_with_text_ek4);
        ___________________ = (TextView) findViewById(R.id.___________________);
        scrollTable = (ScrollView) findViewById(R.id.scrollTable);



        //custom code goes here


    }

    // считаем, сколько сценариев создано
    public int countScene(){
        sPref = getSharedPreferences("ScenariousCount", MODE_PRIVATE);
        String  scenNum1 = sPref.getString("count: ", String.valueOf(scenNum));
        scenNum = Integer.parseInt(scenNum1);
        //scenNum = (Integer) sPref.getInt("count: ", scenNum);

        System.out.println("scenNum: " + scenNum);
        return scenNum;
    }

    // список имён созданных файлов
    public void files(){
        // берём названия файлов
        // System.out.println("fileNames !!!! : " + fileNames);
        sPref = getSharedPreferences("MyFiles", MODE_PRIVATE);
        ArrayList<String> savedFileNames = new ArrayList<String>(sPref.getStringSet("fileNames", new HashSet<>()));
        fileNames.addAll(savedFileNames);
        for (String fileName : fileNames) {
            System.out.println("fileNames: " + fileName);
        }
    }

        public void fillTableWithFileData() {
            int countId = 0; // счётчик для установки id
        for (String fileName : fileNames) {
            // увеличиваем счётчик
            countId += 1;

            // Получаем SharedPreferences для текущего файла
            SharedPreferences filePrefs = getSharedPreferences(fileName, MODE_PRIVATE);

            // Получаем значения по ключам
            String name = filePrefs.getString("saved_name", "");
            String type = filePrefs.getString("saved_type", "");

            // Клонируем существующие элементы
            TableLayout stk = (TableLayout) findViewById(R.id.table);
            TableRow clonedTableRow = new TableRow(this);
            TextView clonedNameTextView = new TextView(this);
            clonedNameTextView.setWidth(625);
            clonedNameTextView.setTextSize(25);
            clonedNameTextView.setPadding(80, 15, 5, 15);
            clonedNameTextView.setGravity(Gravity.LEFT);
            clonedNameTextView.setId(countId); // устанавливаем id
            clonedNameTextView.setClickable(true);

            clonedNameTextView.setOnClickListener(this);


            TextView clonedTypeTextView = new TextView(this);
            //clonedTypeTextView.setLayoutParams(new ViewGroup.LayoutParams(10, 42));
            clonedTypeTextView.setTextSize(25);
            clonedTypeTextView.setPadding(5, 15, 5, 15);
            clonedTypeTextView.setGravity(Gravity.CENTER);

            clonedNameTextView.setId(countId); // устанавливаем id
            clonedNameTextView.setTag(name);
            clonedTableRow.setTag(name);

            clonedNameTextView.setClickable(true);

            System.out.println("table 1");

            // Устанавливаем данные из файла SharedPreferences в клонированные элементы
            clonedNameTextView.setText(name);
            clonedTypeTextView.setText(type);

            clonedTableRow.addView(clonedNameTextView);
            System.out.println("table 2");
            clonedTableRow.addView(clonedTypeTextView);
            System.out.println("table 3");

            // Добавляем клонированную строку в таблицу
            stk.addView(clonedTableRow);
            System.out.println("table 4");
        }
        }



    public void toCreate1(View v){
        Intent intent = new Intent(scenarious.this, scenarious_create1.class);
        //System.out.println("succeeeeeeeeeeeeeeeeees");
        startActivity(intent);
    }
    public void toReturn(View v){
        Intent intent = new Intent(scenarious.this, frame_3_activity.class);
        //System.out.println("succeeeeeeeeeeeeeeeeees");
        startActivity(intent);
    }

        @Override
        public void onClick(View v) {
            clickNum += 1;
            System.out.println(clickNum);
            if (clickNum == 1) {
                // получаем тег нажатого элемента для дальнейших действий (тег = имя нового файла, что упрощает работу с данными)
                String naame = (String) v.getTag();
                v.setBackground(ContextCompat.getDrawable(this, R.color.bbb));
                // получаем данные этого элемента
                data(naame);

                addCurrent(naame);
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

        public void addCurrent(String s) {
            sPref = getSharedPreferences("MyFiles", MODE_PRIVATE);
            SharedPreferences.Editor ed3 = sPref.edit();
            ed3.putString("current_name", s);
            ed3.apply();
        }

        public void data(String s) {
            SharedPreferences filePrefs = getSharedPreferences(s, MODE_PRIVATE);

            // Получаем значения по ключам
            String name = filePrefs.getString("saved_name", "");
            String type = filePrefs.getString("saved_type", "");

            System.out.println("name: " + name + ", type: " + type);
        }

}
	
	