import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Menu extends JFrame {
    JButton Mais;
    JButton Menos;
    JLabel Caixa_total_de_itens;
    JLabel labelQtdProdutoAtual;

    String getLancheNome(Lanche lanche) {
        return lanche.nome + " - R$ " + lanche.preco;
    }

    public Menu(Restaurante restaurante, Usuario usuario) {
        setTitle("Menu");
        setLocation(100, 100);
        setSize(1024, 768);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        ArrayList<Lanche> pedido = new ArrayList<>();

        componente_botao Volatr = new componente_botao();
        Volatr.setBounds(60, 440, 100, 50);

        componente_botao Proxima = new componente_botao();
        Proxima.setBounds(700, 50, 50, 50);

        componente_botao botaoOk = new componente_botao();
        botaoOk.setBounds(584, 122, 52, 55);

        String[] lista_de_itens = Arrays.stream(restaurante.cardapio.toArray()).map(n -> getLancheNome((Lanche) n)).toArray(String[]::new);

        JComboBox<String> dropdownProdutos = new JComboBox<>(lista_de_itens);
        dropdownProdutos.setBounds(230, 120, 200, 30);

        Mais = new componente_botao();
        Mais.setBounds(446, 125, 50, 50);

        Menos = new componente_botao();
        Menos.setBounds(154, 125, 50, 50);

        labelQtdProdutoAtual = new componente_label();
        labelQtdProdutoAtual.setBounds(535, 120, 60, 40);

        Caixa_total_de_itens = new componente_label();
        Caixa_total_de_itens.setBounds(540, 380, 91, 64);

        Volatr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        Proxima.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new tela_Finalizar(restaurante, usuario, pedido).setVisible(true);
                dispose();
            }
        });

        botaoOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para adicionar itens ao pedido...
            }
        });

        Mais.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para aumentar a quantidade...
            }
        });

        Menos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para diminuir a quantidade...
            }
        });

        ImageIcon imagem = new ImageIcon("src/imagens/cardapio.png");
        Image imagemRedimensionada = imagem.getImage().getScaledInstance(800, 550, Image.SCALE_DEFAULT);
        ImageIcon imagemFinal = new ImageIcon(imagemRedimensionada);
        JLabel labelImagem = new JLabel(imagemFinal);
        labelImagem.setBounds(0, 0, 800, 500);

        getContentPane().add(Volatr);
        getContentPane().add(Proxima);
        getContentPane().add(botaoOk);
        getContentPane().add(Caixa_total_de_itens);
        getContentPane().add(Mais);
        getContentPane().add(Menos);
        getContentPane().add(labelQtdProdutoAtual);
        getContentPane().add(dropdownProdutos);
        getContentPane().add(labelImagem);

        labelImagem.setVisible(true);
    }
}
