document.addEventListener("DOMContentLoaded", function() {
	//Varaibles
    const button = document.getElementById("btn-crear-cuenta");
    
    button.addEventListener("click", function(e) {
	    e.preventDefault();
        if (validarPass()) {
            document.forms["form-registro"].submit();
        }
    });
    
    function validarPass() {
    	//Variables
        const password = document.getElementById("password").value;
        const key = document.getElementById("key").value;
        
        if (password !== key) {
            alert("Las contraseñas no coinciden.");
            return false;
        }
        return true;
    }
});