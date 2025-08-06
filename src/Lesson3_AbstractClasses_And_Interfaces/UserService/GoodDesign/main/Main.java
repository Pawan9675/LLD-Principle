package Lesson3_AbstractClasses_And_Interfaces.UserService.GoodDesign.main;

import Lesson3_AbstractClasses_And_Interfaces.UserService.GoodDesign.repository.APIRepository;
import Lesson3_AbstractClasses_And_Interfaces.UserService.GoodDesign.repository.IRepository;
import Lesson3_AbstractClasses_And_Interfaces.UserService.GoodDesign.repository.MongoDBRepository;
import Lesson3_AbstractClasses_And_Interfaces.UserService.GoodDesign.repository.MySQLRepository;
import Lesson3_AbstractClasses_And_Interfaces.UserService.GoodDesign.service.Service;

// Main.java
public class Main {
    public static void main(String[] args) {
        IRepository mysqlRepo = new MySQLRepository();
        IRepository mongoRepo = new MongoDBRepository();

        Service service1 = new Service(mysqlRepo);
        service1.getUserData();                      // Output from MySQL
        service1.getUserByEmail("pawan@mail.com");

        Service service2 = new Service(mongoRepo);
        service2.getUserData();                      // Output from MongoDB
        service2.getUserByEmail("singh@mail.com");

        IRepository apiRepo = new APIRepository();

        Service service3 = new Service(apiRepo);
        service3.getUserData();                      // Output from API
        service3.getUserByEmail("apiuser@mail.com");
    }
}
