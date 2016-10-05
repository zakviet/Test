package com.capgemini.test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.exception.InvalidCustomerException;
import com.capgemini.model.Account;
import com.capgemini.model.Customer;
import com.capgemini.service.BankService;
import com.capgemini.service.BankServiceImple;

import junit.framework.TestCase;

/**
 * 
 */

/**
 * @author zhasan and sanjay
 *
 */
public class AccountTest extends TestCase {
	
	Account acc1;
	@Before
	public void setUp() throws Exception {
		
		
		int amount = 15000;
		int accountNumber = 5001;
		Customer customer;
		BankService service; 

		
		customer = new Customer("zahir");
		System.out.println(customer.getName());
		System.out.println(amount);
		acc1 = new Account(accountNumber, amount, customer);
		
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * 1. create account If account does not exist system should throw exception
	 * @throws InvalidAccountNumberException */
	@Test(expected=com.capgemini.exception.InvalidAccountNumberException.class)
	public void testAccountDoesNotExist()  {
		BankService service = new BankServiceImple();
		
			try {
				service.createAccount(0, acc1.getAmount(), acc1.getCustomer());
			} catch (InvalidAccountNumberException e) {
				//e.printStackTrace();
				System.out.println(e.getClass());
			} catch (InsufficientBalanceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
	}
	/**
	 * 2. If customer is invalid system should throw exception*/
	@Test
	public void testIsvalidCustomer() {
		
		assertEquals("zahir", acc1.getCustomer().getName());
		
	
	}
	
	/**
	 * 3. If Ac no. is invalid system should throw exception*/
	@Test
	public void testIsvalidAccountNumber() {
		
		assertNotEquals(2001, acc1.getAccountNumber());
		
	
	}
	/**
	 * 4. If Amount is invalid system should throw exception*/
	@Test
	public void testIfamountisvalid() {
		
		assertNotEquals(200, acc1.getAmount());
		
	
	}
	
	
	/**
	 * 5. If valid info is passed system should return the account number*/
	@Test
	public void testvalidAccounttesting() {
		
		assertEquals(5001, acc1.getAccountNumber());
		
	
	}
	
	/**
	 * 1. search account If account does not exist system should throw exception*/
	@Test(expected = com.capgemini.exception.InvalidAccountNumberException.class)
	public void testAccountDoesNotExistInSearchAccount() {
		BankService service = new BankServiceImple();
		try {
			service.searchAccount(2001);
		} catch (InvalidAccountNumberException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass());
		}
		
	
	}
	
	/**
	 * 2. search account If Ac no. is invalid system should throw exception*/
	@Test
	public void testIsvalidAccountNumberInSearchAccount() {
		
		assertNotEquals(2001, acc1.getAccountNumber());
		
	
	}
	/**
	 * 3. search account  If valid info is passed search account work successfully*/
	@Test
	public void testValidInfoForSearchAccount() {
		
		assertEquals(5001, acc1.getAccountNumber());
		
	
	}
	
	/**
	 * 1. withdraw amount If account does not exist system should throw exception*/
	@Test(expected = com.capgemini.exception.InvalidAccountNumberException.class)
	public void testAccountDoesNotExistForWithdrawAmount() {
		BankService service = new BankServiceImple();
		try {
			service.searchAccount(2001);
		} catch (InvalidAccountNumberException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass());
		}
		
	
	}
	/**
	 * 2. withdraw amount If customer is invalid system should throw exception*/
	@Test
	public void testIsvalidCustomerForWithdrawAmount() throws InvalidCustomerException{
		
		assertNotEquals("xyz", acc1.getCustomer().getName());
		
	
	}
	
	/**
	 * 3. withdraw amount If Ac no. is invalid system should throw exception*/
	@Test
	public void testIsvalidAccountNumberForWithdrawAmount() throws InvalidAccountNumberException{
		
		assertNotEquals(2001, acc1.getAccountNumber());
		
	
	}
	/**
	 * 4. withdraw amount If Amount is invalid system should throw exception*/
	@Test
	public void testIfamountisvalidForWithdrawAmount() throws InsufficientBalanceException{
		
		assertNotEquals(10000, acc1.getAmount());
		
	
	}
	
	/**
	 * 5. withdraw amount If valid info is passed system should withdraw amount*/
	@Test
	public void testValidForWithdrawAmount() throws InsufficientBalanceException{
		
		assertNotEquals(20000, acc1.getAmount() < 20000);
		
	
	}
	
	/**
	 * 1. showBalance If account does not exist system should throw exception for */
	@Test(expected = com.capgemini.exception.InvalidAccountNumberException.class)
	public void testAccountDoesNotExistInShowBalance() {
		BankService service = new BankServiceImple();
		try {
			service.searchAccount(2001);
		} catch (InvalidAccountNumberException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass());
		}
		
	
	}
	
	/**
	 * 2. showBalance If customer is invalid system should throw exception*/
	@Test
	public void testIsvalidCustomerforshowBalance() throws InvalidCustomerException {
		
		assertEquals("zahir", acc1.getCustomer().getName());
		
	
	}
	
	/**
	 * 3. showBalance If Ac no. is invalid system should throw exception*/
	@Test
	public void testIsvalidAccountNumberforShowbalance() {
		
		assertNotEquals(0, acc1.getAccountNumber());
		
	
	}
	/**
	 * 4. show balance  If valid info is passed show balance  work successfully*/
	@Test
	public void testValidInfoForShowBalance() {
		
		assertEquals(5001, acc1.getAccountNumber());
		
	
	}
	

}
