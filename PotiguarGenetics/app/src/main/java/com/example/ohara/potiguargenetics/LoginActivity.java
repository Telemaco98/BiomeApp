package com.example.ohara.potiguargenetics;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent (this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void onClick (View view) {
        switch (view.getId()) {
            case R.id.login_button:
                    login();
                break;
            case R.id.register_button:
                    Intent intent = new Intent(this, RegisterActivity.class);
                    startActivity(intent);
                break;
        }
    }

    private void login() {
        String user_email = ((EditText) findViewById(R.id.email_text)).getText().toString();
        String user_psw   = ((EditText) findViewById(R.id.psw_text)).getText().toString();

        mAuth.signInWithEmailAndPassword(user_email, user_psw).
            addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        FirebaseUser currentUser = mAuth.getCurrentUser();

                        if(currentUser != null) {
                            Toast.makeText(getApplication(), "Logged", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplication(), "Falha na Autenticação", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
    }
}
