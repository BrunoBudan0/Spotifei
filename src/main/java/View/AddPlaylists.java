
package View;

import Control.ControlPlaylist;
import Model.Musica;
import Model.Playlist;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JLabel;

public class AddPlaylists extends javax.swing.JFrame {

    public AddPlaylists() {
        initComponents();
        inicializar();
    }
    
    // Constructor que recebe a música selecionada
    public AddPlaylists(Musica musica) {
        this.musicaSelecionada = musica;
        initComponents();
        inicializar();
        
        // Exibir informações da música selecionada
        if (musica != null) {
            lblNomeMusica.setText(musica.getNomeMusic());
            this.setTitle("Adicionar à Playlist: " + musica.getNomeMusic());
        }
    }
    
    private void inicializar() {
        setLocationRelativeTo(null); // Centraliza na tela
        
        modeloLista = new DefaultListModel<>();
        lista.setModel(modeloLista);
        
        playlists = new ArrayList<>();
        
        c = new ControlPlaylist(this);
        
        // Carregar playlists do usuário
        c.carregarPlaylists();
    }

    public JLabel getLblNomeMusica() {
        return lblNomeMusica;
    }

    public void setLblNomeMusica(JLabel lblNomeMusica) {
        this.lblNomeMusica = lblNomeMusica;
    }
    
    private Musica musicaSelecionada;
    private List<Playlist> playlists;
    private DefaultListModel<String> modeloLista;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        lblNomeMusica = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        jLabel1.setText("📁 Adicionar a Playlists");

        jScrollPane1.setViewportView(lista);

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(102, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(btVoltar)
                        .addGap(22, 22, 22))))
            .addGroup(layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(lblNomeMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(lblNomeMusica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btVoltar)
                    .addComponent(jButton1))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (musicaSelecionada == null) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Nenhuma música foi selecionada", 
                "Erro", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int indice = lista.getSelectedIndex();
        Playlist playlistSelecionada = c.obterPlaylistSelecionada(indice);
        
        if (playlistSelecionada != null) {
            boolean sucesso = c.adicionarMusicaAPlaylist(musicaSelecionada, playlistSelecionada);
            
            if (sucesso) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Música adicionada à playlist com sucesso!", 
                    "Sucesso", 
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
                
                // Voltar para a tela de pesquisa
                this.setVisible(false);
                PesquisaMusica pesquisaView = new PesquisaMusica();
                pesquisaView.setVisible(true);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Selecione uma playlist", 
                "Aviso", 
                javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public Playlist getPlaylistSelecionada() {
        int indice = lista.getSelectedIndex();
        return c.obterPlaylistSelecionada(indice);
    }
    
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
    private javax.swing.JButton btVoltar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNomeMusica;
    private javax.swing.JList<String> lista;
    // End of variables declaration//GEN-END:variables
}
