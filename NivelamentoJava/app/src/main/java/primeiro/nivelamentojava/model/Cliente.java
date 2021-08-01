package primeiro.nivelamentojava.model;

// Pojo
public class Cliente {
    // atributos - nome, email, telefone, idade, sexo
    // construtor
    // métodos de acesso (getters e setters) - ação - verbo - CamelCase

    private String nome;
    private String email;
    private String telefone;
    private Integer idade;
    private boolean sexo;

    // Tipos de Dados: primitivos e não primitivos

    // Construtor - padrão
    // public Cliente() {}

    public Cliente(String nome, String email, String telefone, Integer idade, boolean sexo) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", idade=" + idade +
                ", sexo=" + sexo +
                '}';
    }
}
