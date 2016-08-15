/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.upqroo.reservations.daos.CustomersDao;
import edu.upqroo.reservations.domain.Customers;
import edu.upqroo.reservations.exceptions.IfCostumerExistsException;
import edu.upqroo.reservations.services.CostumerService;
import edu.upqroo.reservations.services.CostumerServiceImpl;
import edu.upqroo.reservations.ui.CustomersUI;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Horacio
 */
public class CostumerServiceImplTest {
    
    public CostumerServiceImplTest() {
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
    @Test(expected = IfCostumerExistsException.class)
    public void shouldIfCostumerExistsException(){
        CustomersDao costumerDao = mock(CustomersDao.class);
        CostumerService costumersService = new CostumerServiceImpl(costumerDao);
        Customers customer = new Customers("Horacio", "Espinosa", "Calle 42", 22);
        when(costumersService.checkIfCustomerExists(customer)).thenReturn(true);
        costumersService.addCustormer(customer);
    }
}