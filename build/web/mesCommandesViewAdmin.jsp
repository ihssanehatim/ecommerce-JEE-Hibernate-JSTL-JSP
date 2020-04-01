<%@page import="mini.projet.DAO.CommandeMetier"%>
<%@page import="mini.projet.BO.Commande"%>
<%@page import="mini.projet.BO.Products"%>
<%@page import="java.util.List"%>
<%@page import="mini.projet.DAO.ProductsMetier"%>

<% List<Commande> cmd = new CommandeMetier().retreive(); %>

<jsp:include page="header.jsp"/>
    <style>
      #loader {
        transition: all 0.3s ease-in-out;
        opacity: 1;
        visibility: visible;
        position: fixed;
        height: 100vh;
        width: 100%;
        background: #fff;
        z-index: 90000;
      }

      #loader.fadeOut {
        opacity: 0;
        visibility: hidden;
      }



      .spinner {
        width: 40px;
        height: 40px;
        position: absolute;
        top: calc(50% - 20px);
        left: calc(50% - 20px);
        background-color: #333;
        border-radius: 100%;
        -webkit-animation: sk-scaleout 1.0s infinite ease-in-out;
        animation: sk-scaleout 1.0s infinite ease-in-out;
      }

      @-webkit-keyframes sk-scaleout {
        0% { -webkit-transform: scale(0) }
        100% {
          -webkit-transform: scale(1.0);
          opacity: 0;
        }
      }

      @keyframes sk-scaleout {
        0% {
          -webkit-transform: scale(0);
          transform: scale(0);
        } 100% {
          -webkit-transform: scale(1.0);
          transform: scale(1.0);
          opacity: 0;
        }
      }
    </style>
  </head>
  <body class="app">
    <!-- @TOC -->
    <!-- =================================================== -->
    <!--
      + @Page Loader
      + @App Content
          - #Left Sidebar
              > $Sidebar Header
              > $Sidebar Menu

          - #Main
              > $Topbar
              > $App Screen Content
    -->


          
        <!-- ### $App Screen Content ### -->
        <main class='main-content bgc-grey-100' >
          <div id='mainContent'>
            <div class="container-fluid">
   
              <div class="row">
                <div class="col-md-12">
                  <div class="bgc-white bd bdrs-3 p-20 mB-20">
                    <h4 class="c-grey-900 mB-20"  style="padding-bottom: 50px;padding-top: 50px;">
                        
                         
                        Table Of Orders :
                         
                   
                  
                         
                         </h4>
                   <table class="table">
                      <thead>
                        <tr>
                            <th scope="col">Order ID</th>
                            <th scope="col">Username</th>
                          <th scope="col">Product</th>
                          <th scope="col">Address</th>
                          <th scope="col">Price</th>
                          <th scope="col">Order Status</th>
                           <th scope="col">Update Order</th>
                        </tr>
                      </thead>
                      <tbody>
                          <% if( cmd != null) {%>
                                        <% for(Commande c : cmd){ %>
                      <form action="/ecommerce/update?id=<%=c.getIdCommade() %>" method="post" >
                        <tr>
                            
                          <th><%=c.getIdCommade() %></th>
                           <th><%=c.getClient().getUsername() %></th>
                          <th><%=c.getProducts().getLabel() %></th>
                          <td><%=c.getAddress().getMaison()+" "+c.getAddress().getRue() +" " +c.getAddress().getVille() +" "+c.getAddress().getPays() %></td>
                          <td><%=c.getProducts().getPrice() %></td>
                          <td><input name="etat" value="<%=c.getEtat()%>"/></td>
                          <td><button class="add-to-cart-btn" ><i class="fa fa-shopping-cart" type="submit" ></i> Update</button></td>
                        </tr>
                      </form>
                        <% }%>
                         <% }else { %>
                        <tr> No Orders yet ! </tr>
                        <% } %>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </main>
       

                <jsp:include page="footer.jsp"/>