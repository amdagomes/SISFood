<%-- 
    Document   : header
    Created on : 18/09/2018, 11:24:10
    Author     : Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <header class="navbar is-orange ">
        <div class="container">
            <div class="navbar-brand">
                <a class="navbar-item">
                    <img src="img/logo2.png" alt="SisFood">
                </a>
                <a role="button" class="navbar-burger" data-target="navMenu" aria-label="menu" aria-expanded="false">
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                </a> 
            </div>
            <div id="navMenu" class="navbar-menu">
                <div class="navbar-end has-text-centered-mobile">
                    <div class="navbar-item">
                        <form method="post" class="search">
                            <div class="field has-addons">
                                <div class="control">
                                    <input class="input is-small" type="text" placeholder="Search.." name="search">
                                </div>
                                <div class="control">
                                    <button class="button is-small" type="submit"><i class="fa fa-search"></i></button>
                                </div>
                            </div>
                        </form>
                    </div>

                    <a class="navbar-item active-link" href="front?action=Logout">
                        <span class="icon">
                            <i class="fas fa-sign-out-alt"></i>
                        </span>
                        <span>
                            Sair
                        </span>
                    </a>
                </div>

            </div>
        </div>
    </header>
</html>
