package com.maratodev.notesapp;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import kotlin.jvm.internal.Intrinsics;
import android.content.Context;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.Metadata;
import android.database.sqlite.SQLiteOpenHelper;

@Metadata(d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000bJ\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\"\u0010\u0012\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000b¨\u0006\u0017" }, d2 = { "Lcom/maratodev/notesapp/NotesDatabaseHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "deleteNote", "", "noteId", "", "getAllNotes", "", "Lcom/maratodev/notesapp/Note;", "getNotesById", "insertNote", "note", "onCreate", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "newVersion", "updateNote", "Companion", "app_debug" }, k = 1, mv = { 1, 8, 0 }, xi = 48)
public final class NotesDatabaseHelper extends SQLiteOpenHelper
{
    private static final String COLUMN_CONTENT = "content";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    public static final Companion Companion;
    private static final String DATABASE_NAME = "notesapp.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "allnotes";
    
    static {
        Companion = new Companion(null);
    }
    
    public NotesDatabaseHelper(final Context context) {
        Intrinsics.checkNotNullParameter((Object)context, "context");
        super(context, "notesapp.db", (SQLiteDatabase$CursorFactory)null, 1);
    }
    
    public final void deleteNote(final int n) {
        final SQLiteDatabase writableDatabase = this.getWritableDatabase();
        writableDatabase.delete("allnotes", "id = ?", new String[] { String.valueOf(n) });
        writableDatabase.close();
    }
    
    public final List<Note> getAllNotes() {
        final List list = (List)new ArrayList();
        final SQLiteDatabase readableDatabase = this.getReadableDatabase();
        final Cursor rawQuery = readableDatabase.rawQuery("SELECT * FROM allnotes", (String[])null);
        while (rawQuery.moveToNext()) {
            final int int1 = rawQuery.getInt(rawQuery.getColumnIndexOrThrow("id"));
            final String string = rawQuery.getString(rawQuery.getColumnIndexOrThrow("title"));
            final String string2 = rawQuery.getString(rawQuery.getColumnIndexOrThrow("content"));
            Intrinsics.checkNotNullExpressionValue((Object)string, "title");
            Intrinsics.checkNotNullExpressionValue((Object)string2, "content");
            list.add((Object)new Note(int1, string, string2));
        }
        rawQuery.close();
        readableDatabase.close();
        return (List<Note>)list;
    }
    
    public final Note getNotesById(int int1) {
        final SQLiteDatabase readableDatabase = this.getReadableDatabase();
        final Cursor rawQuery = readableDatabase.rawQuery("SELECT * FROM allnotes WHERE id = " + int1, (String[])null);
        rawQuery.moveToFirst();
        int1 = rawQuery.getInt(rawQuery.getColumnIndexOrThrow("id"));
        final String string = rawQuery.getString(rawQuery.getColumnIndexOrThrow("title"));
        final String string2 = rawQuery.getString(rawQuery.getColumnIndexOrThrow("content"));
        rawQuery.close();
        readableDatabase.close();
        Intrinsics.checkNotNullExpressionValue((Object)string, "title");
        Intrinsics.checkNotNullExpressionValue((Object)string2, "content");
        return new Note(int1, string, string2);
    }
    
    public final void insertNote(final Note note) {
        Intrinsics.checkNotNullParameter((Object)note, "note");
        final SQLiteDatabase writableDatabase = this.getWritableDatabase();
        final ContentValues contentValues = new ContentValues();
        contentValues.put("title", note.getTitle());
        contentValues.put("content", note.getContent());
        writableDatabase.insert("allnotes", (String)null, contentValues);
        writableDatabase.close();
    }
    
    public void onCreate(final SQLiteDatabase sqLiteDatabase) {
        if (sqLiteDatabase != null) {
            sqLiteDatabase.execSQL("CREATE TABLE allnotes (id INTEGER PRIMARY KEY, title TEXT, content TEXT)");
        }
    }
    
    public void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
        if (sqLiteDatabase != null) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS allnotes");
        }
        this.onCreate(sqLiteDatabase);
    }
    
    public final void updateNote(final Note note) {
        Intrinsics.checkNotNullParameter((Object)note, "note");
        final SQLiteDatabase writableDatabase = this.getWritableDatabase();
        final ContentValues contentValues = new ContentValues();
        contentValues.put("title", note.getTitle());
        contentValues.put("content", note.getContent());
        writableDatabase.update("allnotes", contentValues, "id = ?", new String[] { String.valueOf(note.getId()) });
        writableDatabase.close();
    }
    
    @Metadata(d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b" }, d2 = { "Lcom/maratodev/notesapp/NotesDatabaseHelper$Companion;", "", "()V", "COLUMN_CONTENT", "", "COLUMN_ID", "COLUMN_TITLE", "DATABASE_NAME", "DATABASE_VERSION", "", "TABLE_NAME", "app_debug" }, k = 1, mv = { 1, 8, 0 }, xi = 48)
    public static final class Companion
    {
        private Companion() {
        }
    }
}
