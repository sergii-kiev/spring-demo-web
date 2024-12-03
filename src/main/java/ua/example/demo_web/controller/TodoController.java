package ua.example.demo_web.controller;

import ua.example.demo_web.model.Todo;
import ua.example.demo_web.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    // Метод для отображения главной страницы с задачами
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "index";
    }

    // Метод для добавления новой задачи
    @PostMapping("/add")
    public String addTodo(@RequestParam String description) {
        Todo todo = new Todo();
        todo.setDescription(description);
        todo.setCompleted(false);
        todoRepository.save(todo);
        return "redirect:/";
    }

    // Метод для отметки задачи как выполненной
    @PostMapping("/complete")
    public String completeTodo(@RequestParam Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        todo.setCompleted(true);
        todoRepository.save(todo);
        return "redirect:/";
    }
}
