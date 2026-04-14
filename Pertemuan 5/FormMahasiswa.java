import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormMahasiswa extends JFrame {
    
    private JTable tabelMahasiswa;
    private DefaultTableModel model;
    private JScrollPane scrollPane;
    Connection connection = ConnectDatabase.getConnectDatabase();

    public FormMahasiswa() {
        setTitle("Data Mahasiswa dari Database");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        String[] kolom = {"nim", "nama", "jenis_kelamin"};
        model = new DefaultTableModel(kolom, 0);
        tabelMahasiswa = new JTable(model);
        scrollPane = new JScrollPane(tabelMahasiswa);

        add(scrollPane);

        tampilData();
    }

    public void tampilData() {
        model.setRowCount(0);

        if (connection == null) {
            JOptionPane.showMessageDialog(this, "Koneksi Database Gagal!");
            return;
        }

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM datadiri");

            while (rs.next()) {
                String nim = rs.getString("nim");
                String nama = rs.getString("nama"); 
                String jk = rs.getString("jenis_kelamin");
                
                // Masukkan ke dalam baris tabel
                Object[] row = {nim, nama, jk};
                model.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal tampil data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormMahasiswa().setVisible(true);
        });
    }
}