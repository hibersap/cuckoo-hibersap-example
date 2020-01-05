function searchCustomers()
{
    let valid = document.getElementById('searchForm').checkValidity();

    if (valid)
    {
        let searchPattern = document.getElementById('searchPattern').value;
        let maxRows = parseInt(document.getElementById('maxRows').value);

        findCustomers(searchPattern, isNaN(maxRows) ? 100 : maxRows);

        let tableBody = document.getElementById("tableBody");
        removeTableRows(tableBody);

        document.getElementById('spinner').classList.remove('hidden');
    }
    else
    {
        alert('The search parameters are not valid')
    }
}

function showCustomers(customers)
{
    document.getElementById('spinner').classList.add('hidden');

    let tableBody = document.getElementById("tableBody");
    for (let i = 0; i < customers.length; i++)
    {
        const customer = customers[i];
        let address = customer.street + ', ' + customer.postalCode + ' ' + customer.city + ', ' + customer.countryKeyIso;
        addTableRow(tableBody, customer.id, customer.name, address);
    }

    document.getElementById('searchResultLegend').innerText = "Search Result (" + customers.length + " rows found)"
}

function addTableRow(tableBody, id, name, address)
{
    let tableRow = document.createElement("tr");
    tableRow.appendChild(createTableData("ID", id));
    tableRow.appendChild(createTableData("Name", name));
    tableRow.appendChild(createTableData("Address", address));
    tableBody.appendChild(tableRow)
}

function createTableData(dataLabel, content)
{
    let td = document.createElement("td");
    td.setAttribute("data-label", dataLabel);
    td.textContent = content;
    return td;
}

function removeTableRows(tableBody)
{
    while (tableBody.firstChild)
    {
        tableBody.firstChild.remove();
    }
}
