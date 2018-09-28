<%-- 
    Document   : cadastrar-estabelecimento
    Created on : 28/09/2018, 10:01:29
    Author     : Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <form method="post" action="front?action=CadastroEstabelecimento" enctype="multipart/form-data" id="cria-estbl" class="modal">
        <div class="columns">
            <div class="column is-3">
                <div class="field fotoperfil is-centered">
                    <figure class="image is-96x96">
                        <img id="foto" src="img/user.png">
                    </figure>
                    <div class="file has-name">
                        <label class="file-label">
                            <input id="arquivo" class="file-input" type="file" accept="image/*" name="foto">
                            <span class="file-cta">
                                <span class="file-icon">
                                    <i class="fas fa-upload"></i>
                                </span>
                                <span class="file-label">
                                    Escolha uma foto
                                </span>
                            </span>
                            <div id="nomearquivo" class="file-name">

                            </div>
                        </label>
                    </div>
                </div>
            </div>
            <div class="column">
                <div class="columns">
                    <div class="column">
                        <div class="field">
                            <label class="label is-left">Nome</label>
                            <div class="control">
                                <input class="input is-small" type="text" name="nome" required>
                            </div>
                        </div>
                    </div>
                    <div class="column">
                        <div class="field">
                            <label class="label is-left">Categoria</label>
                            <div class="control">
                                <input class="input is-small" type="text" name="categoria" required>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="field">
                    <label class="label is-left">Descrição</label>
                    <div class="control">
                        <textarea class="textarea is-small" type="text" name="descricao" rows="2"></textarea>
                    </div>
                </div>
                <div class="field">
                    <label class="label is-left">Rua</label>
                    <div class="control">
                        <input class="input is-small" type="text" name="rua" required>
                    </div>
                </div>
                <div class="columns">
                    <div class="column">
                        <div class="field">
                            <label class="label is-left">Cidade</label>
                            <div class="control">
                                <input class="input is-small" type="text" name="cidade" required>
                            </div>
                        </div>
                    </div>
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
                        <div class="field">
                            <label class="label is-left">CEP</label>
                            <div class="control">
                                <input class="input is-small" type="text" name="cep" required>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="columns">
                    <div class="column">
                        <div class="field">
                            <label class="label is-left">Telefone</label>
                            <div class="control">
                                <input class="input is-small" type="text" name="telefone" required>
                            </div>
                        </div>
                    </div>
                    <div class="column is-2">
                        <div class="field">
                            <label class="label is-left">Abre às</label>
                            <div class="control">
                                <input class="input is-small" type="time" name="horaAbre">
                            </div>
                        </div>
                    </div>
                    <div class="column is-2">
                        <div class="field">
                            <label class="label is-left">Fecha às</label>
                            <div class="control">
                                <input class="input is-small" type="time" name="horaFecha">
                            </div>
                        </div>
                    </div>
                </div>
                <input class="button is-success is-fullwidth" type="submit" value="Criar">
            </div>
        </div>
    </form>

</html>
