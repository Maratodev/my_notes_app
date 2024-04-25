package com.maratodev.notesapp;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View$OnClickListener;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import android.os.Bundle;
import android.content.Intent;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest$Builder;
import kotlin.jvm.internal.Intrinsics;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.MobileAds;
import android.content.Context;
import com.google.android.gms.ads.initialization.InitializationStatus;
import android.view.View;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.AdView;
import com.maratodev.notesapp.databinding.ActivityMainBinding;
import kotlin.Metadata;
import androidx.appcompat.app.AppCompatActivity;

@Metadata(d1 = { "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0019" }, d2 = { "Lcom/maratodev/notesapp/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/maratodev/notesapp/databinding/ActivityMainBinding;", "db", "Lcom/maratodev/notesapp/NotesDatabaseHelper;", "mAdView", "Lcom/google/android/gms/ads/AdView;", "getMAdView", "()Lcom/google/android/gms/ads/AdView;", "setMAdView", "(Lcom/google/android/gms/ads/AdView;)V", "mInterstitialAd", "Lcom/google/android/gms/ads/interstitial/InterstitialAd;", "notesAdapter", "Lcom/maratodev/notesapp/NotesAdapter;", "searchView", "Lcom/google/android/gms/ads/search/SearchAdView;", "loadBannerAds", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "app_debug" }, k = 1, mv = { 1, 8, 0 }, xi = 48)
public final class MainActivity extends AppCompatActivity
{
    private ActivityMainBinding binding;
    private NotesDatabaseHelper db;
    public AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private NotesAdapter notesAdapter;
    private SearchAdView searchView;
    
    private final void loadBannerAds() {
        MobileAds.initialize((Context)this, (OnInitializationCompleteListener)new MainActivity$$ExternalSyntheticLambda1());
        final View viewById = this.findViewById(R.id.adView);
        Intrinsics.checkNotNullExpressionValue((Object)viewById, "findViewById(R.id.adView)");
        this.setMAdView((AdView)viewById);
        final AdRequest build = new AdRequest$Builder().build();
        Intrinsics.checkNotNullExpressionValue((Object)build, "Builder().build()");
        this.getMAdView().loadAd(build);
        this.getMAdView().setAdListener((AdListener)new MainActivity$loadBannerAds.MainActivity$loadBannerAds$2());
    }
    
    private static final void loadBannerAds$lambda$1(final InitializationStatus initializationStatus) {
        Intrinsics.checkNotNullParameter((Object)initializationStatus, "it");
    }
    
    private static final void onCreate$lambda$0(final MainActivity mainActivity, final View view) {
        Intrinsics.checkNotNullParameter((Object)mainActivity, "this$0");
        mainActivity.startActivity(new Intent((Context)mainActivity, (Class)AddNoteActivity.class));
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
        final ActivityMainBinding inflate = ActivityMainBinding.inflate(this.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue((Object)inflate, "inflate(layoutInflater)");
        this.binding = inflate;
        final ActivityMainBinding activityMainBinding = null;
        ActivityMainBinding activityMainBinding2 = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding2 = null;
        }
        this.setContentView((View)activityMainBinding2.getRoot());
        this.loadBannerAds();
        this.db = new NotesDatabaseHelper((Context)this);
        NotesDatabaseHelper db;
        if ((db = this.db) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("db");
            db = null;
        }
        this.notesAdapter = new NotesAdapter(db.getAllNotes(), (Context)this);
        ActivityMainBinding binding;
        if ((binding = this.binding) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            binding = null;
        }
        binding.notesRecyclerView.setLayoutManager((RecyclerView$LayoutManager)new LinearLayoutManager((Context)this));
        ActivityMainBinding binding2;
        if ((binding2 = this.binding) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            binding2 = null;
        }
        final RecyclerView notesRecyclerView = binding2.notesRecyclerView;
        NotesAdapter notesAdapter;
        if ((notesAdapter = this.notesAdapter) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notesAdapter");
            notesAdapter = null;
        }
        notesRecyclerView.setAdapter((RecyclerView$Adapter)notesAdapter);
        ActivityMainBinding binding3 = this.binding;
        if (binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            binding3 = activityMainBinding;
        }
        binding3.addButton.setOnClickListener((View$OnClickListener)new MainActivity$$ExternalSyntheticLambda0(this));
    }
    
    protected void onResume() {
        super.onResume();
        final NotesAdapter notesAdapter = this.notesAdapter;
        NotesDatabaseHelper notesDatabaseHelper = null;
        NotesAdapter notesAdapter2 = notesAdapter;
        if (notesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notesAdapter");
            notesAdapter2 = null;
        }
        final NotesDatabaseHelper db = this.db;
        if (db == null) {
            Intrinsics.throwUninitializedPropertyAccessException("db");
        }
        else {
            notesDatabaseHelper = db;
        }
        notesAdapter2.refreshData(notesDatabaseHelper.getAllNotes());
    }
    
    public final void setMAdView(final AdView mAdView) {
        Intrinsics.checkNotNullParameter((Object)mAdView, "<set-?>");
        this.mAdView = mAdView;
    }
}
