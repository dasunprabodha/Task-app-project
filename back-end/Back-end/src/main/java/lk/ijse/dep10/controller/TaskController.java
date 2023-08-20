package lk.ijse.dep10.controller;

import lk.ijse.dep10.dao.TaskDao;
import lk.ijse.dep10.model.Task;
import lk.ijse.dep10.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("app/api/v1/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    @Autowired
    TaskDao taskDao;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        return taskService.getAllTasks();
    }
    @PostMapping
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        Task savedTask = taskDao.save(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<List<Task>> deleteTask(@PathVariable("id") Integer id) {
        return taskService.deleteTask(id);
    }


}
