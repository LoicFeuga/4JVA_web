
function login(){
	
	addDataToForm("login","#form_signup");
		
	//$("#form_signup").submit();
	
	var login = document.querySelector("#login").value;
	var mdp = document.querySelector("#mdp").value; 
	

	$.post(REST+"users/login",
		{
			login : login ,
			mdp : mdp,
		},function(e){
			console.log('result:'+ e);
		});

	
	return false;
	
}

/**
 * Permet d'ajouter des valeurs pour la Servlet 
 * @param val la valeur de action
 * @param idForm l'id du formulaire ex: #form_signup
 * @returns
 */
function addDataToForm(val,idForm){
	var input = $("<input>")
    .attr("type", "hidden")
    .attr("name", "action").val(val);

	$(idForm).append($(input));
}

		
