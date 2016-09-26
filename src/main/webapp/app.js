function callAjax(url, callback) {
	var stdout = document.querySelector('#stdout');
	var xhr;
	// compatible with IE7+, Firefox, Chrome, Opera, Safari
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			callback(xhr.responseText);
		}
		else {
			console.debug("xhr.readyState = ", xhr.readyState);
			stdout.innerHTML = xhr.responseText;
		}
	}
	xhr.open("GET", url, true);
	xhr.send();
}



function test (){
	alert ("coucoqsdfqsdfqsdfcu it works");
}