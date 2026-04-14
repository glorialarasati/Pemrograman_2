import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class latTabel extends JFrame {
    private DefaultTableModel mod;
    Object[] data = new Object[3];

    JTextField nimTxt = new JTextField(10);
    JTextField namaTxt = new JTextField(10);
    JTextField nilTxt = new JTextField(10);
    JTable jTable1 = new JTable();
    JButton btnTambah = new JButton("Tambah");

    public latTabel() {
        setTitle("Tabel Mahasiswa");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new java.awt.FlowLayout());

        add(new JLabel("NIM"));
        add(nimTxt);
        add(new JLabel("Nama"));
        add(namaTxt);
        add(new JLabel("Nilai"));
        add(nilTxt);
        add(btnTambah);
        add(new JScrollPane(jTable1));

        judulTabel();

        btnTambah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                data[0] = nimTxt.getText();
                data[1] = namaTxt.getText();
                data[2] = nilTxt.getText();
                mod.addRow(data);
            }
        });
    }

    private void judulTabel() {
        mod = new DefaultTableModel();
        mod.addColumn("NIM");
        mod.addColumn("Nama");
        mod.addColumn("Nilai");
        jTable1.setModel(mod);
    }

    public static void main(String[] args) {
        new latTabel().setVisible(true);
    }
}