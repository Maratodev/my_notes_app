package com.maratodev.notesapp.databinding;

import android.view.ViewGroup;
import android.view.LayoutInflater;
import androidx.viewbinding.ViewBindings;
import com.maratodev.notesapp.R;
import android.view.View;
import androidx.cardview.widget.CardView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

public final class NotesItemBinding implements ViewBinding
{
    public final TextView contentTextView;
    public final ImageView moreButton;
    private final CardView rootView;
    public final TextView titleTextView;
    
    private NotesItemBinding(final CardView rootView, final TextView contentTextView, final ImageView moreButton, final TextView titleTextView) {
        this.rootView = rootView;
        this.contentTextView = contentTextView;
        this.moreButton = moreButton;
        this.titleTextView = titleTextView;
    }
    
    public static NotesItemBinding bind(final View view) {
        int n = R.id.contentTextView;
        final TextView textView = (TextView)ViewBindings.findChildViewById(view, n);
        if (textView != null) {
            n = R.id.moreButton;
            final ImageView imageView = (ImageView)ViewBindings.findChildViewById(view, n);
            if (imageView != null) {
                n = R.id.titleTextView;
                final TextView textView2 = (TextView)ViewBindings.findChildViewById(view, n);
                if (textView2 != null) {
                    return new NotesItemBinding((CardView)view, textView, imageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }
    
    public static NotesItemBinding inflate(final LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }
    
    public static NotesItemBinding inflate(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final boolean b) {
        final View inflate = layoutInflater.inflate(R.layout.notes_item, viewGroup, false);
        if (b) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }
    
    public CardView getRoot() {
        return this.rootView;
    }
}
