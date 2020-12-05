# Projeto Prático de EC017 (Redes Neurais) - 2020/2

## Informações
- **Objetivo**: pesquisar e empregar outras técnicas de aprendizado de máquina (diferentes de redes neurais artificiais) em problemas de classificação do mundo real.
- **Grupo**: no máximo 4 integrantes; os nomes dos integrantes devem ser encaminhados para o professor por e-mail ou via Microsoft Teams até 07/12/20 (segunda-feira) às 23h59, impreterivelmente.
- **Entrega**: por e-mail para marcelovca90@inatel.br com o assunto “[EC017] Projeto Prático” (sem aspas) até 02/01/2021 (sábado) às 23h59, impreterivelmente.

## Grupos sugeridos

| Número |                                                              Integrantes                                                             | Conjunto de dados |  Classificador |
|:------:|:------------------------------------------------------------------------------------------------------------------------------------:|:-----------------:|:--------------:|
|    1   |        Amanda de Cássia Mendes Mota <br> Débora Vitória Braga Bacelar   <br> Iago Coutinho Campos <br> Milena Machado Ferreira       |   a ser definido  | a ser definido |
|    2   | Billy Rodrigues Francisco Mafra <br> Brener Oliveira dos Reis   <br> Willer Rodrigo da Silva <br> William Fraga Guimarães   Barreiro |   a ser definido  | a ser definido |
|    3   |                Bruno Pereira Garcia Caputo <br> Danilo Peixoto Ferreira <br>   Heitor Toledo Lassarote de Paula <br>                 |   a ser definido  | a ser definido |
|    4   |    Flávio Brusamolin Brito <br> Leonardo Eufrazio Nogueira <br>   Vinícius Moreira Cardoso <br> Victor Fernandes Mariano Marcelino   |   a ser definido  | a ser definido |
|    5   |               Gustavo Marins Bitencourt <br> João Paulo Martins de Oliveira   <br> Paulo Matheus de Araujo Silva <br>                |   a ser definido  | a ser definido |
|    6   |       Evandro Pijanowski Andrade <br> João Pedro de Souza Pereira Alves   <br> João Batista Paiva <br> Lucas Negrão Reys Sarno       |   a ser definido  | a ser definido |

## Procedimento

1.	Download do Weka: [https://waikato.github.io/weka-wiki/downloading_weka/]().

	Obs.: baixar a "Stable version" (weka-3-8-4-azul-zulu) específica para seu sistema operacional, ou a versão genérica (“other plaftorms”)

2.	Carregar o conjunto de dados (informado pelo professor):

	Explorer > Aba "Preprocess" > Open file... > `"conjunto_de_dados.arff"`

3.	Balancear o conjunto de dados:

	Explorer > Aba "Preprocess" > Filter > Choose > `weka.filters.supervised.instance.ClassBalancer` > Apply

4.	Embaralhar o conjunto de dados:

	Explorer > Aba "Preprocess" > Filter > Choose > `weka.filters.unsupervised.instance.Randomize` > Apply

5.	Escolher o classificador (informado pelo professor):

	Explorer > Aba "Classify" > Classifier > Choose > `"classificador"`

6.	Configurar o classificador:

	Explorer > Aba "Classify" > clicar na caixa de texto ao lado do botão "Choose"

7.	Executar o classificador:

	Explorer > Aba "Classify" > Test options > Cross-validation Folds > `5` > Start

Os resultados serão exibidos na área de texto "Classifier output". Exemplo:

```
=== Stratified cross-validation ===
=== Summary ===

Correctly Classified Instances         117               78      %
Incorrectly Classified Instances        33               22      %
```

Neste caso, o modelo de aprendizado de máquina obteve 78% de acerto na validação cruzada.

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
	  - Favor desconsiderar os seguintes (caso estejam disponíveis): `batchSize`, `debug`, `doNotCheckCapabilities`, `doNotReplaceMissingValues`, `numDecimalPlaces` e `seed`.
  - Executar 10 experimentos (variando o parâmetro escolhido)
	  - Obsservação: a variação do parâmetro deve implicar em variação na taxa de acerto. Caso isso não aconteca com um parâmetro em particular, escolher outro até que tal variação aconteça.
  - Guardar os resultados de cada execução
  - Exibir gráfico "parâmetro versus taxa de acerto"
- Discussão dos resultados
- Conclusão

Sugestão: utilizar o template fornecido pelo professor para confecção da apresentação.

## Conjuntos de dados disponíveis:

|      Nome     |                                          Referência (UCI)                                   |                 Arquivo (ARFF)          |
|:-------------:|:-------------------------------------------------------------------------------------------:|:---------------------------------------:|
| breast-cancer |                [link](https://archive.ics.uci.edu/ml/datasets/Breast+Cancer)                | [link](datasets/breast-cancer.arff.zip) |
|    credit-g   |         [link](https://archive.ics.uci.edu/ml/datasets/statlog+(german+credit+data))        |    [link](datasets/credit-g.arff.zip)   |
|     glass     |             [link](https://archive.ics.uci.edu/ml/datasets/Glass+Identification)            |     [link](datasets/glass.arff.zip)     |
|   hepatitis   |                  [link](https://archive.ics.uci.edu/ml/datasets/Hepatitis)                  |   [link](datasets/hepatitis.arff.zip)   |
|     labor     |               [link](https://archive.ics.uci.edu/ml/datasets/Labor+Relations)               |     [link](datasets/labor.arff.zip)     |
|    mushroom   |                   [link](https://archive.ics.uci.edu/ml/datasets/Mushroom)                  |    [link](datasets/mushroom.arff.zip)   |
|     sonar     | [link](http://archive.ics.uci.edu/ml/datasets/connectionist+bench+(sonar,+mines+vs.+rocks)) |     [link](datasets/sonar.arff.zip)     |
|    soybean    |               [link](https://archive.ics.uci.edu/ml/datasets/Soybean+(Large))               |    [link](datasets/soybean.arff.zip)    |
|    vehicle    |        [link](https://archive.ics.uci.edu/ml/datasets/Statlog+(Vehicle+Silhouettes))        |    [link](datasets/vehicle.arff.zip)    |
|      zoo      |                     [link](https://archive.ics.uci.edu/ml/datasets/Zoo)                     |      [link](datasets/zoo.arff.zip)      |

## Classificadores disponíveis:

|      Nome       |                                     Documentação (WEKA)                                     |              Artigo (PDF)              |
|:---------------:|:-------------------------------------------------------------------------------------------:|:--------------------------------------:|
|  DecisionTable  |  [link](http://weka.sourceforge.net/doc.stable/weka/classifiers/rules/DecisionTable.html)   |  [link](classifiers/DecisionTable.pdf) |
|      DTNB       |   [link](https://weka.sourceforge.io/doc.packages/DTNB/weka/classifiers/rules/DTNB.html)    |      [link](classifiers/DTNB.pdf)      |
|       IBk       |         [link](https://weka.sourceforge.io/doc.dev/weka/classifiers/lazy/IBk.html)          |       [link](classifiers/IBk.pdf)      |
|      KStar      |        [link](http://weka.sourceforge.net/doc.dev/weka/classifiers/lazy/KStar.html)         |      [link](classifiers/KStar.pdf)     |
|     LibSVM      |    [link](https://weka.sourceforge.io/doc.stable/weka/classifiers/functions/LibSVM.html)    |     [link](classifiers/LibSVM.pdf)     |
|      PART       |        [link](https://weka.sourceforge.io/doc.dev/weka/classifiers/rules/PART.html)         |      [link](classifiers/PART.pdf)      |
|   RandomTree    |     [link](https://weka.sourceforge.io/doc.dev/weka/classifiers/trees/RandomTree.html)      |   [link](classifiers/RandomTree.pdf)   |
|     REPTree     |       [link](http://weka.sourceforge.net/doc.dev/weka/classifiers/trees/REPTree.html)       |     [link](classifiers/REPTree.pdf)    |
|       SMO       |       [link](https://weka.sourceforge.io/doc.dev/weka/classifiers/functions/SMO.html)       |       [link](classifiers/SMO.pdf)      |
| SimpleLogistic  | [link](http://weka.sourceforge.net/doc.dev/weka/classifiers/functions/SimpleLogistic.html)  | [link](classifiers/SimpleLogistic.pdf) |