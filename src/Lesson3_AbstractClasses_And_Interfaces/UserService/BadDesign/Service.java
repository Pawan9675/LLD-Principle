package Lesson3_AbstractClasses_And_Interfaces.UserService.BadDesign;

// Service.java
public class Service {
    private MySQLRepository mysqlRepo = new MySQLRepository();
    private MongoDBRepository mongoRepo = new MongoDBRepository();

    public void getUserData() {
        System.out.println(mysqlRepo.getUser());  // tightly coupled to MySQL
        System.out.println(mongoRepo.getUser());  // tightly coupled to MongoDB
    }

    public void getUserByEmail(String email) {
        System.out.println(mysqlRepo.getUserByMail(email));
        System.out.println(mongoRepo.getUserByMail(email));
    }
}
