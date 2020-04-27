<%@ include file="common/header.jsp"%>
<style>
<!--
/* .table-striped thead {
  width: 97%;
}

.table-striped tbody {
  height: 230px;
  overflow-y: auto;
  width: 100%;
} */

/* .table-striped thead, .table-striped tbody, .table-striped tr, .table-striped td, .table-striped th {
  display: block;
}
.table-striped tbody td, .table-striped thead > tr> th {
  float: left;
  border-bottom-width: 0;
}
 */

.my-custom-scrollbar {
position: relative;
height: 800px;
overflow: auto;
}
.table-wrapper-scroll-y {
display: block;
}
-->
</style>


<div class="container">
<br>
<h5>Stock Details <a href="" id="addStock"
						 data-toggle="modal"
						data-target="#addStockPopup"><span class="fa fa-plus" aria-hidden="true" style="color: #80d4ff;"></span></a> 
						</h5>
<div class="table-wrapper-scroll-y my-custom-scrollbar">
		<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Item Id</th>
				<th scope="col">Item Name</th>
				<th scope="col">Available Stk</th>
				<th scope="col">Consumed Stk</th>
				<th scope="col">Added On</th>
				<th scope="col">Update On</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<tr>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		</tr>
		<tr>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		</tr>
		<tr>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		</tr>
		<tr>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		</tr>
		<tr>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		</tr>
		<tr>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		</tr>
		<tr>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		</tr>
		<tr>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		</tr>
			<%-- <c:forEach var="items" items="${itemList}">
				<tr>
					<th scope="row">${items.srNo}</th>
					
					<td>${items.itmId}</td>
					<td>${items.itmDesc}</td>
					<td>${items.catName}<input type="hidden"
						value="${items.itmCatId}" />
					</td>
					
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
			</c:forEach> --%>

		</tbody>
	</table>
	</div>
</div>

<div class="modal fade" id="addStockPopup" tabindex="-1" role="dialog"
	aria-labelledby="addStockModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="addStockModalLabel">Update Order
					Details</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<form method="POST" action="" id="">
				<div class="modal-body">
					<div class="form-group">
						<label for="itemName">Item Name</label> <input type="text"
							class="form-control" id="itemName"
							aria-describedby="itemNameHelp" placeholder="Item Description"
							name="itmDesc" autocomplete="off"> <small
							id="itemNameErr"></small>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>

					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</form>
		</div>
	</div>
</div>
<%@ include file="common/footer.jsp"%>