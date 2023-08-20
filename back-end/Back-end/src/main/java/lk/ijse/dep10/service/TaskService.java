package lk.ijse.dep10.service;

import lk.ijse.dep10.dao.TaskDao;
import lk.ijse.dep10.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskDao taskDao;
    public ResponseEntity<List<Task>> getAllTasks() {
        try {
            return new ResponseEntity<>(taskDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Task>> deleteTask(Integer id) {
        taskDao.deleteById(id);
        return null;
    }


}
