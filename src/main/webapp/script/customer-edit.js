
function saveCustomer()
{
    let customerId = document.getElementById("editId").value;
    console.log("customerId", customerId);
    let customer = {};
    customer.formOfAddress = getInputField("editFormOfAddress");
    customer.name = getInputField("editName");
    customer.street = getInputField("editStreet");
    customer.poBox = getInputField("editPOBox");
    customer.postalCode = getInputField("editPostalCode");
    customer.city = getInputField("editCity");
    customer.countryKeyIso = getInputField("editCountryKeyIso");
    customer.region = getInputField("editRegion");
    customer.phoneNumber = getInputField("editPhoneNumber");
    customer.email = getInputField("editEmail");
    console.log("customer", customer);
    updateCustomer(customerId, customer);
}

function fillEditForm(customerId)
{
    let customer = getCustomer(customerId);
    if (customer != null)
    {
        setInputField("editId", customer.id);
        setInputField("editFormOfAddress", customer.formOfAddress);
        setInputField("editName", customer.name);
        setInputField("editStreet", customer.street);
        setInputField("editPOBox", customer.poBox);
        setInputField("editPostalCode", customer.postalCode);
        setInputField("editCity", customer.city);
        setInputField("editCountryKeyIso", customer.countryKeyIso);
        setInputField("editRegion", customer.region);
        setInputField("editPhoneNumber", customer.phoneNumber);
        setInputField("editEmail", customer.email);
    }
}

function getCustomer(id)
{
    for (let i = 0; i < allCustomers.length; i++)
    {
        const customer = allCustomers[i];
        if (customer.id === id)
        {
            return customer;
        }
    }
    return null;
}

function setInputField(fieldId, content)
{
    document.getElementById(fieldId).value = content;
}

function getInputField(fieldId)
{
    return document.getElementById(fieldId).value;
}

function backToSearchForm()
{
    showSearchForm();
    searchCustomers();
}

function showSearchForm()
{
    document.getElementById("searchForm").classList.remove("hidden");
    document.getElementById("editForm").classList.add("hidden");
}

