package com.example.ohara.potiguargenetics;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ohara.potiguargenetics.Dialog.DateDialog;
import com.example.ohara.potiguargenetics.Entity.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    private String name;
    private String origin_city;
    private String birth;
    private String genre;
    private String school_degree;
    private String cell_phone;
    private String street;
    private String cep;
    private int    house_number;
    private String neighborhood;
    private String city;
    private String email;
    private String psw;
    private String confirm_psw;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
    }

    public void onClick (View view) {
        switch (view.getId()) {
            case R.id.btn_cancel:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_confirm:
                registerUser();
                break;
        }
    }

    public void openDatePicker (View view) {
        DateDialog dateDialog = new DateDialog();
        dateDialog.show(getFragmentManager(), "datePicker");
    }

    public void registerUser () {
        name          = ((EditText) findViewById(R.id.name_text)).getText().toString();
        origin_city   = ((EditText) findViewById(R.id.origin_city_text)).getText().toString();
        birth         = ((TextView) findViewById(R.id.birth_text_view)).getText().toString();
        school_degree = ((EditText) findViewById(R.id.school_degree_text)).getText().toString();
        cell_phone    = ((EditText) findViewById(R.id.cellphone_number)).getText().toString();
        street        = ((EditText) findViewById(R.id.street_text)).getText().toString();
        cep           = ((EditText) findViewById(R.id.cep_number)).getText().toString();
        house_number  = Integer.parseInt(((EditText) findViewById(R.id.house_number)).getText().toString());
        neighborhood  = ((EditText) findViewById(R.id.neighborhood_text)).getText().toString();
        city          = ((EditText) findViewById(R.id.city_text)).getText().toString();
        email         = ((EditText) findViewById(R.id.email_text)).getText().toString();
        psw           = ((EditText) findViewById(R.id.psw_text)).getText().toString();
        confirm_psw   = ((EditText) findViewById(R.id.confirm_psw_text)).getText().toString();

        RadioButton radio_btn_F = (RadioButton) findViewById( R.id.radio_btn_F);
        genre = (radio_btn_F.isChecked()) ? "F" : "M";

        if (!psw.equals(confirm_psw)) {
            Toast.makeText(this, "As senhas não conferem", Toast.LENGTH_SHORT).show();
            return ;
        }

        if (!TextUtils.isEmpty(email)) {
            FirebaseDatabase db = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = db.getReference("users");


            String id = databaseReference.push().getKey();
            User user = new User(id, name, origin_city, birth, genre, school_degree, cell_phone, street, cep, house_number, neighborhood, city, email, psw);

            //TODO validation

            databaseReference.child(id).setValue(user);


            mAuth.createUserWithEmailAndPassword(email, psw)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser currentUser = mAuth.getCurrentUser();
                                if (currentUser != null) {
                                    Toast.makeText(RegisterActivity.this, "Usuário autentticado com sucesso", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                }
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(RegisterActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        } else {
            Toast.makeText(this, "Por favor, insira todos os dadods", Toast.LENGTH_SHORT).show();
        }
    }
}
