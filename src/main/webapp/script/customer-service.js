function findCustomers(searchNamePattern, maxRows)
{
    let customers = [];

    let request = new XMLHttpRequest();
    request.ontimeout = function () {
        alert('Timeout when calling server: HTTP status ' + request.status + ' (' + request.statusText + ')\n\n'
                + 'URL: ' + request.responseURL);
        showCustomers(customers);
    };
    request.onload = function () {
        if (request.readyState === 4)
        {
            if (request.status === 200)
            {
                customers = JSON.parse(request.response);
            }
            else
            {
                alert('Error when calling server: HTTP status ' + request.status + ' (' + request.statusText + ')\n\n'
                        + 'URL: ' + request.responseURL);
            }
            showCustomers(customers)
        }
    };
    request.open("GET", location.pathname + "api/customer/search?pattern=" + searchNamePattern + "&max=" + maxRows, true);
    request.setRequestHeader("Accept", "application/json");
    request.timeout = 10000;
    request.send();
}

function updateCustomer(id, customer)
{
    let request = new XMLHttpRequest();
    request.ontimeout = function () {
        alert('Timeout when calling server: HTTP status ' + request.status + ' (' + request.statusText + ')\n\n'
                + 'URL: ' + request.responseURL);
    };
    request.onload = function () {
        if (request.readyState !== 4 || request.status !== 204)
        {
            alert('Error when calling server: HTTP status ' + request.status + ' (' + request.statusText + ')\n\n'
                    + 'URL: ' + request.responseURL);
        }
        else
        {
            alert('Customer saved');
        }
    };
    request.open("PUT", location.pathname + "api/customer/" + id, true);
    request.setRequestHeader("Content-Type", "application/json");
    request.timeout = 10000;
    request.send(JSON.stringify(customer));
}