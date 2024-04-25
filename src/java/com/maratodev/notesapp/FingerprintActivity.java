package com.maratodev.notesapp;

import android.view.View$OnClickListener;
import android.os.Bundle;
import androidx.biometric.BiometricPrompt$PromptInfo$Builder;
import androidx.biometric.BiometricPrompt$AuthenticationCallback;
import androidx.fragment.app.FragmentActivity;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;
import androidx.biometric.BiometricManager;
import android.content.Context;
import android.view.View;
import androidx.biometric.BiometricPrompt$PromptInfo;
import java.util.concurrent.Executor;
import androidx.biometric.BiometricPrompt;
import com.maratodev.notesapp.databinding.ActivityFingerprintBinding;
import kotlin.Metadata;
import androidx.appcompat.app.AppCompatActivity;

@Metadata(d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0012" }, d2 = { "Lcom/maratodev/notesapp/FingerprintActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/maratodev/notesapp/databinding/ActivityFingerprintBinding;", "biometricPrompt", "Landroidx/biometric/BiometricPrompt;", "executor", "Ljava/util/concurrent/Executor;", "promptInfo", "Landroidx/biometric/BiometricPrompt$PromptInfo;", "cheCkDeviceHasBiometric", "", "createBiometricsListener", "createPromptInfo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug" }, k = 1, mv = { 1, 8, 0 }, xi = 48)
public final class FingerprintActivity extends AppCompatActivity
{
    private ActivityFingerprintBinding binding;
    private BiometricPrompt biometricPrompt;
    private Executor executor;
    private BiometricPrompt$PromptInfo promptInfo;
    
    private final void cheCkDeviceHasBiometric() {
        final BiometricManager from = BiometricManager.from((Context)this);
        Intrinsics.checkNotNullExpressionValue((Object)from, "from(this@FingerprintActivity)");
        final int canAuthenticate = from.canAuthenticate(32783);
        final ActivityFingerprintBinding activityFingerprintBinding = null;
        ActivityFingerprintBinding activityFingerprintBinding2 = null;
        BiometricPrompt$PromptInfo biometricPrompt$PromptInfo = null;
        final ActivityFingerprintBinding activityFingerprintBinding3 = null;
        final ActivityFingerprintBinding activityFingerprintBinding4 = null;
        switch (canAuthenticate) {
            default: {
                ActivityFingerprintBinding binding = this.binding;
                if (binding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    binding = activityFingerprintBinding3;
                }
                binding.fpTextView.setText((CharSequence)"Something went wrong! ");
                break;
            }
            case 12: {
                ActivityFingerprintBinding binding2 = this.binding;
                if (binding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    binding2 = activityFingerprintBinding4;
                }
                binding2.fpTextView.setText((CharSequence)"No Biometric Features On This Device ");
                break;
            }
            case 11: {
                ActivityFingerprintBinding binding3 = this.binding;
                if (binding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    binding3 = activityFingerprintBinding;
                }
                binding3.fpTextView.setText((CharSequence)"Device is not enable Biometric Features ");
                break;
            }
            case 1: {
                final ActivityFingerprintBinding binding4 = this.binding;
                if (binding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                else {
                    activityFingerprintBinding2 = binding4;
                }
                activityFingerprintBinding2.fpTextView.setText((CharSequence)"Biometric Features On This Device Are Currently Unavailable");
                break;
            }
            case 0: {
                ActivityFingerprintBinding binding5;
                if ((binding5 = this.binding) == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    binding5 = null;
                }
                binding5.fpTextView.setText((CharSequence)"Biometric Features is Available On This Device And it can Authenticate");
                this.createBiometricsListener();
                this.createPromptInfo();
                BiometricPrompt biometricPrompt;
                if ((biometricPrompt = this.biometricPrompt) == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("biometricPrompt");
                    biometricPrompt = null;
                }
                final BiometricPrompt$PromptInfo promptInfo = this.promptInfo;
                if (promptInfo == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("promptInfo");
                }
                else {
                    biometricPrompt$PromptInfo = promptInfo;
                }
                biometricPrompt.authenticate(biometricPrompt$PromptInfo);
                break;
            }
        }
    }
    
    private final void createBiometricsListener() {
        final Executor mainExecutor = ContextCompat.getMainExecutor((Context)this);
        Intrinsics.checkNotNullExpressionValue((Object)mainExecutor, "getMainExecutor(this)");
        this.executor = mainExecutor;
        final FragmentActivity fragmentActivity = (FragmentActivity)this;
        Executor executor;
        if ((executor = this.executor) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("executor");
            executor = null;
        }
        this.biometricPrompt = new BiometricPrompt(fragmentActivity, executor, (BiometricPrompt$AuthenticationCallback)new FingerprintActivity$createBiometricsListener.FingerprintActivity$createBiometricsListener$1(this));
    }
    
    private final void createPromptInfo() {
        final BiometricPrompt$PromptInfo build = new BiometricPrompt$PromptInfo$Builder().setTitle((CharSequence)"Fingerprint login").setSubtitle((CharSequence)"Login using your fingerprint").setNegativeButtonText((CharSequence)"CANCEL BIOMETRICS").build();
        Intrinsics.checkNotNullExpressionValue((Object)build, "Builder()\n            .s\u2026CS\")\n            .build()");
        this.promptInfo = build;
    }
    
    private static final void onCreate$lambda$0(final FingerprintActivity fingerprintActivity, final View view) {
        Intrinsics.checkNotNullParameter((Object)fingerprintActivity, "this$0");
        fingerprintActivity.cheCkDeviceHasBiometric();
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final ActivityFingerprintBinding inflate = ActivityFingerprintBinding.inflate(this.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue((Object)inflate, "inflate(layoutInflater)");
        this.binding = inflate;
        final ActivityFingerprintBinding activityFingerprintBinding = null;
        ActivityFingerprintBinding activityFingerprintBinding2 = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityFingerprintBinding2 = null;
        }
        this.setContentView((View)activityFingerprintBinding2.getRoot());
        ActivityFingerprintBinding binding = this.binding;
        if (binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            binding = activityFingerprintBinding;
        }
        binding.fingerprintImage.setOnClickListener((View$OnClickListener)new FingerprintActivity$$ExternalSyntheticLambda0(this));
    }
}
