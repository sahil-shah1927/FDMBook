package com.fdmgroup.Listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.fdmgroup.GameManagement.Game;

/**
 * Application Lifecycle Listener implementation class GameInitializationListener
 *
 */
public class GameInitializationListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public GameInitializationListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  
    { 
        System.gc();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  
    { 
    	Game newGame = new Game();
		
		ServletContext appScopeContext = sce.getServletContext();
		
		appScopeContext.setAttribute("game", newGame);
    }
	
}
