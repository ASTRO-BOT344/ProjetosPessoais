import json

def garantir_arquivo():
   
    arquivo = open("usuarios.json", "a")
    arquivo.close()

def buscar_dados():
    garantir_arquivo()
    arquivo = open("usuarios.json", "r")
    conteudo = arquivo.read()
    
    arquivo_vazio = conteudo == ""
    if arquivo_vazio == True:
        arquivo.close()
        return {}
    
    dados = json.loads(conteudo)
    arquivo.close()
    return dados

def salvar_dados(dicionario):
    arquivo = open("usuarios.json", "w")
    texto_json = json.dumps(dicionario, indent=4)
    arquivo.write(texto_json)
    arquivo.close()