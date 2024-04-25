package com.maratodev.notesapp;

import android.view.View$OnClickListener;
import android.content.ClipboardManager;
import android.content.ClipData;
import android.os.Bundle;
import java.util.Locale;
import android.speech.tts.TextToSpeech$OnInitListener;
import android.content.Intent;
import android.widget.Toast;
import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import android.view.View;
import android.speech.tts.TextToSpeech;
import com.maratodev.notesapp.databinding.ActivityUpdateBinding;
import kotlin.Metadata;
import androidx.appcompat.app.AppCompatActivity;

@Metadata(d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000f" }, d2 = { "Lcom/maratodev/notesapp/UpdateNotesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/maratodev/notesapp/databinding/ActivityUpdateBinding;", "db", "Lcom/maratodev/notesapp/NotesDatabaseHelper;", "noteId", "", "textToSpeech", "Landroid/speech/tts/TextToSpeech;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug" }, k = 1, mv = { 1, 8, 0 }, xi = 48)
public final class UpdateNotesActivity extends AppCompatActivity
{
    private ActivityUpdateBinding binding;
    private NotesDatabaseHelper db;
    private int noteId;
    private TextToSpeech textToSpeech;
    
    public UpdateNotesActivity() {
        this.noteId = -1;
    }
    
    private static final void onCreate$lambda$0(final UpdateNotesActivity updateNotesActivity, final View view) {
        Intrinsics.checkNotNullParameter((Object)updateNotesActivity, "this$0");
        final ActivityUpdateBinding binding = updateNotesActivity.binding;
        final NotesDatabaseHelper notesDatabaseHelper = null;
        ActivityUpdateBinding activityUpdateBinding = binding;
        if (binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpdateBinding = null;
        }
        final int length = ((CharSequence)String.valueOf((Object)activityUpdateBinding.updateTitleEditText.getText())).length();
        final int n = 1;
        if (length == 0) {
            Toast.makeText((Context)updateNotesActivity, (CharSequence)"Please add Title", 0).show();
        }
        else {
            ActivityUpdateBinding binding2;
            if ((binding2 = updateNotesActivity.binding) == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                binding2 = null;
            }
            int n2;
            if (((CharSequence)String.valueOf((Object)binding2.updateContentEditText.getText())).length() == 0) {
                n2 = n;
            }
            else {
                n2 = 0;
            }
            if (n2 != 0) {
                Toast.makeText((Context)updateNotesActivity, (CharSequence)"Please add some note", 0).show();
            }
            else {
                ActivityUpdateBinding binding3;
                if ((binding3 = updateNotesActivity.binding) == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    binding3 = null;
                }
                final String value = String.valueOf((Object)binding3.updateTitleEditText.getText());
                ActivityUpdateBinding binding4;
                if ((binding4 = updateNotesActivity.binding) == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    binding4 = null;
                }
                final Note note = new Note(updateNotesActivity.noteId, value, String.valueOf((Object)binding4.updateContentEditText.getText()));
                NotesDatabaseHelper db = updateNotesActivity.db;
                if (db == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("db");
                    db = notesDatabaseHelper;
                }
                db.updateNote(note);
                updateNotesActivity.startActivity(new Intent((Context)updateNotesActivity, (Class)MainActivity.class));
                Toast.makeText((Context)updateNotesActivity, (CharSequence)"Updated Successfully", 0).show();
            }
        }
    }
    
    private static final void onCreate$lambda$2(final UpdateNotesActivity updateNotesActivity, final View view) {
        Intrinsics.checkNotNullParameter((Object)updateNotesActivity, "this$0");
        ActivityUpdateBinding binding;
        if ((binding = updateNotesActivity.binding) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            binding = null;
        }
        updateNotesActivity.textToSpeech = new TextToSpeech((Context)updateNotesActivity, (TextToSpeech$OnInitListener)new UpdateNotesActivity$$ExternalSyntheticLambda4(updateNotesActivity, String.valueOf((Object)binding.updateContentEditText.getText())));
    }
    
    private static final void onCreate$lambda$2$lambda$1(final UpdateNotesActivity updateNotesActivity, final String s, final int n) {
        Intrinsics.checkNotNullParameter((Object)updateNotesActivity, "this$0");
        Intrinsics.checkNotNullParameter((Object)s, "$text");
        if (n == 0) {
            TextToSpeech textToSpeech;
            if ((textToSpeech = updateNotesActivity.textToSpeech) == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textToSpeech");
                textToSpeech = null;
            }
            textToSpeech.setLanguage(Locale.US);
            TextToSpeech textToSpeech2;
            if ((textToSpeech2 = updateNotesActivity.textToSpeech) == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textToSpeech");
                textToSpeech2 = null;
            }
            textToSpeech2.speak((CharSequence)s, 0, (Bundle)null, (String)null);
        }
    }
    
    private static final void onCreate$lambda$3(final UpdateNotesActivity updateNotesActivity, final View view) {
        Intrinsics.checkNotNullParameter((Object)updateNotesActivity, "this$0");
        final ActivityUpdateBinding binding = updateNotesActivity.binding;
        final ActivityUpdateBinding activityUpdateBinding = null;
        ActivityUpdateBinding activityUpdateBinding2 = binding;
        if (binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpdateBinding2 = null;
        }
        if (((CharSequence)String.valueOf((Object)activityUpdateBinding2.updateContentEditText.getText())).length() == 0) {
            Toast.makeText((Context)updateNotesActivity, (CharSequence)"No note to copy", 0).show();
        }
        else {
            ActivityUpdateBinding binding2 = updateNotesActivity.binding;
            if (binding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                binding2 = activityUpdateBinding;
            }
            final ClipData plainText = ClipData.newPlainText((CharSequence)"text", (CharSequence)String.valueOf((Object)binding2.updateContentEditText.getText()));
            final Object systemService = updateNotesActivity.getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ((ClipboardManager)systemService).setPrimaryClip(plainText);
            Toast.makeText((Context)updateNotesActivity, (CharSequence)"Copied to clipboard", 0).show();
        }
    }
    
    private static final void onCreate$lambda$4(final UpdateNotesActivity updateNotesActivity, final View view) {
        Intrinsics.checkNotNullParameter((Object)updateNotesActivity, "this$0");
        final ActivityUpdateBinding binding = updateNotesActivity.binding;
        final ActivityUpdateBinding activityUpdateBinding = null;
        ActivityUpdateBinding activityUpdateBinding2 = binding;
        if (binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpdateBinding2 = null;
        }
        if (((CharSequence)String.valueOf((Object)activityUpdateBinding2.updateContentEditText.getText())).length() == 0) {
            Toast.makeText((Context)updateNotesActivity, (CharSequence)"Can not share empty note", 0).show();
        }
        else {
            final Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            ActivityUpdateBinding binding2 = updateNotesActivity.binding;
            if (binding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                binding2 = activityUpdateBinding;
            }
            intent.putExtra("android.intent.extra.TEXT", String.valueOf((Object)binding2.updateContentEditText.getText()));
            updateNotesActivity.startActivity(Intent.createChooser(intent, (CharSequence)"Share to"));
        }
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final ActivityUpdateBinding inflate = ActivityUpdateBinding.inflate(this.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue((Object)inflate, "inflate(layoutInflater)");
        this.binding = inflate;
        final ActivityUpdateBinding activityUpdateBinding = null;
        ActivityUpdateBinding activityUpdateBinding2 = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpdateBinding2 = null;
        }
        this.setContentView((View)activityUpdateBinding2.getRoot());
        this.db = new NotesDatabaseHelper((Context)this);
        if ((this.noteId = this.getIntent().getIntExtra("note_id", -1)) == -1) {
            this.finish();
            return;
        }
        NotesDatabaseHelper db;
        if ((db = this.db) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("db");
            db = null;
        }
        final Note notesById = db.getNotesById(this.noteId);
        ActivityUpdateBinding binding;
        if ((binding = this.binding) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            binding = null;
        }
        binding.updateTitleEditText.setText((CharSequence)notesById.getTitle());
        ActivityUpdateBinding binding2;
        if ((binding2 = this.binding) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            binding2 = null;
        }
        binding2.updateContentEditText.setText((CharSequence)notesById.getContent());
        ActivityUpdateBinding binding3;
        if ((binding3 = this.binding) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            binding3 = null;
        }
        binding3.updateSaveButton.setOnClickListener((View$OnClickListener)new UpdateNotesActivity$$ExternalSyntheticLambda0(this));
        ActivityUpdateBinding binding4;
        if ((binding4 = this.binding) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            binding4 = null;
        }
        binding4.speakButton.setOnClickListener((View$OnClickListener)new UpdateNotesActivity$$ExternalSyntheticLambda1(this));
        ActivityUpdateBinding binding5;
        if ((binding5 = this.binding) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            binding5 = null;
        }
        binding5.copyButton.setOnClickListener((View$OnClickListener)new UpdateNotesActivity$$ExternalSyntheticLambda2(this));
        ActivityUpdateBinding binding6 = this.binding;
        if (binding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            binding6 = activityUpdateBinding;
        }
        binding6.shareButton.setOnClickListener((View$OnClickListener)new UpdateNotesActivity$$ExternalSyntheticLambda3(this));
    }
}
