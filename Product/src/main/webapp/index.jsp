<%@page import="com.adavanta.dao.product.*"%>
<%@page import="com.atvanta.model.*"%> 
<%@page import="java.util.ArrayList"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Products</title>
	<link rel="stylesheet" type="text/css" href="http://kenwheeler.github.io/slick/slick/slick.css"/>
	<link rel="stylesheet" type="text/css" href="http://kenwheeler.github.io/slick/slick/slick-theme.css"/>
	<link rel="stylesheet" type="text/css" href="assets/bootstrap-3.3.6-dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="styles.css">
	
         <script type="text/javascript">
 
            var form = $('#addProduct');
            form.submit(function () {

            $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doAddProduct',
            data: form.serialize(),
            success: function (data) {
            var result=data;
           // $('#result').attr("value",result);
           alert(result);
            }
            });

            return false;
            });
            var form = $('#editProduct');
            form.submit(function () {

            $.ajax({
            type: "POST",
            url: ${pageContext.request.contextPath}+'/do?MOD=BOK&ACT=doEdiProduct',
            data: form.serialize(),
            success: function (data) {
            var result=data;
           // $('#result').attr("value",result);
           alert(result);
            }
            });

            return false;
            });
</script>
</head>
<body>
	

	<div class="navbar navbar-default navbar-fixed-top" id="topnav">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="index.php" class="navbar-brand">Products</a>
			</div>

			<ul class="nav navbar-nav">
				<li style="width:300px;left:10px;top:10px;"><input type="text" class="form-control" id="search" name=""></li>
				<li style="top:10px;left:20px;"><button class="btn btn-primary" id="search_btn" name=""><span class='glyphicon glyphicon-search'></span></button></li>
			</ul>
 
		</div>
	</div>
<br>
<a href="#addClientModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-2">
			<div id="get_cat"></div>
				<!--<div class="nav nav-pills nav-stacked">
					<li class="active"><a href="#"><h4>Categories</h4></a></li>
					<li><a href="#">Categories</a></li>
					<li><a href="#">Categories</a></li>
					<li><a href="#">Categories</a></li>
					<li><a href="#">Categories</a></li>
				</div>-->
				<div id="get_brand"></div>
				<!--<div class="nav nav-pills nav-stacked">
					<li class="active"><a href="#"><h4>Brands</h4></a></li>
					<li><a href="#">Categories</a></li>
					<li><a href="#">Categories</a></li>
					<li><a href="#">Categories</a></li>
					<li><a href="#">Categories</a></li>
				</div>-->
			</div>
			<div class="col-md-8">
			<div class="row">
					<div class="col-md-12" id="cartmsg">
						
					</div>
				</div>
				<div class="panel panel-info">
					<div class="panel-heading text-center">--Featured Products--
						<div class='pull-right'>
								Sort: &nbsp;&nbsp;&nbsp;<a href="#" id='price_sort'>Price</a> | <a href="#" id='pop_sort'>Popularity</a>
							</div>
					</div>
					<div class="panel-body">
					<div id="get_product"></div>
						 <div class="col-md-4">
                                                     <%
                                                         ProductDAO pd = new ProductDAO();
                                                         ArrayList<ProductModel> prodsList = pd.getAllProducts();
                                                     for(ProductModel prodModel :prodsList){    
                                                     %>
							<div class="panel panel-info">
								<div class="panel-heading"><%=prodModel.getProductName()%></div>
								<div class="panel-body"><img src="<%= byteToImage(prodModel.getProductName() ,prodModel.getProductImage())%>"></div>
								<div class="panel-heading"><%=prodModel.getPrice()%>
								<button class="btn btn-danger btn-xs" style="float:right;">Add to Cart</button>
								</div>
							</div>
                                                         <%
                                                             }
                                                             %>
						</div> 
					</div>
					<div class="panel-footer">&copy; 2018</div>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<center>
					<ul class='pagination' id='pageno'>
						
					</ul>
				</center>
			</div>

			<!-- view Modal -->
				
				<div class="modal fade" id="prod_detail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="myModalLabel">Product Details</h4>
				      </div>
				      <div class="modal-body" id='dynamic_content'>
				        ...
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				        
				      </div>
				    </div>
				  </div>
				</div>

			 <!-- Modal ends-->
		</div>
	</div>
<!-- add modal   -->

<div class="signup-form">
    <form name="addProduct" id="addProduct" action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddProduct" method="post">
		<h2>Create an Account</h2>
        <div class="form-group">
        	<input name ="productname" id ="productname" type="text" class="form-control input-lg"  placeholder="Full Names" required="required">
        </div>
		<div class="form-group">
                    <input type="text" class="form-control input-lg" id ="price" name="price" placeholder="UserName" required="required">
        </div>
		<div class="form-group">
            <input type="text" class="form-control input-lg" id ="price"  name="price" placeholder="Password" required="required">
        </div>
		<div class="form-group">
                <div class="form-group">
            <input type="file" name="file" id="file" required>
          </div>
          <button class="btn btn-lg btn-primary" id="upload-button" type="submit" disabled>Upload image</button>
        </form>

        <br>
        <div class="alert alert-info" id="loading" style="display: none;" role="alert">
          Uploading image...
          <div class="progress">
            <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
            </div>
          </div>
        </div>
        <div id="message"></div>
      </div>
        </div>  
        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block ">Add Product</button>
        </div>
    </form> 
   </div>

   <!-- edit modal   -->

<div class="signup-form">
    <form name="editProduct" id="editProduct" action="${pageContext.request.contextPath}/do?MOD=BOK&ACT=doAddProduct" method="post">
		<h2>Create an Account</h2>
        <div class="form-group">
        	<input name ="productname" id ="productname" type="text" class="form-control input-lg"  placeholder="Full Names" required="required">
        </div>
		<div class="form-group">
                    <input type="text" class="form-control input-lg" id ="price" name="price" placeholder="UserName" required="required">
        </div>
		<div class="form-group">
            <input type="text" class="form-control input-lg" id ="price"  name="price" placeholder="Password" required="required">
        </div>
		<div class="form-group">
                <div class="form-group">
            <input type="file" name="file" id="file" required>
          </div>
          <button class="btn btn-lg btn-primary" id="upload-button" type="submit" disabled>Upload image</button>
        </form>

        <br>
        <div class="alert alert-info" id="loading" style="display: none;" role="alert">
          Uploading image...
          <div class="progress">
            <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
            </div>
          </div>
        </div>
        <div id="message"></div>
      </div>
        </div>  
        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block ">Add Product</button>
        </div>
    </form> 
   </div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
  	<script type="text/javascript" src="//cdn.jsdelivr.net/jquery.slick/1.6.0/slick.min.js"></script>
	<script src="assets/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
	<script src="main.js"></script>
</body>
</html>