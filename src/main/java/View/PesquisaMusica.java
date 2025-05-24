
package View;

import Control.ControlMusica;
import Model.Musica;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

public class PesquisaMusica extends javax.swing.JFrame {

    public PesquisaMusica() {
        initComponents();
        
        modeloLista = new DefaultListModel<>();
        lista.setModel(modeloLista);
        musicas = new ArrayList<>();
        
        c = new ControlMusica(this);
        setLocationRelativeTo(null); // Centraliza na tela
    }

    public JTextField getTxtPesquisa() {
        return txtPesquisa;
    }

    public void setTxtPesquisa(JTextField txtPesquisa) {
        this.txtPesquisa = txtPesquisa;
    }
    
    
     private List<Musica> musicas;
     private DefaultListModel<String> modeloLista; 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        txtPesquisa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btBusca = new javax.swing.JButton();
        btCurtir = new javax.swing.JButton();
        btAddPlay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        jLabel1.setText("Musicas");

        jScrollPane1.setViewportView(lista);

        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });

        jLabel2.setText("🔍");

        btBusca.setText("buscar");
        btBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscaActionPerformed(evt);
            }
        });

        btCurtir.setText("Curtir");
        btCurtir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCurtirActionPerformed(evt);
            }
        });

        btAddPlay.setText("Adicionar a playlist");
        btAddPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddPlayActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btCurtir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btAddPlay)
                                .addGap(29, 29, 29)))
                        .addComponent(btVoltar)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btBusca)
                        .addGap(59, 59, 59))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(btVoltar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btBusca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCurtir)
                            .addComponent(btAddPlay))
                        .addGap(24, 24, 24))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.setVisible(false);
        Home tl = new Home();
        tl.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed

    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void btBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscaActionPerformed
        c.carregarMusicas(getTxtPesquisa().getText());
    }//GEN-LAST:event_btBuscaActionPerformed

    private void btCurtirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCurtirActionPerformed
        int indice = lista.getSelectedIndex();
        c.curtirMusicaSelecionada(indice);
    }//GEN-LAST:event_btCurtirActionPerformed

    private void btAddPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddPlayActionPerformed
        int indice = lista.getSelectedIndex();
    
    if (indice >= 0 && indice < musicas.size()) {
        // Obter a música selecionada
        Musica musicaSelecionada = musicas.get(indice);
        
        this.setVisible(false);
        AddPlaylists addPlaylistsView = new AddPlaylists(musicaSelecionada);
        addPlaylistsView.setVisible(true);
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Selecione uma música para adicionar à playlist", 
            "Aviso", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btAddPlayActionPerformed
    
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
            c.atualizarListaMusicas(musicas);
        }
    }

    public DefaultListModel<String> getModeloLista() {
        return modeloLista;
    }

    public JList<String> getLista() {
        return lista;
    }

    public void setLista(JList<String> lista) {
        this.lista = lista;
    }

    private ControlMusica c;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddPlay;
    private javax.swing.JButton btBusca;
    private javax.swing.JButton btCurtir;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lista;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
