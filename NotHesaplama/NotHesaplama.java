/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotHesaplama;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author akpin
 */
public class NotHesaplama extends JFrame {

    /**
     * @param args the command line arguments
     */
    private JTextField jtf1 = new JTextField();
    private JTextField jtf2 = new JTextField();
    private JTextField jtf3 = new JTextField();
    private JTextField jtf4 = new JTextField();
    private JTextField jtf5 = new JTextField();

    private final JButton jb1 = new JButton("Not Hesapla");

    /**
     * Creates new form NotHesaplayici
     */
    public NotHesaplama() {

        JPanel p1 = new JPanel(new GridLayout(5, 2));
        p1.add(new Label("Vize Notu"));
        p1.add(jtf1);
        p1.add(new Label("Final Notu:"));
        p1.add(jtf2);
        p1.add(new Label("Lab Notu:"));
        p1.add(jtf3);
        p1.add(new Label("Dönem Sonu Notu"));
        p1.add(jtf4);
        p1.add(new Label("Harf Notu"));
        p1.add(jtf5);

        p1.setBorder(new TitledBorder("Vize, Final ve Lab Notu Giriniz."));

        jtf4.setEditable(false);
        jtf5.setEditable(false);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p2.add(jb1);

        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

        jb1.addMouseListener(new mouseDinleyici());
        this.addWindowListener(new pencereDinleyici());

        this.setFocusable(true);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }
            
            
            @Override
            public void keyPressed(KeyEvent devamke) {
                if (devamke.getKeyCode() == KeyEvent.VK_R) {
                    Random r = new Random();
                    jtf1.setText(String.valueOf(r.nextInt(100)));
                    jtf2.setText(String.valueOf(r.nextInt(100)));
                    jtf3.setText(String.valueOf(r.nextInt(100)));

                }
            }
            
            
            @Override
            public void keyReleased(KeyEvent ke) {
            }
            
        });

        jb1.addActionListener((ActionEvent ae) -> {
            int vizeNotu = Integer.parseInt(jtf1.getText());
            int finalNotu = Integer.parseInt(jtf2.getText());
            int labNotu = Integer.parseInt(jtf3.getText());

            Ogrenci o = new Ogrenci();
            o.setDonemSonuNotu(vizeNotu, finalNotu, labNotu);

            jtf4.setText(String.valueOf(o.getDonemSonuNotu()));
            o.setHarfNotu(o.getDonemSonuNotu());
            jtf5.setText(o.getHarfNotu());
        }
        );

    }

    private class mouseDinleyici extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent me) {
            jb1.setForeground(Color.magenta);
        }

        @Override
        public void mouseExited(MouseEvent me) {
            jb1.setForeground(null);

        }

    }

    private class pencereDinleyici extends WindowAdapter {

        @Override
        public void windowOpened(WindowEvent we) {
            System.out.println("Uygulamaya Hoşgeldiniz...");
        }

        @Override
        public void windowClosing(WindowEvent we) {
            System.out.println("Pencere kapatılıyor");
        }

        @Override
        public void windowClosed(WindowEvent we) {
            System.out.println("Pencere kapandı");
        }

        @Override
        public void windowIconified(WindowEvent we) {
            if (Integer.valueOf(jtf1.getText()) > -1) {
                if (Integer.valueOf(jtf1.getText()) > 10) {
                    jtf1.setText(String.valueOf(Integer.valueOf(jtf1.getText()) - 10));
                    System.out.println("Pencere Küçültüldü... Vize notundan 10p eksiltildi. Mevcut vize notu:" + jtf1.getText());

                } else {
                    System.out.println("Pencere Küçültüldü... Vize notu 10 puandan küçük olduğu için 10 eksiltilemedi!");

                }

            } // String sayi = JOptionPane.showInputDialog("Lütfen pozitif bir sayı giriniz!");
            else {
                JOptionPane.showMessageDialog(null, "Girilen Sayı = " + Integer.valueOf(jtf1.getText()), "Lütfen pozitif bir sayı giriniz!", JOptionPane.CLOSED_OPTION);

            }

        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        NotHesaplama frame = new NotHesaplama();
        frame.pack();
        frame.setTitle("Not Hesaplayıcı");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
