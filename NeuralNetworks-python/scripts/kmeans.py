import numpy as np

from blueprint import datasets, estimators, plot_utils


if __name__ == '__main__':
  # set random number generator seed
  np.random.seed(0)

  # set floating point formatting when printing
  np.set_printoptions(formatter = {'float': '{:.5f}'.format})

  # load data
  dataset = datasets.tsne_2d

  x = dataset.input
  d = dataset.output

  # define the estimator parameters
  k = 4
  iterations = 1e3
  eps = 1e-6

  # create the estimator
  estimator = estimators.KMeans(k, iterations, eps)

  # train the estimator
  c = estimator.train(x)

  # evaluate the estimator
  accuracy = estimator.evaluate(x, d, c)

  # plot clusters
  y = estimator.predict(x, c)
  plot_utils.scatter(x[:, 0], x[:, 1], x_label = 'tsne-1', y_label = 'tsne-2', colors = y)
