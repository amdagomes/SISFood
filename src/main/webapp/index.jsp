<%-- 
    Document   : index
    Created on : 15/08/2018, 19:26:44
    Author     : Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SisFood</title>
        <meta charset="utf-8">
        <meta name="viewport" content="whidth: device-width, initial-scale-1.0, maximun-scale-1.0">
        <meta name="description" content="Rede Social voltada para o ramo alimenticio.">
        <meta name="keywords" content="social, media, rede, social, food, alimento">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
        <link rel="stylesheet" href="css/style.css">
        <script defer src="https://use.fontawesome.com/releases/v5.1.0/js/all.js"></script>
    </head>
    <body>
        <section class="container is-fullhd h100 background">
            
            <div class="columns is-centered is-vertical-center box-login">
                
                <div class="column is-7-mobile is-4-tablet is-3-desktop box ">
                    <div class="image logo">
                        <img src="img/logo.png">
                    </div>
                    <form method="post" action="front" >
                        <div class="field">
                            <div class="control has-icons-left has-icons-right">
                                <input class="input" type="email" placeholder="Email" required>
                                <span class="icon is-small is-left">
                                    <i class="fas fa-user"></i>
                                </span>
                            </div>
                        </div>
                        <div class="field">
                            <p class="control has-icons-left">
                                <input class="input" type="password" placeholder="Password" required>
                                <span class="icon is-small is-left">
                                    <i class="fas fa-lock"></i>
                                </span>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control">
                                <input type="hidden" name="command" value="Login">
                                <input class="button is-success is-fullwidth is-rounded" type="submit" value="Login">
                            </p>
                        </div>
                    </form>	
                    <div class="footer-form">
                        <p>Ainda não faz parte do SisFood?<a href="cadastro.jsp"> Criar Conta</a></p>
                    </div>
                </div>
            </div> 
        </section> 
    </body>
</html>