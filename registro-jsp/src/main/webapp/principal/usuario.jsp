<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <title>Tela Principal do Sistema </title>
    
     <jsp:include page="header.jsp"></jsp:include>
  </head>

  <body>
 	<jsp:include page="pre-load.jsp"></jsp:include>
  <!-- Pre-loader end -->
  
  <div id="pcoded" class="pcoded">
      <div class="pcoded-overlay-box"></div>
      <div class="pcoded-container navbar-wrapper">
         
          <jsp:include page="navbar-header.jsp"></jsp:include>

          <div class="pcoded-main-container">
              <div class="pcoded-wrapper">
                <jsp:include page="navbar-menu.jsp"></jsp:include>
                  <div class="pcoded-content">
                      <!-- Page-header start -->
                      <jsp:include page="page-header.jsp"></jsp:include>
                      <!-- Page-header end -->
                        <div class="pcoded-inner-content">
                            <!-- Main-body start -->
                            <div class="main-body">
                                <div class="page-wrapper">
                                    <!-- Page-body start -->
                                    <div class="page-body">
                                        <div class="row">
                                           <div class="col-md-12">
                                                <div class="card">
                                                    <div class="card-header">
                                                        <h5>Cadastro de Usuário</h5>
                                                        
                                                    </div>
                                                    <div class="card-block">
                                                        <form class="form-material" method="post" action="<%=request.getContextPath() %>/ServletUsuarioController">
                                                           <div class="form-group form-default form-static-label">
                                                                <input type="text" name="id" id="id" class="form-control"  disabled="disabled">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label">ID:</label>
                                                            </div>
                                                            <div class="form-group form-default form-static-label">
                                                                <input type="text" name="nome" id="nome" class="form-control"  required="">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label">Nome:</label>
                                                            </div>
                                                            <div class="form-group form-default form-static-label">
                                                                <input type="text" name="login" id="login" class="form-control"  required="">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label">Email </label>
                                                            </div>
                                                            <div class="form-group form-default form-static-label">
                                                                <input type="password" name="senha" id="senha" class="form-control"  required="">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label">Senha </label>
                                                            </div>
                                                            <button type="submit" class="btn btn-success">Salvar</button>
                                                            <button type="button" class="btn btn-primary">Alterar</button>
                                                            <button type="button" class="btn btn-danger">Excluir</button>
                                                         </form>
                                                       </div>
                                                            </div>
                                                            </div>
                                                            
                                        </div>
                                    </div>
                                    <!-- Page-body end -->
                                </div>
                                <div id="styleSelector"> </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
   <jsp:include page="javascript-file.jsp"></jsp:include>
</body>

</html>
    