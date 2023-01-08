package edu.mum.cs544;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

//This class is for Exercise AMP.2 – More Associations by Group12.
public class App {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        System.out.println("App is running");
        
        emf = Persistence.createEntityManagerFactory("cs544");
                
        EntityManager em = emf.createEntityManager();

        //a)
        System.out.println("a)");
        em.getTransaction().begin();
        Department department1 = new Department("Computer Science");

        Employee employee1=new Employee("James");
        em.persist(employee1);
        department1.addEmployee(employee1);

        Employee employee2=new Employee("Louis");
        em.persist(employee2);
        department1.addEmployee(employee2);

        em.persist(department1);
        em.getTransaction().commit();

        TypedQuery<Department> departmentSelectQuery = em.createQuery("from Department", Department.class);
        List<Department> departmentList = departmentSelectQuery.getResultList();
        System.out.println("---Department List---");
        for (Department department : departmentList) {
            System.out.println("id= " + department.getId() + ", name= " + department.getName());

            System.out.println("Employees : ");
            for(Employee employee : department.getEmployees()){
                System.out.println("employeeid= "+employee.getEmployeenumber() + ", name= "+employee.getName());
            }

            System.out.println("----------");
        }

        TypedQuery<Employee> employeeSelectQuery = em.createQuery("from Employee", Employee.class);
        List<Employee> employeeList = employeeSelectQuery.getResultList();
        System.out.println("---Employee List---");
        for (Employee employee : employeeList) {
            System.out.println("employeeid= "+employee.getEmployeenumber() + ", name= "+employee.getName() +
            ", department info: name= " + employee.getDepartment().getName());
        }

        //b) 
        System.out.println("b)");
        em.getTransaction().begin();
        Book book1= new Book("About Summber", "Sam");
        Publisher publisher1 = new Publisher("Diamond Publiser");
        em.persist(publisher1);
        book1.setPublisher(publisher1);
        em.persist(book1);

        Book book2= new Book("About Rainy Season", "Rain");
        em.persist(book2);

        TypedQuery<Book> bookSelectQuery = em.createQuery("from Book", Book.class);
        List<Book> bookList = bookSelectQuery.getResultList();
        System.out.println("---Book List---");
        for (Book book : bookList) {
            String textToShow = "title= "+book.getTitle() + ", author= "+book.getAuthor();
            if(book.getPublisher() != null) //as publisher may be null because of 0 or 1 relationship
                textToShow += ", publisher info: name= " + book.getPublisher().getName();
           
            System.out.println(textToShow);
        }

        em.getTransaction().commit();

        //c) 
        System.out.println("c)");
        em.getTransaction().begin();
        Student student1 = new Student(1L, "Joe", "Dam");
        em.persist(student1);
        Student student2 = new Student(2L, "Yu", "Hanna");
        em.persist(student2);

        Course course1 = new Course("CS544", "Enterprise Architecture");
        em.persist(course1);
        course1.addStudent(student1);
        course1.addStudent(student2);

        Course course2 = new Course("CS545", "Web Application Architecture");
        em.persist(course2);
        course2.addStudent(student1);
        course2.addStudent(student2);

        Course course3 = new Course("CS390", "FPP");
        em.persist(course3);
        course3.addStudent(student1);

        em.getTransaction().commit();

        TypedQuery<Student> studentSelectQuery = em.createQuery("from Student", Student.class);
        List<Student> studentList = studentSelectQuery.getResultList();
        System.out.println("---Student List---");
        for (Student student : studentList) {
            System.out.println("studentid= " + student.getStudentid() + ", firstname= " + student.getFirstname() + 
            ", lastname= "+student.getLastname());

            System.out.println("Taken Courses : ");
            for(Course course : student.getCourses()){
                System.out.println("courseid= "+course.getCoursenumber() + ", name= "+course.getName());
            }

            System.out.println("----------");
        }
        
        //d)
        System.out.println("d)");
        em.getTransaction().begin();

        Customer customer1 = new Customer("Tonny");
        Reservation reservation1=new Reservation(new Date());
        em.persist(reservation1);
        customer1.addReservation(reservation1);
        Reservation reservation2=new Reservation(new Date());
        em.persist(reservation2);
        customer1.addReservation(reservation2);

        em.persist(customer1);
        em.getTransaction().commit();

        TypedQuery<Customer> customerSelectQuery1 = em.createQuery("from Customer", Customer.class);
        List<Customer> customerList1 = customerSelectQuery1.getResultList();
        System.out.println("---Customer List---");
        for (Customer customer : customerList1) {
            System.out.println("name= " + customer.getName());

            System.out.println("Reservations : ");
            for(Reservation reservation : customer.getReservations()){
                System.out.println("date= "+reservation.getDate());
            }

            System.out.println("----------");
        }


        //e)
        System.out.println("e)");
        em.getTransaction().begin();
        Book book3 = new Book("About Snow", "Liey");
        em.persist(book3);
        Customer customer2 = new Customer("Windy");
        Reservation reservation3=new Reservation(new Date());
        em.persist(reservation3);
        reservation3.setBook(book3);
        customer2.addReservation(reservation3);
        Reservation reservation4=new Reservation(new Date());
        em.persist(reservation4);
        reservation4.setBook(book1);
        customer2.addReservation(reservation4);

        em.persist(customer2);
        em.getTransaction().commit();

        TypedQuery<Customer> customerSelectQuery2 = em.createQuery("from Customer", Customer.class);
        List<Customer> customerList2 = customerSelectQuery2.getResultList();
        System.out.println("---Customer List---");
        for (Customer customer : customerList2) {
            System.out.println("name= " + customer.getName());

            System.out.println("    Reservations : ");
            for(Reservation reservation : customer.getReservations()){
                System.out.println("    date= "+reservation.getDate());
                Book reservedBook = reservation.getBook();
                if(reservedBook != null){
                    System.out.println("        Books in this Reservation :");
                    String textToShow = "           title= "+reservedBook.getTitle() + ", author= "+reservedBook.getAuthor();
                    if(reservedBook.getPublisher() != null) //as publisher may be null because of 0 or 1 relationship
                        textToShow += ", publisher info: name= " + reservedBook.getPublisher().getName();
                
                    System.out.println(textToShow);
                }
            }

            System.out.println("----------");
        }

        //f)
        System.out.println("f)");
        em.getTransaction().begin();
        Office office1 = new Office("Verill");
        em.persist(office1);

        Department department2 = new Department("International Relation");

        Employee employee3=new Employee("Susan");
        em.persist(employee3);
        department2.addEmployee(employee3);
        office1.addEmployee(employee3);

        Employee employee4=new Employee("Mindi");
        em.persist(employee4);
        department2.addEmployee(employee4);
        office1.addEmployee(employee4);

        em.persist(department2);
        em.getTransaction().commit();

        TypedQuery<Department> secondDepartmentSelectQuery = em.createQuery("from Department", Department.class);
        List<Department> secondDepartmentList = secondDepartmentSelectQuery.getResultList();
        System.out.println("---Department List---");
        for (Department department : secondDepartmentList) {
            System.out.println("id= " + department.getId() + ", name= " + department.getName());

            System.out.println("Employees : ");
            for(Employee employee : department.getEmployees()){
                System.out.println("employeeid= "+employee.getEmployeenumber() + ", name= "+employee.getName());
            }

            System.out.println("----------");
        }

        TypedQuery<Employee> secondEmployeeSelectQuery = em.createQuery("from Employee", Employee.class);
        List<Employee> secondEmployeeList = secondEmployeeSelectQuery.getResultList();
        System.out.println("---Employee List---");
        for (Employee employee : secondEmployeeList) {
            String textToShow="employeeid= "+employee.getEmployeenumber() + ", name= "+employee.getName() +
            ", department info: name= " + employee.getDepartment().getName();
            if(employee.getOffice()!=null) //not necessary for f) but in a), but because there are employees who have no office yet
                textToShow+=", office info: building= " + employee.getOffice().getBuilding();
            System.out.println(textToShow);
        }

        TypedQuery<Office> officeSelectQuery = em.createQuery("from Office", Office.class);
        List<Office> officeList = officeSelectQuery.getResultList();
        System.out.println("---Office List---");
        for (Office office : officeList) {
            System.out.println("building= " + office.getBuilding());

            System.out.println("Employees : ");
            for(Employee employee : office.getEmployees()){
                System.out.println("employeeid= "+employee.getEmployeenumber() + ", name= "+employee.getName());
            }

            System.out.println("----------");
        }
        em.close();
    }
}
