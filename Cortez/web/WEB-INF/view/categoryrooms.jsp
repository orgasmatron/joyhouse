<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : categoryrooms
    Created on : 23.03.2016, 22:30:17
    Author     : ???
--%>

<div id="indexLeftColumn">
    
    <c:choose>
        <c:when test="${categoryId==0}">
            <div class="categoryBoxSelect">
        
            <span class="HeadcategoryLabelText">All</span>
        
    </div>
         
        </c:when>
        <c:otherwise>
            <div class="categoryBox">
        <a  style="text-decoration:none" href="categoryrooms?0">
            <span class="HeadcategoryLabelText">All</span>
        </a>
    </div>
        </c:otherwise>
            </c:choose>

        
             <c:forEach var="category" items="${CatRooms}">
                 <c:choose>
                <c:when test="${category.id==categoryId}">
                    
                <div class="categoryBoxSelect">
        
            <span class="HeadcategoryLabelText">${category.name}</span>
        
    </div>
                
            </c:when>
            <c:otherwise>
                
                <div class="categoryBox">
        <a style="text-decoration:none" href="categoryrooms?${category.id}">
            <span class="HeadcategoryLabelText">${category.name}</span>
        </a>
    </div>
            </c:otherwise>
               </c:choose>  
            </c:forEach>
            
              
                      
</div> 
     <div id="indexRightColumn">
    <div id="girlsTable">
        <table id="table">
            
            <c:forEach var="rooms" items="${categoryRooms}" varStatus="iter">
            <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'violet'}">
             <td>
                    <img src="${initParam.girlsImagePath}${rooms.name}.gif" alt="rooms image">
                </td>
            <td>
                    <span class="nameGirlText">${rooms.name}</span>
                    <br>
                    <span class="smallText">${rooms.description}</span>
                </td>
            <td>
                    <span class="nameGirlText"> &euro; ${rooms.price} / hour</span>
                </td>
                <td>
                    <form action="addToCart" method="post">
                        <input type="hidden"
                               name="orderId"
                               value="${rooms.id}">
                        <input type="submit" value="add to cart">
                    </form>
                </td>
            </tr>
            
            </c:forEach>
            
            </table>


    </div>   


</div>

