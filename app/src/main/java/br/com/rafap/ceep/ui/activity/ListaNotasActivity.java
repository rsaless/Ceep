package br.com.rafap.ceep.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;
import java.util.Random;

import br.com.rafap.ceep.R;
import br.com.rafap.ceep.dao.NotaDAO;
import br.com.rafap.ceep.model.Nota;
import br.com.rafap.ceep.ui.recyclerview.adapter.ListaNotasAdapter;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);


        List<Nota> todasNotas = notasDeExemplo();

        configuraRecyclerView(todasNotas);

    }

    private List<Nota> notasDeExemplo() {
        NotaDAO dao = new NotaDAO();
        Random gerador = new Random();
        for (int i=1; i<= 100; i++){
            String mensagem = geraMensagem(gerador.nextInt(40));
            dao.insere(new Nota("titulo " + i,mensagem));
        }

        return dao.todos();
    }

    private String geraMensagem(int qtd){
        String mensagem = "";
        for (int i =0;i<qtd;i++) mensagem += "a";
        return mensagem;
    }

    private void configuraRecyclerView(List<Nota> todasNotas) {
        RecyclerView listaNotas = findViewById(R.id.lista_notas_recyclerview);
        listaNotas.setAdapter(new ListaNotasAdapter(this, todasNotas));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        listaNotas.setLayoutManager(layoutManager);
    }
}
