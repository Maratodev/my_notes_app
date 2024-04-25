package com.maratodev.notesapp;

import android.view.View$OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import android.view.View;
import com.maratodev.notesapp.databinding.ActivityAddNoteBinding;
import kotlin.Metadata;
import androidx.appcompat.app.AppCompatActivity;

@Metadata(d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000b" }, d2 = { "Lcom/maratodev/notesapp/AddNoteActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/maratodev/notesapp/databinding/ActivityAddNoteBinding;", "db", "Lcom/maratodev/notesapp/NotesDatabaseHelper;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug" }, k = 1, mv = { 1, 8, 0 }, xi = 48)
public final class AddNoteActivity extends AppCompatActivity
{
    private ActivityAddNoteBinding binding;
    private NotesDatabaseHelper db;
    
    private static final void onCreate$lambda$0(final AddNoteActivity addNoteActivity, final View view) {
        Intrinsics.checkNotNullParameter((Object)addNoteActivity, "this$0");
        final ActivityAddNoteBinding binding = addNoteActivity.binding;
        final NotesDatabaseHelper notesDatabaseHelper = null;
        ActivityAddNoteBinding activityAddNoteBinding = binding;
        if (binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddNoteBinding = null;
        }
        final int length = ((CharSequence)String.valueOf((Object)activityAddNoteBinding.titleEditText.getText())).length();
        final int n = 1;
        if (length == 0) {
            Toast.makeText((Context)addNoteActivity, (CharSequence)"Please add Title", 0).show();
        }
        else {
            ActivityAddNoteBinding binding2;
            if ((binding2 = addNoteActivity.binding) == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                binding2 = null;
            }
            int n2;
            if (((CharSequence)String.valueOf((Object)binding2.contentEditText.getText())).length() == 0) {
                n2 = n;
            }
            else {
                n2 = 0;
            }
            if (n2 != 0) {
                Toast.makeText((Context)addNoteActivity, (CharSequence)"Please add some note", 0).show();
            }
            else {
                ActivityAddNoteBinding binding3;
                if ((binding3 = addNoteActivity.binding) == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    binding3 = null;
                }
                final String value = String.valueOf((Object)binding3.titleEditText.getText());
                ActivityAddNoteBinding binding4;
                if ((binding4 = addNoteActivity.binding) == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    binding4 = null;
                }
                final Note note = new Note(0, value, String.valueOf((Object)binding4.contentEditText.getText()));
                NotesDatabaseHelper db = addNoteActivity.db;
                if (db == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("db");
                    db = notesDatabaseHelper;
                }
                db.insertNote(note);
                addNoteActivity.finish();
                Toast.makeText((Context)addNoteActivity, (CharSequence)"Note saved", 0).show();
            }
        }
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final ActivityAddNoteBinding inflate = ActivityAddNoteBinding.inflate(this.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue((Object)inflate, "inflate(layoutInflater)");
        this.binding = inflate;
        final ActivityAddNoteBinding activityAddNoteBinding = null;
        ActivityAddNoteBinding activityAddNoteBinding2 = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddNoteBinding2 = null;
        }
        this.setContentView((View)activityAddNoteBinding2.getRoot());
        this.db = new NotesDatabaseHelper((Context)this);
        ActivityAddNoteBinding binding = this.binding;
        if (binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            binding = activityAddNoteBinding;
        }
        binding.saveButton.setOnClickListener((View$OnClickListener)new AddNoteActivity$$ExternalSyntheticLambda0(this));
    }
}
