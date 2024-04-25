package com.maratodev.notesapp.databinding;

import android.view.ViewGroup;
import android.view.LayoutInflater;
import androidx.viewbinding.ViewBindings;
import com.maratodev.notesapp.R;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.TextView;
import android.widget.ImageView;
import com.google.android.gms.ads.AdView;
import androidx.viewbinding.ViewBinding;

public final class ActivityMainBinding implements ViewBinding
{
    public final AdView adView;
    public final ImageView addButton;
    public final TextView notesHeading;
    public final RecyclerView notesRecyclerView;
    public final RelativeLayout relativeLayout;
    private final ConstraintLayout rootView;
    public final SearchView searchView;
    
    private ActivityMainBinding(final ConstraintLayout rootView, final AdView adView, final ImageView addButton, final TextView notesHeading, final RecyclerView notesRecyclerView, final RelativeLayout relativeLayout, final SearchView searchView) {
        this.rootView = rootView;
        this.adView = adView;
        this.addButton = addButton;
        this.notesHeading = notesHeading;
        this.notesRecyclerView = notesRecyclerView;
        this.relativeLayout = relativeLayout;
        this.searchView = searchView;
    }
    
    public static ActivityMainBinding bind(final View view) {
        int n = R.id.adView;
        final AdView adView = (AdView)ViewBindings.findChildViewById(view, n);
        if (adView != null) {
            n = R.id.addButton;
            final ImageView imageView = (ImageView)ViewBindings.findChildViewById(view, n);
            if (imageView != null) {
                n = R.id.notesHeading;
                final TextView textView = (TextView)ViewBindings.findChildViewById(view, n);
                if (textView != null) {
                    n = R.id.notesRecyclerView;
                    final RecyclerView recyclerView = (RecyclerView)ViewBindings.findChildViewById(view, n);
                    if (recyclerView != null) {
                        n = R.id.relativeLayout;
                        final RelativeLayout relativeLayout = (RelativeLayout)ViewBindings.findChildViewById(view, n);
                        if (relativeLayout != null) {
                            n = R.id.searchView;
                            final SearchView searchView = (SearchView)ViewBindings.findChildViewById(view, n);
                            if (searchView != null) {
                                return new ActivityMainBinding((ConstraintLayout)view, adView, imageView, textView, recyclerView, relativeLayout, searchView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }
    
    public static ActivityMainBinding inflate(final LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }
    
    public static ActivityMainBinding inflate(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final boolean b) {
        final View inflate = layoutInflater.inflate(R.layout.activity_main, viewGroup, false);
        if (b) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }
    
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
