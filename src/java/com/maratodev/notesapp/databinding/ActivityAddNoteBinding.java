package com.maratodev.notesapp.databinding;

import android.view.ViewGroup;
import android.view.LayoutInflater;
import androidx.viewbinding.ViewBindings;
import com.maratodev.notesapp.R;
import android.view.View;
import com.google.android.material.textfield.TextInputLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;
import androidx.viewbinding.ViewBinding;

public final class ActivityAddNoteBinding implements ViewBinding
{
    public final TextInputEditText contentEditText;
    public final TextView noteHeading;
    private final RelativeLayout rootView;
    public final ImageView saveButton;
    public final TextInputEditText titleEditText;
    public final TextInputLayout titleUp;
    
    private ActivityAddNoteBinding(final RelativeLayout rootView, final TextInputEditText contentEditText, final TextView noteHeading, final ImageView saveButton, final TextInputEditText titleEditText, final TextInputLayout titleUp) {
        this.rootView = rootView;
        this.contentEditText = contentEditText;
        this.noteHeading = noteHeading;
        this.saveButton = saveButton;
        this.titleEditText = titleEditText;
        this.titleUp = titleUp;
    }
    
    public static ActivityAddNoteBinding bind(final View view) {
        int n = R.id.contentEditText;
        final TextInputEditText textInputEditText = (TextInputEditText)ViewBindings.findChildViewById(view, n);
        if (textInputEditText != null) {
            n = R.id.noteHeading;
            final TextView textView = (TextView)ViewBindings.findChildViewById(view, n);
            if (textView != null) {
                n = R.id.saveButton;
                final ImageView imageView = (ImageView)ViewBindings.findChildViewById(view, n);
                if (imageView != null) {
                    n = R.id.titleEditText;
                    final TextInputEditText textInputEditText2 = (TextInputEditText)ViewBindings.findChildViewById(view, n);
                    if (textInputEditText2 != null) {
                        n = R.id.titleUp;
                        final TextInputLayout textInputLayout = (TextInputLayout)ViewBindings.findChildViewById(view, n);
                        if (textInputLayout != null) {
                            return new ActivityAddNoteBinding((RelativeLayout)view, textInputEditText, textView, imageView, textInputEditText2, textInputLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }
    
    public static ActivityAddNoteBinding inflate(final LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }
    
    public static ActivityAddNoteBinding inflate(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final boolean b) {
        final View inflate = layoutInflater.inflate(R.layout.activity_add_note, viewGroup, false);
        if (b) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }
    
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
