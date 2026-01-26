import storage

def realizar_cadastro(nome, senha):
    usuarios = storage.buscar_dados()
    
    ja_existe = nome in usuarios
    if ja_existe == True:
        return "Erro: Usuário já cadastrado."
    
    usuarios[nome] = senha
    storage.salvar_dados(usuarios)
    return "Cadastro realizado com sucesso!"

def realizar_login(nome, senha):
    usuarios = storage.buscar_dados()
    
    ja_existe = nome in usuarios
    if ja_existe == True:
        senha_correta = usuarios[nome] == senha
        if senha_correta == True:
            return True
            
    return False