
	 
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
    import android.content.SyncRequest;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.ImageView;
    import android.widget.RelativeLayout;
    import android.widget.ScrollView;
    import android.widget.TableLayout;
    import android.widget.TableRow;
    import android.widget.TextView;

    import java.util.ArrayList;
    import java.util.HashSet;

    import alex.knyazz.myapplication.scenarious_create2;

    public class scenarious extends Activity {


    private ScrollView authorisation;
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


    SharedPreferences sPref;

    int scenNum = 0;

    public ArrayList<String> fileNames = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        countScene();

        if (scenNum == 0){
            setContentView(R.layout.scenarious);
        }else{
        setContentView(R.layout.scenarious1);}

        files();


        authorisation = (ScrollView) findViewById(R.id.authorisation);
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

    /*public void fillTableWithFileData() {
        for (String fileName : fileNames) {
            // Получаем SharedPreferences для текущего файла
            SharedPreferences filePrefs = getSharedPreferences(fileName, MODE_PRIVATE);

            // Получаем значения по ключам
            String name = filePrefs.getString("name", "");
            String type = filePrefs.getString("type", "");

            // Создаем новую строку в таблице
            TableRow row = new TableRow(this);

            // Клонируем существующие элементы TableRowSc, NameOfScene и TypeOfScene
            TableRow clonedRow = (TableRow) getLayoutInflater().inflate(R.layout.scenarious1, table, true);
            TextView clonedNameTextView = (TextView) clonedRow.findViewById(R.id.NameOfScene);
            TextView clonedTypeTextView = (TextView) clonedRow.findViewById(R.id.TypeOfScene);

            // Устанавливаем данные из файла SharedPreferences в клонированные элементы
            clonedNameTextView.setText(name);
            clonedTypeTextView.setText(type);

            // Добавляем клонированную строку в таблицу
            table.addView(clonedRow);
        }
    }*/



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
}
	
	