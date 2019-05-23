package app.palindromo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnVerificar = findViewById(R.id.btnVerificar);
        final EditText txtPalabra = findViewById(R.id.txtPalabra);
        final TextView txtPolindromo = findViewById(R.id.txtPolindromo);
        final TextView txtInversa = findViewById(R.id.txtInversa);
        final TextView txtLongitud = findViewById(R.id.txtLongitud);
        final TextView txtLetra = findViewById(R.id.txtLetra);

        btnVerificar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String palabra =  txtPalabra.getText().toString();
                String palabra2 = "";
                String inversa = "";
                int longitud;
                int mayorRepeticion= 0;
                char [] letras;
                char letraMasRepetida = 0;


                for (int i=palabra.length()-1; i >= 0; i--) {
                    palabra2 = palabra2 + palabra.charAt(i);
                }
                if(palabra.equals(palabra2)){
                    txtPolindromo.setText("Es un palindromo");
                }else{
                    txtPolindromo.setText("No es un palindromo");
                }


                longitud = palabra.length();
                txtInversa.setText(""+longitud);


                for(int x = palabra.length()-1; x >= 0; x--){
                    inversa += palabra.charAt(x);
                }
                txtLongitud.setText(""+inversa);


                letras = palabra.toCharArray();
                for(int i =0; i<letras.length; i++){
                    char letraActual = letras[i];
                    int contador = 0;

                    for (int j=0; j<letras.length; j++){
                        if (letras[j] == letraActual)
                            contador++;

                    }
                    if (mayorRepeticion < contador){
                        mayorRepeticion = contador;
                        letraMasRepetida = letraActual;
                    }
                }
                txtLetra.setText(""+letraMasRepetida);

            }
        });

    }


}
