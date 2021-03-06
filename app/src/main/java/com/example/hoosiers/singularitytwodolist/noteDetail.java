package com.example.hoosiers.singularitytwodolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hoosiers on 7/17/2016.
 */
public class noteDetail extends AppCompatActivity{

    private EditText checkedTextView;
    private EditText editTextTaskDesc;
    private EditText editTextDate;
    private Button buttonUpdateTask;
    private Button buttonSubList;
    private Button buttonDeleteTask;
    private List<Task> taskList;
    private ArrayList<Subtask> subTasks;
    String taskName = null;
    String taskNote = null;
    String taskDate = null;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_detail_layout);

        checkedTextView = (EditText) findViewById(R.id.checkedTextView);
        editTextTaskDesc = (EditText) findViewById(R.id.editTextTaskDesc);
        editTextDate = (EditText) findViewById(R.id.editTextDate);
        buttonUpdateTask = (Button) findViewById(R.id.buttonUpdateTask);
        buttonSubList = (Button) findViewById(R.id.buttonSubList);
        buttonDeleteTask = (Button) findViewById(R.id.buttonDeleteTask);
        editTextDate = (EditText) findViewById(R.id.editTextDate);


        String list_name = getIntent().getStringExtra("list_name");
    }

    public void getTaskName (View v){
        if (v.getId() == R.id.checkedTextView){
            taskName = checkedTextView.getText().toString();
        }
    }

    public void getTaskDesc (View v){
        if (v.getId() == R.id.editTextTaskDesc){
            taskNote = editTextTaskDesc.getText().toString();
        }
    }

    public void getDateDone (View v){
        if (v.getId() == R.id.editTextDate){
            taskDate = editTextDate.getText().toString();
        }
    }

    public void addTask (View v){
        if (v.getId() == R.id.buttonUpdateTask){
            if (taskName != null){
                Boolean taskCompleted = false;
                if (taskDate != null){
                    taskCompleted = true;
                }
                ArrayList<Subtask> subTasks = new ArrayList<Subtask>();
                Task taskObject = new Task(taskName, taskNote, taskCompleted, subTasks);
                taskList.add(taskObject);
            }
        }
    }

    public void addSubTask (View v){
        if (v.getId() == R.id.buttonSubList){
            if (taskName != null){

                Intent i = new Intent(noteDetail.this, subList.class);
                i.putExtra("task_name", taskName);
                startActivity(new Intent(noteDetail.this, subList.class));

            }

        }
    }

    public void deleteTask (View v){
        //GET task
        //taskList.remove(taskObject);
        //PUT
    }
}
