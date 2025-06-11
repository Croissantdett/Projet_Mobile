package com.example.fsi_notes;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class InformationActivity extends AppCompatActivity {

    private TextView nomUti;
    private TextView preUti;
    private TextView telUti;
    private TextView mailUti;
    private TextView nomMaitapp;
    private TextView preMaitapp;
    private TextView telMaitapp;
    private TextView mailMaitapp;
    private TextView nomEnt;
    private TextView nomTut;
    private TextView preTut;
    private TextView telTut;
    private TextView mailTut;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_info_user);
        initialisation();
    }

    public void initialisation() {

        nomUti = findViewById(R.id.nomUti);
        preUti = findViewById(R.id.preUti);
        telUti = findViewById(R.id.telUti);
        mailUti = findViewById(R.id.mailUti);
        nomMaitapp = findViewById(R.id.nomMaitapp);
        preMaitapp = findViewById(R.id.preMaitapp);
        telMaitapp = findViewById(R.id.telMaitapp);
        mailMaitapp = findViewById(R.id.mailMaitapp);
        nomEnt = findViewById(R.id.nomEnt);
        nomTut = findViewById(R.id.nomTut);
        preTut = findViewById(R.id.preTut);
        telTut = findViewById(R.id.telTut);
        mailTut = findViewById(R.id.mailTut);


        loadUserData();
    }




    /**
     * Charge les données de l'utilisateur depuis la base de données et les affiche.
     */
    private void loadUserData() {
        DataSource dataSource = new DataSource(InformationActivity.this);
        dataSource.open();

        Utilisateur utilisateur = dataSource.getsoloUtilisateur();
        if (utilisateur != null) {
            nomUti.setText(utilisateur.getNomUti());
            preUti.setText(utilisateur.getPreUti());
            telUti.setText(utilisateur.getTelUti());
            mailUti.setText(utilisateur.getMailUti());
            nomMaitapp.setText(utilisateur.getNomMaitapp());
            preMaitapp.setText(utilisateur.getPreMaitapp());
            telMaitapp.setText(utilisateur.getTelMaitapp());
            mailMaitapp.setText(utilisateur.getMailMaitapp());
            nomEnt.setText(utilisateur.getNomEnt());
            nomTut.setText(utilisateur.getNomTut());
            preTut.setText(utilisateur.getPreTut());
            telTut.setText(utilisateur.getTelTut());
            mailTut.setText(utilisateur.getMailTut());
        } else {
            Toast.makeText(this, "Erreur: utilisateur non trouvé", Toast.LENGTH_LONG).show();
        }

        dataSource.close();
    }
}