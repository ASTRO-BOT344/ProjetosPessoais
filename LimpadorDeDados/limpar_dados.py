import pandas as pd

def limpar_dados(arquivo_entrada, arquivo_saida):
    df = pd.read_excel(arquivo_entrada)
    df = df.dropna(how='all')
  
    if 'Nome' in df.columns:
        df['Nome'] = df['Nome'].str.upper().str.strip()
    
    df.to_excel(arquivo_saida, index=False)
    print(f"Dados limpos com sucesso! Salvo em: {arquivo_saida}")
