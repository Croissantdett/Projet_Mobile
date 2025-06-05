package com.example.fsi_notes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private EditText login;
    private EditText mdp;
    private Button btnConnexion;
    private String loginjava;
    private String mdpjava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        initialisation();
    }

    public void initialisation() {

        login = findViewById(R.id.login);
        mdp = findViewById(R.id.mdp);
        btnConnexion = findViewById(R.id.btnConnexion);



        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginjava = login.getText().toString();
                mdpjava = mdp.getText().toString();

                if (!loginjava.isEmpty() && !mdpjava.isEmpty()) {
                    RetroFitClientUtilisateur.getInstance()
                            .getMyApi()
                            .demon(loginjava, mdpjava)
                            .enqueue(new Callback<Utilisateur>() {
                                @Override
                                public void onResponse(Call<Utilisateur> call, retrofit2.Response<Utilisateur> response) {
                                    if (response.isSuccessful() && response.body() != null) {
                                        Utilisateur utilisateur = response.body();
                                            Log.d("utilisateur", utilisateur.toString());
                                            DataSource dataSource = new DataSource(MainActivity.this);
                                            dataSource.open();

                                            dataSource.insertuser(utilisateur);

                                            Intent intent = new Intent(MainActivity.this, Bilan1Activity.class);
                                            startActivity(intent);



                                    } else {
                                        Toast.makeText(MainActivity.this, "Authentification échouée", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<Utilisateur> call, Throwable t) {
                                    Log.e("RetrofitError", "Erreur : " + t.getMessage());
                                    Toast.makeText(MainActivity.this, "Erreur : " + t.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            });



                }

            }
        });


    }
}