import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemListener;

public class Latihan1_Hobi extends JFrame {
    public Latihan1_Hobi() {
        super("Hobi");
        JTextField txtNama = new JTextField(12);
        JCheckBox a = new JCheckBox("Musik");
        JCheckBox b = new JCheckBox("Olahraga");
        JCheckBox c = new JCheckBox("Membaca");
        JCheckBox d = new JCheckBox("Game");
        JCheckBox eHobi = new JCheckBox("Coding");

        JLabel infoJumlah = new JLabel("Terpilih: 0 hobi");
        infoJumlah.setForeground(Color.BLUE);

        JTextArea areaLog = new JTextArea(4, 22);
        areaLog.setEditable(false);
        areaLog.setLineWrap(true);

        JButton btn = new JButton("Tampilkan");
        btn.setToolTipText("Tampilkan daftar hobi yang dipilih");
        btn.setMnemonic('T');

        JButton btnReset = new JButton("Reset");
        btnReset.setToolTipText("Kosongkan semua pilihan");
        btnReset.setMnemonic('R');

        ItemListener cekListener = ev -> {
            int jml = 0;
            if (a.isSelected()) jml++;
            if (b.isSelected()) jml++;
            if (c.isSelected()) jml++;
            if (d.isSelected()) jml++;
            if (eHobi.isSelected()) jml++;
            infoJumlah.setText("Terpilih: " + jml + " hobi");
        };
        a.addItemListener(cekListener);
        b.addItemListener(cekListener);
        c.addItemListener(cekListener);
        d.addItemListener(cekListener);
        eHobi.addItemListener(cekListener);

        btn.addActionListener(e -> {
            String nama = txtNama.getText().trim();
            String daftar = "";
            if (a.isSelected()) { daftar += "Musik "; }
            if (b.isSelected()) { daftar += "Olahraga "; }
            if (c.isSelected()) { daftar += "Membaca "; }
            if (d.isSelected()) { daftar += "Game "; }
            if (eHobi.isSelected()) { daftar += "Coding "; }

            if (daftar.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Belum memilih hobi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            } else {
                String pemilik = nama.isEmpty() ? "Hobimu" : "Hobi " + nama;
                String pesan = pemilik + ": " + daftar.trim();
                areaLog.append(pesan + "\n");
                JOptionPane.showMessageDialog(this, pesan, "Info Hobi", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnReset.addActionListener(e -> {
            txtNama.setText("");
            a.setSelected(false);
            b.setSelected(false);
            c.setSelected(false);
            d.setSelected(false);
            eHobi.setSelected(false);
            areaLog.setText("");
        });

        JPanel panelAtas = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panelAtas.add(new JLabel("Nama:"));
        panelAtas.add(txtNama);

        JPanel panelCek = new JPanel(new GridLayout(0, 1, 3, 3));
        panelCek.setBackground(new Color(230, 244, 252));
        panelCek.setBorder(BorderFactory.createTitledBorder("Pilih Hobi"));
        panelCek.add(a);
        panelCek.add(b);
        panelCek.add(c);
        panelCek.add(d);
        panelCek.add(eHobi);
        panelCek.add(infoJumlah);

        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 4));
        panelTombol.add(btn);
        panelTombol.add(btnReset);

        JPanel panelBawah = new JPanel(new BorderLayout(4, 4));
        panelBawah.add(panelTombol, BorderLayout.NORTH);
        panelBawah.add(new JScrollPane(areaLog), BorderLayout.CENTER);

        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 14, 10, 14));
        setLayout(new BorderLayout(6, 6));
        add(panelAtas, BorderLayout.NORTH);
        add(panelCek, BorderLayout.CENTER);
        add(panelBawah, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {}
        SwingUtilities.invokeLater(() -> new Latihan1_Hobi().setVisible(true));
    }
}