package View;

import Control.ControlMusica;
import Control.TipoTela;
import Model.Playlist;
import Model.Musica;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import java.util.List;
import java.util.ArrayList;

public class PlaylistMusica extends javax.swing.JFrame {
    
    private Playlist playlistAtual;
    private List<Musica> musicas;
    private DefaultListModel<String> modeloLista;
    private ControlMusica c;
    
    public PlaylistMusica() {
        initComponents();
        setLocationRelativeTo(null);
        inicializarComponentes();
    }
    
    // Novo construtor que recebe a playlist
    public PlaylistMusica(Playlist playlist) {
        initComponents();
        setLocationRelativeTo(null);
        this.playlistAtual = playlist;
        inicializarComponentes();
        
        // Configure o nome da playlist na label
        if (playlist != null) {
            lblNomePlay.setText(playlist.getNomePlaylist());
            this.setTitle("Playlist: " + playlist.getNomePlaylist());
        }
    }
    
    //Utilizando para chamar nos dois construtores
    private void inicializarComponentes() {
        
        modeloLista = new DefaultListModel<>();
        lista.setModel(modeloLista);
        
        
        musicas = new ArrayList<>();
        //Utilizando novo tipo de tela
        c = new ControlMusica(this, TipoTela.PLAYLIST_MUSICA);
        

        if (playlistAtual != null) {
            c.carregarMusicasPlaylist();
        }
    }

    public JLabel getLblNomePlay() {
        return lblNomePlay;
    }

    public void setLblNomePlay(JLabel lblNomePlay) {
        this.lblNomePlay = lblNomePlay;
    }
    
    // Getters e Setters para a playlist atual
    public Playlist getPlaylistAtual() {
        return playlistAtual;
    }
    
    public void setPlaylistAtual(Playlist playlistAtual) {
        this.playlistAtual = playlistAtual;
        if (playlistAtual != null) {
            lblNomePlay.setText(playlistAtual.getNomePlaylist());
            this.setTitle("Playlist: " + playlistAtual.getNomePlaylist());
            if (c != null) {
                c.carregarMusicasPlaylist();
            }
        }
    }
    
    // Método para obter o ID da playlist atual
    public Integer getIdPlaylistAtual() {
        return playlistAtual != null ? playlistAtual.getIdPlaylist() : null;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btVoltar = new javax.swing.JButton();
        lblNomePlay = new javax.swing.JLabel();
        btDescurtir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btDescurtir.setText("Remover");
        btDescurtir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDescurtirActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(btDescurtir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btVoltar)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblNomePlay, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblNomePlay)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDescurtir)
                    .addComponent(btVoltar))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.setVisible(false);
        Playlists tl = new Playlists();
        tl.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btDescurtirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDescurtirActionPerformed
         int indice = lista.getSelectedIndex();
         c.removerMusicaPlaylistSelecionada(indice); 
    }//GEN-LAST:event_btDescurtirActionPerformed
    
    // Métodos para gerenciar a lista de músicas
    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }
    
    public List<Musica> getMusicas() {
        return musicas;
    }
    
    public void limparLista() {
        if (modeloLista != null) {
            modeloLista.clear();
        }
    }
    
    public void adicionarItemLista(String item) {
        if (modeloLista != null) {
            modeloLista.addElement(item);
        }
    }
    
    public void atualizarInterface() {
        if (lista != null) {
            lista.revalidate();
            lista.repaint();
        }
    }
    
    public void recarregarMusicas() {
        if (c != null) {
            c.carregarMusicasPlaylist();
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
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDescurtir;
    private javax.swing.JButton btVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNomePlay;
    private javax.swing.JList<String> lista;
    // End of variables declaration//GEN-END:variables
}
