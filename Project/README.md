# Projeto Prático de EC017 (Redes Neurais) - 2020/2

## Informações
- **Objetivo**: pesquisar e empregar outras técnicas de aprendizado de máquina (diferentes de redes neurais artificiais) em problemas de classificação do mundo real.
- **Grupo**: no máximo 4 integrantes; em caso de alteração, o professor deverá ser comunicado por e-mail ou via Microsoft Teams até 07/12/20 (segunda-feira) às 23h59, impreterivelmente.
- **Entrega**: por e-mail para marcelovca90@inatel.br com o assunto “[EC017] Projeto Prático” (sem aspas) até 02/01/2021 (sábado) às 23h59, impreterivelmente.

## Grupos

| Número |                                                              Integrantes                                                           |                                                        Conjunto de dados                                                       |                                                                                       Classificador                                                                                      | Entrega |
|:------:|:----------------------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:-------:|
|    1   |        Amanda de Cássia Mendes Mota <br> Débora Vitória Braga Bacelar <br> Iago Coutinho Campos <br> Milena Machado Ferreira       | hepatitis <br> [referência](https://archive.ics.uci.edu/ml/datasets/Hepatitis) <br> [download](datasets/hepatitis.arff.zip)    | SimpleLogistic <br> [documentação do WEKA](http://weka.sourceforge.net/doc.dev/weka/classifiers/functions/SimpleLogistic.html) <br> [artigo relacionado](classifiers/SimpleLogistic.pdf) |    🟢   |
|    2   | Billy Rodrigues Francisco Mafra <br> Brener Oliveira dos Reis <br> Willer Rodrigo da Silva <br> William Fraga Guimarães   Barreiro | zoo <br> [referência](https://archive.ics.uci.edu/ml/datasets/Zoo) <br> [download](datasets/zoo.arff.zip)                      | LibSVM <br>[documentação do WEKA](https://weka.sourceforge.io/doc.stable/weka/classifiers/functions/LibSVM.html) <br> [artigo relacionado](classifiers/LibSVM.pdf)                       |    🟢   |
|    3   |                Bruno Pereira Garcia Caputo <br> Danilo Peixoto Ferreira <br>   Heitor Toledo Lassarote de Paula                    | soybean <br> [referência](https://archive.ics.uci.edu/ml/datasets/Soybean+(Large)) <br> [download](datasets/soybean.arff.zip)  | SMO <br> [documentação do WEKA](https://weka.sourceforge.io/doc.dev/weka/classifiers/functions/SMO.html) <br> [artigo relacionado](classifiers/SMO.pdf)                                  |    🟢   |
|    4   |    Flávio Brusamolin Brito <br> Leonardo Eufrazio Nogueira <br>   Vinícius Moreira Cardoso <br> Victor Fernandes Mariano Marcelino | glass <br> [referência](https://archive.ics.uci.edu/ml/datasets/Glass+Identification) <br> [download](datasets/glass.arff.zip) | REPTree <br> [documentação do WEKA](http://weka.sourceforge.net/doc.dev/weka/classifiers/trees/REPTree.html) <br> [artigo relacionado](classifiers/REPTree.pdf)                          |    🔴   |
|    5   |               Gustavo Marins Bitencourt <br> João Paulo Martins de Oliveira <br> Paulo Matheus de Araujo Silva                     | labor <br> [referência](https://archive.ics.uci.edu/ml/datasets/Labor+Relations) <br> [download](datasets/labor.arff.zip)      | KStar <br> [documentação do WEKA](http://weka.sourceforge.net/doc.dev/weka/classifiers/lazy/KStar.html) <br> [artigo relacionado](classifiers/KStar.pdf)                                 |    🟢   |
|    6   |       Evandro Pijanowski Andrade <br> João Pedro de Souza Pereira Alves <br> João Batista Paiva <br> Lucas Negrão Reys Sarno       | mushroom <br> [referência](https://archive.ics.uci.edu/ml/datasets/Mushroom) <br> [download](datasets/mushroom.arff.zip)       | PART <br> [documentação do WEKA](https://weka.sourceforge.io/doc.dev/weka/classifiers/rules/PART.html) <br> [artigo relacionado](classifiers/PART.pdf)                                   |    🟢   |

## Procedimento

1.	Download do Weka: [https://waikato.github.io/weka-wiki/downloading_weka/](https://waikato.github.io/weka-wiki/downloading_weka/).

	Obs.: baixar a "Stable version" (`weka-3-8-4-azul-zulu`) específica para seu sistema operacional, ou a versão genérica (“other plaftorms”)

2.	Abrir a tela de preprocessamento e execução dos experimentos:

	Weka GUI Chooser > Applications > `Explorer`

3.	Extrair e carregar o conjunto de dados (informado pelo professor):

	Explorer > Aba "Preprocess" > Open file... > `"conjunto_de_dados.arff"`

4.	Balancear o conjunto de dados:

	Explorer > Aba "Preprocess" > Filter > Choose > `weka.filters.supervised.instance.ClassBalancer` > Apply

5.	Embaralhar o conjunto de dados:

	Explorer > Aba "Preprocess" > Filter > Choose > `weka.filters.unsupervised.instance.Randomize` > Apply

6.	Escolher o classificador (informado pelo professor):

	Explorer > Aba "Classify" > Classifier > Choose > `"classificador"`

7.	Configurar o classificador:

	Explorer > Aba "Classify" > clicar na caixa de texto ao lado do botão "Choose"

8.	Executar o classificador:

	Explorer > Aba "Classify" > Test options > Cross-validation Folds > `5` > Start

Os resultados serão exibidos na área de texto "Classifier output". Exemplo:

```
=== Stratified cross-validation ===
=== Summary ===

Correctly Classified Instances         117               78      %
Incorrectly Classified Instances        33               22      %
```

Neste caso, o modelo de aprendizado de máquina obteve 78% de acerto na validação cruzada.

Observação: resultados de execuções passadas podem ser encontrados em "Result list" (parte inferior esquerda da tela).


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
	  - Favor desconsiderar os seguintes (caso estejam disponíveis): `batchSize`, `debug`, `doNotCheckCapabilities`, `doNotReplaceMissingValues`, `numDecimalPlaces` e `seed`.
  - Executar 10 experimentos (variando o parâmetro escolhido)
	  - Observação: a variação do parâmetro deve implicar em variação na taxa de acerto. Caso isso não aconteca com um parâmetro em particular, escolher outro até que tal variação aconteça.
  - Guardar os resultados de cada execução
  - Exibir gráfico "parâmetro versus taxa de acerto"
- Discussão dos resultados
- Conclusão

Sugestão: utilizar o [template](template.pptx) fornecido pelo professor para confecção da apresentação.
