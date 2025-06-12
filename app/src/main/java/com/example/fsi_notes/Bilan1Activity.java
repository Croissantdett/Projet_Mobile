package com.example.fsi_notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Bilan1Activity extends AppCompatActivity {

    private TextView datevisit;
    private TextView notedossier;
    private TextView noteoral;
    private TextView noteentreprise;
    private TextView moyenne;
    private TextView remarque;
    private Button btnBilan2;

    private DrawerLayout drawerLayout;
    private ImageView ivMenu;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bilan1);
        initialisation();
    }

    public void initialisation() {

        datevisit = findViewById(R.id.datevisit);
        notedossier = findViewById(R.id.notedossier);
        noteoral = findViewById(R.id.noteoral);
        noteentreprise = findViewById(R.id.noteentreprise);
        moyenne = findViewById(R.id.moyenne);
        remarque = findViewById(R.id.remarque);
        btnBilan2 = findViewById(R.id.btnBilan2);

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
                Toast.makeText(Bilan1Activity.this, "Vous êtes déjà sur la page des bilans", Toast.LENGTH_SHORT).show();
            } else if (itemId == R.id.nav_info) {
                Intent infoIntent = new Intent(Bilan1Activity.this, InformationActivity.class);
                startActivity(infoIntent);
            } else if (itemId == R.id.nav_logout) {

                Toast.makeText(Bilan1Activity.this, "Déconnexion...", Toast.LENGTH_SHORT).show();
                Intent loginIntent = new Intent(Bilan1Activity.this, MainActivity.class);
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
     * Ajoute une vérification pour afficher un toast si le bilan 1 est en retard.
     */
    private void loadUserData() {
        DataSource dataSource = new DataSource(Bilan1Activity.this);
        dataSource.open();

        Utilisateur utilisateur = dataSource.getsoloUtilisateur();
        if (utilisateur != null) {
            // Vérification du retard sur le bilan 1
            String bilanDate = utilisateur.getDatVisBil1();  // date du bilan en String

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
            try {
                Date limite = sdf.parse("31/01/2025");
                Date maintenant = new Date();

                boolean bilanVide = (bilanDate == null || bilanDate.trim().isEmpty());

                if (bilanVide && maintenant.after(limite)) {
                    Toast.makeText(this, "Le bilan est en retard", Toast.LENGTH_LONG).show();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            // Ensuite on remplit les champs
            datevisit.setText(bilanDate);
            notedossier.setText(String.valueOf(utilisateur.getNotDosBil1()));
            noteoral.setText(String.valueOf(utilisateur.getNotOrBil1()));
            noteentreprise.setText(String.valueOf(utilisateur.getNotEntBil1()));
            moyenne.setText(String.valueOf(utilisateur.getMoyBil1()));
            remarque.setText(utilisateur.getRemBil1());

            btnBilan2.setOnClickListener(v -> {
                Intent intent = new Intent(Bilan1Activity.this, Bilan2Activity.class);
                startActivity(intent);
            });
        } else {

            Toast.makeText(this, "Erreur: utilisateur non trouvé", Toast.LENGTH_LONG).show();
        }

        dataSource.close();
    }
}
