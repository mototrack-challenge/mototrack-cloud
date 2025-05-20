# Variáveis
RESOURCE_GROUP="mototrack-rg"
VM_NAME="mototrack-vm"
USERNAME="admmototrack"

# Obter o IP público da VM
VM_IP=$(az vm show --resource-group $RESOURCE_GROUP --name $VM_NAME --show-details --query publicIps -o tsv)

# Acessar a VM e instalar Docker e Git
ssh $USERNAME@$VM_IP << 'EOF'
  # Atualizar pacotes
  sudo apt update -y

  # Instalar dependências
  sudo apt install -y apt-transport-https ca-certificates curl software-properties-common git

  # Adicionar repositório do Docker
  curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg
  echo \
    "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu \
    $(lsb_release -cs) stable" | \
    sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

  # Instalar Docker
  sudo apt update -y
  sudo apt install -y docker-ce docker-ce-cli containerd.io

  # Permitir usar docker sem sudo (opcional)
  sudo usermod -aG docker $USER

  # Verificar versões instaladas
  docker --version
  git --version
EOF
