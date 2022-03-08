
package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ShoppingListServlet extends HttpServlet {

   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String sessionName = (String) session.getAttribute("username");
        String logoutParam = request.getParameter("action");
        
        if(logoutParam == null){
            if(sessionName != null){
                doPost(request, response);
                return;
            }
            else{
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
        }
        else if(logoutParam.equals("logout")){
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        session.setAttribute("username", username);
        
        //keep track of items
        ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
        
        String action = request.getParameter("action");
        boolean isEmpty = false;
        
        //Singleton pattern
        if(items == null){
            items = new ArrayList<>();
        }

        if(action != null && action.equals("add")){
            if(request.getParameter("item") != null){
                String userItems = request.getParameter("item");
                items.add(userItems);
                session.setAttribute("items", items);    
            }
        }
        else if(action != null && action.equals("delete")){
            String deletedItem = request.getParameter("items");
            items.remove(deletedItem);
            session.setAttribute("items", items);    
        }
        
        if(items.size() == 0){
            isEmpty = true;
        }
        request.setAttribute("isEmpty", isEmpty);
        request.setAttribute("itemList", items);
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        return;
        
    }

    
}
