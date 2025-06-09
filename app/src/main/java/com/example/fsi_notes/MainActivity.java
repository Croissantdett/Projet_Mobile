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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response; // Assurez-vous d'avoir le bon import pour Response

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

                if (loginjava.isEmpty() || mdpjava.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                    return;
                }

                RetroFitClientUtilisateur.getInstance()
                        .getMyApi()
                        .demon(loginjava, mdpjava)
                        .enqueue(new Callback<Utilisateur>() {
                            @Override
                            public void onResponse(Call<Utilisateur> call, Response<Utilisateur> response) {

                                if (response.isSuccessful() && response.body() != null) {
                                    Utilisateur utilisateur = response.body();
                                    Log.d("LOGIN_API", "Utilisateur reçu de l'API : " + utilisateur.getNomUti());

                                    DataSource dataSource = new DataSource(MainActivity.this);
                                    dataSource.open();

                                    Log.d("LOGIN_DB", "Suppression des anciens utilisateurs de la base de données locale.");
                                    dataSource.deleteUtilisateur();

                                    Log.d("LOGIN_DB", "Insertion du nouvel utilisateur : " + utilisateur.getNomUti());
                                    dataSource.insertuser(utilisateur);

                                    dataSource.close();

                                    Intent intent = new Intent(MainActivity.this, Bilan1Activity.class);
                                    startActivity(intent);

                                    finish();

                                } else {

                                    Toast.makeText(MainActivity.this, "Login ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Utilisateur> call, Throwable t) {
                                Log.e("LOGIN_API_ERROR", "Erreur réseau : " + t.getMessage());
                                Toast.makeText(MainActivity.this, "Erreur réseau. Veuillez vérifier votre connexion.", Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });
    }
}