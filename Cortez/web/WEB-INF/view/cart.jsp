<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<div id="cartWidget">   
    <div id="Widget"> 
         
      
        
         <c:if test="${!empty cart }">
        <a style="text-decoration:none" href="viewCart?clear=true">
            
            <span class="bubble">Clear</span>
        </a>
          
        </c:if>

        <a style="text-decoration:none" href="continue">
            <span class="bubble">Continue</span>
        </a>



        <a style="text-decoration:none" href="#">
            <span class="bubble">Checkout</span>
        </a>


    </div>
</div>
<div id="cartLeftColumn">
    <div id="cartNameTable">
        Your ordered room
    </div>

    
            
        
    <div id="cartTableResult"> 
        <c:choose>
        <c:when test="${!(cart.getRooms () == null)}">
        <table id="tableCart"> 
         
              
           <tr class="lightBlue">
                  
              
             <td>
                    <img src="${initParam.roomsImagePath}${cart.getRooms ().getProduct().name}.gif" alt="rooms image">
                </td>
            <td>
                    <span class="nameGirlText">${cart.getRooms ().getProduct().name}</span>
                    <br>
                    <span class="smallText">${cart.getRooms ().getProduct().description}</span>
                </td>
            <td>
                    <span class="nameGirlText"> &euro; ${cart.getRooms ().getProduct().price} / hour</span>
                </td>
                
           </tr> 
                 
               </table>
                 </c:when>     
</c:choose>
               

    </div>
</div>

<div id="cartRightColumn">
    <div id="cartNameTable">
        Your ordered girls
    </div>
    <div id="cartTableResult">  
        <c:choose>
        <c:when test="${!(cart.getNumberOfGirlsItems() ==0)}">
        <table id="tableCart"> 
            <c:forEach var="girlss" items="${cart.getGirls()}" varStatus="iter">
           <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'violet'}">
             
             <td>
                    <img src="${initParam.girlsImagePath}${girlss.getProduct().name}.gif" alt="girls image">
                </td>
            
                <td>
                    <span class="nameGirlText">${girlss.getProduct().name}</span>
                    <br>
                    <span class="smallText">${girlss.getProduct().description}</span>
                </td>
            <td>
                    <span class="nameGirlText"> &euro; ${girlss.getProduct().price} / hour</span>
                </td>
                
                
                
                
            </tr>
            
            </c:forEach>
            
        </table>
         </c:when>     
</c:choose>

    </div>

</div>


