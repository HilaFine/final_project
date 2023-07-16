package dev.hilaferberfine.mysecretfamilyrecipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

//import dev.hilaferberfine.mysecretfamilyrecipeapp.databinding.ActivityLogInBinding;
import dev.hilaferberfine.mysecretfamilyrecipeapp.databinding.ActivityRegiserPageBinding;
//import dev.hilaferberfine.mysecretfamilyrecipeapp.LogInActivity;

public class RegisterPage extends AppCompatActivity {
    private ActivityRegiserPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegiserPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button2.setOnClickListener(v -> register());
    }
    private void register(){
        String email = Objects.requireNonNull(binding.etEmail.getText()).toString().trim();
        String password = Objects.requireNonNull(binding.etPassword.getText()).toString().trim();
        if(email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter your email and password", Toast.LENGTH_SHORT).show();
        } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Please enter valid email address", Toast.LENGTH_SHORT).show();
        } else {
            createNewUser(email, password);

        }
    }

    private void createNewUser(String email, String password) {
        FirebaseApp.initializeApp(this);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if(task.isSuccessful()){

                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("logedIn", 1);
                startActivity(intent);

                finish();
            } else {
                Toast.makeText(this, "Account create failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
