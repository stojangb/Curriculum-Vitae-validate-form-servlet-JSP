<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"
              media="screen,projection"/>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <nav>
        <div class="nav-wrapper">
            <a href="#" class="brand-logo">Logo</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href="">Stojan Gasic</a></li>
            </ul>
        </div>
    </nav>
</head>
<body>
    <!-- Contenido-->

    <div class="container">
        <h1 style="color: #57EF98">Simulador de crédito</h1>

        <form action="validarcv.do" method="POST">

            <div class="input-field col s6">
                <input placeholder="Luis Miguel" type="text" name="nombres">
                <label>Nombre</label>
            </div>

    

            <div class="input-field col s7">
                
                <input placeholder="55"  type="text" name="monto" value="0">
            
               
               
                
                <label>Monto (UF)</label>

            </div>
            
            
             <div class="input-field col s12" name="cuotaAnios">
                <select name="cuotaanios">
                    <option value="0" selected>Escoge una opción</option>
                    
                    
                    <% 
                        for (int i = 1; i<=30; i++){
            
                        %>
                        <option value="<%=i%>"><%=i%></option>
                        <%}
                        
                        %>
                        
                    
                    <!--
                   
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                    <option value="13">13</option>
                    <option value="14">14</option>
                    <option value="15">15</option>
                    <option value="16">16</option>
                    <option value="17">17</option>
                    <option value="18">18</option>
                    <option value="19">19</option>
                    <option value="20">20</option>
                    <option value="21">21</option>
                    <option value="22">22</option>
                    <option value="23">23</option>
                    <option value="24">24</option>
                    <option value="25">25</option>
                    <option value="26">26</option>
                    <option value="27">27</option>
                    <option value="28">28</option>
                    <option value="29">29</option>
                    <option value="30">30</option>
                   -->
          
                </select>
                <label>Cuota (Años)</label>
            </div>
            
            
            
            
            
            
                      <p>Seguro desgravamen</p>

            <p>
                <input name="seguroDesgravamen" type="radio" id="si"  value="si" />
                <label for="si">Si</label>
            </p>
            <p>
                <input name="seguroDesgravamen" type="radio" id="no" value="no"/>
                <label for="no">No</label>
            </p>
 
           
            <p>
            <input type="hidden" name="seguroDesgravamen" value="null" />
            </p>
            <br>

         
            
                      <p>Seguro Contra Incendio</p>

            <p>
                <input name="seguroIncendio" type="radio" id="si2"  value="si" />
                <label for="si2">Si</label>
            </p>
            <p>
                <input name="seguroIncendio" type="radio" id="no2" value="no"/>
                <label for="no2">No</label>
            </p>
 
           
            <p>
            <input type="hidden" name="seguroIncendio" value="null" />
            </p>
            <br>

      
  

            
            

    
   <button class="btn-floating btn-large waves-effect waves-light green" type="submit"
                    name=“action">
                <i class="material-icons right">send</i>
            </button>
            
            <button class="btn-floating btn-large waves-effect waves-light red" type="reset"
                    name=“action">
                <i class="material-icons right">delete</i>
            </button>
            
            
                </div>
  
           

      
         
            
        </form>

    </div>
    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>

    <script>
        $(document).ready(function () {
            $('select').material_select();
        });
    </script>

</body>

</html>