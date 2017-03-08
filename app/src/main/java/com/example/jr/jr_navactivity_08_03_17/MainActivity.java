package com.example.jr.jr_navactivity_08_03_17;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int RESULT_SELECTION = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button_registration);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                goToNextActivity();
            }
        });
    }
    //Fonction qui redirige vers un autre activité
    public void goToNextActivity()
    {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivityForResult(intent, RESULT_SELECTION);
    }
    // Fonction qui attend le resultat de l'activité Register
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_SELECTION)
        {
            //Récupération des Valeurs stockées
            SharedPreferences settings = getSharedPreferences("RegisterActivity", 0);
            String Name = settings.getString("Name", "name");
            String Pass = settings.getString("Email", "email");
            String Mail = settings.getString("Password", "pass");

            //Affichage des TOASTS
            Toast.makeText(MainActivity.this, "Name:" + Name , Toast.LENGTH_LONG).show();
            Toast.makeText(MainActivity.this, "Password:" +Pass  , Toast.LENGTH_LONG).show();
            Toast.makeText(MainActivity.this, "Email:" +Mail  , Toast.LENGTH_LONG).show();

            //Affichage LOG
            System.out.println("Name:" + Name);
            System.out.println("Password:" +Pass);
            System.out.println("Email:" +Mail);

        }
    }

}
