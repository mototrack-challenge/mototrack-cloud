# Variáveis
RESOURCE_GROUP="mototrack-rg"
VM_NAME="mototrack-vm"
LOCATION="brazilsouth"
USERNAME="admmototrack"
PASSWORD="FIAP@2tdspy#"

# Criar grupo de recursos
az group create --name $RESOURCE_GROUP --location $LOCATION

# Criar VM com imagem Ubuntu LTS
az vm create --resource-group $RESOURCE_GROUP --name $VM_NAME --image Ubuntu2204 --size Standard_B2s --admin-username $USERNAME --admin-password "$PASSWORD" --authentication-type password

# Abrir a porta 8080
az vm open-port --port 8080 --resource-group $RESOURCE_GROUP --name $VM_NAME