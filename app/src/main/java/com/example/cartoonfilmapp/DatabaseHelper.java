package com.example.cartoonfilmapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "cartoonDB";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "cartoons";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_VIDEO_URL = "video_url";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_VIDEO_URL + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addCartoon(String name, String description, String videoUrl) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_DESCRIPTION, description);
        values.put(COLUMN_VIDEO_URL, videoUrl);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    public void addInitialCartoons() {
        addCartoon("Rick and Morty", "Rick and Morty is an American animated science fiction sitcom.", "https://www.youtube.com/watch?v=Rq-WoQDqu_o");
        addCartoon("SpongeBob", "SpongeBob is a cheerful sponge living under the sea.", "https://www.youtube.com/watch?v=Ho0Csm1pANM");
        addCartoon("Regular Show", "Regular Show follows the adventures of Mordecai and Rigby.", "https://www.youtube.com/watch?v=q7_9k08TATc");
        addCartoon("Tom and Jerry", "Tom and Jerry is a classic cat-and-mouse cartoon.", "https://www.youtube.com/watch?v=t0Q2otsqC4I");
        addCartoon("Batman", "Batman is a superhero fighting crime in Gotham City.", "https://www.youtube.com/watch?v=pWJMEHMi09U");
    }

    public Cursor getAllCartoons() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }
}
