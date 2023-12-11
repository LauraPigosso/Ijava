import javax.swing.*;
import java.util.ArrayList;


public class Inicializador {
    public void comecar() {
        ArrayList<Restaurante> lista_de_resutaurante = new ArrayList<>();
        ArrayList<Usuario> lista_de_usuarios = new ArrayList<>();

        tela_iniciar tela = new tela_iniciar();
        tela.setVisible(true);

        Cadastro_restaurantes restaurante = new Cadastro_restaurantes(lista_de_resutaurante, lista_de_usuarios);
        Cadastro_usuarios usuarios = new Cadastro_usuarios(lista_de_resutaurante, lista_de_usuarios);

        tela.getCadastro_restaurante().addActionListener(e -> restaurante.setVisible(true));

        tela.getCadastro_usuario().addActionListener(e -> usuarios.setVisible(true));

        tela.getCadastro_pedido().addActionListener(e -> new Pedidos(lista_de_resutaurante, lista_de_usuarios).setVisible(true));

    }
}
