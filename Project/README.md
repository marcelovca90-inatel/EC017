# Projeto Prático de EC017 (Redes Neurais)

## Informações gerais
- 8 grupos de 3 ou 4 integrantes
- Data de entrega por e-mail: 30/novembro/19 12h00
- Não haverá apresentação do projeto. A correção se baseará nos slides entregues.

## Conjuntos de dados disponíveis

- [datasets/breast-cancer.arff](https://archive.ics.uci.edu/ml/datasets/Breast+Cancer)
- [datasets/colic.arff](https://archive.ics.uci.edu/ml/datasets/Horse+Colic)
- [datasets/credit-g.arff](https://archive.ics.uci.edu/ml/datasets/statlog+(german+credit+data))
- [datasets/heart-statlog.arff](http://archive.ics.uci.edu/ml/datasets/statlog+(heart))
- [datasets/hepatitis.arff](https://archive.ics.uci.edu/ml/datasets/Hepatitis)
- [datasets/labor.arff](https://archive.ics.uci.edu/ml/datasets/Labor+Relations)
- [datasets/sonar.arff](http://archive.ics.uci.edu/ml/datasets/connectionist+bench+(sonar,+mines+vs.+rocks))
- [datasets/vote.arff](https://archive.ics.uci.edu/ml/datasets/congressional+voting+records)

## Classificadores disponíveis
- [weka.classifiers.bayes.BayesNet](http://weka.sourceforge.net/doc.dev/weka/classifiers/bayes/BayesNet.html)
- [weka.classifiers.functions.SimpleLogistic](http://weka.sourceforge.net/doc.dev/weka/classifiers/functions/SimpleLogistic.html)
- [weka.classifiers.functions.VotedPerceptron](http://weka.sourceforge.net/doc.dev/weka/classifiers/functions/VotedPerceptron.html)
- [weka.classifiers.lazy.IBk](http://weka.sourceforge.net/doc.dev/weka/classifiers/lazy/IBk.html)
- [weka.classifiers.rules.DecisionTable](http://weka.sourceforge.net/doc.stable/weka/classifiers/rules/DecisionTable.html)
- [weka.classifiers.trees.RandomTree](http://weka.sourceforge.net/doc.dev/weka/classifiers/trees/RandomTree.html)
- [weka.classifiers.trees.REPTree](http://weka.sourceforge.net/doc.dev/weka/classifiers/trees/REPTree.html)
- [weka.classifiers.trees.RandomForest](http://weka.sourceforge.net/doc.dev/weka/classifiers/trees/RandomForest.html)

## Referências

- [references/BayesNet.pdf](https://github.com/marcelovca90/trabalho-ec017/raw/master/references/BayesNet.pdf): FRIEDMAN, Nir; GEIGER, Dan; GOLDSZMIDT, Moises. Bayesian network classifiers. Machine learning, v. 29, n. 2-3, p. 131-163, 1997.
- [references/SimpleLogistic.pdf](https://github.com/marcelovca90/trabalho-ec017/raw/master/references/SimpleLogistic.pdf): SUMNER, Marc; FRANK, Eibe; HALL, Mark. Speeding up logistic model tree induction. In: European Conference on Principles of Data Mining and Knowledge Discovery. Springer, Berlin, Heidelberg, 2005. p. 675-683.
- [references/VotedPerceptron.pdf](https://github.com/marcelovca90/trabalho-ec017/raw/master/references/VotedPerceptron.pdf): FREUND, Yoav; SCHAPIRE, Robert E. Large margin classification using the perceptron algorithm. Machine learning, v. 37, n. 3, p. 277-296, 1999.
- [references/IBk.pdf](https://github.com/marcelovca90/trabalho-ec017/raw/master/references/IBk.pdf): AHA, David W.; KIBLER, Dennis; ALBERT, Marc K. Instance-based learning algorithms. Machine learning, v. 6, n. 1, p. 37-66, 1991.
- [references/DecisionTable.pdf](https://github.com/marcelovca90/trabalho-ec017/raw/master/references/DecisionTable.pdf): KOHAVI, Ron. The power of decision tables. In: European conference on machine learning. Springer, Berlin, Heidelberg, 1995. p. 174-189.
- [references/RandomTree.pdf](https://github.com/marcelovca90/trabalho-ec017/raw/master/references/RandomTree.pdf): LI, Xinwei. Random Decision Trees. 2004.
- [references/REPTree.pdf](https://github.com/marcelovca90/trabalho-ec017/raw/master/references/REPTree.pdf): BRUNK, Clifford A.; PAZZANI, Michael J. An investigation of noise-tolerant relational concept learning algorithms. In: Machine Learning Proceedings 1991. 1991. p. 389-393.
- [references/RandomForest.pdf](https://github.com/marcelovca90/trabalho-ec017/raw/master/references/RandomForest.pdf): BREIMAN, Leo. Random forests. Machine learning, v. 45, n. 1, p. 5-32, 2001.

## Procedimento

1. Clonagem (ou download) deste repositório: [https://github.com/marcelovca90/trabalho-ec017](https://github.com/marcelovca90/trabalho-ec017)

2. Download do Weka: [https://www.cs.waikato.ac.nz/~ml/weka/downloading.html](https://www.cs.waikato.ac.nz/~ml/weka/downloading.html). Observação: baixar a "Stable version" (weka-3-8-3)

3. Carregar o conjunto de dados: Explorer > Aba "Preprocess" > Open file... > data_set.arff

4. Balancear o conjunto de dados: Explorer > Aba "Preprocess" > Filter > Choose > weka.filters.supervised.instance.ClassBalancer > Apply

4. Embaralhar o conjunto de dados: Explorer > Aba "Preprocess" > Filter > Choose > weka.filters.unsupervised.instance.Randomize > Apply

5. Escolher o classificador: Explorer > Aba "Classify" > Classifier > Choose > "classificador"

6. Configurar o classificador: Explorer > Aba "Classify" > clicar na caixa de texto ao lado do botão "Choose"

7. Executar o classificador: Explorer > Aba "Classify" > Test options > Percentage split % > 50 > Start

Os resultados serão exibidos na área de texto "Classifier output". Exemplo:

```
Correctly Classified Instances          37               74      %
Incorrectly Classified Instances        13               26      %
```

Neste caso, o modelo de aprendizado de máquina obteve 74% de acerto no conjunto de testes.

Observação: resultados de execuções passadas podem ser encontrados em "Result list" (sudoeste da tela).

## Apresentação

- Breve revisão sobre o conjunto de dados
  - Descrição do conjunto (do que se trata)
  - Quantidade de instâncias (amostras)
  - Quantidade e descrição dos atributos

- Breve revisão sobre o modelo escolhido
  - Princípio de funcionamento
  - Significado dos parâmetros de configuração

- Simulação
  - Executar 10 experimentos (variando um parâmetro)
     - Se só houver parâmetros booleanos, então fazer a combinação de dois ou mais parâmetros, se possível
     - Se nenhum parâmetro puder ser alterado, então variar o percentual de treinamento/teste
  - Guardar os resultados de cada execução
  - Exibir gráfico "parâmetro versus taxa de acerto"

- Discussão dos resultados

- Conclusão

## Grupos

| Número |                                                             Integrantes                                                             | Conjunto de dados |  Classificador  | Entrega |
|:------:|:-----------------------------------------------------------------------------------------------------------------------------------:|:-----------------:|:---------------:|:-------:|
|    1   | 1131 Douglas Sales Alves Amante<br>1162 Filipe Firmino Lemos<br>1177 Filipe Mazzon Ribeiro<br>1136 Matheus Henrique da Silva                 |        vote       |      REPTree    | ✔️ |
|    2   | 1143 Bruno Balestra de Carvalho Ferreira<br>1172 Ronaldo José Francisco Franco<br>1173 Ruan Patrick de Souza                              |     hepatitis     | VotedPerceptron | ✔️ |
|    3   | 839 Filipe Campos de Lima<br>1267 Lucas Lopes de Souza<br>1194 Matheus de Oliveira e Silva Lourenço Lage<br>1114 Saulo José Moreira          |       colic       |  SimpleLogistic | ✔️ |
|    4   | 1153 Ana Júlia Floriano Monti<br>1164 Ellen Silveira Paradello<br>1147 Felipe Martins Vítor<br>1112 Rafael Magalhães de Barros               |       labor       |     BayesNet    | ✔️ |
|    5   | 1129 Emerson Faria de Oliveira<br>1242 Ensley Fortunato Moreira Ribeiro<br>1126 Jefferson Cleyson Gomes Almeida<br>1176 Wesley Reis da Silva |      credit-g     |      RandomForest      | ✔️ |
|    6   | 1159 Eduardo Augusto de Oliveira Pereira<br>1148 Gustavo Henrique Rosa de Castro<br>1119 Jonathan Donizetti Pereira<br>1170 José Andare Neto |   heart-statlog   |       IBk       | ✔️ |
|    7   | 1200 Alan Frank de Oliveira Andrade<br>1146 Bruno de Lima Oliveira<br>1055 Nícollas Siqueira Corrêa<br>1029 Tulio Fernando Nogueira          |   breast-cancer   |    RandomTree   | ✔️ |
|    8   | 1155 Daniel Campos Souza<br>1132 Giovana Maria Tavares de Souza Bocato<br>1160 Pedro Manoel César Moreira                                 |       sonar       |  DecisionTable  | ✔️ |
