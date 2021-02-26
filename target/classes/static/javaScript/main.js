
$(function(){
	$(document).on("click","#addNewAddressBook",function(event) {
		event.preventDefault();
		$.ajax({
			url: "/newAddressBook"
		}).then(function(data) {
			   console.log(data);
			   $("#addressBooksDisplay").append(data);
		});
	});
	$(document).on("click",".displayAddressBookLink",function(event) {
		event.preventDefault();
		console.log();
		$(".allAddressBooks").hide()
		$("#addressBookDisplay").html("");	
		$(".singleAddressBook").show()
		$("#addNewContact").attr("action", "addNewBuddyToAddressBook/" + $(this).attr("name"));
		console.log($("#addNewContact").attr("action"));
		$.ajax({
			url: $(this).attr("href")
		}).then(function(data) {
			   console.log(data);
			   $("#addressBookDisplay").append(data);	
		});	
	});

	$("#addNewContact").submit(function (event){
		event.preventDefault();
		let formData = $('#addNewContact').serialize();
		$.ajax({
			type        : "POST",
			url:  $(this).attr("action"),
			data        : formData, 
            dataType    : 'text',
			encode          : true
		}).then(function(data) {
			   console.log(data);
			   $("#addressBookDisplay").append(data);	
		});	
	});
	$(document).on("click","#back",function(event) {
		event.preventDefault();
		console.log();
		$(".allAddressBooks").show()
		$(".singleAddressBook").hide()
	});
});