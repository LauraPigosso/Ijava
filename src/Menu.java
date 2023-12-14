import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Menu  extends JFrame {
     JButton Mais;
     JButton Menos;
     JLabel caixa_total;
     JLabel valor;
    String getLancheNome(Lanche lanche){
        return lanche.nome + " - R$ " + lanche.preco;
    }

    public Menu(Restaurante restaurante, Usuario usuario){
        setTitle("Cardapio");
        setBounds(100, 100, 1024, 768);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        int quantidadeProduto = 0;
        int quantidadeTotal = 0;

        ArrayList<Lanche> pedido = new ArrayList<>();


        componente_botao botaoVoltar = new componente_botao();
        botaoVoltar.setBounds(24, 632, 249, 80);


        componente_botao proximo = new componente_botao();
        proximo.setBounds(24, 490, 249, 80);

        componente_botao adicionar = new componente_botao();
        adicionar.setBounds(24, 348, 249, 80);

        String[] cardapio_cheio = Arrays.stream(restaurante.cardapio.toArray()).map(n -> getLancheNome((Lanche) n)).toArray(String[]::new);

        JComboBox<String> Caixa_lanches = new JComboBox<>(cardapio_cheio);
        Caixa_lanches.setBounds(448, 230, 414, 135);

        Mais = new componente_botao();
        Mais.setBounds(873, 269, 50, 50);

        Menos = new componente_botao();
        Menos.setBounds(359, 269, 50, 50);

        valor = new componente_label();
        valor.setBounds(512, 455, 191, 100);
        valor.setText("" + quantidadeProduto);

        caixa_total = new componente_label();
        caixa_total.setBounds(678, 576, 191, 100);
        caixa_total.setText("" + quantidadeTotal);

        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        proximo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new tela_Finalizar(restaurante, usuario, pedido).setVisible(true);
                dispose();
            }
        });

        adicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int quantidadeAadicionar = Integer.parseInt(valor.getText());
                String nomeProduto = cardapio_cheio[Caixa_lanches.getSelectedIndex()].split(" - ")[0];
                Lanche lanche = null;

                for (Lanche _lanche : restaurante.cardapio) {
                    if (_lanche.nome.equals(nomeProduto)){
                        lanche = _lanche;
                    }
                }

                for (int i = 0; i < quantidadeAadicionar; i++) {
                    pedido.add(new Lanche(lanche.nome, lanche.preco));
                }

                caixa_total.setText("" + (pedido.size()));
                valor.setText("" + 0);
            }
        });

        Mais.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                valor.setText("" + (Integer.parseInt(valor.getText())+1));

            }
        });

        Menos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                valor.setText("" + (Integer.parseInt(valor.getText())-1));

            }
        });

        ImageIcon imagem = new ImageIcon("src/imagens/cardapio.png");
        Image imagemRedimensionada = imagem.getImage().getScaledInstance(1024, 768, Image.SCALE_DEFAULT);
        ImageIcon imagemFinal = new ImageIcon(imagemRedimensionada);
        JLabel labelImagem = new JLabel(imagemFinal);
        labelImagem.setBounds(0,  0, 1024, 768);

        getContentPane().add(botaoVoltar);
        getContentPane().add(proximo);
        getContentPane().add(adicionar);
        getContentPane().add(caixa_total);
        getContentPane().add(Mais);
        getContentPane().add(Menos);
        getContentPane().add(valor);
        getContentPane().add(Caixa_lanches);
        getContentPane().add(labelImagem);
        labelImagem.setVisible(true);
    }

}
