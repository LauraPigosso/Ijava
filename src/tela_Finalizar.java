

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class tela_Finalizar extends JFrame {
    public tela_Finalizar(Restaurante restaurante, Usuario usuario, ArrayList<Lanche> lista_de_itens){
        setTitle("finalizar");
        setLocation(100, 100);
        setSize(1024, 768);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        componente_botao botaoVoltar = new componente_botao();
        botaoVoltar.setBounds(50, 430, 100, 50);

        componente_botao botaoImprimirNotaFiscal = new componente_botao();
        botaoImprimirNotaFiscal.setBounds(130, 305, 215, 40);
        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        Label nomeRestaurante = new Label();
        nomeRestaurante.setBounds(260, 70, 310, 45);
        nomeRestaurante.setText(restaurante.nome.toUpperCase());

        Label nomeCliente = new Label();
        nomeCliente.setBounds(200, 120, 310, 45);
        nomeCliente.setText(usuario.nome.toUpperCase());

        Label total = new Label();
        total.setBounds(150, 204, 293, 83);

        double totalPedido = 0;
        for (Lanche lanche : lista_de_itens) {
            totalPedido = lanche.preco + totalPedido;
        }
        total.setText("R$" + totalPedido + "0");

        double finalTotalPedido = totalPedido;
        botaoImprimirNotaFiscal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                System.out.println("Nota fiscal de: " + restaurante.nome.toUpperCase());
                System.out.println("PRODUTO........................PREÇO");
                String seila = "...............................";
                for (Lanche lanche: lista_de_itens) {
                    String saida_nota = lanche.nome;
                    saida_nota += seila.substring(0, seila.length() - saida_nota.length());
                    System.out.println(saida_nota + "R$" + lanche.preco);
                }
                System.out.println("TOTAL..........................R$" + finalTotalPedido);
                System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            }
        });

        getContentPane().add(botaoVoltar);
        getContentPane().add(nomeRestaurante);
        getContentPane().add(nomeCliente);
        getContentPane().add(total);
        getContentPane().add(botaoImprimirNotaFiscal);

        ImageIcon imagem = new ImageIcon("src/imagens/tela_finalizar.png");
        Image imagem_figma = imagem.getImage().getScaledInstance(1024, 768, Image.SCALE_DEFAULT);
        ImageIcon backgroud = new ImageIcon(imagem_figma);
        JLabel BG_imagem = new JLabel(backgroud);
        BG_imagem.setBounds(0, 0, 1024, 768);

        getContentPane().add(BG_imagem);
        BG_imagem.setVisible(true);
    }
}
