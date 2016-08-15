/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.upqroo.reservations.daos.ReservationsDao;
import edu.upqroo.reservations.daos.ReservationsMongoDao;
import edu.upqroo.reservations.daos.UsersDao;
import edu.upqroo.reservations.daos.UsersMongoDao;
import edu.upqroo.reservations.domain.TableResults;
import edu.upqroo.reservations.domain.Users;
import edu.upqroo.reservations.exceptions.IfCostumerExistsException;
import edu.upqroo.reservations.exceptions.IfLimitUsersException;
import edu.upqroo.reservations.exceptions.IfUsersExistsException;
import edu.upqroo.reservations.services.ReservationService;
import edu.upqroo.reservations.services.ReservationServiceImpl;
import edu.upqroo.reservations.services.UserService;
import edu.upqroo.reservations.services.UserServiceImpl;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Moises Barrera
 */
public class AdminTest {
    
    public AdminTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test(expected = IfUsersExistsException.class)
    public void AddEmployeeRepitExistsException() throws IfUsersExistsException, IfLimitUsersException{
            UsersDao con;
            UserService userService;
            ReservationsDao dao;
            ReservationService Reservacion;
            con = new UsersMongoDao();
            dao = new ReservationsMongoDao();
            userService = new UserServiceImpl(con,dao);
            Users user = new Users();
            user.setName("Moi");
            user.setLastName("Barrera");
            user.setUserName("Mojojo");
            user.setPassword("Hola");
            user.setIsAdministrator(false);
            userService.addUser(user);
            userService.addUser(user);
    }
    
    @Test(expected = IfLimitUsersException.class)
    public void LimitAddExistsException() throws IfUsersExistsException, IfLimitUsersException{
            UsersDao con;
            UserService userService;
            ReservationsDao dao;
            ReservationService Reservacion;
            con = new UsersMongoDao();
            dao = new ReservationsMongoDao();
            userService = new UserServiceImpl(con,dao);
            Users user = new Users();
            user.setName("Moi");
            user.setLastName("Barrera");
            user.setUserName("Mojojo");
            user.setPassword("Hola");
            user.setIsAdministrator(false);
            userService.addUser(user);
            user.setUserName("1");
            userService.addUser(user);
            user.setUserName("2");
            userService.addUser(user);
            user.setUserName("3");
            userService.addUser(user);
            user.setUserName("4");
            userService.addUser(user);
            user.setUserName("5");
            userService.addUser(user);
            user.setUserName("6");
            userService.addUser(user);
            user.setUserName("7");
            userService.addUser(user);
            user.setUserName("8");
            userService.addUser(user);
            user.setUserName("9");
            userService.addUser(user);
            user.setUserName("10");
            userService.addUser(user);
    }
    
    @Test
    public void DeleteUser() throws IfUsersExistsException, IfLimitUsersException
    {
            UsersDao con;
            UserService userService;
            ReservationsDao dao;
            ReservationService Reservacion;
            con = new UsersMongoDao();
            dao = new ReservationsMongoDao();
            userService = new UserServiceImpl(con,dao);
            Users user = new Users();
            user.setName("Moi");
            user.setLastName("Barrera");
            user.setUserName("Mojojo");
            user.setPassword("Hola");
            user.setIsAdministrator(false);
            //userService.addUser(user);
            userService.DeleteUser(2);
    }
    
    @Test
    public void UpdateUser() throws IfUsersExistsException, IfLimitUsersException{
            UsersDao con;
            UserService userService;
            ReservationsDao dao;
            ReservationService Reservacion;
            con = new UsersMongoDao();
            dao = new ReservationsMongoDao();
            userService = new UserServiceImpl(con,dao);
            Users user = new Users();
            user.setId(5);
            user.setName("Moi");
            user.setLastName("Barrera");
            user.setUserName("jojo");
            user.setPassword("Hola");
            user.setIsAdministrator(false);
            //userService.addUser(user);
            userService.UpdateUser(user);
    }  
    
    @Test
    public void GetUser() throws IfUsersExistsException, IfLimitUsersException{
            UsersDao con;
            UserService userService;
            ReservationsDao dao;
            ReservationService Reservacion;
            con = new UsersMongoDao();
            dao = new ReservationsMongoDao();
            userService = new UserServiceImpl(con,dao);
            Users user = new Users();
            user.setName("Moi");
            user.setLastName("Barrera");
            user.setUserName("Mojojo");
            user.setPassword("Hola");
            user.setIsAdministrator(false);
            //userService.addUser(user);
            userService.GetUser(3);
    }   
  
    @Test
    public void GetListReservationsByUser() throws IfUsersExistsException, IfLimitUsersException{
            UsersDao con;
            UserService userService;
            ReservationsDao dao;
            ReservationService Reservacion;
            con = new UsersMongoDao();
            dao = new ReservationsMongoDao();
            userService = new UserServiceImpl(con,dao);
            Users user = new Users();
            user.setName("Moi");
            user.setLastName("Barrera");
            user.setUserName("Mojojo");
            user.setPassword("Hola");
            user.setIsAdministrator(false);
            //userService.addUser(user);
            List<TableResults>  result = userService.GetResultVentas();
    }
}
