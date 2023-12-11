import java.util.ArrayList;

public class Restaurante {
    public String nome;
    public String cnpj;
    public String local;
    public ArrayList<Lanche> cardapio;

    public Restaurante(String nome, String cnpj, String local) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.local = local;
        this.cardapio = new ArrayList<>();
    }
}
