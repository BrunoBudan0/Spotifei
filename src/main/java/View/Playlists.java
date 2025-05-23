
package View;

import Control.ControlPlaylist;
import Model.Playlist;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;
import java.util.ArrayList;

public class Playlists extends javax.swing.JFrame {

    public Playlists() {
        initComponents();
        setLocationRelativeTo(null); // Centraliza na tela
        
        modeloLista = new DefaultListModel<>();
        lista.setModel(modeloLista);
        
        playlists = new ArrayList<>();
        
        c = new ControlPlaylist(this);
        
        c.carregarPlaylists();//Carrega a playlist na tela
    }

    private List<Playlist> playlists;
    private DefaultListModel<String> modeloLista; 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        btVoltar = new javax.swing.JButton();
        btNewPlay = new javax.swing.JButton();
        btExcPlay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Playlists");

        jScrollPane1.setViewportView(lista);

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btNewPlay.setText("Nova Playlist");
        btNewPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewPlayActionPerformed(evt);
            }
        });

        btExcPlay.setText("Excluir Playlist");
        btExcPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcPlayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(107, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btNewPlay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btExcPlay)
                        .addGap(31, 31, 31)
                        .addComponent(btVoltar)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVoltar)
                    .addComponent(btNewPlay)
                    .addComponent(btExcPlay))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNewPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewPlayActionPerformed
        this.setVisible(false);
        NewPlaylist tl = new NewPlaylist();
        tl.setVisible(true);
    }//GEN-LAST:event_btNewPlayActionPerformed

    private void btExcPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcPlayActionPerformed
        int indice = lista.getSelectedIndex();
        c.excluirPlaylistSelecionada(indice);
    }//GEN-LAST:event_btExcPlayActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.setVisible(false);
        Home tl = new Home();
        tl.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    public void setPlaylists(List<Playlist> playlists){
        this.playlists = playlists;
    }
    public List<Playlist> getPlaylists(){
        return playlists;
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
    public void recarregarPlaylist(){
        if(c != null) {
            c.carregarPlaylists();
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
    
    private ControlPlaylist c;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcPlay;
    private javax.swing.JButton btNewPlay;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lista;
    // End of variables declaration//GEN-END:variables
}
