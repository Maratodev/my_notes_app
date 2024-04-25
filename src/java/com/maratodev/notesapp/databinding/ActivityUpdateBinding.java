package com.maratodev.notesapp.databinding;

import android.view.ViewGroup;
import android.view.LayoutInflater;
import androidx.viewbinding.ViewBindings;
import com.maratodev.notesapp.R;
import android.view.View;
import com.google.android.material.textfield.TextInputEditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;

public final class ActivityUpdateBinding implements ViewBinding
{
    public final ImageView copyButton;
    public final TextInputLayout noteContent;
    public final TextView noteHeading;
    private final RelativeLayout rootView;
    public final ImageView shareButton;
    public final ImageView speakButton;
    public final TextInputLayout titleUp;
    public final TextInputEditText updateContentEditText;
    public final ImageView updateSaveButton;
    public final TextInputEditText updateTitleEditText;
    
    private ActivityUpdateBinding(final RelativeLayout rootView, final ImageView copyButton, final TextInputLayout noteContent, final TextView noteHeading, final ImageView shareButton, final ImageView speakButton, final TextInputLayout titleUp, final TextInputEditText updateContentEditText, final ImageView updateSaveButton, final TextInputEditText updateTitleEditText) {
        this.rootView = rootView;
        this.copyButton = copyButton;
        this.noteContent = noteContent;
        this.noteHeading = noteHeading;
        this.shareButton = shareButton;
        this.speakButton = speakButton;
        this.titleUp = titleUp;
        this.updateContentEditText = updateContentEditText;
        this.updateSaveButton = updateSaveButton;
        this.updateTitleEditText = updateTitleEditText;
    }
    
    public static ActivityUpdateBinding bind(final View view) {
        int n = R.id.copyButton;
        final ImageView imageView = (ImageView)ViewBindings.findChildViewById(view, n);
        if (imageView != null) {
            n = R.id.noteContent;
            final TextInputLayout textInputLayout = (TextInputLayout)ViewBindings.findChildViewById(view, n);
            if (textInputLayout != null) {
                n = R.id.noteHeading;
                final TextView textView = (TextView)ViewBindings.findChildViewById(view, n);
                if (textView != null) {
                    n = R.id.shareButton;
                    final ImageView imageView2 = (ImageView)ViewBindings.findChildViewById(view, n);
                    if (imageView2 != null) {
                        n = R.id.speakButton;
                        final ImageView imageView3 = (ImageView)ViewBindings.findChildViewById(view, n);
                        if (imageView3 != null) {
                            n = R.id.titleUp;
                            final TextInputLayout textInputLayout2 = (TextInputLayout)ViewBindings.findChildViewById(view, n);
                            if (textInputLayout2 != null) {
                                n = R.id.updateContentEditText;
                                final TextInputEditText textInputEditText = (TextInputEditText)ViewBindings.findChildViewById(view, n);
                                if (textInputEditText != null) {
                                    n = R.id.updateSaveButton;
                                    final ImageView imageView4 = (ImageView)ViewBindings.findChildViewById(view, n);
                                    if (imageView4 != null) {
                                        n = R.id.updateTitleEditText;
                                        final TextInputEditText textInputEditText2 = (TextInputEditText)ViewBindings.findChildViewById(view, n);
                                        if (textInputEditText2 != null) {
                                            return new ActivityUpdateBinding((RelativeLayout)view, imageView, textInputLayout, textView, imageView2, imageView3, textInputLayout2, textInputEditText, imageView4, textInputEditText2);
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
    
    public static ActivityUpdateBinding inflate(final LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }
    
    public static ActivityUpdateBinding inflate(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final boolean b) {
        final View inflate = layoutInflater.inflate(R.layout.activity_update, viewGroup, false);
        if (b) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }
    
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
