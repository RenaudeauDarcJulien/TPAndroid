package com.example.jr.jr_navactivity_08_03_17;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Button buttonValideAccount;
    EditText username;
    EditText password;
    EditText mail;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        buttonValideAccount = (Button)findViewById(R.id.button_valideAccount);
        username = (EditText)findViewById(R.id.editText_username);
        password = (EditText)findViewById(R.id.editText_password);
        mail = (EditText)findViewById(R.id.editText_mail);

        sharedPreferences = getApplicationContext().getSharedPreferences("RegisterActivity", 0);
        editor = sharedPreferences.edit();

        buttonValideAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick (View v) {
                //Récupération des valeurs entrées
                String name = username.getText().toString();
                String email = mail.getText().toString();
                String pass = password.getText().toString();

                //Vérification que les champs soit remplis
                if(username.getText().length()<=0){
                    Toast.makeText(RegisterActivity.this, "Enter name", Toast.LENGTH_SHORT).show();
                }
                else if( mail.getText().length()<=0){
                    Toast.makeText(RegisterActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
                }
                else if( password.getText().length()<=0){
                    Toast.makeText(RegisterActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                }
                else{

                    //Valeurs enregistré dans l'editor
                    editor.putString("Name", name);
                    editor.putString("Email",email);
                    editor.putString("Password",pass);
                    editor.commit();// Envoi des valeurs

                    //Envoi du Resultat
                    Intent intent = new Intent();
                    setResult(0, intent);
                    //Fermerture de l'activité
                    finish();
                }
            }
        });
    }
}

