package com.example.pedrapapeloutesouraprojeto;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }
    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }
    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }
    public void opcaoSelecionada(String escolhaUsuario){

        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3);// 0 1 2
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaAPP = opcoes[ numero ];

        switch ( escolhaAPP ){
            case "pedra" :
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (escolhaAPP== "tesoura" && escolhaUsuario == "papel") ||
                (escolhaAPP == "papel" && escolhaUsuario == "pedra") ||
                (escolhaAPP == "pedra" && escolhaUsuario == "tesoura")
        ){
            textoResultado.setText("você perdeu:( ");
        }else if (
                (escolhaUsuario== "tesoura" && escolhaAPP == "papel") ||
                (escolhaUsuario == "papel" && escolhaAPP == "pedra") ||
                (escolhaUsuario== "pedra" && escolhaAPP == "tesoura")
        ){
            textoResultado.setText("você ganhou:) ");
        }else {
            textoResultado.setText("você Empatamos:) ");
        }

        System.out.print("item clicado: " + escolhaAPP );

    }
    }
