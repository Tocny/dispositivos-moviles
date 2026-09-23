package com.example.tarea2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Contiene las dos pantallas de la Tarea 2 (correspondientes a un pedido y confirmacion),
 * solo una está activa a la vez: la que NO esté comentada en onCreate().
 * Para ver la otra pantalla hay que invertir los comentarios,
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Pantalla 1: pedido
        //setContentView(R.layout.pedido);
        //setupPedido();

        // Pantalla 2: confirmacion
         setContentView(R.layout.confirmacion);
         setupConfirmacion();
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
}
