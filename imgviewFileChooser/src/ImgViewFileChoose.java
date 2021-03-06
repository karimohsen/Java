
import java.awt.Button;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ImgViewFileChoose.java
 *
 * Created on Jan 13, 2015, 1:05:55 PM
 */
/**
 *
 * @author Karim
 */
public class ImgViewFileChoose extends javax.swing.JFrame {

    Button b = new Button("...");
    String file_path = "";

    /** Creates new form ImgViewFileChoose */
    public ImgViewFileChoose() {
        initComponents();
        jScrollPane1.setCorner(JScrollPane.LOWER_RIGHT_CORNER, b);
        b.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JFileChooser jfile = new JFileChooser();

                class FileFiltering extends FileFilter {

                    @Override
                    public boolean accept(File f) {
                        if ((f.getName().toLowerCase().endsWith(".jpg")) || (f.getName().toLowerCase().endsWith(".gif")) || (f.isDirectory())) {
                            return true;
                        } else {
                            return false;
                        }

                    }

                    @Override
                    public String getDescription() {

                        return ".Jpg & .Gif Files";

                    }
                }
                class FileViewer extends FileView {

                    @Override
                    public Icon getIcon(File f) {
                        if ((f.getName().toLowerCase().endsWith(".jpg")) || (f.getName().toLowerCase().endsWith(".gif"))) {
                            Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Karim\\Desktop\\imgtest.jpg").getScaledInstance(32, 32, Image.SCALE_SMOOTH);
                            ImageIcon icon = new ImageIcon(img);
                            return icon;
                        } else {
                            return null;
                        }
                    }
                }
                jfile.setFileFilter(new FileFiltering());
                jfile.setFileView(new FileViewer());
                int choice = jfile.showOpenDialog(ImgViewFileChoose.this);

                if (choice == JFileChooser.APPROVE_OPTION) {
                    file_path = jfile.getSelectedFile().getAbsolutePath();

                }
                if (file_path != null) {
                    Image img = Toolkit.getDefaultToolkit().getImage(file_path);
                    ImageIcon icon = new ImageIcon(img);
                    jScrollPane1.setViewportView(new JLabel(icon));
                }
            }
        });

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ImgViewFileChoose().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
