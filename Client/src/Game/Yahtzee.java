/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import client.Client;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Yahtzee extends javax.swing.JFrame {

    /**
     * Creates new form Yahtzee
     */
    public static Yahtzee thisGame;
    public String Name = "asa";
    public int hamle = 0;
    public static ArrayList<ImageIcon> icons;
    static int sayac;
    Random rnd = new Random();
    int k;
    ArrayList<String> secilen = new ArrayList<String>();
    ArrayList<JButton> buttons;
    int gecici;
    Client clnt = new Client();
    public Thread tmr_slider;
    public int OyunToplam = 0;
    public int rivalToplam = 0;

    public Yahtzee() {
        //lbl_name.setText(Name);
        sayac = 0;
        icons = new ArrayList<ImageIcon>();
        ImageIcon icn1 = new ImageIcon("C:\\Users\\Asus\\Desktop\\Yahtzee\\Client\\src\\client\\images\\bir.jpg");
        ImageIcon icn2 = new ImageIcon("C:\\Users\\Asus\\Desktop\\Yahtzee\\Client\\src\\client\\images\\iki.jpg");
        ImageIcon icn3 = new ImageIcon("C:\\Users\\Asus\\Desktop\\Yahtzee\\Client\\src\\client\\images\\uç.jpg");
        ImageIcon icn4 = new ImageIcon("C:\\Users\\Asus\\Desktop\\Yahtzee\\Client\\src\\client\\images\\dort.jpg");
        ImageIcon icn5 = new ImageIcon("C:\\Users\\Asus\\Desktop\\Yahtzee\\Client\\src\\client\\images\\bes.jpg");
        ImageIcon icn6 = new ImageIcon("C:\\Users\\Asus\\Desktop\\Yahtzee\\Client\\src\\client\\images\\altı.jpg");
        icons.add(icn1);
        icons.add(icn2);
        icons.add(icn3);
        icons.add(icn4);
        icons.add(icn5);
        icons.add(icn6);
        initComponents();
        thisGame = this;
        buttons = new ArrayList<JButton>();
        buttons.add(btn_bir);
        buttons.add(btn_iki);
        buttons.add(btn_uc);
        buttons.add(btn_dort);
        buttons.add(btn_bes);
        buttons.add(btn_alti);
        buttons.add(btn_3x);
        buttons.add(btn_4x);
        buttons.add(btn_home);
        buttons.add(btn_small);
        buttons.add(btn_large);
        buttons.add(btn_yahtzee);
        buttons.add(btn_soru);
        buttons.get(0).setName("bir");
        buttons.get(1).setName("iki");
        buttons.get(2).setName("uc");
        buttons.get(3).setName("dort");
        buttons.get(4).setName("bes");
        buttons.get(5).setName("alti");
        buttons.get(6).setName("3x");
        buttons.get(7).setName("4x");
        buttons.get(8).setName("home");
        buttons.get(9).setName("small");
        buttons.get(10).setName("large");
        buttons.get(11).setName("yahtzee");
        buttons.get(12).setName("soru");
        btn_roll.setEnabled(false);
        btn_play.setEnabled(false);
        tmr_slider = new Thread(() -> {
            //soket bağlıysa dönsün
            while (Client.socket.isConnected()) {

                try {
                    //
                    Thread.sleep(100);
                    //eğer ikisinden biri -1 ise resim dönmeye devam etsin sonucu göstermesin
                } catch (InterruptedException ex) {
                    Logger.getLogger(Yahtzee.class.getName()).log(Level.SEVERE, null, ex);
                }

                tmr_slider.stop();

                //Reset();
            }

        });

    }
    Runnable r = new Runnable() {
        @Override
        public void run() {
            lbl_zar1.setEnabled(true);
            lbl_zar2.setEnabled(true);
            lbl_zar3.setEnabled(true);
            lbl_zar4.setEnabled(true);
            lbl_zar5.setEnabled(true);
            for (int i = 0; i < 10; i++) {
                k = rnd.nextInt(6);
                lbl_zar1.setIcon(icons.get(k));
                k = rnd.nextInt(6);
                lbl_zar2.setIcon(icons.get(k));
                k = rnd.nextInt(6);
                lbl_zar3.setIcon(icons.get(k));
                k = rnd.nextInt(6);
                lbl_zar4.setIcon(icons.get(k));
                k = rnd.nextInt(6);
                lbl_zar5.setIcon(icons.get(k));
                if (sayac >= 3) {
                    btn_roll.setEnabled(false);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Yahtzee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    };

    public void Roll() throws InterruptedException {
        sayac++;

        Thread t = new Thread(r);
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_bir = new javax.swing.JButton();
        btn_iki = new javax.swing.JButton();
        btn_uc = new javax.swing.JButton();
        btn_dort = new javax.swing.JButton();
        btn_bes = new javax.swing.JButton();
        btn_alti = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btn_3x = new javax.swing.JButton();
        btn_4x = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();
        btn_small = new javax.swing.JButton();
        btn_large = new javax.swing.JButton();
        btn_yahtzee = new javax.swing.JButton();
        btn_soru = new javax.swing.JButton();
        lbl_rivalbir = new javax.swing.JLabel();
        lbl_rivaliki = new javax.swing.JLabel();
        lbl_rivaluc = new javax.swing.JLabel();
        lbl_rivaldort = new javax.swing.JLabel();
        lbl_rivalbes = new javax.swing.JLabel();
        lbl_rivalalti = new javax.swing.JLabel();
        lbl_rival3x = new javax.swing.JLabel();
        lbl_rival4x = new javax.swing.JLabel();
        lbl_rivalhm = new javax.swing.JLabel();
        lbl_rivalsmall = new javax.swing.JLabel();
        lbl_rivallarge = new javax.swing.JLabel();
        lbl_rivalyahtzee = new javax.swing.JLabel();
        lbl_rivalsoru = new javax.swing.JLabel();
        lbl_zar1 = new javax.swing.JLabel();
        lbl_zar2 = new javax.swing.JLabel();
        lbl_zar3 = new javax.swing.JLabel();
        lbl_zar4 = new javax.swing.JLabel();
        lbl_zar5 = new javax.swing.JLabel();
        btn_roll = new javax.swing.JButton();
        btn_play = new javax.swing.JButton();
        lbl_secim1 = new javax.swing.JLabel();
        lbl_secim2 = new javax.swing.JLabel();
        lbl_secim3 = new javax.swing.JLabel();
        lbl_secim4 = new javax.swing.JLabel();
        lbl_secim5 = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("YAHTZEE");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 11)); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/images/bir.jpg"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/images/iki.jpg"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/images/uç.jpg"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/images/dort.jpg"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/images/bes.jpg"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/images/altı.jpg"))); // NOI18N

        btn_bir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_birActionPerformed(evt);
            }
        });

        btn_iki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ikiActionPerformed(evt);
            }
        });

        btn_uc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ucActionPerformed(evt);
            }
        });

        btn_dort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dortActionPerformed(evt);
            }
        });

        btn_bes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_besActionPerformed(evt);
            }
        });

        btn_alti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_altiActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/images/3x.jpg"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/images/4x.jpg"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/images/hm.jpg"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/images/small.jpg"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/images/large.jpg"))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/images/yahtzee.jpg"))); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/images/soruisareti.jpg"))); // NOI18N

        btn_3x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_3xActionPerformed(evt);
            }
        });

        btn_4x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_4xActionPerformed(evt);
            }
        });

        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        btn_small.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_smallActionPerformed(evt);
            }
        });

        btn_large.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_largeActionPerformed(evt);
            }
        });

        btn_yahtzee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_yahtzeeActionPerformed(evt);
            }
        });

        btn_soru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_soruActionPerformed(evt);
            }
        });

        lbl_zar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/images/altı.jpg"))); // NOI18N
        lbl_zar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_zar1MousePressed(evt);
            }
        });

        lbl_zar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/images/dort.jpg"))); // NOI18N
        lbl_zar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_zar2MousePressed(evt);
            }
        });

        lbl_zar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/images/bir.jpg"))); // NOI18N
        lbl_zar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_zar3MousePressed(evt);
            }
        });

        lbl_zar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/images/bes.jpg"))); // NOI18N
        lbl_zar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_zar4MousePressed(evt);
            }
        });

        lbl_zar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/images/iki.jpg"))); // NOI18N
        lbl_zar5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_zar5MousePressed(evt);
            }
        });

        btn_roll.setBackground(new java.awt.Color(107, 0, 0));
        btn_roll.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 24)); // NOI18N
        btn_roll.setText("Zar At");
        btn_roll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rollActionPerformed(evt);
            }
        });

        btn_play.setBackground(new java.awt.Color(107, 0, 0));
        btn_play.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 24)); // NOI18N
        btn_play.setText("Seçimi Gönder");
        btn_play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_playActionPerformed(evt);
            }
        });

        lbl_secim1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_secim1MousePressed(evt);
            }
        });

        lbl_secim2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_secim2MousePressed(evt);
            }
        });

        lbl_secim3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_secim3MousePressed(evt);
            }
        });

        lbl_secim4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_secim4MousePressed(evt);
            }
        });

        lbl_secim5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_secim5MousePressed(evt);
            }
        });

        lbl_name.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 18)); // NOI18N
        lbl_name.setForeground(new java.awt.Color(107, 0, 0));

        jButton1.setBackground(new java.awt.Color(107, 0, 0));
        jButton1.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 24)); // NOI18N
        jButton1.setText("Oyundan Ayrıl");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 1035, Short.MAX_VALUE)
                .addComponent(lbl_name)
                .addGap(37, 37, 37))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_alti, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_bes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_dort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_uc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_bir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_iki, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_rivalalti, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(lbl_rivalbes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_rivaldort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_rivaluc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_rivaliki, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_rivalbir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(114, 114, 114)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_small, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_4x, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_large, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_3x, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_yahtzee, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_soru, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_rivalsoru, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(lbl_rival3x, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_rival4x, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_rivalsmall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_rivallarge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_rivalyahtzee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_rivalhm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_zar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_zar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_zar3)
                                .addGap(84, 84, 84)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_zar2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_zar5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btn_roll, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_secim1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_secim2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_secim3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_secim4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_secim5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_play, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbl_name)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(lbl_rival3x, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_3x, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btn_bir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_rivalbir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(btn_4x, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_rival4x, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_rivaliki, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_iki, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_zar1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_zar2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lbl_zar3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbl_zar4, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                        .addComponent(lbl_rivalhm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_rivaluc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_uc, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_zar5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_roll, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_rivaldort, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10)
                    .addComponent(btn_dort, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_rivalsmall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_small, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_secim4, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(lbl_secim3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_secim2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_secim1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_rivallarge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_rivalbes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_secim5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_bes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_large, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_play, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_rivalalti, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_alti, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_yahtzee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_rivalyahtzee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_soru, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_rivalsoru, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_rollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rollActionPerformed
        try {
            Roll();
        } catch (InterruptedException ex) {
            Logger.getLogger(Yahtzee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_rollActionPerformed


    private void lbl_zar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_zar1MousePressed

        ImageIcon icon = new ImageIcon();
        icon = (ImageIcon) lbl_zar1.getIcon();
        if (lbl_zar1.isEnabled()) {
            for (int i = 0; i < 6; i++) {
                if (icon.toString().equals(icons.get(i).toString())) {
                    if (secilen.size() < 5) {
                        secilen.add(Integer.toString(i));
                        if (lbl_secim1.getIcon() == null) {
                            lbl_secim1.setIcon(icon);
                        } else if (lbl_secim2.getIcon() == null) {
                            lbl_secim2.setIcon(icon);
                        } else if (lbl_secim3.getIcon() == null) {
                            lbl_secim3.setIcon(icon);
                        } else if (lbl_secim4.getIcon() == null) {
                            lbl_secim4.setIcon(icon);
                        } else if (lbl_secim5.getIcon() == null) {
                            lbl_secim5.setIcon(icon);
                        }
                    } else {
                        System.out.println("sayı fazla");
                    }
                }
            }
        }
        lbl_zar1.setEnabled(false);

    }//GEN-LAST:event_lbl_zar1MousePressed

    private void lbl_zar2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_zar2MousePressed
        ImageIcon icon = new ImageIcon();
        icon = (ImageIcon) lbl_zar2.getIcon();
        if (lbl_zar2.isEnabled()) {
            for (int i = 0; i < 6; i++) {
                if (icon.toString().equals(icons.get(i).toString())) {
                    if (secilen.size() < 5) {
                        secilen.add(Integer.toString(i));
                        if (lbl_secim1.getIcon() == null) {
                            lbl_secim1.setIcon(icon);
                        } else if (lbl_secim2.getIcon() == null) {
                            lbl_secim2.setIcon(icon);
                        } else if (lbl_secim3.getIcon() == null) {
                            lbl_secim3.setIcon(icon);
                        } else if (lbl_secim4.getIcon() == null) {
                            lbl_secim4.setIcon(icon);
                        } else if (lbl_secim5.getIcon() == null) {
                            lbl_secim5.setIcon(icon);
                        }
                    } else {
                        System.out.println("sayı fazla");
                    }
                }
            }
        }
        lbl_zar2.setEnabled(false);

    }//GEN-LAST:event_lbl_zar2MousePressed

    private void lbl_zar3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_zar3MousePressed
        ImageIcon icon = new ImageIcon();
        icon = (ImageIcon) lbl_zar3.getIcon();
        if (lbl_zar3.isEnabled()) {
            for (int i = 0; i < 6; i++) {
                if (icon.toString().equals(icons.get(i).toString())) {
                    if (secilen.size() < 5) {
                        secilen.add(Integer.toString(i));
                        if (lbl_secim1.getIcon() == null) {
                            lbl_secim1.setIcon(icon);
                        } else if (lbl_secim2.getIcon() == null) {
                            lbl_secim2.setIcon(icon);
                        } else if (lbl_secim3.getIcon() == null) {
                            lbl_secim3.setIcon(icon);
                        } else if (lbl_secim4.getIcon() == null) {
                            lbl_secim4.setIcon(icon);
                        } else if (lbl_secim5.getIcon() == null) {
                            lbl_secim5.setIcon(icon);
                        }
                    } else {
                        System.out.println("sayı fazla");
                    }
                }
            }
        }
        lbl_zar3.setEnabled(false);

    }//GEN-LAST:event_lbl_zar3MousePressed

    private void lbl_zar4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_zar4MousePressed
        ImageIcon icon = new ImageIcon();
        icon = (ImageIcon) lbl_zar4.getIcon();
        if (lbl_zar4.isEnabled()) {
            for (int i = 0; i < 6; i++) {
                if (icon.toString().equals(icons.get(i).toString())) {
                    if (secilen.size() < 5) {
                        secilen.add(Integer.toString(i));
                        if (lbl_secim1.getIcon() == null) {
                            lbl_secim1.setIcon(icon);
                        } else if (lbl_secim2.getIcon() == null) {
                            lbl_secim2.setIcon(icon);
                        } else if (lbl_secim3.getIcon() == null) {
                            lbl_secim3.setIcon(icon);
                        } else if (lbl_secim4.getIcon() == null) {
                            lbl_secim4.setIcon(icon);
                        } else if (lbl_secim5.getIcon() == null) {
                            lbl_secim5.setIcon(icon);
                        }
                    } else {
                        System.out.println("sayı fazla");
                    }
                }
            }
        }
        lbl_zar4.setEnabled(false);

    }//GEN-LAST:event_lbl_zar4MousePressed

    private void lbl_zar5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_zar5MousePressed
        ImageIcon icon = new ImageIcon();
        icon = (ImageIcon) lbl_zar5.getIcon();
        if (lbl_zar5.isEnabled()) {
            for (int i = 0; i < 6; i++) {
                if (icon.toString().equals(icons.get(i).toString())) {
                    if (secilen.size() < 5) {
                        secilen.add(Integer.toString(i));
                        if (lbl_secim1.getIcon() == null) {
                            lbl_secim1.setIcon(icon);
                        } else if (lbl_secim2.getIcon() == null) {
                            lbl_secim2.setIcon(icon);
                        } else if (lbl_secim3.getIcon() == null) {
                            lbl_secim3.setIcon(icon);
                        } else if (lbl_secim4.getIcon() == null) {
                            lbl_secim4.setIcon(icon);
                        } else if (lbl_secim5.getIcon() == null) {
                            lbl_secim5.setIcon(icon);
                        }
                    } else {
                        System.out.println("sayı fazla");
                    }
                }
            }
        }
        lbl_zar5.setEnabled(false);

    }//GEN-LAST:event_lbl_zar5MousePressed

    private void lbl_secim1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_secim1MousePressed
        ImageIcon icon = new ImageIcon();
        icon = (ImageIcon) lbl_secim1.getIcon();
        String tmp;
        for (int i = 0; i < 6; i++) {
            if (icon.toString().equals(icons.get(i).toString())) {
                tmp = Integer.toString(i);
                secilen.remove(tmp);
            }
        }
        lbl_secim1.setIcon(null);

    }//GEN-LAST:event_lbl_secim1MousePressed

    private void lbl_secim2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_secim2MousePressed
        ImageIcon icon = new ImageIcon();
        icon = (ImageIcon) lbl_secim2.getIcon();
        String tmp;
        for (int i = 0; i < 6; i++) {
            if (icon.toString().equals(icons.get(i).toString())) {
                tmp = Integer.toString(i);
                secilen.remove(tmp);
            }
        }
        lbl_secim2.setIcon(null);
    }//GEN-LAST:event_lbl_secim2MousePressed

    private void lbl_secim3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_secim3MousePressed
        ImageIcon icon = new ImageIcon();
        icon = (ImageIcon) lbl_secim3.getIcon();
        String tmp;
        for (int i = 0; i < 6; i++) {
            if (icon.toString().equals(icons.get(i).toString())) {
                tmp = Integer.toString(i);
                secilen.remove(tmp);
            }
        }
        lbl_secim3.setIcon(null);
    }//GEN-LAST:event_lbl_secim3MousePressed

    private void lbl_secim4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_secim4MousePressed
        ImageIcon icon = new ImageIcon();
        icon = (ImageIcon) lbl_secim4.getIcon();
        String tmp;
        for (int i = 0; i < 6; i++) {
            if (icon.toString().equals(icons.get(i).toString())) {
                tmp = Integer.toString(i);
                secilen.remove(tmp);
            }
        }
        lbl_secim4.setIcon(null);
    }//GEN-LAST:event_lbl_secim4MousePressed

    private void lbl_secim5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_secim5MousePressed
        ImageIcon icon = new ImageIcon();
        icon = (ImageIcon) lbl_secim5.getIcon();
        String tmp;
        for (int i = 0; i < 6; i++) {
            if (icon.toString().equals(icons.get(i).toString())) {
                tmp = Integer.toString(i);
                secilen.remove(tmp);
            }
        }
        lbl_secim5.setIcon(null);
    }//GEN-LAST:event_lbl_secim5MousePressed

    private void btn_birActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_birActionPerformed
        int toplam = 0;
        for (int i = 0; i < secilen.size(); i++) {

            if (secilen.get(i).equals("0")) {
                toplam++;
            }
        }
        if (toplam > 0) {
            for (int i = 0; i < buttons.size(); i++) {
                if (buttons.get(i).isEnabled()) {
                    buttons.get(i).setText("");
                }
            }
            btn_bir.setText(Integer.toString(toplam));
            gecici = buttons.indexOf(btn_bir);
        }

    }//GEN-LAST:event_btn_birActionPerformed

    private void btn_ikiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ikiActionPerformed
        int toplam = 0;
        for (int i = 0; i < secilen.size(); i++) {

            if (secilen.get(i).equals("1")) {
                toplam += 2;
            }
        }
        if (toplam > 0) {
            for (int i = 0; i < buttons.size(); i++) {
                if (buttons.get(i).isEnabled()) {
                    buttons.get(i).setText("");
                }
            }
            btn_iki.setText(Integer.toString(toplam));
            gecici = buttons.indexOf(btn_iki);
        }
    }//GEN-LAST:event_btn_ikiActionPerformed

    private void btn_ucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ucActionPerformed
        int toplam = 0;
        for (int i = 0; i < secilen.size(); i++) {

            if (secilen.get(i).equals("2")) {
                toplam += 3;
            }
        }
        if (toplam > 0) {
            for (int i = 0; i < buttons.size(); i++) {
                if (buttons.get(i).isEnabled()) {
                    buttons.get(i).setText("");
                }
            }
            btn_uc.setText(Integer.toString(toplam));
            gecici = buttons.indexOf(btn_uc);
        }
    }//GEN-LAST:event_btn_ucActionPerformed

    private void btn_dortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dortActionPerformed
        int toplam = 0;
        for (int i = 0; i < secilen.size(); i++) {

            if (secilen.get(i).equals("3")) {
                toplam += 4;
            }
        }
        if (toplam > 0) {
            for (int i = 0; i < buttons.size(); i++) {
                if (buttons.get(i).isEnabled()) {
                    buttons.get(i).setText("");
                }
            }
            btn_dort.setText(Integer.toString(toplam));
            gecici = buttons.indexOf(btn_dort);
        }
    }//GEN-LAST:event_btn_dortActionPerformed

    private void btn_besActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_besActionPerformed
        int toplam = 0;
        for (int i = 0; i < secilen.size(); i++) {

            if (secilen.get(i).equals("4")) {
                toplam += 5;
            }
        }
        if (toplam > 0) {
            for (int i = 0; i < buttons.size(); i++) {
                if (buttons.get(i).isEnabled()) {
                    buttons.get(i).setText("");
                }
            }
            btn_bes.setText(Integer.toString(toplam));
            gecici = buttons.indexOf(btn_bes);
        }
    }//GEN-LAST:event_btn_besActionPerformed

    private void btn_altiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_altiActionPerformed
        int toplam = 0;
        for (int i = 0; i < secilen.size(); i++) {

            if (secilen.get(i).equals("5")) {
                toplam += 6;
            }
        }
        if (toplam > 0) {
            for (int i = 0; i < buttons.size(); i++) {
                if (buttons.get(i).isEnabled()) {
                    buttons.get(i).setText("");
                }
            }
            btn_alti.setText(Integer.toString(toplam));
            gecici = buttons.indexOf(btn_alti);
        }
    }//GEN-LAST:event_btn_altiActionPerformed

    private void btn_3xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_3xActionPerformed
        int sayac = 0;
        int toplam = 0;
        for (int i = 0; i < secilen.size(); i++) {
            for (int j = i + 1; j < secilen.size(); j++) {

                if (secilen.get(i).equals(secilen.get(j))) {
                    sayac++;
                    toplam += (Integer.parseInt(secilen.get(i)) + 1);
                }
            }
            sayac++;
            toplam += Integer.parseInt(secilen.get(i)) + 1;
            if (sayac < 3) {
                sayac = 0;
                toplam = 0;
            } else {
                break;
            }
        }
        if (sayac >= 3) {
            for (int i = 0; i < buttons.size(); i++) {
                if (buttons.get(i).isEnabled()) {
                    buttons.get(i).setText("");
                }
            }
            btn_3x.setText(Integer.toString(toplam));
            gecici = buttons.indexOf(btn_3x);
        }

    }//GEN-LAST:event_btn_3xActionPerformed

    private void btn_4xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_4xActionPerformed
        int sayac = 0;
        int toplam = 0;
        for (int i = 0; i < secilen.size(); i++) {
            for (int j = i + 1; j < secilen.size(); j++) {

                if (secilen.get(i).equals(secilen.get(j))) {
                    sayac++;
                    toplam += (Integer.parseInt(secilen.get(i)) + 1);
                }
            }
            sayac++;
            toplam += Integer.parseInt(secilen.get(i)) + 1;
            if (sayac < 4) {
                sayac = 0;
                toplam = 0;
            } else {
                break;
            }
        }
        if (sayac >= 4) {
            for (int i = 0; i < buttons.size(); i++) {
                if (buttons.get(i).isEnabled()) {
                    buttons.get(i).setText("");
                }
            }
            btn_4x.setText(Integer.toString(toplam));
            gecici = buttons.indexOf(btn_4x);
        }
    }//GEN-LAST:event_btn_4xActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        int sayac1 = 0, sayac2 = 0;
        for (int i = 0; i < secilen.size(); i++) {
            for (int j = i + 1; j < secilen.size(); j++) {

                if (secilen.get(i).equals(secilen.get(j))) {
                    sayac1++;

                }
            }
            sayac1++;

            if (sayac1 < 3) {
                sayac1 = 0;

            } else {
                break;
            }
        }
        for (int i = 0; i < secilen.size(); i++) {
            for (int j = i + 1; j < secilen.size(); j++) {

                if (secilen.get(i).equals(secilen.get(j))) {
                    sayac2++;

                }
            }
            sayac2++;

            if (sayac2 > 2 || sayac2 < 2) {
                sayac2 = 0;

            } else {
                break;
            }

        }
        if (sayac1 == 3 && sayac2 == 2) {
            for (int i = 0; i < buttons.size(); i++) {
                if (buttons.get(i).isEnabled()) {
                    buttons.get(i).setText("");
                }
            }
            btn_home.setText("25");
            gecici = buttons.indexOf(btn_home);
        }
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_smallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_smallActionPerformed
        int sayac = 0;

        for (int i = 0; i < secilen.size(); i++) {
            for (int j = i + 1; j < secilen.size(); j++) {

                if (secilen.get(i).equals(secilen.get(j))) {
                    sayac++;

                }
            }
            sayac++;

            if (sayac < 4) {
                sayac = 0;

            } else {
                break;
            }
        }
        if (sayac >= 4) {
            for (int i = 0; i < buttons.size(); i++) {
                if (buttons.get(i).isEnabled()) {
                    buttons.get(i).setText("");
                }
            }
            btn_small.setText("30");
            gecici = buttons.indexOf(btn_small);
        }
    }//GEN-LAST:event_btn_smallActionPerformed

    private void btn_largeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_largeActionPerformed
        int sayac = 1;
        String sec = secilen.get(0);
        for (int i = 1; i < secilen.size(); i++) {

            if (secilen.get(i).equals(sec)) {
                sayac++;

            }

        }
        if (sayac == 5) {
            for (int i = 0; i < buttons.size(); i++) {
                if (buttons.get(i).isEnabled()) {
                    buttons.get(i).setText("");
                }
            }
            btn_large.setText("40");
            gecici = buttons.indexOf(btn_large);
        }
    }//GEN-LAST:event_btn_largeActionPerformed

    private void btn_yahtzeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_yahtzeeActionPerformed
        int sayac = 1;
        String sec = secilen.get(0);
        for (int i = 1; i < secilen.size(); i++) {

            if (secilen.get(i).equals(sec)) {
                sayac++;

            }

        }
        if (sayac == 5) {
            for (int i = 0; i < buttons.size(); i++) {
                if (buttons.get(i).isEnabled()) {
                    buttons.get(i).setText("");
                }
            }
            btn_yahtzee.setText("50");
            gecici = buttons.indexOf(btn_yahtzee);
        }
    }//GEN-LAST:event_btn_yahtzeeActionPerformed

    private void btn_soruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_soruActionPerformed
        int toplam = 0;

        for (int i = 0; i < secilen.size(); i++) {
            toplam += (Integer.parseInt(secilen.get(i)) + 1);
        }

        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).isEnabled()) {
                buttons.get(i).setText("");
            }
        }
        btn_soru.setText(Integer.toString(toplam));
        gecici = buttons.indexOf(btn_soru);
    }//GEN-LAST:event_btn_soruActionPerformed

    private void btn_playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_playActionPerformed
        hamle++;
        buttons.get(gecici).setEnabled(false);
        String[] dizi = new String[2];
        Message msg = new Message(Message.Message_Type.point);
        dizi[0] = buttons.get(gecici).getText();
        dizi[1] = buttons.get(gecici).getName();
        msg.content = dizi;
        clnt.Send(msg);
        sayac = 0;
        btn_roll.setEnabled(true);
        lbl_secim1.setIcon(null);
        lbl_secim2.setIcon(null);
        lbl_secim3.setIcon(null);
        lbl_secim4.setIcon(null);
        lbl_secim5.setIcon(null);
        for (int i = 0; i < 5; i++) {

            secilen.remove(0);
        }
        if (hamle == 13) {

            OyunToplam = Integer.parseInt(btn_bir.getText()) + Integer.parseInt(btn_iki.getText()) + Integer.parseInt(btn_uc.getText()) + Integer.parseInt(btn_yahtzee.getText()) + Integer.parseInt(btn_soru.getText())
                    + Integer.parseInt(btn_dort.getText()) + Integer.parseInt(btn_bes.getText()) + Integer.parseInt(btn_alti.getText()) + Integer.parseInt(btn_3x.getText()) + Integer.parseInt(btn_4x.getText())
                    + Integer.parseInt(btn_home.getText()) + Integer.parseInt(btn_small.getText()) + Integer.parseInt(btn_large.getText());
            System.out.println(OyunToplam);
            Message msg1 = new Message(Message.Message_Type.finish);
            msg1.content = OyunToplam;
            Client.Send(msg1);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Yahtzee.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (Yahtzee.thisGame.OyunToplam > rivalToplam) {
                JOptionPane.showMessageDialog(null, "Oyunu " + Yahtzee.thisGame.OyunToplam + " puanla" + " kazandız.");
            } else if (Yahtzee.thisGame.OyunToplam < rivalToplam) {
                JOptionPane.showMessageDialog(null, "Oyunu " + Yahtzee.thisGame.OyunToplam + " puanla " + lbl_name.getText() + " kazandı.");

            } else {
                JOptionPane.showMessageDialog(null, "Oyun berabere bitti ");

            }
            Client.Stop();
            Giris g=new Giris();
            g.setVisible(true);
            thisGame.setVisible(false);
        }

    }//GEN-LAST:event_btn_playActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Message msg=new Message(Message.Message_Type.Disconnect);
        msg.content="0";
        Client.Send(msg);
        Client.Stop();
        Giris g=new Giris();
        g.setVisible(true);
        thisGame.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Yahtzee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Yahtzee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Yahtzee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Yahtzee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Yahtzee().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_3x;
    private javax.swing.JButton btn_4x;
    private javax.swing.JButton btn_alti;
    private javax.swing.JButton btn_bes;
    public static javax.swing.JButton btn_bir;
    private javax.swing.JButton btn_dort;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_iki;
    private javax.swing.JButton btn_large;
    public javax.swing.JButton btn_play;
    public javax.swing.JButton btn_roll;
    private javax.swing.JButton btn_small;
    private javax.swing.JButton btn_soru;
    private javax.swing.JButton btn_uc;
    private javax.swing.JButton btn_yahtzee;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lbl_name;
    public javax.swing.JLabel lbl_rival3x;
    public javax.swing.JLabel lbl_rival4x;
    public javax.swing.JLabel lbl_rivalalti;
    public javax.swing.JLabel lbl_rivalbes;
    public javax.swing.JLabel lbl_rivalbir;
    public javax.swing.JLabel lbl_rivaldort;
    public javax.swing.JLabel lbl_rivalhm;
    public javax.swing.JLabel lbl_rivaliki;
    public javax.swing.JLabel lbl_rivallarge;
    public javax.swing.JLabel lbl_rivalsmall;
    public javax.swing.JLabel lbl_rivalsoru;
    public javax.swing.JLabel lbl_rivaluc;
    public javax.swing.JLabel lbl_rivalyahtzee;
    private javax.swing.JLabel lbl_secim1;
    private javax.swing.JLabel lbl_secim2;
    private javax.swing.JLabel lbl_secim3;
    private javax.swing.JLabel lbl_secim4;
    private javax.swing.JLabel lbl_secim5;
    private javax.swing.JLabel lbl_zar1;
    private javax.swing.JLabel lbl_zar2;
    private javax.swing.JLabel lbl_zar3;
    private javax.swing.JLabel lbl_zar4;
    private javax.swing.JLabel lbl_zar5;
    // End of variables declaration//GEN-END:variables
}