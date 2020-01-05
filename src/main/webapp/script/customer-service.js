function findCustomers(searchNamePattern)
{
    var request = new XMLHttpRequest();
    request.onload = function () {
        if (request.readyState !== 4 || request.status !== 200)
        {
            alert('Error when calling server: HTTP status ' + request.status + ' (' + request.statusText + ')\n\n'
                    + 'URL: ' + request.responseURL);
            showCustomers(JSON.parse('[]'))
        }
        let customers = JSON.parse(request.response);
        console.log('customers', customers);
        showCustomers(customers)
    };
    request.open("GET", location.pathname + "api/customer/search?pattern=" + searchNamePattern + "&max=10", true);
    request.send();
}