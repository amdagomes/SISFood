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
        <section class="hero is-fullhd h100 background">

            <div class="columns is-centered is-vertical-center box-login ">

                <div class="column is-7-mobile is-6-tablet is-8-desktop box ">
                    <div class="image logo">
                        <img src="img/logo.png">
                    </div>
                    <form method="post" action="front?action=CadastroUsuario" enctype="multipart/form-data" >
                        <div class="columns">
                            <div class="column is-3 is-vertical-center">
                                <div class="field fotoperfil is-centered">
                                    <figure class="image ">
                                        <img id="fotoperfil" src="img/user.png">
                                    </figure>
                                    <div class="file has-name">
                                        <label class="file-label">
                                            <input id="file" class="file-input" type="file" accept="image/*" name="fotoPerfil">
                                            <span class="file-cta">
                                                <span class="file-icon">
                                                    <i class="fas fa-upload"></i>
                                                </span>
                                                <span class="file-label">
                                                    Escolha uma foto
                                                </span>
                                            </span>
                                            <div id="filename" class="file-name">

                                            </div>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="column">
                                <div class="field">
                                    <h5 class="subtitle">Dados Pessoais</h5>
                                    <label class="label is-left">Nome</label>
                                    <div class="control">
                                        <input class="input is-small" type="text" name="nome" required>
                                    </div>
                                </div>
                                <div class="columns">
                                    <div class="column">
                                        <div class="field">
                                            <label class="label is-left">Data nascimento</label>
                                            <div class="control">
                                                <input class="input is-small" type="date" name="dataNascimento" required>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="column">
                                        <div class="field">
                                            <label class="label is-left">Sexo</label>
                                            <div class="control">
                                                <div class="select is-small">
                                                    <select name="sexo">
                                                        <option value="Feminino">Feminino</option>
                                                        <option value="Masculino">Masculino</option>
                                                    </select>
                                                </div>         
                                            </div>
                                        </div>
                                    </div>          
                                </div>

                                <div class="field">
                                    <h5 class="subtitle">Endereço</h5>
                                    <label class="label is-left">Rua/nº</label>
                                    <div class="control">
                                        <div class="columns is-gapless">
                                            <div class="column is-10">
                                                <input class="input is-small" type="text" name="rua" required>
                                            </div>
                                            <div class="column">
                                                <input class="input is-small" type="text" placeholder="nº" name="numeroCasa">
                                            </div>
                                        </div>   
                                    </div>
                                </div>
                                <div class="field">
                                    <label class="label is-left">Cidade</label>
                                    <div class="control">
                                        <input class="input is-small" type="text" name="cidade" required>
                                    </div>
                                </div>
                                <div class="field">
                                    <div class="columns">
                                        <div class="column is-narrow">
                                            <label class="label is-left">Estado</label>
                                            <div class="control">
                                                <div class="select is-small">
                                                    <select name="estado">
                                                        <option value="AC">AC</option>
                                                        <option value="AL">AL</option>
                                                        <option value="AP">AP</option>
                                                        <option value="AM">AM</option>
                                                        <option value="BA">BA</option>
                                                        <option value="CE">CE</option>
                                                        <option value="DF">DF</option>
                                                        <option value="ES">ES</option>
                                                        <option value="GO">GO</option>
                                                        <option value="MA">MA</option>
                                                        <option value="MT">MT</option>
                                                        <option value="MS">MS</option>
                                                        <option value="MG">MG</option>
                                                        <option value="PA">PA</option>
                                                        <option value="PB">PB</option>
                                                        <option value="PR">PR</option>
                                                        <option value="PE">PE</option>
                                                        <option value="PI">PI</option>
                                                        <option value="RJ">RJ</option>
                                                        <option value="RN">RN</option>
                                                        <option value="RS">RS</option>
                                                        <option value="RO">RO</option>
                                                        <option value="RR">RR</option>
                                                        <option value="SC">SC</option>
                                                        <option value="SP">SP</option>
                                                        <option value="SE">SE</option>
                                                        <option value="TO">TO</option>
                                                        <option value="ES">ES</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="column">
                                            <label class="label is-left">CEP</label>
                                            <div class="control">
                                                <input class="input is-small" type="text" placeholder="Ex.:588815000" name="cep" required>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="column">
                                <div class="field">
                                    <h5 class="subtitle">Conta</h5>
                                    <label class="label is-left">Email</label>
                                    <div class="control has-icons-left has-icons-right">
                                        <input class="input is-small" type="email" placeholder="Ex.: user@user.com"  name="email" required>
                                        <span class="icon is-small is-left">
                                            <i class="fas fa-user"></i>
                                        </span>
                                    </div>
                                    <div class="field">
                                        <label class="label">Senha</label>
                                        <p class="control has-icons-left">
                                            <input class="input is-small" type="password" name ="senha" required>
                                            <span class="icon is-small is-left">
                                                <i class="fas fa-lock"></i>
                                            </span>
                                        </p>
                                    </div>
                                    <div class="field">
                                        <p class="control">
                                            <input type="hidden" name="identificador" value="Login">
                                            <input class="button is-success is-fullwidth is-rounded" type="submit" value="Cadastrar">
                                        </p>
                                    </div>
                                    <div class="footer-form">
                                        <p>Já possui uma conta?<a href="index.jsp"> Fazer login</a></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>  
                </div>
            </div> 
        </section> 
        <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>
            var erro = "${param.erroCadastroUsuario}";
            if (erro === "1") {
                swal("Erro", "Verifique a data de nascimento", "error");
            }
            if (erro === "2") {
                swal("Erro", "Este email já está sendo utilizado", "error");
            }

            //exibe o src da imagem
            var file = document.getElementById("file");
            file.onchange = function () {
                if (file.files.length > 0)
                {
                    document.getElementById('filename').innerHTML = file.files[0].name;
                }
            };

            //altera a foto de exibição do perfil
            $("#file").on('change', function () {
                if (this.files && this.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $('#fotoperfil').attr("src", e.target.result).fadeIn();
                    }
                    reader.readAsDataURL(this.files[0]);
                }
            });
        </script>
    </body>
</html>