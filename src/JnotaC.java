
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2830482321037
 */
public class JnotaC extends javax.swing.JFrame {

    /**
     * Creates new form notaEntrada
     */
    public JnotaC() {
        initComponents(); 
        carregarClientesNaComboBox();  
        carregarProdutosNaComboBox(); 
     modeloTabela = new javax.swing.table.DefaultTableModel(
    new Object[][] {},
    new String[] { "Cliente", "Produto", "Preço ", "Quantidade", "Data", "Valor Total (R$)" }
);
Jtable.setModel(modeloTabela);
   
    }   
    
    


     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        Jproduto = new javax.swing.JComboBox();
        txtQuantidade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jtable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("NOTA");

        jButton1.setText("VOLTAR");

        jButton2.setText("INSERIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Jtable);

        jButton3.setText("Cadastrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Jproduto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jButton2)
                .addGap(93, 93, 93)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(121, 121, 121))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                                         
    try {
        Cliente clienteSelecionado = (Cliente) jComboBox1.getSelectedItem();
        Produto produtoSelecionado = (Produto) Jproduto.getSelectedItem();
        int quantidade = Integer.parseInt(txtQuantidade.getText());

        if (quantidade <= 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Quantidade deve ser maior que zero.");
            return;
        }

// Pegando a data atual
String dataAtual = java.time.LocalDate.now().toString(); // formato: yyyy-MM-dd

// Calculando valor total
double peso = produtoSelecionado.getPeso(); // certifique-se que a classe Produto tem getPreco()
double valorTotal = peso * quantidade;

modeloTabela.addRow(new Object[] {
    clienteSelecionado.getNome(),
    produtoSelecionado.getNome(),
    produtoSelecionado.getPeso(),
    quantidade,
    dataAtual,
    String.format("R$ %.2f", valorTotal)

});

    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Digite um número válido para a quantidade.");
    } catch (NullPointerException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Selecione um cliente e um produto.");
    
}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                                        
    try {
        // Criar objeto nota
        notaC nota = new notaC();
        nota.setData(java.time.LocalDate.now().toString());

        // Calcular valor total da tabela
        float total = 0;
        for (int i = 0; i < modeloTabela.getRowCount(); i++) {
            String valorStr = modeloTabela.getValueAt(i, 5).toString()
                                .replace("R$", "")
                                .trim()
                                .replace(",", ".");
            total += Float.parseFloat(valorStr);
        }
        nota.setVlrTotal(total);

        // Inserir no banco só a nota com data e valor total
        notaCDAO daoNota = new notaCDAO();
        int notaId = daoNota.inserir(nota); // retorna o ID, mas não usa ainda

        javax.swing.JOptionPane.showMessageDialog(this, "Nota cadastrada com sucesso! ID: " + notaId);

        // Limpar a tabela para nova entrada
        modeloTabela.setRowCount(0);
        txtQuantidade.setText("");

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao cadastrar nota: " + e.getMessage());
    }



    }//GEN-LAST:event_jButton3ActionPerformed
private void carregarClientesNaComboBox() {
    ClienteDAO dao = new ClienteDAO();
    List<Cliente> clientes = dao.listarClientes();
    jComboBox1.removeAllItems(); // Limpa antes
    for (Cliente c : clientes) {
        jComboBox1.addItem(c);
    }
} 
private void carregarProdutosNaComboBox() {
    ProdutoDAO dao = new ProdutoDAO();
    List<Produto> produtos = dao.listarProdutos();
    Jproduto.removeAllItems();
    for (Produto p : produtos) {
        Jproduto.addItem(p);
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JnotaC().setVisible(true);
            }
        });
    }
private javax.swing.JTable tabelaNota;
private javax.swing.table.DefaultTableModel modeloTabela;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Jproduto;
    private javax.swing.JTable Jtable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
