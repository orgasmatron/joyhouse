/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import cart.ShoppingCart;
import entity.*;
import session.*;
import java.io.IOException;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import abstractProduct.Product;

@WebServlet(name = "Controller",
            loadOnStartup = 1,
            urlPatterns = {"/categorygirls",
                           "/categoryrooms",
                           "/addToCart",
                           "/viewCart",
                           "/updateCart",
                           "/checkout",
                           "/purchase",
                           "/chooseLanguage",
                             "/continue"})
public class ControllerServlet extends HttpServlet {

   
    @EJB
    private CategorygirlsFacade categoryGirlsFacade;
    @EJB
    private CategoryroomsFacade categoryRoomsFacade;
    @EJB
    private GirlsFacade GirlsFacade;
     @EJB
    private RoomsFacade RoomsFacade;
    @Override
    public void init() throws ServletException {

        // store category list in servlet context
        getServletContext().setAttribute("CatGirls", categoryGirlsFacade.findAll());
        getServletContext().setAttribute("CatRooms", categoryRoomsFacade.findAll());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session=request.getSession();

        String userPath = request.getServletPath();

        // if category page is requested
        if (userPath.equals("/categorygirls")) {
            int fromCatPage= 1;//идентификатор категории (девки или команты)
          
          String categoryId = request.getQueryString(); 
          
            if (categoryId!=null){
               if (Short.parseShort(categoryId)==0){
                session.setAttribute("categoryGirls", GirlsFacade.findAll());   
               }else {
                
              Categorygirls selectedGirlsCategory = categoryGirlsFacade.find(Short.parseShort(categoryId)); 
              
              Collection<Girls> categoryGirls = selectedGirlsCategory.getGirlsCollection();
               session.setAttribute("categoryGirls", categoryGirls);
               }
               //идентификатор страницы
               session.setAttribute("fromCatPage",fromCatPage);
               //               сохраняет текущую категорнию для continue
             session.setAttribute("categoryId", categoryId);
            }
            
            

        // if cart page is requested
        }else if (userPath.equals("/categoryrooms")) {
            
            int fromCatPage= 2;//идентификатор категории (девки или команты)
 String categoryId = request.getQueryString(); 
 
       if (categoryId!=null){
           if (Short.parseShort(categoryId)==0){
                session.setAttribute("categoryRooms", RoomsFacade.findAll());   
               }else {
           
            
              Categoryrooms selectedRoomsCategory = categoryRoomsFacade.find(Short.parseShort(categoryId));
              Collection<Rooms> categoryRooms = selectedRoomsCategory.getRoomsCollection();
               session.setAttribute("categoryRooms", categoryRooms);

            }
       }
        //идентификатор страницы
               session.setAttribute("fromCatPage",fromCatPage);
               //               сохраняет текущую категорнию для continue
             session.setAttribute("categoryId", categoryId);
               
        } else if (userPath.equals("/viewCart")) {
            String clear = request.getParameter("clear");
            if ((clear!=null) && clear.equals("true")){
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");    
                cart.clear();
            }
           

            userPath = "/cart";
            
 } else if (userPath.equals("/continue")) {
     int girlsOrRoomsPage =(int) session.getAttribute("fromCatPage");
//            int categoryId =  (int) session.getAttribute("categoryId");
            if (girlsOrRoomsPage==1){
                userPath = "/categorygirls";
                 } else if (girlsOrRoomsPage==2){
                      userPath = "/categoryrooms";
                 }

        } else if (userPath.equals("/checkout")) {
            // TODO: Implement checkout page request

        // if user switches language
        } else if (userPath.equals("/chooseLanguage")) {
            // TODO: Implement language request

        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
HttpSession session=request.getSession();
        String userPath = request.getServletPath();
ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
 int girlsOrRoomsPage =(int) session.getAttribute("fromCatPage");
        // if addToCart action is called
        if (userPath.equals("/addToCart")) {
            
            if (cart==null){
                cart= new ShoppingCart();
                session.setAttribute("cart", cart);
            }
             String orderId = request.getParameter("orderId");

             if (girlsOrRoomsPage==1){
     
            if (!orderId.isEmpty()) {

                Product girls = GirlsFacade.find(Integer.parseInt(orderId));
                cart.addItem(girls);
            }
            // TODO: Implement add product to cart action
              userPath = "/categorygirls";
             } else if(girlsOrRoomsPage==2){
                 if (!orderId.isEmpty()) {

                Product rooms = RoomsFacade.find(Integer.parseInt(orderId));
                cart.addItem(rooms);
            }
            // TODO: Implement add product to cart action
              userPath = "/categoryrooms";
                 
             }
             
           

        // if updateCart action is called
        } else if (userPath.equals("/updateCart")) {
            // TODO: Implement update cart action
       
           
       
        } else if (userPath.equals("/purchase")) {
            // TODO: Implement purchase action

            userPath = "/confirmation";
        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}