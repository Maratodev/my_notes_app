package com.maratodev.notesapp;

import android.view.View$OnClickListener;
import android.content.Intent;
import android.content.ClipboardManager;
import android.content.ClipData;
import android.widget.Toast;
import android.os.Bundle;
import java.util.Locale;
import android.speech.tts.TextToSpeech$OnInitListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest$Builder;
import kotlin.jvm.internal.Intrinsics;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.MobileAds;
import android.content.Context;
import com.google.android.gms.ads.initialization.InitializationStatus;
import android.view.View;
import android.speech.tts.TextToSpeech;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.AdView;
import com.maratodev.notesapp.databinding.ActivityViewNoteBinding;
import kotlin.Metadata;
import androidx.appcompat.app.AppCompatActivity;

@Metadata(d1 = { "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018" }, d2 = { "Lcom/maratodev/notesapp/ViewNoteActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/maratodev/notesapp/databinding/ActivityViewNoteBinding;", "db", "Lcom/maratodev/notesapp/NotesDatabaseHelper;", "mAdView", "Lcom/google/android/gms/ads/AdView;", "getMAdView", "()Lcom/google/android/gms/ads/AdView;", "setMAdView", "(Lcom/google/android/gms/ads/AdView;)V", "mInterstitialAd", "Lcom/google/android/gms/ads/interstitial/InterstitialAd;", "noteId", "", "textToSpeech", "Landroid/speech/tts/TextToSpeech;", "loadBannerAds", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug" }, k = 1, mv = { 1, 8, 0 }, xi = 48)
public final class ViewNoteActivity extends AppCompatActivity
{
    private ActivityViewNoteBinding binding;
    private NotesDatabaseHelper db;
    public AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private int noteId;
    private TextToSpeech textToSpeech;
    
    public ViewNoteActivity() {
        this.noteId = -1;
    }
    
    private final void loadBannerAds() {
        MobileAds.initialize((Context)this, (OnInitializationCompleteListener)new ViewNoteActivity$$ExternalSyntheticLambda4());
        final View viewById = this.findViewById(R.id.adView);
        Intrinsics.checkNotNullExpressionValue((Object)viewById, "findViewById(R.id.adView)");
        this.setMAdView((AdView)viewById);
        final AdRequest build = new AdRequest$Builder().build();
        Intrinsics.checkNotNullExpressionValue((Object)build, "Builder().build()");
        this.getMAdView().loadAd(build);
        this.getMAdView().setAdListener((AdListener)new ViewNoteActivity$loadBannerAds.ViewNoteActivity$loadBannerAds$2());
    }
    
    private static final void loadBannerAds$lambda$6(final InitializationStatus initializationStatus) {
        Intrinsics.checkNotNullParameter((Object)initializationStatus, "it");
    }
    
    private static final void onCreate$lambda$1(final ViewNoteActivity viewNoteActivity, final View view) {
        Intrinsics.checkNotNullParameter((Object)viewNoteActivity, "this$0");
        ActivityViewNoteBinding binding;
        if ((binding = viewNoteActivity.binding) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            binding = null;
        }
        viewNoteActivity.textToSpeech = new TextToSpeech((Context)viewNoteActivity, (TextToSpeech$OnInitListener)new ViewNoteActivity$$ExternalSyntheticLambda5(viewNoteActivity, binding.noteViewContent.getText().toString()));
    }
    
    private static final void onCreate$lambda$1$lambda$0(final ViewNoteActivity viewNoteActivity, final String s, final int n) {
        Intrinsics.checkNotNullParameter((Object)viewNoteActivity, "this$0");
        Intrinsics.checkNotNullParameter((Object)s, "$text");
        if (n == 0) {
            TextToSpeech textToSpeech;
            if ((textToSpeech = viewNoteActivity.textToSpeech) == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textToSpeech");
                textToSpeech = null;
            }
            textToSpeech.setLanguage(Locale.US);
            TextToSpeech textToSpeech2;
            if ((textToSpeech2 = viewNoteActivity.textToSpeech) == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textToSpeech");
                textToSpeech2 = null;
            }
            textToSpeech2.speak((CharSequence)s, 0, (Bundle)null, (String)null);
        }
    }
    
    private static final void onCreate$lambda$2(final ViewNoteActivity viewNoteActivity, final View view) {
        Intrinsics.checkNotNullParameter((Object)viewNoteActivity, "this$0");
        final ActivityViewNoteBinding binding = viewNoteActivity.binding;
        final ActivityViewNoteBinding activityViewNoteBinding = null;
        ActivityViewNoteBinding activityViewNoteBinding2 = binding;
        if (binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityViewNoteBinding2 = null;
        }
        if (((CharSequence)activityViewNoteBinding2.noteViewContent.getText().toString()).length() == 0) {
            Toast.makeText((Context)viewNoteActivity, (CharSequence)"No note to copy", 0).show();
        }
        else {
            ActivityViewNoteBinding binding2 = viewNoteActivity.binding;
            if (binding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                binding2 = activityViewNoteBinding;
            }
            final ClipData plainText = ClipData.newPlainText((CharSequence)"text", (CharSequence)binding2.noteViewContent.getText().toString());
            final Object systemService = viewNoteActivity.getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ((ClipboardManager)systemService).setPrimaryClip(plainText);
            Toast.makeText((Context)viewNoteActivity, (CharSequence)"Copied to clipboard", 0).show();
        }
    }
    
    private static final void onCreate$lambda$3(final ViewNoteActivity viewNoteActivity, final View view) {
        Intrinsics.checkNotNullParameter((Object)viewNoteActivity, "this$0");
        final ActivityViewNoteBinding binding = viewNoteActivity.binding;
        final ActivityViewNoteBinding activityViewNoteBinding = null;
        ActivityViewNoteBinding activityViewNoteBinding2 = binding;
        if (binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityViewNoteBinding2 = null;
        }
        if (((CharSequence)activityViewNoteBinding2.noteViewContent.getText().toString()).length() == 0) {
            Toast.makeText((Context)viewNoteActivity, (CharSequence)"Can not share empty note", 0).show();
        }
        else {
            final Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            ActivityViewNoteBinding binding2 = viewNoteActivity.binding;
            if (binding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                binding2 = activityViewNoteBinding;
            }
            intent.putExtra("android.intent.extra.TEXT", binding2.noteViewContent.getText().toString());
            viewNoteActivity.startActivity(Intent.createChooser(intent, (CharSequence)"Share to"));
        }
    }
    
    private static final void onCreate$lambda$5(final ViewNoteActivity viewNoteActivity, final Note note, final View view) {
        Intrinsics.checkNotNullParameter((Object)viewNoteActivity, "this$0");
        Intrinsics.checkNotNullParameter((Object)note, "$note");
        final Intent intent = new Intent((Context)viewNoteActivity, (Class)UpdateNotesActivity.class);
        intent.putExtra("note_id", note.getId());
        viewNoteActivity.startActivity(intent);
    }
    
    public final AdView getMAdView() {
        final AdView mAdView = this.mAdView;
        if (mAdView != null) {
            return mAdView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAdView");
        return null;
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final ActivityViewNoteBinding inflate = ActivityViewNoteBinding.inflate(this.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue((Object)inflate, "inflate(layoutInflater)");
        this.binding = inflate;
        final ActivityViewNoteBinding activityViewNoteBinding = null;
        ActivityViewNoteBinding activityViewNoteBinding2 = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityViewNoteBinding2 = null;
        }
        this.setContentView((View)activityViewNoteBinding2.getRoot());
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
        ActivityViewNoteBinding binding;
        if ((binding = this.binding) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            binding = null;
        }
        binding.noteViewTitle.setText((CharSequence)notesById.getTitle());
        ActivityViewNoteBinding binding2;
        if ((binding2 = this.binding) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            binding2 = null;
        }
        binding2.noteViewContent.setText((CharSequence)notesById.getContent());
        this.loadBannerAds();
        ActivityViewNoteBinding binding3;
        if ((binding3 = this.binding) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            binding3 = null;
        }
        binding3.speakButton.setOnClickListener((View$OnClickListener)new ViewNoteActivity$$ExternalSyntheticLambda0(this));
        ActivityViewNoteBinding binding4;
        if ((binding4 = this.binding) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            binding4 = null;
        }
        binding4.copyButton.setOnClickListener((View$OnClickListener)new ViewNoteActivity$$ExternalSyntheticLambda1(this));
        ActivityViewNoteBinding binding5;
        if ((binding5 = this.binding) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            binding5 = null;
        }
        binding5.shareButton.setOnClickListener((View$OnClickListener)new ViewNoteActivity$$ExternalSyntheticLambda2(this));
        ActivityViewNoteBinding binding6 = this.binding;
        if (binding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            binding6 = activityViewNoteBinding;
        }
        binding6.editUpdateNoteButton.setOnClickListener((View$OnClickListener)new ViewNoteActivity$$ExternalSyntheticLambda3(this, notesById));
    }
    
    public final void setMAdView(final AdView mAdView) {
        Intrinsics.checkNotNullParameter((Object)mAdView, "<set-?>");
        this.mAdView = mAdView;
    }
}
