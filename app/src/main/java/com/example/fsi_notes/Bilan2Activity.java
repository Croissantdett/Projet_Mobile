package com.example.fsi_notes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Bilan2Activity extends AppCompatActivity {


    private TextView datevisit2;
    private TextView notedossier2;
    private TextView noteoral2;
    private TextView moyenne2;
    private TextView remarque2;
    private Button btnBilan1;


    private DrawerLayout drawerLayout;
    private ImageView ivMenu;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_bilan2);
        initialisation();
    }

    public void initialisation() {

        datevisit2 = findViewById(R.id.datevisit2);
        notedossier2 = findViewById(R.id.notedossier2);
        noteoral2 = findViewById(R.id.noteoral2);
        moyenne2 = findViewById(R.id.moyenne2);
        remarque2 = findViewById(R.id.remarque2);
        btnBilan1 = findViewById(R.id.btnBilan1);

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

            if (itemId == R.id.nav_bilans) {

                Intent bilan1Intent = new Intent(Bilan2Activity.this, Bilan1Activity.class);
                startActivity(bilan1Intent);
                finish();
            } else if (itemId == R.id.nav_info) {
                Intent infoIntent = new Intent(Bilan2Activity.this, InformationActivity.class);
                startActivity(infoIntent);
            } else if (itemId == R.id.nav_logout) {

                Toast.makeText(Bilan2Activity.this, "Déconnexion...", Toast.LENGTH_SHORT).show();
                Intent loginIntent = new Intent(Bilan2Activity.this, MainActivity.class);
                loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(loginIntent);
                finish();
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    /**
     * Charge les données de l'utilisateur et affiche les informations du BILAN 2.
     */
    private void loadUserData() {
        DataSource dataSource = new DataSource(Bilan2Activity.this);
        dataSource.open();

        Utilisateur utilisateur = dataSource.getsoloUtilisateur();
        if (utilisateur != null) {
            datevisit2.setText(utilisateur.getDatVisBil2());
            notedossier2.setText(String.valueOf(utilisateur.getNotDossBil2()));
            noteoral2.setText(String.valueOf(utilisateur.getNotOrBil2()));
            moyenne2.setText(String.valueOf(utilisateur.getMoyBil2()));
            remarque2.setText(utilisateur.getRemBil2());

            btnBilan1.setOnClickListener(v -> {
                Intent intent = new Intent(Bilan2Activity.this, Bilan1Activity.class);
                startActivity(intent);
                finish();
            });

        } else {
            Toast.makeText(this, "Erreur: utilisateur non trouvé", Toast.LENGTH_LONG).show();
        }

        dataSource.close();
    }
}