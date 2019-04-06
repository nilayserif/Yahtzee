/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import Game.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static client.Client.sInput;
import Game.Yahtzee;
import Game.Giris;
import javax.swing.JOptionPane;

/**
 *
 * @author INSECT
 */
// serverdan gelecek mesajları dinleyen thread
class Listen extends Thread {

    public void run() {
        //soket bağlı olduğu sürece dön
        while (Client.socket.isConnected()) {
            try {
                //mesaj gelmesini bloking olarak dinyelen komut
                Message received = (Message) (sInput.readObject());
                //mesaj gelirse bu satıra geçer
                //mesaj tipine göre yapılacak işlemi ayır.
                switch (received.type) {
                    case Name:
                        Client.name=received.content.toString();
                        break;
                    case RivalConnected:
                        String name = received.content.toString();
                        Yahtzee.thisGame.lbl_name.setText("Rakip Oyuncu Adı: "+name);
                        Yahtzee.thisGame.btn_play.setEnabled(true);
                        Yahtzee.thisGame.btn_roll.setEnabled(true);
                        //Yahtzee.thisGame.lbl_name.setText(name);
                        /*Game.ThisGame.txt_rival_name.setText(name);
                        Game.ThisGame.btn_pick.setEnabled(true);
                        Game.ThisGame.btn_send_message.setEnabled(true);*/
                        Yahtzee.thisGame.tmr_slider.start();
                        break;
                    case Disconnect:
                        JOptionPane.showMessageDialog(null, "Rakip oyundan ayrıldı.");
                        Giris g=new Giris();
                        g.setVisible(true);
                        Yahtzee.thisGame.setVisible(false);
                        break;
                    case point:
                       // Game.ThisGame.txt_receive.setText(received.content.toString());
                        String []d=(String[]) received.content;
                        String secilen=d[1];
                        String puan=d[0];
                        switch (secilen){
                            case "bir":
                                Yahtzee.thisGame.lbl_rivalbir.setText(puan);
                                break;
                            case "iki":
                                Yahtzee.thisGame.lbl_rivaliki.setText(puan);
                                break;
                            case "uc":
                                Yahtzee.thisGame.lbl_rivaluc.setText(puan);
                                break;
                            case "dort":
                                Yahtzee.thisGame.lbl_rivaldort.setText(puan);
                                break;
                            case "bes":
                                Yahtzee.thisGame.lbl_rivalbes.setText(puan);
                                break;
                            case "alti":
                                Yahtzee.thisGame.lbl_rivalalti.setText(puan);
                                break;
                            case "3x":
                                Yahtzee.thisGame.lbl_rival3x.setText(puan);
                                break;
                            case "4x":
                                Yahtzee.thisGame.lbl_rival4x.setText(puan);
                                break;
                            case "home":
                                Yahtzee.thisGame.lbl_rivalhm.setText(puan); 
                                break;
                            case "small":
                                Yahtzee.thisGame.lbl_rivalsmall.setText(puan);
                                break;
                            case "large":
                                Yahtzee.thisGame.lbl_rivallarge.setText(puan);
                                break;
                            case "yahtzee":
                                Yahtzee.thisGame.lbl_rivalyahtzee.setText(puan);
                                break;
                            case "soru":
                                Yahtzee.thisGame.lbl_rivalsoru.setText(puan);
                                break;
                        }
                                
                        break;
                    

                    case finish:
                        Yahtzee.thisGame.rivalToplam=(int)received.content;
                        break;

                }

            } catch (IOException ex) {

                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                //Client.Stop();
                break;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                //Client.Stop();
                break;
            }
        }

    }
}

public class Client {

    //her clientın bir soketi olmalı
    public static Socket socket;
    
    public static String name="";
    //verileri almak için gerekli nesne
    public static ObjectInputStream sInput;
    //verileri göndermek için gerekli nesne
    public static ObjectOutputStream sOutput;
    //serverı dinleme thredi 
    public static Listen listenMe;

    public static void Start(String ip, int port) {
        try {
            // Client Soket nesnesi
            Client.socket = new Socket(ip, port);
            Client.Display("Servera bağlandı");
            // input stream
            Client.sInput = new ObjectInputStream(Client.socket.getInputStream());
            // output stream
            Client.sOutput = new ObjectOutputStream(Client.socket.getOutputStream());
            Client.listenMe = new Listen();
            Client.listenMe.start();
            
            //ilk mesaj olarak isim gönderiyorum
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //client durdurma fonksiyonu
    public static void Stop() {
        try {
            if (Client.socket != null) {
                Client.listenMe.stop();
                Client.socket.close();
                Client.sOutput.flush();
                Client.sOutput.close();

                Client.sInput.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void Display(String msg) {

        System.out.println(msg);

    }

    //mesaj gönderme fonksiyonu
    public static void Send(Message msg) {
        try {
            Client.sOutput.writeObject(msg);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}