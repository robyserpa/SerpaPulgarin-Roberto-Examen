/**
 * 
 */
function crear(){
	var n= document.getElementById('usu_nombre').value;
	var ce = document.getElementById('usu_cedula').value;
	var co = document.getElementById('usu_cedula').value;
	
	
	var url = "/SerpaPulgarin-Roberto-Examen/crear-usuario?usu_nombre=" + n + "&usu_cedula=" + ce + "&usu_correo=" + co;
	
	location.href = url;
	//$.get(url, function(res){
		//var msg = res.split("&", 2);
		//showNotice(msg[0], msg[1]);
		//jQuery('#father-load').load(`${url} #child-load`);
	//});
}