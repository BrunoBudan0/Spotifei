
package View;

import Control.ControlMusica;
import Model.Musica;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class CurtidasMusicas extends javax.swing.JFrame {

    public CurtidasMusicas() {
        initComponents();
        
        modeloLista = new DefaultListModel<>();
        lista.setModel(modeloLista);
        musicas = new ArrayList<>();
        
        c = new ControlMusica(this);
        c.carregarMusicasCurtidas();
        setLocationRelativeTo(null); // Centraliza na tela
    }

    private List<Musica> musicas;
     private DefaultListModel<String> modeloLista; 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        btVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btDescurtir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(lista);

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        jLabel1.setText("Musicas Curtidas ❤️");

        btDescurtir.setText("Descurtir");
        btDescurtir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDescurtirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(225, 225, 225))))
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(btDescurtir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btVoltar)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDescurtir)
                    .addComponent(btVoltar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.setVisible(false);
        Home tl = new Home();
        tl.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btDescurtirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDescurtirActionPerformed
        int indice = lista.getSelectedIndex();
        c.descurtirMusicaSelecionada(indice);
    }//GEN-LAST:event_btDescurtirActionPerformed
    public void setMusicas(List<Musica> musicas){
        this.musicas = musicas;
    }
    public List<Musica> getMusicas(){
        return musicas;
    }
    public void limparLista(){
        if (modeloLista != null){
            modeloLista.clear();
        }
    }
    public void adicionarItemLista(String item) {
        if(modeloLista != null){
            modeloLista.addElement(item);
        }
    }
    public void atualizarInterface(){
        if (lista != null) {
            lista.revalidate();
            lista.repaint();
        }
    }
    public void recarregarMusicas(){
        if(c != null) {
            c.carregarMusicasCurtidas();
        }
    }

    public JList<String> getLista() {
        return lista;
    }

    public void setLista(JList<String> lista) {
        this.lista = lista;
    }
    
     public DefaultListModel<String> getModeloLista() {
        return modeloLista;
    }
    
    private ControlMusica c;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDescurtir;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lista;
    // End of variables declaration//GEN-END:variables
}
