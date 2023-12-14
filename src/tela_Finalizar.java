

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

        componente_botao Voltar = new componente_botao();
        Voltar.setBounds(24, 632, 249, 80);
        Voltar.setContentAreaFilled(false);

        componente_botao finalizar = new componente_botao();
        finalizar.setBounds(24, 490, 249, 80);
        finalizar.setContentAreaFilled(false);
        Voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        Label nome_do_Restaurante = new Label();
        nome_do_Restaurante.setBounds(574, 263, 500, 45);
        nome_do_Restaurante.setText(restaurante.nome.toUpperCase());

        Label nome_do_Cliente = new Label();
        nome_do_Cliente.setBounds(623, 396, 500, 45);
        nome_do_Cliente.setText(usuario.nome.toUpperCase());

        Label total = new Label();
        total.setBounds(614, 580, 286, 95);

        double total_do_pedido = 0;
        for (Lanche lanche : lista_de_itens) {
            total_do_pedido = lanche.preco + total_do_pedido;
        }
        total.setText("R$" + total_do_pedido + "0");

        double valor_total_final = total_do_pedido;
        finalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("_____________________________________________________");
                System.out.println("Total..........................R$" + valor_total_final);
                System.out.println("Restaurante: " + restaurante.nome.toUpperCase());
                System.out.println("lanches........................valor");
                String seila = "...............................";
                for (Lanche lanche: lista_de_itens) {
                    String saida_nota = lanche.nome;
                    saida_nota += seila.substring(0, seila.length() - saida_nota.length());
                    System.out.println(saida_nota + "R$" + lanche.preco);
                }
                System.out.println("_____________________________________________________");
            }
        });

        ImageIcon imagem = new ImageIcon("src/imagens/Nota.png");
        Image imagem_figma = imagem.getImage().getScaledInstance(1024, 768, Image.SCALE_DEFAULT);
        ImageIcon backgroud = new ImageIcon(imagem_figma);
        JLabel BG_imagem = new JLabel(backgroud);
        BG_imagem.setBounds(0, 0, 1024, 768);

        getContentPane().add(Voltar);
        getContentPane().add(nome_do_Restaurante);
        getContentPane().add(nome_do_Cliente);
        getContentPane().add(total);
        getContentPane().add(finalizar);
        getContentPane().add(BG_imagem);
        BG_imagem.setVisible(true);
    }
}
