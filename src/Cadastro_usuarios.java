import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Cadastro_usuarios extends JFrame {
     JTextField Caixa_nome;
     JTextField Caixa_CPF;
     JTextField Caixa_endereco;
     JButton botaoCadastrar;
    public Cadastro_usuarios(ArrayList<Restaurante> lista_de_resutaurante, ArrayList<Usuario> lista_de_usuarios) {
        setTitle("Cadastro de usuários");
        setLocation(100, 100);
        setSize(1024, 768);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Font fonte = new Font("Arial", Font.BOLD, 24);

        Caixa_nome = new JTextField(20);
        Caixa_nome.setBounds(150, 205, 300, 45);
        Caixa_nome.setFont(fonte);

        Caixa_CPF = new JTextField(14);
        Caixa_CPF.setBounds(150, 280, 300, 45);
        Caixa_CPF.setFont(fonte);

        Caixa_endereco = new JTextField(14);
        Caixa_endereco.setBounds(200, 350, 250, 45);
        Caixa_endereco.setFont(fonte);

        componente_botao Cadastrar = new componente_botao();
        Cadastrar.setBounds(550, 280, 80, 80);

        componente_botao Voltar = new componente_botao();
        Voltar.setBounds(60, 440, 100, 50);

        Cadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = Caixa_nome.getText();
                String cpf = Caixa_CPF.getText();
                String endereço = Caixa_endereco.getText();

                lista_de_usuarios.add(new Usuario(nome, cpf, endereço));

                System.out.println("Cliente cadastrado com sucesso");

                Caixa_nome.setText("");
                Caixa_CPF.setText("");
                Caixa_endereco.setText("");

                new Pedidos(lista_de_resutaurante, lista_de_usuarios).setVisible(true);
                dispose();
            }
        });


        Voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        ImageIcon imagem = new ImageIcon("src/imagens/cadastrar_usuario.png");
        Image imagemRedimensionada = imagem.getImage().getScaledInstance(800, 550, Image.SCALE_DEFAULT);
        ImageIcon imagemFinal = new ImageIcon(imagemRedimensionada);
        JLabel labelImagem = new JLabel(imagemFinal);
        labelImagem.setBounds(0,  0, 800, 500);

        getContentPane().add(Caixa_CPF);
        getContentPane().add(Caixa_nome);
        getContentPane().add(Caixa_endereco);
        getContentPane().add(Cadastrar);
        getContentPane().add(labelImagem);
        getContentPane().add(Voltar);

        labelImagem.setVisible(true);
    }

}
