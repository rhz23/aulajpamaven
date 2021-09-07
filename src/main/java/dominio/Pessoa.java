package dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

//o @Entity da classe javax.persistence.Entity indica que a classe pessoa é para ser mapeada!
@Entity
public class Pessoa implements Serializable {

    //o @Id indica que o proximo atributo é referente ao ID daquela tabela no banco, e o @GeneratedValue(strategy = GenerationType.IDENTITY) indica a forma de auto geração do campo id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //é possivel usar a notação abaixo para indicar o nome que a coluna deve ter no banco de dados (caso queira que a coluna tenha nome diferente do nome usado na classe
    //@Column(name = "nomecompleto")
    private String nome;
    private String email;

    public Pessoa(){
    }

    public Pessoa(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
