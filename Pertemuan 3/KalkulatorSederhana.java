import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KalkulatorSederhana extends JFrame implements ActionListener {

    JLabel lblAngka1, lblAngka2, lblHasil;
    JTextField txtAngka1, txtAngka2, txtHasil;
    JButton btnTambah, btnHapus, btnExit;

    public KalkulatorSederhana() {
        setTitle("Kalkulator Penjumlahan");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Label
        lblAngka1 = new JLabel("Angka Pertama");
        lblAngka1.setBounds(20, 20, 120, 25);
        add(lblAngka1);

        lblAngka2 = new JLabel("Angka Kedua");
        lblAngka2.setBounds(20, 60, 120, 25);
        add(lblAngka2);

        lblHasil = new JLabel("Hasil");
        lblHasil.setBounds(20, 100, 120, 25);
        add(lblHasil);

        // TextField
        txtAngka1 = new JTextField();
        txtAngka1.setBounds(150, 20, 150, 25);
        add(txtAngka1);

        txtAngka2 = new JTextField();
        txtAngka2.setBounds(150, 60, 150, 25);
        add(txtAngka2);

        txtHasil = new JTextField();
        txtHasil.setBounds(150, 100, 150, 25);
        txtHasil.setEditable(false);
        add(txtHasil);

        // Button
        btnTambah = new JButton("Tambah");
        btnTambah.setBounds(20, 150, 90, 30);
        btnTambah.addActionListener(this);
        add(btnTambah);

        btnHapus = new JButton("Hapus");
        btnHapus.setBounds(120, 150, 90, 30);
        btnHapus.addActionListener(this);
        add(btnHapus);

        btnExit = new JButton("Exit");
        btnExit.setBounds(220, 150, 90, 30);
        btnExit.addActionListener(this);
        add(btnExit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTambah) {
            try {
                double angka1 = Double.parseDouble(txtAngka1.getText());
                double angka2 = Double.parseDouble(txtAngka2.getText());
                double hasil = angka1 + angka2;
                txtHasil.setText(String.valueOf(hasil));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Input harus berupa angka!");
            }
        }

        if (e.getSource() == btnHapus) {
            txtAngka1.setText("");
            txtAngka2.setText("");
            txtHasil.setText("");
        }

        if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new KalkulatorSederhana().setVisible(true);
    }
}