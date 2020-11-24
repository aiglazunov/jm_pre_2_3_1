//package web;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import web.config.HiberConfig;
//import web.model.User;
//import web.service.UserService;
//
//public class MainApp {
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(HiberConfig.class);
//
//        UserService userService = context.getBean(UserService.class);
//
//        User user1 = new User("User1", "Lastname1", (byte) 4);
//
//        userService.add(user1);
//        userService.listUsers();
//
//        context.close();
//    }
//}
