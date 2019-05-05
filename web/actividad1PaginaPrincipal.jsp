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
        
          <!--En este apartado se pusieron los titulos con diferentes tamaños y color de letra-->
        <h1 style="color: #57EF98">Prueba de Componentes web</h1>
        <h2 style="">Actividad Numero 1</h2>
        <h3 style="">Realizar un menu con los diferentes ejercicios: </h3>
        <br>
        <br>
        <h4 style="">Menu de ejercicios: </h4>
      
        <!--En este segundo apartado se creo el menu con los enlaces requeridos-->
        <!---->
        
        
          <div class="collection">
    <a href="/pruebaComponentesWeb/actividad2.jsp" class="collection-item">Ejercicio 1<span class="badge"></span></a>


  </div>
            


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