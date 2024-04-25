package com.maratodev.notesapp.databinding;

import android.view.ViewGroup;
import android.view.LayoutInflater;
import androidx.viewbinding.ViewBindings;
import com.maratodev.notesapp.R;
import android.view.View;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ImageView;
import com.google.android.gms.ads.AdView;
import androidx.viewbinding.ViewBinding;

public final class ActivityViewNoteBinding implements ViewBinding
{
    public final AdView adView;
    public final ImageView copyButton;
    public final ImageView editUpdateNoteButton;
    public final TextView noteViewContent;
    public final TextView noteViewTitle;
    public final RelativeLayout relativeLayout;
    private final ConstraintLayout rootView;
    public final ScrollView scrollView;
    public final ImageView shareButton;
    public final ImageView speakButton;
    
    private ActivityViewNoteBinding(final ConstraintLayout rootView, final AdView adView, final ImageView copyButton, final ImageView editUpdateNoteButton, final TextView noteViewContent, final TextView noteViewTitle, final RelativeLayout relativeLayout, final ScrollView scrollView, final ImageView shareButton, final ImageView speakButton) {
        this.rootView = rootView;
        this.adView = adView;
        this.copyButton = copyButton;
        this.editUpdateNoteButton = editUpdateNoteButton;
        this.noteViewContent = noteViewContent;
        this.noteViewTitle = noteViewTitle;
        this.relativeLayout = relativeLayout;
        this.scrollView = scrollView;
        this.shareButton = shareButton;
        this.speakButton = speakButton;
    }
    
    public static ActivityViewNoteBinding bind(final View view) {
        int n = R.id.adView;
        final AdView adView = (AdView)ViewBindings.findChildViewById(view, n);
        if (adView != null) {
            n = R.id.copyButton;
            final ImageView imageView = (ImageView)ViewBindings.findChildViewById(view, n);
            if (imageView != null) {
                n = R.id.editUpdateNoteButton;
                final ImageView imageView2 = (ImageView)ViewBindings.findChildViewById(view, n);
                if (imageView2 != null) {
                    n = R.id.noteViewContent;
                    final TextView textView = (TextView)ViewBindings.findChildViewById(view, n);
                    if (textView != null) {
                        n = R.id.noteViewTitle;
                        final TextView textView2 = (TextView)ViewBindings.findChildViewById(view, n);
                        if (textView2 != null) {
                            n = R.id.relativeLayout;
                            final RelativeLayout relativeLayout = (RelativeLayout)ViewBindings.findChildViewById(view, n);
                            if (relativeLayout != null) {
                                n = R.id.scrollView;
                                final ScrollView scrollView = (ScrollView)ViewBindings.findChildViewById(view, n);
                                if (scrollView != null) {
                                    n = R.id.shareButton;
                                    final ImageView imageView3 = (ImageView)ViewBindings.findChildViewById(view, n);
                                    if (imageView3 != null) {
                                        n = R.id.speakButton;
                                        final ImageView imageView4 = (ImageView)ViewBindings.findChildViewById(view, n);
                                        if (imageView4 != null) {
                                            return new ActivityViewNoteBinding((ConstraintLayout)view, adView, imageView, imageView2, textView, textView2, relativeLayout, scrollView, imageView3, imageView4);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }
    
    public static ActivityViewNoteBinding inflate(final LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }
    
    public static ActivityViewNoteBinding inflate(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final boolean b) {
        final View inflate = layoutInflater.inflate(R.layout.activity_view_note, viewGroup, false);
        if (b) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }
    
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
