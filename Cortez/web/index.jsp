<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : 23.03.2016, 18:55:09
    Author     : ???
--%>



<%--sql:query var="CatGirls" dataSource="jdbc/cortez">
    SELECT * FROM categorygirls
</sql:query>
    <sql:query var="CatRooms" dataSource="jdbc/cortez">
        SELECT *  FROM categoryrooms
    </sql:query--%>

<div id="velcomeLeftColumn">
    <div id="categoryBoxPlace">
        <div class="girlscategoryBox">
            <a style="text-decoration:none" href="categorygirls?0">
                <span class="HeadcategoryLabelText">Our girls</span>
            </a>
        </div>
        
        <c:forEach var="Categor" items="${CatGirls}">
 <a style="text-decoration:none" href="categorygirls?${Categor.id}">
                <span class="categoryLabelText">${Categor.name}</span>
            </a>
           
        </c:forEach>


    </div>

</div>

<div id="velcomeCenterColumn">

    <img src="img/IndexVelcome/cort.jpg" alt="???">
</div>

<div id="velcomeRightColumn">
    <div id="roomcategoryBoxPlace">


        <div class="roomcategoryBox">
            <a style="text-decoration:none" href="categoryrooms?0">
                <span class="HeadcategoryLabelText">Our rooms</span>
            </a>
        </div>

        <c:forEach var="CateRooms" items="${CatRooms}">
            
            <div class="Box">
            <a style="text-decoration:none" href="categoryrooms?${CateRooms.id}">
                <span class="categoryLabelText">${CateRooms.name}</span>
            </a>
        </div>
        </c:forEach>
        
       

    </div>

</div>

