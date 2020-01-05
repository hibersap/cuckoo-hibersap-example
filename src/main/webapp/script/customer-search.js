function searchCustomers()
{
    let searchPattern = document.getElementById('searchPattern').value;
    findCustomers(searchPattern);

    let tableBody = document.getElementById("tableBody");
    removeTableRows(tableBody);

    document.getElementById('spinner').classList.remove('hidden');
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
