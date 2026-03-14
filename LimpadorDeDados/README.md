# Data Cleaner - Python & Pandas
Este repositório contém um script em Python desenvolvido para automatizar a limpeza e padronização de planilhas Excel. O objetivo é transformar dados brutos em informações estruturadas e prontas para análise, removendo ruídos e inconsistências comuns.

### 🚀 Funcionalidades

* **Remoção de Linhas Vazias:** Elimina automaticamente registros que não possuem nenhum conteúdo.

* **Padronização de Texto:** Converte todos os nomes na coluna 'Nome' para letras maiúsculas e remove espaços extras no início ou fim do texto.

* **Exportação Otimizada:** Gera um novo arquivo Excel limpo, preservando a integridade do arquivo original.

### 🛠️ Tecnologias Utilizadas
#### Python 3.x

* **Pandas:** Biblioteca poderosa para manipulação e análise de dados.

* **Openpyxl:** Engine necessária para a leitura e escrita de arquivos.xlsx.

### 📋 Pré-requisitos
**Antes de executar o script, você precisará instalar as dependências necessárias:**
```bash
pip install pandas openpyxl
```

### 📂 Como Usar
Clone este repositório ou baixe o arquivo.py.

Certifique-se de ter um arquivo chamado dados.xlsx na mesma pasta do script.

**Execute o script:**
```bash
python seu_script.py
```
O arquivo processado será gerado com o nome dados_limpos.xlsx

### 📝 Exemplo de Código
**O núcleo da lógica utiliza o método .dropna() para limpeza e funções vetorizadas de string do Pandas para a padronização:**

```bash
df = df.dropna(how='all')
if 'Nome' in df.columns:
    df['Nome'] = df['Nome'].str.upper().str.strip()
```
