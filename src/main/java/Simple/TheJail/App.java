/*
 * ******* Hostel Management System********
 * @Ganesha c
 * HMS is automated hostel management system, where we have two users one is Enduser, enduser can perform following operations
 * Illustarting Lambok,Logger and Global Exception using in HMS aka TheJail
 * 
 * 
 * */package Simple.TheJail;

import java.util.Scanner;

import org.jboss.logging.Logger;

import Simple.TheJail.Exception.GlobalException;
import Simple.TheJail.Service.LoginRegister;
import Simple.TheJail.ServiceImpl.LoginRegisterImpl;

public class App 
{
	static Logger log=Logger.getLogger(App.class);
    public static void main( String[] args ) throws GlobalException
    {
    	Scanner sc=new Scanner(System.in);
        log.info("\t\t--------------------The Jail-----------------------");
        	log.info("\tPress 1 for Registration\n\tPress 2 for login");
        	int op=sc.nextInt();
        	LoginRegister logreg=new LoginRegisterImpl();
        	switch(op) {
        	case 1->logreg.Registration();
        	case 2->logreg.Login();
        	}
        	sc.close();
        	
    }
}
