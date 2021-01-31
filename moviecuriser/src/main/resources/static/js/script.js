function validate(){
		var jname=document.getElementById("title").value;
		var jprice=document.getElementById("imdbRating").value;
		var jdateoflaunch=document.getElementById("datepicker").value;
		var jagerating=document.getElementById("ageRating").value;
		if(jname==="" || jname.length==0){
			alert("Movie Name is required");
			return false;
		}
		if(name.length > 200){
			alert("Movie Name cannot exceed 200 characters.");
			return false;
		}
		if(jprice===""){
			alert("IMDb rating is required");
			return false;
		}
		if(!(jprice.match(/^[0-9]+$/))){
			alert("IMDb rating has to be a number");
			return false;
		}
		if(jdateoflaunch===""){
			alert("Date of launch is required");
			return false;
		}
		if(jagerating==="" || jagerating.length==0){
			alert("Age Rating is required");
			return false;
		}
		if(!(jagerating.match(/^[0-9]+$/))){
			alert("Age rating has to be a number");
			return false;
		}
		if(document.form.category.selectedIndex==""){
			alert("Select one category");
			return false;
		}
}