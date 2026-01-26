import auth

def start():
    status = True
    
    while status == True:
        print("1. Cadastrar")
        print("2. Login")
        print("3. Sair")
        
        op = input("Opção: ")
        
        if op == "1":
            u = input("Usuário: ")
            s = input("Senha: ")
            print(auth.realizar_cadastro(u, s))
            
        elif op == "2":
            u = input("Usuário: ")
            s = input("Senha: ")
            sucesso = auth.realizar_login(u, s)
            
            if sucesso == True:
                print("Login realizado!")
            else:
                print("Usuário ou senha inválidos.")
                
        elif op == "3":
            status = False
            print("Encerrando...")

start()