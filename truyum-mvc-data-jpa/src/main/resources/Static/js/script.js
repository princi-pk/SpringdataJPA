function validate(){
		var jname=document.getElementById("title").value;
		var jprice=document.getElementById("price").value;
		var jdateoflaunch=document.getElementById("datepicker").value;
		var jcategory=document.getElementById("category");
		if(jname==="" || jname.length==0){
			alert("Item Name is required");
			return false;
		}
		if(name.length > 200){
			alert("Item Name cannot exceed 200 characters.");
			return false;
		}
		if(jprice===""){
			alert("Price is required");
			return false;
		}
		if(!(jprice.match(/^[0-9]+$/))){
			alert("Price has to be a number");
			return false;
		}
		if(jdateoflaunch===""){
			alert("Date of launch is required");
			return false;
		}
		if(jcategory.value==""|| jcategory==null){
			alert("Select one category");
			return false;
		}
}