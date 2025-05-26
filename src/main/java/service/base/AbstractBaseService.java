package service.base;

import repository.base.AbstractCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public abstract class AbstractBaseService<T> {

    @Autowired
    private AbstractCrudRepository<T> repository;

    public List<T> listarTodos() {
        return repository.buscarTodos();
    }

    public Optional<T> buscarPorId(Integer id) {
        return repository.buscarPorId(id);
    }

    public void salvar(T entity) {
        repository.salvar(entity);
    }

    public void excluir(T entity) {
        repository.excluir(entity);
    }
}
