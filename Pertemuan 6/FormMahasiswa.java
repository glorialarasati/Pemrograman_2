import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormMahasiswa extends JFrame {
    
    private JTable mahasiswa;
    private DefaultTableModel model;
    private JTextField nimTF, namaTF, jenis_kelaminTF;
    private JScrollPane scrollPane;
    private JButton btnUpdate;
    Connection connection = ConnectDatabase.getConnectDatabase();

    public FormMahasiswa() {
        setTitle("Data Mahasiswa");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] kolom = {"NIM", "Nama", "Jenis Kelamin"};
        model = new DefaultTableModel(kolom, 0);
        mahasiswa = new JTable(model);
        scrollPane = new JScrollPane(mahasiswa);

        nimTF = new JTextField(10);
        namaTF = new JTextField(10);
        jenis_kelaminTF = new JTextField(10);
        btnUpdate = new JButton("OK / Update");

        JPanel panelInput = new JPanel(new GridLayout(4, 2, 10, 10));
        panelInput.add(new JLabel("NIM:"));
        panelInput.add(nimTF);
        panelInput.add(new JLabel("Nama:"));
        panelInput.add(namaTF);
        panelInput.add(new JLabel("Jenis_Kelamin:"));
        panelInput.add(jenis_kelaminTF);
        panelInput.add(btnUpdate);

        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(panelInput, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        btnUpdate.addActionListener(e -> {
            prosesUpdate();
        });

        editData();
    }

    public void editData() {
        model.setRowCount(0);

        try {
            String sql = "UPDATE datadiri SET nama=?, jenis_kelamin=? WHERE nim=?";
            PreparedStatement pS = connection.prepareStatement(sql);
            
            pS.setString(1, namaTF.getText());
            pS.setString(2, jenis_kelaminTF.getText());
            pS.setString(3, nimTF.getText());

            if (pS.executeUpdate() > 0)
                JOptionPane.showMessageDialog(this, "Edit Sukses!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Edit gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void prosesUpdate() {
    // Validasi input kosong
    if (nimTF.getText().isEmpty() || namaTF.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "NIM dan Nama tidak boleh kosong!");
        return;
    }

    try {
        String sql = "UPDATE datadiri SET nama=?, jenis_kelamin=? WHERE nim=?";
        PreparedStatement pS = connection.prepareStatement(sql);

        pS.setString(1, namaTF.getText());
        pS.setString(2, jenis_kelaminTF.getText());
        pS.setString(3, nimTF.getText());

        int rowsAffected = pS.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Data Berhasil Diupdate!");
            editData(); // Refresh tabel supaya perubahan langsung kelihatan
            
            // Opsional: Kosongkan field setelah update
            nimTF.setText("");
            namaTF.setText("");
            jenis_kelaminTF.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Data tidak ditemukan. Cek kembali NIM!");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error Database: " + e.getMessage());
    }
}
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormMahasiswa().setVisible(true);
        });
    }
}