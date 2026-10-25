package com.example.tarea3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Contiene las pantallas de la Tarea 2 (pedido y confirmacion) y la nueva
 * pantalla de la Tarea 3 (menu con un ListView).
 * Solo una está activa a la vez: la que NO esté comentada en onCreate().
 * Para ver otra pantalla hay que invertir los comentarios,
 * recompilar y volver a ejecutar.
 */
public class MainActivity extends AppCompatActivity {

    // Vistas de la Pantalla 1: pedido.xml
    private EditText txtNombre;
    private RadioGroup rgPlatillo;
    private CheckBox chkPapas;
    private CheckBox chkRefresco;
    private Button btnOrdenar;
    private TextView lblResultado;

    // Vistas de la Pantalla 2: confirmacion.xml
    private CheckBox chkTerminos;
    private Button btnConfirmar;
    private Button btnCancelar;

    // Vistas de la Pantalla 3: menu.xml
    private ListView lvMenu;

    // Datos del menú: el elemento i de cada arreglo corresponde al mismo platillo
    private final String[] nombres = {
            "Hamburguesa", "Pizza", "Ensalada", "Tacos",
            "Hot dog", "Ramen", "Sushi", "Pastel de chocolate"
    };
    private final String[] descripciones = {
            "La magnificarne.",
            "Pepperoni y queso mozzarella",
            "Lechuga, jitomate y aderezo César",
            "Orden de 5 tacos al pastor",
            "Salchicha, jitomate y mostaza",
            "Caldo con cerdo y huevo",
            "California Roll de 10 piezas",
            "Rebanada con crema de chocolate"
    };
    private final int[] precios = {95, 120, 80, 70, 55, 130, 140, 60};
    private final int[] imagenes = {
            R.drawable.hamburguesa, R.drawable.pizza, R.drawable.ensalada, R.drawable.tacos,
            R.drawable.hot_dog, R.drawable.ramen, R.drawable.sushi, R.drawable.pastel
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Pantalla 1: pedido
        //setContentView(R.layout.pedido);
        //setupPedido();

        // Pantalla 2: confirmacion
        //setContentView(R.layout.confirmacion);
        //setupConfirmacion();

        // Pantalla 3: menu (ListView)
        setContentView(R.layout.menu);
        setupMenu();
    }

    /**
     * Vincula las vistas del pedido con sus variables y el evento
     * onClick de btnOrdenar.
     * Solo es un texto resumen que sale en la misma pantalla del pedido.
     */
    private void setupPedido() {
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        rgPlatillo = (RadioGroup) findViewById(R.id.rgPlatillo);
        chkPapas = (CheckBox) findViewById(R.id.chkPapas);
        chkRefresco = (CheckBox) findViewById(R.id.chkRefresco);
        btnOrdenar = (Button) findViewById(R.id.btnOrdenar);
        lblResultado = (TextView) findViewById(R.id.lblResultado);

        btnOrdenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. Leer el nombre capturado en el EditText
                String nombre = txtNombre.getText().toString();

                // 2. Determinar cuál alimento está seleccionado
                String platillo = "";
                int idSeleccionado = rgPlatillo.getCheckedRadioButtonId();
                if (idSeleccionado == R.id.rbHamburguesa) {
                    platillo = "Hamburguesa";
                } else if (idSeleccionado == R.id.rbPizza) {
                    platillo = "Pizza";
                } else if (idSeleccionado == R.id.rbEnsalada) {
                    platillo = "Ensalada";
                }

                // 3. Revisar los CheckBox
                String extras = "";
                if (chkPapas.isChecked()) {
                    extras += "Papas fritas, ";
                }
                if (chkRefresco.isChecked()) {
                    extras += "Refresco, ";
                }
                if (extras.endsWith(", ")) {
                    extras = extras.substring(0, extras.length() - 2);
                }

                // 4. mostrar el resumen del pedido
                String resumen = "Pedido de " + nombre + ": " + platillo;
                if (!extras.isEmpty()) {
                    resumen += " + " + extras;
                }
                lblResultado.setText(resumen);
            }
        });
    }

    /**
     * Conecta las vistas de confirmacion.xml con sus variables y define los
     * eventos de btnConfirmar y btnCancelar.
     */
    private void setupConfirmacion() {
        chkTerminos = (CheckBox) findViewById(R.id.chkTerminos);
        btnConfirmar = (Button) findViewById(R.id.btnConfirmar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Solo confirma si el usuario aceptó los términos
                if (chkTerminos.isChecked()) {
                    Toast.makeText(MainActivity.this, "¡Pedido confirmado!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Debes aceptar los términos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Pedido cancelado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Llena el ListView de menu.xml con los platillos y define el evento
     * setOnItemClickListener al elegir uno de ellos.
     */
    private void setupMenu() {
        lvMenu = (ListView) findViewById(R.id.lvMenu);

        // 1. Armar una fila (HashMap) por cada platillo
        ArrayList<HashMap<String, String>> platillos = new ArrayList<>();
        for (int i = 0; i < nombres.length; i++) {
            HashMap<String, String> fila = new HashMap<>();
            fila.put("imagen", String.valueOf(imagenes[i]));
            fila.put("nombre", nombres[i]);
            fila.put("descripcion", descripciones[i]);
            fila.put("precio", "$" + precios[i]);
            platillos.add(fila);
        }

        // 2. El adaptador pasa cada clave del HashMap a su vista en item_platillo.xml
        //    (el id del drawable en "imagen" lo asigna al ImageView)
        SimpleAdapter adaptador = new SimpleAdapter(
                this,
                platillos,
                R.layout.item_platillo,
                new String[]{"imagen", "nombre", "descripcion", "precio"},
                new int[]{R.id.imgPlatillo, R.id.lblNombrePlatillo, R.id.lblDescripcion, R.id.lblPrecio});
        lvMenu.setAdapter(adaptador);

        // 3. Evento al tocar un platillo de la lista
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mensaje = "Elegiste: " + nombres[position] + " — $" + precios[position];
                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
