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
        Volatr.setBounds(26, 632, 249, 80);
        Volatr.setContentAreaFilled(false);

        componente_botao Proxima = new componente_botao();
        Proxima.setBounds(26, 490, 249, 80);
        Proxima.setContentAreaFilled(false);

        componente_botao botaoOk = new componente_botao();
        botaoOk.setBounds(585, 632, 192, 80);

        String[] lista_de_itens = Arrays.stream(restaurante.cardapio.toArray()).map(n -> getLancheNome((Lanche) n)).toArray(String[]::new);

        JComboBox<String> dropdownProdutos = new JComboBox<>(lista_de_itens);
        dropdownProdutos.setBounds(467, 230, 428, 94);

        Mais = new componente_botao();
        Mais.setBounds(910, 240, 80, 80);
        Mais.setContentAreaFilled(false);

        Menos = new componente_botao();
        Menos.setBounds(910, 233, 80, 80);
        Menos.setContentAreaFilled(false);

        labelQtdProdutoAtual = new componente_label();
        labelQtdProdutoAtual.setBounds(623, 434, 122, 80);

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
            }
        });

        Mais.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        Menos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        ImageIcon imagem = new ImageIcon("src/imagens/Cardapio.png");
        Image imagem_figma = imagem.getImage().getScaledInstance(1024, 768, Image.SCALE_DEFAULT);
        ImageIcon backgroud = new ImageIcon(imagem_figma);
        JLabel BG_imagem = new JLabel(backgroud);
        BG_imagem.setBounds(0, 0, 1024, 768);

        getContentPane().add(Volatr);
        getContentPane().add(Proxima);
        getContentPane().add(botaoOk);
        getContentPane().add(Caixa_total_de_itens);
        getContentPane().add(Mais);
        getContentPane().add(Menos);
        getContentPane().add(labelQtdProdutoAtual);
        getContentPane().add(dropdownProdutos);
        getContentPane().add(BG_imagem);
        BG_imagem.setVisible(true);
    }
}
