package com.jh.example.generics.controller;

import com.jh.example.generics.model.vo.Parent;
import com.jh.example.list.model.vo.Student;
import com.jh.example.set.model.vo.Dog;

public class GenericsController {
    public void doGennerics() {
	Parent<Student,Dog> p = new Parent<>();
    }
}
