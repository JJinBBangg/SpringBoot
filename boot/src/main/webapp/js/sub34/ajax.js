$("#button1").click(function(){
  $.ajax("/sub34/link1")
    .then(() => {
      $("#h1").text("");
      $("#h2").text("");
      $("#h3").text("");
      $("#h4").text("");
      $("#h5").text("");
      $("#h6").text("");
    })
    .catch((e)=>{
		console.log(e)
	});
});
$("#button2").click(function(){
  $.ajax("/sub34/link2")
    .then((response) => {
      const city = response.city;
      const address = response.address;
      $("#h1").text(city);
      $("#h2").text(address);
    })
    .catch((e)=>{
		console.log(e)
	});
});
$("#button3").click(function(){
	const text1 = $("#text1").val();
  $.ajax(`/sub34/link3?id=${text1}`)
    .then((response) => {
      const supplierName = response.supplierName;
      const contactName = response.contactName;
      const address = response.address;
      const city = response.city;
      const country = response.country;
      const phone = response.phone;
      $("#h1").text(supplierName);
      $("#h2").text(contactName);
      $("#h3").text(address);
      $("#h4").text(city);
      $("#h5").text(country);
      $("#h6").text(phone);
    })
    .catch((e)=>{
		console.log(e)
	});
});

$("#checkBtn").click(()=>{
  const email = $("#email").val();
  const person = {
	  name : "kookjin",
	  age : 33
  }
  const married = $("#isBoolean"). is(":checked");
  
  console.log(email)
	$.ajax({
		  url: "/sub34/link4",
		  method: "POST",
		  data: JSON.stringify([{ email , person, married}, { email: email+"231" , person: person, married}]),
		  contentType: "application/json",
		  dataType: "json",
		  success: function(){
			  console.log('성공')
		  },
		  error: function(){
			  console.log('실패')
		  },
		  complate: function(){
			  console.log('성공이든 실패이든')
		  }
		  }).then((response) => {
	  	alert(response.message);
	}).catch((e)=>{
      	alert(e)
    })
});

$("#button5").click(function(){
  $.ajax("/sub34/link5",{
	  dataType: 'json',
  	}).done((response) => {
		console.log(response)
		console.log(response.detail)
    }).fail((response)=>{
		//console.log(response.responseJSON)
		console.log(response.responseJSON)
	}).always(()=>{
		
	})
});

  
  
  
  
