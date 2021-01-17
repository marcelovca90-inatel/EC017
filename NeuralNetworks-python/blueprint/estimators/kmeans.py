import numpy as np

from . import utils
from .estimator import Estimator


# https://github.com/Yangyangii/MachineLearningTutorial/blob/master/Numpy/RBF-Network-with-Kmeans-clustering.ipynb
# https://jakevdp.github.io/PythonDataScienceHandbook/05.11-k-means.html
class KMeans(Estimator):
  def __init__(self, k, maximum_iterations, epsilon):
    self.k = k
    self.maximum_iterations = maximum_iterations
    self.epsilon = epsilon

  def train(self, x):
    c = utils.kmeans_plus_plus(x, self.k)
    dist = np.zeros([self.k, x.shape[0]])
    eps2 = self.epsilon * self.epsilon
    it = 0

    while it < self.maximum_iterations:
      for i, centroid in enumerate(c):
        dist[i] = np.sum(np.square(np.subtract(np.broadcast_to(centroid, x.shape), x)), axis = 1)

      y = np.argmin(dist, axis = 0)

      prev_c = c
      c = np.array([np.mean(x[y == i], axis = 0) for i in range(self.k)])

      if np.all(np.square(c - prev_c) < eps2):
        break

      it += 1

    return c

  def predict(self, x, c):
    dist = np.zeros([self.k, x.shape[0]])

    for i, centroid in enumerate(c):
      dist[i] = np.sum(np.square(np.subtract(np.broadcast_to(centroid, x.shape), x)), axis = 1)

    y = np.argmin(dist, axis = 0)

    return y

  def evaluate(self, x, d, c):
    y = self.predict(x, c)

    accuracy = utils.rand_index_score(y, d)

    print(f'Accuracy: {accuracy * 100:.5f}% ({accuracy:.5f})')

    return accuracy
