package org.todo.controller;
import org.todo.model.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/todos")
public class TodoController {
    private List<Todo> todoList = new ArrayList<>();
    private long idCounter = 1;

    @GetMapping
    public String getTodos(Model model) {
        model.addAttribute("todos", todoList);
        return "index";
    }

    @PostMapping
    public String addTodo(@RequestParam String description) {
        todoList.add(new Todo(idCounter++, description));
        return "redirect:/todos";
    }

    @PostMapping("/complete/{id}")
    public String completeTodo(@PathVariable Long id) {
        todoList.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .ifPresent(todo -> todo.setCompleted(true));
        return "redirect:/todos";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoList.removeIf(todo -> todo.getId().equals(id));
        return "redirect:/todos";
    }
}