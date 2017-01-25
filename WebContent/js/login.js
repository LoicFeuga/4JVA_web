function goSignup(){
	//$("#form_signup").animate({"margin-left":"-1000px"},1000);

	$("#form_signup").html("");
	addDataToForm("go_signup","#form_signup");
	
	//setTimeout(function(){
		
		$("#form_signup").submit();
	//},1000);
}

$("#goSignup").click(function(e){
	$("#form_signup").attr('method',"GET");
	$("#action").val("go_signup");
	$("#form_signup").submit();
});
function login(){
	
	addDataToForm("login","#form_signup");
		
	//$("#form_signup").submit();
	
	//var login = document.querySelector("#login").value;
	//var mdp = document.querySelector("#mdp").value; 

//	$.soap({
//	    url: REST+'UserServiceService/UserService/',
//	    method: 'login',
//
//	    data: {
//	        log: 'Remy Blom',
//	        mdp: 'Hi!'
//	    },
//
//	    success: function (e) {
//	        // do stuff with soapResponse
//	        // if you want to have the response as JSON use soapResponse.toJSON();
//	        // or soapResponse.toString() to get XML string
//	        // or soapResponse.toXML() to get XML DOM
//	    	console.log(e);
//	    	console.log(e.toString());
//	    	console.log(e.toXML());
//	    },
//	    error: function (SOAPResponse) {
//	    	console.log(SOAPResponse);
//	    }
//	});
//	
//	 var pl = new SOAPClientParameters();
//	 pl.add("log", login);
//	 pl.add("mdp", mdp);
//	 
//	 SOAPClient.invoke(REST+'UserServiceService/UserService', "login", pl, true, function(e){
//		 console.log(e);
//	 });
	
	
//return false;
	
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

		
