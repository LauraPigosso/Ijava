import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Cadastro_Lanches extends JFrame {

    JTextField Caixa_nome;
    JTextField Caixa_preco;

    public Cadastro_Lanches(ArrayList<Restaurante> lista_de_resutaurante, ArrayList<Usuario> lista_de_usuarios, Restaurante escolhido) {
        setTitle("Cadastre seus lanches");
        setLocation(100, 100);
        setSize(1024, 768);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Font fonte = new Font("Arial", Font.BOLD, 22);

        Caixa_nome = new JTextField(20);
        Caixa_nome.setBounds(150, 205, 300, 45);
        Caixa_nome.setFont(fonte);

        Caixa_preco = new JTextField(14);
        Caixa_preco.setBounds(150, 280, 300, 45);
        Caixa_preco.setFont(fonte);

        componente_botao Cadastrar = new componente_botao();
        Cadastrar.setBounds(550, 280, 80, 80);

        componente_botao Finalizar = new componente_botao();
        Finalizar.setBounds(60, 440, 100, 50);

        Cadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = Caixa_nome.getText();
                String preco = Caixa_preco.getText();

                System.out.println("lanche cadastrado com sucesso");
                escolhido.cardapio.add(new Lanche(nome, Double.parseDouble(preco)));

                Caixa_nome.setText("");
                Caixa_preco.setText("");

                Timer timer = new Timer(1500, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        });

        Finalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Pedidos(lista_de_resutaurante, lista_de_usuarios).setVisible(true);
                dispose();
            }
        });

        ImageIcon imagem = new ImageIcon("src/imagens/Cadastrar_lanche.png");
        Image imagem_figma = imagem.getImage().getScaledInstance(1024, 768, Image.SCALE_DEFAULT);
        ImageIcon backgroud = new ImageIcon(imagem_figma);
        JLabel BG_imagem = new JLabel(backgroud);
        BG_imagem.setBounds(0, 0, 1024, 768);

        getContentPane().add(Caixa_preco);
        getContentPane().add(Caixa_nome);
        getContentPane().add(Cadastrar);
        getContentPane().add(Finalizar);
        getContentPane().add(BG_imagem);
        BG_imagem.setVisible(true);
    }
}
