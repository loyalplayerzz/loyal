$(document).ready(function(){ 
	
	var originalFont = parseFloat(ReadCookie('originalFont'));
	if (originalFont == null)
	 {  
       var originalFontSize = $('html').css('font-size');
		SetCookie('originalFont',originalFontSize,30);
    }
    else
	 {  
         var originalFontSize = $('html').css('font-size');
    }
	
	var fontAlreadySet = parseFloat(ReadCookie('newFont'));
	if (fontAlreadySet == null)
	{  }
    else
	 {
        $('html').css('font-size', fontAlreadySet);
   	}
	// reset Font Size
    $(".resetFont").click(function(){ 
		SetCookie('newFont',16,30);
	   	var font = $('html').css('font-size', originalFontSize);
  });
  // Increase Font Size
  $(".increaseFont").click(function(){
	//alert(document.cookie.length);
    var currentFontSize = $('html').css('font-size');
    var currentFontSizeNum = parseFloat(currentFontSize, 20);
   	var newFontSize = currentFontSizeNum*1.2;
	if(newFontSize>20){var newFontSize = currentFontSizeNum;} 
	SetCookie('newFont',newFontSize,30);
    $('html').css('font-size', newFontSize);
    return false;
  });
  // Decrease Font Size
  $(".decreaseFont").click(function(){  
    var currentFontSize = $('html').css('font-size'); 
    var currentFontSizeNum = parseFloat(currentFontSize, 10);
    var newFontSize = currentFontSizeNum*0.8;
	//alert("decrease"+newFontSize);
	if(newFontSize<11){var newFontSize = currentFontSizeNum;} 
	SetCookie('newFont',newFontSize,30);
    $('html').css('font-size', newFontSize);
    return false;
  });
});
function SetCookie(cookieName,cookieValue,nDays) {
 var today = new Date();
 var expire = new Date();
 if (nDays==null || nDays==0) nDays=1;
 expire.setTime(today.getTime() + 3600000*24*nDays);
 document.cookie = cookieName+"="+escape(cookieValue)
                 + ";expires="+expire.toGMTString()+ ";path=/";
}
function ReadCookie(cookieName) { 
 var theCookie=" "+document.cookie;
 var ind=theCookie.indexOf(" "+cookieName+"=");
 if (ind==-1) ind=theCookie.indexOf(";"+cookieName+"=");
 if (ind==-1 || cookieName=="") return "";
 var ind1=theCookie.indexOf(";",ind+1);
 if (ind1==-1) ind1=theCookie.length; 
 return unescape(theCookie.substring(ind+cookieName.length+2,ind1));
}
