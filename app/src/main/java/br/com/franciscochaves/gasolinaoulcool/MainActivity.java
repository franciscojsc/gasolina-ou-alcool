package br.com.franciscochaves.gasolinaoulcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button botaoVerificar;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = findViewById(R.id.edit_alcool);
        precoGasolina = findViewById(R.id.edit_gasolina);
        botaoVerificar = findViewById(R.id.button_verificar);
        textoResultado = findViewById(R.id.text_resultado);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String textoPrecoAlcool = precoAlcool.getText().toString();
                String textoPrecoGasolina = precoGasolina.getText().toString();

                Double valorAlcool = null;
                Double valorGasolina = null;

                try {

                    if (!textoPrecoAlcool.trim().isEmpty()) {
                        valorAlcool = Double.parseDouble(textoPrecoAlcool);

                        if(valorAlcool < 0){

                            throw new Exception("campo preço do álcool deve ser igual ou maior que zero");
                        }
                    }else{

                        throw new Exception("campo preço do álcool, digite o valor");

                    }

                    if (!textoPrecoGasolina.trim().isEmpty()) {
                        valorGasolina = Double.parseDouble(textoPrecoGasolina);

                        if(valorGasolina <= 0){

                            throw new Exception("campo preço da gasolina deve ser maior que zero");
                        }
                    }else{

                        throw new Exception("campo do preço do gasolina, digite o valor");

                    }

                    //Cálculo  = alcool / gasolina
                    double resultado = valorAlcool / valorGasolina;

                    if (resultado >= 0.7) {

                        textoResultado.setText("É melhor utilizar Gasolina");

                    } else {

                        textoResultado.setText("É melhor utilizar Álcool");

                    }

                } catch (Exception e) {

                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
