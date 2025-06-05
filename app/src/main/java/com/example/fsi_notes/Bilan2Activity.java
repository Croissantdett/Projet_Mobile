package com.example.fsi_notes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Bilan2Activity extends AppCompatActivity {

    private TextView datevisit2;
    private TextView notedossier2;
    private TextView noteoral2;
    private TextView moyenne2;
    private TextView remarque2;
    private Button btnBilan1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bilan1);
        initialisation();
    }

    public void initialisation() {
        datevisit2 = findViewById(R.id.datevisit2);
        notedossier2 = findViewById(R.id.notedossier2);
        noteoral2 = findViewById(R.id.noteoral2);
        moyenne2 = findViewById(R.id.moyenne2);
        remarque2 = findViewById(R.id.remarque2);
        btnBilan1 = findViewById(R.id.btnBilan1);

        DataSource dataSource = new DataSource(Bilan2Activity.this);
        dataSource.open();

        Utilisateur utilisateur = dataSource.getsoloUtilisateur();
        if (utilisateur != null) {
            datevisit2.setText(utilisateur.getDatVisBil1());
            notedossier2.setText(String.valueOf(utilisateur.getNotDosBil1()));
            noteoral2.setText(String.valueOf(utilisateur.getNotOrBil1()));
            moyenne2.setText(String.valueOf(utilisateur.getMoyBil1()));
            remarque2.setText(utilisateur.getRemBil1());
            btnBilan1.setOnClickListener(v -> {
                Intent intent = new Intent(Bilan2Activity.this, Bilan1Activity.class);
                startActivity(intent);
            });
        }
    }
}
