package tela;

import banco.GerenciaCadastro;
import dados.Livro;
import javax.swing.JOptionPane;

public class FrmCadastro extends javax.swing.JFrame
{
    GerenciaCadastro objCad = new GerenciaCadastro();
    Livro crudLivro = new Livro();
    
    public FrmCadastro()
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCadastrar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCadastrar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setName(""); // NOI18N
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnConsultar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConsultar)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btnCadastrar)
                .addGap(18, 18, 18)
                .addComponent(btnConsultar)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir)
                .addGap(18, 18, 18)
                .addComponent(btnAlterar)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed

        crudLivro.setTitulo(JOptionPane.showInputDialog("Informe o título do livro que será cadastrado:"));
        crudLivro.setAutor(JOptionPane.showInputDialog("Informe o nome do autor do livro:"));
        crudLivro.setGenero(JOptionPane.showInputDialog("Informe o gênero do livro:"));
        crudLivro.setAnopublicacao(Integer.parseInt(JOptionPane.showInputDialog("Informe o ano de publicação do livro:")));

        if(objCad.cadastraLivro(crudLivro) == 1)
        {
            JOptionPane.showMessageDialog(null,"Cadastro efetuado com sucesso");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Cadastro não realizado");
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed

        crudLivro.setTitulo(JOptionPane.showInputDialog("Digite o tíulo do livro a ser pesquisado"));

        if(true == objCad.consultaLivro(crudLivro)){
            JOptionPane.showMessageDialog(null,"O livro " + crudLivro.getTitulo()+ " está cadastrado no banco de dados");
        }
        else{
            JOptionPane.showMessageDialog(null,"O livro " + crudLivro.getTitulo() + " não está cadastrado no banco de dados");
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        crudLivro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o código do livro que será excluído")));

        if(objCad.excluir(crudLivro) == 1)
        {
            JOptionPane.showMessageDialog(null," Exclusão realizada com sucesso no banco de dados");
        }
        else
        {
            JOptionPane.showMessageDialog(null," Erro de exclusão");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed

        crudLivro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o código do livro que será alterado:")));
        crudLivro.setTitulo(JOptionPane.showInputDialog("Digite o novo titulo:"));
        crudLivro.setAutor(JOptionPane.showInputDialog("Digite o novo nome do autor:"));
        crudLivro.setGenero(JOptionPane.showInputDialog("Digite o novo genero do livro:"));
        crudLivro.setAnopublicacao(Integer.parseInt(JOptionPane.showInputDialog("Digite o novo ano da publicação do livro:")));

        int resposta = objCad.alterarLivro(crudLivro);

        switch (resposta)
        {
            case 0:
                JOptionPane.showMessageDialog(null,"Erro de alteração");
                break;

            case 1:
                JOptionPane.showMessageDialog(null,"Alteração realizada com sucesso");
                break;

            default:
                JOptionPane.showMessageDialog(null,"Operação cancelada pelo o usuario");
                break;
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new FrmCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    // End of variables declaration//GEN-END:variables
}