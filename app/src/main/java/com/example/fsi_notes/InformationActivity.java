package com.example.fsi_notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

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
    private TextView adrEnt;
    private TextView vilEnt;
    private TextView cpEnt;
    private TextView nomTut;
    private TextView preTut;
    private TextView telTut;
    private TextView mailTut;

    private DrawerLayout drawerLayout;
    private ImageView ivMenu;
    private NavigationView navigationView;


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
        adrEnt = findViewById(R.id.adrEnt);
        vilEnt = findViewById(R.id.vilEnt);
        cpEnt = findViewById(R.id.cpEnt);
        nomTut = findViewById(R.id.nomTut);
        preTut = findViewById(R.id.preTut);
        telTut = findViewById(R.id.telTut);
        mailTut = findViewById(R.id.mailTut);


        drawerLayout = findViewById(R.id.drawer_layout);
        ivMenu = findViewById(R.id.ivMenu);
        navigationView = findViewById(R.id.nav_view);


        setupDrawer();
        loadUserData();

    }

    /**
     * Configure les écouteurs d'événements pour le menu tiroir.
     */
    private void setupDrawer() {
        ivMenu.setOnClickListener(v -> {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_info) {
                Toast.makeText(InformationActivity.this, "Vous êtes déjà sur la page des informations", Toast.LENGTH_SHORT).show();
            } else if (itemId == R.id.nav_bilans) {
                Intent infoIntent = new Intent(InformationActivity.this, Bilan1Activity.class);
                startActivity(infoIntent);
            } else if (itemId == R.id.nav_logout) {

                Toast.makeText(InformationActivity.this, "Déconnexion...", Toast.LENGTH_SHORT).show();
                Intent loginIntent = new Intent(InformationActivity.this, MainActivity.class);
                loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(loginIntent);
                finish();
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
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
            preUti.setText(String.valueOf(utilisateur.getPreUti()));
            telUti.setText(String.valueOf(utilisateur.getTelUti()));
            mailUti.setText(String.valueOf(utilisateur.getMailUti()));
            nomMaitapp.setText(String.valueOf(utilisateur.getNomMaitapp()));
            preMaitapp.setText(utilisateur.getPreMaitapp());
            telMaitapp.setText(String.valueOf(utilisateur.getTelMaitapp()));
            mailMaitapp.setText(String.valueOf(utilisateur.getMailMaitapp()));
            nomEnt.setText(String.valueOf(utilisateur.getNomEnt()));
            adrEnt.setText(String.valueOf(utilisateur.getAdrEnt()));
            vilEnt.setText(String.valueOf(utilisateur.getVilEnt()));
            cpEnt.setText(String.valueOf(utilisateur.getCpEnt()));
            nomTut.setText(String.valueOf(utilisateur.getNomTut()));
            preTut.setText(String.valueOf(utilisateur.getPreTut()));
            telTut.setText(String.valueOf(utilisateur.getTelTut()));
            mailTut.setText(String.valueOf(utilisateur.getMailTut()));
        } else {

            Toast.makeText(this, "Erreur: utilisateur non trouvé", Toast.LENGTH_LONG).show();
        }

        dataSource.close();


    }

}
