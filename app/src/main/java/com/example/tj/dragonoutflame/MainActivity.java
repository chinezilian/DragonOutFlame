package com.example.tj.dragonoutflame;


import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class MainActivity extends Activity {

    /* Definição dos objetos que serão usados na Activity Principal
        statusMessage mostrará mensagens de status sobre a conexão
        counterMessage mostrará o valor do contador como recebido do Arduino
        connect é a thread de gerenciamento da conexão Bluetooth
     */
    static TextView statusMessage;
    static TextView dados;
    static TextView Value2;
    static TextView Value3;
    static TextView Value4;
    static TextView Value5;
    ConnectionThread connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Link entre os elementos da interface gráfica e suas
            representações em Java.
         */
        statusMessage = (TextView) findViewById(R.id.statusMessage);
        dados = (TextView) findViewById(R.id.dados);
        Value2 = (TextView) findViewById(R.id.Value2);
        Value3 = (TextView) findViewById(R.id.Value3);
        Value4 = (TextView) findViewById(R.id.Value4);
        Value5 = (TextView) findViewById(R.id.Value5);

        /* Teste rápido. O hardware Bluetooth do dispositivo Android
            está funcionando ou está bugado de forma misteriosa?
            Será que existe, pelo menos? Provavelmente existe.
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


    // String string1;
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
*/
   public static void check(String data) {
       int startIndex,endIndex;
       startIndex=0;
       endIndex=data.indexOf(";");
       if (endIndex<0) return;
      /* String[] date=data.split("$");
       if (date[0]!= "acc") return;
       if (date[2]!= "gps") return;
       data=date[1];*/
       String[] date1=data.split(";");
       int total = 0; // Numero de posições preenchidas
       for(int i=0;i<=date1.length-1;i++){
           if(date1[i] != null)total++;
            }
       System.out.println(total);
            // extrai o primeiro elemento
           double elem1 = Double.parseDouble(data.substring(startIndex, endIndex));
           System.out.println(elem1);
           // extrai o segundo elemento
           startIndex = endIndex + 1;
           endIndex = data.indexOf(";", startIndex);
           double elem2 = Double.parseDouble(data.substring(startIndex, endIndex));
           System.out.println(elem2);
           // extrai o terceiro elemento
           startIndex = endIndex + 1;
           endIndex = data.indexOf(";", startIndex);
           double elem3 = Double.parseDouble(data.substring(startIndex, endIndex));
           System.out.println(elem3);
           // extrai o quarto elemento
           startIndex = endIndex + 1;
           endIndex = data.indexOf(";", startIndex);
           double elem4 = Double.parseDouble(data.substring(startIndex, endIndex));
           System.out.println(elem4);
           // extrai o quinto e último elemento
       startIndex = endIndex + 1;
       endIndex = data.indexOf(";", startIndex);
       double elem5 = Double.parseDouble(data.substring(startIndex, endIndex));
       System.out.println(elem5);;
       // extrai o quinto e último elemento
       startIndex = endIndex + 1;
       endIndex = data.indexOf(";", startIndex);
       double elem6 = Double.parseDouble(data.substring(startIndex, endIndex));
       System.out.println(elem6);
       // extrai o terceiro elemento
       startIndex = endIndex + 1;
       endIndex = data.indexOf(";", startIndex);
       double elem7 = Double.parseDouble(data.substring(startIndex, endIndex));
       System.out.println(elem7);
       // extrai o quinto e último elemento
       startIndex=endIndex+1;
       double elem8=Double.parseDouble(data.substring(startIndex));
       System.out.println(elem8);

       dados.setText(""+elem1);
       Value2.setText(""+elem2);
       Value3.setText(""+elem3);
       Value4.setText(""+elem7);
      Value5.setText(""+elem8);

   }


    public void restartCounter(View view) {

        connect.write("restart\n".getBytes());
    }

}