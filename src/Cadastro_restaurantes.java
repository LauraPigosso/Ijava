import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Cadastro_restaurantes extends JFrame {

     JTextField Caixa_nome;
     JTextField Caixa_CNPJ;
     JTextField Caixa_local;

    public Cadastro_restaurantes(ArrayList<Restaurante> lista_de_resutaurante, ArrayList<Usuario> lista_de_usuarios) {
        setTitle("Cadastro de restaurantes");
        setLocation(100, 100);
        setSize(1024, 768);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Font fonte = new Font("Arial", Font.BOLD, 22);

        Caixa_nome = new JTextField(20);
        Caixa_nome.setSize(249, 80);
        Caixa_nome.setLocation(150, 205);
        Caixa_nome.setFont(fonte);

        Caixa_CNPJ = new JTextField(14);
        Caixa_CNPJ.setSize(249, 80);
        Caixa_CNPJ.setLocation(300, 45);
        Caixa_CNPJ.setFont(fonte);

        Caixa_local = new JTextField(14);
        Caixa_local.setSize(249, 80);
        Caixa_local.setLocation(200, 350);
        Caixa_local.setFont(fonte);

        componente_botao Cadastrar = new componente_botao();
        Cadastrar.setBounds(550, 280, 80, 80);

        componente_botao Voltar = new componente_botao();
        Voltar.setBounds(60, 440, 100, 50);

        Cadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = Caixa_nome.getText();
                String cnpj = Caixa_CNPJ.getText();
                String local = Caixa_local.getText();
                Restaurante restaurante = new Restaurante(nome, cnpj, local);

                System.out.println("Restaurante cadastrado");
                lista_de_resutaurante.add(restaurante);

                Caixa_nome.setText("");
                Caixa_CNPJ.setText("");
                Caixa_local.setText("");

                new Cadastro_Lanches(lista_de_resutaurante, lista_de_usuarios, restaurante).setVisible(true);
                dispose();
            }
        });

        Voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        ImageIcon imagem = new ImageIcon("src/imagens/cadastrar_restaurante.png");
        Image imagemRedimensionada = imagem.getImage().getScaledInstance(800, 550, Image.SCALE_DEFAULT);
        ImageIcon imagemFinal = new ImageIcon(imagemRedimensionada);
        JLabel labelImagem = new JLabel(imagemFinal);
        labelImagem.setBounds(0,  0, 800, 500);

        getContentPane().add(Caixa_CNPJ);
        getContentPane().add(Caixa_nome);
        getContentPane().add(Caixa_local);
        getContentPane().add(Cadastrar);
        getContentPane().add(Voltar);
        getContentPane().add(labelImagem);

        labelImagem.setVisible(true);
    }



}
