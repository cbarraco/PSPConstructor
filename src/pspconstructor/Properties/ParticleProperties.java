package pspconstructor.Properties;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.filechooser.FileFilter;
import pspconstructor.Components.GCHandler;
import pspconstructor.Components.GCSprite;
import pspconstructor.IOHandler;
import pspconstructor.Main;

/**
 *
 * @author Carlo
 */
public class ParticleProperties extends javax.swing.JInternalFrame {

    JFileChooser fchParticle = new JFileChooser();
    String FilePath = "";
    int Index;

    /** Creates new form infSoundProperties */
    public ParticleProperties(int index) {
        initComponents();
        for (GCSprite s : GCHandler.Sprites) {
            cboSprite.addItem(s.Name);
        }
        for (GCSprite s : GCHandler.Sprites) {
            if (s.ID == GCHandler.Particles.get(index).Sprite.ID) {
                cboSprite.setSelectedItem(s.Name);
            }
            if (s.ID == -1) {
                cboSprite.setSelectedIndex(0);
            }
        }
        Index = index;
        fchParticle.addChoosableFileFilter(new psiFilter());
        fchParticle.setAcceptAllFileFilterUsed(false);
        cboSpritePRenderer renderer = new cboSpritePRenderer();
        cboSprite.setRenderer(renderer);
        getInfo();
    }

    public void getInfo() {
        txtFile.setText(GCHandler.Particles.get(Index).Filename);
        FilePath = GCHandler.Particles.get(Index).FilePath;
    }

    public void setInfo() {
        GCHandler.Particles.get(Index).setFileName(txtFile.getText());
        GCHandler.Particles.get(Index).setFilePath(FilePath);
        if (cboSprite.getSelectedIndex() != 0) {
            GCHandler.Particles.get(Index).Sprite = GCHandler.Sprites.get(cboSprite.getSelectedIndex() - 1);
            GCHandler.Particles.get(Index).Sprite.ID = GCHandler.Sprites.get(cboSprite.getSelectedIndex() - 1).ID;
        } else {
            GCHandler.Particles.get(Index).Sprite = new GCSprite("");
            GCHandler.Particles.get(Index).Sprite.ID = -1;
        }
        Main.logMain.repaint();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNewParticle = new javax.swing.JButton();
        btnLoadParticle = new javax.swing.JButton();
        lblFile = new javax.swing.JLabel();
        txtFile = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        cboSprite = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Particle Properties");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/pspconstructor/Images/Particle.png"))); // NOI18N

        btnNewParticle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pspconstructor/Images/New.png"))); // NOI18N
        btnNewParticle.setText("New Particle System");
        btnNewParticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewParticleActionPerformed(evt);
            }
        });

        btnLoadParticle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pspconstructor/Images/Open.png"))); // NOI18N
        btnLoadParticle.setText("Load Particle System");
        btnLoadParticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadParticleActionPerformed(evt);
            }
        });

        lblFile.setText("File:");

        txtFile.setEditable(false);
        txtFile.setAutoscrolls(false);

        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pspconstructor/Images/Check.png"))); // NOI18N
        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        cboSprite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Sprite" }));
        cboSprite.setMaximumSize(new java.awt.Dimension(136, 26));
        cboSprite.setMinimumSize(new java.awt.Dimension(136, 26));
        cboSprite.setPreferredSize(new java.awt.Dimension(136, 26));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLoadParticle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNewParticle, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(cboSprite, 0, 151, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFile, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                    .addComponent(btnOk, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNewParticle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoadParticle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboSprite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFile)
                    .addComponent(txtFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOk)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        setInfo();
        this.dispose();
}//GEN-LAST:event_btnOkActionPerformed

    private void btnNewParticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewParticleActionPerformed
        try {
            Runtime.getRuntime().exec("particleed/particleed.exe");
        } catch (IOException A) {
            JOptionPane.showMessageDialog(null, "Error finding/loading file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnNewParticleActionPerformed

    private void btnLoadParticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadParticleActionPerformed
        if (fchParticle.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File out = new File("./Source/Game/Game/Res/particle" + GCHandler.Particles.get(Index).ID + "." + IOHandler.getExtension(fchParticle.getSelectedFile()));
            try {
                IOHandler.copyFile(new File(fchParticle.getSelectedFile().getPath()), out);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            txtFile.setText(fchParticle.getSelectedFile().getName());
            txtFile.setEditable(false);
        }
    }//GEN-LAST:event_btnLoadParticleActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoadParticle;
    private javax.swing.JButton btnNewParticle;
    public javax.swing.JButton btnOk;
    public static javax.swing.JComboBox cboSprite;
    private javax.swing.JLabel lblFile;
    private javax.swing.JTextField txtFile;
    // End of variables declaration//GEN-END:variables
}

class psiFilter extends FileFilter {

    String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }

    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        String extension = getExtension(f);
        if (extension != null) {
            if (extension.equals("psi")) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public String getDescription() {
        return "Particles: '.psi'";
    }
}
class cboSpritePRenderer extends JLabel implements ListCellRenderer {

    public cboSpritePRenderer() {
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
        setPreferredSize(new Dimension(100, 24));
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        if (index == -1) {
            if (ParticleProperties.cboSprite.getSelectedIndex() == 0) {
                setIcon(new ImageIcon(new GCSprite("").Image.getImage().getScaledInstance(16, 16, Image.SCALE_AREA_AVERAGING)));
            } else {
                setIcon(new ImageIcon(GCHandler.Sprites.get(ParticleProperties.cboSprite.getSelectedIndex() - 1).Image.getImage().getScaledInstance(16, 16, Image.SCALE_AREA_AVERAGING)));
            }
            setText(String.valueOf(value));
        } else if (index == 0) {
            setIcon(new ImageIcon(new GCSprite("").Image.getImage().getScaledInstance(16, 16, Image.SCALE_AREA_AVERAGING)));
            setText(String.valueOf(value));
        } else {
            setIcon(new ImageIcon(GCHandler.Sprites.get(index - 1).Image.getImage().getScaledInstance(16, 16, Image.SCALE_AREA_AVERAGING)));
            setText(String.valueOf(value));
        }
        return this;
    }
}