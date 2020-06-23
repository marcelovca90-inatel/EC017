# Projeto Prático de EC017 (Redes Neurais)

## Informações
- **Objetivo**: pesquisar e empregar outras técnicas de aprendizado de máquina (diferentes de redes neurais artificiais) em problemas de classificação do mundo real.
- **Grupo**: no máximo 4 integrantes; os nomes dos integrantes devem ser encaminhados para o professor até definições até 22/06/20 (segunda-feira) às 23h59, impreterivelmente.
- **Entrega**: por e-mail para marcelovca90@inatel.br com o assunto “[EC017] Projeto Prático” (sem aspas) até 01/07/2020 (quarta-feira) às 23h59, impreterivelmente.

## Procedimento

1.	Download do Weka: https://waikato.github.io/weka-wiki/downloading_weka/.

	Obs.: baixar a "Stable version" (weka-3-8-4) específica para seu sistema operacional, ou a versão genérica (“other plaftorms”)

2.	Carregar o conjunto de dados (informado pelo professor):

	Explorer > Aba "Preprocess" > Open file... > data_set.arff

3.	Balancear o conjunto de dados:

	Explorer > Aba "Preprocess" > Filter > Choose > weka.filters.supervised.instance.ClassBalancer > Apply

4.	Embaralhar o conjunto de dados:

	Explorer > Aba "Preprocess" > Filter > Choose > weka.filters.unsupervised.instance.Randomize > Apply

5.	Escolher o classificador (informado pelo professor):

	Explorer > Aba "Classify" > Classifier > Choose > "classificador"

6.	Configurar o classificador:

	Explorer > Aba "Classify" > clicar na caixa de texto ao lado do botão "Choose"

7.	Executar o classificador:

	Explorer > Aba "Classify" > Test options > Percentage split % > 50 > Start

Os resultados serão exibidos na área de texto "Classifier output". Exemplo:

```
Correctly Classified Instances          37               74      %
Incorrectly Classified Instances        13               26      %
```

Neste caso, o modelo de aprendizado de máquina obteve 74% de acerto no conjunto de testes.

Obs.: resultados de execuções passadas podem ser encontrados em "Result list" (parte inferior esquerda da tela).


## Apresentação

A apresentação a ser entregue deve contemplar os seguintes tópicos:

- Breve revisão sobre o conjunto de dados
  - Descrição do conjunto (do que se trata)
  - Quantidade de instâncias (amostras)
  - Quantidade e descrição dos atributos
- Breve revisão sobre o modelo
  - Princípio de funcionamento
  - Significado dos parâmetros de configuração
- Simulação
  - Definir um parâmetro do classificador para ser configurado
  - Executar 10 experimentos (variando o parâmetro escolhido). Obs.: a variação do parâmetro deve implicar em variação na taxa de acerto. Caso isso não aconteca com um parâmetro em particular, escolher outro até que tal variação aconteça.
  - Guardar os resultados de cada execução
  - Exibir gráfico "parâmetro versus taxa de acerto"
- Discussão dos resultados
- Conclusão

Sugestão: utilizar o template fornecido pelo professor para confecção da apresentação.
