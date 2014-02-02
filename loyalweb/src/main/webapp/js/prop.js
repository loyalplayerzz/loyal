$(document).ready(function () {

var loc = window.location.protocol;
    /*Store the environment host that the application is in*/
    hostUri = window.location.host;

    /*split the path and store in an array*/
    var pathArray = window.location.pathname.split('/');

    /*Retrieve the URI to be passed and store in a variable*/
    var contextURI = pathArray[1];

    /*Combine all of above and store the URL value in contextRoot*/
    var contextRoot = loc + "//" + hostUri + "/" + contextURI;

    /*Following would be the root URL for DEAMockWeb*/
    restBaseUrl = loc + "//" + hostUri + "/" + "loyalservice/rest";

    });