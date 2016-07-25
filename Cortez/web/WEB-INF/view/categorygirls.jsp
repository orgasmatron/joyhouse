<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : categorygirls
    Created on : 23.03.2016, 22:29:59
    Author     : ???
--%>
<%--sql:query var="CatGirls" dataSource="jdbc/cortez">
    SELECT *  FROM categorygirls
</sql:query>
<c:choose>
    <c:when test="${pageContext.request.queryString==0}">
        <sql:query var="girls" dataSource="jdbc/cortez">
            SELECT * FROM girls
        </sql:query>
    </c:when>
    <c:otherwise>
<sql:query var="girls" dataSource="jdbc/cortez">
SELECT * FROM girls WHERE category_id = ?
<sql:param value="${pageContext.request.queryString}"/>
</sql:query>
    </c:otherwise>
</c:choose--%>

<div id="indexLeftColumn">
    
    <c:choose>
        <c:when test="${categoryId==0}">
            <div class="categoryBoxSelect">
        
            <span class="HeadcategoryLabelText">All</span>
        
    </div>
         
        </c:when>
        <c:otherwise>
            <div class="categoryBox">
        <a  style="text-decoration:none" href="categorygirls?0">
            <span class="HeadcategoryLabelText">All</span>
        </a>
    </div>
        </c:otherwise>
            </c:choose>

        
             <c:forEach var="category" items="${CatGirls}">
                 <c:choose>
                <c:when test="${category.id==categoryId}">
                    
                <div class="categoryBoxSelect">
        
            <span class="HeadcategoryLabelText">${category.name}</span>
        
    </div>
                
            </c:when>
            <c:otherwise>
                
                <div class="categoryBox">
        <a style="text-decoration:none" href="categorygirls?${category.id}">
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
            
            <c:forEach var="girlss" items="${categoryGirls}" varStatus="iter">
            <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'violet'}">
             <td>
                    <img src="${initParam.girlsImagePath}${girlss.name}.gif" alt="girls image">
                </td>
            <td>
                    <span class="nameGirlText">${girlss.name}</span>
                    <br>
                    <span class="smallText">${girlss.description}</span>
                </td>
            <td>
                    <span class="nameGirlText"> &euro; ${girlss.price} / hour</span>
                </td>
                <td>
                    <form action="addToCart" method="post">
                        <input type="hidden"
                               name="orderId"
                               value="${girlss.id}">
                        <input type="submit" value="add to cart">
                    </form>
                </td>
            </tr>
            
            </c:forEach>
           
            </table>


    </div>   


</div>

       
