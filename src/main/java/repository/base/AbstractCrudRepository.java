package repository.base;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public abstract class AbstractCrudRepository<T> {
    protected EntityManager em;

    protected abstract Class<T> getEntityClass();

    @Transactional
    public void salvar(T entity) {
        em.persist(entity);
    }

    public Optional<T> buscarPorId(Integer id) {
        return Optional.ofNullable(em.find(getEntityClass(), id));
    }

    public List<T> buscarTodos() {
        return em.createQuery("FROM " + getEntityClass().getSimpleName(), getEntityClass()).getResultList();
    }

    @Transactional
    public void excluir(T entity) {
        em.remove(entity);
    }
}
