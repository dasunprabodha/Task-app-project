import {Component} from '@angular/core';
import {Task} from "./task";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'task-app';
  taskList: Array<Task> = [];


  constructor(private http: HttpClient) {
    http.get<Array<Task>>('http://localhost:8080/app/api/v1/tasks')
      .subscribe(taskList => this.taskList = taskList);
  }

  saveTask(txt: HTMLInputElement) {
    if (!txt.value.trim()) {
      txt.select();
      return;
    }
    this.http.post<Task>('http://localhost:8080/app/api/v1/tasks',
      new Task(0, txt.value, "NOT_COMPLETED")).subscribe(task => {
      this.taskList.push(task);
      txt.value = '';
      txt.focus();
    });


  }

  deleteTask(task: Task) {
    this.http.delete(`http://localhost:8080/app/api/v1/tasks/${task.id}`).subscribe(
      (data: Object) => {
        const index: number = this.taskList.indexOf(task);
        if (index !== -1) {
          this.taskList.splice(index, 1);
        }
      },
      (error) => {
        console.error('Error deleting task:', error);
      }
    );
  }

  ;

}
