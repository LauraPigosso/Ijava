
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Pedidos extends JFrame {
    String getNome(Restaurante restaurante){
        return restaurante.nome;
    }
    String getUsuarioNome(Usuario usuario){
        return usuario.nome;
    }

    public Pedidos(ArrayList<Restaurante> lista_de_resutaurante, ArrayList<Usuario> lista_de_usuarios){

        setTitle("Fazer pedido");
        setLocation(100, 100);
        setSize(1024, 768);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        String[] lista_de_clientes = Arrays.stream(lista_de_usuarios.toArray()).map(n -> getUsuarioNome((Usuario) n)).toArray(String[]::new);
        String[] listaRestaurantes = Arrays.stream(lista_de_resutaurante.toArray()).map(n -> getNome((Restaurante) n)).toArray(String[]::new);

        JComboBox<String> dropdownClientes = new JComboBox<>(lista_de_clientes);
        dropdownClientes.setBounds(480, 347, 346, 60);

        JComboBox<String> dropdownRestaurantes = new JComboBox<>(listaRestaurantes);
        dropdownRestaurantes.setBounds(480, 553, 346, 60);

        componente_botao Voltar = new componente_botao();
        Voltar.setBounds(26, 632, 249, 80);
        Voltar.setContentAreaFilled(false);

        componente_botao Proximo = new componente_botao();
        Proximo.setBounds(26, 490, 249, 80);
        Proximo.setContentAreaFilled(false);


        Voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        Proximo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomeCliente = lista_de_clientes[dropdownClientes.getSelectedIndex()];
                String nomeRestaurante = listaRestaurantes[dropdownRestaurantes.getSelectedIndex()];
                Restaurante restaurante = null;
                Usuario usuario = null;
                for (Usuario _user: lista_de_usuarios) {
                    if (_user.nome == nomeCliente){
                        usuario = _user;
                    }
                }

                for (Restaurante _res: lista_de_resutaurante) {
                    if (_res.nome == nomeRestaurante){
                        restaurante = _res;
                    }
                }
                new Menu(restaurante, usuario).setVisible(true);
                dispose();
            }
        });

        ImageIcon imagem = new ImageIcon("src/imagens/Tela_escolher.png");
        Image imagem_figma = imagem.getImage().getScaledInstance(1024, 768, Image.SCALE_DEFAULT);
        ImageIcon backgroud = new ImageIcon(imagem_figma);
        JLabel BG_imagem = new JLabel(backgroud);
        BG_imagem.setBounds(0, 0, 1024, 768);

        getContentPane().add(dropdownClientes);
        getContentPane().add(dropdownRestaurantes);
        getContentPane().add(Voltar);
        getContentPane().add(Proximo);

        getContentPane().add(BG_imagem);
        BG_imagem.setVisible(true);
    }
}
