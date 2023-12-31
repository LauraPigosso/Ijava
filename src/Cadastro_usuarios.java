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

        Font fonte = new Font("Arial", Font.BOLD, 40);

        Caixa_nome = new JTextField(20);
        Caixa_nome.setSize(249, 54);
        Caixa_nome.setLocation(646, 283);
        Caixa_nome.setFont(fonte);

        Caixa_CPF = new JTextField(14);
        Caixa_CPF.setSize(249, 54);
        Caixa_CPF.setLocation(646, 416);
        Caixa_CPF.setFont(fonte);

        Caixa_endereco = new JTextField(14);
        Caixa_endereco.setSize(249, 54);
        Caixa_endereco.setLocation(646, 549);
        Caixa_endereco.setFont(fonte);

        componente_botao Cadastrar = new componente_botao();
        Cadastrar.setBounds(643, 656, 249, 80);
        Cadastrar.setContentAreaFilled(false);

        componente_botao Voltar = new componente_botao();
        Voltar.setBounds(123, 656, 249, 80);
        Voltar.setContentAreaFilled(false);


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

        ImageIcon imagem = new ImageIcon("src/imagens/Cadastrar_usuario.png");
        Image imagem_figma = imagem.getImage().getScaledInstance(1024, 768, Image.SCALE_DEFAULT);
        ImageIcon backgroud = new ImageIcon(imagem_figma);
        JLabel BG_imagem = new JLabel(backgroud);
        BG_imagem.setBounds(0, 0, 1024, 768);

        getContentPane().add(Caixa_CPF);
        getContentPane().add(Caixa_nome);
        getContentPane().add(Caixa_endereco);
        getContentPane().add(Cadastrar);
        getContentPane().add(Voltar);

        getContentPane().add(BG_imagem);
        BG_imagem.setVisible(true);
    }

}
