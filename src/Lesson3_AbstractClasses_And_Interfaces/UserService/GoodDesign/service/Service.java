package Lesson3_AbstractClasses_And_Interfaces.UserService.GoodDesign.service;

import Lesson3_AbstractClasses_And_Interfaces.UserService.GoodDesign.repository.IRepository;

// Service.java
public class Service {
    private IRepository repo;

    public Service(IRepository repo) {
        this.repo = repo;
    }

    public void getUserData() {
        System.out.println(repo.getUser());
    }

    public void getUserByEmail(String email) {
        System.out.println(repo.getUserByMail(email));
    }
}
