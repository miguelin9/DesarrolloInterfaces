package es.vcarmen.chatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.historial)
    TextView hisorial;

    @BindView(R.id.enviar)
    Button enviar;

    @BindView(R.id.entrada)
    EditText entrada;

    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // para que funcione el ButterKnife
        ButterKnife.bind(this);

        conectarFirebase();
    }

    public void conectarFirebase() {
        // copiado del asistente de firebase
        // Write a message to the database
        database = FirebaseDatabase.getInstance(); // instancia la base de datos
        myRef = database.getReference("chat"); // parecido a crear una tabla llamada chat
    }

    // manejador de enventos para el botón con butterknife ("más easy")
    @OnClick(R.id.enviar)
    public void enviarMensaje() {
        // primero sacar lo que el usuario a escrito en el edittext
        String cadena = entrada.getText().toString();
        // vaciamos el edittext
        limpiarEntrada();
        // instanciamos el objeto que hemos creado con el POI Mensaje
        Mensaje msg = new Mensaje(cadena);
        // guardamos en firebase
        guardarMensaje(msg);

    }

    public void limpiarEntrada() {
        entrada.setText("");
    }

    public void guardarMensaje(Mensaje msg) {
        myRef.push().setValue(msg);
    }

}
