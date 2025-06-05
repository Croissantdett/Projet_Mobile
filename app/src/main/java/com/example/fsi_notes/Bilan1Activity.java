package com.example.fsi_notes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Bilan1Activity extends AppCompatActivity {

    private TextView datevisit;
    private TextView notedossier;
    private TextView noteoral;
    private TextView noteentreprise;
    private TextView moyenne;
    private TextView remarque;
    private Button btnBilan2;

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


        DataSource dataSource = new DataSource(Bilan1Activity.this);
        dataSource.open();

        Utilisateur utilisateur = dataSource.getsoloUtilisateur();
        if (utilisateur != null) {
            datevisit.setText(utilisateur.getDatVisBil1());
            notedossier.setText(String.valueOf(utilisateur.getNotDosBil1()));
            noteoral.setText(String.valueOf(utilisateur.getNotOrBil1()));
            noteentreprise.setText(String.valueOf(utilisateur.getNotEntBil1()));
            moyenne.setText(String.valueOf(utilisateur.getMoyBil1()));
            remarque.setText(utilisateur.getRemBil1());
            btnBilan2.setOnClickListener(v -> {
                Intent intent = new Intent(Bilan1Activity.this, Bilan2Activity.class);
                startActivity(intent);
            });
        }
    }
}
