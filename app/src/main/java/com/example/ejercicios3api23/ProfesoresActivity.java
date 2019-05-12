package com.example.ejercicios3api23;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProfesoresActivity extends AppCompatActivity {
    EditText etNombre,etApellido;
    ListView lvProfesores;
    ArrayList profesores;
    Button btnGrabar;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesores);

        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        btnGrabar = findViewById(R.id.btnGrabar);
        lvProfesores = findViewById(R.id.lvProfesores);
        profesores=new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,profesores);

        lvProfesores.setAdapter(adapter);
        registerForContextMenu(lvProfesores);
        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profesores.add(etNombre.getText().toString()+" "+etApellido.getText().toString());
                lvProfesores.deferNotifyDataSetChanged();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info =(AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle("Profesor:" +profesores.get(info.position));
        inflater.inflate(R.menu.menu_contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.menu_eliminar:
                profesores.remove(info.position);
                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return  true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_add_item:
                Toast.makeText(ProfesoresActivity.this, "Agregar Item", Toast.LENGTH_LONG).show();
                profesores.add("Profesor X");
                adapter.notifyDataSetChanged();
                return true;

            case R.id.menu_refrescar:
                adapter.notifyDataSetChanged();
                Toast.makeText(ProfesoresActivity.this, "Refrescar", Toast.LENGTH_LONG).show();
                return true;

            case R.id.menu_vermapa:
                Toast.makeText(ProfesoresActivity.this, "Ver Mapa", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ProfesoresActivity.this, MapsActivity.class);
                startActivity(intent);
                return true;

            case R.id.menu_cerrar:
                Toast.makeText(ProfesoresActivity.this, "Cerrar Sesión", Toast.LENGTH_LONG).show();
                Intent intento = new Intent(ProfesoresActivity.this, MainActivity.class);
                startActivity(intento);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
