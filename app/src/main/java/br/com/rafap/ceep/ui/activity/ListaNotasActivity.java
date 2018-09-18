package br.com.rafap.ceep.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import br.com.rafap.ceep.R;
import br.com.rafap.ceep.dao.NotaDAO;
import br.com.rafap.ceep.model.Nota;
import br.com.rafap.ceep.ui.adapter.ListaNotasAdapter;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        ListView listaNotas = findViewById(R.id.listView);
        NotaDAO dao = new NotaDAO();
        for (int i=1; i<= 10000; i++){
            dao.insere(new Nota("titulo " + i,"descrição " + i));
        }

        List<Nota> todasNotas = dao.todos();
        listaNotas.setAdapter(new ListaNotasAdapter(this, todasNotas));
    }
}
