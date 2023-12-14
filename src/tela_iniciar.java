import javax.swing.*;
import java.awt.*;

public class tela_iniciar extends JFrame {
     JButton cadastro_restaurante;
     JButton cadastro_pedido;
     JButton cadastro_usuario;

    public JButton getCadastro_restaurante() {
        return cadastro_restaurante;
    }

    public void setCadastro_restaurante(JButton cadastro_restaurante) {
        this.cadastro_restaurante = cadastro_restaurante;
    }

    public JButton getCadastro_pedido() {
        return cadastro_pedido;
    }

    public void setCadastro_pedido(JButton cadastro_pedido) {
        this.cadastro_pedido = cadastro_pedido;
    }

    public JButton getCadastro_usuario() {
        return cadastro_usuario;
    }

    public void setCadastro_usuario(JButton cadastro_usuario) {
        this.cadastro_usuario = cadastro_usuario;
    }

    public tela_iniciar() {
        setTitle("BEm vindo");
        setLocation(100, 100);
        setSize(1024, 768);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        cadastro_restaurante = new JButton();
        cadastro_usuario = new JButton();
        cadastro_pedido = new JButton();

        cadastro_restaurante.setOpaque(false);
        cadastro_pedido.setOpaque(false);
        cadastro_usuario.setOpaque(false);

        cadastro_restaurante.setContentAreaFilled(false);
        cadastro_pedido.setContentAreaFilled(false);
        cadastro_usuario.setContentAreaFilled(false);

        cadastro_restaurante.setBorderPainted(false);
        cadastro_pedido.setBorderPainted(false);
        cadastro_usuario.setBorderPainted(false);

        cadastro_restaurante.setBounds(646, 262, 250, 80);
        cadastro_pedido.setBounds(646, 430, 250, 80);
        cadastro_usuario.setBounds(646, 598, 250, 80);

        ImageIcon imagem = new ImageIcon("src/imagens/tela_inicial.png");
        Image imagem_figma = imagem.getImage().getScaledInstance(1024, 768, Image.SCALE_DEFAULT);
        ImageIcon backgroud = new ImageIcon(imagem_figma);
        JLabel BG_imagem = new JLabel(backgroud);
        BG_imagem.setBounds(0, 0, 1024, 768);

        getContentPane().add(cadastro_restaurante);
        getContentPane().add(cadastro_pedido);
        getContentPane().add(cadastro_usuario);

        getContentPane().add(BG_imagem);
        BG_imagem.setVisible(true);
    }
}
