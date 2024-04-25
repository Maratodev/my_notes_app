package com.maratodev.notesapp.databinding;

import android.view.ViewGroup;
import android.view.LayoutInflater;
import androidx.viewbinding.ViewBindings;
import com.maratodev.notesapp.R;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;

public final class ActivityFingerprintBinding implements ViewBinding
{
    public final ImageView fingerprintImage;
    public final TextView fpTextView;
    private final LinearLayout rootView;
    
    private ActivityFingerprintBinding(final LinearLayout rootView, final ImageView fingerprintImage, final TextView fpTextView) {
        this.rootView = rootView;
        this.fingerprintImage = fingerprintImage;
        this.fpTextView = fpTextView;
    }
    
    public static ActivityFingerprintBinding bind(final View view) {
        int n = R.id.fingerprintImage;
        final ImageView imageView = (ImageView)ViewBindings.findChildViewById(view, n);
        if (imageView != null) {
            n = R.id.fpTextView;
            final TextView textView = (TextView)ViewBindings.findChildViewById(view, n);
            if (textView != null) {
                return new ActivityFingerprintBinding((LinearLayout)view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }
    
    public static ActivityFingerprintBinding inflate(final LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }
    
    public static ActivityFingerprintBinding inflate(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final boolean b) {
        final View inflate = layoutInflater.inflate(R.layout.activity_fingerprint, viewGroup, false);
        if (b) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }
    
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
