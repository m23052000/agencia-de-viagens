package repository;

import jakarta.persistence.TypedQuery;
import model.Destino;
import repository.base.AbstractCrudRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Repository
public class DestinoRepository extends AbstractCrudRepository<Destino> {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected Class<Destino> getEntityClass() {
        return Destino.class;
    }

    public List<Destino> pesquisarPorNomeOuLocalizacao(String nome, String localizacao) {
        StringBuilder jpql = new StringBuilder("SELECT d FROM Destino d WHERE 1=1");

        if (nome != null && !nome.isEmpty()) {
            jpql.append(" AND d.nome LIKE :nome");
        }
        if (localizacao != null && !localizacao.isEmpty()) {
            jpql.append(" AND d.localizacao LIKE :localizacao");
        }

        TypedQuery<Destino> query = em.createQuery(jpql.toString(), Destino.class);
        if (nome != null && !nome.isEmpty()) {
            query.setParameter("nome", "%" + nome + "%");
        }
        if (localizacao != null && !localizacao.isEmpty()) {
            query.setParameter("localizacao", "%" + localizacao + "%");
        }

        return query.getResultList();
    }
}