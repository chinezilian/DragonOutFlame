package com.example.tj.dragonoutflame;


import android.app.Activity;
import android.app.Fragment;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;


public class MainActivity extends Activity {

    /* Definição dos objetos que serão usados na Activity Principal
        statusMessage mostrará mensagens de status sobre a conexão
        counterMessage mostrará o valor do contador como recebido do Arduino
        connect é a thread de gerenciamento da conexão Bluetooth
     */
    static TextView statusMessage;
    static TextView Value1;
    static TextView Value2;
    static TextView Value3;

    ConnectionThread connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Link entre os elementos da interface gráfica e suas
            representações em Java.
*/
        statusMessage = (TextView) findViewById(R.id.statusMessage);
        Value1 = (TextView) findViewById(R.id.Value1);
        Value2 = (TextView) findViewById(R.id.Value2);
        Value3 = (TextView) findViewById(R.id.Value3);

         /*Teste rápido.
         */

        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        if (btAdapter == null) {
            statusMessage.setText("Que pena! Hardware Bluetooth não está funcionando :(");
        } else {
            statusMessage.setText("Ótimo! Hardware Bluetooth está funcionando :)");
        }

        /* A chamada do seguinte método liga o Bluetooth no dispositivo Android
            sem pedido de autorização do usuário. É altamente não recomendado no
            Android Developers, mas, para simplificar este app, que é um demo,
            faremos isso. Na prática, em um app que vai ser usado por outras
            pessoas, não faça isso.
         */
        btAdapter.enable();

        /* Definição da thread de conexão como cliente.
            Aqui, você deve incluir o endereço MAC do seu módulo Bluetooth.
            O app iniciará e vai automaticamente buscar por esse endereço.
            Caso não encontre, dirá que houve um erro de conexão.
         */
        connect = new ConnectionThread("98:D3:31:F4:22:86");
        connect.start();

        /* Um descanso rápido, para evitar bugs esquisitos.
         */
        try {
            Thread.sleep(1000);
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            /* Esse método é invocado na Activity principal
                sempre que a thread de conexão Bluetooth recebe
                uma mensagem.
             */
            Bundle bundle = msg.getData();
            byte[] data = bundle.getByteArray("data");
            String dataString = new String(data);

            /* Aqui ocorre a decisão de ação, baseada na string
                recebida. Caso a string corresponda à uma das
                mensagens de status de conexão (iniciadas com --),
                atualizamos o status da conexão conforme o código.
             */
            if(dataString.equals("---N"))
                statusMessage.setText("Ocorreu um erro durante a conexão D:");
            else if(dataString.equals("---S"))
                statusMessage.setText("Conectado :D");
            else {

                /* Se a mensagem não for um código de status,
                    então ela deve ser tratada pelo aplicativo
                    como uma mensagem vinda diretamente do outro
                    lado da conexão.
                */
                check(dataString);

            }

        }
    };

   /* public void startSecondActivity(View view) {

        Intent secondActivity = new Intent(this, MainActivityB.class);
        secondActivity.putExtra("my_String", string1);
        startActivity(secondActivity);
    }
    */
/* Esse método é invocado sempre que o usuário clicar na TextView
        que contem o contador. O app Android transmite a string "restart",
        seguido de uma quebra de linha, que é o indicador de fim de mensagem.
        static double[] elem = new double[12];
*/static double elem1,elem2,elem3,elem4,elem5,elem6,elem7,elem8,elem9,elem10,elem11,elem12,elem13,elem14,elem15;
   public static void check(String data) {
       int startIndex,endIndex;
       startIndex=0;
       endIndex=data.indexOf(";");
       if (endIndex<0) return;
       // extrai o primeiro elemento
       elem1 = Double.parseDouble(data.substring(startIndex, endIndex));
       System.out.println(elem1);
       // extrai o segundo elemento
       startIndex = endIndex + 1;
       endIndex = data.indexOf(";", startIndex);
       elem2 = Double.parseDouble(data.substring(startIndex, endIndex));
       System.out.println(elem2);
       // extrai o terceiro elemento
       startIndex = endIndex + 1;
       endIndex = data.indexOf(";", startIndex);
       elem3 = Double.parseDouble(data.substring(startIndex, endIndex));
       System.out.println(elem3);
       // extrai o quarto elemento
       startIndex = endIndex + 1;
       endIndex = data.indexOf(";", startIndex);
       elem4 = Double.parseDouble(data.substring(startIndex, endIndex));
       System.out.println(elem4);
       // extrai o quinto e último elemento
       startIndex = endIndex + 1;
       endIndex = data.indexOf(";", startIndex);
       elem5 = Double.parseDouble(data.substring(startIndex, endIndex));
       System.out.println(elem5);;
       // extrai o quinto e último elemento
       startIndex = endIndex + 1;
       endIndex = data.indexOf(";", startIndex);
       elem6 = Double.parseDouble(data.substring(startIndex, endIndex));
       System.out.println(elem6);
       // extrai o terceiro elemento
       startIndex = endIndex + 1;
       endIndex = data.indexOf(";", startIndex);
       elem7 = Double.parseDouble(data.substring(startIndex, endIndex));
       System.out.println(elem7);
       // extrai o terceiro elemento
       startIndex = endIndex + 1;
       endIndex = data.indexOf(";", startIndex);
       elem8 = Double.parseDouble(data.substring(startIndex, endIndex));
       System.out.println(elem8);
       // extrai o terceiro elemento
       startIndex = endIndex + 1;
       endIndex = data.indexOf(";", startIndex);
       elem9 = Double.parseDouble(data.substring(startIndex, endIndex));
       System.out.println(elem9);
       // extrai o terceiro elemento
       startIndex = endIndex + 1;
       endIndex = data.indexOf(";", startIndex);
       elem10 = Double.parseDouble(data.substring(startIndex, endIndex));
       System.out.println(elem10);
       // extrai o terceiro elemento
       startIndex = endIndex + 1;
       endIndex = data.indexOf(";", startIndex);
       elem11 = Double.parseDouble(data.substring(startIndex, endIndex));
       System.out.println(elem11);
       // extrai o terceiro elemento
      /* startIndex = endIndex + 1;
       endIndex = data.indexOf(";", startIndex);
       elem12 = Double.parseDouble(data.substring(startIndex, endIndex));
       System.out.println(elem12);
       // extrai o terceiro elemento
       startIndex = endIndex + 1;
       endIndex = data.indexOf(";", startIndex);
       elem13 = Double.parseDouble(data.substring(startIndex, endIndex));
       System.out.println(elem13);
       // extrai o terceiro elemento
       startIndex = endIndex + 1;
       endIndex = data.indexOf(";", startIndex);
       elem14 = Double.parseDouble(data.substring(startIndex, endIndex));
       System.out.println(elem14);*/
       // extrai o quinto e último elemento
       startIndex=endIndex+1;
       elem12=Double.parseDouble(data.substring(startIndex));
       System.out.println(elem12);

       seting();

   }
    public static void seting(){

        Value1.setText(""+elem7);
        Value2.setText(""+elem8);
        Value3.setText(""+elem9);
    }


    public void restartCounter(View view) {

        connect.write("restart\n".getBytes());
    }


    public void startSecondActivity(View view) {

        Intent secondActivity = new Intent(this, secondActivity.class);
        startActivity(secondActivity);
    }

}