package ua.example.demo_web.repository;

import  ua.example.demo_web.model.Todo;
import org.springframework.data.repository.CrudRepository;

// Интерфейс репозитория для работы с сущностью Todo
public interface TodoRepository extends CrudRepository<Todo, Long> {
}
