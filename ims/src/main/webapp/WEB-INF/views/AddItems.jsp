<%@ include file="common/header.jsp"%>

<div class="container">
	<!-- ------------ body --------------- -->

	<br />
	<c:url var="addItems" value="addItems"></c:url>
	<c:url var="editItems" value="editItems"></c:url>
	<div class="col-sm-6">
		<div class="alert alert-primary" role="alert">Add Item Details</div>
		<c:if test="${not empty success}">
			<div class="alert alert-success alert-dismissible fade show">
				<strong>Success!</strong> Item has been added successfully.
				<button type="button" class="close" data-dismiss="alert">&times;</button>
			</div>
		</c:if>
		<%-- <div class="alert alert-success alert-dismissible fade show">
    <strong>${msg}</strong> Item has been added successfully.
    <button type="button" class="close" data-dismiss="alert">&times;</button>
</div> --%>

		<form method="POST" action="${addItems}">
			<div class="form-group">
				<label for="itemId">Item Id</label> <input type="text"
					class="form-control" id="itemId" aria-describedby="itmIdHelp"
					placeholder="Item id" name="itmId" autocomplete="off"> <small
					id="itemIdErr"></small>
			</div>
			<div class="form-group">
				<label for="itemName">Item Name</label> <input type="text"
					class="form-control" id="itemName" aria-describedby="itemNameHelp"
					placeholder="Item Description" name="itmDesc" autocomplete="off">
				<small id="itemNameErr"></small>
			</div>
			<div class="form-group">
				<label for="itemCategory">Item Category</label> <select
					class="form-control" id="itemCategory" name="itmCatId" required>
					<option value="0" selected="selected">--select--</option>
					<c:forEach var="cat" items="${cateList}">
						<option value="${cat.catId}">${cat.catName}</option>
					</c:forEach>
				</select> <small id="catErr"></small>
			</div>
			<div class="form-check">
				<input type="checkbox" class="	form-check-input" id="activeCheck"
					name="itmActv"> <label class="form-check-label"
					for="activeCheck">Active</label>
			</div>
			<button type="submit" id="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<br />
	<div class="alert alert-primary" role="alert">Here are the Item
		details...</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Item Id</th>
				<th scope="col">Item Name</th>
				<th scope="col">Category</th>
				<th scope="col">Active</th>
				<th scope="col">Create Date</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty itemList}">
				<tr>
					<td></td>
					<td>No records found!</td>
				</tr>
			</c:if>
			<c:forEach var="items" items="${itemList}">
				<tr>
					<th scope="row">${items.srNo}</th>
					<%--  --%>
					<td>${items.itmId}</td>
					<td>${items.itmDesc}</td>
					<td>${items.catName}<input type="hidden"
						value="${items.itmCatId}" />
					</td>
					<%--  --%>
					<td>${items.itmActv}</td>
					<td>${items.itmCreatedDt}</td>
					<td><a href="./find/${items.itmId}" id="editLink"
						class="btn btn-outline-primary btn-xs" data-toggle="modal"
						data-target="#editPopup">Edit</a> 
						<input type="hidden" id="Id" value="${items.itmId}" />
						<input type="hidden" id="catId" value="${items.itmCatId}" /> 
						<input type="hidden" id="itmNm" value="${items.itmDesc}" /> 
						<input type="hidden" id="chk" value="${items.itmActv}" /> 
						<a type="button" href="./remove/${items.itmId}" class="btn btn-outline-danger btn-xs">Delete</a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<div class="row">
		<div class="col-sm-5">
			<div class="dataTables_info" id="example_info" role="status"
				aria-live="polite">Showing 1 to 5 of ${totalCount} entries</div>
		</div>
		<div class="col-sm-7">
			<div class="dataTables_paginate paging_simple_numbers"
				id="example_paginate">
				<ul class="pagination">
					<li class="paginate_button previous disabled" id="example_previous">
						<a href="#" aria-controls="example" data-dt-idx="0" tabindex="0">Previous</a>
					</li>
					<c:forEach begin="1" end="${totalCount%5 == 0?(totalCount/5):(totalCount/5)+1}" varStatus="i">
						<li class="paginate_button active"><a href="./next/${i.index}"
							aria-controls="example" data-dt-idx="1" tabindex="0">${i.index}</a>
						</li>
					</c:forEach>
					<li class="paginate_button next" id="example_next"><a href="#"
						aria-controls="example" data-dt-idx="7" tabindex="0">Next</a></li>
				</ul>
			</div>
		</div>
	</div>

</div>
<!-- Modal -->
<div class="modal fade" id="editPopup" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Edit Item
					Details</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<form method="POST" action="" id="editform">
				<div class="modal-body">
					<div class="form-group">
						<label for="itemId">Item Id</label> <input type="text"
							class="form-control" id="itemId" aria-describedby="itmIdHelp"
							disabled="disabled" placeholder="Item id" name="itmId"
							autocomplete="off"> <small id="itemIdErr"></small>
					</div>
					<div class="form-group">
						<label for="itemName">Item Name</label> <input type="text"
							class="form-control" id="itemName"
							aria-describedby="itemNameHelp" placeholder="Item Description"
							name="itmDesc" autocomplete="off"> <small
							id="itemNameErr"></small>
					</div>
					<div class="form-group">
						<label for="itemCategory">Item Category</label> <select
							class="form-control" id="itemCategory" name="itmCatId" required>
							<option value="0" selected="selected">--select--</option>
							<c:forEach var="cat" items="${cateList}">
								<option value="${cat.catId}">${cat.catName}</option>
							</c:forEach>
						</select> <small id="catErr"></small>
					</div>
					<div class="form-check">
						<input type="checkbox" class="	form-check-input" id="activeCheck"
							name="itmActv"> <label class="form-check-label"
							for="activeCheck">Active</label>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>

					<button type="submit" class="btn btn-primary">Save changes</button>
				</div>
			</form>
		</div>
	</div>
</div>
<c:remove var="success" scope="session" />
<script type="text/javascript">
	$(document).ready(

			function() {
				$('#itemIdErr').hide();
				$('#itemNameErr').hide();
				$('#catErr').hide();

				var itm_err = true;
				var name_Err = true;
				var cat_err = true;

				var cat_value = 0;

				$('#itemId').keyup(function() {
					itemId_check();
				});
				function itemId_check() {
					var itemId_val = $('#itemId').val();
					if (itemId_val.length == '') {
						$('#itemIdErr').show();
						$('#itemIdErr').html("Please enter Item Id.");
						$('#itemIdErr').focus();
						$('#itemIdErr').css("color", "red");

						itm_err = false;
						return false;
					} else {
						$('#itemIdErr').hide();
					}

					if (itemId_val.length < 7) {
						$('#itemIdErr').show();
						$('#itemIdErr').html(
								"Item id must be greater than 6 character.");
						$('#itemIdErr').focus();
						$('#itemIdErr').css("color", "red");

						itm_err = false;
						return false;
					} else {
						$('#itemIdErr').hide();
					}

				}
				$('#itemName').keyup(function() {
					check_Item_Name();
				});
				function check_Item_Name() {
					var itm_name = $('#itemName').val();
					if (itm_name.length == '') {
						$('#itemNameErr').show();
						$('#itemNameErr')
								.html("Please enter Item Description.");
						$('#itemNameErr').focus();
						$('#itemNameErr').css("color", "red");

						name_Err = false;
						return false;
					} else {
						$('#itemNameErr').hide();
					}
				}
				$('#itemCategory').change(function() {
					check_category();
				});

				function check_category() {
					var itm_cat = $("#itemCategory").val();
					cat_value = itm_cat;
					console.log('VAlue ' + itm_cat);
					if (cat_value < 1) {
						$('#catErr').show();
						$('#catErr').html("Please select a category.");
						$('#catErr').focus();
						$('#catErr').css("color", "red");
						cat_err = false;
						return false;
					} else {
						$('#catErr').hide();
					}
				}

				$('#submit').click(
						function() {
							itm_err = true;
							name_Err = true;
							cat_err = true;
							itemId_check();
							check_Item_Name();
							check_category();
							if ((itm_err == true) && (name_Err == true)
									&& (cat_err == true))
								return true;
							else
								return false;
						});

				/* $("#success-alert").fadeTo(2000, 500).slideUp(500, function(){
				    $("#success-alert").slideUp(500);
				}); */

				/*
				edit button
				 */

				$('table #editLink').on(
						'click',
						function() {
							var id = $(this).parent().find('#Id').val();
							var itmNm = $(this).parent().find('#itmNm').val();
							var chk = $(this).parent().find('#chk').val();
							var catId = $(this).parent().find('#catId').val();
							$('#editPopup #itemId').val(id);
							$('#editPopup #itemCategory').val(catId);
							$('#editPopup #itemName').val(itmNm);
							$('#editPopup #activeCheck').prop('checked',
									chk == "Y" ? true : false);
							$("#editform").attr(
									'action',
									'${pageContext.request.contextPath}/editItems/'
											+ id);
							/* $.ajax({
									 contentType: 'application/json',
									/* type : 'GET',
									url  : '${pageContext.request.contextPath}/find/'+id,
								
									 success: function (data) {
								          $.each(data, function(index, currEmp) {
								             console.log(currEmp.name); //to print name of employee
								         });    
								        },
							        error: function(){      
							            alert('Error while request..');
							           }
								}); */
						});

			});
</script>
</body>
</html>