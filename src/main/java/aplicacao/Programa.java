package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {

        /*
        Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
        Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
        Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
         */

        //para colocar os dados acima em um banco de dados é necessário criar a conexão com o banco:
        //instanciar a EntityManagerFactory para que o mesmo crie um entityManager com o nome da "persistent unity, que é o nome utilizado no arquivo persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();
        //após a instanciação abaixo tem-se a conexão com o banco de dados e toda a parte de contexto de persistencia implementada.

        /*
        //sempre que o JPA faz alguma transção que não é uma simples leitura, ele necessita de uma "transação", conforme abaixo:
        em.getTransaction().begin();
        //o comando abaixo adiciona o objeto instanciado dentro do banco de dados.
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();
         */

        Pessoa p = em.find(Pessoa.class, 2);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

        System.out.println(p);

        System.out.println("Pronto!");
        em.close();
        emf.close();

    }
}
