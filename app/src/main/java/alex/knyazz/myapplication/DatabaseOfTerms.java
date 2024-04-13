package alex.knyazz.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOfTerms extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "terms.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "terms_table";
    private static final String COLUMN_TERM = "term";
    private static final String COLUMN_CATEGORY = "category";
    private static final String COLUMN_AGE_CATEGORY = "age_category";

    public DatabaseOfTerms(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_TERM + " TEXT,"
                + COLUMN_CATEGORY + " TEXT,"
                + COLUMN_AGE_CATEGORY + " INTEGER"
                + ")";
        db.execSQL(createTableQuery);

        // Заполняем базу данных данными
        // ru
        addTerm(db, "выпить", "алкоголь", 18);
        addTerm(db, "употребить", "алкоголь", 18);
        addTerm(db, "употребить", "наркотики", 18);
        addTerm(db, "курить", "табак", 18);

        //////////////////////////////////////////////////////////////////////////
        // en
        addTerm(db, "drink", "алкоголь", 18);
        addTerm(db, "drunk", "алкоголь", 18);
        addTerm(db, "use", "наркотики", 18);
        addTerm(db, "smoke", "табак", 18);

        System.out.println("Database created and filled with initial data.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private void addTerm(SQLiteDatabase db, String term, String category, int ageCategory) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_TERM, term);
        values.put(COLUMN_CATEGORY, category);
        values.put(COLUMN_AGE_CATEGORY, ageCategory);
        db.insert(TABLE_NAME, null, values);
    }

    public Cursor getAllTerms() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    // возвращает возрастную категорию
    public int getAgeCategoryByTerm(String term) {
        SQLiteDatabase db = this.getReadableDatabase();
        System.out.println("Executing query: SELECT " + COLUMN_AGE_CATEGORY + " FROM " + TABLE_NAME +
                " WHERE " + COLUMN_TERM + "='" + term + "'");
        Cursor cursor = db.rawQuery("SELECT " + COLUMN_AGE_CATEGORY + " FROM " + TABLE_NAME +
                " WHERE " + COLUMN_TERM + "=?", new String[]{term});
        int ageCategory = -1; // По умолчанию возрастная категория -1, если термин не найден
        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex(COLUMN_AGE_CATEGORY);
            ageCategory = cursor.getInt(columnIndex);
            System.out.println("Term: " + term + ", Age Category: " + ageCategory);
        }
        cursor.close();
        return ageCategory;

    }

    public void printAllTerms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        try {
            if (cursor.moveToFirst()) {
                int termIndex = cursor.getColumnIndex(COLUMN_TERM);
                int categoryIndex = cursor.getColumnIndex(COLUMN_CATEGORY);
                int ageCategoryIndex = cursor.getColumnIndex(COLUMN_AGE_CATEGORY);
                do {
                    if (termIndex != -1 && categoryIndex != -1 && ageCategoryIndex != -1) {
                        String term = cursor.getString(termIndex);
                        String category = cursor.getString(categoryIndex);
                        int ageCategory = cursor.getInt(ageCategoryIndex);
                        System.out.println("Term: " + term + ", Category: " + category + ", Age Category: " + ageCategory);
                    } else {
                        System.out.println("Один или несколько столбцов не найдены в курсоре.");
                    }
                } while (cursor.moveToNext());
            }
        } finally {
            cursor.close();
        }
    }


}
