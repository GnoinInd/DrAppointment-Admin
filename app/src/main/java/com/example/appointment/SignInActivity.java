package com.example.appointment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appointment.databinding.ActivitySignInBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Objects;

public class SignInActivity extends AppCompatActivity {
    private ActivitySignInBinding binding;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;


    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser() != null && getIntent().getIntExtra("intent",0) != 1 ){
            startActivity(new Intent(SignInActivity.this, MainActivity.class));
            finish();
        }
        if(FirebaseAuth.getInstance().getCurrentUser() != null && getIntent().getIntExtra("intent",0) == 1 ){
            startActivity(new Intent(SignInActivity.this, PatientDetailsActivity.class));
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(getIntent().getIntExtra("intent", 0) == 1)
            binding.enterAsGuest.setVisibility(View.GONE);


        binding.enterAsGuest.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));


        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);


        binding.googleLogin.setOnClickListener(v -> {
            Intent googleSignInintent = gsc.getSignInIntent();
            signInLauncher.launch(googleSignInintent);
        });

    }
    ActivityResultLauncher<Intent> signInLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if(result.getResultCode() == Activity.RESULT_OK){
            Intent data = result.getData();

            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                GoogleSignInAccount signInAccount = task.getResult(ApiException.class);
                AuthCredential authCredential = GoogleAuthProvider.getCredential(signInAccount.getIdToken(), null);
                FirebaseAuth.getInstance().signInWithCredential(authCredential)
                                .addOnCompleteListener(task1 -> {
                                    if(task1.isSuccessful()){
                                        if(getIntent().getIntExtra("intent", 0) == 1){
                                            startActivity(new Intent(SignInActivity.this, PatientDetailsActivity.class));
                                        }
                                        else startActivity(new Intent(SignInActivity.this, MainActivity.class));
                                        finish();
                                        Toast.makeText(SignInActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    }
                                    else Toast.makeText(SignInActivity.this, Objects.requireNonNull(task1.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                                });


            } catch (ApiException e) {
                Toast.makeText(SignInActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    });
}