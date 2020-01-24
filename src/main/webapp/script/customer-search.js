let allCustomers = [];

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
    allCustomers = customers;

    document.getElementById('spinner').classList.add('hidden');

    let tableBody = document.getElementById("tableBody");
    for (let i = 0; i < allCustomers.length; i++)
    {
        const customer = allCustomers[i];
        let address = customer.street + ', ' + customer.postalCode + ' ' + customer.city + ', ' + customer.countryKeyIso;
        addTableRow(tableBody, customer.id, customer.name, address);
    }

    document.getElementById('searchResultLegend').innerText = "Search Result (" + allCustomers.length + " rows found)"
}

function addTableRow(tableBody, id, name, address)
{
    let tableRow = document.createElement("tr");
    tableRow.setAttribute("id", id);
    tableRow.appendChild(createTableData("ID", id));
    tableRow.appendChild(createTableData("Name", name));
    tableRow.appendChild(createTableData("Address", address));
    let tr = tableBody.appendChild(tableRow);
    tr.addEventListener("click", function () {
        showEditForm();
        fillEditForm(this.id);
    });
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

function showEditForm()
{
    document.getElementById("searchForm").classList.add("hidden");
    document.getElementById("editForm").classList.remove("hidden");
}
