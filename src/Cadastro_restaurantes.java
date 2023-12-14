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

        Font fonte = new Font("Arial", Font.BOLD, 40);

        Caixa_nome = new JTextField(20);
        Caixa_nome.setSize(249, 54);
        Caixa_nome.setLocation(646, 283);
        Caixa_nome.setFont(fonte);

        Caixa_CNPJ = new JTextField(14);
        Caixa_CNPJ.setSize(249, 54);
        Caixa_CNPJ.setLocation(646, 416);
        Caixa_CNPJ.setFont(fonte);

        Caixa_local = new JTextField(14);
        Caixa_local.setSize(249, 54);
        Caixa_local.setLocation(646, 549);
        Caixa_local.setFont(fonte);

        componente_botao Cadastrar = new componente_botao();
        Cadastrar.setBounds(643, 656, 249, 80);
        Cadastrar.setContentAreaFilled(false);

        componente_botao Voltar = new componente_botao();
        Voltar.setBounds(123, 656, 249, 80);
        Voltar.setContentAreaFilled(false);

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

        ImageIcon imagem = new ImageIcon("src/imagens/Cadastrar_restaurante.png");
        Image imagem_figma = imagem.getImage().getScaledInstance(1024, 768, Image.SCALE_DEFAULT);
        ImageIcon backgroud = new ImageIcon(imagem_figma);
        JLabel BG_imagem = new JLabel(backgroud);
        BG_imagem.setBounds(0, 0, 1024, 768);

        getContentPane().add(Caixa_CNPJ);
        getContentPane().add(Caixa_nome);
        getContentPane().add(Caixa_local);
        getContentPane().add(Cadastrar);
        getContentPane().add(Voltar);
        getContentPane().add(BG_imagem);
        BG_imagem.setVisible(true);
    }



}
