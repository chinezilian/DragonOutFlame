package com.example.tj.dragonoutflame;

/**
 * Created by TJ on 23/04/2018.
 */

public class DateTreat {

/*    void Calibrate(void){

        unsigned int count1;
        count1 = 0;

        do{
            ADC_GetAllAxis();//Função que atualiza os valores dos eixos X e Y
            sstatex = sstatex + Sample_X; //Acumula as amostras no eixo X
            sstatey = sstatey + Sample_Y;//Acumula as amostras no eixo Y
            count1++;
        }while(count1!=0x0400);//Amostragem de 1024 Hz
        sstatex=sstatex>>10;//Normaliza e guarda o referencial de calibração
        sstatey=sstatey>>10;//Normaliza e guarda o referencial de calibração
    }

    void Filter(void)
{
do{
accelerationx[1]=accelerationx[1] + Sample_X;
accelerationy[1]=accelerationy[1] + Sample_Y;
count2++;}while (count2!=0x40);//executa 64 amostras

accelerationx[1]= accelerationx[1]>>6;
accelerationy[1]= accelerationy[1]>>6;
}
//Ajustes e controle
if ((accelerationx[1] <=3)&&(accelerationx[1] >= -3)) //Janela de controle aplicada sobre o eixo X
{accelerationx[1] = 0;}

//primeira integração eixo X
 velocityx[1] = velocityx[0] + accelerationx[0] + ((accelerationx[1] - accelerationx[0])>>1)
//segunda integração eixo Y
positionX[1] = positionX[0] + velocityx[0] + ((velocityx[1] - velocityx[0])>>1);

//Detecção de parada
if (accelerationx[1]==0) { countx++;}
else { countx =0;}
  if (countx>=25)//apos 25 medias iguais a zero, considere a parada

   {
   velocityx[1]=0;
   velocityx[0]=0;
   }
*/
}
